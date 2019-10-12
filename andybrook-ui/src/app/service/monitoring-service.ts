import { Injectable } from "@angular/core";
import { HttpService } from "./http-service";
import { Observable } from "rxjs";
import { HttpHeaders } from "@angular/common/http";

@Injectable()
export class MonitoringService {

    private ACTUATOR_URL: string = 'actuator/'
    private ACTUATOR_METRICS_URL: string = this.ACTUATOR_URL + 'metrics/'
    constructor(private httpApi: HttpService) {}

    getCpuUsage(): Observable<any> {
        return this.httpApi.get(this.ACTUATOR_METRICS_URL + 'process.cpu.usage');
    }

    getSystemCpuCount(): Observable<any> {
        return this.httpApi.get(this.ACTUATOR_METRICS_URL + 'system.cpu.count');
    }

    getJvmThreadsLive(): Observable<any> {
        return this.httpApi.get(this.ACTUATOR_METRICS_URL + 'jvm.threads.live');
    }

    getJvmMemoryUsed(): Observable<any> {
        return this.httpApi.get(this.ACTUATOR_METRICS_URL + 'jvm.memory.used');
    }

    getServerLogFile(): Observable<any> {
        let options = {
            responseType: 'text'
        }; 
        return this.httpApi.get(this.ACTUATOR_URL + 'logfile', options);
    }
}