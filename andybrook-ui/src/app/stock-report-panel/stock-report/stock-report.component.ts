import { Component, OnInit } from '@angular/core';
import { StockReportService } from '../../service/stock-report-service';
import { StockItem } from '../../model/StockItem'
import { StockReport } from '../../model/StockReport';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  
  selector: 'stock-report',
  templateUrl: './stock-report.component.html',
  styleUrls: ['./stock-report.component.css']
})
export class StockReportComponent implements OnInit {

  reportId: number = 1
  report: StockReport

  constructor(private stockReportService: StockReportService,
              private route: ActivatedRoute,
              private router: Router) { }

  ngOnInit() {
    this.report = new StockReport()
    let stockReportId = parseInt(this.route.snapshot.paramMap.get('id'))
    this.stockReportService.getStockReport(this.report, stockReportId)
    //this.stockReportService.getStockReport(this.report, this.reportId);
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

  onClickBack() {
    this.router.navigate([''])
}
}
