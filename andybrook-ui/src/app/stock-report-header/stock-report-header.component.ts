import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { StockReport } from '../model/StockReport';

@Component({
  selector: 'stock-report-header',
  templateUrl: './stock-report-header.component.html',
  styleUrls: ['./stock-report-header.component.css']
})
export class StockReportHeaderComponent implements OnInit {

  @Input() report: StockReport

  @Output() onCloseStockReportEvent = new EventEmitter()

  constructor() { }

  ngOnInit() {
  }

  onClickCloseReport() {
    this.onCloseStockReportEvent.emit()
  }
}
