import { Injectable } from '@angular/core';
import { HttpService } from './http-service';
import { Observable } from 'rxjs';

@Injectable()
export class NotificationService {

    constructor(private httpApi: HttpService) {

    }

    notifyOrder(id: number): Observable<any> {
        let request = { "id" : id }
        return this.httpApi.post("v1/notification/report", request)
    }
} 