import { Component, OnInit, Input } from '@angular/core';
import { OrderItem } from 'src/app/model/OrderItem';

@Component({
  selector: 'selected-order-items-list',
  templateUrl: './selected-order-items-list.component.html',
  styleUrls: ['./selected-order-items-list.component.css']
})
export class SelectedOrderItemsListComponent implements OnInit {

  @Input() selectedOrderItems: OrderItem[];

  constructor() { }

  ngOnInit() {

  }

}
