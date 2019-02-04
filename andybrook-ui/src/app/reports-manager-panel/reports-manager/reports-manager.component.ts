import { Component, OnInit } from '@angular/core';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';
import { CreateReportModalComponent } from '../create-report-modal/create-report-modal.component'
import { StockReportService } from 'src/app/service/stock-report-service';
import { ReportInfo } from 'src/app/model/ReportInfo';


@Component({
  selector: 'reports-manager',
  templateUrl: './reports-manager.component.html',
  styleUrls: ['./reports-manager.component.css']
})
export class ReportsManagerComponent implements OnInit {

  reports = new Map<number, ReportInfo>()
  reportInfo: ReportInfo

  constructor(private stockReportService: StockReportService, private dialog: MatDialog) { }

  ngOnInit() {
    this.stockReportService.getAllStockReports(this.reports)
  }

  openCreateReportModal() {
    const dialogRef = this.dialog.open(CreateReportModalComponent, {
      width: '250px',
      data: {reportInfo: this.reportInfo}
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      this.reportInfo = result;
    });
  }

}
