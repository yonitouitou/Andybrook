import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormGroup, FormBuilder, Validators, FormControl, FormArray } from '@angular/forms';
import { LoginRequest } from '../../model/request/login/LoginRequest';
import { LoginService } from '../../service/login-service';
import { Subject } from 'rxjs';
import { debounceTime } from 'rxjs/operators';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  invalidLogin: boolean = false;
  private _errorMessage: string
  private _error = new Subject<string>()
  constructor(private formBuilder: FormBuilder, private router: Router, private loginService: LoginService) { }

  ngOnInit() {
    this._error.subscribe((msg) => this._errorMessage = msg);
    this._error.pipe(debounceTime(2000)).subscribe(() => this._errorMessage = null);
    this.loginForm = this.formBuilder.group({
      username: ['', Validators.compose([Validators.required])],
      password: ['', Validators.required]
    });
  }

  onSubmit() {
    if (this.loginForm.valid) {
      let username = this.loginForm.get("username").value;
      let loginRequest = new LoginRequest(username, this.loginForm.get("password").value)
      this.loginService.authenticate(loginRequest).subscribe(
        data => {
          this.router.navigateByUrl('/orders');
          this.loginService.setUserLoggedIn(true, username);  
        },
        error => {
          this.changeErrorMessage("Invalid credentials");
        }
      )
    }
  }

  private changeErrorMessage(errorMessage: string) {
    this._error.next(errorMessage);
  }

}
