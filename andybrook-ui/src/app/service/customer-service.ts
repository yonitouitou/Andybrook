
import { Observable } from 'rxjs';
import { HttpService } from './http-service';
import { Injectable } from '@angular/core';
import { AddCustomerReq } from '../model/request/customer/AddCustomerReq';

@Injectable()
export class CustomerService {

    private url: string = "v1/customer";

    constructor(private http: HttpService) {
    }

    addCustomer(req: AddCustomerReq): Observable<any> {
        return this.http.post(this.url + "/add", req);
    }
    
    getStoresOfOwner(ownerId: number): Observable<any> {
        return this.http.get(this.url + "/storesOfOwner/" + ownerId);
    }
    
    getAllCustomers(): Observable<any> {
        return this.http.get(this.url + "/all");
    }

    searchCustomerByIdOrNames(input: string): Observable<any> {
        return this.http.get(this.url + "/searchByIdOrName/" + input);
    }

    getAllOwnersIdsAndNames(): Observable<any>{
        return this.http.get(this.url + "/allOwnerIdsAndNames");
    }
}