import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { Component } from '@angular/compiler/src/core';
import { Injectable } from '@angular/core';

@Injectable()
export class ModalBuilder {

    constructor(private modalService: NgbModal) {

    }

    open(component: any): NgbModalRef  {
        return this.modalService.open(component)
    }

    openCenteredLargeModal(component: any): NgbModalRef {
        return this.modalService.open(component, {size: 'lg', centered: true})
    }

    openCenteredModal(component: any): NgbModalRef {
        return this.modalService.open(component, {centered: true})
    }
}