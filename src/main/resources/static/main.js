(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["main"],{

/***/ "./src/$$_lazy_route_resource lazy recursive":
/*!**********************************************************!*\
  !*** ./src/$$_lazy_route_resource lazy namespace object ***!
  \**********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

function webpackEmptyAsyncContext(req) {
	// Here Promise.resolve().then() is used instead of new Promise() to prevent
	// uncaught exception popping up in devtools
	return Promise.resolve().then(function() {
		var e = new Error("Cannot find module '" + req + "'");
		e.code = 'MODULE_NOT_FOUND';
		throw e;
	});
}
webpackEmptyAsyncContext.keys = function() { return []; };
webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
module.exports = webpackEmptyAsyncContext;
webpackEmptyAsyncContext.id = "./src/$$_lazy_route_resource lazy recursive";

/***/ }),

/***/ "./src/app/admin/admin-panel/admin-panel.component.css":
/*!*************************************************************!*\
  !*** ./src/app/admin/admin-panel/admin-panel.component.css ***!
  \*************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL2FkbWluL2FkbWluLXBhbmVsL2FkbWluLXBhbmVsLmNvbXBvbmVudC5jc3MifQ== */"

/***/ }),

/***/ "./src/app/admin/admin-panel/admin-panel.component.html":
/*!**************************************************************!*\
  !*** ./src/app/admin/admin-panel/admin-panel.component.html ***!
  \**************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container-fluid\">\n    <form [formGroup]=\"adminForm\" (ngSubmit)=\"onSubmit()\">\n      <div class=\"form-group\">\n          <label class=\"form-check-label\" for=\"exampleCheck1\">Notification &nbsp;</label>\n          <input type=\"checkbox\" formControlName=\"notification\" class=\"form-check-input\" (input)=\"settingChanged()\">\n      </div>\n      <div class=\"form-group\">\n        <label for=\"Email\">Email addresses\n          <span style=\"font-size: 80%; font-style: italic\">(Use comma ',' delimiter for multiple emails)</span\n        ></label>\n        <input type=\"text\" formControlName=\"emails\"\n          (input)=\"settingChanged()\"\n          class=\"form-control\"\n        />\n      </div>\n      <div class=\"form-group\">\n        <label for=\"ordersNbToShow\">Orders number to show by default</label>\n        <input type=\"text\" formControlName=\"ordersNbToShow\"\n          (input)=\"settingChanged()\"\n          class=\"form-control\"\n        />\n      </div>\n      <div class=\"form-group\">\n        <button type=\"submit\" class=\"btn btn-primary\" [disabled]=\"saveButtonDisabled\">Save</button>\n      </div>\n    </form>\n    <ngb-alert *ngIf=\"alertMessage\" type=\"success\" (close)=\"alertMessage = null\">{{ alertMessage }}</ngb-alert>\n</div>"

/***/ }),

/***/ "./src/app/admin/admin-panel/admin-panel.component.ts":
/*!************************************************************!*\
  !*** ./src/app/admin/admin-panel/admin-panel.component.ts ***!
  \************************************************************/
/*! exports provided: AdminPanelComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AdminPanelComponent", function() { return AdminPanelComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _service_admin_setting_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../service/admin-setting-service */ "./src/app/service/admin-setting-service.ts");
/* harmony import */ var src_app_model_admin_AdminSetting__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! src/app/model/admin/AdminSetting */ "./src/app/model/admin/AdminSetting.ts");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");







var AdminPanelComponent = /** @class */ (function () {
    function AdminPanelComponent(formBuilder, adminSettingService) {
        this.formBuilder = formBuilder;
        this.adminSettingService = adminSettingService;
        this._success = new rxjs__WEBPACK_IMPORTED_MODULE_5__["Subject"]();
        this.submitted = false;
        this.saveButtonDisabled = true;
    }
    AdminPanelComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.adminForm = this.formBuilder.group({
            notification: [],
            ordersNbToShow: ['', _angular_forms__WEBPACK_IMPORTED_MODULE_4__["Validators"].min(1)],
            emails: ['', [_angular_forms__WEBPACK_IMPORTED_MODULE_4__["Validators"].required]]
        });
        this.adminSetting = new src_app_model_admin_AdminSetting__WEBPACK_IMPORTED_MODULE_3__["AdminSetting"]();
        this.adminSettingService.getAdminSetting(this.adminSetting)
            .subscribe(function (data) {
            _this.adminSetting.emails = data.emails;
            _this.adminSetting.ordersNbToShow = data.ordersNbToShow;
            _this.adminSetting.notifyOnCloseReport = data.notificationPolicy.onCloseReport;
            _this.adminForm.setValue({
                notification: _this.adminSetting.notifyOnCloseReport,
                emails: _this.adminSetting.emails.join(),
                ordersNbToShow: _this.adminSetting.ordersNbToShow
            });
        });
        this._success.subscribe(function (msg) { return _this.alertMessage = msg; });
        this._success.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_6__["debounceTime"])(5000)).subscribe(function () { return _this.alertMessage = null; });
    };
    AdminPanelComponent.prototype.changeAlertMessage = function () {
        this._success.next("Setting saved successully");
    };
    AdminPanelComponent.prototype.settingChanged = function () {
        this.saveButtonDisabled = false;
    };
    AdminPanelComponent.prototype.settingSaved = function (successfully) {
        this.saveButtonDisabled = true;
        this.changeAlertMessage();
    };
    Object.defineProperty(AdminPanelComponent.prototype, "f", {
        // convenience getter for easy access to form fields
        get: function () { return this.adminForm.controls; },
        enumerable: true,
        configurable: true
    });
    AdminPanelComponent.prototype.onSubmit = function () {
        var _this = this;
        this.submitted = true;
        if (this.adminForm.invalid) {
            return;
        }
        var values = this.adminForm.value;
        this.adminSetting.emails = values.emails.split(",");
        this.adminSetting.ordersNbToShow = values.ordersNbToShow;
        this.adminSetting.notifyOnCloseReport = values.notification;
        this.adminSettingService.updateAdminSetting(this.adminSetting).subscribe(function (data) {
            _this.adminSetting.emails = data.emails;
            _this.adminSetting.ordersNbToShow = data.ordersNbToShow;
            _this.adminSetting.notifyOnCloseReport = data.notificationPolicy.onCloseReport;
            _this.settingSaved(true);
        });
    };
    AdminPanelComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'admin-panel',
            template: __webpack_require__(/*! ./admin-panel.component.html */ "./src/app/admin/admin-panel/admin-panel.component.html"),
            styles: [__webpack_require__(/*! ./admin-panel.component.css */ "./src/app/admin/admin-panel/admin-panel.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_angular_forms__WEBPACK_IMPORTED_MODULE_4__["FormBuilder"],
            _service_admin_setting_service__WEBPACK_IMPORTED_MODULE_2__["AdminSettingService"]])
    ], AdminPanelComponent);
    return AdminPanelComponent;
}());



/***/ }),

/***/ "./src/app/app-nav-bar/app-nav-bar.component.css":
/*!*******************************************************!*\
  !*** ./src/app/app-nav-bar/app-nav-bar.component.css ***!
  \*******************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL2FwcC1uYXYtYmFyL2FwcC1uYXYtYmFyLmNvbXBvbmVudC5jc3MifQ== */"

/***/ }),

/***/ "./src/app/app-nav-bar/app-nav-bar.component.html":
/*!********************************************************!*\
  !*** ./src/app/app-nav-bar/app-nav-bar.component.html ***!
  \********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<nav class=\"navbar navbar-expand-md navbar-dark bg-primary fixed-top\">\n    <a class=\"navbar-brand\" href=\"#\">Andybrook</a>\n    <button class=\"navbar-toggler hidden-sm-up\" type=\"button\" (click)=\"isNavbarCollapsed = !isNavbarCollapsed\" data-target=\"#navbarsDefault\" aria-controls=\"navbarsDefault\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n      <span class=\"navbar-toggler-icon\"></span>\n    </button>\n    <div [ngbCollapse]=\"isNavbarCollapsed\" class=\"collapse navbar-collapse\" id=\"navbarsDefault\">\n      <ul class=\"navbar-nav mr-auto\">\n        <li class=\"nav-item\">\n          <a class=\"nav-link\"\n             routerLinkActive=\"active\"\n             [routerLinkActiveOptions]=\"{exact: true}\"\n             routerLink=\"/\"\n          >Home</a>\n        </li>\n        <li class=\"nav-item dropdown\" ngbDropdown>\n          <a class=\"nav-link dropdown-toggle\" id=\"id01\" ngbDropdownToggle>Customers</a>\n          <div class=\"dropdown-menu\" aria-labelledby=\"id01\" ngbDropdownMenu>\n            <a class=\"dropdown-item\" routerLink=\"/customer-dashboard\">Dashboard</a>\n            <a class=\"dropdown-item\" routerLink=\"/new-customer\">New Customer</a>\n          </div>\n        </li>\n        <li class=\"nav-item\">\n          <a class=\"nav-link\"\n             routerLink=\"/admin\"\n          >Admin</a>\n        </li>\n      </ul>\n    </div>\n  </nav>"

/***/ }),

/***/ "./src/app/app-nav-bar/app-nav-bar.component.ts":
/*!******************************************************!*\
  !*** ./src/app/app-nav-bar/app-nav-bar.component.ts ***!
  \******************************************************/
/*! exports provided: AppNavBarComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppNavBarComponent", function() { return AppNavBarComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");


var AppNavBarComponent = /** @class */ (function () {
    function AppNavBarComponent() {
        this.isNavbarCollapsed = true;
    }
    AppNavBarComponent.prototype.ngOnInit = function () {
    };
    AppNavBarComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-app-nav-bar',
            template: __webpack_require__(/*! ./app-nav-bar.component.html */ "./src/app/app-nav-bar/app-nav-bar.component.html"),
            styles: [__webpack_require__(/*! ./app-nav-bar.component.css */ "./src/app/app-nav-bar/app-nav-bar.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [])
    ], AppNavBarComponent);
    return AppNavBarComponent;
}());



/***/ }),

/***/ "./src/app/app.component.css":
/*!***********************************!*\
  !*** ./src/app/app.component.css ***!
  \***********************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL2FwcC5jb21wb25lbnQuY3NzIn0= */"

/***/ }),

/***/ "./src/app/app.component.html":
/*!************************************!*\
  !*** ./src/app/app.component.html ***!
  \************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<app-app-nav-bar></app-app-nav-bar>\n<br>\n<br>\n<br>\n<div class=\"container-fluid\">\n    <router-outlet></router-outlet>\n</div>\n\n"

/***/ }),

/***/ "./src/app/app.component.ts":
/*!**********************************!*\
  !*** ./src/app/app.component.ts ***!
  \**********************************/
/*! exports provided: AppComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppComponent", function() { return AppComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");


var AppComponent = /** @class */ (function () {
    function AppComponent() {
    }
    AppComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-root',
            template: __webpack_require__(/*! ./app.component.html */ "./src/app/app.component.html"),
            styles: [__webpack_require__(/*! ./app.component.css */ "./src/app/app.component.css")]
        })
    ], AppComponent);
    return AppComponent;
}());



/***/ }),

/***/ "./src/app/app.module.ts":
/*!*******************************!*\
  !*** ./src/app/app.module.ts ***!
  \*******************************/
/*! exports provided: AppModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppModule", function() { return AppModule; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_platform_browser__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/platform-browser */ "./node_modules/@angular/platform-browser/fesm5/platform-browser.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm5/material.es5.js");
/* harmony import */ var _angular_material_toolbar__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/material/toolbar */ "./node_modules/@angular/material/esm5/toolbar.es5.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _angular_platform_browser_animations__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @angular/platform-browser/animations */ "./node_modules/@angular/platform-browser/fesm5/animations.js");
/* harmony import */ var _app_component__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ./app.component */ "./src/app/app.component.ts");
/* harmony import */ var _order_panel_list_order_item_list_order_item_component__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ./order-panel/list-order-item/list-order-item.component */ "./src/app/order-panel/list-order-item/list-order-item.component.ts");
/* harmony import */ var _orders_manager_panel_orders_manager_orders_manager_component__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ./orders-manager-panel/orders-manager/orders-manager.component */ "./src/app/orders-manager-panel/orders-manager/orders-manager.component.ts");
/* harmony import */ var _order_panel_show_order_show_order_component__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! ./order-panel/show-order/show-order.component */ "./src/app/order-panel/show-order/show-order.component.ts");
/* harmony import */ var _service_order_service__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! ./service/order-service */ "./src/app/service/order-service.ts");
/* harmony import */ var _service_http_service__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! ./service/http-service */ "./src/app/service/http-service.ts");
/* harmony import */ var _service_admin_setting_service__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! ./service/admin-setting-service */ "./src/app/service/admin-setting-service.ts");
/* harmony import */ var _header_menu_header_menu_component__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__(/*! ./header-menu/header-menu.component */ "./src/app/header-menu/header-menu.component.ts");
/* harmony import */ var _order_panel_show_order_header_show_order_header_component__WEBPACK_IMPORTED_MODULE_17__ = __webpack_require__(/*! ./order-panel/show-order-header/show-order-header.component */ "./src/app/order-panel/show-order-header/show-order-header.component.ts");
/* harmony import */ var _orders_manager_panel_list_orders_list_orders_component__WEBPACK_IMPORTED_MODULE_18__ = __webpack_require__(/*! ./orders-manager-panel/list-orders/list-orders.component */ "./src/app/orders-manager-panel/list-orders/list-orders.component.ts");
/* harmony import */ var _ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_19__ = __webpack_require__(/*! @ng-bootstrap/ng-bootstrap */ "./node_modules/@ng-bootstrap/ng-bootstrap/fesm5/ng-bootstrap.js");
/* harmony import */ var _admin_admin_panel_admin_panel_component__WEBPACK_IMPORTED_MODULE_20__ = __webpack_require__(/*! ./admin/admin-panel/admin-panel.component */ "./src/app/admin/admin-panel/admin-panel.component.ts");
/* harmony import */ var _shared_module__WEBPACK_IMPORTED_MODULE_21__ = __webpack_require__(/*! ./shared.module */ "./src/app/shared.module.ts");
/* harmony import */ var _customer_customer_panel_customer_panel_component__WEBPACK_IMPORTED_MODULE_22__ = __webpack_require__(/*! ./customer/customer-panel/customer-panel.component */ "./src/app/customer/customer-panel/customer-panel.component.ts");
/* harmony import */ var _service_notification_service__WEBPACK_IMPORTED_MODULE_23__ = __webpack_require__(/*! ./service/notification-service */ "./src/app/service/notification-service.ts");
/* harmony import */ var _app_nav_bar_app_nav_bar_component__WEBPACK_IMPORTED_MODULE_24__ = __webpack_require__(/*! ./app-nav-bar/app-nav-bar.component */ "./src/app/app-nav-bar/app-nav-bar.component.ts");
/* harmony import */ var _modal_confirm_modal_confirm_modal_component__WEBPACK_IMPORTED_MODULE_25__ = __webpack_require__(/*! ./modal/confirm-modal/confirm-modal-component */ "./src/app/modal/confirm-modal/confirm-modal-component.ts");
/* harmony import */ var _common_components_modal_builder__WEBPACK_IMPORTED_MODULE_26__ = __webpack_require__(/*! ./common-components/modal-builder */ "./src/app/common-components/modal-builder.ts");
/* harmony import */ var _modal_create_order_modal_create_order_modal_component__WEBPACK_IMPORTED_MODULE_27__ = __webpack_require__(/*! ./modal/create-order-modal/create-order-modal.component */ "./src/app/modal/create-order-modal/create-order-modal.component.ts");
/* harmony import */ var _service_customer_service__WEBPACK_IMPORTED_MODULE_28__ = __webpack_require__(/*! ./service/customer-service */ "./src/app/service/customer-service.ts");
/* harmony import */ var _modal_info_modal_info_modal_component__WEBPACK_IMPORTED_MODULE_29__ = __webpack_require__(/*! ./modal/info-modal/info-modal.component */ "./src/app/modal/info-modal/info-modal.component.ts");
/* harmony import */ var _service_product_service__WEBPACK_IMPORTED_MODULE_30__ = __webpack_require__(/*! ./service/product-service */ "./src/app/service/product-service.ts");
/* harmony import */ var _modal_show_order_items_modal_show_order_items_modal_component__WEBPACK_IMPORTED_MODULE_31__ = __webpack_require__(/*! ./modal/show-order-items-modal/show-order-items-modal.component */ "./src/app/modal/show-order-items-modal/show-order-items-modal.component.ts");
/* harmony import */ var _order_panel_selected_order_items_list_selected_order_items_list_component__WEBPACK_IMPORTED_MODULE_32__ = __webpack_require__(/*! ./order-panel/selected-order-items-list/selected-order-items-list.component */ "./src/app/order-panel/selected-order-items-list/selected-order-items-list.component.ts");
/* harmony import */ var _modal_delete_order_items_modal_delete_order_items_modal_component__WEBPACK_IMPORTED_MODULE_33__ = __webpack_require__(/*! ./modal/delete-order-items-modal/delete-order-items-modal.component */ "./src/app/modal/delete-order-items-modal/delete-order-items-modal.component.ts");
/* harmony import */ var _modal_add_order_item_modal_add_order_item_modal_component__WEBPACK_IMPORTED_MODULE_34__ = __webpack_require__(/*! ./modal/add-order-item-modal/add-order-item-modal.component */ "./src/app/modal/add-order-item-modal/add-order-item-modal.component.ts");
/* harmony import */ var ngx_cookie_service__WEBPACK_IMPORTED_MODULE_35__ = __webpack_require__(/*! ngx-cookie-service */ "./node_modules/ngx-cookie-service/index.js");
/* harmony import */ var _customer_list_customer_list_customer_component__WEBPACK_IMPORTED_MODULE_36__ = __webpack_require__(/*! ./customer/list-customer/list-customer.component */ "./src/app/customer/list-customer/list-customer.component.ts");
/* harmony import */ var _customer_customer_orders_customer_orders_component__WEBPACK_IMPORTED_MODULE_37__ = __webpack_require__(/*! ./customer/customer-orders/customer-orders.component */ "./src/app/customer/customer-orders/customer-orders.component.ts");
/* harmony import */ var _customer_customer_info_customer_info_component__WEBPACK_IMPORTED_MODULE_38__ = __webpack_require__(/*! ./customer/customer-info/customer-info.component */ "./src/app/customer/customer-info/customer-info.component.ts");
/* harmony import */ var _customer_customer_header_customer_header_component__WEBPACK_IMPORTED_MODULE_39__ = __webpack_require__(/*! ./customer/customer-header/customer-header.component */ "./src/app/customer/customer-header/customer-header.component.ts");
/* harmony import */ var _customer_new_customer_new_customer_component__WEBPACK_IMPORTED_MODULE_40__ = __webpack_require__(/*! ./customer/new-customer/new-customer.component */ "./src/app/customer/new-customer/new-customer.component.ts");









































