import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatDialogModule } from '@angular/material'
import { MatToolbarModule } from '@angular/material/toolbar';
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
import { HeaderMenuComponent } from './header-menu/header-menu.component';
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
import { CustomerOrdersComponent } from './customer/customer-orders/customer-orders.component';
import { CustomerInfoComponent } from './customer/customer-info/customer-info.component';
import { CustomerHeaderComponent } from './customer/customer-header/customer-header.component';
import { NewCustomerComponent } from './customer/new-customer/new-customer.component';
import { FileUploadModule } from 'ng2-file-upload';
import { OrderNotificationModalComponent } from './modal/order-notification-modal/order-notification-modal.component';
import { UploadProductFileModalComponent } from './modal/upload-product-file-modal/upload-product-file-modal.component';
import { ProductsPanelComponent } from './product/products-panel/products-panel.component';

const appRoutes: Routes = [
  { path: '', component: OrdersManagerComponent },
  { path: 'order/:id', component: ShowOrderComponent },
  { path: 'admin', component: AdminPanelComponent },
  { path: 'new-customer/:id', component: NewCustomerComponent },
  { path: 'customer-dashboard', component: CustomerPanelComponent },
  { path: 'products', component: ProductsPanelComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    ListOrderItemComponent,
    OrdersManagerComponent,
    ShowOrderComponent,
    HeaderMenuComponent,
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
    CustomerOrdersComponent,
    CustomerInfoComponent,
    CustomerHeaderComponent,
    NewCustomerComponent,
    OrderNotificationModalComponent,
    UploadProductFileModalComponent,
    ProductsPanelComponent,
  ],
  entryComponents: [
    CreateOrderModalComponent,
    ConfirmModalComponent,
    InfoModalComponent,
    ShowOrderItemsModalComponent,
    DeleteOrderItemsModalComponent,
    AddOrderItemModalComponent,
    OrderNotificationModalComponent
  ],
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
    FileUploadModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [
    OrderService,
    HttpService,
    AdminSettingService,
    NotificationService,
    ModalBuilder,
    CustomerService,
    ProductService,
    CookieService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
