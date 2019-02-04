import { Component, OnInit } from '@angular/core';
import { StockReportService } from '../service/stock-report-service';
import { StockItem } from '../model/StockItem'
import { StockReport } from '../model/StockReport';

@Component({
  selector: 'stock-report',
  templateUrl: './stock-report.component.html',
  styleUrls: ['./stock-report.component.css']
})
export class StockReportComponent implements OnInit {

  reportId: number = 1
  report: StockReport

  constructor(private stockReportService: StockReportService) { }

  ngOnInit() {
    this.report = new StockReport()
    this.stockReportService.getStockReport(this.report, this.reportId);
  }

  onNewStockItem(stockItemToAdd: StockItem) {
    this.stockReportService.addItem(this.report, stockItemToAdd)

  }

  onChangeStockItem(stockItemToUpdate: StockItem) {
    this.stockReportService.updateStockItem(this.report, stockItemToUpdate)
  }

  onDeleteStockItem(id: number) {
    this.stockReportService.deleteItem(this.report, id)
  }

  onCloseStockReport() {
    this.stockReportService.closeStockReport(this.report)
  }
}