var appRoutes = [
    { path: '', component: _orders_manager_panel_orders_manager_orders_manager_component__WEBPACK_IMPORTED_MODULE_11__["OrdersManagerComponent"] },
    { path: 'order/:id', component: _order_panel_show_order_show_order_component__WEBPACK_IMPORTED_MODULE_12__["ShowOrderComponent"] },
    { path: 'admin', component: _admin_admin_panel_admin_panel_component__WEBPACK_IMPORTED_MODULE_20__["AdminPanelComponent"] },
    { path: 'new-customer', component: _customer_new_customer_new_customer_component__WEBPACK_IMPORTED_MODULE_40__["NewCustomerComponent"] },
    { path: 'customer-dashboard', component: _customer_customer_panel_customer_panel_component__WEBPACK_IMPORTED_MODULE_22__["CustomerPanelComponent"] }
];
var AppModule = /** @class */ (function () {
    function AppModule() {
    }
    AppModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_2__["NgModule"])({
            declarations: [
                _app_component__WEBPACK_IMPORTED_MODULE_9__["AppComponent"],
                _order_panel_list_order_item_list_order_item_component__WEBPACK_IMPORTED_MODULE_10__["ListOrderItemComponent"],
                _orders_manager_panel_orders_manager_orders_manager_component__WEBPACK_IMPORTED_MODULE_11__["OrdersManagerComponent"],
                _order_panel_show_order_show_order_component__WEBPACK_IMPORTED_MODULE_12__["ShowOrderComponent"],
                _header_menu_header_menu_component__WEBPACK_IMPORTED_MODULE_16__["HeaderMenuComponent"],
                _order_panel_show_order_header_show_order_header_component__WEBPACK_IMPORTED_MODULE_17__["OrderHeaderComponent"],
                _orders_manager_panel_list_orders_list_orders_component__WEBPACK_IMPORTED_MODULE_18__["ListOrdersComponent"],
                _admin_admin_panel_admin_panel_component__WEBPACK_IMPORTED_MODULE_20__["AdminPanelComponent"],
                _customer_customer_panel_customer_panel_component__WEBPACK_IMPORTED_MODULE_22__["CustomerPanelComponent"],
                _app_nav_bar_app_nav_bar_component__WEBPACK_IMPORTED_MODULE_24__["AppNavBarComponent"],
                _modal_confirm_modal_confirm_modal_component__WEBPACK_IMPORTED_MODULE_25__["ConfirmModalComponent"],
                _modal_create_order_modal_create_order_modal_component__WEBPACK_IMPORTED_MODULE_27__["CreateOrderModalComponent"],
                _modal_info_modal_info_modal_component__WEBPACK_IMPORTED_MODULE_29__["InfoModalComponent"],
                _modal_show_order_items_modal_show_order_items_modal_component__WEBPACK_IMPORTED_MODULE_31__["ShowOrderItemsModalComponent"],
                _order_panel_selected_order_items_list_selected_order_items_list_component__WEBPACK_IMPORTED_MODULE_32__["SelectedOrderItemsListComponent"],
                _modal_delete_order_items_modal_delete_order_items_modal_component__WEBPACK_IMPORTED_MODULE_33__["DeleteOrderItemsModalComponent"],
                _modal_add_order_item_modal_add_order_item_modal_component__WEBPACK_IMPORTED_MODULE_34__["AddOrderItemModalComponent"],
                _customer_list_customer_list_customer_component__WEBPACK_IMPORTED_MODULE_36__["ListCustomerComponent"],
                _customer_customer_orders_customer_orders_component__WEBPACK_IMPORTED_MODULE_37__["CustomerOrdersComponent"],
                _customer_customer_info_customer_info_component__WEBPACK_IMPORTED_MODULE_38__["CustomerInfoComponent"],
                _customer_customer_header_customer_header_component__WEBPACK_IMPORTED_MODULE_39__["CustomerHeaderComponent"],
                _customer_new_customer_new_customer_component__WEBPACK_IMPORTED_MODULE_40__["NewCustomerComponent"],
            ],
            entryComponents: [
                _modal_create_order_modal_create_order_modal_component__WEBPACK_IMPORTED_MODULE_27__["CreateOrderModalComponent"],
                _modal_confirm_modal_confirm_modal_component__WEBPACK_IMPORTED_MODULE_25__["ConfirmModalComponent"],
                _modal_info_modal_info_modal_component__WEBPACK_IMPORTED_MODULE_29__["InfoModalComponent"],
                _modal_show_order_items_modal_show_order_items_modal_component__WEBPACK_IMPORTED_MODULE_31__["ShowOrderItemsModalComponent"],
                _modal_delete_order_items_modal_delete_order_items_modal_component__WEBPACK_IMPORTED_MODULE_33__["DeleteOrderItemsModalComponent"],
                _modal_add_order_item_modal_add_order_item_modal_component__WEBPACK_IMPORTED_MODULE_34__["AddOrderItemModalComponent"]
            ],
            imports: [
                _angular_platform_browser__WEBPACK_IMPORTED_MODULE_1__["BrowserModule"],
                _angular_common_http__WEBPACK_IMPORTED_MODULE_6__["HttpClientModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_3__["FormsModule"],
                _angular_material_toolbar__WEBPACK_IMPORTED_MODULE_5__["MatToolbarModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_4__["MatDialogModule"],
                _angular_platform_browser_animations__WEBPACK_IMPORTED_MODULE_8__["BrowserAnimationsModule"],
                _angular_platform_browser_animations__WEBPACK_IMPORTED_MODULE_8__["NoopAnimationsModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_3__["ReactiveFormsModule"],
                _ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_19__["NgbModule"],
                _shared_module__WEBPACK_IMPORTED_MODULE_21__["SharedModule"],
                _angular_router__WEBPACK_IMPORTED_MODULE_7__["RouterModule"].forRoot(appRoutes)
            ],
            providers: [
                _service_order_service__WEBPACK_IMPORTED_MODULE_13__["OrderService"],
                _service_http_service__WEBPACK_IMPORTED_MODULE_14__["HttpService"],
                _service_admin_setting_service__WEBPACK_IMPORTED_MODULE_15__["AdminSettingService"],
                _service_notification_service__WEBPACK_IMPORTED_MODULE_23__["NotificationService"],
                _common_components_modal_builder__WEBPACK_IMPORTED_MODULE_26__["ModalBuilder"],
                _service_customer_service__WEBPACK_IMPORTED_MODULE_28__["CustomerService"],
                _service_product_service__WEBPACK_IMPORTED_MODULE_30__["ProductService"],
                ngx_cookie_service__WEBPACK_IMPORTED_MODULE_35__["CookieService"]
            ],
            bootstrap: [_app_component__WEBPACK_IMPORTED_MODULE_9__["AppComponent"]]
        })
    ], AppModule);
    return AppModule;
}());



/***/ }),

/***/ "./src/app/common-components/modal-builder.ts":
/*!****************************************************!*\
  !*** ./src/app/common-components/modal-builder.ts ***!
  \****************************************************/
/*! exports provided: ModalBuilder */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ModalBuilder", function() { return ModalBuilder; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @ng-bootstrap/ng-bootstrap */ "./node_modules/@ng-bootstrap/ng-bootstrap/fesm5/ng-bootstrap.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");



var ModalBuilder = /** @class */ (function () {
    function ModalBuilder(modalService) {
        this.modalService = modalService;
    }
    ModalBuilder.prototype.open = function (component) {
        return this.modalService.open(component);
    };
    ModalBuilder.prototype.openCenteredLargeModal = function (component) {
        return this.modalService.open(component, { size: 'lg', centered: true });
    };
    ModalBuilder.prototype.openCenteredModal = function (component) {
        return this.modalService.open(component, { centered: true });
    };
    ModalBuilder = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_2__["Injectable"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_1__["NgbModal"]])
    ], ModalBuilder);
    return ModalBuilder;
}());



/***/ }),

/***/ "./src/app/common-components/pipe/FilterPipe.ts":
/*!******************************************************!*\
  !*** ./src/app/common-components/pipe/FilterPipe.ts ***!
  \******************************************************/
/*! exports provided: FilterPipe */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "FilterPipe", function() { return FilterPipe; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");


var FilterPipe = /** @class */ (function () {
    function FilterPipe() {
    }
    FilterPipe.prototype.transform = function (items, field, value) {
        if (!items) {
            return new Array[0];
        }
        var array = Array.from(items);
        if (!field || !value) {
            return array;
        }
        return array.filter(function (singleTerm) { return singleTerm['product'][field].toLowerCase().includes(value.toLowerCase()); });
    };
    FilterPipe = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Pipe"])({
            name: 'filter',
        }),
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])()
    ], FilterPipe);
    return FilterPipe;
}());



/***/ }),

/***/ "./src/app/customer/customer-header/customer-header.component.css":
/*!************************************************************************!*\
  !*** ./src/app/customer/customer-header/customer-header.component.css ***!
  \************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL2N1c3RvbWVyL2N1c3RvbWVyLWhlYWRlci9jdXN0b21lci1oZWFkZXIuY29tcG9uZW50LmNzcyJ9 */"

/***/ }),

/***/ "./src/app/customer/customer-header/customer-header.component.html":
/*!*************************************************************************!*\
  !*** ./src/app/customer/customer-header/customer-header.component.html ***!
  \*************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/customer/customer-header/customer-header.component.ts":
/*!***********************************************************************!*\
  !*** ./src/app/customer/customer-header/customer-header.component.ts ***!
  \***********************************************************************/
/*! exports provided: CustomerHeaderComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "CustomerHeaderComponent", function() { return CustomerHeaderComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");


var CustomerHeaderComponent = /** @class */ (function () {
    function CustomerHeaderComponent() {
    }
    CustomerHeaderComponent.prototype.ngOnInit = function () {
    };
    CustomerHeaderComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'customer-header',
            template: __webpack_require__(/*! ./customer-header.component.html */ "./src/app/customer/customer-header/customer-header.component.html"),
            styles: [__webpack_require__(/*! ./customer-header.component.css */ "./src/app/customer/customer-header/customer-header.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [])
    ], CustomerHeaderComponent);
    return CustomerHeaderComponent;
}());



/***/ }),

/***/ "./src/app/customer/customer-info/customer-info.component.css":
/*!********************************************************************!*\
  !*** ./src/app/customer/customer-info/customer-info.component.css ***!
  \********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL2N1c3RvbWVyL2N1c3RvbWVyLWluZm8vY3VzdG9tZXItaW5mby5jb21wb25lbnQuY3NzIn0= */"

/***/ }),

/***/ "./src/app/customer/customer-info/customer-info.component.html":
/*!*********************************************************************!*\
  !*** ./src/app/customer/customer-info/customer-info.component.html ***!
  \*********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<h5>Store Information</h5>\n<hr>\n<div>\n  <label>ID : {{ customer.id }}</label>\n  <br>\n  <label>Store : {{ customer.store.name }}</label>\n  <br>\n  <label>Address : {{ customer.store.address }}</label>\n  <br>\n  <label>Phone : {{ customer.store.phone }}</label>\n  <br>\n  <label>Email : {{ customer.store.email }}</label>\n</div>"

/***/ }),

/***/ "./src/app/customer/customer-info/customer-info.component.ts":
/*!*******************************************************************!*\
  !*** ./src/app/customer/customer-info/customer-info.component.ts ***!
  \*******************************************************************/
/*! exports provided: CustomerInfoComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "CustomerInfoComponent", function() { return CustomerInfoComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var src_app_model_Customer__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! src/app/model/Customer */ "./src/app/model/Customer.ts");



var CustomerInfoComponent = /** @class */ (function () {
    function CustomerInfoComponent() {
    }
    CustomerInfoComponent.prototype.ngOnInit = function () {
    };
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", src_app_model_Customer__WEBPACK_IMPORTED_MODULE_2__["Customer"])
    ], CustomerInfoComponent.prototype, "customer", void 0);
    CustomerInfoComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'customer-info',
            template: __webpack_require__(/*! ./customer-info.component.html */ "./src/app/customer/customer-info/customer-info.component.html"),
            styles: [__webpack_require__(/*! ./customer-info.component.css */ "./src/app/customer/customer-info/customer-info.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [])
    ], CustomerInfoComponent);
    return CustomerInfoComponent;
}());



/***/ }),

/***/ "./src/app/customer/customer-orders/customer-orders.component.css":
/*!************************************************************************!*\
  !*** ./src/app/customer/customer-orders/customer-orders.component.css ***!
  \************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "/* Scroll Bar Aggregated Order Item table */\n.my-custom-scrollbar {\n    position: relative;\n    max-height: 35%;\n    overflow: auto;\n  }\n.table-wrapper-scroll-y {\n    display: block;\n  }\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvY3VzdG9tZXIvY3VzdG9tZXItb3JkZXJzL2N1c3RvbWVyLW9yZGVycy5jb21wb25lbnQuY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBLDJDQUEyQztBQUMzQztJQUNJLGtCQUFrQjtJQUNsQixlQUFlO0lBQ2YsY0FBYztFQUNoQjtBQUVBO0lBQ0UsY0FBYztFQUNoQiIsImZpbGUiOiJzcmMvYXBwL2N1c3RvbWVyL2N1c3RvbWVyLW9yZGVycy9jdXN0b21lci1vcmRlcnMuY29tcG9uZW50LmNzcyIsInNvdXJjZXNDb250ZW50IjpbIi8qIFNjcm9sbCBCYXIgQWdncmVnYXRlZCBPcmRlciBJdGVtIHRhYmxlICovXG4ubXktY3VzdG9tLXNjcm9sbGJhciB7XG4gICAgcG9zaXRpb246IHJlbGF0aXZlO1xuICAgIG1heC1oZWlnaHQ6IDM1JTtcbiAgICBvdmVyZmxvdzogYXV0bztcbiAgfVxuICBcbiAgLnRhYmxlLXdyYXBwZXItc2Nyb2xsLXkge1xuICAgIGRpc3BsYXk6IGJsb2NrO1xuICB9Il19 */"

/***/ }),

/***/ "./src/app/customer/customer-orders/customer-orders.component.html":
/*!*************************************************************************!*\
  !*** ./src/app/customer/customer-orders/customer-orders.component.html ***!
  \*************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<h5>Orders ({{ orders.length }})</h5>\n<div class=\"table-responsive table-wrapper-scroll-y my-custom-scrollbar\">\n  <table class=\"table table-striped table-bordered table-sm\">\n      <thead>\n          <tr>\n              <th>ID</th>\n              <th>Name</th>\n              <th>Status</th>\n              <th>Products</th>\n              <th>Qty</th>\n              <th>Amount</th>\n              <th>Creation</th>\n              <th></th>\n          </tr>\n      </thead>\n      <tbody>\n          <tr *ngFor=\"let order of orders\">\n              <td>{{ order.id }}</td>\n              <td>{{ order.name }}</td>\n              <td [ngClass]=\"order.status === 'OPEN' ? 'table-success' : 'table-danger'\">{{ order.status }}</td>\n              <td>{{ order.aggregatedOrderInfo.productSize }}</td>\n              <td>{{ order.aggregatedOrderInfo.orderItemSize }}</td>\n              <td>{{ order.aggregatedOrderInfo.totalPrice }} €</td>\n              <td>{{ order.createdDatetime  | date:'shortDate' }}</td>\n              <td>\n                <button\n                    class=\"btn btn-success btn-sm\"\n                    [routerLink]=\"['/order', order.id]\"\n                >See</button>\n              </td>\n          </tr>\n      </tbody>\n  </table>\n</div>\n"

/***/ }),

/***/ "./src/app/customer/customer-orders/customer-orders.component.ts":
/*!***********************************************************************!*\
  !*** ./src/app/customer/customer-orders/customer-orders.component.ts ***!
  \***********************************************************************/
/*! exports provided: CustomerOrdersComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "CustomerOrdersComponent", function() { return CustomerOrdersComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var src_app_service_order_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! src/app/service/order-service */ "./src/app/service/order-service.ts");



var CustomerOrdersComponent = /** @class */ (function () {
    function CustomerOrdersComponent(orderService) {
        this.orderService = orderService;
        this.orders = [];
    }
    CustomerOrdersComponent.prototype.ngOnInit = function () {
    };
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", Array)
    ], CustomerOrdersComponent.prototype, "orders", void 0);
    CustomerOrdersComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'customer-orders',
            template: __webpack_require__(/*! ./customer-orders.component.html */ "./src/app/customer/customer-orders/customer-orders.component.html"),
            styles: [__webpack_require__(/*! ./customer-orders.component.css */ "./src/app/customer/customer-orders/customer-orders.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [src_app_service_order_service__WEBPACK_IMPORTED_MODULE_2__["OrderService"]])
    ], CustomerOrdersComponent);
    return CustomerOrdersComponent;
}());



/***/ }),

/***/ "./src/app/customer/customer-panel/customer-panel.component.css":
/*!**********************************************************************!*\
  !*** ./src/app/customer/customer-panel/customer-panel.component.css ***!
  \**********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL2N1c3RvbWVyL2N1c3RvbWVyLXBhbmVsL2N1c3RvbWVyLXBhbmVsLmNvbXBvbmVudC5jc3MifQ== */"

/***/ }),

/***/ "./src/app/customer/customer-panel/customer-panel.component.html":
/*!***********************************************************************!*\
  !*** ./src/app/customer/customer-panel/customer-panel.component.html ***!
  \***********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"row\">\n  <customer-header></customer-header>\n</div>\n<div class=\"row\">\n  <div class=\"col-md-auto\">\n    <list-customer (onCustomerSelected)=\"onCustomerSelected($event)\"></list-customer>\n  </div>\n  <div class=\"col\">\n    <customer-info [customer]=\"customer\"></customer-info>\n    <hr>\n    <customer-orders [orders]=\"orders\"></customer-orders>\n  </div>\n</div>"

/***/ }),

/***/ "./src/app/customer/customer-panel/customer-panel.component.ts":
/*!*********************************************************************!*\
  !*** ./src/app/customer/customer-panel/customer-panel.component.ts ***!
  \*********************************************************************/
/*! exports provided: CustomerPanelComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "CustomerPanelComponent", function() { return CustomerPanelComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var src_app_model_AggregatedOrder__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! src/app/model/AggregatedOrder */ "./src/app/model/AggregatedOrder.ts");
/* harmony import */ var src_app_service_order_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! src/app/service/order-service */ "./src/app/service/order-service.ts");




var CustomerPanelComponent = /** @class */ (function () {
    function CustomerPanelComponent(orderService) {
        this.orderService = orderService;
        this.orders = [];
    }
    CustomerPanelComponent.prototype.ngOnInit = function () {
    };
    CustomerPanelComponent.prototype.onCustomerSelected = function (event) {
        this.customer = event;
        this.loadOrders(event.id);
    };
    CustomerPanelComponent.prototype.loadOrders = function (customerId) {
        var _this = this;
        this.orderService.getOrdersOfCustomer(customerId).subscribe(function (data) {
            var arr = [];
            for (var _i = 0, data_1 = data; _i < data_1.length; _i++) {
                var order = data_1[_i];
                arr.push(src_app_model_AggregatedOrder__WEBPACK_IMPORTED_MODULE_2__["AggregatedOrder"].fromJson(order));
            }
            _this.orders = arr;
        });
    };
    CustomerPanelComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'customer-panel',
            template: __webpack_require__(/*! ./customer-panel.component.html */ "./src/app/customer/customer-panel/customer-panel.component.html"),
            styles: [__webpack_require__(/*! ./customer-panel.component.css */ "./src/app/customer/customer-panel/customer-panel.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [src_app_service_order_service__WEBPACK_IMPORTED_MODULE_3__["OrderService"]])
    ], CustomerPanelComponent);
    return CustomerPanelComponent;
}());



/***/ }),

/***/ "./src/app/customer/list-customer/list-customer.component.css":
/*!********************************************************************!*\
  !*** ./src/app/customer/list-customer/list-customer.component.css ***!
  \********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "/* Scroll Bar customer list table */\n.my-custom-scrollbar {\n    position: relative;\n    max-height: 45%;\n    overflow: auto;\n  }\n.table-wrapper-scroll-y {\n    display: block;\n  }\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvY3VzdG9tZXIvbGlzdC1jdXN0b21lci9saXN0LWN1c3RvbWVyLmNvbXBvbmVudC5jc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUEsbUNBQW1DO0FBQ25DO0lBQ0ksa0JBQWtCO0lBQ2xCLGVBQWU7SUFDZixjQUFjO0VBQ2hCO0FBRUE7SUFDRSxjQUFjO0VBQ2hCIiwiZmlsZSI6InNyYy9hcHAvY3VzdG9tZXIvbGlzdC1jdXN0b21lci9saXN0LWN1c3RvbWVyLmNvbXBvbmVudC5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyIvKiBTY3JvbGwgQmFyIGN1c3RvbWVyIGxpc3QgdGFibGUgKi9cbi5teS1jdXN0b20tc2Nyb2xsYmFyIHtcbiAgICBwb3NpdGlvbjogcmVsYXRpdmU7XG4gICAgbWF4LWhlaWdodDogNDUlO1xuICAgIG92ZXJmbG93OiBhdXRvO1xuICB9XG4gIFxuICAudGFibGUtd3JhcHBlci1zY3JvbGwteSB7XG4gICAgZGlzcGxheTogYmxvY2s7XG4gIH0iXX0= */"

/***/ }),

