import { Component, OnInit, Input, Output, EventEmitter, PipeTransform } from '@angular/core';
import { StockItem } from '../../model/StockItem'
import { Product } from '../../model/Product';
import { OrderService } from 'src/app/service/order-service';
import { Order } from 'src/app/model/Order';
import { ModalBuilder } from 'src/app/common-components/modal-builder';
import { InfoModalComponent } from 'src/app/modal/info-modal/info-modal.component';
import { ProductService } from 'src/app/service/product-service';
import { Observable } from 'rxjs';
import { debounceTime, distinctUntilChanged, map } from 'rxjs/operators';

@Component({
  selector: 'list-stock-item',
  templateUrl: './list-stock-item.component.html',
  styleUrls: ['./list-stock-item.component.css']
})
export class ListStockItemComponent implements OnInit {

  inputId: number
  inputBarCode: string
  inputName: string
  inputQuantity: number
  inputPrice: number
  selectedRow: number
  isScanMode: boolean
  areNewStockItemFieldsSet = false
  searchString: string
  productNames: string[] = []
  productIdMapByName: Map<string, number> = new Map()
  
  search = (text$: Observable<string>) =>
    text$.pipe(
      debounceTime(200),
      distinctUntilChanged(),
      map(term => term.length < 1 ? []
        : this.productNames.filter(v => v.toLowerCase().indexOf(term.toLowerCase()) > -1).slice(0, 10))
    )

  @Input() stockItems: IterableIterator<StockItem>
  @Input() order: Order

  @Output() onCreateStockItemEvent = new EventEmitter<StockItem>()
  @Output() onChangeStockItemEvent = new EventEmitter<StockItem>()
  @Output() onDeleteStockItemEvent = new EventEmitter<number>()

  constructor(private orderService: OrderService,
              private productService: ProductService,
              private modalBuilder: ModalBuilder) {}

  ngOnInit() {
    this.productService.getAllProductNames().subscribe(
      data => {
        for (let idAndNameProduct of data) {
          this.productIdMapByName.set(idAndNameProduct.second, idAndNameProduct.first)
          this.productNames.push(idAndNameProduct.second);
        }
      }
    )
  }

  onBlurNewItemInput() {
    this.checkInputFieldSet()
  }

  onBlurBarCode() {
    this.productService.getByBarCode(this.inputBarCode.trim()).subscribe(
      data => {
        const product = Product.fromJson(data);
        this.inputId = product.id;
        this.inputName = product.name;
        this.inputQuantity = 1;
        this.createNewStockItem()
      },
      error => {
        const modalRef = this.modalBuilder.open(InfoModalComponent)
        modalRef.componentInstance.title = "Error : Product not added to order " + this.order.name
        modalRef.componentInstance.message = error.error
      }
    )
  }

  onBlurInputName() {
    const id = this.productIdMapByName.get(this.inputName.trim())
    if (id != null) {
      this.productService.get(id).subscribe(
        data => {
          this.inputId = data.id
          this.inputPrice = data.price
          this.inputQuantity = 1
        },
        error => {
          const modalRef = this.modalBuilder.open(InfoModalComponent)
          modalRef.componentInstance.title = "Error : Product " + this.inputName + " not found"
          modalRef.componentInstance.message = error.error
        }
      )
    }
    this.checkInputFieldSet();
  }

  checkInputFieldSet() {
    this.areNewStockItemFieldsSet = this.inputName.trim().length > 0
                                      && this.inputQuantity > 0
                                      && this.inputPrice > 0
  }

  createNewStockItem() {
    var stockItem = new StockItem(undefined, null, this.inputQuantity, new Product(this.inputId, this.inputName, this.inputPrice), null, null)
    this.orderService.addItem(this.order, stockItem).subscribe(
      data => {
          let barCodeId
          if (data.barCode != null) {
            barCodeId = data.item.barCode.id
          }
          let product = new Product(data.product.id, data.product.name, data.product.price)
          stockItem = new StockItem(data.id, barCodeId, data.quantity, product, data.createdDatetime, data.lastModifiedDatetime)
          this.onCreateStockItemEvent.emit(stockItem)
          this.resetNewStockitemFields()
      },
      error => {
        const modalRef = this.modalBuilder.open(InfoModalComponent)
        modalRef.componentInstance.title = "Error : Product item " + stockItem.product.name + " not added to order " + this.order.name
        modalRef.componentInstance.message = error.error
        this.resetNewStockitemFields()
      })
  }

  deleteStockItem(id: number) {
    this.orderService.deleteItem(this.order, id).subscribe(
      data => {
          console.log(data)
          this.onDeleteStockItemEvent.emit(id)
      },
      error => {

      }
    )
  }

  onChangeStockItemQuantity(stockItem: StockItem, event: any) {
    let newQuantity = event.target.textContent
    if (stockItem.quantity != newQuantity) {
      let item = new StockItem(stockItem.id, stockItem.barCode, newQuantity, stockItem.product, stockItem.createdDatetime, stockItem.lastModifiedDatetime)
      this.onChangeStockItemEvent.emit(item)
    } 
  }

  setSelectedRow(index: number) {
    this.selectedRow = index
  }

  private resetNewStockitemFields() {
    this.inputId = undefined
    this.inputBarCode = ""
    this.inputName = ""
    this.inputQuantity = undefined
    this.inputPrice = undefined
    this.areNewStockItemFieldsSet = false
  }

}
