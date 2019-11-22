import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { LoginService } from '../service/login-service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-app-nav-bar',
  templateUrl: './app-nav-bar.component.html',
  styleUrls: ['./app-nav-bar.component.css']
})
export class AppNavBarComponent implements OnInit {

  isNavbarCollapsed = true;
  isLoggedIn$: Observable<boolean>;     

  constructor(private loginService: LoginService, private router: Router) { }

  ngOnInit() {
    this.isLoggedIn$ = this.loginService.getUserLoggedObservable();
  }

  onLogout() {
    this.loginService.logout().subscribe(
      data => alert(JSON.stringify(data)),
      error => {
        alert(JSON.stringify(error))
      }
    )
    this.router.navigateByUrl('/');
  }
}