/***/ "./src/app/customer/list-customer/list-customer.component.html":
/*!*********************************************************************!*\
  !*** ./src/app/customer/list-customer/list-customer.component.html ***!
  \*********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<h5>Customers</h5>\n<div class=\"table-responsive table-wrapper-scroll-y my-custom-scrollbar\">\n  <table class=\"table table-striped table-hover\">\n    <thead>\n      <tr>\n        <th>ID</th>\n        <th>Store</th>\n        <th>Owner</th>\n      </tr>\n    </thead>\n    <tbody>\n      <tr *ngFor=\"let customer of customers\" (click)=\"onClickCustomer(customer)\">\n        <td>{{ customer.id }}</td>\n        <td>{{ customer.store.name }}</td>\n        <td>{{ customer.store.owner.firstName + \" \" + customer.store.owner.lastName }}</td>\n      </tr>\n    </tbody>\n  </table>\n</div>"

/***/ }),

/***/ "./src/app/customer/list-customer/list-customer.component.ts":
/*!*******************************************************************!*\
  !*** ./src/app/customer/list-customer/list-customer.component.ts ***!
  \*******************************************************************/
/*! exports provided: ListCustomerComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ListCustomerComponent", function() { return ListCustomerComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var src_app_model_Customer__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! src/app/model/Customer */ "./src/app/model/Customer.ts");
/* harmony import */ var src_app_common_components_modal_builder__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! src/app/common-components/modal-builder */ "./src/app/common-components/modal-builder.ts");
/* harmony import */ var src_app_service_customer_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! src/app/service/customer-service */ "./src/app/service/customer-service.ts");
/* harmony import */ var src_app_modal_info_modal_info_modal_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! src/app/modal/info-modal/info-modal.component */ "./src/app/modal/info-modal/info-modal.component.ts");






var ListCustomerComponent = /** @class */ (function () {
    function ListCustomerComponent(customerService, modalBuilder) {
        this.customerService = customerService;
        this.modalBuilder = modalBuilder;
        this.onCustomerSelected = new _angular_core__WEBPACK_IMPORTED_MODULE_1__["EventEmitter"]();
        this.customers = [];
    }
    ListCustomerComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.customerService.getAllCustomers().subscribe(function (data) {
            for (var _i = 0, data_1 = data; _i < data_1.length; _i++) {
                var customer = data_1[_i];
                _this.customers.push(src_app_model_Customer__WEBPACK_IMPORTED_MODULE_2__["Customer"].fromJson(customer));
            }
        }, function (error) {
            var modalRef = _this.modalBuilder.open(src_app_modal_info_modal_info_modal_component__WEBPACK_IMPORTED_MODULE_5__["InfoModalComponent"]);
            modalRef.componentInstance.title = "Cannot load the customers.";
            modalRef.componentInstance.message = error.error;
        });
    };
    ListCustomerComponent.prototype.onClickCustomer = function (customer) {
        this.onCustomerSelected.emit(customer);
    };
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Output"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", Object)
    ], ListCustomerComponent.prototype, "onCustomerSelected", void 0);
    ListCustomerComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'list-customer',
            template: __webpack_require__(/*! ./list-customer.component.html */ "./src/app/customer/list-customer/list-customer.component.html"),
            styles: [__webpack_require__(/*! ./list-customer.component.css */ "./src/app/customer/list-customer/list-customer.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [src_app_service_customer_service__WEBPACK_IMPORTED_MODULE_4__["CustomerService"],
            src_app_common_components_modal_builder__WEBPACK_IMPORTED_MODULE_3__["ModalBuilder"]])
    ], ListCustomerComponent);
    return ListCustomerComponent;
}());



/***/ }),

/***/ "./src/app/customer/new-customer/new-customer.component.css":
/*!******************************************************************!*\
  !*** ./src/app/customer/new-customer/new-customer.component.css ***!
  \******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".ng-invalid:not(form)  {\n    border-left: 5px solid #a94442; /* red */\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvY3VzdG9tZXIvbmV3LWN1c3RvbWVyL25ldy1jdXN0b21lci5jb21wb25lbnQuY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBO0lBQ0ksOEJBQThCLEVBQUUsUUFBUTtBQUM1QyIsImZpbGUiOiJzcmMvYXBwL2N1c3RvbWVyL25ldy1jdXN0b21lci9uZXctY3VzdG9tZXIuY29tcG9uZW50LmNzcyIsInNvdXJjZXNDb250ZW50IjpbIi5uZy1pbnZhbGlkOm5vdChmb3JtKSAge1xuICAgIGJvcmRlci1sZWZ0OiA1cHggc29saWQgI2E5NDQ0MjsgLyogcmVkICovXG59Il19 */"

/***/ }),

/***/ "./src/app/customer/new-customer/new-customer.component.html":
/*!*******************************************************************!*\
  !*** ./src/app/customer/new-customer/new-customer.component.html ***!
  \*******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<form [formGroup]=\"form\" (ngSubmit)=\"onSubmit()\">\n  <h5>Owner</h5>\n  <hr>\n  <div class=\"row\">\n    <div class=\"col form-group\">\n      <label for=\"newowner\">New Owner &nbsp;</label>\n      <input type=\"checkbox\" formControlName=\"isNewOwnerCheckbox\" (click)=\"onClickNewOwnerCheckbox($event)\">\n    </div>\n  </div>\n  <div class=\"row\">\n    <div *ngIf=\"! showCreateOwnerForm\" class=\"col-5 form-group\">\n      <label for=\"Name\">Select an existing owner :</label>\n      <input type=\"text\" formControlName=\"ownerAutoComplete\"\n        (blur)=\"onBlurOwnerAutoComplete()\"\n        [(ngModel)]=\"inputOwnerName\"\n        [ngbTypeahead]=\"search\"\n        class=\"form-control\"/>\n    </div>\n  </div>\n  <div *ngIf=\"storesOfSelectedOwner.length > 0\" class=\"row\">\n    <div class=\"col-5\">\n      <table class=\"table table-striped table-bordered table-sm\">\n        <thead>\n          <tr>\n            <th>#</th>\n            <th>Id</th>\n            <th>Name</th>\n            <th>Email</th>\n            <th>Phone</th>\n          </tr>\n        </thead>\n        <tbody>\n          <tr *ngFor=\"let store of storesOfSelectedOwner; let i = index\">\n            <td>{{ i + 1 }}</td>\n            <td>{{ store.id }}</td>\n            <td>{{ store.name }}</td>\n            <td>{{ store.email }}</td>\n            <td>{{ store.phone }}</td>\n          </tr>\n        </tbody>\n      </table>\n    </div>\n  </div>\n  <div *ngIf=\"showCreateOwnerForm\" class=\"row\">\n    <div class=\"col form-group\">\n      <label for=\"compagnyName\">Compagny Nane</label>\n      <input type=\"text\" formControlName=\"ownerCompagnyName\" class=\"form-control\" (blur)=onBlurStringFormControl($event)/>\n    </div>\n    <div class=\"col form-group\">\n        <label for=\"firstName\">FirstName</label>\n        <input type=\"text\" formControlName=\"ownerFirstName\" class=\"form-control\" (blur)=onBlurStringFormControl($event)/>\n    </div>\n    <div class=\"col form-group\">\n        <label for=\"lastName\">LastName</label>\n        <input type=\"text\" formControlName=\"ownerLastName\" class=\"form-control\" (blur)=onBlurStringFormControl($event)/>\n    </div>\n    <div class=\"col form-group\">\n        <label for=\"email\">Email</label>\n        <input type=\"text\" formControlName=\"ownerEmail\" class=\"form-control\" (blur)=onBlurLowcaseStringFormControl($event)/>\n    </div>\n  </div>\n  <br>\n  <h5>Store</h5>\n  <hr>\n  <div class=\"row\">\n      <div class=\"col form-group\">\n          <label for=\"name\">Name</label>\n          <input type=\"text\" formControlName=\"storeName\" class=\"form-control\" (blur)=onBlurStringFormControl($event)/>\n      </div>\n      <div class=\"col form-group\">\n          <label for=\"address\">Address</label>\n          <input type=\"text\" formControlName=\"storeAddress\" class=\"form-control\"/>\n      </div>\n      <div class=\"col form-group\">\n          <label for=\"zipCode\">Zip Code</label>\n          <input type=\"text\" formControlName=\"storeZipCode\" class=\"form-control\"/>\n      </div>\n      <div class=\"col form-group\">\n          <label for=\"city\">City</label>\n          <input type=\"text\" formControlName=\"storeCity\" class=\"form-control\" (blur)=onBlurStringFormControl($event)/>\n      </div>\n  </div>\n  <div class=\"row\">\n      <div class=\"col form-group\">\n          <label for=\"phone\">Phone</label>\n          <input type=\"text\" formControlName=\"storePhone\" class=\"form-control\"/>\n      </div>\n      <div class=\"col form-group\">\n          <label for=\"email\">Email</label>\n          <input type=\"text\" formControlName=\"storeEmail\" class=\"form-control\" (blur)=onBlurLowcaseStringFormControl($event)>\n      </div>\n  </div>\n  <hr>\n  <div class=\"row\">\n    <div class=\"col\">\n      <button class=\"btn btn-primary\" type=\"submit\">Add Customer</button>\n    </div>\n    <div class=\"col-md-auto\">\n      <ngb-alert *ngIf=\"errorMessage\" type=\"danger\" [dismissible]=\"true\" (close)=\"errorMessage = null\">{{ errorMessage }}</ngb-alert>\n    </div>\n  </div>\n</form>"

/***/ }),

/***/ "./src/app/customer/new-customer/new-customer.component.ts":
/*!*****************************************************************!*\
  !*** ./src/app/customer/new-customer/new-customer.component.ts ***!
  \*****************************************************************/
/*! exports provided: NewCustomerComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "NewCustomerComponent", function() { return NewCustomerComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var src_app_service_customer_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! src/app/service/customer-service */ "./src/app/service/customer-service.ts");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var src_app_model_request_customer_AddCustomerReq__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! src/app/model/request/customer/AddCustomerReq */ "./src/app/model/request/customer/AddCustomerReq.ts");
/* harmony import */ var src_app_model_Store__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! src/app/model/Store */ "./src/app/model/Store.ts");
/* harmony import */ var src_app_common_components_modal_builder__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! src/app/common-components/modal-builder */ "./src/app/common-components/modal-builder.ts");
/* harmony import */ var src_app_modal_info_modal_info_modal_component__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! src/app/modal/info-modal/info-modal.component */ "./src/app/modal/info-modal/info-modal.component.ts");
/* harmony import */ var src_app_util_StringUtil__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! src/app/util/StringUtil */ "./src/app/util/StringUtil.ts");











var NewCustomerComponent = /** @class */ (function () {
    function NewCustomerComponent(formBuilder, modalBuilder, customerService) {
        var _this = this;
        this.formBuilder = formBuilder;
        this.modalBuilder = modalBuilder;
        this.customerService = customerService;
        this.ownerNames = [];
        this.storesOfSelectedOwner = [];
        this._error = new rxjs__WEBPACK_IMPORTED_MODULE_4__["Subject"]();
        this.search = function (text$) {
            return text$.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_5__["debounceTime"])(200), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_5__["distinctUntilChanged"])(), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_5__["map"])(function (term) { return term.length < 1 ? []
                : _this.ownerNames.filter(function (v) { return v.toLowerCase().indexOf(term.toLowerCase()) > -1; }).slice(0, 10); }));
        };
    }
    NewCustomerComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.ownerIdMapByName = new Map();
        this.initForm();
        this._error.subscribe(function (msg) { return _this.errorMessage = msg; });
        this._error.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_5__["debounceTime"])(4000)).subscribe(function () { return _this.errorMessage = null; });
    };
    NewCustomerComponent.prototype.initForm = function () {
        this.showCreateOwnerForm = false;
        this.loadOwners();
        this.form = this.formBuilder.group({
            ownerAutoComplete: [''],
            isNewOwnerCheckbox: [],
            ownerCompagnyName: [''],
            ownerFirstName: [''],
            ownerLastName: [''],
            ownerEmail: ['', _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].email],
            storeName: ['', _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required],
            storeAddress: [''],
            storeZipCode: [''],
            storeCity: [''],
            storePhone: [''],
            storeEmail: ['', _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].email]
        });
    };
    NewCustomerComponent.prototype.loadOwners = function () {
        var _this = this;
        this.customerService.getAllOwnersIdsAndNames().subscribe(function (data) {
            for (var _i = 0, data_1 = data; _i < data_1.length; _i++) {
                var owner = data_1[_i];
                _this.ownerIdMapByName.set(owner.second, owner.first);
                _this.ownerNames.push(owner.second);
            }
        });
    };
    NewCustomerComponent.prototype.onBlurStringFormControl = function (event) {
        event.srcElement.value = src_app_util_StringUtil__WEBPACK_IMPORTED_MODULE_10__["StringUtil"].capitalFirstLetter(event.srcElement.value);
    };
    NewCustomerComponent.prototype.onBlurLowcaseStringFormControl = function (event) {
        event.srcElement.value = event.srcElement.value.toLowerCase();
    };
    NewCustomerComponent.prototype.onClickNewOwnerCheckbox = function (event) {
        var controls = this.form.controls;
        controls.ownerAutoComplete.reset();
        this.showCreateOwnerForm = event.currentTarget.checked;
        if (this.showCreateOwnerForm) {
            controls.ownerAutoComplete.setValidators(null);
            controls.ownerCompagnyName.setValidators(_angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required);
        }
        else {
            controls.ownerAutoComplete.setValidators(_angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required);
            controls.ownerCompagnyName.setValidators(null);
        }
        this.storesOfSelectedOwner = [];
    };
    NewCustomerComponent.prototype.onBlurOwnerAutoComplete = function () {
        var _this = this;
        var ownerNameSelected = this.form.controls.ownerAutoComplete.value;
        var ownerId = this.ownerIdMapByName.get(ownerNameSelected);
        if (ownerId != null) {
            this.customerService.getStoresOfOwner(ownerId).subscribe(function (data) {
                for (var _i = 0, data_2 = data; _i < data_2.length; _i++) {
                    var store = data_2[_i];
                    _this.storesOfSelectedOwner.push(src_app_model_Store__WEBPACK_IMPORTED_MODULE_7__["Store"].fromJson(store));
                }
            }, function (error) {
                var modalRef = _this.modalBuilder.open(src_app_modal_info_modal_info_modal_component__WEBPACK_IMPORTED_MODULE_9__["InfoModalComponent"]);
                modalRef.componentInstance.title = '';
                modalRef.componentInstance.message = 'Cannot load the stores of the owner : ' + ownerNameSelected;
            });
        }
        else {
            this.storesOfSelectedOwner = [];
        }
    };
    NewCustomerComponent.prototype.changeErrorMessage = function (errorMessage) {
        this._error.next(errorMessage);
    };
    NewCustomerComponent.prototype.onSubmit = function () {
        var _this = this;
        var controls = this.form.controls;
        if (this.form.valid) {
            var ownerId = void 0, ownerFirstName = void 0, ownerLastName = void 0, ownerEmail = void 0, ownerCompagnyName = void 0;
            var storeName = void 0, storeAddress = void 0, storePhone = void 0, storeEmail = void 0;
            if (controls.isNewOwnerCheckbox.value) {
                ownerFirstName = controls.ownerFirstName.value;
                ownerCompagnyName = controls.ownerCompagnyName.value;
                ownerLastName = controls.ownerLastName.value;
                ownerEmail = controls.ownerEmail.value;
            }
            else {
                ownerId = this.ownerIdMapByName.get(controls.ownerAutoComplete.value);
                if (ownerId == null) {
                    // do validator 
                }
            }
            storeName = controls.storeName.value;
            storeAddress = controls.storeAddress.value + ' - ' + controls.storeZipCode.value + ' ' + controls.storeCity.value;
            storePhone = controls.storePhone.value;
            storeEmail = controls.storeEmail.value;
            var req = new src_app_model_request_customer_AddCustomerReq__WEBPACK_IMPORTED_MODULE_6__["AddCustomerReq"](ownerId, storeName);
            req.ownerCompagnyName = ownerCompagnyName;
            req.ownerFirstName = ownerFirstName;
            req.ownerLastName = ownerLastName;
            req.ownerEmail = ownerEmail;
            req.storeAddress = storeAddress;
            req.storeEmail = storeEmail;
            req.storePhone = storePhone;
            this.customerService.addCustomer(req).subscribe(function (data) {
                _this.form.reset();
                _this.storesOfSelectedOwner = [];
            }, function (error) {
                _this.changeErrorMessage(error.error);
            });
        }
        else {
            this.changeErrorMessage("Form not valid.");
        }
    };
    NewCustomerComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'new-customer',
            template: __webpack_require__(/*! ./new-customer.component.html */ "./src/app/customer/new-customer/new-customer.component.html"),
            styles: [__webpack_require__(/*! ./new-customer.component.css */ "./src/app/customer/new-customer/new-customer.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormBuilder"],
            src_app_common_components_modal_builder__WEBPACK_IMPORTED_MODULE_8__["ModalBuilder"],
            src_app_service_customer_service__WEBPACK_IMPORTED_MODULE_3__["CustomerService"]])
    ], NewCustomerComponent);
    return NewCustomerComponent;
}());



/***/ }),

/***/ "./src/app/header-menu/header-menu.component.css":
/*!*******************************************************!*\
  !*** ./src/app/header-menu/header-menu.component.css ***!
  \*******************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL2hlYWRlci1tZW51L2hlYWRlci1tZW51LmNvbXBvbmVudC5jc3MifQ== */"

/***/ }),

/***/ "./src/app/header-menu/header-menu.component.html":
/*!********************************************************!*\
  !*** ./src/app/header-menu/header-menu.component.html ***!
  \********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<p>\n  header-menu works!\n</p>\n"

/***/ }),

/***/ "./src/app/header-menu/header-menu.component.ts":
/*!******************************************************!*\
  !*** ./src/app/header-menu/header-menu.component.ts ***!
  \******************************************************/
/*! exports provided: HeaderMenuComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "HeaderMenuComponent", function() { return HeaderMenuComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");


var HeaderMenuComponent = /** @class */ (function () {
    function HeaderMenuComponent() {
    }
    HeaderMenuComponent.prototype.ngOnInit = function () {
    };
    HeaderMenuComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-header-menu',
            template: __webpack_require__(/*! ./header-menu.component.html */ "./src/app/header-menu/header-menu.component.html"),
            styles: [__webpack_require__(/*! ./header-menu.component.css */ "./src/app/header-menu/header-menu.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [])
    ], HeaderMenuComponent);
    return HeaderMenuComponent;
}());



/***/ }),

/***/ "./src/app/modal/add-order-item-modal/add-order-item-modal.component.css":
/*!*******************************************************************************!*\
  !*** ./src/app/modal/add-order-item-modal/add-order-item-modal.component.css ***!
  \*******************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL21vZGFsL2FkZC1vcmRlci1pdGVtLW1vZGFsL2FkZC1vcmRlci1pdGVtLW1vZGFsLmNvbXBvbmVudC5jc3MifQ== */"

/***/ }),

