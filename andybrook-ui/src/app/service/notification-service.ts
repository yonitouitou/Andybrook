import { Injectable } from '@angular/core';
import { HttpService } from './http-service';
import { Observable } from 'rxjs';
import { OrderNotificationRequest } from '../model/request/notification/OrderNotificationRequest';

@Injectable()
export class NotificationService {

    private url: string = "v1/notification";

    constructor(private httpApi: HttpService) {}

    notify(req: OrderNotificationRequest): Observable<any> {
        let options = {
            responseType: 'blob',
            observe: 'response'
        }; 
        return this.httpApi.post(this.url + "/notify", req, options);
    }

    getDocumentTypes(): Observable<any> {
        return this.httpApi.get(this.url + "/document-types");
    }
} 