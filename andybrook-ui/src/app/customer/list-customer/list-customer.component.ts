import { Component, OnInit, EventEmitter, Output, Input } from '@angular/core';
import { Customer } from 'src/app/model/Customer';
import { CustomerService } from 'src/app/service/customer-service';

@Component({
  selector: 'list-customer',
  templateUrl: './list-customer.component.html',
  styleUrls: ['./list-customer.component.css']
})
export class ListCustomerComponent implements OnInit {

  @Output() onCustomerSelected = new EventEmitter<Customer>()
  @Input() customer: Customer
  customers: Customer[] = [];

  constructor(private customerService: CustomerService) { }

  ngOnInit() {
    this.getCustomersList(null);
  }

  private getCustomersList(searchInput: string) {
    let obs;
    this.customers = [];
    if (searchInput === null || searchInput.length == 0) {
      obs = this.customerService.getAllCustomers();
    } else {
      obs = this.customerService.searchCustomerByIdOrNames(searchInput);
    }
    obs.subscribe(
      data => {
        for (let customer of data) {
          this.customers.push(Customer.fromJson(customer));
        }
      },
      error => {
        this.customers = [];
      }
    )
  }

  onClickCustomer(customer: Customer) {
    this.onCustomerSelected.emit(customer);
  }

  onClickSearch(value: string) {
    this.getCustomersList(value.trim());
  }
}
