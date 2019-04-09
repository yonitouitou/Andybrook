import { Injectable } from '@angular/core';
import { HttpService } from './http-service';
import { Observable } from 'rxjs';
import { Product } from '../model/Product';

@Injectable()
export class ProductService {

    constructor(private http: HttpService) {
    }

    get(id: number): Observable<any> {
        return this.http.get("/v1/product/get/" + id)
    }

    getByBarCode(barCode: string): Observable<Product> {
        return this.http.get("/v1/product/getByBarCode/" + barCode);
    }

    getAllProductNames(): Observable<any> {
        return this.http.get("/v1/product/getAllExistingProductNames")
    }
}