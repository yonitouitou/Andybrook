import { Component, OnInit, ChangeDetectionStrategy } from '@angular/core';
import { OrderService } from '../../service/order-service';
import { OrderItem } from '../../model/OrderItem'
import { ActivatedRoute, Router } from '@angular/router';
import { AggregatedOrder } from 'src/app/model/AggregatedOrder';

@Component({
  
  selector: 'show-order',
  templateUrl: './show-order.component.html',
  styleUrls: ['./show-order.component.css'],
  changeDetection: ChangeDetectionStrategy.Default
})
export class ShowOrderComponent implements OnInit {

  order: AggregatedOrder;

  constructor(private orderService: OrderService,
              private route: ActivatedRoute,
              private router: Router) { }

  ngOnInit() {
    this.order = new AggregatedOrder();
    const orderId = parseInt(this.route.snapshot.paramMap.get('id'));
    this.loadOrder(orderId);
  }

  onOrderItemAdded(orderItem: OrderItem) {
    this.refreshOrder();
  }

  onChangeOrderItem(orderItem: OrderItem) {
    //this.order.items.set(orderItem.id, orderItem)
  }

  onDeleteOrderItem(ids: number[]) {
    this.refreshOrder();
  }

  onClickBack() {
    this.router.navigate(['/orders'])
  }

  private loadOrder(orderId: number) {
    this.orderService.getOrder(orderId).subscribe(data => {
      this.order = AggregatedOrder.fromJson(data);
    })  
  }

  private refreshOrder() {
    this.loadOrder(this.order.aggregatedOrderInfo.id) 
  }
}
