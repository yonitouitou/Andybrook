import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { AggregatedOrder } from 'src/app/model/AggregatedOrder';
import { OrderService } from 'src/app/service/order-service';
import { Customer } from 'src/app/model/Customer';

@Component({
  selector: 'customer-panel',
  templateUrl: './customer-panel.component.html',
  styleUrls: ['./customer-panel.component.css']
})
export class CustomerPanelComponent implements OnInit {

  customer: Customer
  orders: AggregatedOrder[] = []

  constructor(private orderService: OrderService) { }

  ngOnInit() {
    
  }

  onCustomerSelected(event) {
    this.customer = event;
    this.loadOrders(event.id);
  }

  private loadOrders(customerId: number) {
    this.orderService.getOrdersOfCustomer(customerId).subscribe(
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
