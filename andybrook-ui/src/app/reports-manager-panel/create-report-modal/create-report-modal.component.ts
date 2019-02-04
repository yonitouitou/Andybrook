import { Component, OnInit, Inject } from '@angular/core';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';
import { ReportInfo } from 'src/app/model/ReportInfo';

@Component({
  selector: 'create-report-modal',
  templateUrl: './create-report-modal.component.html',
  styleUrls: ['./create-report-modal.component.css']
})
export class CreateReportModalComponent implements OnInit {

  constructor(private dialogRef: MatDialogRef<CreateReportModalComponent>,
    @Inject(MAT_DIALOG_DATA) public data: ReportInfo) { }

  ngOnInit() {
  }

  onCancelClick(): void {
    this.dialogRef.close();
  }

}
