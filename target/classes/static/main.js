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

module.exports = "<nav class=\"navbar navbar-expand-md navbar-dark bg-primary fixed-top\">\n    <a class=\"navbar-brand\" href=\"#\">Andybrook</a>\n    <button class=\"navbar-toggler hidden-sm-up\" type=\"button\" (click)=\"isNavbarCollapsed = !isNavbarCollapsed\" data-target=\"#navbarsDefault\" aria-controls=\"navbarsDefault\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n      <span class=\"navbar-toggler-icon\"></span>\n    </button>\n    <div [ngbCollapse]=\"isNavbarCollapsed\" class=\"collapse navbar-collapse\" id=\"navbarsDefault\">\n      <ul class=\"navbar-nav mr-auto\">\n        <li class=\"nav-item\">\n          <a class=\"nav-link\"\n             routerLinkActive=\"active\"\n             [routerLinkActiveOptions]=\"{exact: true}\"\n             routerLink=\"/\"\n          >Home</a>\n        </li>\n        <li class=\"nav-item\">\n            <a class=\"nav-link\"\n               routerLink=\"/customer\"\n            >Customer</a>\n          </li>\n        <li class=\"nav-item\">\n          <a class=\"nav-link\"\n             routerLink=\"/admin\"\n          >Admin</a>\n        </li>\n        <li class=\"nav-item dropdown\" ngbDropdown>\n          <a class=\"nav-link dropdown-toggle\" id=\"id01\" href=\"#\" ngbDropdownToggle>Files</a>\n          <div class=\"dropdown-menu\" aria-labelledby=\"id01\" ngbDropdownMenu>\n            <a class=\"dropdown-item\" href=\"#\">HTML</a>\n            <a class=\"dropdown-item\" href=\"#\">TS</a>\n            <a class=\"dropdown-item\" href=\"#\">JS</a>\n          </div>\n        </li>\n      </ul>\n    </div>\n  </nav>"

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
/* harmony import */ var _stock_report_panel_list_stock_item_list_stock_item_component__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ./stock-report-panel/list-stock-item/list-stock-item.component */ "./src/app/stock-report-panel/list-stock-item/list-stock-item.component.ts");
/* harmony import */ var _orders_manager_panel_orders_manager_orders_manager_component__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ./orders-manager-panel/orders-manager/orders-manager.component */ "./src/app/orders-manager-panel/orders-manager/orders-manager.component.ts");
/* harmony import */ var _stock_report_panel_stock_report_stock_report_component__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! ./stock-report-panel/stock-report/stock-report.component */ "./src/app/stock-report-panel/stock-report/stock-report.component.ts");
/* harmony import */ var _service_order_service__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! ./service/order-service */ "./src/app/service/order-service.ts");
/* harmony import */ var _service_http_service__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! ./service/http-service */ "./src/app/service/http-service.ts");
/* harmony import */ var _service_admin_setting_service__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! ./service/admin-setting-service */ "./src/app/service/admin-setting-service.ts");
/* harmony import */ var _header_menu_header_menu_component__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__(/*! ./header-menu/header-menu.component */ "./src/app/header-menu/header-menu.component.ts");
/* harmony import */ var _stock_report_panel_stock_report_header_stock_report_header_component__WEBPACK_IMPORTED_MODULE_17__ = __webpack_require__(/*! ./stock-report-panel/stock-report-header/stock-report-header.component */ "./src/app/stock-report-panel/stock-report-header/stock-report-header.component.ts");
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































