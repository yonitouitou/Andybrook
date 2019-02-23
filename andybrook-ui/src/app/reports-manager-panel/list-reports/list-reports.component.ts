import { Component, OnInit, Input } from '@angular/core';
import { StockReport } from 'src/app/model/StockReport';
import { StockReportService } from 'src/app/service/stock-report-service';
import { ReportsManagerComponent } from '../reports-manager/reports-manager.component';
import { NotificationService } from 'src/app/service/notification-service';

@Component({
  selector: 'list-reports',
  templateUrl: './list-reports.component.html',
  styleUrls: ['./list-reports.component.css']
})
export class ListReportsComponent implements OnInit {

  @Input() reports: StockReport[]

  page: number = 1
  pageSize: number = 4
  collectionSize: number

  constructor(private stockReportService: StockReportService,
              private notificationService: NotificationService) {}

  ngOnInit() {
    this.collectionSize = this.reports.length
  }

  onClickCloseReport(reportInfo: StockReport) {
      this.stockReportService.closeStockReport(reportInfo)
  }

  onClickNotify(orderId: number) {
    this.notificationService.notifyOrder(orderId).subscribe(
      data => console.log("Notify done : " + data)
    )
  }

  get stockReportsArray(): StockReport[] {
    return this.reports
              .slice((this.page - 1) * this.pageSize, (this.page -1) * this.pageSize + this.pageSize)
  }
}
