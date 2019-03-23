import { Component, OnInit, Input } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-info-modal',
  templateUrl: './info-modal.component.html',
  styleUrls: ['./info-modal.component.css']
})
export class InfoModalComponent implements OnInit {

  @Input() title: string
  @Input() message: string

  constructor(public modal: NgbActiveModal) { }

  ngOnInit() {
  }

  onClickClose() {
    this.modal.close(false)
  }
}
