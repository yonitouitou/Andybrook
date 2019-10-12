import { Component, OnDestroy, OnInit } from '@angular/core';
import { interval, Observable, timer} from 'rxjs';
import { MonitoringService } from '../../service/monitoring-service';
import { ActuatorBasicResponse } from '../../model/monitoring/actuator/ActuatorBasicResponse';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  private cpuUsage: ActuatorBasicResponse
  private cpuSystemCount: ActuatorBasicResponse
  private jvmThreadLive: ActuatorBasicResponse
  private jvmMemoryUsed: ActuatorBasicResponse
  private logFile: string

  private timer: Observable<number> = timer(0, 5000);

  constructor(private monitoringService: MonitoringService) { }

  ngOnInit() {
    this.timer.subscribe(
      event => {
        this.getCpuUsage()
        this.getSystemCpuCount()
        this.getJvmThreadsLive()
        this.getJvmMemoryUsed()
        this.getLogFile()
      }
    )
  }

  private getLogFile(): void {
    this.monitoringService.getServerLogFile().subscribe(
      res => {
        this.logFile = res
      }
    )
  }

  private getJvmMemoryUsed(): void {
    this.monitoringService.getJvmMemoryUsed().subscribe(
      res => {
        this.jvmMemoryUsed = ActuatorBasicResponse.fromJson(res)
      }
    )
  }

  private getJvmThreadsLive(): void {
    this.monitoringService.getJvmThreadsLive().subscribe(
      res => {
        this.jvmThreadLive = ActuatorBasicResponse.fromJson(res)
      }
    )
  }

  private getCpuUsage(): void {
    this.monitoringService.getCpuUsage().subscribe(
      res => {
        this.cpuUsage = ActuatorBasicResponse.fromJson(res)
      }
    )
  }

  private getSystemCpuCount(): void {
    this.monitoringService.getSystemCpuCount().subscribe(
      res => {
        this.cpuSystemCount = ActuatorBasicResponse.fromJson(res)
      }
    )
  }
}
