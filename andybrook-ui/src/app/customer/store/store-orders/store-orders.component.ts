import { Component, OnInit, Input, OnChanges } from '@angular/core';
import { OrderService } from '../../../service/order-service';
import { AggregatedOrder } from '../../../model/AggregatedOrder';
import { ModalBuilder } from '../../../common-components/modal-builder';
import { CreateOrderModalComponent } from '../../../modal/create-order-modal/create-order-modal.component';

@Component({
  selector: 'store-orders',
  templateUrl: './store-orders.component.html',
  styleUrls: ['./store-orders.component.css']
})
export class StoreOrdersComponent implements OnChanges {

  @Input() storeId: number
  private orders: AggregatedOrder[]

  constructor(private orderService: OrderService, private modalBuilder: ModalBuilder) { }

  ngOnChanges() {
    this.loadOrders()
  }

  private loadOrders() {
    if (this.storeId != null) {
      this.orderService.getOrdersOfStore(this.storeId).subscribe(
        data => {
          let arr: AggregatedOrder[] = [];
          for (let order of data) {
            arr.push(AggregatedOrder.fromJson(order));
          }
          this.orders = arr;
        }
      )
    }
  }

  private onNewOrder(): void {
    this.modalBuilder.open(CreateOrderModalComponent)
  }
}
