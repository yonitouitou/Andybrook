import { Component, OnInit, Input, Output, EventEmitter, PipeTransform } from '@angular/core';
import { StockItem } from '../../model/StockItem'
import { Product } from '../../model/Product';

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
  @Input() orderId: number
  @Input() orderStatus: string

  @Output() onCreateStockItemEvent = new EventEmitter<StockItem>()
  @Output() onChangeStockItemEvent = new EventEmitter<StockItem>()
  @Output() onDeleteStockItemEvent = new EventEmitter<number>()

  constructor() {}

  ngOnInit() {
    
  }

  onBlurNewItemInput() {
    this.areNewStockItemFieldsSet = this.inputName.trim().length > 0
                                      && this.inputQuantity >= 0
                                      && this.inputPrice >= 0
  }

  createNewStockItem() {
    var stockItem = new StockItem(undefined, this.inputQuantity, new Product(undefined, this.inputName, this.inputPrice))
    this.onCreateStockItemEvent.emit(stockItem)
    this.resetNewStockitemFields()
  }

  deleteStockItem(id: number) {
    this.onDeleteStockItemEvent.emit(id)
  }

  onChangeStockItemName(stockItem: StockItem, event: any) {
    let product = stockItem.product
    let newName = event.target.textContent
    if (product.name !== newName) {
      let p = new Product(product.id, newName, product.price)
      let item = new StockItem(stockItem.id, stockItem.quantity, p)
      this.onChangeStockItemEvent.emit(item)
    } 
  }

  onChangeStockItemQuantity(stockItem: StockItem, event: any) {
    let newQuantity = event.target.textContent
    if (stockItem.quantity != newQuantity) {
      let item = new StockItem(stockItem.id, newQuantity, stockItem.product)
      this.onChangeStockItemEvent.emit(item)
    } 
  }

  onChangeStockItemPrice(stockItem: StockItem, event: any) {
    let product = stockItem.product
    let newPrice = event.target.textContent
    if (product.price != newPrice) {
      let p = new Product(product.id, product.name, newPrice)
      let item = new StockItem(stockItem.id, stockItem.quantity, p)
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
