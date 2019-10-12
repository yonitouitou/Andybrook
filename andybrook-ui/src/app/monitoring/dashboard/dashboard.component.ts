import { Component, OnDestroy, OnInit } from '@angular/core';
import { interval, Observable, timer} from 'rxjs';
import { MonitoringService } from '../../service/monitoring-service';
import { ActuatorBasicResponse } from '../../model/monitoring/actuator/ActuatorBasicResponse';
import { ActuatorDbHealth } from '../../model/monitoring/actuator/ActuatorDbHealth';
import { ActuatorElasticsearchHealth } from '../../model/monitoring/actuator/ActuatorElasticsearchHealth';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit, OnDestroy {

  private cpuUsage: ActuatorBasicResponse
  private cpuSystemCount: ActuatorBasicResponse
  private elasticsearchHealth: ActuatorElasticsearchHealth
  private jvmThreadLive: ActuatorBasicResponse
  private jvmMemoryUsed: ActuatorBasicResponse
  private jvmMemoryMax: ActuatorBasicResponse
  private dbHealth: ActuatorDbHealth
  private logFile: string
  private cpuUsageWarningLimit: number = 0.85
  private memoryUsageWarningLimit: number

  private timer: Observable<number> = timer(0, 5000);
  private timerSubscription

  constructor(private monitoringService: MonitoringService) { }

  ngOnInit() {
    this.timerSubscription = this.timer.subscribe(
      event => {
        this.getCpuUsage()
        this.getSystemCpuCount()
        this.getJvmThreadsLive()
        this.getJvmMemoryMax()
        this.getJvmMemoryUsed()
        this.getElasticsearchHealth()
        this.getDatabaseHealth()
      }
    ) 
  }

  ngOnDestroy() {
    this.timerSubscription.unsubscribe()
  }

  private getDatabaseHealth(): void {
    this.monitoringService.getDatabaseHealth().subscribe(
      res => {
        this.dbHealth = ActuatorDbHealth.fromJson(res)
      },
      error => {
        this.dbHealth = ActuatorDbHealth.fromJson(error.error)
      }
    )
  }

  private getElasticsearchHealth(): void {
    this.monitoringService.getElasticsearchHealth().subscribe(
      res => {
        this.elasticsearchHealth = ActuatorElasticsearchHealth.fromJson(res)
      },
      error => {
        this.elasticsearchHealth = ActuatorElasticsearchHealth.fromJson(error.error)
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

  private getJvmMemoryMax(): void {
    this.monitoringService.getJvmMemoryMax().subscribe(
      res => {
        this.jvmMemoryMax = ActuatorBasicResponse.fromJson(res)
        this.memoryUsageWarningLimit = Number(this.jvmMemoryMax.values[0]) * 0.85
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

  private getElasticsearchStatus(): string {
    let status;
    if (this.elasticsearchHealth.elasticsearchStatus == 'yellow') {
      status = 'Y'
    } else if (this.elasticsearchHealth.elasticsearchStatus == 'green') {
      status = 'G'
    } else {
      status = 'R'
    }
    return status
  } 

  private getPercentOfCpuUsage(): string {
    return (Number(this.cpuUsage.values[0]) * 100).toFixed(2)
  }

  private getPercentOfMemoryUsed(): string {
    return (((Number(this.jvmMemoryUsed.values[0]) / 1000000) / (Number(this.jvmMemoryMax.values[0]) / 1000000)) * 100).toFixed(2)
  }

  private getMemoryUsedInMb(): string {
    return (Number(this.jvmMemoryUsed.values[0]) / 1000000).toFixed(0)
  }
}
