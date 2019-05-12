import { Component, OnInit, Input } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { FormGroup, FormBuilder } from '@angular/forms';
import { NotificationService } from 'src/app/service/notification-service';
import { OrderNotificationRequest } from 'src/app/model/request/notification/OrderNotificationRequest';

@Component({
  selector: 'app-order-notification-modal',
  templateUrl: './order-notification-modal.component.html',
  styleUrls: ['./order-notification-modal.component.css']
})
export class OrderNotificationModalComponent implements OnInit {

  @Input() orderId: number
  form: FormGroup

  constructor(private modal: NgbActiveModal,
              private formBuilder: FormBuilder,
              private notificationService: NotificationService) { }

  ngOnInit() {
    this.form = this.formBuilder.group({
      dateDocument: [''],
    });
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
