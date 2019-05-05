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

const appRoutes: Routes = [
  { path: '', component: OrdersManagerComponent },
  { path: 'order/:id', component: ShowOrderComponent },
  { path: 'admin', component: AdminPanelComponent},
  { path: 'customers', component: CustomerPanelComponent}
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
  ],
  entryComponents: [
    CreateOrderModalComponent,
    ConfirmModalComponent,
    InfoModalComponent,
    ShowOrderItemsModalComponent,
    DeleteOrderItemsModalComponent,
    AddOrderItemModalComponent
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
