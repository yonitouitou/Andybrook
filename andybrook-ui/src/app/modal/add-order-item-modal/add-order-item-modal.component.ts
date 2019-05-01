import { Component, OnInit, Input } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { OrderService } from 'src/app/service/order-service';
import { AddOrderItemReq } from 'src/app/model/request/AddOrderItemReq';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { ProductService } from 'src/app/service/product-service';
import { Observable, Subject } from 'rxjs';
import { debounceTime, distinctUntilChanged, map } from 'rxjs/operators';
import { ProductStockInfo } from 'src/app/model/ProductStockInfo';

@Component({
  selector: 'add-order-item-modal',
  templateUrl: './add-order-item-modal.component.html',
  styleUrls: ['./add-order-item-modal.component.css']
})
export class AddOrderItemModalComponent implements OnInit {

  @Input() orderId: number

  addOrderItemForm: FormGroup
  productNames: string[] = []
  productIdMapByName: Map<string, number> = new Map()
  inputProductName: string
  productStockInfo: ProductStockInfo
  errorMessage: string
  private _error = new Subject<string>()

  constructor(private formBuilder: FormBuilder,
              private modal: NgbActiveModal,
              private productService: ProductService,
              private orderService: OrderService) {}

  ngOnInit() {
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
    this.addOrderItemForm = this.formBuilder.group({
      productName: [''],
      productId: [''],
      quantity: ['', Validators.min(1)]
    });
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
        this.productStockInfo = null;
      }
    ) 
  }
  onSubmit() {
    let productName = this.addOrderItemForm.get("productName").value;
    let productId = this.productIdMapByName.get(productName);
    const qty = this.addOrderItemForm.get("quantity").value;
    if (this.productStockInfo === null) {
      this.errorMessage = 'Please select a product from the auto-complete list.';
    } else if (! this.isValidQuantity(qty)) {
      this.errorMessage = 'Please choose a quantity between 1 to ' + this.productStockInfo.getFreeQuantity();
    } else {
      let request = new AddOrderItemReq(this.orderId, productId, null, qty);
      this.orderService.addOrderItem(request).subscribe(
        data => {
          console.log(data);
          this.modal.close(true);
        },
        error => {
          this.changeErrorMessage(error.error);
        });
      this.errorMessage = null;
    }
  }

  private changeErrorMessage(errorMessage: string) {
    this._error.next(errorMessage);
  }

  private isValidQuantity(qty: number): boolean {
    return qty > 0 && qty <= this.productStockInfo.getFreeQuantity();
  }
  

  onClose() {
    this.modal.close(false)
  }

}
