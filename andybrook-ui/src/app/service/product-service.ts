import { Injectable } from '@angular/core';
import { HttpService } from './http-service';
import { Observable } from 'rxjs';

@Injectable()
export class ProductService {

    constructor(private http: HttpService) {
    }

    getAllProductNames(): Observable<string> {
        return this.http.get("/v1/product/getAllExistingProductNames")
    }
}