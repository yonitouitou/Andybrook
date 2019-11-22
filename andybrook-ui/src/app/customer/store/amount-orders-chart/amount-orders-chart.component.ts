import { Component, OnInit, Input } from '@angular/core';
import { OrdersStatisticService } from '../../../service/orders-statistic-service';
import { Label } from 'ng2-charts';
import { ChartDataSets } from 'chart.js';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';

@Component({
  selector: 'amount-orders-chart',
  templateUrl: './amount-orders-chart.component.html',
  styleUrls: ['./amount-orders-chart.component.css']
})
export class AmountOrdersChartComponent implements OnInit {

  @Input() storeId: number

  private xLabels: Label[] = []
  private yValues: ChartDataSets[] = []
  private lastOrdersNb: number = 10
  lastOrdersForm: FormGroup

  constructor(private ordersStatisticService: OrdersStatisticService, private formBuilder: FormBuilder) { }

/*public barChartData: ChartDataSets[] = [
    { data: [65, 59, 80, 81, 56, 55, 40], label: 'Series A' },
    { data: [28, 48, 40, 19, 86, 27, 90], label: 'Series B' }
  ];*/

  ngOnInit() {
    this.initForm()
    this.loadData(10)
  }

  initForm(): void {
    this.lastOrdersForm = this.formBuilder.group({
      lastOrderNumber: [10, [Validators.min(1)]]
    });
  }

  loadData(ordersToLoadNb: number): void {
    let amounts: number[] = []
    this.ordersStatisticService.getLastOrdersOfStore(this.storeId, ordersToLoadNb).subscribe(
      d => {
        for (let item of d.items) {
          this.xLabels.push(item.orderName)
          amounts.push(item.amount)
        }
        this.yValues = [
          { data: amounts, label: 'Amount'},
        ]
      }, error => {
        console.log(JSON.stringify(error))
        alert(JSON.stringify(error))
      }
    )
  }

  onRefresh(): void {
    alert('OnRefresh')
    this.loadData(this.lastOrdersForm.get("lastOrderNumber").value)
  }
}
