import { Component, OnInit, ChangeDetectionStrategy } from '@angular/core';
import { StockReportService } from '../../service/stock-report-service';
import { StockItem } from '../../model/StockItem'
import { StockReport } from '../../model/StockReport';
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
  report: StockReport

  constructor(private stockReportService: StockReportService,
              private route: ActivatedRoute,
              private router: Router) { }

  ngOnInit() {
    this.report = new StockReport()
    let stockReportId = parseInt(this.route.snapshot.paramMap.get('id'))
    this.stockReportService.getStockReport(this.report, stockReportId).subscribe(data => {
      this.report.id = data.id
      this.report.name = data.name
      this.report.comment = data.comment
      this.report.status = data.status
      this.report.customer = Customer.fromJson(data.customer)
      for (let item of data.items) {
        let product = new Product(item.product.id, item.product.name, item.product.price)
        let stockItem = new StockItem(item.id, item.quantity, product)
        this.report.items.set(stockItem.id, stockItem)
      }
  })
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
