import { Component, OnInit } from '@angular/core';
import { CreateReportModalComponent } from '../create-report-modal/create-report-modal.component'
import { OrderService } from 'src/app/service/order-service';
import { Order } from "../../model/Order";
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'orders-manager',
  templateUrl: './orders-manager.component.html',
  styleUrls: ['./orders-manager.component.css']
})
export class OrdersManagerComponent implements OnInit {

  orders: Order[] = []
  noOrdersFoundMessage: string
  searchButtonDisabled: boolean = false
  isOrderListFiltered: boolean = false

  constructor(private orderService: OrderService,
              private modalService: NgbModal
              ) { }

  ngOnInit() {
    this.getAllOrders()
  }

  onClickSearch(value: string) {
    if (value.length > 0) {
      this.searchButtonDisabled = true
      this.isOrderListFiltered = true
      this.getOrderByName(value)
    } else if (value.length == 0 && this.isOrderListFiltered) {
      this.searchButtonDisabled = true
      this.getAllOrders()
      this.isOrderListFiltered = false
    }
  }

  private getOrderById(id: number) {
    this.orderService.getOrder(id).subscribe(
      data => {
        this.orders = this.parseOrderIntoArray(data)
        this.searchButtonDisabled = false
      }
    )
  }

  private getOrderByName(name: string) {
    this.orderService.getOrderByName(name).subscribe(
      data => {
        this.orders = this.parseOrderIntoArray(data)
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

  private parseOrderIntoArray(data: any) : Order[] {
    let orders: Order[] = []
    for (let i = 0; i < data.length ; i++) {
      let item = Order.fromJson(data[i]);
      orders.push(item)
    }
    return orders
  }

  openCreateReportModal() {
    const modalRef = this.modalService.open(CreateReportModalComponent, {
      size: 'lg'
    });
    modalRef.componentInstance.name = 'World'
    
  }

}
