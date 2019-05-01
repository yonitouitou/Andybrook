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

  reportId: number = 1;
  order: AggregatedOrder;

  constructor(private orderService: OrderService,
              private route: ActivatedRoute,
              private router: Router) { }

  ngOnInit() {
    this.order = new AggregatedOrder();
    this.order.id = parseInt(this.route.snapshot.paramMap.get('id'));
    this.refreshOrder();
  }

  onOrderItemAdded(orderItem: OrderItem) {
    this.refreshOrder();
  }

  onChangeOrderItem(orderItem: OrderItem) {
    //this.order.items.set(orderItem.id, orderItem)
  }

  onDeleteOrderItem(id: number) {
    this.refreshOrder();
  }

  onClickBack() {
    this.router.navigate([''])
  }

  private refreshOrder() {
    this.orderService.getOrder(this.order.id).subscribe(data => {
      this.order = AggregatedOrder.fromJson(data);
    })  
  }
}
