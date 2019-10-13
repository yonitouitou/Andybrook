import { Injectable } from "@angular/core";
import { HttpService } from "./http-service";
import { Observable } from "rxjs";

@Injectable()
export class StoreService {

    private STORE_URL: string = '/v1/store'

    constructor(private httpApi: HttpService) {}

    get(id: number): Observable<any> {
        return this.httpApi.get(this.STORE_URL + '/get/' + id)
    }
}