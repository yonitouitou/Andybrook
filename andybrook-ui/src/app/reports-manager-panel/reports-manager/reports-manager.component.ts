import { Component, OnInit } from '@angular/core';
import { CreateReportModalComponent } from '../create-report-modal/create-report-modal.component'
import { StockReportService } from 'src/app/service/stock-report-service';
import { StockReport } from '../../model/StockReport'
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'reports-manager',
  templateUrl: './reports-manager.component.html',
  styleUrls: ['./reports-manager.component.css']
})
export class ReportsManagerComponent implements OnInit {

  reports: StockReport[] = []
  noOrdersFoundMessage: string
  searchButtonDisabled: boolean = false
  isOrderListFiltered: boolean = false

  constructor(private stockReportService: StockReportService,
              private modalService: NgbModal,
              private route: ActivatedRoute
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
    this.stockReportService.getStockReport(id).subscribe(
      data => {
        this.reports = this.parseOrderIntoArray(data)
        this.searchButtonDisabled = false
      }
    )
  }

  private getOrderByName(name: string) {
    this.stockReportService.getStockReportByName(name).subscribe(
      data => {
        this.reports = this.parseOrderIntoArray(data)
        this.searchButtonDisabled = false
      }
    )
  }

  private getAllOrders() {
    this.stockReportService.getAllStockReports().subscribe(
      data => {
          this.reports = this.parseOrderIntoArray(data)
          if (this.reports.length == 0) {
            this.noOrdersFoundMessage = "No order found"
          }
      }
    ) 
  }

  private parseOrderIntoArray(data: any) : StockReport[] {
    let orders: StockReport[] = []
    for (let i = 0; i < data.length ; i++) {
      let item = StockReport.fromJson(data[i]);
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
