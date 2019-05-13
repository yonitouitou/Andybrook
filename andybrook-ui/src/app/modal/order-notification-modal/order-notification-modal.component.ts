import { Component, OnInit, Input } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
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
  notificationTypes: string[] = []

  constructor(private modal: NgbActiveModal,
              private formBuilder: FormBuilder,
              private notificationService: NotificationService) { }

  ngOnInit() {
    this.initNotificationTypes();
    this.form = this.formBuilder.group({
      notificationTypesSelect: [this.notificationTypes, Validators.required],
      dateDocument: []
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

  onSubmit() {
    let dp = this.form.controls.dateDocument.value;
    let dateDocument = new Date(dp.year, dp.month, dp.day);
    let req = new OrderNotificationRequest(this.orderId);
    req.dateDocument = dateDocument.getTime();
    this.notificationService.notifyOrder(req).subscribe(
       data => {
         console.log("Notify done : " + data)
         this.modal.close();
       }
    )
  }

  onClose() {
    this.modal.close(false);
  }

}
