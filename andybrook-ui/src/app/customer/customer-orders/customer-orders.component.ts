import { Component, OnInit, Input, OnChanges } from '@angular/core';
import { AggregatedOrder } from 'src/app/model/AggregatedOrder';
import { OrderService } from 'src/app/service/order-service';
import { Customer } from 'src/app/model/Customer';

@Component({
  selector: 'customer-orders',
  templateUrl: './customer-orders.component.html',
  styleUrls: ['./customer-orders.component.css']
})
export class CustomerOrdersComponent implements OnInit, OnChanges {

  @Input() customer: Customer
  private orders: AggregatedOrder[] = []

  constructor(private orderService: OrderService) { }

  ngOnInit() {
  }

  ngOnChanges() {
    this.loadOrders()
  }

  private loadOrders() {
    if (this.customer != null) {
      this.orderService.getOrdersOfCustomer(this.customer.id).subscribe(
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
