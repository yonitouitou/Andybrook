import { Injectable } from '@angular/core';
import { HttpService } from './http-service';
import { AdminSetting } from '../model/admin/AdminSetting'
import { Observable } from 'rxjs';


@Injectable()
export class AdminSettingService {

    constructor(private httpApi: HttpService) {}

    getAdminSetting(adminSetting: AdminSetting) : Observable<any> {
        console.log("Get admin setting.");
        return this.httpApi.get("/v1/admin/setting/get")
    }

    updateAdminSetting(adminSetting: AdminSetting): Observable<any> {
        console.log("Update admin setting " + adminSetting);
        return this.httpApi.post("v1/admin/setting/update", adminSetting)
    }
}
