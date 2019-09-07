import { Component, OnInit, Input } from '@angular/core';
import { OrderService } from 'src/app/service/order-service';
import { NotificationService } from 'src/app/service/notification-service';
import { ModalBuilder } from 'src/app/common-components/modal-builder';
import { ConfirmModalComponent } from 'src/app/modal/confirm-modal/confirm-modal-component';
import { AggregatedOrder } from 'src/app/model/AggregatedOrder';
import { OrderNotificationModalComponent } from 'src/app/modal/order-notification-modal/order-notification-modal.component';

@Component({
  selector: 'list-orders',
  templateUrl: './list-orders.component.html',
  styleUrls: ['./list-orders.component.css']
})
export class ListOrdersComponent implements OnInit {

  @Input() orders: AggregatedOrder[]

  page: number = 1
  pageSize: number = 10
  collectionSize: number

  constructor(private orderService: OrderService,
              private modalBuilder: ModalBuilder) {}

  ngOnInit() {
    this.collectionSize = this.orders.length
  }

  onClickCloseOrder(orderToClose: AggregatedOrder) {
    let modalRef = this.modalBuilder.open(ConfirmModalComponent);
    modalRef.componentInstance.title = "Close Order Confirmation";
    modalRef.componentInstance.message = "Are you sure you want to close the order "
          + orderToClose.name + " for the store " + orderToClose.customer.store.name + ' ?';

    modalRef.result.then((response) => {
      if (response) {
        this.orderService.closeOrder(orderToClose.id).subscribe(
          data => {
            orderToClose.closeDatetime = data.closeDateTime
            orderToClose.status = data.status
          }
        )
      }
    });
  }

  onClickNotify(order: AggregatedOrder) {
    let modalRef = this.modalBuilder.open(OrderNotificationModalComponent);
    modalRef.componentInstance.orderId = order.id;
  }

  get ordersArray(): AggregatedOrder[] {
    return this.orders
              .slice((this.page - 1) * this.pageSize, (this.page -1) * this.pageSize + this.pageSize)
  }
}
