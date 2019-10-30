import { ToastService } from "../../service/toast.service";
import { Injectable } from "@angular/core";

@Injectable()
export class ToastBuilder {

    title = 'ng-bootstrap-demo';

    constructor(private toastService: ToastService) {}
 
    showStandard() {
        this.toastService.show('I am a standard toast', {
            delay: 2000,
            autohide: true
        });
    }

    showSuccess() {
        this.toastService.show('I am a success toast', {
            classname: 'bg-success text-light',
            delay: 2000 ,
            autohide: true,
            headertext: 'Toast Header'
        });
    }

    showError() {
        this.toastService.show('I am a success toast', {
            classname: 'bg-danger text-light',
            delay: 2000 ,
            autohide: true,
            headertext: 'Error!!!'
        });
    }

    showCustomToast(customTpl) {
        this.toastService.show(customTpl, {
            classname: 'bg-info text-light',
            delay: 3000,
            autohide: true
        });
    }

}