/***/ "./src/app/modal/add-order-item-modal/add-order-item-modal.component.html":
/*!********************************************************************************!*\
  !*** ./src/app/modal/add-order-item-modal/add-order-item-modal.component.html ***!
  \********************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"modal-header\">\n    <h5 class=\"modal-title\" id=\"modal-basic-title\">Add order items</h5>\n    <button type=\"button\" class=\"close\" aria-label=\"Close\" (click)=\"onClose()\">\n      <span aria-hidden=\"true\">&times;</span>\n    </button>\n</div>\n<div class=\"modal-body\">\n  <form [formGroup]=\"addOrderItemForm\">\n    <div class=\"custom-control custom-switch\" style=\"float: right\">\n      <input type=\"checkbox\" class=\"custom-control-input\" id=\"customSwitch1\" (click)=\"shouldEnableBarCodeMode($event)\" [(ngModel)]=\"barCodeMode\" [ngModelOptions]=\"{standalone: true}\">\n      <label class=\"custom-control-label\" for=\"customSwitch1\">Barcode Mode</label>\n    </div>\n    <div *ngIf=\"barCodeMode\">\n      <div class=\"form-group\">\n          <label for=\"barCode\">BarCode</label>\n          <input type=\"text\" formControlName=\"barCode\"\n            (change)=\"onValueChange()\"\n            (blur)=\"onBlurBarCode()\"\n            class=\"form-control\"/>\n      </div>\n    </div>\n    <div *ngIf=\"! barCodeMode\">\n      <div class=\"form-group\">\n        <label for=\"Name\">Product Name</label>\n        <input type=\"text\" formControlName=\"productName\"\n          [(ngModel)]=\"inputProductName\"\n          [ngbTypeahead]=\"search\"\n          (change)=\"onProductNameChange()\"\n          (blur)=\"onBlurProductName()\"\n          class=\"form-control\"/>\n      </div>\n      <div class=\"form-group\">\n        <label for=\"quantity\">Quantity</label>\n        <input type=\"number\" formControlName=\"quantity\"\n          (change)=\"onValueChange()\"\n          class=\"form-control\"/>\n      </div>\n    </div>\n    <div *ngIf=\"productStockInfo\">\n      <table class=\"table table-striped\">\n        <thead>\n          <tr>\n            <th>Id</th>\n            <th>Name</th>\n            <th>Initial Qty</th>\n            <th>Free Qty</th>\n          </tr>\n        </thead>\n        <tbody>\n          <tr>\n            <td>{{ productStockInfo.product.id }}</td>\n            <td>{{ productStockInfo.product.name }}</td>\n            <td>{{ productStockInfo.createdQuantity }}</td>\n            <td>{{ productStockInfo.createdQuantity - productStockInfo.usedQuantity }}</td>\n          </tr>\n        </tbody>\n      </table>\n    </div>\n    <div *ngIf=\"productItem\">\n      <table class=\"table table-striped\">\n        <thead>\n          <tr>\n            <th>Id</th>\n            <th>Name</th>\n            <th>Free</th>\n          </tr>\n        </thead>\n        <tbody>\n          <tr>\n            <td>{{ productItem.id }}</td>\n            <td>{{ productItem.product.name }}</td>\n            <td>{{ productItem.orderItemId ? 'No' : 'Yes' }}</td>\n          </tr>\n        </tbody>\n      </table>\n    </div>\n  </form>\n</div>\n<div class=\"modal-footer\">\n  <div class=\"container\">\n    <div class=\"row\">\n        <div class=\"col-md-auto\">\n            <ngb-alert *ngIf=\"errorMessage\" type=\"danger\" [dismissible]=\"true\" (close)=\"errorMessage = null\">{{ errorMessage }}</ngb-alert>\n        </div>\n        <div class=\"col\">\n          <button class=\"btn btn-outline-dark\" type=\"button\" [disabled]=\"isAddButtonDisabled\" (click)=\"onSubmit()\" style=\"float:right\">\n              <span *ngIf=\"addOrderItemInProgress\" class=\"spinner-border spinner-border-sm\" role=\"status\" aria-hidden=\"true\"></span>\n            Add</button>\n        </div>\n    </div>\n  </div>\n</div>"

/***/ }),

/***/ "./src/app/modal/add-order-item-modal/add-order-item-modal.component.ts":
/*!******************************************************************************!*\
  !*** ./src/app/modal/add-order-item-modal/add-order-item-modal.component.ts ***!
  \******************************************************************************/
/*! exports provided: AddOrderItemModalComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AddOrderItemModalComponent", function() { return AddOrderItemModalComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var src_app_service_order_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! src/app/service/order-service */ "./src/app/service/order-service.ts");
/* harmony import */ var src_app_model_request_order_AddOrderItemReq__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! src/app/model/request/order/AddOrderItemReq */ "./src/app/model/request/order/AddOrderItemReq.ts");
/* harmony import */ var _ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @ng-bootstrap/ng-bootstrap */ "./node_modules/@ng-bootstrap/ng-bootstrap/fesm5/ng-bootstrap.js");
/* harmony import */ var src_app_service_product_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! src/app/service/product-service */ "./src/app/service/product-service.ts");
/* harmony import */ var ngx_cookie_service__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ngx-cookie-service */ "./node_modules/ngx-cookie-service/index.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var src_app_model_ProductStockInfo__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! src/app/model/ProductStockInfo */ "./src/app/model/ProductStockInfo.ts");
/* harmony import */ var src_app_model_request_order_AddOrderItemByBarCodeReq__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! src/app/model/request/order/AddOrderItemByBarCodeReq */ "./src/app/model/request/order/AddOrderItemByBarCodeReq.ts");
/* harmony import */ var src_app_util_TypeUtil__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! src/app/util/TypeUtil */ "./src/app/util/TypeUtil.ts");
/* harmony import */ var src_app_model_ProductItem__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! src/app/model/ProductItem */ "./src/app/model/ProductItem.ts");














var AddOrderItemModalComponent = /** @class */ (function () {
    function AddOrderItemModalComponent(formBuilder, modal, cookieService, productService, orderService) {
        var _this = this;
        this.formBuilder = formBuilder;
        this.modal = modal;
        this.cookieService = cookieService;
        this.productService = productService;
        this.orderService = orderService;
        this.productNames = [];
        this.productIdMapByName = new Map();
        this._error = new rxjs__WEBPACK_IMPORTED_MODULE_8__["Subject"]();
        this.search = function (text$) {
            return text$.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_9__["debounceTime"])(200), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_9__["distinctUntilChanged"])(), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_9__["map"])(function (term) { return term.length < 1 ? []
                : _this.productNames.filter(function (v) { return v.toLowerCase().indexOf(term.toLowerCase()) > -1; }).slice(0, 10); }));
        };
    }
    AddOrderItemModalComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.initBarCodeMode();
        this.initForm();
        this.getAllCustomers();
        this._error.subscribe(function (msg) { return _this.errorMessage = msg; });
        this._error.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_9__["debounceTime"])(4000)).subscribe(function () { return _this.errorMessage = null; });
    };
    AddOrderItemModalComponent.prototype.onProductNameChange = function () {
        this.onValueChange();
        this.productStockInfo = null;
    };
    AddOrderItemModalComponent.prototype.onValueChange = function () {
        this.errorMessage = null;
    };
    AddOrderItemModalComponent.prototype.initForm = function () {
        if (this.barCodeMode) {
            this.disableAddButton(false);
        }
        this.addOrderItemForm = this.formBuilder.group({
            barCode: [''],
            productName: [''],
            productId: [''],
            quantity: ['', _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].min(1)]
        });
    };
    AddOrderItemModalComponent.prototype.initBarCodeMode = function () {
        this.barCodeMode = this.cookieService.check("barCodeMode") ? src_app_util_TypeUtil__WEBPACK_IMPORTED_MODULE_12__["TypeUtil"].toBoolean(this.cookieService.get("barCodeMode")) : true;
    };
    AddOrderItemModalComponent.prototype.shouldEnableBarCodeMode = function (event) {
        this.resetForm();
        this.cookieService.set("barCodeMode", String(event.currentTarget.checked));
    };
    AddOrderItemModalComponent.prototype.resetForm = function () {
        this.addOrderItemForm.reset();
        this.productStockInfo = null;
        this.productItem = null;
        this.changeErrorMessage(null);
    };
    AddOrderItemModalComponent.prototype.getAllCustomers = function () {
        var _this = this;
        this.productService.getAllProductNames().subscribe(function (data) {
            for (var _i = 0, data_1 = data; _i < data_1.length; _i++) {
                var idAndNameProduct = data_1[_i];
                _this.productIdMapByName.set(idAndNameProduct.second, idAndNameProduct.first);
                _this.productNames.push(idAndNameProduct.second);
            }
        });
    };
    AddOrderItemModalComponent.prototype.onBlurProductName = function () {
        var _this = this;
        this.productItem = null;
        var productName = this.addOrderItemForm.get("productName").value;
        if (productName != null) {
            var productId = this.productIdMapByName.get(productName);
            if (productId != null) {
                this.productService.getProductStockInfo(productId).subscribe(function (data) {
                    _this.productStockInfo = src_app_model_ProductStockInfo__WEBPACK_IMPORTED_MODULE_10__["ProductStockInfo"].fromJson(data);
                }, function (error) {
                    _this.changeErrorMessage(error.error);
                    _this.productStockInfo = null;
                });
            }
        }
    };
    AddOrderItemModalComponent.prototype.onBlurBarCode = function () {
        var _this = this;
        this.productStockInfo = null;
        var barCode = this.addOrderItemForm.get("barCode").value;
        if (barCode != null) {
            this.productService.getProductItemByBarCode(barCode).subscribe(function (data) {
                _this.productItem = src_app_model_ProductItem__WEBPACK_IMPORTED_MODULE_13__["ProductItem"].fromJson(data);
                _this.disableAddButton(false);
            }, function (error) {
                _this.changeErrorMessage(error.error);
                _this.productItem = null;
            });
        }
    };
    AddOrderItemModalComponent.prototype.onSubmit = function () {
        if (this.barCodeMode) {
            this.onSubmitBarCodeMode();
        }
        else {
            this.onSubmitNoBarCodeMode();
        }
    };
    AddOrderItemModalComponent.prototype.onSubmitBarCodeMode = function () {
        var _this = this;
        var barCode = this.addOrderItemForm.get("barCode").value;
        if (barCode == null || barCode.length == 0) {
            this.changeErrorMessage("Please enter a barcode.");
        }
        else {
            this.addInProgress(true);
            var request = new src_app_model_request_order_AddOrderItemByBarCodeReq__WEBPACK_IMPORTED_MODULE_11__["AddOrderItemByBarCodeReq"](this.orderId, barCode);
            this.orderService.addOrderItemByBarCode(request).subscribe(function (data) {
                console.log(data);
                _this.modal.close(true);
            }, function (error) {
                _this.changeErrorMessage(error.error);
                _this.addInProgress(false);
            });
            this.errorMessage = null;
        }
    };
    AddOrderItemModalComponent.prototype.onSubmitNoBarCodeMode = function () {
        var _this = this;
        var productName = this.addOrderItemForm.get("productName").value;
        var productId = this.productIdMapByName.get(productName);
        var qty = this.addOrderItemForm.get("quantity").value;
        if (this.productStockInfo === null) {
            this.changeErrorMessage('Please select a product from the auto-complete list.');
        }
        else if (!this.isValidQuantity(qty)) {
            this.changeErrorMessage('Please choose a quantity between 1 to ' + this.productStockInfo.getFreeQuantity());
        }
        else {
            this.addInProgress(true);
            var request = new src_app_model_request_order_AddOrderItemReq__WEBPACK_IMPORTED_MODULE_4__["AddOrderItemReq"](this.orderId, productId, qty);
            this.orderService.addOrderItem(request).subscribe(function (data) {
                console.log(data);
                _this.modal.close(true);
            }, function (error) {
                _this.changeErrorMessage(error.error);
                _this.addInProgress(false);
            });
            this.errorMessage = null;
        }
    };
    AddOrderItemModalComponent.prototype.addInProgress = function (isInProgress) {
        this.addOrderItemInProgress = isInProgress;
    };
    AddOrderItemModalComponent.prototype.changeErrorMessage = function (errorMessage) {
        this._error.next(errorMessage);
    };
    AddOrderItemModalComponent.prototype.isValidQuantity = function (qty) {
        return qty > 0 && qty <= this.productStockInfo.getFreeQuantity();
    };
    AddOrderItemModalComponent.prototype.disableAddButton = function (disabled) {
        this.isAddButtonDisabled = disabled;
    };
    AddOrderItemModalComponent.prototype.onClose = function () {
        this.modal.close(false);
    };
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", Number)
    ], AddOrderItemModalComponent.prototype, "orderId", void 0);
    AddOrderItemModalComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'add-order-item-modal',
            template: __webpack_require__(/*! ./add-order-item-modal.component.html */ "./src/app/modal/add-order-item-modal/add-order-item-modal.component.html"),
            styles: [__webpack_require__(/*! ./add-order-item-modal.component.css */ "./src/app/modal/add-order-item-modal/add-order-item-modal.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormBuilder"],
            _ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_5__["NgbActiveModal"],
            ngx_cookie_service__WEBPACK_IMPORTED_MODULE_7__["CookieService"],
            src_app_service_product_service__WEBPACK_IMPORTED_MODULE_6__["ProductService"],
            src_app_service_order_service__WEBPACK_IMPORTED_MODULE_3__["OrderService"]])
    ], AddOrderItemModalComponent);
    return AddOrderItemModalComponent;
}());



/***/ }),

/***/ "./src/app/modal/confirm-modal/confirm-modal-component.css":
/*!*****************************************************************!*\
  !*** ./src/app/modal/confirm-modal/confirm-modal-component.css ***!
  \*****************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL21vZGFsL2NvbmZpcm0tbW9kYWwvY29uZmlybS1tb2RhbC1jb21wb25lbnQuY3NzIn0= */"

/***/ }),

/***/ "./src/app/modal/confirm-modal/confirm-modal-component.html":
/*!******************************************************************!*\
  !*** ./src/app/modal/confirm-modal/confirm-modal-component.html ***!
  \******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"modal-header\">\n    <h4 class=\"modal-title\" id=\"modal-basic-title\">{{ title }}</h4>\n    <button type=\"button\" class=\"close\" aria-label=\"Close\" (click)=\"onClickClose()\">\n      <span aria-hidden=\"true\">&times;</span>\n    </button>\n</div>\n<div class=\"modal-body\">\n    <p>{{ message }}</p>\n</div>\n<div class=\"modal-footer\">\n  <button type=\"button\" class=\"btn btn-secondary\" (click)=\"onClickClose()\">No</button>\n  <button type=\"button\" class=\"btn btn-primary\" (click)=\"onClickYes()\">Yes</button>\n</div>\n"

/***/ }),

/***/ "./src/app/modal/confirm-modal/confirm-modal-component.ts":
/*!****************************************************************!*\
  !*** ./src/app/modal/confirm-modal/confirm-modal-component.ts ***!
  \****************************************************************/
/*! exports provided: ConfirmModalComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ConfirmModalComponent", function() { return ConfirmModalComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @ng-bootstrap/ng-bootstrap */ "./node_modules/@ng-bootstrap/ng-bootstrap/fesm5/ng-bootstrap.js");



var ConfirmModalComponent = /** @class */ (function () {
    function ConfirmModalComponent(modal) {
        this.modal = modal;
    }
    ConfirmModalComponent.prototype.ngOnInit = function () {
    };
    ConfirmModalComponent.prototype.onClickYes = function () {
        this.modal.close(true);
    };
    ConfirmModalComponent.prototype.onClickClose = function () {
        this.modal.close(false);
    };
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", String)
    ], ConfirmModalComponent.prototype, "title", void 0);
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", String)
    ], ConfirmModalComponent.prototype, "message", void 0);
    ConfirmModalComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'confirm-modal',
            template: __webpack_require__(/*! ./confirm-modal-component.html */ "./src/app/modal/confirm-modal/confirm-modal-component.html"),
            styles: [__webpack_require__(/*! ./confirm-modal-component.css */ "./src/app/modal/confirm-modal/confirm-modal-component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_2__["NgbActiveModal"]])
    ], ConfirmModalComponent);
    return ConfirmModalComponent;
}());



/***/ }),

/***/ "./src/app/modal/create-order-modal/create-order-modal.component.css":
/*!***************************************************************************!*\
  !*** ./src/app/modal/create-order-modal/create-order-modal.component.css ***!
  \***************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL21vZGFsL2NyZWF0ZS1vcmRlci1tb2RhbC9jcmVhdGUtb3JkZXItbW9kYWwuY29tcG9uZW50LmNzcyJ9 */"

/***/ }),

/***/ "./src/app/modal/create-order-modal/create-order-modal.component.html":
/*!****************************************************************************!*\
  !*** ./src/app/modal/create-order-modal/create-order-modal.component.html ***!
  \****************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"modal-header\">\n  <h4 class=\"modal-title\" id=\"modal-basic-title\">New Order</h4>\n  <button type=\"button\" class=\"close\" aria-label=\"Close\" (click)=\"onClose()\">\n    <span aria-hidden=\"true\">&times;</span>\n  </button>\n</div>\n<form [formGroup]=\"createOrderForm\" (ngSubmit)=\"onSubmit()\">\n  <div class=\"modal-body\">\n      <div class=\"form-group\">\n        <label for=\"Name\">Name</label>\n        <input type=\"text\" formControlName=\"name\"\n          (input)=\"settingChanged()\"\n          class=\"form-control\"/>\n          <label *ngIf=\"isFormSubmitted && createOrderForm.get('name').invalid\" class=\"text-danger\">A name is required.</label>\n      </div>\n      <div class=\"form-group\">\n        <label for=\"comment\">Comment/Description</label>\n        <input type=\"text\" formControlName=\"comment\"\n          (input)=\"settingChanged()\"\n          class=\"form-control\"/>\n      </div>\n      <div class=\"form-group\">\n        <label for=\"customer\">Customer</label>\n        <select type=\"text\" formControlName=\"customers\"\n          (input)=\"settingChanged()\"\n          class=\"form-control\">\n          <option *ngFor=\"let customer of customersArray\"\n          [ngValue]=\"customer\">{{customer.id}} | {{ customer.store.name }} | {{ customer.store.owner.firstName }} {{ customer.store.owner.lastName }}</option>\n        </select>\n        <label *ngIf=\"isFormSubmitted && createOrderForm.get('customers').invalid\" class=\"text-danger\">A customer is required.</label>\n      </div>\n      <div>\n          <ngb-alert *ngIf=\"errorMessage\" type=\"danger\" [dismissible]=\"false\" (close)=\"errorMessage = null\">{{ errorMessage }}</ngb-alert>\n      </div>\n  </div>\n  <div class=\"modal-footer\">\n    <button type=\"submit\" class=\"btn btn-outline-dark\">Create</button>\n  </div>\n</form>"

/***/ }),

/***/ "./src/app/modal/create-order-modal/create-order-modal.component.ts":
/*!**************************************************************************!*\
  !*** ./src/app/modal/create-order-modal/create-order-modal.component.ts ***!
  \**************************************************************************/
/*! exports provided: CreateOrderModalComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "CreateOrderModalComponent", function() { return CreateOrderModalComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @ng-bootstrap/ng-bootstrap */ "./node_modules/@ng-bootstrap/ng-bootstrap/fesm5/ng-bootstrap.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var src_app_model_Customer__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! src/app/model/Customer */ "./src/app/model/Customer.ts");
/* harmony import */ var src_app_service_customer_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! src/app/service/customer-service */ "./src/app/service/customer-service.ts");
/* harmony import */ var src_app_model_Order__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! src/app/model/Order */ "./src/app/model/Order.ts");
/* harmony import */ var src_app_service_order_service__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! src/app/service/order-service */ "./src/app/service/order-service.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");











var CreateOrderModalComponent = /** @class */ (function () {
    function CreateOrderModalComponent(modal, customerService, orderService, router, formBuilder) {
        this.modal = modal;
        this.customerService = customerService;
        this.orderService = orderService;
        this.router = router;
        this.formBuilder = formBuilder;
        this.customersArray = [];
        this.isFormSubmitted = false;
        this._error = new rxjs__WEBPACK_IMPORTED_MODULE_9__["Subject"]();
    }
    CreateOrderModalComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.createOrderForm = this.formBuilder.group({
            name: ['', [_angular_forms__WEBPACK_IMPORTED_MODULE_3__["Validators"].required]],
            customers: [[], [_angular_forms__WEBPACK_IMPORTED_MODULE_3__["Validators"].required]],
            comment: ['']
        });
        this.customerService.getAllCustomers().subscribe(function (data) {
            console.log(data);
            for (var i = 0; i < data.length; i++) {
                _this.customersArray.push(src_app_model_Customer__WEBPACK_IMPORTED_MODULE_4__["Customer"].fromJson(data[i]));
            }
            _this.createOrderForm.setValue({
                name: '',
                comment: '',
                customers: _this.customersArray
            });
        });
        this._error.subscribe(function (msg) { return _this.errorMessage = msg; });
        this._error.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_10__["debounceTime"])(5000)).subscribe(function () { return _this.errorMessage = null; });
    };
    CreateOrderModalComponent.prototype.changeErrorMessage = function (errorMessage) {
        this._error.next("Order not created : " + errorMessage);
    };
    CreateOrderModalComponent.prototype.settingChanged = function () {
    };
    CreateOrderModalComponent.prototype.onSubmit = function () {
        var _this = this;
        this.isFormSubmitted = true;
        var customer = this.createOrderForm.get("customers").value;
        var orderName = this.createOrderForm.get("name").value;
        var comment = this.createOrderForm.get("comment").value;
        var order = new src_app_model_Order__WEBPACK_IMPORTED_MODULE_6__["Order"]();
        order.name = orderName;
        order.comment = comment;
        order.customer = customer;
        this.orderService.addOrder(order).subscribe(function (data) {
            _this.modal.close(true);
            _this.router.navigate(['/order', data.id]);
        }, function (error) {
            _this.changeErrorMessage(error.error);
        });
    };
    CreateOrderModalComponent.prototype.onClose = function () {
        this.modal.close(false);
    };
    CreateOrderModalComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-create-order-modal',
            template: __webpack_require__(/*! ./create-order-modal.component.html */ "./src/app/modal/create-order-modal/create-order-modal.component.html"),
            styles: [__webpack_require__(/*! ./create-order-modal.component.css */ "./src/app/modal/create-order-modal/create-order-modal.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_2__["NgbActiveModal"],
            src_app_service_customer_service__WEBPACK_IMPORTED_MODULE_5__["CustomerService"],
            src_app_service_order_service__WEBPACK_IMPORTED_MODULE_7__["OrderService"],
            _angular_router__WEBPACK_IMPORTED_MODULE_8__["Router"],
            _angular_forms__WEBPACK_IMPORTED_MODULE_3__["FormBuilder"]])
    ], CreateOrderModalComponent);
    return CreateOrderModalComponent;
}());



