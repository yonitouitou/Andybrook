import { Component } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'modal-builder-component',
  templateUrl: './modal-builder-component.html',
  styleUrls: ['./modal-builder-component.css']
})
export class ModalBuilderComponent {
  constructor(private modalService: NgbModal) {}

  
  open(component) {
    const modalRef = this.modalService.open(component);
    modalRef.componentInstance.name = 'World';
  }
}
