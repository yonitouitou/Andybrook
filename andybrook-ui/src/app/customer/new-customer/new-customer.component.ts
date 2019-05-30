import { Component, OnInit, Input, OnChanges, SimpleChanges } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { CustomerService } from 'src/app/service/customer-service';
import { Observable, Subject } from 'rxjs';
import { debounceTime, distinctUntilChanged, map } from 'rxjs/operators';
import { AddOrUpdateCustomerReq } from 'src/app/model/request/customer/AddOrUpdateCustomerReq';
import { Store } from 'src/app/model/Store';
import { ModalBuilder } from 'src/app/common-components/modal-builder';
import { InfoModalComponent } from 'src/app/modal/info-modal/info-modal.component';
import { StringUtil } from 'src/app/util/StringUtil';
import { Customer } from 'src/app/model/Customer';
import { Address } from 'src/app/model/Address';

@Component({
  selector: 'new-customer',
  templateUrl: './new-customer.component.html',
  styleUrls: ['./new-customer.component.css']
})
export class NewCustomerComponent implements OnInit, OnChanges {

  @Input() customer: Customer

  form: FormGroup
  inputOwnerName: string
  ownerNames: string[] = []
  ownerIdMapByName: Map<string, number>
  errorMessage: string
  storesOfSelectedOwner: Store[] = []
  private _error = new Subject<string>()

  constructor(private formBuilder: FormBuilder,
              private modalBuilder: ModalBuilder,
              private customerService: CustomerService) {
    this.ownerIdMapByName = new Map();
    this.initForm();
    this._error.subscribe((msg) => this.errorMessage = msg);
    this._error.pipe(debounceTime(4000)).subscribe(() => this.errorMessage = null);
  }

  ngOnInit() {
  }

  ngOnChanges(changes: SimpleChanges): void {
    if (this.customer != null) {
      this.fillForm();
    }
  }

  private initForm() {
    this.loadOwners();
    this.form = this.formBuilder.group({
      ownerAutoComplete: '',
      ownerFirstName: '',
      ownerLastName: '',
      ownerEmail: ['', Validators.email],
      storeName: ['', Validators.required],
      storeStreetNumber: '',
      storeStreetName: '',
      storeZipCode: '',
      storeCity: '',
      storeCountry: '',
      storePhone: '',
      storeEmail: ['', Validators.email]
    });
    if (this.customer != null) {
      this.fillForm();
    }
  }

  private fillForm() {
    const store = this.customer.store;
    this.form.setValue({
      ownerAutoComplete: store.owner.compagnyName,
      ownerFirstName: store.owner.firstName,
      ownerLastName: store.owner.lastName,
      ownerEmail: store.owner.email,
      storeName: store.name,
      storeStreetNumber: store.address.streetNumber,
      storeStreetName: store.address.streetName,
      storeZipCode: store.address.zipCode,
      storeCity: store.address.city,
      storeCountry: store.address.country,
      storePhone: store.phone,
      storeEmail: store.email
    })
  }

  private loadOwners() {
    this.customerService.getAllOwnersIdsAndNames().subscribe(
      data => {
        for (let owner of data) {
          this.ownerIdMapByName.set(owner.second, owner.first);
          this.ownerNames.push(owner.second);
        }
      }
    )
  }

  onBlurStringFormControl(event) {
    event.srcElement.value = StringUtil.capitalFirstLetter(event.srcElement.value);
  }

  onBlurLowcaseStringFormControl(event) {
    event.srcElement.value = event.srcElement.value.toLowerCase();
  }

  search = (text$: Observable<string>) =>
    text$.pipe(
      debounceTime(200),
      distinctUntilChanged(),
      map(term => term.length < 1 ? []
        : this.ownerNames.filter(v => v.toLowerCase().indexOf(term.toLowerCase()) > -1).slice(0, 10))
  )

  onBlurOwnerAutoComplete() {
    let ownerNameSelected = this.form.controls.ownerAutoComplete.value;
    let ownerId = this.ownerIdMapByName.get(ownerNameSelected);
    if (ownerId != null) {
      this.customerService.getStoresOfOwner(ownerId).subscribe(
        data => {
          for (let store of data) {
            this.storesOfSelectedOwner.push(Store.fromJson(store));
          }
        }, error => {
          const modalRef = this.modalBuilder.open(InfoModalComponent);
          modalRef.componentInstance.title = '';
          modalRef.componentInstance.message = 'Cannot load the stores of the owner : ' + ownerNameSelected; 
        }
      )
    } else {
      this.storesOfSelectedOwner = [];
    }
  }

  private changeErrorMessage(errorMessage: string) {
    this._error.next(errorMessage);
  }

  onSubmit() {
    let controls = this.form.controls;
    if (this.form.valid) {
      let ownerId = this.ownerIdMapByName.get(controls.ownerAutoComplete.value);
      let req = new AddOrUpdateCustomerReq(ownerId, controls.storeName.value);
      if (this.customer != null) {
        req.customerId = this.customer.id;
      }
      req.ownerCompagnyName = controls.ownerAutoComplete.value;
      req.ownerFirstName = controls.ownerFirstName.value;
      req.ownerLastName = controls.ownerLastName.value;
      req.ownerEmail = controls.ownerEmail.value;
      req.storeName = controls.storeName.value;
      req.storeEmail = controls.storeEmail.value;
      req.storePhone = controls.storePhone.value;
      req.storeAddress = new Address(controls.storeStreetNumber.value, controls.storeStreetName.value,
                                controls.storeZipCode.value, controls.storeCity.value, controls.storeCountry.value);

      this.customerService.addCustomer(req).subscribe(
        data => {
          this.form.reset();
          this.storesOfSelectedOwner = [];
        },
        error => {
          this.changeErrorMessage(error.error);
        }
      );
    } else {
      this.changeErrorMessage("Form not valid.");
    }
  }
}
