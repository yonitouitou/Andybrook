import { Component, OnInit } from '@angular/core';
import { CreateReportModalComponent } from '../create-report-modal/create-report-modal.component'
import { StockReportService } from 'src/app/service/stock-report-service';
import { ReportInfo } from 'src/app/model/ReportInfo';
import { ModalBuilderComponent } from 'src/app/common-components/modal-builder-component/modalBuilderComponent';

@Component({
  selector: 'reports-manager',
  templateUrl: './reports-manager.component.html',
  styleUrls: ['./reports-manager.component.css']
})
export class ReportsManagerComponent implements OnInit {

  reports = new Map<number, ReportInfo>()
  reportInfo: ReportInfo

  constructor(private stockReportService: StockReportService,
              private modalBuilder: ModalBuilderComponent,
              ) { }

  ngOnInit() {
    this.stockReportService.getAllStockReports(this.reports)
  }

  openCreateReportModal() {
    this.modalBuilder.open(CreateReportModalComponent)
  }

}
