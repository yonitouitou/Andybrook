import { Component, OnInit, Input } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'confirm-modal',
  templateUrl: './confirm-modal-component.html',
  styleUrls: ['./confirm-modal-component.css']
})
export class ConfirmModalComponent implements OnInit {

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
