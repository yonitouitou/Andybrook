import { Component, OnInit, Input } from '@angular/core';
import { AggregatedOrder } from 'src/app/model/AggregatedOrder';
import { OrderService } from 'src/app/service/order-service';

@Component({
  selector: 'customer-orders',
  templateUrl: './customer-orders.component.html',
  styleUrls: ['./customer-orders.component.css']
})
export class CustomerOrdersComponent implements OnInit {

  @Input() orders: AggregatedOrder[] = []

  constructor(private orderService: OrderService) { }

  ngOnInit() {
  }

  

}
