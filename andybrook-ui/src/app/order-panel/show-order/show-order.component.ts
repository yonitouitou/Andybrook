import { Component, OnInit, ChangeDetectionStrategy } from '@angular/core';
import { OrderService } from '../../service/order-service';
import { OrderItem } from '../../model/OrderItem'
import { Order } from "../../model/Order";
import { ActivatedRoute, Router } from '@angular/router';
import { Customer } from '../../model/Customer';
import { Product } from '../../model/Product'

@Component({
  
  selector: 'show-order',
  templateUrl: './show-order.component.html',
  styleUrls: ['./show-order.component.css'],
  changeDetection: ChangeDetectionStrategy.Default
})
export class ShowOrderComponent implements OnInit {

  reportId: number = 1
  order: Order

  constructor(private orderService: OrderService,
              private route: ActivatedRoute,
              private router: Router) { }

  ngOnInit() {
    this.order = new Order()
    let orderId = parseInt(this.route.snapshot.paramMap.get('id'))
    this.orderService.getOrder(orderId).subscribe(data => {
      this.order.id = data.id
      this.order.name = data.name
      this.order.comment = data.comment
      this.order.status = data.status
      this.order.customer = Customer.fromJson(data.customer)
      console.log("Order item size in order : " + orderId + " : " + data.items.size)
      for (let item of data.items) {
        let orderItem = OrderItem.fromJson(item);
        this.order.items.set(orderItem.id, orderItem)
      }
  })
  }

  onNewOrderItem(orderItem: OrderItem) {
    this.order.items.set(orderItem.id, orderItem)
  }

  onChangeOrderItem(orderItem: OrderItem) {
    this.order.items.set(orderItem.id, orderItem)
  }

  onDeleteOrderItem(id: number) {
    this.order.items.delete(id)
  }

  onClickBack() {
    this.router.navigate([''])
  }
}
