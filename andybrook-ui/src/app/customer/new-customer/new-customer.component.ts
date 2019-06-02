import { Component, OnInit, Input, OnChanges, SimpleChanges, Output, EventEmitter } from '@angular/core';
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
  @Output() onUpdateCustomerEvent = new EventEmitter<number>();

  form: FormGroup
  inputOwnerName: string
  ownerNames: string[] = []
  ownerIdMapByName: Map<string, number>
  errorMessage: string
  storesOfSelectedOwner: Store[] = []
  typeAlert: string = 'success'
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
      ownerAutoComplete: this.getStringValue(store.owner.compagnyName),
      ownerFirstName: this.getStringValue(store.owner.firstName),
      ownerLastName: this.getStringValue(store.owner.lastName),
      ownerEmail: this.getStringValue(store.owner.email),
      storeName: this.getStringValue(store.name),
      storeStreetNumber: this.getStringValue(store.address.streetNumber),
      storeStreetName: this.getStringValue(store.address.streetName),
      storeZipCode: this.getNumericValue(store.address.zipCode),
      storeCity: this.getStringValue(store.address.city),
      storeCountry: this.getStringValue(store.address.country),
      storePhone: this.getStringValue(store.phone),
      storeEmail: this.getStringValue(store.email)
    })
  }

  private getStringValue(value: string): string {
    return value.length > 0 || value == 'null' ? value : "";
  }

  private getNumericValue(value: number): string {
    return value <= 0 ? "" : value.toString();
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

  private changeAlertMessage(type: string, errorMessage: string) {
    this.typeAlert = type;
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

      this.sendCustomerRequest(req, this.customer != null)
    } else {
      this.changeAlertMessage("danger", "Form not valid.");
    }
  }

  private sendCustomerRequest(req: AddOrUpdateCustomerReq, isUpdateRequest: boolean) {
    let observable = isUpdateRequest ? this.customerService.updateCustomer(req) : this.customerService.addCustomer(req); 
    observable.subscribe(
      data => {
        this.changeAlertMessage("success", "Customer successfully saved");
        this.onUpdateCustomerEvent.emit(this.customer.id);
      },
      error => {
        this.changeAlertMessage("danger", error.error);
      }
    );
  }
}
