import { Component, OnInit, Input } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { OrderService } from 'src/app/service/order-service';
import { Order } from 'src/app/model/Order';


@Component({
  selector: 'close-report-modal',
  templateUrl: './close-report-modal.component.html',
  styleUrls: ['./close-report-modal.component.css']
})
export class CloseReportModalComponent implements OnInit {

  @Input() title: string
  @Input() message: string

  constructor(public modal: NgbActiveModal) { }

  ngOnInit() {
  }

  onClickYes() {
    this.modal.close(true)
  }

  onClickClose() {
    this.modal.close(false)
  }

}
