import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { AggregatedOrder } from 'src/app/model/AggregatedOrder';
import { OrderService } from 'src/app/service/order-service';
import { CustomerService } from 'src/app/service/customer-service';
import { Store } from '../../model/Store';

@Component({
  selector: 'customer-panel',
  templateUrl: './customer-panel.component.html',
  styleUrls: ['./customer-panel.component.css']
})
export class CustomerPanelComponent implements OnInit {

  store: Store
  orders: AggregatedOrder[] = []

  constructor(private customerService: CustomerService) { }

  ngOnInit() {
    
  }

  onStoreSelected(event) {
    this.store = event;
  }

  onUpdateStore(event) {
    this.customerService.getCustomer(event.id).subscribe(
      data => {
        this.store = Store.fromJson(data);
      }
    )
  }

}