var appRoutes = [
    { path: '', component: _orders_manager_panel_orders_manager_orders_manager_component__WEBPACK_IMPORTED_MODULE_11__["OrdersManagerComponent"] },
    { path: 'stockreport/:id', component: _stock_report_panel_stock_report_stock_report_component__WEBPACK_IMPORTED_MODULE_12__["StockReportComponent"] },
    { path: 'admin', component: _admin_admin_panel_admin_panel_component__WEBPACK_IMPORTED_MODULE_20__["AdminPanelComponent"] },
    { path: 'customers', component: _customer_customer_panel_customer_panel_component__WEBPACK_IMPORTED_MODULE_22__["CustomerPanelComponent"] }
];
var AppModule = /** @class */ (function () {
    function AppModule() {
    }
    AppModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_2__["NgModule"])({
            declarations: [
                _app_component__WEBPACK_IMPORTED_MODULE_9__["AppComponent"],
                _stock_report_panel_list_stock_item_list_stock_item_component__WEBPACK_IMPORTED_MODULE_10__["ListStockItemComponent"],
                _orders_manager_panel_orders_manager_orders_manager_component__WEBPACK_IMPORTED_MODULE_11__["OrdersManagerComponent"],
                _stock_report_panel_stock_report_stock_report_component__WEBPACK_IMPORTED_MODULE_12__["StockReportComponent"],
                _header_menu_header_menu_component__WEBPACK_IMPORTED_MODULE_16__["HeaderMenuComponent"],
                _stock_report_panel_stock_report_header_stock_report_header_component__WEBPACK_IMPORTED_MODULE_17__["StockReportHeaderComponent"],
                _orders_manager_panel_list_orders_list_orders_component__WEBPACK_IMPORTED_MODULE_18__["ListOrdersComponent"],
                _admin_admin_panel_admin_panel_component__WEBPACK_IMPORTED_MODULE_20__["AdminPanelComponent"],
                _customer_customer_panel_customer_panel_component__WEBPACK_IMPORTED_MODULE_22__["CustomerPanelComponent"],
                _app_nav_bar_app_nav_bar_component__WEBPACK_IMPORTED_MODULE_24__["AppNavBarComponent"],
                _modal_confirm_modal_confirm_modal_component__WEBPACK_IMPORTED_MODULE_25__["ConfirmModalComponent"],
                _modal_create_order_modal_create_order_modal_component__WEBPACK_IMPORTED_MODULE_27__["CreateOrderModalComponent"],
                _modal_info_modal_info_modal_component__WEBPACK_IMPORTED_MODULE_29__["InfoModalComponent"],
            ],
            entryComponents: [_modal_create_order_modal_create_order_modal_component__WEBPACK_IMPORTED_MODULE_27__["CreateOrderModalComponent"], _modal_confirm_modal_confirm_modal_component__WEBPACK_IMPORTED_MODULE_25__["ConfirmModalComponent"], _modal_info_modal_info_modal_component__WEBPACK_IMPORTED_MODULE_29__["InfoModalComponent"]],
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
            providers: [_service_order_service__WEBPACK_IMPORTED_MODULE_13__["OrderService"], _service_http_service__WEBPACK_IMPORTED_MODULE_14__["HttpService"], _service_admin_setting_service__WEBPACK_IMPORTED_MODULE_15__["AdminSettingService"], _service_notification_service__WEBPACK_IMPORTED_MODULE_23__["NotificationService"], _common_components_modal_builder__WEBPACK_IMPORTED_MODULE_26__["ModalBuilder"], _service_customer_service__WEBPACK_IMPORTED_MODULE_28__["CustomerService"], _service_product_service__WEBPACK_IMPORTED_MODULE_30__["ProductService"]],
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

module.exports = "<p>\n  owner-panel works!\n</p>\n"

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


var CustomerPanelComponent = /** @class */ (function () {
    function CustomerPanelComponent() {
    }
    CustomerPanelComponent.prototype.ngOnInit = function () {
    };
    CustomerPanelComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'customer-panel',
            template: __webpack_require__(/*! ./customer-panel.component.html */ "./src/app/customer/customer-panel/customer-panel.component.html"),
            styles: [__webpack_require__(/*! ./customer-panel.component.css */ "./src/app/customer/customer-panel/customer-panel.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [])
    ], CustomerPanelComponent);
    return CustomerPanelComponent;
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

module.exports = "<div class=\"modal-header\">\n  <h4 class=\"modal-title\" id=\"modal-basic-title\">New Order</h4>\n  <button type=\"button\" class=\"close\" aria-label=\"Close\" (click)=\"onClose()\">\n    <span aria-hidden=\"true\">&times;</span>\n  </button>\n</div>\n<form [formGroup]=\"createOrderForm\" (ngSubmit)=\"onSubmit()\">\n<div class=\"modal-body\">\n    <div class=\"form-group\">\n      <label for=\"Name\">Name</label>\n      <input type=\"text\" formControlName=\"name\"\n        (input)=\"settingChanged()\"\n        class=\"form-control\"/>\n        <label *ngIf=\"isFormSubmitted && createOrderForm.get('name').invalid\" class=\"text-danger\">A name is required.</label>\n    </div>\n    <div class=\"form-group\">\n      <label for=\"comment\">Comment/Description</label>\n      <input type=\"text\" formControlName=\"comment\"\n        (input)=\"settingChanged()\"\n        class=\"form-control\"/>\n    </div>\n    <div class=\"form-group\">\n      <label for=\"customer\">Customer</label>\n      <select type=\"text\" formControlName=\"customers\"\n        (input)=\"settingChanged()\"\n        class=\"form-control\">\n        <option *ngFor=\"let customer of customersArray\"\n        [ngValue]=\"customer\">{{customer.id}} | {{ customer.store.name }} | {{ customer.store.owner.firstName }} {{ customer.store.owner.lastName }}</option>\n      </select>\n      <label *ngIf=\"isFormSubmitted && createOrderForm.get('customers').invalid\" class=\"text-danger\">A customer is required.</label>\n    </div>\n</div>\n<div class=\"modal-footer\">\n  <button type=\"submit\" class=\"btn btn-outline-dark\" >Create</button>\n</div></form>"

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









var CreateOrderModalComponent = /** @class */ (function () {
    function CreateOrderModalComponent(modal, customerService, orderService, router, formBuilder) {
        this.modal = modal;
        this.customerService = customerService;
        this.orderService = orderService;
        this.router = router;
        this.formBuilder = formBuilder;
        this.customersArray = [];
        this.isFormSubmitted = false;
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
            _this.router.navigate(['/stockreport', data.id]);
        }, function (error) {
            console.log("ERROOoooooooooooooooooooR " + error);
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
            total += items[i].product.price * items[i].quantity;
        }
        return total;
    };
    return Order;
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
        this.firstName = '';
        this.lastName = '';
        this.email = '';
        this.address = '';
    }
    Owner.fromJson = function (data) {
        var owner = new Owner();
        owner.id = data.id;
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
    return Product;
}());



/***/ }),

/***/ "./src/app/model/StockItem.ts":
/*!************************************!*\
  !*** ./src/app/model/StockItem.ts ***!
  \************************************/
/*! exports provided: StockItem */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "StockItem", function() { return StockItem; });
var Type;
(function (Type) {
    Type["GLASSES"] = "GLASSES";
})(Type || (Type = {}));
var StockItem = /** @class */ (function () {
    function StockItem(id, barCode, quantity, product, creationDatetime, lastModifyDatetime) {
        this.type = Type.GLASSES;
        this.id = id;
        this.barCode = barCode;
        this.quantity = quantity;
        this.product = product;
        this.createdDatetime = creationDatetime;
        this.lastModifiedDatetime = lastModifyDatetime;
    }
    return StockItem;
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
        this.name = '';
        this.email = '';
        this.owner = new _Owner__WEBPACK_IMPORTED_MODULE_0__["Owner"]();
    }
    Store.fromJson = function (data) {
        var store = new Store();
        store.id = data.id;
        store.name = data.name;
        store.email = data.email;
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

module.exports = "<div class=\"col-md-20 user-container\">\n    <table class=\"table table-striped\">\n        <thead>\n            <tr>\n                <th>ID</th>\n                <th>Name</th>\n                <th>Store</th>\n                <th>Status</th>\n                <th>Total Product</th>\n                <th>Total Qty</th>\n                <th>Total Price</th>\n                <th>Creation Date</th>\n                <th>Close Date</th>\n                <th></th>\n                <th></th>\n            </tr>\n        </thead>\n        <tbody>\n            <tr *ngFor=\"let order of ordersArray\">\n                <td>{{ order.id }}</td>\n                <td>{{ order.name }}</td>\n                <td>{{ order.customer.store.name }}</td>\n                <td>{{ order.status }}</td>\n                <td>{{ order.nbProduct }}</td>\n                <td>{{ order.totalItemQty }}</td>\n                <td>{{ order.totalPrice }} €</td>\n                <td>{{ order.createDatetime  | date:'medium' }}</td>\n                <td>{{ order.closeDatetime  | date:'medium' }}</td>\n                <td><button\n                    class=\"btn btn-success\"\n                    [routerLink]=\"['/stockreport', order.id]\"\n                    >See</button>\n                </td>\n                <td><button\n                    *ngIf=\"order.status !== 'CLOSED'\"\n                    class=\"btn btn-info\"\n                    (click)=\"onClickCloseOrder(order)\"\n                    >Close Order</button>\n                    <button\n                        *ngIf=\"order.status === 'CLOSED'\"\n                        class=\"btn btn-primary\"\n                        (click)=\"onClickNotify(order)\"\n                    >Notify</button>\n                </td>\n            </tr>\n        </tbody>\n    </table>\n    <div class=\"row justify-content-between\">\n        <div class=\"col-4\">\n            <ngb-pagination [collectionSize]=\"collectionSize\" [(page)]=\"page\" [pageSize]=\"pageSize\"></ngb-pagination>\n        </div>\n        <div class=\"col-2\">\n            <select class=\"custom-select\" [(ngModel)]=\"pageSize\">\n                <option [ngValue]=\"5\">5 items per page</option>\n                <option [ngValue]=\"10\">10 items per page</option>\n                <option [ngValue]=\"20\">20 items per page</option>\n            </select>\n        </div>\n    </div>\n</div>"

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
        modalRef.componentInstance.title = "Close Report Confirmation";
        modalRef.componentInstance.message = "Are you sure you want to close the order "
            + orderToClose.name + " for the store " + orderToClose.customer.store.name;
        modalRef.result.then(function (response) {
            if (response) {
                _this.orderService.closeOrder(orderToClose);
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
/* harmony import */ var _model_Order__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../model/Order */ "./src/app/model/Order.ts");
/* harmony import */ var src_app_common_components_modal_builder__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! src/app/common-components/modal-builder */ "./src/app/common-components/modal-builder.ts");
/* harmony import */ var src_app_modal_create_order_modal_create_order_modal_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! src/app/modal/create-order-modal/create-order-modal.component */ "./src/app/modal/create-order-modal/create-order-modal.component.ts");






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
    OrdersManagerComponent.prototype.getOrderById = function (id) {
        var _this = this;
        this.orderService.getOrder(id).subscribe(function (data) {
            _this.orders = _this.parseOrderIntoArray(data);
            _this.searchButtonDisabled = false;
        });
    };
    OrdersManagerComponent.prototype.getOrderByName = function (name) {
        var _this = this;
        this.orderService.getOrderByName(name).subscribe(function (data) {
            _this.orders = _this.parseOrderIntoArray(data);
            _this.searchButtonDisabled = false;
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
            var item = _model_Order__WEBPACK_IMPORTED_MODULE_3__["Order"].fromJson(data[i]);
            orders.push(item);
        }
        return orders;
    };
    OrdersManagerComponent.prototype.openCreateReportModal = function () {
        var modalRef = this.modalBuilder.open(src_app_modal_create_order_modal_create_order_modal_component__WEBPACK_IMPORTED_MODULE_5__["CreateOrderModalComponent"]);
    };
    OrdersManagerComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'orders-manager',
            template: __webpack_require__(/*! ./orders-manager.component.html */ "./src/app/orders-manager-panel/orders-manager/orders-manager.component.html"),
            styles: [__webpack_require__(/*! ./orders-manager.component.css */ "./src/app/orders-manager-panel/orders-manager/orders-manager.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [src_app_service_order_service__WEBPACK_IMPORTED_MODULE_2__["OrderService"],
            src_app_common_components_modal_builder__WEBPACK_IMPORTED_MODULE_4__["ModalBuilder"]])
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
    }
    CustomerService.prototype.getAllCustomers = function () {
        return this.http.get("v1/customer/all");
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
        console.log("Get report " + id);
        return this.httpApi.get("/v1/order/get/" + id);
    };
    OrderService.prototype.getOrderByName = function (name) {
        console.log("Get report by name : " + name);
        return this.httpApi.get("/v1/order/getByName/" + name);
    };
    OrderService.prototype.addItem = function (order, item) {
        console.log("Add item[ " + ", " + item.quantity + " to order " + order.id);
        return this.httpApi.post("/v1/order/addOrderItem", this.toUpdateRequest(order, item));
    };
    OrderService.prototype.updateStockItem = function (order, itemToUpdate) {
        console.log("update order " + order.id + " | " + itemToUpdate);
        return this.httpApi.post("/v1/order/update", this.toUpdateRequest(order, itemToUpdate));
    };
    OrderService.prototype.deleteItem = function (order, stockItemIdToDelete) {
        console.log("Delete Item : " + stockItemIdToDelete);
        return this.httpApi.delete("/v1/order/deleteOrderItem/" + order.id + "/" + stockItemIdToDelete);
    };
    OrderService.prototype.closeOrder = function (order) {
        console.log("Close order : " + order.id);
        var request = { "id": order.id };
        this.httpApi.post("/v1/order/close", request).subscribe(function (data) {
            order.closeDatetime = data.closeDateTime;
            order.status = data.status;
        });
    };
    OrderService.prototype.getAllOrders = function () {
        console.log("Get all reports");
        return this.httpApi.get("/v1/order/all");
    };
    OrderService.prototype.toUpdateRequest = function (order, item) {
        return {
            "orderId": order.id,
            "orderItem": item,
            "type": item.type
        };
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
        return this.http.get("/v1/product/get/" + id);
    };
    ProductService.prototype.getAllProductNames = function () {
        return this.http.get("/v1/product/getAllExistingProductNames");
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

/***/ "./src/app/stock-report-panel/list-stock-item/list-stock-item.component.css":
/*!**********************************************************************************!*\
  !*** ./src/app/stock-report-panel/list-stock-item/list-stock-item.component.css ***!
  \**********************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".table tr.active td {\n    background-color:#275e94 !important;\n    color: white;\n    font-weight: bold;\n  }\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvc3RvY2stcmVwb3J0LXBhbmVsL2xpc3Qtc3RvY2staXRlbS9saXN0LXN0b2NrLWl0ZW0uY29tcG9uZW50LmNzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQTtJQUNJLG1DQUFtQztJQUNuQyxZQUFZO0lBQ1osaUJBQWlCO0VBQ25CIiwiZmlsZSI6InNyYy9hcHAvc3RvY2stcmVwb3J0LXBhbmVsL2xpc3Qtc3RvY2staXRlbS9saXN0LXN0b2NrLWl0ZW0uY29tcG9uZW50LmNzcyIsInNvdXJjZXNDb250ZW50IjpbIi50YWJsZSB0ci5hY3RpdmUgdGQge1xuICAgIGJhY2tncm91bmQtY29sb3I6IzI3NWU5NCAhaW1wb3J0YW50O1xuICAgIGNvbG9yOiB3aGl0ZTtcbiAgICBmb250LXdlaWdodDogYm9sZDtcbiAgfSJdfQ== */"

/***/ }),

/***/ "./src/app/stock-report-panel/list-stock-item/list-stock-item.component.html":
/*!***********************************************************************************!*\
  !*** ./src/app/stock-report-panel/list-stock-item/list-stock-item.component.html ***!
  \***********************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"user-container\">\n  <form>\n    <div class=\"form-group\">\n      <div class=\"input-group\">\n        <div class=\"input-group-addon\">\n          <i class=\"glyphicon glyphicon-search\"></i>\n        </div>\n        <input type=\"text\"\n          class=\"form-control\"\n          name=\"searchString\"\n          placeholder=\"Type to search...\"\n          [(ngModel)]=\"searchString\">\n      </div>\n    </div>\n  </form>\n  <table class=\"table table-striped\">\n    <thead>\n      <tr>\n        <th>ID</th>\n        <th>Name</th>\n        <th>Price</th>\n        <th>Quantity</th>\n        <th>Creation Date</th>\n        <th>Last Modify Date</th>\n        <th></th>\n      </tr>\n    </thead>\n    <tbody>\n      <tr *ngIf=\"order.status !== 'CLOSED'\">\n        <td></td>\n        <td>\n          <input class=\"form-control\" (blur)=\"onBlurInputName()\" [(ngModel)]=\"inputName\" [ngbTypeahead]=\"search\">\n        </td>\n        <td>\n          <input class=\"form-control\" (blur)=\"onBlurNewItemInput()\" [(ngModel)]=\"inputPrice\">\n        </td>\n        <td>\n          <input class=\"form-control\" (blur)=\"onBlurNewItemInput()\" [(ngModel)]=\"inputQuantity\">\n        </td>\n        <td></td>\n        <td></td>\n        <td>\n          <button class=\"btn btn-info\" [disabled]=\"! areNewStockItemFieldsSet\" (click)=\"createNewStockItem()\"> Add\n            Stock Item</button>\n        </td>\n      </tr>\n      <tr *ngFor=\"let item of stockItems | filter : 'name' : searchString; let i = index\" (click)=\"setSelectedRow(i)\"\n        [class.active]=\"i == selectedRow\">\n        <td>{{ item.product.id }}</td>\n        <td contenteditable=\"order.status !== 'CLOSED'\"\n          (blur)=\"onChangeStockItemName(item, $event)\">\n          {{ item.product.name }}\n        </td>\n        <td\n          contenteditable=\"order.status !== 'CLOSED'\"\n          (blur)=\"onChangeStockItemPrice(item, $event)\">\n          {{ item.product.price }} €\n        </td>\n        <td\n          contenteditable=\"order.status !== 'CLOSED'\"\n          (blur)=\"onChangeStockItemQuantity(item, $event)\">\n          {{ item.quantity }}\n        </td>\n        <td>{{ item.createdDatetime }}</td>\n        <td>{{ item.lastModifiedDatetime }}</td>\n        <td>\n          <button *ngIf=\"order.status !== 'CLOSED'\" (click)=\"deleteStockItem(item.id)\" class=\"btn btn-danger\">\n            Delete</button>\n        </td>\n      </tr>\n    </tbody>\n  </table>\n</div>"

/***/ }),