/***/ }),

/***/ "./src/app/modal/delete-order-items-modal/delete-order-items-modal.component.css":
/*!***************************************************************************************!*\
  !*** ./src/app/modal/delete-order-items-modal/delete-order-items-modal.component.css ***!
  \***************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".my-custom-scrollbar {\n    position: relative;\n    max-height: 500px;\n    overflow: auto;\n}\n\n.table-wrapper-scroll-y {\n    display: block;\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvbW9kYWwvZGVsZXRlLW9yZGVyLWl0ZW1zLW1vZGFsL2RlbGV0ZS1vcmRlci1pdGVtcy1tb2RhbC5jb21wb25lbnQuY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBO0lBQ0ksa0JBQWtCO0lBQ2xCLGlCQUFpQjtJQUNqQixjQUFjO0FBQ2xCOztBQUVBO0lBQ0ksY0FBYztBQUNsQiIsImZpbGUiOiJzcmMvYXBwL21vZGFsL2RlbGV0ZS1vcmRlci1pdGVtcy1tb2RhbC9kZWxldGUtb3JkZXItaXRlbXMtbW9kYWwuY29tcG9uZW50LmNzcyIsInNvdXJjZXNDb250ZW50IjpbIi5teS1jdXN0b20tc2Nyb2xsYmFyIHtcbiAgICBwb3NpdGlvbjogcmVsYXRpdmU7XG4gICAgbWF4LWhlaWdodDogNTAwcHg7XG4gICAgb3ZlcmZsb3c6IGF1dG87XG59XG5cbi50YWJsZS13cmFwcGVyLXNjcm9sbC15IHtcbiAgICBkaXNwbGF5OiBibG9jaztcbn0iXX0= */"

/***/ }),

/***/ "./src/app/modal/delete-order-items-modal/delete-order-items-modal.component.html":
/*!****************************************************************************************!*\
  !*** ./src/app/modal/delete-order-items-modal/delete-order-items-modal.component.html ***!
  \****************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"modal-header\">\n  <h4 class=\"modal-title\" id=\"modal-basic-title\">{{ title }}</h4>\n  <button type=\"button\" class=\"close\" aria-label=\"Close\" (click)=\"onClickClose()\">\n    <span aria-hidden=\"true\">&times;</span>\n  </button>\n</div>\n<div class=\"modal-body\">\n  <div class=\"table-wrapper-scroll-y my-custom-scrollbar\">\n    <table class=\"table table-striped\">\n      <thead>\n        <tr>\n          <th>#</th>\n          <th>Id</th>\n          <th>Product Name</th>\n          <th>BarCode</th>\n        </tr>\n      </thead>\n      <tbody>\n        <tr *ngFor=\"let item of orderItems; let i = index\">\n          <td>{{ i+1 }}</td>\n          <td>{{ item.productItem.id }}</td>\n          <td>{{ item.productItem.product.name }}</td>\n          <td>{{ item.productItem.barCode }}</td>\n        </tr>\n      </tbody>\n    </table>\n  </div>\n</div>\n<div class=\"modal-footer\">\n<button type=\"button\" class=\"btn btn-secondary\" (click)=\"onClickClose()\">No</button>\n<button type=\"button\" class=\"btn btn-primary\" (click)=\"onClickYes()\">Yes</button>\n</div>\n"

/***/ }),

/***/ "./src/app/modal/delete-order-items-modal/delete-order-items-modal.component.ts":
/*!**************************************************************************************!*\
  !*** ./src/app/modal/delete-order-items-modal/delete-order-items-modal.component.ts ***!
  \**************************************************************************************/
/*! exports provided: DeleteOrderItemsModalComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "DeleteOrderItemsModalComponent", function() { return DeleteOrderItemsModalComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @ng-bootstrap/ng-bootstrap */ "./node_modules/@ng-bootstrap/ng-bootstrap/fesm5/ng-bootstrap.js");



var DeleteOrderItemsModalComponent = /** @class */ (function () {
    function DeleteOrderItemsModalComponent(modal) {
        this.modal = modal;
    }
    DeleteOrderItemsModalComponent.prototype.ngOnInit = function () {
    };
    DeleteOrderItemsModalComponent.prototype.onClickYes = function () {
        this.modal.close(true);
    };
    DeleteOrderItemsModalComponent.prototype.onClickClose = function () {
        this.modal.close(false);
    };
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", String)
    ], DeleteOrderItemsModalComponent.prototype, "title", void 0);
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", Array)
    ], DeleteOrderItemsModalComponent.prototype, "orderItems", void 0);
    DeleteOrderItemsModalComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-delete-order-items-modal',
            template: __webpack_require__(/*! ./delete-order-items-modal.component.html */ "./src/app/modal/delete-order-items-modal/delete-order-items-modal.component.html"),
            styles: [__webpack_require__(/*! ./delete-order-items-modal.component.css */ "./src/app/modal/delete-order-items-modal/delete-order-items-modal.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_2__["NgbActiveModal"]])
    ], DeleteOrderItemsModalComponent);
    return DeleteOrderItemsModalComponent;
}());



/***/ }),

/***/ "./src/app/modal/info-modal/info-modal.component.css":
/*!***********************************************************!*\
  !*** ./src/app/modal/info-modal/info-modal.component.css ***!
  \***********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL21vZGFsL2luZm8tbW9kYWwvaW5mby1tb2RhbC5jb21wb25lbnQuY3NzIn0= */"

/***/ }),

/***/ "./src/app/modal/info-modal/info-modal.component.html":
/*!************************************************************!*\
  !*** ./src/app/modal/info-modal/info-modal.component.html ***!
  \************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"modal-header\">\n  <h4 class=\"modal-title\" id=\"modal-basic-title\">{{ title }}</h4>\n  <button type=\"button\" class=\"close\" aria-label=\"Close\" (click)=\"onClickClose()\">\n    <span aria-hidden=\"true\">&times;</span>\n  </button>\n</div>\n<div class=\"modal-body\">\n  <p>{{ message }}</p>\n</div>\n<div class=\"modal-footer\">\n  <button type=\"button\" class=\"btn btn-secondary\" (click)=\"onClickClose()\">OK</button>\n</div>\n"

/***/ }),

/***/ "./src/app/modal/info-modal/info-modal.component.ts":
/*!**********************************************************!*\
  !*** ./src/app/modal/info-modal/info-modal.component.ts ***!
  \**********************************************************/
/*! exports provided: InfoModalComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "InfoModalComponent", function() { return InfoModalComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @ng-bootstrap/ng-bootstrap */ "./node_modules/@ng-bootstrap/ng-bootstrap/fesm5/ng-bootstrap.js");



var InfoModalComponent = /** @class */ (function () {
    function InfoModalComponent(modal) {
        this.modal = modal;
    }
    InfoModalComponent.prototype.ngOnInit = function () {
    };
    InfoModalComponent.prototype.onClickClose = function () {
        this.modal.close(false);
    };
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", String)
    ], InfoModalComponent.prototype, "title", void 0);
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", String)
    ], InfoModalComponent.prototype, "message", void 0);
    InfoModalComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-info-modal',
            template: __webpack_require__(/*! ./info-modal.component.html */ "./src/app/modal/info-modal/info-modal.component.html"),
            styles: [__webpack_require__(/*! ./info-modal.component.css */ "./src/app/modal/info-modal/info-modal.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_2__["NgbActiveModal"]])
    ], InfoModalComponent);
    return InfoModalComponent;
}());



/***/ }),

/***/ "./src/app/modal/show-order-items-modal/show-order-items-modal.component.css":
/*!***********************************************************************************!*\
  !*** ./src/app/modal/show-order-items-modal/show-order-items-modal.component.css ***!
  \***********************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL21vZGFsL3Nob3ctb3JkZXItaXRlbXMtbW9kYWwvc2hvdy1vcmRlci1pdGVtcy1tb2RhbC5jb21wb25lbnQuY3NzIn0= */"

/***/ }),

/***/ "./src/app/modal/show-order-items-modal/show-order-items-modal.component.html":
/*!************************************************************************************!*\
  !*** ./src/app/modal/show-order-items-modal/show-order-items-modal.component.html ***!
  \************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"modal-header\">\n  <h5 class=\"modal-title\" id=\"modal-basic-title\">Order Items</h5>\n  <button type=\"button\" class=\"close\" aria-label=\"Close\" (click)=\"onClose()\">\n    <span aria-hidden=\"true\">&times;</span>\n  </button>\n</div>\n<div class=\"modal-body\">\n  <table class=\"table table-striped\">\n    <thead>\n      <tr>\n        <th>#</th>\n        <th>Id</th>\n        <th>Name</th>\n        <th>Price</th>\n        <th>Creation Date</th>\n        <th>Last Modified Date</th>\n        <th>BarCode</th>\n      </tr>\n    </thead>\n    <tbody>\n      <tr *ngFor=\"let item of orderItems; let i = index\">\n        <td>{{ i+1 }}</td>\n        <td>{{ item.productItem.id }}</td>\n        <td>{{ item.productItem.product.name }}</td>\n        <td>{{ item.productItem.product.price }} €</td>\n        <td>{{ item.createdDatetime }}</td>\n        <td>{{ item.lastModifiedDatetime }}</td>\n        <td>{{ item.productItem.barCode }}</td>\n      </tr>\n    </tbody>\n  </table>\n</div>\n<div class=\"modal-footer\">\n  <button class=\"btn btn-outline-dark\" (click)=\"onClose()\">Close</button>\n</div>"

/***/ }),

/***/ "./src/app/modal/show-order-items-modal/show-order-items-modal.component.ts":
/*!**********************************************************************************!*\
  !*** ./src/app/modal/show-order-items-modal/show-order-items-modal.component.ts ***!
  \**********************************************************************************/
/*! exports provided: ShowOrderItemsModalComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ShowOrderItemsModalComponent", function() { return ShowOrderItemsModalComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @ng-bootstrap/ng-bootstrap */ "./node_modules/@ng-bootstrap/ng-bootstrap/fesm5/ng-bootstrap.js");



var ShowOrderItemsModalComponent = /** @class */ (function () {
    function ShowOrderItemsModalComponent(modal) {
        this.modal = modal;
    }
    ShowOrderItemsModalComponent.prototype.ngOnInit = function () {
    };
    ShowOrderItemsModalComponent.prototype.onClose = function () {
        this.modal.close(false);
    };
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", Array)
    ], ShowOrderItemsModalComponent.prototype, "orderItems", void 0);
    ShowOrderItemsModalComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-show-order-items-modal',
            template: __webpack_require__(/*! ./show-order-items-modal.component.html */ "./src/app/modal/show-order-items-modal/show-order-items-modal.component.html"),
            styles: [__webpack_require__(/*! ./show-order-items-modal.component.css */ "./src/app/modal/show-order-items-modal/show-order-items-modal.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_2__["NgbActiveModal"]])
    ], ShowOrderItemsModalComponent);
    return ShowOrderItemsModalComponent;
}());



/***/ }),

/***/ "./src/app/model/AggregatedOrder.ts":
/*!******************************************!*\
  !*** ./src/app/model/AggregatedOrder.ts ***!
  \******************************************/
/*! exports provided: AggregatedOrder */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AggregatedOrder", function() { return AggregatedOrder; });
/* harmony import */ var _AggregatedOrderInfo__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./AggregatedOrderInfo */ "./src/app/model/AggregatedOrderInfo.ts");
/* harmony import */ var _AggregatedOrderItem__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./AggregatedOrderItem */ "./src/app/model/AggregatedOrderItem.ts");
/* harmony import */ var _Customer__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./Customer */ "./src/app/model/Customer.ts");



var AggregatedOrder = /** @class */ (function () {
    function AggregatedOrder() {
        this.aggregatedOrderItems = [];
    }
    AggregatedOrder.fromJson = function (data) {
        var order = new AggregatedOrder();
        order.id = data.id;
        order.name = data.name;
        order.customer = _Customer__WEBPACK_IMPORTED_MODULE_2__["Customer"].fromJson(data.customer);
        order.status = data.status;
        order.comment = data.comment;
        order.createdDatetime = data.createdDatetime;
        order.lastModifiedDatetime = data.lastModifiedDatetime;
        order.closeDatetime = data.closeDatetime;
        order.aggregatedOrderInfo = _AggregatedOrderInfo__WEBPACK_IMPORTED_MODULE_0__["AggregatedOrderInfo"].fromJson(data.aggregatedOrderInfo);
        for (var _i = 0, _a = data.aggregatedOrderItems; _i < _a.length; _i++) {
            var item = _a[_i];
            order.aggregatedOrderItems.push(_AggregatedOrderItem__WEBPACK_IMPORTED_MODULE_1__["AggregatedOrderItem"].fromJson(item));
        }
        return order;
    };
    return AggregatedOrder;
}());



/***/ }),

/***/ "./src/app/model/AggregatedOrderInfo.ts":
/*!**********************************************!*\
  !*** ./src/app/model/AggregatedOrderInfo.ts ***!
  \**********************************************/
/*! exports provided: AggregatedOrderInfo */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AggregatedOrderInfo", function() { return AggregatedOrderInfo; });
var AggregatedOrderInfo = /** @class */ (function () {
    function AggregatedOrderInfo() {
    }
    AggregatedOrderInfo.fromJson = function (data) {
        var order = new AggregatedOrderInfo();
        order.orderItemSize = data.orderItemSize;
        order.productSize = data.productSize;
        order.totalPrice = data.totalPrice;
        return order;
    };
    return AggregatedOrderInfo;
}());



/***/ }),

/***/ "./src/app/model/AggregatedOrderItem.ts":
/*!**********************************************!*\
  !*** ./src/app/model/AggregatedOrderItem.ts ***!
  \**********************************************/
/*! exports provided: AggregatedOrderItem */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AggregatedOrderItem", function() { return AggregatedOrderItem; });
/* harmony import */ var _Product__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./Product */ "./src/app/model/Product.ts");
/* harmony import */ var _OrderItem__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./OrderItem */ "./src/app/model/OrderItem.ts");


var AggregatedOrderItem = /** @class */ (function () {
    function AggregatedOrderItem() {
        this.orderItems = [];
    }
    AggregatedOrderItem.fromJson = function (data) {
        var orderItem = new AggregatedOrderItem();
        orderItem.quantity = data.quantity;
        orderItem.ttlPrice = data.ttlPrice;
        orderItem.lastModifiedDatetime = data.lastModifiedDatetime;
        orderItem.product = _Product__WEBPACK_IMPORTED_MODULE_0__["Product"].fromJson(data.product);
        for (var _i = 0, _a = data.orderItems; _i < _a.length; _i++) {
            var item = _a[_i];
            orderItem.orderItems.push(_OrderItem__WEBPACK_IMPORTED_MODULE_1__["OrderItem"].fromJson(item));
        }
        return orderItem;
    };
    return AggregatedOrderItem;
}());



/***/ }),

/***/ "./src/app/model/Customer.ts":
/*!***********************************!*\
  !*** ./src/app/model/Customer.ts ***!
  \***********************************/
/*! exports provided: Customer */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Customer", function() { return Customer; });
/* harmony import */ var _Store__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./Store */ "./src/app/model/Store.ts");

var Customer = /** @class */ (function () {
    function Customer() {
        this.store = new _Store__WEBPACK_IMPORTED_MODULE_0__["Store"]();
    }
    Customer.fromJson = function (data) {
        var customer = new Customer();
        customer.id = data.id;
        customer.store = _Store__WEBPACK_IMPORTED_MODULE_0__["Store"].fromJson(data.store);
        return customer;
    };
    return Customer;
}());



/***/ }),

/***/ "./src/app/model/Order.ts":
/*!********************************!*\
  !*** ./src/app/model/Order.ts ***!
  \********************************/
/*! exports provided: Order */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Order", function() { return Order; });
/* harmony import */ var _Customer__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./Customer */ "./src/app/model/Customer.ts");

var Order = /** @class */ (function () {
    function Order() {
        this.customer = new _Customer__WEBPACK_IMPORTED_MODULE_0__["Customer"]();
        this.items = new Map();
    }
    Order.fromJson = function (data) {
        var itemsQty = data.items.reduce(function (sum, item) { return sum + item.quantity; }, 0);
        var totalPrice = this.getTotalPrice(data.items);
        var sr = new Order();
        sr.id = data.id;
        sr.name = data.name;
        sr.customer = data.customer;
        sr.status = data.status,
            sr.nbProduct = data.items.length;
        sr.createDatetime = data.createdDateTime;
        sr.closeDatetime = data.closeDateTime;
        sr.comment = data.comment;
        sr.totalItemQty = itemsQty;
        sr.totalPrice = totalPrice;
        return sr;
    };
    Order.getTotalPrice = function (items) {
        var total = 0;
        for (var i = 0; i < items.length; i++) {
            total += items[i].productItem.product.price * items[i].quantity;
        }
        return total;
    };
    return Order;
}());



/***/ }),

/***/ "./src/app/model/OrderItem.ts":
/*!************************************!*\
  !*** ./src/app/model/OrderItem.ts ***!
  \************************************/
/*! exports provided: OrderItem */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "OrderItem", function() { return OrderItem; });
/* harmony import */ var _ProductItem__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./ProductItem */ "./src/app/model/ProductItem.ts");

var Type;
(function (Type) {
    Type["GLASSES"] = "GLASSES";
})(Type || (Type = {}));
var OrderItem = /** @class */ (function () {
    function OrderItem() {
        this.type = Type.GLASSES;
    }
    OrderItem.fromJson = function (data) {
        var orderItem = new OrderItem();
        orderItem.id = data.id;
        orderItem.productItem = _ProductItem__WEBPACK_IMPORTED_MODULE_0__["ProductItem"].fromJson(data.productItem);
        orderItem.createdDatetime = data.createdDatetime;
        orderItem.lastModifiedDatetime = data.lastModifiedDatetime;
        return orderItem;
    };
    return OrderItem;
}());



/***/ }),

/***/ "./src/app/model/Owner.ts":
/*!********************************!*\
  !*** ./src/app/model/Owner.ts ***!
  \********************************/
/*! exports provided: Owner */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Owner", function() { return Owner; });
var Owner = /** @class */ (function () {
    function Owner() {
    }
    Owner.fromJson = function (data) {
        var owner = new Owner();
        owner.id = data.id;
        owner.compagnyName = data.compagnyName;
        owner.firstName = data.firstName;
        owner.lastName = data.lastName;
        owner.email = data.email;
        owner.address = data.address;
        return owner;
    };
    return Owner;
}());



/***/ }),

/***/ "./src/app/model/Product.ts":
/*!**********************************!*\
  !*** ./src/app/model/Product.ts ***!
  \**********************************/
/*! exports provided: Product */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Product", function() { return Product; });
var Product = /** @class */ (function () {
    function Product(id, name, price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    Product.fromJson = function (data) {
        var productId = data.id;
        var productName = data.name;
        var productPrice = data.price;
        return new Product(productId, productName, productPrice);
    };
    return Product;
}());



/***/ }),

/***/ "./src/app/model/ProductItem.ts":
/*!**************************************!*\
  !*** ./src/app/model/ProductItem.ts ***!
  \**************************************/
/*! exports provided: ProductItem */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ProductItem", function() { return ProductItem; });
/* harmony import */ var _Product__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./Product */ "./src/app/model/Product.ts");

