import { Component, OnInit, Input, Output, EventEmitter, PipeTransform } from '@angular/core';
import { StockItem } from '../../model/StockItem'
import { Product } from '../../model/Product';
import { OrderService } from 'src/app/service/order-service';
import { Order } from 'src/app/model/Order';
import { ModalBuilder } from 'src/app/common-components/modal-builder';
import { InfoModalComponent } from 'src/app/modal/info-modal/info-modal.component';

@Component({
  selector: 'list-stock-item',
  templateUrl: './list-stock-item.component.html',
  styleUrls: ['./list-stock-item.component.css']
})
export class ListStockItemComponent implements OnInit {

  inputName: string
  inputQuantity: number
  inputPrice: number
  selectedRow: number
  areNewStockItemFieldsSet = false
  searchString: string

  @Input() stockItems: IterableIterator<StockItem>
  @Input() order: Order

  @Output() onCreateStockItemEvent = new EventEmitter<StockItem>()
  @Output() onChangeStockItemEvent = new EventEmitter<StockItem>()
  @Output() onDeleteStockItemEvent = new EventEmitter<number>()

  constructor(private orderService: OrderService,
              private modalBuilder: ModalBuilder) {}

  ngOnInit() {
    
  }

  onBlurNewItemInput() {
    this.areNewStockItemFieldsSet = this.inputName.trim().length > 0
                                      && this.inputQuantity >= 0
                                      && this.inputPrice >= 0
  }

  createNewStockItem() {
    var stockItem = new StockItem(undefined, null, this.inputQuantity, new Product(undefined, this.inputName, this.inputPrice), null, null)
    this.orderService.addItem(this.order, stockItem).subscribe(
      data => {
          let barCodeId
          if (data.item.barCode != null) {
            barCodeId = data.item.barCode.id
          }
          let product = new Product(data.item.product.id, data.item.product.name, data.item.product.price)
          stockItem = new StockItem(data.item.id, barCodeId, data.item.quantity, product, data.item.createdDatetime, data.item.lastModifiedDatetime)
          this.onCreateStockItemEvent.emit(stockItem)
          this.resetNewStockitemFields()
      },
      error => {
        const modalRef = this.modalBuilder.open(InfoModalComponent)
        modalRef.componentInstance.title = "Error : Product item " + stockItem.product.name + " not added to order " + this.order.name
        modalRef.componentInstance.message = error.error.message
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

  onChangeStockItemName(stockItem: StockItem, event: any) {
    let product = stockItem.product
    let newName = event.target.textContent
    if (product.name !== newName) {
      let p = new Product(product.id, newName, product.price)
      let item = new StockItem(stockItem.id, stockItem.barCode, stockItem.quantity, p, stockItem.createdDatetime, stockItem.lastModifiedDatetime)
      this.orderService.updateStockItem(this.order, item).subscribe(data => {
        this.order.id = data.id
        this.order.name = data.name
        this.order.comment = data.comment
        this.order.status = data.status
        let product = new Product(data.item.product.id, data.item.product.name, data.item.product.price)
        let stockItem = new StockItem(data.item.id, data.item.barCode.id, data.item.quantity, product, data.item.createdDatetime, data.item.lastModifiedDatetime)
        this.order.items.set(stockItem.id, stockItem)
        this.onChangeStockItemEvent.emit(stockItem)
      },
      error => {
        debugger;
          console.log(error)
      })
    } 
  }

  onChangeStockItemQuantity(stockItem: StockItem, event: any) {
    let newQuantity = event.target.textContent
    if (stockItem.quantity != newQuantity) {
      let item = new StockItem(stockItem.id, stockItem.barCode, newQuantity, stockItem.product, stockItem.createdDatetime, stockItem.lastModifiedDatetime)
      this.onChangeStockItemEvent.emit(item)
    } 
  }

  onChangeStockItemPrice(stockItem: StockItem, event: any) {
    let product = stockItem.product
    let newPrice = event.target.textContent
    if (product.price != newPrice) {
      let p = new Product(product.id, product.name, newPrice)
      let item = new StockItem(stockItem.id, stockItem.barCode, stockItem.quantity, p, stockItem.createdDatetime, stockItem.lastModifiedDatetime)
      this.onChangeStockItemEvent.emit(item)
    } 
  }

  setSelectedRow(index: number) {
    this.selectedRow = index
  }

  private resetNewStockitemFields() {
    this.inputName = ""
    this.inputQuantity = undefined
    this.inputPrice = undefined
    this.areNewStockItemFieldsSet = false
  }

}
