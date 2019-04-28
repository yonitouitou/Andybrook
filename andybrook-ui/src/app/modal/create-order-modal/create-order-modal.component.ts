import { Component, OnInit, Input } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Validators, FormBuilder, FormGroup } from '@angular/forms';
import { Customer } from 'src/app/model/Customer';
import { CustomerService } from 'src/app/service/customer-service';
import { Order } from 'src/app/model/Order';
import { OrderService } from 'src/app/service/order-service';
import { Router } from '@angular/router';
import { Subject } from 'rxjs';
import { debounceTime } from 'rxjs/operators';

@Component({
  selector: 'app-create-order-modal',
  templateUrl: './create-order-modal.component.html',
  styleUrls: ['./create-order-modal.component.css']
})
export class CreateOrderModalComponent implements OnInit {

  createOrderForm: FormGroup
  customersArray: Customer[] = []
  isFormSubmitted: boolean = false
  errorMessage: string
  private _error = new Subject<string>()

  constructor(private modal: NgbActiveModal,
              private customerService: CustomerService,
              private orderService: OrderService,
              private router: Router,
              private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.createOrderForm = this.formBuilder.group({
      name: ['', [Validators.required]],
      customers: [[], [Validators.required]],
      comment: ['']
    });

    this.customerService.getAllCustomers().subscribe(data => {
      console.log(data)
      for (let i = 0; i < data.length; i++) {
        this.customersArray.push(Customer.fromJson(data[i]))
      }
      this.createOrderForm.setValue({
        name: '',
        comment: '',
        customers: this.customersArray
      })
    })

    this._error.subscribe((msg) => this.errorMessage = msg)
    this._error.pipe(debounceTime(5000)).subscribe(() => this.errorMessage = null)
  }

  public changeErrorMessage(errorMessage: string) {
    this._error.next("Order not created : " + errorMessage)
  }

  settingChanged() {

  }

  onSubmit() {
    this.isFormSubmitted = true
    const customer = this.createOrderForm.get("customers").value
    const orderName = this.createOrderForm.get("name").value
    const comment = this.createOrderForm.get("comment").value
    const order = new Order()
    order.name = orderName
    order.comment = comment
    order.customer = customer
    this.orderService.addOrder(order).subscribe(
      data => {
        this.modal.close(true)
        this.router.navigate(['/order', data.id])
      },
      error => {
        this.changeErrorMessage(error.error);
      })
  }

  onClose() {
    this.modal.close(false)
  }

}