var ProductItem = /** @class */ (function () {
    function ProductItem() {
    }
    ProductItem.fromJson = function (data) {
        var productItem = new ProductItem();
        productItem.id = data.id;
        productItem.orderItemId = data.orderItemIdOpt;
        productItem.product = _Product__WEBPACK_IMPORTED_MODULE_0__["Product"].fromJson(data.product);
        productItem.createdDatetime = data.createdDatetime;
        productItem.lastModifiedDatetime = data.lastModifiedDatetime;
        if (data.barCode != undefined) {
            productItem.barCode = data.barCode.id;
        }
        return productItem;
    };
    return ProductItem;
}());



/***/ }),

/***/ "./src/app/model/ProductStockInfo.ts":
/*!*******************************************!*\
  !*** ./src/app/model/ProductStockInfo.ts ***!
  \*******************************************/
/*! exports provided: ProductStockInfo */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ProductStockInfo", function() { return ProductStockInfo; });
/* harmony import */ var _Product__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./Product */ "./src/app/model/Product.ts");

var ProductStockInfo = /** @class */ (function () {
    function ProductStockInfo() {
    }
    ProductStockInfo.fromJson = function (data) {
        var stockInfo = new ProductStockInfo();
        stockInfo.product = _Product__WEBPACK_IMPORTED_MODULE_0__["Product"].fromJson(data.product);
        stockInfo.createdQuantity = data.quantityCreated;
        stockInfo.usedQuantity = data.quantityUsed;
        return stockInfo;
    };
    ProductStockInfo.prototype.getFreeQuantity = function () {
        return this.createdQuantity - this.usedQuantity;
    };
    return ProductStockInfo;
}());



/***/ }),

/***/ "./src/app/model/Store.ts":
/*!********************************!*\
  !*** ./src/app/model/Store.ts ***!
  \********************************/
/*! exports provided: Store */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Store", function() { return Store; });
/* harmony import */ var _Owner__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./Owner */ "./src/app/model/Owner.ts");

var Store = /** @class */ (function () {
    function Store() {
    }
    Store.fromJson = function (data) {
        var store = new Store();
        store.id = data.id;
        store.name = data.name;
        store.address = data.address;
        store.email = data.email;
        store.phone = data.phone;
        store.owner = _Owner__WEBPACK_IMPORTED_MODULE_0__["Owner"].fromJson(data.owner);
        return store;
    };
    return Store;
}());



/***/ }),

/***/ "./src/app/model/admin/AdminSetting.ts":
/*!*********************************************!*\
  !*** ./src/app/model/admin/AdminSetting.ts ***!
  \*********************************************/
/*! exports provided: AdminSetting */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AdminSetting", function() { return AdminSetting; });
var AdminSetting = /** @class */ (function () {
    function AdminSetting() {
    }
    return AdminSetting;
}());



/***/ }),

/***/ "./src/app/model/request/customer/AddCustomerReq.ts":
/*!**********************************************************!*\
  !*** ./src/app/model/request/customer/AddCustomerReq.ts ***!
  \**********************************************************/
/*! exports provided: AddCustomerReq */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AddCustomerReq", function() { return AddCustomerReq; });
var AddCustomerReq = /** @class */ (function () {
    function AddCustomerReq(ownerId, storeName) {
        this.ownerId = ownerId;
        this.storeName = storeName;
    }
    return AddCustomerReq;
}());



/***/ }),

/***/ "./src/app/model/request/order/AddOrderItemByBarCodeReq.ts":
/*!*****************************************************************!*\
  !*** ./src/app/model/request/order/AddOrderItemByBarCodeReq.ts ***!
  \*****************************************************************/
/*! exports provided: AddOrderItemByBarCodeReq */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AddOrderItemByBarCodeReq", function() { return AddOrderItemByBarCodeReq; });
var AddOrderItemByBarCodeReq = /** @class */ (function () {
    function AddOrderItemByBarCodeReq(orderId, barCode) {
        this.orderId = orderId;
        this.barCode = barCode;
    }
    return AddOrderItemByBarCodeReq;
}());



/***/ }),

/***/ "./src/app/model/request/order/AddOrderItemReq.ts":
/*!********************************************************!*\
  !*** ./src/app/model/request/order/AddOrderItemReq.ts ***!
  \********************************************************/
/*! exports provided: AddOrderItemReq */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AddOrderItemReq", function() { return AddOrderItemReq; });
var AddOrderItemReq = /** @class */ (function () {
    function AddOrderItemReq(orderId, productId, requestedQty) {
        this.orderId = orderId;
        this.productId = productId;
        this.requestedQty = requestedQty;
    }
    return AddOrderItemReq;
}());



/***/ }),

/***/ "./src/app/model/request/order/DeleteOrderItemsReq.ts":
/*!************************************************************!*\
  !*** ./src/app/model/request/order/DeleteOrderItemsReq.ts ***!
  \************************************************************/
/*! exports provided: DeleteOrderItemsReq */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "DeleteOrderItemsReq", function() { return DeleteOrderItemsReq; });
var DeleteOrderItemsReq = /** @class */ (function () {
    function DeleteOrderItemsReq(orderId, orderItemsId) {
        this.orderId = orderId;
        this.orderItemsId = orderItemsId;
    }
    return DeleteOrderItemsReq;
}());



/***/ }),

/***/ "./src/app/order-panel/list-order-item/list-order-item.component.css":
/*!***************************************************************************!*\
  !*** ./src/app/order-panel/list-order-item/list-order-item.component.css ***!
  \***************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".table tr.active td {\n    background-color:#275e94 !important;\n    color: white;\n    font-weight: bold;\n    white-space: nowrap;\n  }\n\n.table table-striped tr td {\n  padding: 1.5%;\n}\n\n/* Scroll Bar Aggregated Order Item table */\n\n.my-custom-scrollbar {\n  position: relative;\n  max-height: 450px;\n  overflow: auto;\n}\n\n.table-wrapper-scroll-y {\n  display: block;\n}\n\n\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvb3JkZXItcGFuZWwvbGlzdC1vcmRlci1pdGVtL2xpc3Qtb3JkZXItaXRlbS5jb21wb25lbnQuY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBO0lBQ0ksbUNBQW1DO0lBQ25DLFlBQVk7SUFDWixpQkFBaUI7SUFDakIsbUJBQW1CO0VBQ3JCOztBQUVGO0VBQ0UsYUFBYTtBQUNmOztBQUVBLDJDQUEyQzs7QUFDM0M7RUFDRSxrQkFBa0I7RUFDbEIsaUJBQWlCO0VBQ2pCLGNBQWM7QUFDaEI7O0FBRUE7RUFDRSxjQUFjO0FBQ2hCIiwiZmlsZSI6InNyYy9hcHAvb3JkZXItcGFuZWwvbGlzdC1vcmRlci1pdGVtL2xpc3Qtb3JkZXItaXRlbS5jb21wb25lbnQuY3NzIiwic291cmNlc0NvbnRlbnQiOlsiLnRhYmxlIHRyLmFjdGl2ZSB0ZCB7XG4gICAgYmFja2dyb3VuZC1jb2xvcjojMjc1ZTk0ICFpbXBvcnRhbnQ7XG4gICAgY29sb3I6IHdoaXRlO1xuICAgIGZvbnQtd2VpZ2h0OiBib2xkO1xuICAgIHdoaXRlLXNwYWNlOiBub3dyYXA7XG4gIH1cblxuLnRhYmxlIHRhYmxlLXN0cmlwZWQgdHIgdGQge1xuICBwYWRkaW5nOiAxLjUlO1xufVxuXG4vKiBTY3JvbGwgQmFyIEFnZ3JlZ2F0ZWQgT3JkZXIgSXRlbSB0YWJsZSAqL1xuLm15LWN1c3RvbS1zY3JvbGxiYXIge1xuICBwb3NpdGlvbjogcmVsYXRpdmU7XG4gIG1heC1oZWlnaHQ6IDQ1MHB4O1xuICBvdmVyZmxvdzogYXV0bztcbn1cblxuLnRhYmxlLXdyYXBwZXItc2Nyb2xsLXkge1xuICBkaXNwbGF5OiBibG9jaztcbn1cblxuIl19 */"

/***/ }),

/***/ "./src/app/order-panel/list-order-item/list-order-item.component.html":
/*!****************************************************************************!*\
  !*** ./src/app/order-panel/list-order-item/list-order-item.component.html ***!
  \****************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"table-responsive table-wrapper-scroll-y my-custom-scrollbar\">\n  <table class=\"table table-striped table-hover\">\n    <thead>\n      <tr>\n        <th>#</th>\n        <th>Name</th>\n        <th>Price</th>\n        <th>Qty</th>\n        <th>Total Price</th>\n        <th>Last Modified Date</th>\n        <th></th>\n      </tr>\n    </thead>\n    <tbody>\n      <tr *ngFor=\"let item of orderItems | filter : 'name' : searchString; let i = index\"\n      (click)=\"setSelectedRow(i); onClickShowSelectedOrderItems(item.orderItems)\"\n        [class.active]=\"i == selectedRow\">\n        <td>{{ i+1 }}</td>\n        <td>{{ item.product.name }}</td>\n        <td>{{ item.product.price }} €</td>\n        <td\n          contenteditable=\"order.status !== 'CLOSED'\"\n          (blur)=\"onChangeOrderItemQuantity(item, $event)\">\n          {{ item.quantity }}\n        </td>\n        <td>{{ item.ttlPrice }} €</td>\n        <td>{{ item.lastModifiedDatetime | date:'medium' }}</td>\n        <td>\n          <button *ngIf=\"order.status !== 'CLOSED'\"\n          (click)=\"onClickDeleteOrderItemButton(i, item.orderItems)\"\n          [disabled]=\"deleteOrderItemInProgressArray[i]\"\n          class=\"btn btn-danger btn-sm\">\n              <span *ngIf=\"deleteOrderItemInProgressArray[i]\" class=\"spinner-border spinner-border-sm\" role=\"status\" aria-hidden=\"true\"></span>\n            Delete</button>\n        </td>\n      </tr>\n    </tbody>\n  </table>\n</div>\n<br>\n<selected-order-items-list\n  [selectedOrderItems]=\"selectedOrderItems\"\n  [order]=\"order\"\n  (onDeleteOrderItemEvent)=\"deleteSingleOrderItem($event)\"\n></selected-order-items-list>\n"

/***/ }),

/***/ "./src/app/order-panel/list-order-item/list-order-item.component.ts":
/*!**************************************************************************!*\
  !*** ./src/app/order-panel/list-order-item/list-order-item.component.ts ***!
  \**************************************************************************/
/*! exports provided: ListOrderItemComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ListOrderItemComponent", function() { return ListOrderItemComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var src_app_service_order_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! src/app/service/order-service */ "./src/app/service/order-service.ts");
/* harmony import */ var src_app_common_components_modal_builder__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! src/app/common-components/modal-builder */ "./src/app/common-components/modal-builder.ts");
/* harmony import */ var src_app_modal_info_modal_info_modal_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! src/app/modal/info-modal/info-modal.component */ "./src/app/modal/info-modal/info-modal.component.ts");
/* harmony import */ var src_app_service_product_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! src/app/service/product-service */ "./src/app/service/product-service.ts");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var src_app_model_AggregatedOrder__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! src/app/model/AggregatedOrder */ "./src/app/model/AggregatedOrder.ts");
/* harmony import */ var src_app_modal_delete_order_items_modal_delete_order_items_modal_component__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! src/app/modal/delete-order-items-modal/delete-order-items-modal.component */ "./src/app/modal/delete-order-items-modal/delete-order-items-modal.component.ts");
/* harmony import */ var src_app_model_request_order_DeleteOrderItemsReq__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! src/app/model/request/order/DeleteOrderItemsReq */ "./src/app/model/request/order/DeleteOrderItemsReq.ts");










var ListOrderItemComponent = /** @class */ (function () {
    function ListOrderItemComponent(orderService, productService, modalBuilder) {
        var _this = this;
        this.orderService = orderService;
        this.productService = productService;
        this.modalBuilder = modalBuilder;
        this.areNewOrderItemFieldsSet = false;
        this.selectedOrderItems = new Map();
        this.productNames = [];
        this.deleteOrderItemInProgressArray = [];
        this.productIdMapByName = new Map();
        this.search = function (text$) {
            return text$.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_6__["debounceTime"])(200), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_6__["distinctUntilChanged"])(), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_6__["map"])(function (term) { return term.length < 1 ? []
                : _this.productNames.filter(function (v) { return v.toLowerCase().indexOf(term.toLowerCase()) > -1; }).slice(0, 10); }));
        };
        this.onCreateOrderItemEvent = new _angular_core__WEBPACK_IMPORTED_MODULE_1__["EventEmitter"]();
        this.onChangeOrderItemEvent = new _angular_core__WEBPACK_IMPORTED_MODULE_1__["EventEmitter"]();
        this.onDeleteOrderItemEvent = new _angular_core__WEBPACK_IMPORTED_MODULE_1__["EventEmitter"]();
    }
    ListOrderItemComponent.prototype.ngOnInit = function () {
        this.initDeleteOrderItemButtonStatus();
    };
    ListOrderItemComponent.prototype.initDeleteOrderItemButtonStatus = function () {
        for (var i = 0; i < this.deleteOrderItemInProgressArray.length; i++) {
            this.deleteOrderItemInProgressArray.push(false);
        }
    };
    ListOrderItemComponent.prototype.checkInputFieldSet = function () {
        this.areNewOrderItemFieldsSet = this.inputName.trim().length > 0
            && this.inputQuantity > 0
            && this.inputPrice > 0;
    };
    ListOrderItemComponent.prototype.deleteSingleOrderItem = function (orderItem) {
        var orderItems = [orderItem];
        this.deleteOrderItem(orderItems);
        this.selectedOrderItems.delete(orderItem.id);
    };
    ListOrderItemComponent.prototype.deleteOrderItem = function (orderItems) {
        var _this = this;
        var ids = orderItems.map(function (item) { return item.id; });
        var req = new src_app_model_request_order_DeleteOrderItemsReq__WEBPACK_IMPORTED_MODULE_9__["DeleteOrderItemsReq"](this.order.id, ids);
        this.orderService.deleteOrderItems(req).subscribe(function (data) {
            _this.onDeleteOrderItemEvent.emit(ids);
            _this.deleteFromSelectedOrderItem(ids);
        }, function (error) {
            var modalRef = _this.modalBuilder.open(src_app_modal_info_modal_info_modal_component__WEBPACK_IMPORTED_MODULE_4__["InfoModalComponent"]);
            modalRef.componentInstance.title = "Error : Failed to delete the order items.";
            modalRef.componentInstance.message = error.error;
        });
    };
    ListOrderItemComponent.prototype.deleteFromSelectedOrderItem = function (ids) {
        for (var _i = 0, ids_1 = ids; _i < ids_1.length; _i++) {
            var id = ids_1[_i];
            this.selectedOrderItems.delete(id);
        }
    };
    ListOrderItemComponent.prototype.onClickDeleteOrderItemButton = function (rowTableIndex, orderItems) {
        this.setDeleteOrderItemButtonStatus(rowTableIndex, true);
        this.displayDeletionConfirmationModal(rowTableIndex, orderItems);
    };
    ListOrderItemComponent.prototype.displayDeletionConfirmationModal = function (rowTableIndex, orderItems) {
        var _this = this;
        var modalRef = this.modalBuilder.openCenteredLargeModal(src_app_modal_delete_order_items_modal_delete_order_items_modal_component__WEBPACK_IMPORTED_MODULE_8__["DeleteOrderItemsModalComponent"]);
        modalRef.componentInstance.title = "Are you sure you want to delete the following order items ?";
        modalRef.componentInstance.orderItems = orderItems;
        modalRef.result.then(function (response) {
            if (response) {
                _this.deleteOrderItem(orderItems);
            }
            _this.setDeleteOrderItemButtonStatus(rowTableIndex, false);
        });
    };
    ListOrderItemComponent.prototype.onChangeOrderItemQuantity = function (orderItem, event) {
        /*let newQuantity = event.target.textContent
        if (orderItem.quantity != newQuantity) {
          let req = new ModifyOrderItemReq(orderItem.id, newQuantity);
          // Must send Http request.
          this.onChangeOrderItemEvent.emit(req)
        } */
    };
    ListOrderItemComponent.prototype.setSelectedRow = function (index) {
        this.selectedRow = index;
    };
    ListOrderItemComponent.prototype.onClickShowSelectedOrderItems = function (selectedOrderItems) {
        var tmp = new Map();
        for (var _i = 0, selectedOrderItems_1 = selectedOrderItems; _i < selectedOrderItems_1.length; _i++) {
            var orderItem = selectedOrderItems_1[_i];
            tmp.set(orderItem.id, orderItem);
        }
        this.selectedOrderItems = tmp;
    };
    ListOrderItemComponent.prototype.setDeleteOrderItemButtonStatus = function (index, isInProgress) {
        this.deleteOrderItemInProgressArray[index] = isInProgress;
    };
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", Object)
    ], ListOrderItemComponent.prototype, "orderItems", void 0);
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", src_app_model_AggregatedOrder__WEBPACK_IMPORTED_MODULE_7__["AggregatedOrder"])
    ], ListOrderItemComponent.prototype, "order", void 0);
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Output"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", Object)
    ], ListOrderItemComponent.prototype, "onCreateOrderItemEvent", void 0);
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Output"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", Object)
    ], ListOrderItemComponent.prototype, "onChangeOrderItemEvent", void 0);
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Output"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", Object)
    ], ListOrderItemComponent.prototype, "onDeleteOrderItemEvent", void 0);
    ListOrderItemComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'list-order-item',
            template: __webpack_require__(/*! ./list-order-item.component.html */ "./src/app/order-panel/list-order-item/list-order-item.component.html"),
            styles: [__webpack_require__(/*! ./list-order-item.component.css */ "./src/app/order-panel/list-order-item/list-order-item.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [src_app_service_order_service__WEBPACK_IMPORTED_MODULE_2__["OrderService"],
            src_app_service_product_service__WEBPACK_IMPORTED_MODULE_5__["ProductService"],
            src_app_common_components_modal_builder__WEBPACK_IMPORTED_MODULE_3__["ModalBuilder"]])
    ], ListOrderItemComponent);
    return ListOrderItemComponent;
}());



/***/ }),

/***/ "./src/app/order-panel/selected-order-items-list/selected-order-items-list.component.css":
/*!***********************************************************************************************!*\
  !*** ./src/app/order-panel/selected-order-items-list/selected-order-items-list.component.css ***!
  \***********************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "/* Scroll Bar Aggregated Order Item table */\n.my-custom-scrollbar {\n    position: relative;\n    max-height: 200px;\n    overflow: auto;\n  }\n.table-wrapper-scroll-y {\n    display: block;\n  }\n  \n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvb3JkZXItcGFuZWwvc2VsZWN0ZWQtb3JkZXItaXRlbXMtbGlzdC9zZWxlY3RlZC1vcmRlci1pdGVtcy1saXN0LmNvbXBvbmVudC5jc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUEsMkNBQTJDO0FBQzNDO0lBQ0ksa0JBQWtCO0lBQ2xCLGlCQUFpQjtJQUNqQixjQUFjO0VBQ2hCO0FBRUE7SUFDRSxjQUFjO0VBQ2hCIiwiZmlsZSI6InNyYy9hcHAvb3JkZXItcGFuZWwvc2VsZWN0ZWQtb3JkZXItaXRlbXMtbGlzdC9zZWxlY3RlZC1vcmRlci1pdGVtcy1saXN0LmNvbXBvbmVudC5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyIvKiBTY3JvbGwgQmFyIEFnZ3JlZ2F0ZWQgT3JkZXIgSXRlbSB0YWJsZSAqL1xuLm15LWN1c3RvbS1zY3JvbGxiYXIge1xuICAgIHBvc2l0aW9uOiByZWxhdGl2ZTtcbiAgICBtYXgtaGVpZ2h0OiAyMDBweDtcbiAgICBvdmVyZmxvdzogYXV0bztcbiAgfVxuICBcbiAgLnRhYmxlLXdyYXBwZXItc2Nyb2xsLXkge1xuICAgIGRpc3BsYXk6IGJsb2NrO1xuICB9XG4gICJdfQ== */"

/***/ }),

