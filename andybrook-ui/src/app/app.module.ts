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
import { OrdersManagerComponent } from './orders-manager-panel/orders-manager/orders-manager.component';
import { StockReportComponent } from './stock-report-panel/stock-report/stock-report.component';
import { OrderService } from './service/order-service';
import { HttpService } from './service/http-service';
import { AdminSettingService } from './service/admin-setting-service';
import { HeaderMenuComponent } from './header-menu/header-menu.component';
import { StockReportHeaderComponent } from './stock-report-panel/stock-report-header/stock-report-header.component';
import { ListOrdersComponent } from './orders-manager-panel/list-orders/list-orders.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AdminPanelComponent } from './admin/admin-panel/admin-panel.component';
import { SharedModule } from './shared.module';
import { CustomerPanelComponent } from './customer/customer-panel/customer-panel.component';
import { NotificationService } from './service/notification-service';
import { AppNavBarComponent } from './app-nav-bar/app-nav-bar.component';
import { ConfirmModalComponent } from './modal/confirm-modal/confirm-modal-component';
import { ModalBuilder } from './common-components/modal-builder';
import { CreateOrderModalComponent } from './modal/create-order-modal/create-order-modal.component';
import { CustomerService } from './service/customer-service';
import { InfoModalComponent } from './modal/info-modal/info-modal.component';
import { ProductService } from './service/product-service';

const appRoutes: Routes = [
  { path: '', component: OrdersManagerComponent },
  { path: 'stockreport/:id', component: StockReportComponent },
  { path: 'admin', component: AdminPanelComponent},
  { path: 'customers', component: CustomerPanelComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    ListStockItemComponent,
    OrdersManagerComponent,
    StockReportComponent,
    HeaderMenuComponent,
    StockReportHeaderComponent,
    ListOrdersComponent,
    AdminPanelComponent,
    CustomerPanelComponent,
    AppNavBarComponent,
    ConfirmModalComponent,
    CreateOrderModalComponent,
    InfoModalComponent,
  ],
  entryComponents: [CreateOrderModalComponent, ConfirmModalComponent, InfoModalComponent],
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
    SharedModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [OrderService, HttpService, AdminSettingService, NotificationService, ModalBuilder, CustomerService, ProductService],
  bootstrap: [AppComponent]
})
export class AppModule { }
