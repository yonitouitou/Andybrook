import { Component, OnInit, ChangeDetectionStrategy } from '@angular/core';
import { OrderService } from '../../service/order-service';
import { StockItem } from '../../model/StockItem'
import { Order } from "../../model/Order";
import { ActivatedRoute, Router } from '@angular/router';
import { Customer } from '../../model/Customer';
import { Product } from '../../model/Product'

@Component({
  
  selector: 'stock-report',
  templateUrl: './stock-report.component.html',
  styleUrls: ['./stock-report.component.css'],
  changeDetection: ChangeDetectionStrategy.Default
})
export class StockReportComponent implements OnInit {

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
        let barCodeId
        if (item.barCode != null) {
          barCodeId = item.barCode.id
        }
        let product = new Product(item.product.id, item.product.name, item.product.price)
        let stockItem = new StockItem(item.id, barCodeId, item.quantity, product, item.createdDatetime, item.lastModifiedDatetime)
        this.order.items.set(stockItem.id, stockItem)
      }
  })
  }

  onNewStockItem(stockItemToAdd: StockItem) {
    this.order.items.set(stockItemToAdd.id, stockItemToAdd)
  }

  onChangeStockItem(stockItemToUpdate: StockItem) {
    this.order.items.set(stockItemToUpdate.id, stockItemToUpdate)
  }

  onDeleteStockItem(id: number) {
    this.order.items.delete(id)
  }

  onCloseOrder() {
    this.orderService.closeOrder(this.order)
  }

  onClickBack() {
    this.router.navigate([''])
  }
}
