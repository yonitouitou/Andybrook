import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatDialogModule } from '@angular/material'
import { MatToolbarModule } from '@angular/material/toolbar';
import { HttpClientModule } from '@angular/common/http'
import { Routes, RouterModule } from '@angular/router'
import { BrowserAnimationsModule, NoopAnimationsModule } from '@angular/platform-browser/animations';
import { AppComponent } from './app.component';
import { ListStockItemComponent } from './stock-report-panel/list-stock-item/list-stock-item.component';
import { ReportsManagerComponent } from './reports-manager-panel/reports-manager/reports-manager.component';
import { StockReportService } from './service/stock-report-service';
import { StockReportComponent } from './stock-report-panel/stock-report/stock-report.component';
import { HttpService } from './service/http-service';
import { HeaderMenuComponent } from './header-menu/header-menu.component';
import { StockReportHeaderComponent } from './stock-report-panel/stock-report-header/stock-report-header.component';
import { ListReportsComponent } from './reports-manager-panel/list-reports/list-reports.component';
import { CreateReportModalComponent } from './reports-manager-panel/create-report-modal/create-report-modal.component';
import { ModalBuilderComponent } from "./common-components/modal-builder-component/modalBuilderComponent";
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AdminPanelComponent } from './admin/admin-panel/admin-panel.component';

const appRoutes: Routes = [
  { path: '', component: ReportsManagerComponent },
  { path: 'stockreport/:id', component: StockReportComponent },
  { path: 'admin', component: AdminPanelComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    ListStockItemComponent,
    ReportsManagerComponent,
    StockReportComponent,
    HeaderMenuComponent,
    StockReportHeaderComponent,
    ListReportsComponent,
    CreateReportModalComponent,
    ModalBuilderComponent,
    AdminPanelComponent
  ],
  entryComponents: [CreateReportModalComponent],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    MatToolbarModule,
    MatDialogModule,
    BrowserAnimationsModule,
    NoopAnimationsModule,
    ReactiveFormsModule,
    NgbModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [StockReportService, HttpService, ModalBuilderComponent],
  bootstrap: [AppComponent]
})
export class AppModule { }
