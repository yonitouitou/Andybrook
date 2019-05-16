import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { CustomerService } from 'src/app/service/customer-service';
import { Observable, Subject } from 'rxjs';
import { debounceTime, distinctUntilChanged, map } from 'rxjs/operators';
import { AddCustomerReq } from 'src/app/model/request/customer/AddCustomerReq';
import { Store } from 'src/app/model/Store';
import { ModalBuilder } from 'src/app/common-components/modal-builder';
import { InfoModalComponent } from 'src/app/modal/info-modal/info-modal.component';
import { StringUtil } from 'src/app/util/StringUtil';

@Component({
  selector: 'new-customer',
  templateUrl: './new-customer.component.html',
  styleUrls: ['./new-customer.component.css']
})
export class NewCustomerComponent implements OnInit {

  form: FormGroup
  showCreateOwnerForm: boolean
  inputOwnerName: string
  ownerNames: string[] = []
  ownerIdMapByName: Map<string, number>
  errorMessage: string
  storesOfSelectedOwner: Store[] = []
  private _error = new Subject<string>()

  constructor(private formBuilder: FormBuilder,
              private modalBuilder: ModalBuilder,
              private customerService: CustomerService) {}

  ngOnInit() {
    this.ownerIdMapByName = new Map();
    this.initForm();
    this._error.subscribe((msg) => this.errorMessage = msg);
    this._error.pipe(debounceTime(4000)).subscribe(() => this.errorMessage = null);
  }

  initForm() {
    this.showCreateOwnerForm = false;
    this.loadOwners();
    this.form = this.formBuilder.group({
      ownerAutoComplete: [''],
      isNewOwnerCheckbox: [],
      ownerCompagnyName: [''],
      ownerFirstName: [''],
      ownerLastName: [''],
      ownerEmail: ['', Validators.email],
      storeName: ['', Validators.required],
      storeAddress: [''],
      storeZipCode: [''],
      storeCity: [''],
      storePhone: [''],
      storeEmail: ['', Validators.email]
    });
  }

  loadOwners() {
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

  onClickNewOwnerCheckbox(event) {
    let controls = this.form.controls;
    controls.ownerAutoComplete.reset();
    this.showCreateOwnerForm = event.currentTarget.checked;
    if (this.showCreateOwnerForm) {
      controls.ownerAutoComplete.setValidators(null);
      controls.ownerCompagnyName.setValidators(Validators.required);
    } else {
      controls.ownerAutoComplete.setValidators(Validators.required);
      controls.ownerCompagnyName.setValidators(null);
    }
    this.storesOfSelectedOwner = [];
  }

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
      let ownerId, ownerFirstName, ownerLastName, ownerEmail, ownerCompagnyName;
      let storeName, storeAddress, storePhone, storeEmail;
      if (controls.isNewOwnerCheckbox.value) {
        ownerFirstName = controls.ownerFirstName.value;
        ownerCompagnyName = controls.ownerCompagnyName.value;
        ownerLastName = controls.ownerLastName.value;
        ownerEmail = controls.ownerEmail.value;
      } else {
        ownerId = this.ownerIdMapByName.get(controls.ownerAutoComplete.value);
        if (ownerId == null) {
          // do validator 
        }
      }
      storeName = controls.storeName.value;
      storeAddress = controls.storeAddress.value + ' - ' + controls.storeZipCode.value + ' ' + controls.storeCity.value;
      storePhone = controls.storePhone.value;
      storeEmail = controls.storeEmail.value;
      let req = new AddCustomerReq(ownerId, storeName);
      req.ownerCompagnyName = ownerCompagnyName;
      req.ownerFirstName = ownerFirstName;
      req.ownerLastName = ownerLastName;
      req.ownerEmail = ownerEmail;
      req.storeAddress = storeAddress;
      req.storeEmail = storeEmail;
      req.storePhone = storePhone;
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