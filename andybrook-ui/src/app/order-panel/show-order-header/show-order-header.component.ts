import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { ModalBuilder } from 'src/app/common-components/modal-builder';
import { ConfirmModalComponent } from 'src/app/modal/confirm-modal/confirm-modal-component';
import { OrderService } from 'src/app/service/order-service';
import { AggregatedOrder } from 'src/app/model/AggregatedOrder';
import { AddOrderItemModalComponent } from 'src/app/modal/add-order-item-modal/add-order-item-modal.component';

@Component({
  selector: 'show-order-header',
  templateUrl: './show-order-header.component.html',
  styleUrls: ['./show-order-header.component.css']
})
export class OrderHeaderComponent implements OnInit {

  @Input() order: AggregatedOrder

  @Output() onCloseOrderEvent = new EventEmitter()
  @Output() onAddOrderItemEvent = new EventEmitter()

  constructor(private modalBuilder: ModalBuilder,
              private orderService: OrderService) { }

  ngOnInit() {
  }

  onClickAddOrderItem() {
    let modalRef = this.modalBuilder.openCenteredLargeModal(AddOrderItemModalComponent);
    modalRef.componentInstance.orderId = this.order.id;
    modalRef.componentInstance.addOrderItemEvent.subscribe(($e) => {
      this.onAddOrderItemEvent.emit();
    })
  }

  onClickCloseOrder() {
    let modalRef = this.modalBuilder.open(ConfirmModalComponent);
    modalRef.componentInstance.title = "Close Order Confirmation";
    modalRef.componentInstance.message = "Are you sure you want to close the order "
          + this.order.name + " for the store " + this.order.customer.store.name + " ?";

    modalRef.result.then((response) => {
      if (response) {
        this.orderService.closeOrder(this.order.id).subscribe(
          data => {
            this.order.closeDatetime = data.closeDateTime;
            this.order.status = data.status;
          }
        )
      }
    })
  }

}
