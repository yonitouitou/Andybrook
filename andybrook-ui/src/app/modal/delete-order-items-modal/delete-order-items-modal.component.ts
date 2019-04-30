import { Component, OnInit, Input } from '@angular/core';
import { OrderItem } from 'src/app/model/OrderItem';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-delete-order-items-modal',
  templateUrl: './delete-order-items-modal.component.html',
  styleUrls: ['./delete-order-items-modal.component.css']
})
export class DeleteOrderItemsModalComponent implements OnInit {

  @Input() title: string
  @Input() orderItems: OrderItem[]

  constructor(public modal: NgbActiveModal) { }

  ngOnInit() {
  }

  onClickYes() {
    this.modal.close(true);
  }

  onClickClose() {
    this.modal.close(false);
  }
}
