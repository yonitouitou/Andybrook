import { Component, OnInit } from '@angular/core';
import { CreateReportModalComponent } from '../create-report-modal/create-report-modal.component'
import { StockReportService } from 'src/app/service/stock-report-service';
import { StockReport } from '../../model/StockReport'
import { ModalBuilderComponent } from 'src/app/common-components/modal-builder-component/modalBuilderComponent';

@Component({
  selector: 'reports-manager',
  templateUrl: './reports-manager.component.html',
  styleUrls: ['./reports-manager.component.css']
})
export class ReportsManagerComponent implements OnInit {

  reports: StockReport[] = []
  noOrdersFoundMessage: string

  constructor(private stockReportService: StockReportService,
              private modalBuilder: ModalBuilderComponent,
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

  openCreateReportModal() {
    this.modalBuilder.open(CreateReportModalComponent)
  }

}
