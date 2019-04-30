import { Component, OnInit, ChangeDetectionStrategy } from '@angular/core';
import { OrderService } from '../../service/order-service';
import { OrderItem } from '../../model/OrderItem'
import { Order } from "../../model/Order";
import { ActivatedRoute, Router } from '@angular/router';
import { Customer } from '../../model/Customer';
import { Product } from '../../model/Product'
import { AggregatedOrder } from 'src/app/model/AggregatedOrder';

@Component({
  
  selector: 'show-order',
  templateUrl: './show-order.component.html',
  styleUrls: ['./show-order.component.css'],
  changeDetection: ChangeDetectionStrategy.Default
})
export class ShowOrderComponent implements OnInit {

  reportId: number = 1;
  order: AggregatedOrder;

  constructor(private orderService: OrderService,
              private route: ActivatedRoute,
              private router: Router) { }

  ngOnInit() {
    this.order = new AggregatedOrder();
    let orderId = parseInt(this.route.snapshot.paramMap.get('id'));
    this.refreshOrder(orderId);
  }

  onNewOrderItem(orderItem: OrderItem) {
    //this.order.aggregatedOrderItemsitems.set(orderItem.id, orderItem)
  }

  onChangeOrderItem(orderItem: OrderItem) {
    //this.order.items.set(orderItem.id, orderItem)
  }

  onDeleteOrderItem(id: number) {
    this.refreshOrder(this.order.id);
  }

  onClickBack() {
    this.router.navigate([''])
  }

  private refreshOrder(orderId: number) {
    this.orderService.getOrder(orderId).subscribe(data => {
      this.order = AggregatedOrder.fromJson(data);
    })  
  }
}
