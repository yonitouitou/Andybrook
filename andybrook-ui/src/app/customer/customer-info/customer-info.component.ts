import { Component, OnInit, Input } from '@angular/core';
import { Store } from '../../model/Store';

@Component({
  selector: 'customer-info',
  templateUrl: './customer-info.component.html',
  styleUrls: ['./customer-info.component.css']
})
export class CustomerInfoComponent implements OnInit {

  @Input() store: Store

  constructor() { }

  ngOnInit() {
  }

}