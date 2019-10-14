import { Component, OnInit, Input } from '@angular/core';
import { FormGroup, Validators, FormBuilder } from '@angular/forms';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Store } from '../../../model/Store';
import { StringUtil } from '../../../util/StringUtil';
import { StoreService } from '../../../service/store-service';
import { Address } from '../../../model/Address';
import { Subject } from 'rxjs';

@Component({
  selector: 'edit-store-info-modal',
  templateUrl: './edit-store-info-modal.component.html',
  styleUrls: ['./edit-store-info-modal.component.css']
})
export class EditStoreInfoModalComponent implements OnInit {

  @Input() store: Store
  private form: FormGroup
  private editInProgress: boolean = false
  private errorMessage: string
  private _error = new Subject<string>()


  constructor(private modal: NgbActiveModal,
              private storeService: StoreService,
              private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.initForm()
  }

  private initForm(): void {
    this.form = this.formBuilder.group({
      name: [this.store.name, Validators.required],
      streetNumber: [this.store.address.streetNumber],
      streetName: [this.store.address.streetName],
      zipCode: [this.store.address.zipCode, [Validators.min(1), Validators.max(999999)]],
      city: [this.store.address.city],
      country: [this.store.address.country],
      phone: [this.store.phone],
      email: [this.store.email, Validators.email]
    })
  }

  onBlurStringFormControl(event) {
    event.srcElement.value = StringUtil.capitalFirstLetter(event.srcElement.value);
  }

  private changeAlertMessage(errorMessage: string) {
    this.errorMessage = errorMessage
    this._error.next(errorMessage);
  }

  onSave(): void {
    if (this.form.valid) {
      this.editInProgress = true
      this.storeService.update(this.createStoreFromForm()).subscribe(
        data => {
          this.onClose(true)
        },
        error => {
          this.editInProgress = false
          this.changeAlertMessage(error.message)
        }
      )
    }
  }

  private createStoreFromForm(): Store {
    let controls = this.form.controls
    let store = new Store()
    store.id = this.store.id
    store.owner = this.store.owner
    store.address = this.createAddress()
    store.name = controls.name.value
    store.email = controls.email.value
    store.phone = controls.phone.value
    return store
  }

  private createAddress(): Address {
    let controls = this.form.controls
    return new Address(controls.streetNumber.value,
                      controls.streetName.value,
                      controls.zipCode.value,
                      controls.city.value,
                      controls.country.value)
  }

  onClose(success: boolean): void {
    this.modal.close(success)
  }
}
