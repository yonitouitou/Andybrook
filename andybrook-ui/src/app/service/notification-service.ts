import { Injectable } from '@angular/core';
import { HttpService } from './http-service';
import { Observable } from 'rxjs';
import { OrderNotificationRequest } from '../model/request/notification/OrderNotificationRequest';

@Injectable()
export class NotificationService {

    private url: string = "v1/notification";

    constructor(private httpApi: HttpService) {}

    asyncNotifyOrder(req: OrderNotificationRequest): Observable<any> {
        return this.httpApi.post(this.url + "/async-order-notification", req);
    }

    syncNotifyOrder(req: OrderNotificationRequest): Observable<any> {
        let options = {
            responseType: 'blob',
            observe: 'response'
        }; 
        return this.httpApi.post(this.url + "/sync-order-notification", req, options);
    }

    getNotificationTypes(): Observable<any> {
        return this.httpApi.get(this.url + "/notification-types");
    }
} 