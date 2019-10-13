import { Injectable } from "@angular/core";
import { HttpService } from "./http-service";
import { Observable } from "rxjs";

@Injectable()
export class OrdersStatisticService {

    private ORDERS_STATISTIC_URL = "/v1/os"

    constructor(private httpApi: HttpService) {}

    getOpenClosedOrdersOfStore(storeId: number): Observable<any> {
        return this.httpApi.get(this.ORDERS_STATISTIC_URL + "/openClosedByStore/" + storeId)
    }
}