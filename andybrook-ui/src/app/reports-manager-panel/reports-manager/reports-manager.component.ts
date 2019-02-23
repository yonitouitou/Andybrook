import { Component, OnInit } from '@angular/core';
import { CreateReportModalComponent } from '../create-report-modal/create-report-modal.component'
import { StockReportService } from 'src/app/service/stock-report-service';
import { StockReport } from '../../model/StockReport'
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'reports-manager',
  templateUrl: './reports-manager.component.html',
  styleUrls: ['./reports-manager.component.css']
})
export class ReportsManagerComponent implements OnInit {

  reports: StockReport[] = []
  noOrdersFoundMessage: string
  searchButtonDisabled: boolean = false

  constructor(private stockReportService: StockReportService,
              private modalService: NgbModal,
              ) { }

  ngOnInit() {
    this.stockReportService.getAllStockReports().subscribe(
      data => {
          let reportsReceived = []
          for (let report of data) {
              let sr = StockReport.fromJson(report)
              reportsReceived.push(sr)
          }
          this.reports = reportsReceived
          if (this.reports.length == 0) {
            this.noOrdersFoundMessage = "No order found"
          }
      }
    ) 
  }

  onClickSearch(value: string) {
    if (value.length > 0) {
      this.searchButtonDisabled = true
      this.stockReportService.getStockReportByName(value).subscribe(
        data => {
          let orders: StockReport[] = []
          for (let i = 0; i < data.length ; i++) {
            let item = StockReport.fromJson(data[i]);
            orders.push(item)
          }
          this.reports = orders
          this.searchButtonDisabled = false
        }
      )
    }
  }

  openCreateReportModal() {
    const modalRef = this.modalService.open(CreateReportModalComponent, {
      size: 'lg'
    });
    modalRef.componentInstance.name = 'World'
    
  }

}
