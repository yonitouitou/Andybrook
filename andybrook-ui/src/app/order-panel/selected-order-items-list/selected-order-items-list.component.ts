import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { OrderItem } from 'src/app/model/OrderItem';
import { DeleteOrderItemsModalComponent } from 'src/app/modal/delete-order-items-modal/delete-order-items-modal.component';
import { ModalBuilder } from 'src/app/common-components/modal-builder';
import { AggregatedOrder } from 'src/app/model/AggregatedOrder';
import { DeleteOrderItemsReq } from 'src/app/model/request/order/DeleteOrderItemsReq';
import { OrderService } from 'src/app/service/order-service';
import { InfoModalComponent } from 'src/app/modal/info-modal/info-modal.component';

@Component({
  selector: 'selected-order-items-list',
  templateUrl: './selected-order-items-list.component.html',
  styleUrls: ['./selected-order-items-list.component.css']
})
export class SelectedOrderItemsListComponent implements OnInit {

  @Input() selectedOrderItems: Map<number, OrderItem> = new Map();
  @Input() order: AggregatedOrder;

  @Output() onDeleteOrderItemEvent = new EventEmitter<OrderItem>();
  deleteOrderItemInProgressArray: boolean[] = [];

  constructor(private modalBuilder: ModalBuilder,
              private orderService: OrderService) { }

  ngOnInit() {
    this.initDeleteOrderItemButtonStatus();
  }

  private initDeleteOrderItemButtonStatus() {
    for (let i = 0; i < this.deleteOrderItemInProgressArray.length; i++) {
      this.deleteOrderItemInProgressArray.push(false);
    }
  }

  onClickDeleteOrderItemButton(rowTableIndex: number, orderItem: OrderItem) {
    this.setDeleteOrderItemButtonStatus(rowTableIndex, true);
    this.displayDeletionConfirmationModal(rowTableIndex, orderItem);
  }

  displayDeletionConfirmationModal(rowTableIndex:number, orderItem: OrderItem) {
    const modalRef = this.modalBuilder.openCenteredLargeModal(DeleteOrderItemsModalComponent)
    modalRef.componentInstance.title = "Are you sure you want to delete the following order item ?";
    let orderItemToDelete = [];
    orderItemToDelete.push(orderItem);
    modalRef.componentInstance.orderItems = orderItemToDelete;
    modalRef.result.then((response) => {
      if (response) {
        this.onDeleteOrderItemEvent.emit(orderItem);
        //this.deleteOrderItem(orderItem);
      }
      this.setDeleteOrderItemButtonStatus(rowTableIndex, false);
    })
  }

  deleteOrderItem(orderItem: OrderItem) {
    const id: number[] = [orderItem.id];
    const req = new DeleteOrderItemsReq(this.order.id, id);
    this.orderService.deleteOrderItems(req).subscribe(
      data => {
          this.selectedOrderItems.delete(orderItem.id);
      },
      error => {
        const modalRef = this.modalBuilder.open(InfoModalComponent)
        modalRef.componentInstance.title = "Error : Failed to delete the order items.";
        modalRef.componentInstance.message = error.error
      }
    )
  }

  setDeleteOrderItemButtonStatus(index: number, isInProgress: boolean) {
    this.deleteOrderItemInProgressArray[index] = isInProgress;
  }

}
