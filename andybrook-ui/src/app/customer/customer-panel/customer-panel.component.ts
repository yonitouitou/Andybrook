import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { AggregatedOrder } from 'src/app/model/AggregatedOrder';
import { OrderService } from 'src/app/service/order-service';
import { Customer } from 'src/app/model/Customer';
import { CustomerService } from 'src/app/service/customer-service';

@Component({
  selector: 'customer-panel',
  templateUrl: './customer-panel.component.html',
  styleUrls: ['./customer-panel.component.css']
})
export class CustomerPanelComponent implements OnInit {

  customer: Customer
  orders: AggregatedOrder[] = []

  constructor(private orderService: OrderService,
              private customerService: CustomerService) { }

  ngOnInit() {
    
  }

  onCustomerSelected(event) {
    this.customer = event;
  }

  onUpdateCustomer(event) {
    this.customerService.getCustomer(event.id).subscribe(
      data => {
        this.customer = Customer.fromJson(data);
      }
    )
  }

}
