import { Component, OnInit, Input, OnChanges } from '@angular/core';
import { Store } from '../../../model/Store';
import { ActivatedRoute, Router } from '@angular/router';
import { StoreService } from '../../../service/store-service';

@Component({
  selector: 'store-info',
  templateUrl: './store-info.component.html',
  styleUrls: ['./store-info.component.css']
})
export class StoreInfoComponent implements OnChanges {

  @Input()
  private storeId: number
  private store: Store
  
  constructor(private storeService: StoreService) { }

  
  ngOnChanges() {
    if (this.storeId != null) {
      this.storeService.get(this.storeId).subscribe(
        data => {
          this.store = Store.fromJson(data)
        }
      )
    }
  }

}
