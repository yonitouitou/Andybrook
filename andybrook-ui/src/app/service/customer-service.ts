import { HttpClient } from 'selenium-webdriver/http';
import { Observable } from 'rxjs';
import { HttpService } from './http-service';
import { Injectable } from '@angular/core';

@Injectable()
export class CustomerService {

    constructor(private http: HttpService) {
    }

    getAllCustomers(): Observable<any> {
        return this.http.get("v1/customer/all");
    }
}