/***/ "./src/app/stock-report-panel/list-stock-item/list-stock-item.component.ts":
/*!*********************************************************************************!*\
  !*** ./src/app/stock-report-panel/list-stock-item/list-stock-item.component.ts ***!
  \*********************************************************************************/
/*! exports provided: ListStockItemComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ListStockItemComponent", function() { return ListStockItemComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _model_StockItem__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../model/StockItem */ "./src/app/model/StockItem.ts");
/* harmony import */ var _model_Product__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../model/Product */ "./src/app/model/Product.ts");
/* harmony import */ var src_app_service_order_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! src/app/service/order-service */ "./src/app/service/order-service.ts");
/* harmony import */ var src_app_model_Order__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! src/app/model/Order */ "./src/app/model/Order.ts");
/* harmony import */ var src_app_common_components_modal_builder__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! src/app/common-components/modal-builder */ "./src/app/common-components/modal-builder.ts");
/* harmony import */ var src_app_modal_info_modal_info_modal_component__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! src/app/modal/info-modal/info-modal.component */ "./src/app/modal/info-modal/info-modal.component.ts");
/* harmony import */ var src_app_service_product_service__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! src/app/service/product-service */ "./src/app/service/product-service.ts");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");










var ListStockItemComponent = /** @class */ (function () {
    function ListStockItemComponent(orderService, productService, modalBuilder) {
        var _this = this;
        this.orderService = orderService;
        this.productService = productService;
        this.modalBuilder = modalBuilder;
        this.areNewStockItemFieldsSet = false;
        this.productNames = [];
        this.productIdMapByName = new Map();
        this.search = function (text$) {
            return text$.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_9__["debounceTime"])(200), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_9__["distinctUntilChanged"])(), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_9__["map"])(function (term) { return term.length < 1 ? []
                : _this.productNames.filter(function (v) { return v.toLowerCase().indexOf(term.toLowerCase()) > -1; }).slice(0, 10); }));
        };
        this.onCreateStockItemEvent = new _angular_core__WEBPACK_IMPORTED_MODULE_1__["EventEmitter"]();
        this.onChangeStockItemEvent = new _angular_core__WEBPACK_IMPORTED_MODULE_1__["EventEmitter"]();
        this.onDeleteStockItemEvent = new _angular_core__WEBPACK_IMPORTED_MODULE_1__["EventEmitter"]();
    }
    ListStockItemComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.productService.getAllProductNames().subscribe(function (data) {
            for (var _i = 0, data_1 = data; _i < data_1.length; _i++) {
                var idAndNameProduct = data_1[_i];
                _this.productIdMapByName.set(idAndNameProduct.second, idAndNameProduct.first);
                _this.productNames.push(idAndNameProduct.second);
            }
        });
    };
    ListStockItemComponent.prototype.onBlurNewItemInput = function () {
        this.checkInputFieldSet();
    };
    ListStockItemComponent.prototype.onBlurInputName = function () {
        var _this = this;
        var id = this.productIdMapByName.get(this.inputName.trim());
        if (id != null) {
            this.productService.get(id).subscribe(function (data) {
                _this.inputId = data.id;
                _this.inputPrice = data.price;
                _this.inputQuantity = 1;
            });
        }
        this.checkInputFieldSet();
    };
    ListStockItemComponent.prototype.checkInputFieldSet = function () {
        this.areNewStockItemFieldsSet = this.inputName.trim().length > 0
            && this.inputQuantity >= 0
            && this.inputPrice >= 0;
    };
    ListStockItemComponent.prototype.createNewStockItem = function () {
        var _this = this;
        var stockItem = new _model_StockItem__WEBPACK_IMPORTED_MODULE_2__["StockItem"](undefined, null, this.inputQuantity, new _model_Product__WEBPACK_IMPORTED_MODULE_3__["Product"](this.inputId, this.inputName, this.inputPrice), null, null);
        this.orderService.addItem(this.order, stockItem).subscribe(function (data) {
            var barCodeId;
            if (data.barCode != null) {
                barCodeId = data.item.barCode.id;
            }
            var product = new _model_Product__WEBPACK_IMPORTED_MODULE_3__["Product"](data.product.id, data.product.name, data.product.price);
            stockItem = new _model_StockItem__WEBPACK_IMPORTED_MODULE_2__["StockItem"](data.id, barCodeId, data.quantity, product, data.createdDatetime, data.lastModifiedDatetime);
            _this.onCreateStockItemEvent.emit(stockItem);
            _this.resetNewStockitemFields();
        }, function (error) {
            var modalRef = _this.modalBuilder.open(src_app_modal_info_modal_info_modal_component__WEBPACK_IMPORTED_MODULE_7__["InfoModalComponent"]);
            modalRef.componentInstance.title = "Error : Product item " + stockItem.product.name + " not added to order " + _this.order.name;
            modalRef.componentInstance.message = error.error.message;
        });
    };
    ListStockItemComponent.prototype.deleteStockItem = function (id) {
        var _this = this;
        this.orderService.deleteItem(this.order, id).subscribe(function (data) {
            console.log(data);
            _this.onDeleteStockItemEvent.emit(id);
        }, function (error) {
        });
    };
    ListStockItemComponent.prototype.onChangeStockItemName = function (stockItem, event) {
        var _this = this;
        var product = stockItem.product;
        var newName = event.target.textContent;
        if (product.name !== newName) {
            var p = new _model_Product__WEBPACK_IMPORTED_MODULE_3__["Product"](product.id, newName, product.price);
            var item = new _model_StockItem__WEBPACK_IMPORTED_MODULE_2__["StockItem"](stockItem.id, stockItem.barCode, stockItem.quantity, p, stockItem.createdDatetime, stockItem.lastModifiedDatetime);
            this.orderService.updateStockItem(this.order, item).subscribe(function (data) {
                _this.order.id = data.id;
                _this.order.name = data.name;
                _this.order.comment = data.comment;
                _this.order.status = data.status;
                var product = new _model_Product__WEBPACK_IMPORTED_MODULE_3__["Product"](data.item.product.id, data.item.product.name, data.item.product.price);
                var stockItem = new _model_StockItem__WEBPACK_IMPORTED_MODULE_2__["StockItem"](data.item.id, data.item.barCode.id, data.item.quantity, product, data.item.createdDatetime, data.item.lastModifiedDatetime);
                _this.order.items.set(stockItem.id, stockItem);
                _this.onChangeStockItemEvent.emit(stockItem);
            }, function (error) {
                debugger;
                console.log(error);
            });
        }
    };
    ListStockItemComponent.prototype.onChangeStockItemQuantity = function (stockItem, event) {
        var newQuantity = event.target.textContent;
        if (stockItem.quantity != newQuantity) {
            var item = new _model_StockItem__WEBPACK_IMPORTED_MODULE_2__["StockItem"](stockItem.id, stockItem.barCode, newQuantity, stockItem.product, stockItem.createdDatetime, stockItem.lastModifiedDatetime);
            this.onChangeStockItemEvent.emit(item);
        }
    };
    ListStockItemComponent.prototype.onChangeStockItemPrice = function (stockItem, event) {
        var product = stockItem.product;
        var newPrice = event.target.textContent;
        if (product.price != newPrice) {
            var p = new _model_Product__WEBPACK_IMPORTED_MODULE_3__["Product"](product.id, product.name, newPrice);
            var item = new _model_StockItem__WEBPACK_IMPORTED_MODULE_2__["StockItem"](stockItem.id, stockItem.barCode, stockItem.quantity, p, stockItem.createdDatetime, stockItem.lastModifiedDatetime);
            this.onChangeStockItemEvent.emit(item);
        }
    };
    ListStockItemComponent.prototype.setSelectedRow = function (index) {
        this.selectedRow = index;
    };
    ListStockItemComponent.prototype.resetNewStockitemFields = function () {
        this.inputName = "";
        this.inputQuantity = undefined;
        this.inputPrice = undefined;
        this.areNewStockItemFieldsSet = false;
    };
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", Object)
    ], ListStockItemComponent.prototype, "stockItems", void 0);
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", src_app_model_Order__WEBPACK_IMPORTED_MODULE_5__["Order"])
    ], ListStockItemComponent.prototype, "order", void 0);
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Output"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", Object)
    ], ListStockItemComponent.prototype, "onCreateStockItemEvent", void 0);
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Output"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", Object)
    ], ListStockItemComponent.prototype, "onChangeStockItemEvent", void 0);
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Output"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", Object)
    ], ListStockItemComponent.prototype, "onDeleteStockItemEvent", void 0);
    ListStockItemComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'list-stock-item',
            template: __webpack_require__(/*! ./list-stock-item.component.html */ "./src/app/stock-report-panel/list-stock-item/list-stock-item.component.html"),
            styles: [__webpack_require__(/*! ./list-stock-item.component.css */ "./src/app/stock-report-panel/list-stock-item/list-stock-item.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [src_app_service_order_service__WEBPACK_IMPORTED_MODULE_4__["OrderService"],
            src_app_service_product_service__WEBPACK_IMPORTED_MODULE_8__["ProductService"],
            src_app_common_components_modal_builder__WEBPACK_IMPORTED_MODULE_6__["ModalBuilder"]])
    ], ListStockItemComponent);
    return ListStockItemComponent;
}());



