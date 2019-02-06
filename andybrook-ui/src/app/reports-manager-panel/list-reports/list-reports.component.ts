import { Component, OnInit, Input } from '@angular/core';
import { StockReport } from 'src/app/model/StockReport';

@Component({
  selector: 'list-reports',
  templateUrl: './list-reports.component.html',
  styleUrls: ['./list-reports.component.css']
})
export class ListReportsComponent implements OnInit {

  @Input() reports:Map<number, StockReport>

  constructor() {}

  ngOnInit() {
  }

  onClickSeeReport(id: number) {
    
  }

}
