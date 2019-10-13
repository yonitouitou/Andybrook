import { Component, OnInit } from '@angular/core';
import { Store } from '../../../model/Store';
import { ActivatedRoute, Router } from '@angular/router';
import { StoreService } from '../../../service/store-service';

@Component({
  selector: 'app-store-dashboard',
  templateUrl: './store-dashboard.component.html',
  styleUrls: ['./store-dashboard.component.css']
})
export class StoreDashboardComponent implements OnInit {

  private storeId: number
  
  constructor(private route: ActivatedRoute) {}

  ngOnInit() {
    this.storeId = parseInt(this.route.snapshot.paramMap.get('id'));
  }

}