/***/ }),

/***/ "./src/app/stock-report-panel/stock-report-header/stock-report-header.component.css":
/*!******************************************************************************************!*\
  !*** ./src/app/stock-report-panel/stock-report-header/stock-report-header.component.css ***!
  \******************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL3N0b2NrLXJlcG9ydC1wYW5lbC9zdG9jay1yZXBvcnQtaGVhZGVyL3N0b2NrLXJlcG9ydC1oZWFkZXIuY29tcG9uZW50LmNzcyJ9 */"

/***/ }),

/***/ "./src/app/stock-report-panel/stock-report-header/stock-report-header.component.html":
/*!*******************************************************************************************!*\
  !*** ./src/app/stock-report-panel/stock-report-header/stock-report-header.component.html ***!
  \*******************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container-fluid\" style=\"border-bottom: 3px solid red\">\n  <div class=\"row justify-content-between\">\n    <div class=\"col-md-4\">\n      <h5>{{ order.name }}</h5>\n      <p>Description/Comment : {{ order.comment }}</p>\n      <div style=\"overflow: hidden;\">\n        <p style=\"float: left\">Customer : &nbsp;</p>\n        <p style=\"float: left; font-weight: bold\"> {{ order.customer.store.name }}</p>\n      </div>\n      <div style=\"overflow: hidden;\">\n        <p style=\"float: left;\">Status :&nbsp;</p>\n        <p style=\"float: left; font-weight: bold\"> {{ order.status }}</p>\n      </div>\n    </div>\n    <div class=\"col-md-6\">\n        <button\n          style=\"float: right\"\n          class=\"btn btn-outline-info\"\n          (click)=\"onClickCloseOrder()\"\n          [disabled]=\"order.status === 'CLOSED'\"\n        >Close the order</button>\n    </div>\n  </div>\n</div>"

/***/ }),

