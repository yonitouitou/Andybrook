import { Component, OnInit, Input } from '@angular/core';
import { StockReport } from 'src/app/model/StockReport';
import { StockReportService } from 'src/app/service/stock-report-service';

@Component({
  selector: 'list-reports',
  templateUrl: './list-reports.component.html',
  styleUrls: ['./list-reports.component.css']
})
export class ListReportsComponent implements OnInit {

  @Input() reports:Map<number, StockReport>

  constructor(private stockReportService: StockReportService) {}

  ngOnInit() {
  }

  onClickCloseReport(reportInfo: StockReport) {
      this.stockReportService.closeStockReport(reportInfo)
  }
}
