import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-app-nav-bar',
  templateUrl: './app-nav-bar.component.html',
  styleUrls: ['./app-nav-bar.component.css']
})
export class AppNavBarComponent implements OnInit {

  isNavbarCollapsed=true;
  
  constructor() { }

  ngOnInit() {
  }

}