/***/ "./src/app/stock-report-panel/stock-report-header/stock-report-header.component.ts":
/*!*****************************************************************************************!*\
  !*** ./src/app/stock-report-panel/stock-report-header/stock-report-header.component.ts ***!
  \*****************************************************************************************/
/*! exports provided: StockReportHeaderComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "StockReportHeaderComponent", function() { return StockReportHeaderComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _model_Order__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../model/Order */ "./src/app/model/Order.ts");
/* harmony import */ var src_app_common_components_modal_builder__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! src/app/common-components/modal-builder */ "./src/app/common-components/modal-builder.ts");
/* harmony import */ var src_app_modal_confirm_modal_confirm_modal_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! src/app/modal/confirm-modal/confirm-modal-component */ "./src/app/modal/confirm-modal/confirm-modal-component.ts");
/* harmony import */ var src_app_service_order_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! src/app/service/order-service */ "./src/app/service/order-service.ts");






var StockReportHeaderComponent = /** @class */ (function () {
    function StockReportHeaderComponent(modalBuilder, orderService) {
        this.modalBuilder = modalBuilder;
        this.orderService = orderService;
        this.onCloseOrderEvent = new _angular_core__WEBPACK_IMPORTED_MODULE_1__["EventEmitter"]();
    }
    StockReportHeaderComponent.prototype.ngOnInit = function () {
    };
    StockReportHeaderComponent.prototype.onClickCloseOrder = function () {
        var _this = this;
        var modalRef = this.modalBuilder.open(src_app_modal_confirm_modal_confirm_modal_component__WEBPACK_IMPORTED_MODULE_4__["ConfirmModalComponent"]);
        modalRef.componentInstance.title = "Close Report Confirmation";
        modalRef.componentInstance.message = "Are you sure you want to close the order "
            + this.order.name + " for the store " + this.order.customer.store.name;
        modalRef.result.then(function (response) {
            if (response) {
                _this.orderService.closeOrder(_this.order);
            }
        });
    };
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", _model_Order__WEBPACK_IMPORTED_MODULE_2__["Order"])
    ], StockReportHeaderComponent.prototype, "order", void 0);
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Output"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", Object)
    ], StockReportHeaderComponent.prototype, "onCloseOrderEvent", void 0);
    StockReportHeaderComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'stock-report-header',
            template: __webpack_require__(/*! ./stock-report-header.component.html */ "./src/app/stock-report-panel/stock-report-header/stock-report-header.component.html"),
            styles: [__webpack_require__(/*! ./stock-report-header.component.css */ "./src/app/stock-report-panel/stock-report-header/stock-report-header.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [src_app_common_components_modal_builder__WEBPACK_IMPORTED_MODULE_3__["ModalBuilder"],
            src_app_service_order_service__WEBPACK_IMPORTED_MODULE_5__["OrderService"]])
    ], StockReportHeaderComponent);
    return StockReportHeaderComponent;
}());



