import { Component, TemplateRef } from '@angular/core';
import { ToastService } from '../../service/toast.service';

@Component({
  selector: 'toast',
  templateUrl: './toast.component.html',
  styleUrls: ['./toast.component.css'],
  host: {'[class.ngb-toasts]': 'true'}
})
export class ToastComponent {

  constructor(public toastService: ToastService) {}
 
  isTemplate(toast) {
    return toast.textOrTpl instanceof TemplateRef;
  }

}
