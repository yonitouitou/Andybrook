import { Component, OnInit } from '@angular/core';
import { OrderService } from 'src/app/service/order-service';
import { ModalBuilder } from 'src/app/common-components/modal-builder';
import { CreateOrderModalComponent } from 'src/app/modal/create-order-modal/create-order-modal.component';
import { AggregatedOrder } from 'src/app/model/AggregatedOrder';

@Component({
  selector: 'orders-manager',
  templateUrl: './orders-manager.component.html',
  styleUrls: ['./orders-manager.component.css']
})
export class OrdersManagerComponent implements OnInit {

  orders: AggregatedOrder[] = []
  noOrdersFoundMessage: string
  searchButtonDisabled: boolean = false
  isOrderListFiltered: boolean = false

  constructor(private orderService: OrderService,
              private modalBuilder: ModalBuilder) { }

  ngOnInit() {
    this.getAllOrders()
  }

  onClickSearch(value: string) {
    if (value.length > 0) {
      this.searchButtonDisabled = true
      this.isOrderListFiltered = true
      this.searchOrderByIdOrName(value)
    } else if (value.length == 0 && this.isOrderListFiltered) {
      this.searchButtonDisabled = true
      this.getAllOrders()
      this.isOrderListFiltered = false
    }
  }

  private searchOrderByIdOrName(name: string) {
    this.orderService.searchOrderByIdOrName(name).subscribe(
      data => {
        this.orders = this.parseOrderIntoArray(data)
        this.searchButtonDisabled = false
      }, error => {
        console.log("error in search : " + error);
        this.orders = [];
        this.searchButtonDisabled = false
      }
    )
  }

  private getAllOrders() {
    this.orderService.getAllOrders().subscribe(
      data => {
          this.orders = this.parseOrderIntoArray(data)
          if (this.orders.length == 0) {
            this.noOrdersFoundMessage = "No order found"
          }
      }
    ) 
  }

  private parseOrderIntoArray(data: any) : AggregatedOrder[] {
    let orders: AggregatedOrder[] = []
    for (let i = 0; i < data.length ; i++) {
      let item = AggregatedOrder.fromJson(data[i]);
      orders.push(item)
    }
    return orders
  }

  openCreateReportModal() {
    const modalRef = this.modalBuilder.open(CreateOrderModalComponent)
  }

}
