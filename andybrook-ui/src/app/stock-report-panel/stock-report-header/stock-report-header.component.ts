import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Order } from "../../model/Order";
import { ModalBuilder } from 'src/app/common-components/modal-builder';
import { ConfirmModalComponent } from 'src/app/modal/confirm-modal/confirm-modal-component';
import { OrderService } from 'src/app/service/order-service';

@Component({
  selector: 'stock-report-header',
  templateUrl: './stock-report-header.component.html',
  styleUrls: ['./stock-report-header.component.css']
})
export class StockReportHeaderComponent implements OnInit {

  @Input() order: Order

  @Output() onCloseOrderEvent = new EventEmitter()

  constructor(private modalBuilder: ModalBuilder,
              private orderService: OrderService) { }

  ngOnInit() {
  }

  onClickCloseOrder() {
    let modalRef = this.modalBuilder.open(ConfirmModalComponent)
    modalRef.componentInstance.title = "Close Report Confirmation"
    modalRef.componentInstance.message = "Are you sure you want to close the order "
          + this.order.name + " for the store " + this.order.customer.store.name

    modalRef.result.then((response) => {
      if (response) {
        this.orderService.closeOrder(this.order)
      }
    })
  }

}