/***/ "./src/app/order-panel/selected-order-items-list/selected-order-items-list.component.html":
/*!************************************************************************************************!*\
  !*** ./src/app/order-panel/selected-order-items-list/selected-order-items-list.component.html ***!
  \************************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"table-responsive table-wrapper-scroll-y my-custom-scrollbar\">\n  <table class=\"table table-striped table-hover table-sm\">\n    <thead>\n      <tr>\n        <th>#</th>\n        <th>Id</th>\n        <th>BarCode</th>\n        <th>Created Date</th>\n        <th>Last Modified Date</th>\n        <th></th>\n      </tr>\n    </thead>\n    <tbody>\n      <tr *ngFor=\"let item of selectedOrderItems.values(); let i = index\">\n        <td>{{ i+1 }}</td>\n        <td>{{ item.productItem.id }}</td>\n        <td>{{ item.productItem.barCode }}</td>\n        <td>{{ item.createdDatetime }}</td>\n        <td>{{ item.lastModifiedDatetime }}</td>\n        <td>\n          <button\n          (click)=\"onClickDeleteOrderItemButton(i, item)\"\n          [disabled]=\"deleteOrderItemInProgressArray[i]\"\n          class=\"btn btn-danger btn-sm\">\n          <span *ngIf=\"deleteOrderItemInProgressArray[i]\" class=\"spinner-border spinner-border-sm\" role=\"status\" aria-hidden=\"true\"></span>\n            Delete</button>\n        </td>\n      </tr>\n    </tbody>\n  </table>\n</div>"

/***/ }),

/***/ "./src/app/order-panel/selected-order-items-list/selected-order-items-list.component.ts":
/*!**********************************************************************************************!*\
  !*** ./src/app/order-panel/selected-order-items-list/selected-order-items-list.component.ts ***!
  \**********************************************************************************************/
/*! exports provided: SelectedOrderItemsListComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "SelectedOrderItemsListComponent", function() { return SelectedOrderItemsListComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var src_app_modal_delete_order_items_modal_delete_order_items_modal_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! src/app/modal/delete-order-items-modal/delete-order-items-modal.component */ "./src/app/modal/delete-order-items-modal/delete-order-items-modal.component.ts");
/* harmony import */ var src_app_common_components_modal_builder__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! src/app/common-components/modal-builder */ "./src/app/common-components/modal-builder.ts");
/* harmony import */ var src_app_model_AggregatedOrder__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! src/app/model/AggregatedOrder */ "./src/app/model/AggregatedOrder.ts");
/* harmony import */ var src_app_model_request_order_DeleteOrderItemsReq__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! src/app/model/request/order/DeleteOrderItemsReq */ "./src/app/model/request/order/DeleteOrderItemsReq.ts");
/* harmony import */ var src_app_service_order_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! src/app/service/order-service */ "./src/app/service/order-service.ts");
/* harmony import */ var src_app_modal_info_modal_info_modal_component__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! src/app/modal/info-modal/info-modal.component */ "./src/app/modal/info-modal/info-modal.component.ts");








var SelectedOrderItemsListComponent = /** @class */ (function () {
    function SelectedOrderItemsListComponent(modalBuilder, orderService) {
        this.modalBuilder = modalBuilder;
        this.orderService = orderService;
        this.selectedOrderItems = new Map();
        this.onDeleteOrderItemEvent = new _angular_core__WEBPACK_IMPORTED_MODULE_1__["EventEmitter"]();
        this.deleteOrderItemInProgressArray = [];
    }
    SelectedOrderItemsListComponent.prototype.ngOnInit = function () {
        this.initDeleteOrderItemButtonStatus();
    };
    SelectedOrderItemsListComponent.prototype.initDeleteOrderItemButtonStatus = function () {
        for (var i = 0; i < this.deleteOrderItemInProgressArray.length; i++) {
            this.deleteOrderItemInProgressArray.push(false);
        }
    };
    SelectedOrderItemsListComponent.prototype.onClickDeleteOrderItemButton = function (rowTableIndex, orderItem) {
        this.setDeleteOrderItemButtonStatus(rowTableIndex, true);
        this.displayDeletionConfirmationModal(rowTableIndex, orderItem);
    };
    SelectedOrderItemsListComponent.prototype.displayDeletionConfirmationModal = function (rowTableIndex, orderItem) {
        var _this = this;
        var modalRef = this.modalBuilder.openCenteredLargeModal(src_app_modal_delete_order_items_modal_delete_order_items_modal_component__WEBPACK_IMPORTED_MODULE_2__["DeleteOrderItemsModalComponent"]);
        modalRef.componentInstance.title = "Are you sure you want to delete the following order item ?";
        var orderItemToDelete = [];
        orderItemToDelete.push(orderItem);
        modalRef.componentInstance.orderItems = orderItemToDelete;
        modalRef.result.then(function (response) {
            if (response) {
                _this.onDeleteOrderItemEvent.emit(orderItem);
                //this.deleteOrderItem(orderItem);
            }
            _this.setDeleteOrderItemButtonStatus(rowTableIndex, false);
        });
    };
    SelectedOrderItemsListComponent.prototype.deleteOrderItem = function (orderItem) {
        var _this = this;
        var id = [orderItem.id];
        var req = new src_app_model_request_order_DeleteOrderItemsReq__WEBPACK_IMPORTED_MODULE_5__["DeleteOrderItemsReq"](this.order.id, id);
        this.orderService.deleteOrderItems(req).subscribe(function (data) {
            _this.selectedOrderItems.delete(orderItem.id);
        }, function (error) {
            var modalRef = _this.modalBuilder.open(src_app_modal_info_modal_info_modal_component__WEBPACK_IMPORTED_MODULE_7__["InfoModalComponent"]);
            modalRef.componentInstance.title = "Error : Failed to delete the order items.";
            modalRef.componentInstance.message = error.error;
        });
    };
    SelectedOrderItemsListComponent.prototype.setDeleteOrderItemButtonStatus = function (index, isInProgress) {
        this.deleteOrderItemInProgressArray[index] = isInProgress;
    };
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", Map)
    ], SelectedOrderItemsListComponent.prototype, "selectedOrderItems", void 0);
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", src_app_model_AggregatedOrder__WEBPACK_IMPORTED_MODULE_4__["AggregatedOrder"])
    ], SelectedOrderItemsListComponent.prototype, "order", void 0);
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Output"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", Object)
    ], SelectedOrderItemsListComponent.prototype, "onDeleteOrderItemEvent", void 0);
    SelectedOrderItemsListComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'selected-order-items-list',
            template: __webpack_require__(/*! ./selected-order-items-list.component.html */ "./src/app/order-panel/selected-order-items-list/selected-order-items-list.component.html"),
            styles: [__webpack_require__(/*! ./selected-order-items-list.component.css */ "./src/app/order-panel/selected-order-items-list/selected-order-items-list.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [src_app_common_components_modal_builder__WEBPACK_IMPORTED_MODULE_3__["ModalBuilder"],
            src_app_service_order_service__WEBPACK_IMPORTED_MODULE_6__["OrderService"]])
    ], SelectedOrderItemsListComponent);
    return SelectedOrderItemsListComponent;
}());



/***/ }),

/***/ "./src/app/order-panel/show-order-header/show-order-header.component.css":
/*!*******************************************************************************!*\
  !*** ./src/app/order-panel/show-order-header/show-order-header.component.css ***!
  \*******************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL29yZGVyLXBhbmVsL3Nob3ctb3JkZXItaGVhZGVyL3Nob3ctb3JkZXItaGVhZGVyLmNvbXBvbmVudC5jc3MifQ== */"

/***/ }),

/***/ "./src/app/order-panel/show-order-header/show-order-header.component.html":
/*!********************************************************************************!*\
  !*** ./src/app/order-panel/show-order-header/show-order-header.component.html ***!
  \********************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container-fluid\" style=\"border-bottom: 1px solid black\">\n  <div class=\"row\">\n    <div class=\"col\">\n      <h5>{{ order.name }}</h5>\n    </div>\n    <div class=\"col\">\n      <p>Comment : {{ order.comment }}</p>\n    </div>\n    <div class=\"col\">\n      <div style=\"overflow: hidden;\">\n        <p style=\"float: left\">Customer : &nbsp;</p>\n        <p style=\"float: left; font-weight: bold\"> {{ order.storeName }}</p>\n      </div>\n    </div>\n    <div class=\"col\">\n      <div style=\"overflow: hidden;\">\n        <p style=\"float: left;\">Status :&nbsp;</p>\n        <p style=\"float: left; font-weight: bold\"> {{ order.status }}</p>\n      </div>\n    </div>\n  </div>\n  <div class=\"row\">\n    <div class=\"col\">\n      <div class=\"row justify-content-between\">\n          <div class=\"col-4\">\n              <button\n                class=\"btn btn-outline-primary\"\n                (click)=\"onClickAddOrderItem()\"\n                [disabled]=\"order.status === 'CLOSED'\"\n              >Add Order Item</button>\n          </div>\n          <div class=\"col-4\">\n              <button\n                style=\"float: right\"\n                class=\"btn btn-outline-info\"\n                (click)=\"onClickCloseOrder()\"\n                [disabled]=\"order.status === 'CLOSED'\"\n              >Close the order</button>\n          </div>\n      </div>\n    </div>\n  </div>    \n  <br>\n</div>"

/***/ }),

/***/ "./src/app/order-panel/show-order-header/show-order-header.component.ts":
/*!******************************************************************************!*\
  !*** ./src/app/order-panel/show-order-header/show-order-header.component.ts ***!
  \******************************************************************************/
/*! exports provided: OrderHeaderComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "OrderHeaderComponent", function() { return OrderHeaderComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var src_app_common_components_modal_builder__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! src/app/common-components/modal-builder */ "./src/app/common-components/modal-builder.ts");
/* harmony import */ var src_app_modal_confirm_modal_confirm_modal_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! src/app/modal/confirm-modal/confirm-modal-component */ "./src/app/modal/confirm-modal/confirm-modal-component.ts");
/* harmony import */ var src_app_service_order_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! src/app/service/order-service */ "./src/app/service/order-service.ts");
/* harmony import */ var src_app_model_AggregatedOrder__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! src/app/model/AggregatedOrder */ "./src/app/model/AggregatedOrder.ts");
/* harmony import */ var src_app_modal_add_order_item_modal_add_order_item_modal_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! src/app/modal/add-order-item-modal/add-order-item-modal.component */ "./src/app/modal/add-order-item-modal/add-order-item-modal.component.ts");







var OrderHeaderComponent = /** @class */ (function () {
    function OrderHeaderComponent(modalBuilder, orderService) {
        this.modalBuilder = modalBuilder;
        this.orderService = orderService;
        this.onCloseOrderEvent = new _angular_core__WEBPACK_IMPORTED_MODULE_1__["EventEmitter"]();
        this.onAddOrderItemEvent = new _angular_core__WEBPACK_IMPORTED_MODULE_1__["EventEmitter"]();
    }
    OrderHeaderComponent.prototype.ngOnInit = function () {
    };
    OrderHeaderComponent.prototype.onClickAddOrderItem = function () {
        var _this = this;
        var modalRef = this.modalBuilder.openCenteredLargeModal(src_app_modal_add_order_item_modal_add_order_item_modal_component__WEBPACK_IMPORTED_MODULE_6__["AddOrderItemModalComponent"]);
        modalRef.componentInstance.orderId = this.order.id;
        modalRef.result.then(function (response) {
            if (response) {
                _this.onAddOrderItemEvent.emit();
            }
        });
    };
    OrderHeaderComponent.prototype.onClickCloseOrder = function () {
        var _this = this;
        var modalRef = this.modalBuilder.open(src_app_modal_confirm_modal_confirm_modal_component__WEBPACK_IMPORTED_MODULE_3__["ConfirmModalComponent"]);
        modalRef.componentInstance.title = "Close Order Confirmation";
        modalRef.componentInstance.message = "Are you sure you want to close the order "
            + this.order.name + " for the store " + this.order.customer.store.name + " ?";
        modalRef.result.then(function (response) {
            if (response) {
                _this.orderService.closeOrder(_this.order.id).subscribe(function (data) {
                    _this.order.closeDatetime = data.closeDateTime;
                    _this.order.status = data.status;
                });
            }
        });
    };
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", src_app_model_AggregatedOrder__WEBPACK_IMPORTED_MODULE_5__["AggregatedOrder"])
    ], OrderHeaderComponent.prototype, "order", void 0);
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Output"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", Object)
    ], OrderHeaderComponent.prototype, "onCloseOrderEvent", void 0);
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Output"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", Object)
    ], OrderHeaderComponent.prototype, "onAddOrderItemEvent", void 0);
    OrderHeaderComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'show-order-header',
            template: __webpack_require__(/*! ./show-order-header.component.html */ "./src/app/order-panel/show-order-header/show-order-header.component.html"),
            styles: [__webpack_require__(/*! ./show-order-header.component.css */ "./src/app/order-panel/show-order-header/show-order-header.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [src_app_common_components_modal_builder__WEBPACK_IMPORTED_MODULE_2__["ModalBuilder"],
            src_app_service_order_service__WEBPACK_IMPORTED_MODULE_4__["OrderService"]])
    ], OrderHeaderComponent);
    return OrderHeaderComponent;
}());



/***/ }),

/***/ "./src/app/order-panel/show-order/show-order.component.css":
/*!*****************************************************************!*\
  !*** ./src/app/order-panel/show-order/show-order.component.css ***!
  \*****************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL29yZGVyLXBhbmVsL3Nob3ctb3JkZXIvc2hvdy1vcmRlci5jb21wb25lbnQuY3NzIn0= */"

/***/ }),

/***/ "./src/app/order-panel/show-order/show-order.component.html":
/*!******************************************************************!*\
  !*** ./src/app/order-panel/show-order/show-order.component.html ***!
  \******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div>\n  <show-order-header\n    [order]=\"order\"\n    (onCloseOrderEvent)=\"onCloseOrder()\"\n    (onAddOrderItemEvent)=\"onOrderItemAdded()\"\n  ></show-order-header>\n  <list-order-item *ngIf=\"order\"\n    [order]=\"order\"\n    [orderItems]=\"order.aggregatedOrderItems.values()\"\n    (onCreateOrderItemEvent)=\"onNewOrderItem($event)\"\n    (onChangeOrderItemEvent)=\"onChangeOrderItem($event)\"\n    (onDeleteOrderItemEvent)=\"onDeleteOrderItem($event)\"\n  ></list-order-item>\n  <div class=\"container=fluid\">\n    <button class=\"btn btn-primary\"\n        (click)=\"onClickBack()\"\n        style=\"float: right\"\n    >Back</button>\n</div>\n</div>"

/***/ }),

/***/ "./src/app/order-panel/show-order/show-order.component.ts":
/*!****************************************************************!*\
  !*** ./src/app/order-panel/show-order/show-order.component.ts ***!
  \****************************************************************/
/*! exports provided: ShowOrderComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ShowOrderComponent", function() { return ShowOrderComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _service_order_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../service/order-service */ "./src/app/service/order-service.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var src_app_model_AggregatedOrder__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! src/app/model/AggregatedOrder */ "./src/app/model/AggregatedOrder.ts");





var ShowOrderComponent = /** @class */ (function () {
    function ShowOrderComponent(orderService, route, router) {
        this.orderService = orderService;
        this.route = route;
        this.router = router;
        this.reportId = 1;
    }
    ShowOrderComponent.prototype.ngOnInit = function () {
        this.order = new src_app_model_AggregatedOrder__WEBPACK_IMPORTED_MODULE_4__["AggregatedOrder"]();
        this.order.id = parseInt(this.route.snapshot.paramMap.get('id'));
        this.refreshOrder();
    };
    ShowOrderComponent.prototype.onOrderItemAdded = function (orderItem) {
        this.refreshOrder();
    };
    ShowOrderComponent.prototype.onChangeOrderItem = function (orderItem) {
        //this.order.items.set(orderItem.id, orderItem)
    };
    ShowOrderComponent.prototype.onDeleteOrderItem = function (ids) {
        this.refreshOrder();
    };
    ShowOrderComponent.prototype.onClickBack = function () {
        this.router.navigate(['']);
    };
    ShowOrderComponent.prototype.refreshOrder = function () {
        var _this = this;
        this.orderService.getOrder(this.order.id).subscribe(function (data) {
            _this.order = src_app_model_AggregatedOrder__WEBPACK_IMPORTED_MODULE_4__["AggregatedOrder"].fromJson(data);
        });
    };
    ShowOrderComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'show-order',
            template: __webpack_require__(/*! ./show-order.component.html */ "./src/app/order-panel/show-order/show-order.component.html"),
            changeDetection: _angular_core__WEBPACK_IMPORTED_MODULE_1__["ChangeDetectionStrategy"].Default,
            styles: [__webpack_require__(/*! ./show-order.component.css */ "./src/app/order-panel/show-order/show-order.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_service_order_service__WEBPACK_IMPORTED_MODULE_2__["OrderService"],
            _angular_router__WEBPACK_IMPORTED_MODULE_3__["ActivatedRoute"],
            _angular_router__WEBPACK_IMPORTED_MODULE_3__["Router"]])
    ], ShowOrderComponent);
    return ShowOrderComponent;
}());



/***/ }),

/***/ "./src/app/orders-manager-panel/list-orders/list-orders.component.css":
/*!****************************************************************************!*\
  !*** ./src/app/orders-manager-panel/list-orders/list-orders.component.css ***!
  \****************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL29yZGVycy1tYW5hZ2VyLXBhbmVsL2xpc3Qtb3JkZXJzL2xpc3Qtb3JkZXJzLmNvbXBvbmVudC5jc3MifQ== */"

/***/ }),

/***/ "./src/app/orders-manager-panel/list-orders/list-orders.component.html":
/*!*****************************************************************************!*\
  !*** ./src/app/orders-manager-panel/list-orders/list-orders.component.html ***!
  \*****************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"table-responsive\">\n    <table class=\"table table-striped\">\n        <thead>\n            <tr>\n                <th>ID</th>\n                <th>Name</th>\n                <th>Store</th>\n                <th>Status</th>\n                <th>Total Product</th>\n                <th>Total Qty</th>\n                <th>Total Price</th>\n                <th>Creation Date</th>\n                <th>Last Modified Date</th>\n                <th>Close Date</th>\n                <th></th>\n                <th></th>\n            </tr>\n        </thead>\n        <tbody>\n            <tr *ngFor=\"let order of ordersArray\">\n                <td>{{ order.id }}</td>\n                <td>{{ order.name }}</td>\n                <td>{{ order.storeName }}</td>\n                <td>{{ order.status }}</td>\n                <td>{{ order.aggregatedOrderInfo.productSize }}</td>\n                <td>{{ order.aggregatedOrderInfo.orderItemSize }}</td>\n                <td>{{ order.aggregatedOrderInfo.totalPrice }} €</td>\n                <td>{{ order.createdDatetime  | date:'medium' }}</td>\n                <td>{{ order.lastModifiedDatetime  | date:'medium' }}</td>\n                <td>{{ order.closeDatetime  | date:'medium' }}</td>\n                <td><button\n                    class=\"btn btn-success\"\n                    [routerLink]=\"['/order', order.id]\"\n                    >See</button>\n                </td>\n                <td><button\n                    *ngIf=\"order.status !== 'CLOSED'\"\n                    class=\"btn btn-info\"\n                    (click)=\"onClickCloseOrder(order)\"\n                    >Close Order</button>\n                    <button\n                        *ngIf=\"order.status === 'CLOSED'\"\n                        class=\"btn btn-primary\"\n                        (click)=\"onClickNotify(order)\"\n                    >Notify</button>\n                </td>\n            </tr>\n        </tbody>\n    </table>\n</div>\n<div class=\"row justify-content-between\">\n    <div class=\"col-4\">\n        <ngb-pagination [collectionSize]=\"collectionSize\" [(page)]=\"page\" [pageSize]=\"pageSize\"></ngb-pagination>\n    </div>\n    <div class=\"col-2\">\n        <select class=\"custom-select\" [(ngModel)]=\"pageSize\">\n            <option [ngValue]=\"5\">5 items per page</option>\n            <option [ngValue]=\"10\">10 items per page</option>\n            <option [ngValue]=\"20\">20 items per page</option>\n        </select>\n    </div>\n</div>\n"

/***/ }),

