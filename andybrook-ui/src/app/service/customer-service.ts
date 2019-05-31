
import { Observable } from 'rxjs';
import { HttpService } from './http-service';
import { Injectable } from '@angular/core';
import { AddOrUpdateCustomerReq } from '../model/request/customer/AddOrUpdateCustomerReq';

@Injectable()
export class CustomerService {

    private url: string = "v1/customer";

    constructor(private http: HttpService) {
    }

    addCustomer(req: AddOrUpdateCustomerReq): Observable<any> {
        return this.http.post(this.url + "/add", req);
    }

    updateCustomer(req: AddOrUpdateCustomerReq): Observable<any> {
        return this.http.post(this.url + "/update", req);
    }

    getCustomer(id: number): Observable<any> {
        return this.http.get(this.url + "/get/" + id);
    }
    
    getStoresOfOwner(ownerId: number): Observable<any> {
        return this.http.get(this.url + "/storesOfOwner/" + ownerId);
    }
    
    getAllCustomers(): Observable<any> {
        return this.http.get(this.url + "/all");
    }

    getAllCustomersNoLimit(): Observable<any> {
        return this.http.get(this.url + "/allNoLimit");
    }

    searchCustomerByIdOrNames(input: string): Observable<any> {
        return this.http.get(this.url + "/searchByIdOrName/" + input);
    }

    getAllOwnersIdsAndNames(): Observable<any>{
        return this.http.get(this.url + "/allOwnerIdsAndNames");
    }
}