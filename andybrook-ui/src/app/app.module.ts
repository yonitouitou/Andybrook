import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http'
import { Routes, RouterModule } from '@angular/router'
import { BrowserAnimationsModule, NoopAnimationsModule } from '@angular/platform-browser/animations';
import { AppComponent } from './app.component';
import { ListOrderItemComponent } from './order-panel/list-order-item/list-order-item.component';
import { OrdersManagerComponent } from './orders-manager-panel/orders-manager/orders-manager.component';
import { ShowOrderComponent } from './order-panel/show-order/show-order.component';
import { OrderService } from './service/order-service';
import { HttpService } from './service/http-service';
import { AdminSettingService } from './service/admin-setting-service';
import { OrderHeaderComponent } from './order-panel/show-order-header/show-order-header.component';
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
import { ShowOrderItemsModalComponent } from './modal/show-order-items-modal/show-order-items-modal.component';
import { SelectedOrderItemsListComponent } from './order-panel/selected-order-items-list/selected-order-items-list.component';
import { DeleteOrderItemsModalComponent } from './modal/delete-order-items-modal/delete-order-items-modal.component';
import { AddOrderItemModalComponent } from './modal/add-order-item-modal/add-order-item-modal.component';
import { CookieService } from 'ngx-cookie-service';
import { ListCustomerComponent } from './customer/list-customer/list-customer.component';
import { CustomerInfoComponent } from './customer/customer-info/customer-info.component';
import { CustomerHeaderComponent } from './customer/customer-header/customer-header.component';
import { NewCustomerComponent } from './customer/new-customer/new-customer.component';
import { FileUploadModule } from 'ng2-file-upload';
import { OrderNotificationModalComponent } from './modal/order-notification-modal/order-notification-modal.component';
import { UploadProductFileModalComponent } from './modal/upload-product-file-modal/upload-product-file-modal.component';
import { ProductsPanelComponent } from './product/products-panel/products-panel.component';
import { LoginComponent } from './authentication/login/login.component';
import { LoginService } from './service/login-service';
import { httpInterceptorProviders } from './http-interceptor/Interceptors-manager';
import { DashboardComponent } from './monitoring/dashboard/dashboard.component';
import { MonitoringService } from './service/monitoring-service';
import { StoreDashboardComponent } from './customer/store/store-dashboard/store-dashboard.component';
import { StoreService } from './service/store-service';
import { StoreOrdersComponent } from './customer/store/store-orders/store-orders.component';
import { StoreInfoComponent } from './customer/store/store-info/store-info.component';
import { OrdersStatisticService } from './service/orders-statistic-service';
import { OpenClosedOrdersCounterComponent } from './customer/store/open-closed-orders-counter/open-closed-orders-counter.component';
import { EditStoreInfoModalComponent } from './modal/store/edit-store-info-modal/edit-store-info-modal.component';
import { ToastComponent } from './common-components/toast/toast.component';
import { ToastBuilder } from './common-components/toast/toast-builder';
import { ChartsModule } from 'ng2-charts';
import { BarChartComponent } from './common-components/chart/bar-chart/bar-chart.component';

const appRoutes: Routes = [
  { path: '', component: LoginComponent},
  { path: 'login', component: LoginComponent},
  { path: 'orders', component: OrdersManagerComponent},
  { path: 'order/:id', component: ShowOrderComponent },
  { path: 'admin', component: AdminPanelComponent },
  { path: 'new-customer/:id', component: NewCustomerComponent },
  { path: 'customer-dashboard', component: CustomerPanelComponent },
  { path: 'store/:id', component: StoreDashboardComponent},
  { path: 'products', component: ProductsPanelComponent },
  { path: 'monitoring', component: DashboardComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    ListOrderItemComponent,
    OrdersManagerComponent,
    ShowOrderComponent,
    OrderHeaderComponent,
    ListOrdersComponent,
    AdminPanelComponent,
    CustomerPanelComponent,
    AppNavBarComponent,
    ConfirmModalComponent,
    CreateOrderModalComponent,
    InfoModalComponent,
    ShowOrderItemsModalComponent,
    SelectedOrderItemsListComponent,
    DeleteOrderItemsModalComponent,
    AddOrderItemModalComponent,
    ListCustomerComponent,
    StoreOrdersComponent,
    CustomerInfoComponent,
    CustomerHeaderComponent,
    NewCustomerComponent,
    OrderNotificationModalComponent,
    UploadProductFileModalComponent,
    ProductsPanelComponent,
    LoginComponent,
    DashboardComponent,
    StoreDashboardComponent,
    StoreInfoComponent,
    OpenClosedOrdersCounterComponent,
    EditStoreInfoModalComponent,
    ToastComponent,
    BarChartComponent
  ],
  entryComponents: [
    CreateOrderModalComponent,
    ConfirmModalComponent,
    InfoModalComponent,
    ShowOrderItemsModalComponent,
    DeleteOrderItemsModalComponent,
    AddOrderItemModalComponent,
    EditStoreInfoModalComponent,
    OrderNotificationModalComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    NoopAnimationsModule,
    ReactiveFormsModule,
    NgbModule,
    ChartsModule,
    SharedModule,
    FileUploadModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [
    OrderService,
    OrdersStatisticService,
    HttpService,
    AdminSettingService,
    NotificationService,
    ModalBuilder,
    ToastBuilder,
    CustomerService,
    StoreService,
    ProductService,
    CookieService,
    LoginService,
    MonitoringService,
    httpInterceptorProviders,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
