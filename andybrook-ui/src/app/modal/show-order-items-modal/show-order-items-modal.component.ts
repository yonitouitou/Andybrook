import { Component, OnInit, Input } from '@angular/core';
import { OrderItem } from 'src/app/model/OrderItem';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-show-order-items-modal',
  templateUrl: './show-order-items-modal.component.html',
  styleUrls: ['./show-order-items-modal.component.css']
})
export class ShowOrderItemsModalComponent implements OnInit {

  @Input() orderItems: OrderItem[];

  constructor(private modal: NgbActiveModal) { }

  ngOnInit() {
  }

  onClose() {
    this.modal.close(false)
  }
}
