import { Component, OnInit, Input } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { FormGroup, FormBuilder, Validators, FormControl, FormArray } from '@angular/forms';
import { NotificationService } from 'src/app/service/notification-service';
import { OrderNotificationRequest } from 'src/app/model/request/notification/OrderNotificationRequest';
import * as fileSaver from 'file-saver'
import { NotificationType } from 'src/app/model/NotificationType';

@Component({
  selector: 'app-order-notification-modal',
  templateUrl: './order-notification-modal.component.html',
  styleUrls: ['./order-notification-modal.component.css']
})
export class OrderNotificationModalComponent implements OnInit {

  @Input() orderId: number
  form: FormGroup
  notificationTypesMapByName: Map<string, NotificationType> = new Map();
  selectedType: NotificationType;
  formatsOfSelectedType: string[];

  constructor(private modal: NgbActiveModal,
              private formBuilder: FormBuilder,
              private notificationService: NotificationService) {}

  ngOnInit() {
    this.initNotificationTypes();
    this.form = this.formBuilder.group({
      notificationTypesSelect: [[], [Validators.required]],
      formats: this.formBuilder.array([]),
      dateDocument: [],
      emailInputs: this.formBuilder.array([])
    });
    const emailInputs = this.form.controls.emailInputs as FormArray;
    emailInputs.push(this.createEmailInput());
  }

  private initNotificationTypes() {
    this.notificationService.getNotificationTypes().subscribe(
      data => {
        for (let i = 0; i < data.length; i++) {
          let notif = NotificationType.fromJson(data[i]);
          this.notificationTypesMapByName.set(notif.type, notif);
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

  private createFormatCheckbox(): FormGroup {
    return this.formBuilder.group({
      format: []
    });
  }

  addFormatCheckbox() {
    let formats = this.form.get('formats') as FormArray;
    formats.push(this.createFormatCheckbox());
  }

  addEmailInput() {
    let emailInputs = this.form.get('emailInputs') as FormArray;
    emailInputs.push(this.createEmailInput());
  }

  onChangeType(event: any) {
    let selectedTypeName = event.target.selectedOptions[0].text;
    if (selectedTypeName != null) {
      this.selectedType = this.notificationTypesMapByName.get(selectedTypeName);
      if (this.selectedType != null) {
        this.formatsOfSelectedType = this.selectedType.supportedFormats;
        for (let i = 0; i < this.formatsOfSelectedType.length; i++) {
          this.addFormatCheckbox()
        }
      } else {
        console.log("Unknown selected type name " + selectedTypeName + ". Known types : " + JSON.stringify(this.notificationTypesMapByName));
      }
    }
  }

  onSubmit() {
    if (this.form.valid) {
      let dp = this.form.controls.dateDocument.value;
      let types: string[] = [];
      types.push(this.form.controls.notificationTypesSelect.value);
      let req = new OrderNotificationRequest(types, this.orderId);
      if (dp != null) {
        req.dateDocument = new Date(dp.year, dp.month - 1, dp.day + 1).getTime();
      }
      req.emails = this.getEmailsFromInputs();
      this.notificationService.syncNotifyOrder(req).subscribe(
        response => {
          this.saveFile(response.body, response.headers.get('filename'), response.headers.get('Content-type'));
          this.modal.close();
        }
      )
    }
  }

  saveFile(data: any, filename?: string, contentType?: string) {
    const blob = new Blob([data], {type: contentType});
    fileSaver.saveAs(blob, filename);
  }

  private getEmailsFromInputs(): string[] {
    let emails: string[] = [];
    let array = this.form.controls.emailInputs as FormArray;
    for (let i = 0; i < array.length; i++) {
      let emailObjValue = array.at(i).value;
      if (emailObjValue.email.length > 0) {
        emails.push(emailObjValue.email);
      }
    }
    return emails;
  }

  onClose() {
    this.modal.close(false);
  }
}