/***/ }),

/***/ "./src/app/stock-report-panel/stock-report/stock-report.component.css":
/*!****************************************************************************!*\
  !*** ./src/app/stock-report-panel/stock-report/stock-report.component.css ***!
  \****************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL3N0b2NrLXJlcG9ydC1wYW5lbC9zdG9jay1yZXBvcnQvc3RvY2stcmVwb3J0LmNvbXBvbmVudC5jc3MifQ== */"

/***/ }),

/***/ "./src/app/stock-report-panel/stock-report/stock-report.component.html":
/*!*****************************************************************************!*\
  !*** ./src/app/stock-report-panel/stock-report/stock-report.component.html ***!
  \*****************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div>\n  <stock-report-header\n    [order]=\"order\"\n    (onCloseOrderEvent)=\"onCloseOrder()\"\n  ></stock-report-header>\n  <list-stock-item *ngIf=\"order\"\n    [order]=\"order\"\n    [stockItems]=\"order.items.values()\"\n    (onCreateStockItemEvent)=\"onNewStockItem($event)\"\n    (onChangeStockItemEvent)=\"onChangeStockItem($event)\"\n    (onDeleteStockItemEvent)=\"onDeleteStockItem($event)\"\n  ></list-stock-item>\n  <div class=\"container=fluid\">\n    <button class=\"btn btn-primary\"\n        (click)=\"onClickBack()\"\n        style=\"float: right\"\n    >Back</button>\n</div>\n</div>"

/***/ }),

