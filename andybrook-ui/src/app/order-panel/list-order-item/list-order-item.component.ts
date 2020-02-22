import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { OrderItem } from '../../model/OrderItem'
import { OrderService } from 'src/app/service/order-service';
import { ModalBuilder } from 'src/app/common-components/modal-builder';
import { InfoModalComponent } from 'src/app/modal/info-modal/info-modal.component';
import { ProductService } from 'src/app/service/product-service';
import { Observable } from 'rxjs';
import { debounceTime, distinctUntilChanged, map } from 'rxjs/operators';
import { ModifyOrderItemReq } from 'src/app/model/request/order/ModifyOrderItemReq';
import { AggregatedOrder } from 'src/app/model/AggregatedOrder';
import { AggregatedOrderItem } from 'src/app/model/AggregatedOrderItem';
import { DeleteOrderItemsModalComponent } from 'src/app/modal/delete-order-items-modal/delete-order-items-modal.component';
import { DeleteOrderItemsReq } from 'src/app/model/request/order/DeleteOrderItemsReq';

@Component({
  selector: 'list-order-item',
  templateUrl: './list-order-item.component.html',
  styleUrls: ['./list-order-item.component.css']
})
export class ListOrderItemComponent implements OnInit {

  @Input() orderItems: IterableIterator<AggregatedOrderItem>
  @Input() order: AggregatedOrder

  @Output() onCreateOrderItemEvent = new EventEmitter<OrderItem>()
  @Output() onChangeOrderItemEvent = new EventEmitter<ModifyOrderItemReq>()
  @Output() onDeleteOrderItemEvent = new EventEmitter<number[]>()
  
  inputId: number
  inputBarCode: string
  inputName: string
  inputQuantity: number
  inputPrice: number
  selectedRow: number
  areNewOrderItemFieldsSet = false
  searchString: string
  selectedOrderItems: Map<number, OrderItem> = new Map();
  productNames: string[] = []
  deleteOrderItemInProgressArray: boolean[] = [];
  productIdMapByName: Map<string, number> = new Map()
  
  search = (text$: Observable<string>) =>
    text$.pipe(
      debounceTime(200),
      distinctUntilChanged(),
      map(term => term.length < 1 ? []
        : this.productNames.filter(v => v.toLowerCase().indexOf(term.toLowerCase()) > -1).slice(0, 10))
    )

  constructor(private orderService: OrderService,
              private modalBuilder: ModalBuilder) {}

  ngOnInit() {
    this.initDeleteOrderItemButtonStatus();
  }

  private initDeleteOrderItemButtonStatus() {
    for (let i = 0; i < this.deleteOrderItemInProgressArray.length; i++) {
      this.deleteOrderItemInProgressArray.push(false);
    }
  }

  checkInputFieldSet() {
    this.areNewOrderItemFieldsSet = this.inputName.trim().length > 0
                                      && this.inputQuantity > 0
                                      && this.inputPrice > 0
  }

  deleteSingleOrderItem(orderItem: OrderItem) {
    const orderItems: OrderItem[] = [orderItem];
    this.deleteOrderItem(orderItems);
    this.selectedOrderItems.delete(orderItem.id);
  }

  deleteOrderItem(orderItems: OrderItem[]) {
    const ids = orderItems.map(item => item.id);
    const req = new DeleteOrderItemsReq(this.order.aggregatedOrderInfo.id, ids);
    this.orderService.deleteOrderItems(req).subscribe(
      data => {
          this.onDeleteOrderItemEvent.emit(ids);
          this.deleteFromSelectedOrderItem(ids);
      },
      error => {
        const modalRef = this.modalBuilder.open(InfoModalComponent)
        modalRef.componentInstance.title = "Error : Failed to delete the order items.";
        modalRef.componentInstance.message = error.error
      }
    )
  }

  private deleteFromSelectedOrderItem(ids: number[]) {
    for(let id of ids) {
      this.selectedOrderItems.delete(id);
    }
  }

  onClickDeleteOrderItemButton(rowTableIndex: number, orderItems: OrderItem[]) {
    this.setDeleteOrderItemButtonStatus(rowTableIndex, true);
    this.displayDeletionConfirmationModal(rowTableIndex, orderItems);
  }

  displayDeletionConfirmationModal(rowTableIndex:number, orderItems: OrderItem[]) {
    const modalRef = this.modalBuilder.openCenteredLargeModal(DeleteOrderItemsModalComponent)
    modalRef.componentInstance.title = "Are you sure you want to delete the following order items ?"
    modalRef.componentInstance.orderItems = orderItems;
    modalRef.result.then((response) => {
      if (response) {
        this.deleteOrderItem(orderItems);
      }
      this.setDeleteOrderItemButtonStatus(rowTableIndex, false);
    })
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

  onClickShowSelectedOrderItems(selectedOrderItems: OrderItem[]) {
    let tmp = new Map<number, OrderItem>();
    for (let orderItem of selectedOrderItems) {
      tmp.set(orderItem.id, orderItem);
    }
    this.selectedOrderItems = tmp;
  }

  setDeleteOrderItemButtonStatus(index: number, isInProgress: boolean) {
      this.deleteOrderItemInProgressArray[index] = isInProgress;
  }
}
