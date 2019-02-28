import { Component, OnInit, Input } from '@angular/core';
import { Order } from "src/app/model/Order";
import { OrderService } from 'src/app/service/order-service';
import { NotificationService } from 'src/app/service/notification-service';
import { ModalBuilder } from 'src/app/common-components/modal-builder';
import { ConfirmModalComponent } from 'src/app/modal/confirm-modal/confirm-modal-component';

@Component({
  selector: 'list-orders',
  templateUrl: './list-orders.component.html',
  styleUrls: ['./list-orders.component.css']
})
export class ListOrdersComponent implements OnInit {

  @Input() orders: Order[]

  page: number = 1
  pageSize: number = 4
  collectionSize: number

  constructor(private orderService: OrderService,
              private notificationService: NotificationService,
              private modalBuilder: ModalBuilder) {}

  ngOnInit() {
    this.collectionSize = this.orders.length
  }

  onClickCloseOrder(orderToClose: Order) {
      let modalRef = this.modalBuilder.open(ConfirmModalComponent)
      modalRef.componentInstance.title = "Close Report Confirmation"
      modalRef.componentInstance.message = "Are you sure you want to close the order "
            + orderToClose.name + " for the store " + orderToClose.customer.store.name

      modalRef.result.then((response) => {
        if (response) {
          this.orderService.closeOrder(orderToClose)
        }
      })
  }

  onClickNotify(order: Order) {
    let modalRef = this.modalBuilder.open(ConfirmModalComponent)
    modalRef.componentInstance.title = "Notification Confirmation"
    modalRef.componentInstance.message = "Are you sure you want to get notification about the order " + order.name + " ?"
    modalRef.result.then((response) => {
      if (response) {
        this.notificationService.notifyOrder(order.id).subscribe(
          data => console.log("Notify done : " + data)
        )
      }
    })
  }

  get ordersArray(): Order[] {
    return this.orders
              .slice((this.page - 1) * this.pageSize, (this.page -1) * this.pageSize + this.pageSize)
  }
}