/***/ "./src/app/stock-report-panel/stock-report/stock-report.component.ts":
/*!***************************************************************************!*\
  !*** ./src/app/stock-report-panel/stock-report/stock-report.component.ts ***!
  \***************************************************************************/
/*! exports provided: StockReportComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "StockReportComponent", function() { return StockReportComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _service_order_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../service/order-service */ "./src/app/service/order-service.ts");
/* harmony import */ var _model_StockItem__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../model/StockItem */ "./src/app/model/StockItem.ts");
/* harmony import */ var _model_Order__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../model/Order */ "./src/app/model/Order.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _model_Customer__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../../model/Customer */ "./src/app/model/Customer.ts");
/* harmony import */ var _model_Product__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ../../model/Product */ "./src/app/model/Product.ts");








var StockReportComponent = /** @class */ (function () {
    function StockReportComponent(orderService, route, router) {
        this.orderService = orderService;
        this.route = route;
        this.router = router;
        this.reportId = 1;
    }
    StockReportComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.order = new _model_Order__WEBPACK_IMPORTED_MODULE_4__["Order"]();
        var orderId = parseInt(this.route.snapshot.paramMap.get('id'));
        this.orderService.getOrder(orderId).subscribe(function (data) {
            _this.order.id = data.id;
            _this.order.name = data.name;
            _this.order.comment = data.comment;
            _this.order.status = data.status;
            _this.order.customer = _model_Customer__WEBPACK_IMPORTED_MODULE_6__["Customer"].fromJson(data.customer);
            for (var _i = 0, _a = data.items; _i < _a.length; _i++) {
                var item = _a[_i];
                var barCodeId = void 0;
                if (item.barCode != null) {
                    barCodeId = item.barCode.id;
                }
                var product = new _model_Product__WEBPACK_IMPORTED_MODULE_7__["Product"](item.product.id, item.product.name, item.product.price);
                var stockItem = new _model_StockItem__WEBPACK_IMPORTED_MODULE_3__["StockItem"](item.id, barCodeId, item.quantity, product, item.createdDatetime, item.lastModifiedDatetime);
                _this.order.items.set(stockItem.id, stockItem);
            }
        });
    };
    StockReportComponent.prototype.onNewStockItem = function (stockItemToAdd) {
        this.order.items.set(stockItemToAdd.id, stockItemToAdd);
    };
    StockReportComponent.prototype.onChangeStockItem = function (stockItemToUpdate) {
        this.order.items.set(stockItemToUpdate.id, stockItemToUpdate);
    };
    StockReportComponent.prototype.onDeleteStockItem = function (id) {
        this.order.items.delete(id);
    };
    StockReportComponent.prototype.onCloseOrder = function () {
        this.orderService.closeOrder(this.order);
    };
    StockReportComponent.prototype.onClickBack = function () {
        this.router.navigate(['']);
    };
    StockReportComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'stock-report',
            template: __webpack_require__(/*! ./stock-report.component.html */ "./src/app/stock-report-panel/stock-report/stock-report.component.html"),
            changeDetection: _angular_core__WEBPACK_IMPORTED_MODULE_1__["ChangeDetectionStrategy"].Default,
            styles: [__webpack_require__(/*! ./stock-report.component.css */ "./src/app/stock-report-panel/stock-report/stock-report.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_service_order_service__WEBPACK_IMPORTED_MODULE_2__["OrderService"],
            _angular_router__WEBPACK_IMPORTED_MODULE_5__["ActivatedRoute"],
            _angular_router__WEBPACK_IMPORTED_MODULE_5__["Router"]])
    ], StockReportComponent);
    return StockReportComponent;
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