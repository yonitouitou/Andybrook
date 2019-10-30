import { Component, OnInit, Input, OnChanges } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Validators, FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Subject } from 'rxjs';
import { debounceTime } from 'rxjs/operators';
import { Store } from '../../model/Store';
import { Order } from '../../model/Order';
import { OrderService } from '../../service/order-service';
import { CustomerService } from '../../service/customer-service';

@Component({
  selector: 'app-create-order-modal',
  templateUrl: './create-order-modal.component.html',
  styleUrls: ['./create-order-modal.component.css']
})
export class CreateOrderModalComponent implements OnInit {

  @Input() storeForOrder: Store

  createOrderForm: FormGroup
  storesArray: Store[] = []
  isFormSubmitted: boolean = false
  errorMessage: string
  private _error = new Subject<string>()

  constructor(private modal: NgbActiveModal,
              private customerService: CustomerService,
              private orderService: OrderService,
              private router: Router,
              private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.storesArray = (this.storeForOrder == null) ? [] : [this.storeForOrder]
    this.createOrderForm = this.formBuilder.group({
      name: ['', [Validators.required]],
      stores: [[], [Validators.required]],
      comment: ['']
    });

    if (this.storesArray.length == 0) {
      this.customerService.getAllCustomersNoLimit().subscribe(data => {
        for (let i = 0; i < data.length; i++) {
          this.storesArray.push(Store.fromJson(data[i]))
        }
        this.setOrderForm('', '', this.storesArray)
      })
    } else {
      this.createOrderForm.controls['stores'].setValue(this.storeForOrder)
    }

    this._error.subscribe((msg) => this.errorMessage = msg)
    this._error.pipe(debounceTime(5000)).subscribe(() => this.errorMessage = null)
  }

  private setOrderForm(name: string, comment: string, stores: Store[]) {
    this.createOrderForm.setValue({
      name: name,
      comment: comment,
      stores: stores
    })
  }

  public changeErrorMessage(errorMessage: string) {
    this._error.next("Order not created : " + errorMessage)
  }

  onSubmit() {
    this.isFormSubmitted = true
    const store = this.createOrderForm.get("stores").value
    const orderName = this.createOrderForm.get("name").value
    const comment = this.createOrderForm.get("comment").value
    const order = new Order()
    order.name = orderName
    order.comment = comment
    order.store = store
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
