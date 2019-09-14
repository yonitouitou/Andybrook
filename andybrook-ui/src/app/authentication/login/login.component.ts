import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormGroup, FormBuilder, Validators, FormControl, FormArray } from '@angular/forms';
import { LoginRequest } from '../../model/request/login/LoginRequest';
import { LoginService } from '../../service/login-service';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  invalidLogin: boolean = false;
  constructor(private formBuilder: FormBuilder, private router: Router, private loginService: LoginService) { }

  onSubmit() {
    if (this.loginForm.valid) {
      let loginRequest = new LoginRequest(this.loginForm.get("username").value, this.loginForm.get("password").value)
      this.loginService.authenticate(loginRequest).subscribe(
        data => {
          alert('innnn')
          this.router.navigateByUrl('/orders');  
        },
        error => {
          alert('error')
        }
      )
    }
  }

  ngOnInit() {
    window.sessionStorage.removeItem('token');
    this.loginForm = this.formBuilder.group({
      username: ['', Validators.compose([Validators.required])],
      password: ['', Validators.required]
    });
  }

}
