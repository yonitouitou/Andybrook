import { Component, OnInit, EventEmitter, Output, Input } from '@angular/core';
import { CustomerService } from 'src/app/service/customer-service';
import { Store } from '../../model/Store';

@Component({
  selector: 'list-customer',
  templateUrl: './list-customer.component.html',
  styleUrls: ['./list-customer.component.css']
})
export class ListCustomerComponent implements OnInit {

  @Output() onStoreSelected = new EventEmitter<Store>()
  @Input() store: Store
  stores: Store[] = [];

  constructor(private customerService: CustomerService) { }

  ngOnInit() {
    this.getStoresList(null);
  }

  private getStoresList(searchInput: string) {
    let obs;
    this.stores = [];
    if (searchInput === null || searchInput.length == 0) {
      obs = this.customerService.getAllCustomers();
    } else {
      obs = this.customerService.searchCustomerByIdOrNames(searchInput);
    }
    obs.subscribe(
      data => {
        for (let store of data) {
          this.stores.push(Store.fromJson(store));
        }
      },
      error => {
        this.stores = [];
      }
    )
  }

  onClickStore(store: Store) {
    this.onStoreSelected.emit(store);
  }

  onClickSearch(value: string) {
    this.getStoresList(value.trim());
  }
}
