import { Component, OnInit, Input, OnChanges } from '@angular/core';
import { OrderService } from '../../../service/order-service';
import { AggregatedOrder } from '../../../model/AggregatedOrder';

@Component({
  selector: 'store-orders',
  templateUrl: './store-orders.component.html',
  styleUrls: ['./store-orders.component.css']
})
export class StoreOrdersComponent implements OnChanges {

  @Input() storeId: number
  private orders: AggregatedOrder[]

  constructor(private orderService: OrderService) { }

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
}
