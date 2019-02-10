import { Injectable } from '@angular/core';
import { HttpService } from './http-service';
import { AdminSetting } from '../model/admin/AdminSetting'
import { Observable } from 'rxjs';


@Injectable()
export class AdminSettingService {

    constructor(private httpApi: HttpService) {}

    getAdminSetting(adminSetting: AdminSetting) : Observable<any> {
        console.log("Get admin setting.")
        return this.httpApi.get("/v1/admin/setting/get")
    }

    updateAdminSetting(adminSetting: AdminSetting) {
        console.log("Update admin setting " + adminSetting)
        this.httpApi.post("v1/admin/setting/update", adminSetting).subscribe(data => {
            adminSetting.email = data.email
            adminSetting.notifyOnCloseReport = data.notificationPolicy.onCloseReport
        })
    }
}