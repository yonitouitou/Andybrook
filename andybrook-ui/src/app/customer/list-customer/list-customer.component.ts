import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { Customer } from 'src/app/model/Customer';
import { ModalBuilder } from 'src/app/common-components/modal-builder';
import { CustomerService } from 'src/app/service/customer-service';
import { InfoModalComponent } from 'src/app/modal/info-modal/info-modal.component';

@Component({
  selector: 'list-customer',
  templateUrl: './list-customer.component.html',
  styleUrls: ['./list-customer.component.css']
})
export class ListCustomerComponent implements OnInit {

  @Output() onCustomerSelected = new EventEmitter<Customer>()
  customers: Customer[] = [];

  constructor(private customerService: CustomerService,
              private modalBuilder: ModalBuilder) { }

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
