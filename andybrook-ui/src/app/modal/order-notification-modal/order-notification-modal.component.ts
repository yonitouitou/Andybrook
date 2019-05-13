import { Component, OnInit, Input } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { FormGroup, FormBuilder, Validators, FormControl, FormArray } from '@angular/forms';
import { NotificationService } from 'src/app/service/notification-service';
import { OrderNotificationRequest } from 'src/app/model/request/notification/OrderNotificationRequest';
import { JsonPipe } from '@angular/common';

@Component({
  selector: 'app-order-notification-modal',
  templateUrl: './order-notification-modal.component.html',
  styleUrls: ['./order-notification-modal.component.css']
})
export class OrderNotificationModalComponent implements OnInit {

  @Input() orderId: number
  form: FormGroup
  emailInputs: FormArray;
  notificationTypes: string[] = []

  constructor(private modal: NgbActiveModal,
              private formBuilder: FormBuilder,
              private notificationService: NotificationService) { }

  ngOnInit() {
    this.initNotificationTypes();
    this.form = this.formBuilder.group({
      notificationTypesSelect: [this.notificationTypes, Validators.required],
      dateDocument: [],
      emailInputs: this.formBuilder.array([this.createEmailInput])
    });
  }

  private initNotificationTypes() {
    this.notificationService.getNotificationTypes().subscribe(
      data => {
        for (let type of data) {
          this.notificationTypes.push(type);
        }
      },
      error => {
        console.log("Error : Cannot get the notification types : " + error);  
      }
    )
  }

  private createEmailInput(): FormGroup {
    return this.formBuilder.group({
      email: ['', Validators.email]
    });
  }

  addEmailInput() {
    this.emailInputs = this.form.get('emailInputs') as FormArray;
    this.emailInputs.push(this.createEmailInput());
  }

  onSubmit() {
    if (this.form.valid) {
      let dp = this.form.controls.dateDocument.value;
      let dateDocument = new Date(dp.year, dp.month - 1, dp.day);
      let types: string[] = [];
      types.push(this.form.controls.notificationTypesSelect.value);
      let req = new OrderNotificationRequest(types, this.orderId);
      req.dateDocument = dateDocument.getTime();
      this.notificationService.notifyOrder(req).subscribe(
        data => {
          console.log("Notify done : " + data)
          this.modal.close();
        }
      )
    }
  }

  onClose() {
    this.modal.close(false);
  }

}
