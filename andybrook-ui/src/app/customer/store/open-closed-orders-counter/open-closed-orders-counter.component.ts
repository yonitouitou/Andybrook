import { Component, OnInit, OnChanges, Input } from '@angular/core';
import { OrdersStatisticService } from '../../../service/orders-statistic-service';
import { OpenClosedOrdersCounter } from '../../../model/statistic/OpenClosedOrdersCounter';

@Component({
  selector: 'open-closed-orders-counter',
  templateUrl: './open-closed-orders-counter.component.html',
  styleUrls: ['./open-closed-orders-counter.component.css']
})
export class OpenClosedOrdersCounterComponent implements OnChanges {

  @Input() private storeId: number
  private counters: OpenClosedOrdersCounter

  constructor(private ordersStatisticService: OrdersStatisticService) { }

  ngOnChanges() {
    if (this.storeId != null) {
      this.ordersStatisticService.getOpenClosedOrdersOfStore(this.storeId).subscribe(
        data => {
          this.counters = OpenClosedOrdersCounter.fromJson(data)
        }, error => {
          alert(JSON.stringify(error))
        }
      )
    }
  }

}
