import { Injectable } from '@angular/core';
import { HttpService } from './http-service';
import { Observable } from 'rxjs';
import { OrderNotificationRequest } from '../model/request/notification/OrderNotificationRequest';

@Injectable()
export class NotificationService {

    private url: string = "v1/notification";

    constructor(private httpApi: HttpService) {}

    notifyOrder(req: OrderNotificationRequest): Observable<any> {
        return this.httpApi.post(this.url + "/order-notification", req);
    }

    getNotificationTypes(): Observable<any> {
        return this.httpApi.get(this.url + "/notification-types");
    }
} 