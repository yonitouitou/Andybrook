import { Injectable } from '@angular/core';
import { HttpService } from './http-service';
import { Observable } from 'rxjs';
import { Product } from '../model/Product';

@Injectable()
export class ProductService {

    constructor(private http: HttpService) {
    }

    get(id: number): Observable<any> {
        return this.http.get("/v1/productItem/get/" + id)
    }

    getAllProductNames(): Observable<any> {
        return this.http.get("/v1/stock/getAllExistingProductNames")
    }

    getProductStockInfo(productId: number): Observable<any> {
        return this.http.get("/v1/stock/productStockInfo/" + productId);
    }

    getProductItemByBarCode(barCode: string): Observable<Product> {
        return this.http.get("/v1/stock/productItemByBarCode/" + barCode);
    }
}
