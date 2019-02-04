import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http'
import { AppComponent } from './app.component';
import { ListStockItemComponent } from './list-stock-item/list-stock-item.component';
import { ReportsManagerComponent } from './reports-manager/reports-manager.component';
import { StockReportService } from './service/stock-report-service';
import { StockReportComponent } from './stock-report/stock-report.component';
import { HttpService } from './service/http-service';
import { HeaderMenuComponent } from './header-menu/header-menu.component';
import { MatToolbarModule } from '@angular/material/toolbar';
import { StockReportHeaderComponent } from './stock-report-header/stock-report-header.component';

@NgModule({
  declarations: [
    AppComponent,
    ListStockItemComponent,
    ReportsManagerComponent,
    StockReportComponent,
    HeaderMenuComponent,
    StockReportHeaderComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    MatToolbarModule
  ],
  providers: [StockReportService, HttpService],
  bootstrap: [AppComponent]
})
export class AppModule { }
