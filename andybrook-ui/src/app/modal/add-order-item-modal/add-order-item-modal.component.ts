import { Component, OnInit, Input } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { OrderService } from 'src/app/service/order-service';
import { AddOrderItemReq } from 'src/app/model/request/AddOrderItemReq';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { ProductService } from 'src/app/service/product-service';
import { CookieService } from 'ngx-cookie-service';
import { Observable, Subject } from 'rxjs';
import { debounceTime, distinctUntilChanged, map } from 'rxjs/operators';
import { ProductStockInfo } from 'src/app/model/ProductStockInfo';
import { AddOrderItemByBarCodeReq } from 'src/app/model/request/AddOrderItemByBarCodeReq';
import { TypeUtil } from 'src/app/util/TypeUtil';

@Component({
  selector: 'add-order-item-modal',
  templateUrl: './add-order-item-modal.component.html',
  styleUrls: ['./add-order-item-modal.component.css']
})
export class AddOrderItemModalComponent implements OnInit {

  @Input() orderId: number

  addOrderItemForm: FormGroup
  addOrderItemInProgress: boolean
  isAddButtonDisabled: boolean
  barCodeMode: boolean
  productNames: string[] = []
  productIdMapByName: Map<string, number> = new Map()
  inputProductName: string
  productStockInfo: ProductStockInfo
  errorMessage: string
  private _error = new Subject<string>()

  constructor(private formBuilder: FormBuilder,
              private modal: NgbActiveModal,
              private cookieService: CookieService,
              private productService: ProductService,
              private orderService: OrderService) {}

  ngOnInit() {
    this.initBarCodeMode();
    this.initForm();
    this.getAllCustomers();
    this._error.subscribe((msg) => this.errorMessage = msg)
    this._error.pipe(debounceTime(4000)).subscribe(() => this.errorMessage = null)
  }

  search = (text$: Observable<string>) =>
    text$.pipe(
      debounceTime(200),
      distinctUntilChanged(),
      map(term => term.length < 1 ? []
        : this.productNames.filter(v => v.toLowerCase().indexOf(term.toLowerCase()) > -1).slice(0, 10))
  )

  onProductNameChange() {
    this.onValueChange();
    this.productStockInfo = null;
  }

  onValueChange() {
    this.errorMessage = null;
  }

  initForm() {
    if (this.barCodeMode) {
      this.disableAddButton(false);
    }
    this.addOrderItemForm = this.formBuilder.group({
      barCode: [''],
      productName: [''],
      productId: [''],
      quantity: ['', Validators.min(1)]
    });
  }

  private initBarCodeMode() {
    this.barCodeMode = this.cookieService.check("barCodeMode") ? TypeUtil.toBoolean(this.cookieService.get("barCodeMode")) : true;
  }

  private shouldEnableBarCodeMode(event) {
      this.cookieService.set("barCodeMode", String(event.currentTarget.checked));
  }

  getAllCustomers() {
    this.productService.getAllProductNames().subscribe(
      data => {
        for (let idAndNameProduct of data) {
          this.productIdMapByName.set(idAndNameProduct.second, idAndNameProduct.first)
          this.productNames.push(idAndNameProduct.second);
        }
        console.log(this.productNames);
      }
    )
  }

  onBlurProductName() {
    let productName = this.addOrderItemForm.get("productName").value;
    let productId = this.productIdMapByName.get(productName);
    this.productService.getProductStockInfo(productId).subscribe(
      data => {
        this.productStockInfo = ProductStockInfo.fromJson(data);
      },
      error => {
        this.changeErrorMessage(error.error);
        this.productStockInfo = null;
      }
    ) 
  }

  onBlurBarCode() {
    let barCode = this.addOrderItemForm.get("barCode").value;
    this.productService.getProductStockInfoByBarCode(barCode).subscribe(
      data => {
        this.productStockInfo = ProductStockInfo.fromJson(data);
        this.disableAddButton(false);
      },
      error => {
        this.disableAddButton(true);
        this.changeErrorMessage(error.error);
        this.productStockInfo = null;
      }
    )
  }

  onSubmit() {
    if (this.barCodeMode) {
      this.onSubmitBarCodeMode();
    } else {
      this.onSubmitNoBarCodeMode();
    }
  }
  
  private onSubmitBarCodeMode() {
    let barCode = this.addOrderItemForm.get("barCode").value;
    if (barCode == null || barCode.length == 0) {
      this.changeErrorMessage("Please enter a barcode.")
    } else {
      this.addInProgress(true);
      let request = new AddOrderItemByBarCodeReq(this.orderId, barCode);
      this.orderService.addOrderItemByBarCode(request).subscribe(
        data => {
          console.log(data);
          this.modal.close(true);
        },
        error => {
          this.changeErrorMessage(error.error);
          this.addInProgress(false);
        });
      this.errorMessage = null;
    }
  }

  private onSubmitNoBarCodeMode() {
    let productName = this.addOrderItemForm.get("productName").value;
    let productId = this.productIdMapByName.get(productName);
    const qty = this.addOrderItemForm.get("quantity").value;
    if (this.productStockInfo === null) {
      this.changeErrorMessage('Please select a product from the auto-complete list.');
    } else if (! this.isValidQuantity(qty)) {
      this.changeErrorMessage('Please choose a quantity between 1 to ' + this.productStockInfo.getFreeQuantity());
    } else {
      this.addInProgress(true);
      let request = new AddOrderItemReq(this.orderId, productId, qty);
      this.orderService.addOrderItem(request).subscribe(
        data => {
          console.log(data);
          this.modal.close(true);
        },
        error => {
          this.changeErrorMessage(error.error);
          this.addInProgress(false);
        });
      this.errorMessage = null;
    }
  }

  private addInProgress(isInProgress: boolean) {
    this.addOrderItemInProgress = isInProgress;
  }

  private changeErrorMessage(errorMessage: string) {
    this._error.next(errorMessage);
  }

  private isValidQuantity(qty: number): boolean {
    return qty > 0 && qty <= this.productStockInfo.getFreeQuantity();
  }

  private disableAddButton(disabled: boolean) {
    this.isAddButtonDisabled = disabled;
  }
  

  onClose() {
    this.modal.close(false)
  }

}