/***/ "./src/app/orders-manager-panel/list-orders/list-orders.component.ts":
/*!***************************************************************************!*\
  !*** ./src/app/orders-manager-panel/list-orders/list-orders.component.ts ***!
  \***************************************************************************/
/*! exports provided: ListOrdersComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ListOrdersComponent", function() { return ListOrdersComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var src_app_service_order_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! src/app/service/order-service */ "./src/app/service/order-service.ts");
/* harmony import */ var src_app_service_notification_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! src/app/service/notification-service */ "./src/app/service/notification-service.ts");
/* harmony import */ var src_app_common_components_modal_builder__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! src/app/common-components/modal-builder */ "./src/app/common-components/modal-builder.ts");
/* harmony import */ var src_app_modal_confirm_modal_confirm_modal_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! src/app/modal/confirm-modal/confirm-modal-component */ "./src/app/modal/confirm-modal/confirm-modal-component.ts");






var ListOrdersComponent = /** @class */ (function () {
    function ListOrdersComponent(orderService, notificationService, modalBuilder) {
        this.orderService = orderService;
        this.notificationService = notificationService;
        this.modalBuilder = modalBuilder;
        this.page = 1;
        this.pageSize = 4;
    }
    ListOrdersComponent.prototype.ngOnInit = function () {
        this.collectionSize = this.orders.length;
    };
    ListOrdersComponent.prototype.onClickCloseOrder = function (orderToClose) {
        var _this = this;
        var modalRef = this.modalBuilder.open(src_app_modal_confirm_modal_confirm_modal_component__WEBPACK_IMPORTED_MODULE_5__["ConfirmModalComponent"]);
        modalRef.componentInstance.title = "Close Order Confirmation";
        modalRef.componentInstance.message = "Are you sure you want to close the order "
            + orderToClose.name + " for the store " + orderToClose.customer.store.name + ' ?';
        modalRef.result.then(function (response) {
            if (response) {
                _this.orderService.closeOrder(orderToClose.id).subscribe(function (data) {
                    orderToClose.closeDatetime = data.closeDateTime;
                    orderToClose.status = data.status;
                });
            }
        });
    };
    ListOrdersComponent.prototype.onClickNotify = function (order) {
        var _this = this;
        var modalRef = this.modalBuilder.open(src_app_modal_confirm_modal_confirm_modal_component__WEBPACK_IMPORTED_MODULE_5__["ConfirmModalComponent"]);
        modalRef.componentInstance.title = "Notification Confirmation";
        modalRef.componentInstance.message = "Are you sure you want to get notification about the order " + order.name + " ?";
        modalRef.result.then(function (response) {
            if (response) {
                _this.notificationService.notifyOrder(order.id).subscribe(function (data) { return console.log("Notify done : " + data); });
            }
        });
    };
    Object.defineProperty(ListOrdersComponent.prototype, "ordersArray", {
        get: function () {
            return this.orders
                .slice((this.page - 1) * this.pageSize, (this.page - 1) * this.pageSize + this.pageSize);
        },
        enumerable: true,
        configurable: true
    });
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", Array)
    ], ListOrdersComponent.prototype, "orders", void 0);
    ListOrdersComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'list-orders',
            template: __webpack_require__(/*! ./list-orders.component.html */ "./src/app/orders-manager-panel/list-orders/list-orders.component.html"),
            styles: [__webpack_require__(/*! ./list-orders.component.css */ "./src/app/orders-manager-panel/list-orders/list-orders.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [src_app_service_order_service__WEBPACK_IMPORTED_MODULE_2__["OrderService"],
            src_app_service_notification_service__WEBPACK_IMPORTED_MODULE_3__["NotificationService"],
            src_app_common_components_modal_builder__WEBPACK_IMPORTED_MODULE_4__["ModalBuilder"]])
    ], ListOrdersComponent);
    return ListOrdersComponent;
}());



/***/ }),

/***/ "./src/app/orders-manager-panel/orders-manager/orders-manager.component.css":
/*!**********************************************************************************!*\
  !*** ./src/app/orders-manager-panel/orders-manager/orders-manager.component.css ***!
  \**********************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL29yZGVycy1tYW5hZ2VyLXBhbmVsL29yZGVycy1tYW5hZ2VyL29yZGVycy1tYW5hZ2VyLmNvbXBvbmVudC5jc3MifQ== */"

/***/ }),

/***/ "./src/app/orders-manager-panel/orders-manager/orders-manager.component.html":
/*!***********************************************************************************!*\
  !*** ./src/app/orders-manager-panel/orders-manager/orders-manager.component.html ***!
  \***********************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container-fluid\">\n    <div class=\"row justify-content-between\">\n        <div class=\"col-4\">\n            <button class=\"btn btn-primary\"\n                (click)=\"openCreateReportModal()\"\n            >New Order</button>\n        </div>\n        <div class=\"col-6\">\n            <div class=\"row justify-content-end\">\n                <div class=\"col-6\">\n                    <input #searchString type=\"text\"\n                        class=\"form-control\"\n                        (keyup.enter)=\"onClickSearch(searchString.value)\"\n                        placeholder=\"Type to search order...\">\n                </div>\n                <div class=\"col-4\">\n                    <button\n                        [disabled]=\"searchButtonDisabled\"\n                        class=\"btn btn-info search_button\"\n                        (click)=\"onClickSearch(searchString.value)\"\n                    >Search</button>\n                </div>\n            </div>\n        </div>\n    </div>\n    <br>\n    <h3 style=\"color: dimgray\" *ngIf=\"orders.length == 0\">{{ noOrdersFoundMessage }}</h3>\n    <div *ngIf=\"orders.length > 0\">\n        <list-orders\n            [orders]=\"orders\"\n        ></list-orders>\n    </div>\n</div>"

/***/ }),

/***/ "./src/app/orders-manager-panel/orders-manager/orders-manager.component.ts":
/*!*********************************************************************************!*\
  !*** ./src/app/orders-manager-panel/orders-manager/orders-manager.component.ts ***!
  \*********************************************************************************/
/*! exports provided: OrdersManagerComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "OrdersManagerComponent", function() { return OrdersManagerComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var src_app_service_order_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! src/app/service/order-service */ "./src/app/service/order-service.ts");
/* harmony import */ var src_app_common_components_modal_builder__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! src/app/common-components/modal-builder */ "./src/app/common-components/modal-builder.ts");
/* harmony import */ var src_app_modal_create_order_modal_create_order_modal_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! src/app/modal/create-order-modal/create-order-modal.component */ "./src/app/modal/create-order-modal/create-order-modal.component.ts");
/* harmony import */ var src_app_model_AggregatedOrder__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! src/app/model/AggregatedOrder */ "./src/app/model/AggregatedOrder.ts");






var OrdersManagerComponent = /** @class */ (function () {
    function OrdersManagerComponent(orderService, modalBuilder) {
        this.orderService = orderService;
        this.modalBuilder = modalBuilder;
        this.orders = [];
        this.searchButtonDisabled = false;
        this.isOrderListFiltered = false;
    }
    OrdersManagerComponent.prototype.ngOnInit = function () {
        this.getAllOrders();
    };
    OrdersManagerComponent.prototype.onClickSearch = function (value) {
        if (value.length > 0) {
            this.searchButtonDisabled = true;
            this.isOrderListFiltered = true;
            this.getOrderByName(value);
        }
        else if (value.length == 0 && this.isOrderListFiltered) {
            this.searchButtonDisabled = true;
            this.getAllOrders();
            this.isOrderListFiltered = false;
        }
    };
    OrdersManagerComponent.prototype.getOrderByName = function (name) {
        var _this = this;
        this.orderService.getOrderByName(name).subscribe(function (data) {
            _this.orders = _this.parseOrderIntoArray(data);
            _this.searchButtonDisabled = false;
        }, function (error) {
            console.log("error in search : " + error);
        });
    };
    OrdersManagerComponent.prototype.getAllOrders = function () {
        var _this = this;
        this.orderService.getAllOrders().subscribe(function (data) {
            _this.orders = _this.parseOrderIntoArray(data);
            if (_this.orders.length == 0) {
                _this.noOrdersFoundMessage = "No order found";
            }
        });
    };
    OrdersManagerComponent.prototype.parseOrderIntoArray = function (data) {
        var orders = [];
        for (var i = 0; i < data.length; i++) {
            var item = src_app_model_AggregatedOrder__WEBPACK_IMPORTED_MODULE_5__["AggregatedOrder"].fromJson(data[i]);
            orders.push(item);
        }
        return orders;
    };
    OrdersManagerComponent.prototype.openCreateReportModal = function () {
        var modalRef = this.modalBuilder.open(src_app_modal_create_order_modal_create_order_modal_component__WEBPACK_IMPORTED_MODULE_4__["CreateOrderModalComponent"]);
    };
    OrdersManagerComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'orders-manager',
            template: __webpack_require__(/*! ./orders-manager.component.html */ "./src/app/orders-manager-panel/orders-manager/orders-manager.component.html"),
            styles: [__webpack_require__(/*! ./orders-manager.component.css */ "./src/app/orders-manager-panel/orders-manager/orders-manager.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [src_app_service_order_service__WEBPACK_IMPORTED_MODULE_2__["OrderService"],
            src_app_common_components_modal_builder__WEBPACK_IMPORTED_MODULE_3__["ModalBuilder"]])
    ], OrdersManagerComponent);
    return OrdersManagerComponent;
}());



/***/ }),

/***/ "./src/app/service/admin-setting-service.ts":
/*!**************************************************!*\
  !*** ./src/app/service/admin-setting-service.ts ***!
  \**************************************************/
/*! exports provided: AdminSettingService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AdminSettingService", function() { return AdminSettingService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _http_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./http-service */ "./src/app/service/http-service.ts");



var AdminSettingService = /** @class */ (function () {
    function AdminSettingService(httpApi) {
        this.httpApi = httpApi;
    }
    AdminSettingService.prototype.getAdminSetting = function (adminSetting) {
        console.log("Get admin setting.");
        return this.httpApi.get("/v1/admin/setting/get");
    };
    AdminSettingService.prototype.updateAdminSetting = function (adminSetting) {
        console.log("Update admin setting " + adminSetting);
        return this.httpApi.post("v1/admin/setting/update", adminSetting);
    };
    AdminSettingService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_http_service__WEBPACK_IMPORTED_MODULE_2__["HttpService"]])
    ], AdminSettingService);
    return AdminSettingService;
}());



/***/ }),

/***/ "./src/app/service/customer-service.ts":
/*!*********************************************!*\
  !*** ./src/app/service/customer-service.ts ***!
  \*********************************************/
/*! exports provided: CustomerService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "CustomerService", function() { return CustomerService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _http_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./http-service */ "./src/app/service/http-service.ts");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");



var CustomerService = /** @class */ (function () {
    function CustomerService(http) {
        this.http = http;
        this.url = "v1/customer";
    }
    CustomerService.prototype.addCustomer = function (req) {
        return this.http.post(this.url + "/add", req);
    };
    CustomerService.prototype.getStoresOfOwner = function (ownerId) {
        return this.http.get(this.url + "/storesOfOwner/" + ownerId);
    };
    CustomerService.prototype.getAllCustomers = function () {
        return this.http.get(this.url + "/all");
    };
    CustomerService.prototype.getAllOwnersIdsAndNames = function () {
        return this.http.get(this.url + "/allOwnerIdsAndNames");
    };
    CustomerService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_2__["Injectable"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_http_service__WEBPACK_IMPORTED_MODULE_1__["HttpService"]])
    ], CustomerService);
    return CustomerService;
}());



/***/ }),

/***/ "./src/app/service/http-service.ts":
/*!*****************************************!*\
  !*** ./src/app/service/http-service.ts ***!
  \*****************************************/
/*! exports provided: HttpService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "HttpService", function() { return HttpService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");



var HttpService = /** @class */ (function () {
    function HttpService(http) {
        this.http = http;
    }
    HttpService.prototype.get = function (url) {
        return this.http.get(url);
    };
    HttpService.prototype.post = function (url, body) {
        return this.http.post(url, body, this.getHeaders());
    };
    HttpService.prototype.delete = function (url) {
        return this.http.delete(url, this.getHeaders());
    };
    HttpService.prototype.getHeaders = function () {
        var httpHeaders = new _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpHeaders"]()
            .set('Content-Type', 'application/json');
        var options = {
            headers: httpHeaders
        };
        return options;
    };
    HttpService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_2__["Injectable"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"]])
    ], HttpService);
    return HttpService;
}());



/***/ }),

/***/ "./src/app/service/notification-service.ts":
/*!*************************************************!*\
  !*** ./src/app/service/notification-service.ts ***!
  \*************************************************/
/*! exports provided: NotificationService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "NotificationService", function() { return NotificationService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _http_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./http-service */ "./src/app/service/http-service.ts");



var NotificationService = /** @class */ (function () {
    function NotificationService(httpApi) {
        this.httpApi = httpApi;
    }
    NotificationService.prototype.notifyOrder = function (id) {
        var request = { "id": id };
        return this.httpApi.post("v1/notification/report", request);
    };
    NotificationService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_http_service__WEBPACK_IMPORTED_MODULE_2__["HttpService"]])
    ], NotificationService);
    return NotificationService;
}());



/***/ }),

/***/ "./src/app/service/order-service.ts":
/*!******************************************!*\
  !*** ./src/app/service/order-service.ts ***!
  \******************************************/
/*! exports provided: OrderService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "OrderService", function() { return OrderService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _http_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./http-service */ "./src/app/service/http-service.ts");



var OrderService = /** @class */ (function () {
    function OrderService(httpApi) {
        this.httpApi = httpApi;
    }
    OrderService.prototype.addOrder = function (order) {
        var request = {
            "name": order.name,
            "customerId": order.customer.id,
            "comment": order.comment
        };
        return this.httpApi.post("/v1/order/add", request);
    };
    OrderService.prototype.getOrder = function (id) {
        console.log("Get order by id " + id);
        return this.httpApi.get("/v1/order/get/" + id);
    };
    OrderService.prototype.getOrderByName = function (name) {
        console.log("Get order by name : " + name);
        return this.httpApi.get("/v1/order/searchByName/" + name);
    };
    OrderService.prototype.getOrdersOfCustomer = function (id) {
        console.log("Get orders of customer " + id);
        return this.httpApi.get("/v1/order/ordersOfCustomer/" + id);
    };
    OrderService.prototype.addOrderItem = function (req) {
        console.log("Add order item[ " + ", " + req.requestedQty + " to order " + req.orderId);
        return this.httpApi.post("/v1/order/addOrderItemByInfo", req);
    };
    OrderService.prototype.addOrderItemByBarCode = function (req) {
        console.log("Add order item by barCode to order " + req.orderId + " : " + req.barCode);
        return this.httpApi.post("/v1/order/addSingleOrderItemsByBarCode", req);
    };
    OrderService.prototype.updateStockItem = function (order, itemToUpdate) {
        console.log("updateProductItem order " + order.id + " | " + itemToUpdate);
        //return this.httpApi.post("/v1/order/updateProductItem", this.toUpdateRequest(order, itemToUpdate))
        return null;
    };
    OrderService.prototype.deleteOrderItems = function (req) {
        console.log("Delete OrderItems from order : " + req.orderId + " : " + req.orderItemsId);
        return this.httpApi.post("/v1/order/deleteOrderItems", req);
    };
    OrderService.prototype.closeOrder = function (orderId) {
        console.log("Close order : " + orderId);
        var request = { "id": orderId };
        return this.httpApi.post("/v1/order/close", request);
    };
    OrderService.prototype.getAllOrders = function () {
        console.log("Get all reports");
        return this.httpApi.get("/v1/order/all");
    };
    OrderService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_http_service__WEBPACK_IMPORTED_MODULE_2__["HttpService"]])
    ], OrderService);
    return OrderService;
}());



/***/ }),

/***/ "./src/app/service/product-service.ts":
/*!********************************************!*\
  !*** ./src/app/service/product-service.ts ***!
  \********************************************/
/*! exports provided: ProductService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ProductService", function() { return ProductService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _http_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./http-service */ "./src/app/service/http-service.ts");



var ProductService = /** @class */ (function () {
    function ProductService(http) {
        this.http = http;
    }
    ProductService.prototype.get = function (id) {
        return this.http.get("/v1/productItem/get/" + id);
    };
    ProductService.prototype.getAllProductNames = function () {
        return this.http.get("/v1/stock/getAllExistingProductNames");
    };
    ProductService.prototype.getProductStockInfo = function (productId) {
        return this.http.get("/v1/stock/productStockInfo/" + productId);
    };
    ProductService.prototype.getProductItemByBarCode = function (barCode) {
        return this.http.get("/v1/stock/productItemByBarCode/" + barCode);
    };
    ProductService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_http_service__WEBPACK_IMPORTED_MODULE_2__["HttpService"]])
    ], ProductService);
    return ProductService;
}());



/***/ }),

/***/ "./src/app/shared.module.ts":
/*!**********************************!*\
  !*** ./src/app/shared.module.ts ***!
  \**********************************/
/*! exports provided: SharedModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "SharedModule", function() { return SharedModule; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_platform_browser__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/platform-browser */ "./node_modules/@angular/platform-browser/fesm5/platform-browser.js");
/* harmony import */ var _common_components_pipe_FilterPipe__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./common-components/pipe/FilterPipe */ "./src/app/common-components/pipe/FilterPipe.ts");




var SharedModule = /** @class */ (function () {
    function SharedModule() {
    }
    SharedModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"])({
            imports: [
                _angular_platform_browser__WEBPACK_IMPORTED_MODULE_2__["BrowserModule"]
            ],
            declarations: [
                _common_components_pipe_FilterPipe__WEBPACK_IMPORTED_MODULE_3__["FilterPipe"]
            ],
            providers: [
            // service
            ],
            exports: [
                _common_components_pipe_FilterPipe__WEBPACK_IMPORTED_MODULE_3__["FilterPipe"]
            ],
        })
    ], SharedModule);
    return SharedModule;
}());



/***/ }),

/***/ "./src/app/util/StringUtil.ts":
/*!************************************!*\
  !*** ./src/app/util/StringUtil.ts ***!
  \************************************/
/*! exports provided: StringUtil */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "StringUtil", function() { return StringUtil; });
var StringUtil = /** @class */ (function () {
    function StringUtil() {
    }
    StringUtil.capitalFirstLetter = function (word) {
        return word.charAt(0).toUpperCase() + word.slice(1);
    };
    return StringUtil;
}());



/***/ }),

/***/ "./src/app/util/TypeUtil.ts":
/*!**********************************!*\
  !*** ./src/app/util/TypeUtil.ts ***!
  \**********************************/
/*! exports provided: TypeUtil */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "TypeUtil", function() { return TypeUtil; });
var TypeUtil = /** @class */ (function () {
    function TypeUtil() {
    }
    TypeUtil.toBoolean = function (str) {
        return str.toLowerCase() == 'true';
    };
    return TypeUtil;
}());



/***/ }),

/***/ "./src/environments/environment.ts":
/*!*****************************************!*\
  !*** ./src/environments/environment.ts ***!
  \*****************************************/
/*! exports provided: environment */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "environment", function() { return environment; });
// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.
var environment = {
    production: false
};
/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.


/***/ }),

/***/ "./src/main.ts":
/*!*********************!*\
  !*** ./src/main.ts ***!
  \*********************/
/*! no exports provided */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/platform-browser-dynamic */ "./node_modules/@angular/platform-browser-dynamic/fesm5/platform-browser-dynamic.js");
/* harmony import */ var _app_app_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./app/app.module */ "./src/app/app.module.ts");
/* harmony import */ var _environments_environment__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./environments/environment */ "./src/environments/environment.ts");




if (_environments_environment__WEBPACK_IMPORTED_MODULE_3__["environment"].production) {
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["enableProdMode"])();
}
Object(_angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_1__["platformBrowserDynamic"])().bootstrapModule(_app_app_module__WEBPACK_IMPORTED_MODULE_2__["AppModule"])
    .catch(function (err) { return console.error(err); });


/***/ }),

/***/ 0:
/*!***************************!*\
  !*** multi ./src/main.ts ***!
  \***************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__(/*! /home/yoni/Documents/projects/andybrook/andybrook-ui/src/main.ts */"./src/main.ts");


/***/ })

},[[0,"runtime","vendor"]]]);
//# sourceMappingURL=main.js.map