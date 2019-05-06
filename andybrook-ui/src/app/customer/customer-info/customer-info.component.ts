import { Component, OnInit, Input } from '@angular/core';
import { Customer } from 'src/app/model/Customer';

@Component({
  selector: 'customer-info',
  templateUrl: './customer-info.component.html',
  styleUrls: ['./customer-info.component.css']
})
export class CustomerInfoComponent implements OnInit {

  @Input() customer: Customer

  constructor() { }

  ngOnInit() {
  }

}
