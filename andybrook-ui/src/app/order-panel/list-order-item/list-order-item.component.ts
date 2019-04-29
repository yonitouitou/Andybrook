import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { OrderItem } from '../../model/OrderItem'
import { Product } from '../../model/Product';
import { OrderService } from 'src/app/service/order-service';
import { ModalBuilder } from 'src/app/common-components/modal-builder';
import { InfoModalComponent } from 'src/app/modal/info-modal/info-modal.component';
import { ProductService } from 'src/app/service/product-service';
import { Observable } from 'rxjs';
import { debounceTime, distinctUntilChanged, map } from 'rxjs/operators';
import { AddOrderItemReq } from 'src/app/model/request/AddOrderItemReq';
import { ModifyOrderItemReq } from 'src/app/model/request/ModifyOrderItemReq';
import { AggregatedOrder } from 'src/app/model/AggregatedOrder';
import { AggregatedOrderItem } from 'src/app/model/AggregatedOrderItem';
import { ShowOrderItemsModalComponent } from 'src/app/modal/show-order-items-modal/show-order-items-modal.component';

@Component({
  selector: 'list-order-item',
  templateUrl: './list-order-item.component.html',
  styleUrls: ['./list-order-item.component.css']
})
export class ListOrderItemComponent implements OnInit {

  inputId: number
  inputBarCode: string
  inputName: string
  inputQuantity: number
  inputPrice: number
  selectedRow: number
  isScanMode: boolean
  areNewOrderItemFieldsSet = false
  searchString: string
  selectedOrderItems: OrderItem[] = [];
  productNames: string[] = []
  productIdMapByName: Map<string, number> = new Map()
  
  search = (text$: Observable<string>) =>
    text$.pipe(
      debounceTime(200),
      distinctUntilChanged(),
      map(term => term.length < 1 ? []
        : this.productNames.filter(v => v.toLowerCase().indexOf(term.toLowerCase()) > -1).slice(0, 10))
    )

  @Input() orderItems: IterableIterator<AggregatedOrderItem>
  @Input() order: AggregatedOrder

  @Output() onCreateOrderItemEvent = new EventEmitter<OrderItem>()
  @Output() onChangeOrderItemEvent = new EventEmitter<ModifyOrderItemReq>()
  @Output() onDeleteOrderItemEvent = new EventEmitter<number>()

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
        this.createNewOrderItem()
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
    this.areNewOrderItemFieldsSet = this.inputName.trim().length > 0
                                      && this.inputQuantity > 0
                                      && this.inputPrice > 0
  }

  createNewOrderItem() {
    var req = new AddOrderItemReq(this.order.id, this.inputId, this.inputBarCode, this.inputQuantity);
    this.orderService.addOrderItem(req).subscribe(
      data => {
          let orderItem = OrderItem.fromJson(data);
          this.onCreateOrderItemEvent.emit(orderItem)
          this.resetNewOrderItemInputFields()
      },
      error => {
        const modalRef = this.modalBuilder.open(InfoModalComponent)
        modalRef.componentInstance.title = "Error : Product item " + this.inputName + " not added to order " + this.order.name
        modalRef.componentInstance.message = error.error
        this.resetNewOrderItemInputFields()
      })
  }

  deleteOrderItem(orderItems: OrderItem[]) {
    for (let orderItem of orderItems) {
      this.orderService.deleteOrderItem(this.order.id, orderItem.id).subscribe(
        data => {
            console.log(data)
            this.onDeleteOrderItemEvent.emit(orderItem.id)
        },
        error => {
          const modalRef = this.modalBuilder.open(InfoModalComponent)
          modalRef.componentInstance.title = "Error : Failed to delete the order item " + orderItem.id;
          modalRef.componentInstance.message = error.error
        }
      )
    }
  }

  onChangeOrderItemQuantity(orderItem: OrderItem, event: any) {
    /*let newQuantity = event.target.textContent
    if (orderItem.quantity != newQuantity) {
      let req = new ModifyOrderItemReq(orderItem.id, newQuantity);
      // Must send Http request.
      this.onChangeOrderItemEvent.emit(req)
    } */
  }

  setSelectedRow(index: number) {
    this.selectedRow = index
  }

  onClickShowOrderItems(selectedOrderItems: OrderItem[]) {
    this.selectedOrderItems = selectedOrderItems;
  }

  private resetNewOrderItemInputFields() {
    this.inputId = undefined
    this.inputBarCode = ""
    this.inputName = ""
    this.inputQuantity = undefined
    this.inputPrice = undefined
    this.areNewOrderItemFieldsSet = false
  }

}
