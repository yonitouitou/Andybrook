import { Injectable } from '@angular/core';
import { HttpService } from './http-service';
import { Observable } from 'rxjs';

@Injectable()
export class ProductService {

    constructor(private http: HttpService) {
    }

    get(id: number): Observable<any> {
        return this.http.get("/v1/product/get/" + id)
    }

    getAllProductNames(): Observable<any> {
        return this.http.get("/v1/product/getAllExistingProductNames")
    }
}