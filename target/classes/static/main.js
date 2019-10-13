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

module.exports = "<div class=\"container-fluid\">\r\n    <form [formGroup]=\"adminForm\" (ngSubmit)=\"onSubmit()\">\r\n      <div class=\"form-group\">\r\n          <label class=\"form-check-label\" for=\"notification\">Notification &nbsp;</label>\r\n          <input type=\"checkbox\" formControlName=\"notification\" class=\"form-check-input\" (input)=\"settingChanged()\">\r\n      </div>\r\n      <div class=\"form-group\">\r\n        <label for=\"Email\">Email addresses\r\n          <span style=\"font-size: 80%; font-style: italic\">(Use comma ',' delimiter for multiple emails)</span\r\n        ></label>\r\n        <input type=\"text\" formControlName=\"emails\"\r\n          (input)=\"settingChanged()\"\r\n          class=\"form-control\"\r\n        />\r\n      </div>\r\n      <div class=\"form-group\">\r\n        <label for=\"itemToShow\">List item number to load by default</label>\r\n        <input type=\"text\" formControlName=\"itemToShow\"\r\n          (input)=\"settingChanged()\"\r\n          class=\"form-control\"\r\n        />\r\n      </div>\r\n      <div class=\"form-group\">\r\n        <button type=\"submit\" class=\"btn btn-primary\" [disabled]=\"saveButtonDisabled\">Save</button>\r\n      </div>\r\n    </form>\r\n    <ngb-alert *ngIf=\"alertMessage\" type=\"success\" (close)=\"alertMessage = null\">{{ alertMessage }}</ngb-alert>\r\n</div>"

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
            itemToShow: ['', _angular_forms__WEBPACK_IMPORTED_MODULE_4__["Validators"].min(1)],
            emails: ['', [_angular_forms__WEBPACK_IMPORTED_MODULE_4__["Validators"].required]]
        });
        this.adminSetting = new src_app_model_admin_AdminSetting__WEBPACK_IMPORTED_MODULE_3__["AdminSetting"]();
        this.adminSettingService.getAdminSetting(this.adminSetting)
            .subscribe(function (data) {
            _this.adminSetting.emails = data.emails;
            _this.adminSetting.itemToShow = data.loadItemsLimit;
            _this.adminSetting.notifyOnCloseReport = data.notificationPolicy.onCloseReport;
            _this.adminForm.setValue({
                notification: _this.adminSetting.notifyOnCloseReport,
                emails: _this.adminSetting.emails.join(),
                itemToShow: _this.adminSetting.itemToShow
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
        this.adminSetting.itemToShow = values.itemToShow;
        this.adminSetting.notifyOnCloseReport = values.notification;
        this.adminSettingService.updateAdminSetting(this.adminSetting).subscribe(function (data) {
            _this.adminSetting.emails = data.emails;
            _this.adminSetting.itemToShow = data.loadItemsLimit;
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

module.exports = "a {\r\n color: gray\r\n}\r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvYXBwLW5hdi1iYXIvYXBwLW5hdi1iYXIuY29tcG9uZW50LmNzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQTtDQUNDO0FBQ0QiLCJmaWxlIjoic3JjL2FwcC9hcHAtbmF2LWJhci9hcHAtbmF2LWJhci5jb21wb25lbnQuY3NzIiwic291cmNlc0NvbnRlbnQiOlsiYSB7XHJcbiBjb2xvcjogZ3JheVxyXG59Il19 */"

/***/ }),

/***/ "./src/app/app-nav-bar/app-nav-bar.component.html":
/*!********************************************************!*\
  !*** ./src/app/app-nav-bar/app-nav-bar.component.html ***!
  \********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<nav *ngIf=\"isLoggedIn$ | async\" class=\"navbar navbar-light navbar-expand-md fixed-top border-bottom\" style=\"background-color: white\">\r\n  <img src=\"../../assets/img/andybrook-logo-home.png\">\r\n  <button class=\"navbar-toggler hidden-sm-up\" type=\"button\" (click)=\"isNavbarCollapsed = !isNavbarCollapsed\" data-target=\"#navbarsDefault\" aria-controls=\"navbarsDefault\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n    <span class=\"navbar-toggler-icon\"></span>\r\n  </button>\r\n  <div [ngbCollapse]=\"isNavbarCollapsed\" class=\"collapse navbar-collapse\" id=\"navbarsDefault\">\r\n    <ul class=\"navbar-nav mr-auto\">\r\n      <li class=\"nav-item\">\r\n        <a class=\"nav-link\"\r\n            routerLink=\"/orders\"\r\n        >Orders</a>\r\n      </li>\r\n      <li class=\"nav-item dropdown\" ngbDropdown>\r\n        <a class=\"nav-link dropdown-toggle\" id=\"id01\" ngbDropdownToggle>Customers</a>\r\n        <div class=\"dropdown-menu\" aria-labelledby=\"id01\" ngbDropdownMenu>\r\n          <a class=\"dropdown-item\" routerLink=\"/customer-dashboard\">Dashboard</a>\r\n          <a class=\"dropdown-item\" routerLink=\"/new-customer/-1\">New Customer</a>\r\n        </div>\r\n      </li>\r\n      <li class=\"nav-item\">\r\n        <a class=\"nav-link\"\r\n            routerLink=\"/products\"\r\n        >Products</a>\r\n      </li>\r\n      <li class=\"nav-item\">\r\n        <a class=\"nav-link\"\r\n            routerLink=\"/monitoring\"\r\n        >Monitoring</a>\r\n      </li>\r\n      <li class=\"nav-item\">\r\n        <a class=\"nav-link\"\r\n            routerLink=\"/admin\"\r\n        >Admin</a>\r\n      </li>\r\n    </ul>\r\n    <ul class=\"navbar-nav\">\r\n        <li class=\"nav-item\">\r\n            <a (click)=\"onLogout()\">\r\n              <img src=\"../../assets/icon/account-logout.png\">\r\n            </a>\r\n        </li>\r\n      </ul>\r\n  </div>\r\n</nav>"

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
/* harmony import */ var _service_login_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../service/login-service */ "./src/app/service/login-service.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");




var AppNavBarComponent = /** @class */ (function () {
    function AppNavBarComponent(loginService, router) {
        this.loginService = loginService;
        this.router = router;
        this.isNavbarCollapsed = true;
    }
    AppNavBarComponent.prototype.ngOnInit = function () {
        this.isLoggedIn$ = this.loginService.getUserLoggedObservable();
    };
    AppNavBarComponent.prototype.onLogout = function () {
        this.loginService.logout();
        this.router.navigateByUrl('/');
    };
    AppNavBarComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-app-nav-bar',
            template: __webpack_require__(/*! ./app-nav-bar.component.html */ "./src/app/app-nav-bar/app-nav-bar.component.html"),
            styles: [__webpack_require__(/*! ./app-nav-bar.component.css */ "./src/app/app-nav-bar/app-nav-bar.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_service_login_service__WEBPACK_IMPORTED_MODULE_2__["LoginService"], _angular_router__WEBPACK_IMPORTED_MODULE_3__["Router"]])
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

module.exports = "<app-app-nav-bar></app-app-nav-bar>\r\n<br>\r\n<br>\r\n<br>\r\n<div class=\"container-fluid\">\r\n    <router-outlet></router-outlet>\r\n</div>\r\n\r\n"

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
/* harmony import */ var _order_panel_show_order_header_show_order_header_component__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__(/*! ./order-panel/show-order-header/show-order-header.component */ "./src/app/order-panel/show-order-header/show-order-header.component.ts");
/* harmony import */ var _orders_manager_panel_list_orders_list_orders_component__WEBPACK_IMPORTED_MODULE_17__ = __webpack_require__(/*! ./orders-manager-panel/list-orders/list-orders.component */ "./src/app/orders-manager-panel/list-orders/list-orders.component.ts");
/* harmony import */ var _ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_18__ = __webpack_require__(/*! @ng-bootstrap/ng-bootstrap */ "./node_modules/@ng-bootstrap/ng-bootstrap/fesm5/ng-bootstrap.js");
/* harmony import */ var _admin_admin_panel_admin_panel_component__WEBPACK_IMPORTED_MODULE_19__ = __webpack_require__(/*! ./admin/admin-panel/admin-panel.component */ "./src/app/admin/admin-panel/admin-panel.component.ts");
/* harmony import */ var _shared_module__WEBPACK_IMPORTED_MODULE_20__ = __webpack_require__(/*! ./shared.module */ "./src/app/shared.module.ts");
/* harmony import */ var _customer_customer_panel_customer_panel_component__WEBPACK_IMPORTED_MODULE_21__ = __webpack_require__(/*! ./customer/customer-panel/customer-panel.component */ "./src/app/customer/customer-panel/customer-panel.component.ts");
/* harmony import */ var _service_notification_service__WEBPACK_IMPORTED_MODULE_22__ = __webpack_require__(/*! ./service/notification-service */ "./src/app/service/notification-service.ts");
/* harmony import */ var _app_nav_bar_app_nav_bar_component__WEBPACK_IMPORTED_MODULE_23__ = __webpack_require__(/*! ./app-nav-bar/app-nav-bar.component */ "./src/app/app-nav-bar/app-nav-bar.component.ts");
/* harmony import */ var _modal_confirm_modal_confirm_modal_component__WEBPACK_IMPORTED_MODULE_24__ = __webpack_require__(/*! ./modal/confirm-modal/confirm-modal-component */ "./src/app/modal/confirm-modal/confirm-modal-component.ts");
/* harmony import */ var _common_components_modal_builder__WEBPACK_IMPORTED_MODULE_25__ = __webpack_require__(/*! ./common-components/modal-builder */ "./src/app/common-components/modal-builder.ts");
/* harmony import */ var _modal_create_order_modal_create_order_modal_component__WEBPACK_IMPORTED_MODULE_26__ = __webpack_require__(/*! ./modal/create-order-modal/create-order-modal.component */ "./src/app/modal/create-order-modal/create-order-modal.component.ts");
/* harmony import */ var _service_customer_service__WEBPACK_IMPORTED_MODULE_27__ = __webpack_require__(/*! ./service/customer-service */ "./src/app/service/customer-service.ts");
/* harmony import */ var _modal_info_modal_info_modal_component__WEBPACK_IMPORTED_MODULE_28__ = __webpack_require__(/*! ./modal/info-modal/info-modal.component */ "./src/app/modal/info-modal/info-modal.component.ts");
/* harmony import */ var _service_product_service__WEBPACK_IMPORTED_MODULE_29__ = __webpack_require__(/*! ./service/product-service */ "./src/app/service/product-service.ts");
/* harmony import */ var _modal_show_order_items_modal_show_order_items_modal_component__WEBPACK_IMPORTED_MODULE_30__ = __webpack_require__(/*! ./modal/show-order-items-modal/show-order-items-modal.component */ "./src/app/modal/show-order-items-modal/show-order-items-modal.component.ts");
/* harmony import */ var _order_panel_selected_order_items_list_selected_order_items_list_component__WEBPACK_IMPORTED_MODULE_31__ = __webpack_require__(/*! ./order-panel/selected-order-items-list/selected-order-items-list.component */ "./src/app/order-panel/selected-order-items-list/selected-order-items-list.component.ts");
/* harmony import */ var _modal_delete_order_items_modal_delete_order_items_modal_component__WEBPACK_IMPORTED_MODULE_32__ = __webpack_require__(/*! ./modal/delete-order-items-modal/delete-order-items-modal.component */ "./src/app/modal/delete-order-items-modal/delete-order-items-modal.component.ts");
/* harmony import */ var _modal_add_order_item_modal_add_order_item_modal_component__WEBPACK_IMPORTED_MODULE_33__ = __webpack_require__(/*! ./modal/add-order-item-modal/add-order-item-modal.component */ "./src/app/modal/add-order-item-modal/add-order-item-modal.component.ts");
/* harmony import */ var ngx_cookie_service__WEBPACK_IMPORTED_MODULE_34__ = __webpack_require__(/*! ngx-cookie-service */ "./node_modules/ngx-cookie-service/index.js");
/* harmony import */ var _customer_list_customer_list_customer_component__WEBPACK_IMPORTED_MODULE_35__ = __webpack_require__(/*! ./customer/list-customer/list-customer.component */ "./src/app/customer/list-customer/list-customer.component.ts");
/* harmony import */ var _customer_customer_info_customer_info_component__WEBPACK_IMPORTED_MODULE_36__ = __webpack_require__(/*! ./customer/customer-info/customer-info.component */ "./src/app/customer/customer-info/customer-info.component.ts");
/* harmony import */ var _customer_customer_header_customer_header_component__WEBPACK_IMPORTED_MODULE_37__ = __webpack_require__(/*! ./customer/customer-header/customer-header.component */ "./src/app/customer/customer-header/customer-header.component.ts");
/* harmony import */ var _customer_new_customer_new_customer_component__WEBPACK_IMPORTED_MODULE_38__ = __webpack_require__(/*! ./customer/new-customer/new-customer.component */ "./src/app/customer/new-customer/new-customer.component.ts");
/* harmony import */ var ng2_file_upload__WEBPACK_IMPORTED_MODULE_39__ = __webpack_require__(/*! ng2-file-upload */ "./node_modules/ng2-file-upload/index.js");
/* harmony import */ var ng2_file_upload__WEBPACK_IMPORTED_MODULE_39___default = /*#__PURE__*/__webpack_require__.n(ng2_file_upload__WEBPACK_IMPORTED_MODULE_39__);
/* harmony import */ var _modal_order_notification_modal_order_notification_modal_component__WEBPACK_IMPORTED_MODULE_40__ = __webpack_require__(/*! ./modal/order-notification-modal/order-notification-modal.component */ "./src/app/modal/order-notification-modal/order-notification-modal.component.ts");
/* harmony import */ var _modal_upload_product_file_modal_upload_product_file_modal_component__WEBPACK_IMPORTED_MODULE_41__ = __webpack_require__(/*! ./modal/upload-product-file-modal/upload-product-file-modal.component */ "./src/app/modal/upload-product-file-modal/upload-product-file-modal.component.ts");
/* harmony import */ var _product_products_panel_products_panel_component__WEBPACK_IMPORTED_MODULE_42__ = __webpack_require__(/*! ./product/products-panel/products-panel.component */ "./src/app/product/products-panel/products-panel.component.ts");
/* harmony import */ var _authentication_login_login_component__WEBPACK_IMPORTED_MODULE_43__ = __webpack_require__(/*! ./authentication/login/login.component */ "./src/app/authentication/login/login.component.ts");
/* harmony import */ var _service_login_service__WEBPACK_IMPORTED_MODULE_44__ = __webpack_require__(/*! ./service/login-service */ "./src/app/service/login-service.ts");
/* harmony import */ var _http_interceptor_Interceptors_manager__WEBPACK_IMPORTED_MODULE_45__ = __webpack_require__(/*! ./http-interceptor/Interceptors-manager */ "./src/app/http-interceptor/Interceptors-manager.ts");
/* harmony import */ var _monitoring_dashboard_dashboard_component__WEBPACK_IMPORTED_MODULE_46__ = __webpack_require__(/*! ./monitoring/dashboard/dashboard.component */ "./src/app/monitoring/dashboard/dashboard.component.ts");
/* harmony import */ var _service_monitoring_service__WEBPACK_IMPORTED_MODULE_47__ = __webpack_require__(/*! ./service/monitoring-service */ "./src/app/service/monitoring-service.ts");
/* harmony import */ var _customer_store_store_dashboard_store_dashboard_component__WEBPACK_IMPORTED_MODULE_48__ = __webpack_require__(/*! ./customer/store/store-dashboard/store-dashboard.component */ "./src/app/customer/store/store-dashboard/store-dashboard.component.ts");
/* harmony import */ var _service_store_service__WEBPACK_IMPORTED_MODULE_49__ = __webpack_require__(/*! ./service/store-service */ "./src/app/service/store-service.ts");
/* harmony import */ var _customer_store_store_orders_store_orders_component__WEBPACK_IMPORTED_MODULE_50__ = __webpack_require__(/*! ./customer/store/store-orders/store-orders.component */ "./src/app/customer/store/store-orders/store-orders.component.ts");
/* harmony import */ var _customer_store_store_info_store_info_component__WEBPACK_IMPORTED_MODULE_51__ = __webpack_require__(/*! ./customer/store/store-info/store-info.component */ "./src/app/customer/store/store-info/store-info.component.ts");
/* harmony import */ var _service_orders_statistic_service__WEBPACK_IMPORTED_MODULE_52__ = __webpack_require__(/*! ./service/orders-statistic-service */ "./src/app/service/orders-statistic-service.ts");
/* harmony import */ var _customer_store_open_closed_orders_counter_open_closed_orders_counter_component__WEBPACK_IMPORTED_MODULE_53__ = __webpack_require__(/*! ./customer/store/open-closed-orders-counter/open-closed-orders-counter.component */ "./src/app/customer/store/open-closed-orders-counter/open-closed-orders-counter.component.ts");






















































var appRoutes = [
    { path: '', component: _authentication_login_login_component__WEBPACK_IMPORTED_MODULE_43__["LoginComponent"] },
    { path: 'login', component: _authentication_login_login_component__WEBPACK_IMPORTED_MODULE_43__["LoginComponent"] },
    { path: 'orders', component: _orders_manager_panel_orders_manager_orders_manager_component__WEBPACK_IMPORTED_MODULE_11__["OrdersManagerComponent"] },
    { path: 'order/:id', component: _order_panel_show_order_show_order_component__WEBPACK_IMPORTED_MODULE_12__["ShowOrderComponent"] },
    { path: 'admin', component: _admin_admin_panel_admin_panel_component__WEBPACK_IMPORTED_MODULE_19__["AdminPanelComponent"] },
    { path: 'new-customer/:id', component: _customer_new_customer_new_customer_component__WEBPACK_IMPORTED_MODULE_38__["NewCustomerComponent"] },
    { path: 'customer-dashboard', component: _customer_customer_panel_customer_panel_component__WEBPACK_IMPORTED_MODULE_21__["CustomerPanelComponent"] },
    { path: 'store/:id', component: _customer_store_store_dashboard_store_dashboard_component__WEBPACK_IMPORTED_MODULE_48__["StoreDashboardComponent"] },
    { path: 'products', component: _product_products_panel_products_panel_component__WEBPACK_IMPORTED_MODULE_42__["ProductsPanelComponent"] },
    { path: 'monitoring', component: _monitoring_dashboard_dashboard_component__WEBPACK_IMPORTED_MODULE_46__["DashboardComponent"] }
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
                _order_panel_show_order_header_show_order_header_component__WEBPACK_IMPORTED_MODULE_16__["OrderHeaderComponent"],
                _orders_manager_panel_list_orders_list_orders_component__WEBPACK_IMPORTED_MODULE_17__["ListOrdersComponent"],
                _admin_admin_panel_admin_panel_component__WEBPACK_IMPORTED_MODULE_19__["AdminPanelComponent"],
                _customer_customer_panel_customer_panel_component__WEBPACK_IMPORTED_MODULE_21__["CustomerPanelComponent"],
                _app_nav_bar_app_nav_bar_component__WEBPACK_IMPORTED_MODULE_23__["AppNavBarComponent"],
                _modal_confirm_modal_confirm_modal_component__WEBPACK_IMPORTED_MODULE_24__["ConfirmModalComponent"],
                _modal_create_order_modal_create_order_modal_component__WEBPACK_IMPORTED_MODULE_26__["CreateOrderModalComponent"],
                _modal_info_modal_info_modal_component__WEBPACK_IMPORTED_MODULE_28__["InfoModalComponent"],
                _modal_show_order_items_modal_show_order_items_modal_component__WEBPACK_IMPORTED_MODULE_30__["ShowOrderItemsModalComponent"],
                _order_panel_selected_order_items_list_selected_order_items_list_component__WEBPACK_IMPORTED_MODULE_31__["SelectedOrderItemsListComponent"],
                _modal_delete_order_items_modal_delete_order_items_modal_component__WEBPACK_IMPORTED_MODULE_32__["DeleteOrderItemsModalComponent"],
                _modal_add_order_item_modal_add_order_item_modal_component__WEBPACK_IMPORTED_MODULE_33__["AddOrderItemModalComponent"],
                _customer_list_customer_list_customer_component__WEBPACK_IMPORTED_MODULE_35__["ListCustomerComponent"],
                _customer_store_store_orders_store_orders_component__WEBPACK_IMPORTED_MODULE_50__["StoreOrdersComponent"],
                _customer_customer_info_customer_info_component__WEBPACK_IMPORTED_MODULE_36__["CustomerInfoComponent"],
                _customer_customer_header_customer_header_component__WEBPACK_IMPORTED_MODULE_37__["CustomerHeaderComponent"],
                _customer_new_customer_new_customer_component__WEBPACK_IMPORTED_MODULE_38__["NewCustomerComponent"],
                _modal_order_notification_modal_order_notification_modal_component__WEBPACK_IMPORTED_MODULE_40__["OrderNotificationModalComponent"],
                _modal_upload_product_file_modal_upload_product_file_modal_component__WEBPACK_IMPORTED_MODULE_41__["UploadProductFileModalComponent"],
                _product_products_panel_products_panel_component__WEBPACK_IMPORTED_MODULE_42__["ProductsPanelComponent"],
                _authentication_login_login_component__WEBPACK_IMPORTED_MODULE_43__["LoginComponent"],
                _monitoring_dashboard_dashboard_component__WEBPACK_IMPORTED_MODULE_46__["DashboardComponent"],
                _customer_store_store_dashboard_store_dashboard_component__WEBPACK_IMPORTED_MODULE_48__["StoreDashboardComponent"],
                _customer_store_store_info_store_info_component__WEBPACK_IMPORTED_MODULE_51__["StoreInfoComponent"],
                _customer_store_open_closed_orders_counter_open_closed_orders_counter_component__WEBPACK_IMPORTED_MODULE_53__["OpenClosedOrdersCounterComponent"]
            ],
            entryComponents: [
                _modal_create_order_modal_create_order_modal_component__WEBPACK_IMPORTED_MODULE_26__["CreateOrderModalComponent"],
                _modal_confirm_modal_confirm_modal_component__WEBPACK_IMPORTED_MODULE_24__["ConfirmModalComponent"],
                _modal_info_modal_info_modal_component__WEBPACK_IMPORTED_MODULE_28__["InfoModalComponent"],
                _modal_show_order_items_modal_show_order_items_modal_component__WEBPACK_IMPORTED_MODULE_30__["ShowOrderItemsModalComponent"],
                _modal_delete_order_items_modal_delete_order_items_modal_component__WEBPACK_IMPORTED_MODULE_32__["DeleteOrderItemsModalComponent"],
                _modal_add_order_item_modal_add_order_item_modal_component__WEBPACK_IMPORTED_MODULE_33__["AddOrderItemModalComponent"],
                _modal_order_notification_modal_order_notification_modal_component__WEBPACK_IMPORTED_MODULE_40__["OrderNotificationModalComponent"]
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
                _ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_18__["NgbModule"],
                _shared_module__WEBPACK_IMPORTED_MODULE_20__["SharedModule"],
                ng2_file_upload__WEBPACK_IMPORTED_MODULE_39__["FileUploadModule"],
                _angular_router__WEBPACK_IMPORTED_MODULE_7__["RouterModule"].forRoot(appRoutes)
            ],
            providers: [
                _service_order_service__WEBPACK_IMPORTED_MODULE_13__["OrderService"],
                _service_orders_statistic_service__WEBPACK_IMPORTED_MODULE_52__["OrdersStatisticService"],
                _service_http_service__WEBPACK_IMPORTED_MODULE_14__["HttpService"],
                _service_admin_setting_service__WEBPACK_IMPORTED_MODULE_15__["AdminSettingService"],
                _service_notification_service__WEBPACK_IMPORTED_MODULE_22__["NotificationService"],
                _common_components_modal_builder__WEBPACK_IMPORTED_MODULE_25__["ModalBuilder"],
                _service_customer_service__WEBPACK_IMPORTED_MODULE_27__["CustomerService"],
                _service_store_service__WEBPACK_IMPORTED_MODULE_49__["StoreService"],
                _service_product_service__WEBPACK_IMPORTED_MODULE_29__["ProductService"],
                ngx_cookie_service__WEBPACK_IMPORTED_MODULE_34__["CookieService"],
                _service_login_service__WEBPACK_IMPORTED_MODULE_44__["LoginService"],
                _service_monitoring_service__WEBPACK_IMPORTED_MODULE_47__["MonitoringService"],
                _http_interceptor_Interceptors_manager__WEBPACK_IMPORTED_MODULE_45__["httpInterceptorProviders"]
            ],
            bootstrap: [_app_component__WEBPACK_IMPORTED_MODULE_9__["AppComponent"]]
        })
    ], AppModule);
    return AppModule;
}());



/***/ }),

/***/ "./src/app/authentication/login/login.component.css":
/*!**********************************************************!*\
  !*** ./src/app/authentication/login/login.component.css ***!
  \**********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL2F1dGhlbnRpY2F0aW9uL2xvZ2luL2xvZ2luLmNvbXBvbmVudC5jc3MifQ== */"

/***/ }),

/***/ "./src/app/authentication/login/login.component.html":
/*!***********************************************************!*\
  !*** ./src/app/authentication/login/login.component.html ***!
  \***********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"card w-75 mt-5 shadow-sm p-3 mb-5 bg-white rounded\" style=\"margin: auto; max-width: 35em;\">\n  <div class=\"card-body\">\n    <picture>\n      <source media=\"(min-width: 1200px)\" srcset=\"../../../assets/img/andybrook-logo.png\" style=\"max-width: 100%\">\n      <source media=\"(min-width: 100px)\" srcset=\"../../../assets/img/andybrook-short-logo.png\" style=\"max-width: 100%\">\n      <img src=\"../../../assets/img/andybrook-logo.png\" style=\"max-width: 100%\">\n    </picture>\n    <form [formGroup]=\"loginForm\" (ngSubmit)=\"onSubmit()\">\n      <div class=\"form-group\">\n        <label for=\"username\">Username :</label>\n        <input type=\"text\" class=\"form-control\" formControlName=\"username\" id=\"username\" autocomplete=\"off\">\n        <div class=\"error\" *ngIf=\"loginForm.controls['username'].hasError('required') && loginForm.controls['username'].touched\">Username is required</div>\n      </div>\n      <div class=\"form-group\">\n        <label for=\"pwd\">Password :</label>\n        <input type=\"password\" class=\"form-control\" formControlName=\"password\" id=\"pwd\" autocomplete=\"off\">\n        <div class=\"error\" *ngIf=\"loginForm.controls['password'].hasError('required') && loginForm.controls['password'].touched\">Password is required</div>\n      </div>\n        <div class=\"row\">\n          <div class=\"col\">\n            <button class=\"btn btn-success\" [disabled]=\"loginForm.invalid\">Login</button>\n          </div>\n          <div class=\"col\">\n            <ngb-alert *ngIf=\"_errorMessage\" type=\"danger\" [dismissible]=\"true\" (close)=\"_errorMessage = null\">{{ _errorMessage }}</ngb-alert>\n          </div>\n        </div>\n    </form>\n  </div>\n</div>"

/***/ }),

/***/ "./src/app/authentication/login/login.component.ts":
/*!*********************************************************!*\
  !*** ./src/app/authentication/login/login.component.ts ***!
  \*********************************************************/
/*! exports provided: LoginComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "LoginComponent", function() { return LoginComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var _model_request_login_LoginRequest__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../model/request/login/LoginRequest */ "./src/app/model/request/login/LoginRequest.ts");
/* harmony import */ var _service_login_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../../service/login-service */ "./src/app/service/login-service.ts");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");








var LoginComponent = /** @class */ (function () {
    function LoginComponent(formBuilder, router, loginService) {
        this.formBuilder = formBuilder;
        this.router = router;
        this.loginService = loginService;
        this.invalidLogin = false;
        this._error = new rxjs__WEBPACK_IMPORTED_MODULE_6__["Subject"]();
    }
    LoginComponent.prototype.ngOnInit = function () {
        var _this = this;
        this._error.subscribe(function (msg) { return _this._errorMessage = msg; });
        this._error.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_7__["debounceTime"])(2000)).subscribe(function () { return _this._errorMessage = null; });
        this.loginForm = this.formBuilder.group({
            username: ['', _angular_forms__WEBPACK_IMPORTED_MODULE_3__["Validators"].compose([_angular_forms__WEBPACK_IMPORTED_MODULE_3__["Validators"].required])],
            password: ['', _angular_forms__WEBPACK_IMPORTED_MODULE_3__["Validators"].required]
        });
    };
    LoginComponent.prototype.onSubmit = function () {
        var _this = this;
        if (this.loginForm.valid) {
            var username_1 = this.loginForm.get("username").value;
            var loginRequest = new _model_request_login_LoginRequest__WEBPACK_IMPORTED_MODULE_4__["LoginRequest"](username_1, this.loginForm.get("password").value);
            this.loginService.authenticate(loginRequest).subscribe(function (data) {
                _this.router.navigateByUrl('/orders');
                _this.loginService.setUserLoggedIn(true, username_1);
            }, function (error) {
                _this.changeErrorMessage("Invalid credentials");
            });
        }
    };
    LoginComponent.prototype.changeErrorMessage = function (errorMessage) {
        this._error.next(errorMessage);
    };
    LoginComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'login',
            template: __webpack_require__(/*! ./login.component.html */ "./src/app/authentication/login/login.component.html"),
            styles: [__webpack_require__(/*! ./login.component.css */ "./src/app/authentication/login/login.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_angular_forms__WEBPACK_IMPORTED_MODULE_3__["FormBuilder"], _angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"], _service_login_service__WEBPACK_IMPORTED_MODULE_5__["LoginService"]])
    ], LoginComponent);
    return LoginComponent;
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

module.exports = "label {\r\n    font-weight: bold;\r\n}\r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvY3VzdG9tZXIvY3VzdG9tZXItaW5mby9jdXN0b21lci1pbmZvLmNvbXBvbmVudC5jc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUE7SUFDSSxpQkFBaUI7QUFDckIiLCJmaWxlIjoic3JjL2FwcC9jdXN0b21lci9jdXN0b21lci1pbmZvL2N1c3RvbWVyLWluZm8uY29tcG9uZW50LmNzcyIsInNvdXJjZXNDb250ZW50IjpbImxhYmVsIHtcclxuICAgIGZvbnQtd2VpZ2h0OiBib2xkO1xyXG59Il19 */"

/***/ }),

/***/ "./src/app/customer/customer-info/customer-info.component.html":
/*!*********************************************************************!*\
  !*** ./src/app/customer/customer-info/customer-info.component.html ***!
  \*********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"row\">\r\n  <div class=\"col\">\r\n    <h5>Store Information</h5>\r\n    <hr>\r\n    <div *ngIf=\"customer\">\r\n      <label>ID :</label> {{ customer.store.id }}\r\n      <br>\r\n      <label>Store :</label> {{ customer.store.name }}\r\n      <br>\r\n      <label>Address :</label> {{ customer.store.address.format() }}\r\n      <br>\r\n      <label>Phone :</label> {{ customer.store.phone }}\r\n      <br>\r\n      <label>Email :</label> {{ customer.store.email }}\r\n    </div>\r\n  </div>\r\n  <div class=\"col\">\r\n    <h5>Owner Information</h5>\r\n    <hr>\r\n    <div *ngIf=\"customer\">\r\n      <label>ID :</label> {{ customer.store.owner.id }}\r\n      <br>\r\n      <label>Compagny :</label> {{ customer.store.owner.compagnyName }}\r\n      <br>\r\n      <label>Name :</label> {{ customer.store.owner.firstName + ' ' + customer.store.owner.lastName }}\r\n      <br>\r\n      <label>Email :</label> {{ customer.store.owner.email }}\r\n    </div>\r\n  </div>\r\n</div>"

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

module.exports = "<div class=\"container-fluid\">\r\n  <div class=\"row\">\r\n    <customer-header></customer-header>\r\n  </div>\r\n  <div class=\"row\">\r\n    <div class=\"col\">\r\n      <list-customer [customer]=\"customer\" (onCustomerSelected)=\"onCustomerSelected($event)\"></list-customer>\r\n    </div>\r\n  </div>\r\n</div>\r\n<!--<div class=\"col-md-auto\">\r\n  <new-customer [customer]=\"customer\" (onUpdateCustomerEvent)=\"onUpdateCustomer($event)\" style=\"margin-bottom: 7px\"></new-customer>\r\n  <customer-orders [customer]=\"customer\"></customer-orders>\r\n</div>-->\r\n"

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
/* harmony import */ var src_app_service_order_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! src/app/service/order-service */ "./src/app/service/order-service.ts");
/* harmony import */ var src_app_model_Customer__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! src/app/model/Customer */ "./src/app/model/Customer.ts");
/* harmony import */ var src_app_service_customer_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! src/app/service/customer-service */ "./src/app/service/customer-service.ts");





var CustomerPanelComponent = /** @class */ (function () {
    function CustomerPanelComponent(orderService, customerService) {
        this.orderService = orderService;
        this.customerService = customerService;
        this.orders = [];
    }
    CustomerPanelComponent.prototype.ngOnInit = function () {
    };
    CustomerPanelComponent.prototype.onCustomerSelected = function (event) {
        this.customer = event;
    };
    CustomerPanelComponent.prototype.onUpdateCustomer = function (event) {
        var _this = this;
        this.customerService.getCustomer(event.id).subscribe(function (data) {
            _this.customer = src_app_model_Customer__WEBPACK_IMPORTED_MODULE_3__["Customer"].fromJson(data);
        });
    };
    CustomerPanelComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'customer-panel',
            template: __webpack_require__(/*! ./customer-panel.component.html */ "./src/app/customer/customer-panel/customer-panel.component.html"),
            styles: [__webpack_require__(/*! ./customer-panel.component.css */ "./src/app/customer/customer-panel/customer-panel.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [src_app_service_order_service__WEBPACK_IMPORTED_MODULE_2__["OrderService"],
            src_app_service_customer_service__WEBPACK_IMPORTED_MODULE_4__["CustomerService"]])
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

module.exports = "/* Scroll Bar customer list table */\r\n.my-custom-scrollbar {\r\n    position: relative;\r\n    max-height: 750px;\r\n    overflow: auto;\r\n  }\r\n.table-wrapper-scroll-y {\r\n    display: block;\r\n  }\r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvY3VzdG9tZXIvbGlzdC1jdXN0b21lci9saXN0LWN1c3RvbWVyLmNvbXBvbmVudC5jc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUEsbUNBQW1DO0FBQ25DO0lBQ0ksa0JBQWtCO0lBQ2xCLGlCQUFpQjtJQUNqQixjQUFjO0VBQ2hCO0FBRUE7SUFDRSxjQUFjO0VBQ2hCIiwiZmlsZSI6InNyYy9hcHAvY3VzdG9tZXIvbGlzdC1jdXN0b21lci9saXN0LWN1c3RvbWVyLmNvbXBvbmVudC5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyIvKiBTY3JvbGwgQmFyIGN1c3RvbWVyIGxpc3QgdGFibGUgKi9cclxuLm15LWN1c3RvbS1zY3JvbGxiYXIge1xyXG4gICAgcG9zaXRpb246IHJlbGF0aXZlO1xyXG4gICAgbWF4LWhlaWdodDogNzUwcHg7XHJcbiAgICBvdmVyZmxvdzogYXV0bztcclxuICB9XHJcbiAgXHJcbiAgLnRhYmxlLXdyYXBwZXItc2Nyb2xsLXkge1xyXG4gICAgZGlzcGxheTogYmxvY2s7XHJcbiAgfSJdfQ== */"

/***/ }),

/***/ "./src/app/customer/list-customer/list-customer.component.html":
/*!*********************************************************************!*\
  !*** ./src/app/customer/list-customer/list-customer.component.html ***!
  \*********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"card w-100 shadow-sm p-3 mb-5 bg-white rounded\">\r\n  <div class=\"card-header\">\r\n    <div class=\"row\">\r\n      <div class=\"col\">\r\n        <h5>Customers</h5>\r\n      </div>\r\n      <div class=\"col\" style=\"float:right\">\r\n        <input #searchInput type=\"search\"\r\n          class=\"form-control form-control-sm\"\r\n          (keyup.enter)=\"onClickSearch(searchInput.value)\"\r\n          placeholder=\"Type to search a customer...\">\r\n      </div>\r\n    </div>\r\n  </div>\r\n  <div class=\"card-body\">\r\n    <div class=\"row\">\r\n      <div class=\"col\">\r\n        <div class=\"table-responsive table-wrapper-scroll-y my-custom-scrollbar\">\r\n          <table class=\"table table-striped table-hover\">\r\n            <thead>\r\n              <tr>\r\n                <th>ID</th>\r\n                <th>Name</th>\r\n                <th>Owner</th>\r\n                <th>Address</th>\r\n                <th>Phone</th>\r\n                <th>Email</th>\r\n              </tr>\r\n            </thead>\r\n            <tbody>\r\n              <tr *ngFor=\"let customer of customers\" (click)=\"onClickCustomer(customer)\">\r\n                <td>{{ customer.id }}</td>\r\n                <td><a [routerLink]=\"['/store', customer.store.id]\">{{ customer.store.name }}</a></td>\r\n                <td>{{ customer.store.owner.firstName + \" \" + customer.store.owner.lastName }}</td>\r\n                <td>{{ customer.store.address.streetNumber + ', ' + customer.store.address.streetName + ' ' + customer.store.address.zipCode + ' - ' + customer.store.address.city }}</td>\r\n                <td>{{ customer.store.phone }}</td>\r\n                <td>{{ customer.store.email }}</td>\r\n              </tr>\r\n            </tbody>\r\n          </table>\r\n        </div>\r\n      </div>\r\n    </div>\r\n  </div>  \r\n</div>"

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
/* harmony import */ var src_app_service_customer_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! src/app/service/customer-service */ "./src/app/service/customer-service.ts");




var ListCustomerComponent = /** @class */ (function () {
    function ListCustomerComponent(customerService) {
        this.customerService = customerService;
        this.onCustomerSelected = new _angular_core__WEBPACK_IMPORTED_MODULE_1__["EventEmitter"]();
        this.customers = [];
    }
    ListCustomerComponent.prototype.ngOnInit = function () {
        this.getCustomersList(null);
    };
    ListCustomerComponent.prototype.getCustomersList = function (searchInput) {
        var _this = this;
        var obs;
        this.customers = [];
        if (searchInput === null || searchInput.length == 0) {
            obs = this.customerService.getAllCustomers();
        }
        else {
            obs = this.customerService.searchCustomerByIdOrNames(searchInput);
        }
        obs.subscribe(function (data) {
            for (var _i = 0, data_1 = data; _i < data_1.length; _i++) {
                var customer = data_1[_i];
                _this.customers.push(src_app_model_Customer__WEBPACK_IMPORTED_MODULE_2__["Customer"].fromJson(customer));
            }
        }, function (error) {
            _this.customers = [];
        });
    };
    ListCustomerComponent.prototype.onClickCustomer = function (customer) {
        this.onCustomerSelected.emit(customer);
    };
    ListCustomerComponent.prototype.onClickSearch = function (value) {
        this.getCustomersList(value.trim());
    };
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Output"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", Object)
    ], ListCustomerComponent.prototype, "onCustomerSelected", void 0);
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", src_app_model_Customer__WEBPACK_IMPORTED_MODULE_2__["Customer"])
    ], ListCustomerComponent.prototype, "customer", void 0);
    ListCustomerComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'list-customer',
            template: __webpack_require__(/*! ./list-customer.component.html */ "./src/app/customer/list-customer/list-customer.component.html"),
            styles: [__webpack_require__(/*! ./list-customer.component.css */ "./src/app/customer/list-customer/list-customer.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [src_app_service_customer_service__WEBPACK_IMPORTED_MODULE_3__["CustomerService"]])
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

module.exports = ".ng-invalid:not(form)  {\r\n    border-left: 5px solid #a94442; /* red */\r\n}\r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvY3VzdG9tZXIvbmV3LWN1c3RvbWVyL25ldy1jdXN0b21lci5jb21wb25lbnQuY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBO0lBQ0ksOEJBQThCLEVBQUUsUUFBUTtBQUM1QyIsImZpbGUiOiJzcmMvYXBwL2N1c3RvbWVyL25ldy1jdXN0b21lci9uZXctY3VzdG9tZXIuY29tcG9uZW50LmNzcyIsInNvdXJjZXNDb250ZW50IjpbIi5uZy1pbnZhbGlkOm5vdChmb3JtKSAge1xyXG4gICAgYm9yZGVyLWxlZnQ6IDVweCBzb2xpZCAjYTk0NDQyOyAvKiByZWQgKi9cclxufSJdfQ== */"

/***/ }),

/***/ "./src/app/customer/new-customer/new-customer.component.html":
/*!*******************************************************************!*\
  !*** ./src/app/customer/new-customer/new-customer.component.html ***!
  \*******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"card w-100 shadow-sm p-3 mb-5 bg-white rounded\">\r\n  <div class=\"card-header\">\r\n      <h5>Customer Information</h5>\r\n  </div>\r\n  <div class=\"card-body\">\r\n    <form [formGroup]=\"form\" (ngSubmit)=\"onSubmit()\">\r\n      <h5>Owner</h5>\r\n      <hr>\r\n      <div class=\"row\">\r\n        <div class=\"col form-group\">\r\n          <label for=\"compagnyName\">Compagny Nane</label>\r\n          <input type=\"text\" formControlName=\"ownerAutoComplete\"\r\n            (blur)=\"onBlurOwnerAutoComplete()\"\r\n            [(ngModel)]=\"inputOwnerName\"\r\n            [ngbTypeahead]=\"search\"\r\n            class=\"form-control form-control-sm\"/>\r\n        </div>\r\n        <div class=\"col form-group\">\r\n            <label for=\"firstName\">FirstName</label>\r\n            <input type=\"text\" formControlName=\"ownerFirstName\" class=\"form-control form-control-sm\" (blur)=onBlurStringFormControl($event)/>\r\n        </div>\r\n        <div class=\"col form-group\">\r\n            <label for=\"lastName\">LastName</label>\r\n            <input type=\"text\" formControlName=\"ownerLastName\" class=\"form-control form-control-sm\" (blur)=onBlurStringFormControl($event)/>\r\n        </div>\r\n        <div class=\"col form-group\">\r\n            <label for=\"email\">Email</label>\r\n            <input type=\"text\" formControlName=\"ownerEmail\" class=\"form-control form-control-sm\" (blur)=onBlurLowcaseStringFormControl($event)/>\r\n        </div>\r\n      </div>\r\n      <div *ngIf=\"storesOfSelectedOwner.length > 0\" class=\"row\">\r\n        <div class=\"col-5\">\r\n          <table class=\"table table-striped table-bordered table-sm\">\r\n            <thead>\r\n              <tr>\r\n                <th>#</th>\r\n                <th>Id</th>\r\n                <th>Name</th>\r\n                <th>Email</th>\r\n                <th>Phone</th>\r\n              </tr>\r\n            </thead>\r\n            <tbody>\r\n              <tr *ngFor=\"let store of storesOfSelectedOwner; let i = index\">\r\n                <td>{{ i + 1 }}</td>\r\n                <td>{{ store.id }}</td>\r\n                <td>{{ store.name }}</td>\r\n                <td>{{ store.email }}</td>\r\n                <td>{{ store.phone }}</td>\r\n              </tr>\r\n            </tbody>\r\n          </table>\r\n        </div>\r\n      </div>\r\n      <h5>Store</h5>\r\n      <hr>\r\n      <div class=\"row\">\r\n          <div class=\"col form-group\">\r\n              <label for=\"name\">Name</label>\r\n              <input type=\"text\" formControlName=\"storeName\" class=\"form-control form-control-sm\" (blur)=onBlurStringFormControl($event)/>\r\n          </div>\r\n          <div class=\"col form-group\">\r\n            <label for=\"streetNumber\">Street Number</label>\r\n            <input type=\"text\" formControlName=\"storeStreetNumber\" class=\"form-control form-control-sm\"/>\r\n          </div>\r\n          <div class=\"col form-group\">\r\n              <label for=\"streetName\">Street</label>\r\n              <input type=\"text\" formControlName=\"storeStreetName\" class=\"form-control form-control-sm\"/>\r\n          </div>\r\n          <div class=\"col form-group\">\r\n              <label for=\"zipCode\">Zip Code</label>\r\n              <input type=\"text\" formControlName=\"storeZipCode\" class=\"form-control form-control-sm\"/>\r\n          </div>\r\n          <div class=\"col form-group\">\r\n              <label for=\"city\">City</label>\r\n              <input type=\"text\" formControlName=\"storeCity\" class=\"form-control form-control-sm\" (blur)=onBlurStringFormControl($event)/>\r\n          </div>\r\n          <div class=\"col form-group\">\r\n            <label for=\"country\">Country</label>\r\n            <input type=\"text\" formControlName=\"storeCountry\" class=\"form-control form-control-sm\" (blur)=onBlurStringFormControl($event)/>\r\n        </div>\r\n      </div>\r\n      <div class=\"row\">\r\n          <div class=\"col form-group\">\r\n              <label for=\"phone\">Phone</label>\r\n              <input type=\"text\" formControlName=\"storePhone\" class=\"form-control form-control-sm\"/>\r\n          </div>\r\n          <div class=\"col form-group\">\r\n              <label for=\"email\">Email</label>\r\n              <input type=\"text\" formControlName=\"storeEmail\" class=\"form-control form-control-sm\" (blur)=onBlurLowcaseStringFormControl($event)>\r\n          </div>\r\n      </div>\r\n      <div class=\"row\">\r\n        <div class=\"col\">\r\n          <button class=\"btn btn-primary\">Save</button>\r\n        </div>\r\n        <div class=\"col-md-auto\">\r\n          <ngb-alert *ngIf=\"errorMessage\" [type]=\"typeAlert\" [dismissible]=\"true\" (close)=\"errorMessage = null\">{{ errorMessage }}</ngb-alert>\r\n        </div>\r\n      </div>\r\n    </form>\r\n  </div>\r\n</div>"

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
/* harmony import */ var src_app_model_request_customer_AddOrUpdateCustomerReq__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! src/app/model/request/customer/AddOrUpdateCustomerReq */ "./src/app/model/request/customer/AddOrUpdateCustomerReq.ts");
/* harmony import */ var src_app_model_Store__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! src/app/model/Store */ "./src/app/model/Store.ts");
/* harmony import */ var src_app_common_components_modal_builder__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! src/app/common-components/modal-builder */ "./src/app/common-components/modal-builder.ts");
/* harmony import */ var src_app_modal_info_modal_info_modal_component__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! src/app/modal/info-modal/info-modal.component */ "./src/app/modal/info-modal/info-modal.component.ts");
/* harmony import */ var src_app_util_StringUtil__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! src/app/util/StringUtil */ "./src/app/util/StringUtil.ts");
/* harmony import */ var src_app_model_Customer__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! src/app/model/Customer */ "./src/app/model/Customer.ts");
/* harmony import */ var src_app_model_Address__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! src/app/model/Address */ "./src/app/model/Address.ts");













var NewCustomerComponent = /** @class */ (function () {
    function NewCustomerComponent(formBuilder, modalBuilder, customerService) {
        var _this = this;
        this.formBuilder = formBuilder;
        this.modalBuilder = modalBuilder;
        this.customerService = customerService;
        this.onUpdateCustomerEvent = new _angular_core__WEBPACK_IMPORTED_MODULE_1__["EventEmitter"]();
        this.ownerNames = [];
        this.storesOfSelectedOwner = [];
        this.typeAlert = 'success';
        this._error = new rxjs__WEBPACK_IMPORTED_MODULE_4__["Subject"]();
        this.search = function (text$) {
            return text$.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_5__["debounceTime"])(200), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_5__["distinctUntilChanged"])(), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_5__["map"])(function (term) { return term.length < 1 ? []
                : _this.ownerNames.filter(function (v) { return v.toLowerCase().indexOf(term.toLowerCase()) > -1; }).slice(0, 10); }));
        };
        this.ownerIdMapByName = new Map();
        this.initForm();
        this._error.subscribe(function (msg) { return _this.errorMessage = msg; });
        this._error.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_5__["debounceTime"])(4000)).subscribe(function () { return _this.errorMessage = null; });
    }
    NewCustomerComponent.prototype.ngOnInit = function () {
    };
    NewCustomerComponent.prototype.ngOnChanges = function (changes) {
        if (this.customer != null) {
            this.fillForm();
        }
    };
    NewCustomerComponent.prototype.initForm = function () {
        this.loadOwners();
        this.form = this.formBuilder.group({
            ownerAutoComplete: '',
            ownerFirstName: '',
            ownerLastName: '',
            ownerEmail: ['', _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].email],
            storeName: ['', _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required],
            storeStreetNumber: '',
            storeStreetName: '',
            storeZipCode: '',
            storeCity: '',
            storeCountry: '',
            storePhone: '',
            storeEmail: ['', _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].email]
        });
        if (this.customer != null) {
            this.fillForm();
        }
    };
    NewCustomerComponent.prototype.fillForm = function () {
        var store = this.customer.store;
        this.form.setValue({
            ownerAutoComplete: this.getStringValue(store.owner.compagnyName),
            ownerFirstName: this.getStringValue(store.owner.firstName),
            ownerLastName: this.getStringValue(store.owner.lastName),
            ownerEmail: this.getStringValue(store.owner.email),
            storeName: this.getStringValue(store.name),
            storeStreetNumber: this.getStringValue(store.address.streetNumber),
            storeStreetName: this.getStringValue(store.address.streetName),
            storeZipCode: this.getNumericValue(store.address.zipCode),
            storeCity: this.getStringValue(store.address.city),
            storeCountry: this.getStringValue(store.address.country),
            storePhone: this.getStringValue(store.phone),
            storeEmail: this.getStringValue(store.email)
        });
    };
    NewCustomerComponent.prototype.getStringValue = function (value) {
        return value.length > 0 || value == 'null' ? value : "";
    };
    NewCustomerComponent.prototype.getNumericValue = function (value) {
        return value <= 0 ? "" : value.toString();
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
    NewCustomerComponent.prototype.changeAlertMessage = function (type, errorMessage) {
        this.typeAlert = type;
        this._error.next(errorMessage);
    };
    NewCustomerComponent.prototype.onSubmit = function () {
        var controls = this.form.controls;
        if (this.form.valid) {
            var ownerId = this.ownerIdMapByName.get(controls.ownerAutoComplete.value);
            var req = new src_app_model_request_customer_AddOrUpdateCustomerReq__WEBPACK_IMPORTED_MODULE_6__["AddOrUpdateCustomerReq"](ownerId, controls.storeName.value);
            if (this.customer != null) {
                req.customerId = this.customer.id;
            }
            req.ownerCompagnyName = controls.ownerAutoComplete.value;
            req.ownerFirstName = controls.ownerFirstName.value;
            req.ownerLastName = controls.ownerLastName.value;
            req.ownerEmail = controls.ownerEmail.value;
            req.storeName = controls.storeName.value;
            req.storeEmail = controls.storeEmail.value;
            req.storePhone = controls.storePhone.value;
            req.storeAddress = new src_app_model_Address__WEBPACK_IMPORTED_MODULE_12__["Address"](controls.storeStreetNumber.value, controls.storeStreetName.value, controls.storeZipCode.value, controls.storeCity.value, controls.storeCountry.value);
            this.sendCustomerRequest(req, this.customer != null);
        }
        else {
            this.changeAlertMessage("danger", "Form not valid.");
        }
    };
    NewCustomerComponent.prototype.sendCustomerRequest = function (req, isUpdateRequest) {
        var _this = this;
        var observable = isUpdateRequest ? this.customerService.updateCustomer(req) : this.customerService.addCustomer(req);
        observable.subscribe(function (data) {
            _this.changeAlertMessage("success", "Customer successfully saved");
            _this.onUpdateCustomerEvent.emit(_this.customer.id);
        }, function (error) {
            _this.changeAlertMessage("danger", error.error);
        });
    };
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", src_app_model_Customer__WEBPACK_IMPORTED_MODULE_11__["Customer"])
    ], NewCustomerComponent.prototype, "customer", void 0);
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Output"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", Object)
    ], NewCustomerComponent.prototype, "onUpdateCustomerEvent", void 0);
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

/***/ "./src/app/customer/store/open-closed-orders-counter/open-closed-orders-counter.component.css":
/*!****************************************************************************************************!*\
  !*** ./src/app/customer/store/open-closed-orders-counter/open-closed-orders-counter.component.css ***!
  \****************************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".center {\r\n    display: block;\r\n    margin-left: auto;\r\n    margin-right: auto;\r\n}\r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvY3VzdG9tZXIvc3RvcmUvb3Blbi1jbG9zZWQtb3JkZXJzLWNvdW50ZXIvb3Blbi1jbG9zZWQtb3JkZXJzLWNvdW50ZXIuY29tcG9uZW50LmNzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQTtJQUNJLGNBQWM7SUFDZCxpQkFBaUI7SUFDakIsa0JBQWtCO0FBQ3RCIiwiZmlsZSI6InNyYy9hcHAvY3VzdG9tZXIvc3RvcmUvb3Blbi1jbG9zZWQtb3JkZXJzLWNvdW50ZXIvb3Blbi1jbG9zZWQtb3JkZXJzLWNvdW50ZXIuY29tcG9uZW50LmNzcyIsInNvdXJjZXNDb250ZW50IjpbIi5jZW50ZXIge1xyXG4gICAgZGlzcGxheTogYmxvY2s7XHJcbiAgICBtYXJnaW4tbGVmdDogYXV0bztcclxuICAgIG1hcmdpbi1yaWdodDogYXV0bztcclxufSJdfQ== */"

/***/ }),

/***/ "./src/app/customer/store/open-closed-orders-counter/open-closed-orders-counter.component.html":
/*!*****************************************************************************************************!*\
  !*** ./src/app/customer/store/open-closed-orders-counter/open-closed-orders-counter.component.html ***!
  \*****************************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"card shadow-sm p-3 mb-5 bg-white rounded\">\n  <div class=\"card-header\">\n      <h5>Closed Orders (%)</h5>\n  </div>\n  <div class=\"card-body\">\n    <div *ngIf=\"counters\">\n        <ngb-progressbar [showValue]=\"false\" type=\"info\" [value]=\"counters.calculatePercentOfClosedOrders()\"><b>{{ counters.closedOrdersCount }} of {{ counters.totalOrders() }} ({{ counters.calculatePercentOfClosedOrders() }}%)</b></ngb-progressbar>\n    </div>\n    <img *ngIf=\"! counters\" class=\"center\" src=\"../../../../assets/icon/LoadingGrey.gif\">\n  </div>\n</div>"

/***/ }),

/***/ "./src/app/customer/store/open-closed-orders-counter/open-closed-orders-counter.component.ts":
/*!***************************************************************************************************!*\
  !*** ./src/app/customer/store/open-closed-orders-counter/open-closed-orders-counter.component.ts ***!
  \***************************************************************************************************/
/*! exports provided: OpenClosedOrdersCounterComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "OpenClosedOrdersCounterComponent", function() { return OpenClosedOrdersCounterComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _service_orders_statistic_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../../service/orders-statistic-service */ "./src/app/service/orders-statistic-service.ts");
/* harmony import */ var _model_statistic_OpenClosedOrdersCounter__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../../model/statistic/OpenClosedOrdersCounter */ "./src/app/model/statistic/OpenClosedOrdersCounter.ts");




var OpenClosedOrdersCounterComponent = /** @class */ (function () {
    function OpenClosedOrdersCounterComponent(ordersStatisticService) {
        this.ordersStatisticService = ordersStatisticService;
    }
    OpenClosedOrdersCounterComponent.prototype.ngOnChanges = function () {
        var _this = this;
        if (this.storeId != null) {
            this.ordersStatisticService.getOpenClosedOrdersOfStore(this.storeId).subscribe(function (data) {
                _this.counters = _model_statistic_OpenClosedOrdersCounter__WEBPACK_IMPORTED_MODULE_3__["OpenClosedOrdersCounter"].fromJson(data);
            }, function (error) {
                alert(JSON.stringify(error));
            });
        }
    };
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", Number)
    ], OpenClosedOrdersCounterComponent.prototype, "storeId", void 0);
    OpenClosedOrdersCounterComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'open-closed-orders-counter',
            template: __webpack_require__(/*! ./open-closed-orders-counter.component.html */ "./src/app/customer/store/open-closed-orders-counter/open-closed-orders-counter.component.html"),
            styles: [__webpack_require__(/*! ./open-closed-orders-counter.component.css */ "./src/app/customer/store/open-closed-orders-counter/open-closed-orders-counter.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_service_orders_statistic_service__WEBPACK_IMPORTED_MODULE_2__["OrdersStatisticService"]])
    ], OpenClosedOrdersCounterComponent);
    return OpenClosedOrdersCounterComponent;
}());



/***/ }),

/***/ "./src/app/customer/store/store-dashboard/store-dashboard.component.css":
/*!******************************************************************************!*\
  !*** ./src/app/customer/store/store-dashboard/store-dashboard.component.css ***!
  \******************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL2N1c3RvbWVyL3N0b3JlL3N0b3JlLWRhc2hib2FyZC9zdG9yZS1kYXNoYm9hcmQuY29tcG9uZW50LmNzcyJ9 */"

/***/ }),

/***/ "./src/app/customer/store/store-dashboard/store-dashboard.component.html":
/*!*******************************************************************************!*\
  !*** ./src/app/customer/store/store-dashboard/store-dashboard.component.html ***!
  \*******************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container-fluid\">\n  <div class=\"row\">\n    <div class=\"col\">\n      <store-info [storeId]=\"storeId\"></store-info>\n    </div>\n  </div>\n  <div class=\"row\">\n    <div class=\"col\">\n      <store-orders [storeId]=\"storeId\"></store-orders>\n    </div>\n    <div class=\"col\">\n      <open-closed-orders-counter [storeId]=\"storeId\"></open-closed-orders-counter>\n    </div>\n  </div>\n</div>"

/***/ }),

/***/ "./src/app/customer/store/store-dashboard/store-dashboard.component.ts":
/*!*****************************************************************************!*\
  !*** ./src/app/customer/store/store-dashboard/store-dashboard.component.ts ***!
  \*****************************************************************************/
/*! exports provided: StoreDashboardComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "StoreDashboardComponent", function() { return StoreDashboardComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");



var StoreDashboardComponent = /** @class */ (function () {
    function StoreDashboardComponent(route) {
        this.route = route;
    }
    StoreDashboardComponent.prototype.ngOnInit = function () {
        this.storeId = parseInt(this.route.snapshot.paramMap.get('id'));
    };
    StoreDashboardComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-store-dashboard',
            template: __webpack_require__(/*! ./store-dashboard.component.html */ "./src/app/customer/store/store-dashboard/store-dashboard.component.html"),
            styles: [__webpack_require__(/*! ./store-dashboard.component.css */ "./src/app/customer/store/store-dashboard/store-dashboard.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_angular_router__WEBPACK_IMPORTED_MODULE_2__["ActivatedRoute"]])
    ], StoreDashboardComponent);
    return StoreDashboardComponent;
}());



/***/ }),

/***/ "./src/app/customer/store/store-info/store-info.component.css":
/*!********************************************************************!*\
  !*** ./src/app/customer/store/store-info/store-info.component.css ***!
  \********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".center {\r\n    display: block;\r\n    margin-left: auto;\r\n    margin-right: auto;\r\n}\r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvY3VzdG9tZXIvc3RvcmUvc3RvcmUtaW5mby9zdG9yZS1pbmZvLmNvbXBvbmVudC5jc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUE7SUFDSSxjQUFjO0lBQ2QsaUJBQWlCO0lBQ2pCLGtCQUFrQjtBQUN0QiIsImZpbGUiOiJzcmMvYXBwL2N1c3RvbWVyL3N0b3JlL3N0b3JlLWluZm8vc3RvcmUtaW5mby5jb21wb25lbnQuY3NzIiwic291cmNlc0NvbnRlbnQiOlsiLmNlbnRlciB7XHJcbiAgICBkaXNwbGF5OiBibG9jaztcclxuICAgIG1hcmdpbi1sZWZ0OiBhdXRvO1xyXG4gICAgbWFyZ2luLXJpZ2h0OiBhdXRvO1xyXG59Il19 */"

/***/ }),

/***/ "./src/app/customer/store/store-info/store-info.component.html":
/*!*********************************************************************!*\
  !*** ./src/app/customer/store/store-info/store-info.component.html ***!
  \*********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"card w-100 shadow-sm p-3 mb-5 bg-white rounded\">\n    <div class=\"card-header\">\n      <h5>Store</h5>\n    </div>\n    <div class=\"card-body\">\n      <div class=\"row\">\n        <div class=\"col\">\n          <div *ngIf=\"store\" class=\"table-responsive\">\n            <table class=\"table table-striped table-hover table-sm\">\n              <thead>\n                <tr>\n                  <th>ID</th>\n                  <th>Name</th>\n                  <th>Owner</th>\n                  <th>Address</th>\n                  <th>Phone</th>\n                  <th>Email</th>\n                </tr>\n              </thead>\n              <tbody>\n                <tr *ngIf=\"store\">\n                  <td>{{ store.id }}</td>\n                  <td>{{ store.name }}</td>\n                  <td>{{ store.owner.getFullName() }}</td>\n                  <td>{{ store.address.format() }}</td>\n                  <td>{{ store.phone }}</td>\n                  <td>{{ store.email }}</td>\n                </tr>\n              </tbody>\n            </table>\n          </div>\n          <img *ngIf=\"! store\" class=\"center\" src=\"../../../../assets/icon/LoadingGrey.gif\">\n        </div>\n      </div>\n    </div>  \n  </div>"

/***/ }),

/***/ "./src/app/customer/store/store-info/store-info.component.ts":
/*!*******************************************************************!*\
  !*** ./src/app/customer/store/store-info/store-info.component.ts ***!
  \*******************************************************************/
/*! exports provided: StoreInfoComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "StoreInfoComponent", function() { return StoreInfoComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _model_Store__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../../model/Store */ "./src/app/model/Store.ts");
/* harmony import */ var _service_store_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../../service/store-service */ "./src/app/service/store-service.ts");




var StoreInfoComponent = /** @class */ (function () {
    function StoreInfoComponent(storeService) {
        this.storeService = storeService;
    }
    StoreInfoComponent.prototype.ngOnChanges = function () {
        var _this = this;
        if (this.storeId != null) {
            this.storeService.get(this.storeId).subscribe(function (data) {
                _this.store = _model_Store__WEBPACK_IMPORTED_MODULE_2__["Store"].fromJson(data);
            });
        }
    };
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", Number)
    ], StoreInfoComponent.prototype, "storeId", void 0);
    StoreInfoComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'store-info',
            template: __webpack_require__(/*! ./store-info.component.html */ "./src/app/customer/store/store-info/store-info.component.html"),
            styles: [__webpack_require__(/*! ./store-info.component.css */ "./src/app/customer/store/store-info/store-info.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_service_store_service__WEBPACK_IMPORTED_MODULE_3__["StoreService"]])
    ], StoreInfoComponent);
    return StoreInfoComponent;
}());



/***/ }),

/***/ "./src/app/customer/store/store-orders/store-orders.component.css":
/*!************************************************************************!*\
  !*** ./src/app/customer/store/store-orders/store-orders.component.css ***!
  \************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "/* Scroll Bar Aggregated Order Item table */\r\n.my-custom-scrollbar {\r\n    position: relative;\r\n    max-height: 300px;\r\n    overflow: auto;\r\n  }\r\n.table-wrapper-scroll-y {\r\n  display: block;\r\n}\r\n.center {\r\n  display: block;\r\n  margin-left: auto;\r\n  margin-right: auto;\r\n}\r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvY3VzdG9tZXIvc3RvcmUvc3RvcmUtb3JkZXJzL3N0b3JlLW9yZGVycy5jb21wb25lbnQuY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBLDJDQUEyQztBQUMzQztJQUNJLGtCQUFrQjtJQUNsQixpQkFBaUI7SUFDakIsY0FBYztFQUNoQjtBQUVGO0VBQ0UsY0FBYztBQUNoQjtBQUVBO0VBQ0UsY0FBYztFQUNkLGlCQUFpQjtFQUNqQixrQkFBa0I7QUFDcEIiLCJmaWxlIjoic3JjL2FwcC9jdXN0b21lci9zdG9yZS9zdG9yZS1vcmRlcnMvc3RvcmUtb3JkZXJzLmNvbXBvbmVudC5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyIvKiBTY3JvbGwgQmFyIEFnZ3JlZ2F0ZWQgT3JkZXIgSXRlbSB0YWJsZSAqL1xyXG4ubXktY3VzdG9tLXNjcm9sbGJhciB7XHJcbiAgICBwb3NpdGlvbjogcmVsYXRpdmU7XHJcbiAgICBtYXgtaGVpZ2h0OiAzMDBweDtcclxuICAgIG92ZXJmbG93OiBhdXRvO1xyXG4gIH1cclxuICBcclxuLnRhYmxlLXdyYXBwZXItc2Nyb2xsLXkge1xyXG4gIGRpc3BsYXk6IGJsb2NrO1xyXG59XHJcblxyXG4uY2VudGVyIHtcclxuICBkaXNwbGF5OiBibG9jaztcclxuICBtYXJnaW4tbGVmdDogYXV0bztcclxuICBtYXJnaW4tcmlnaHQ6IGF1dG87XHJcbn0iXX0= */"

/***/ }),

/***/ "./src/app/customer/store/store-orders/store-orders.component.html":
/*!*************************************************************************!*\
  !*** ./src/app/customer/store/store-orders/store-orders.component.html ***!
  \*************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"card shadow-sm p-3 mb-5 bg-white rounded\">\r\n    <div class=\"card-header\">\r\n        <h5>Orders ({{ orders.length }})</h5>\r\n    </div>\r\n    <div class=\"card-body\">\r\n        <div *ngIf=\"orders\" class=\"table-responsive table-wrapper-scroll-y my-custom-scrollbar\">\r\n            <table class=\"table table-striped table-bordered table-sm\">\r\n                <thead>\r\n                    <tr>\r\n                        <th>ID</th>\r\n                        <th>Name</th>\r\n                        <th>Status</th>\r\n                        <th>Products</th>\r\n                        <th>Qty</th>\r\n                        <th>Amount</th>\r\n                        <th>Creation</th>\r\n                        <th>Closed</th>\r\n                        <th></th>\r\n                    </tr>\r\n                </thead>\r\n                <tbody>\r\n                    <tr *ngFor=\"let order of orders\">\r\n                        <td>{{ order.id }}</td>\r\n                        <td>{{ order.name }}</td>\r\n                        <td [ngClass]=\"order.status === 'OPEN' ? 'table-success' : 'table-danger'\">{{ order.status }}</td>\r\n                        <td>{{ order.aggregatedOrderInfo.productSize }}</td>\r\n                        <td>{{ order.aggregatedOrderInfo.orderItemSize }}</td>\r\n                        <td>{{ order.aggregatedOrderInfo.totalPrice }} €</td>\r\n                        <td>{{ order.createdDatetime  | date:'shortDate' }}</td>\r\n                        <td>{{ order.closeDatetime  | date:'shortDate' }}</td>\r\n                        <td>\r\n                            <button\r\n                                class=\"btn btn-success btn-sm\"\r\n                                [routerLink]=\"['/order', order.id]\"\r\n                            >See</button>\r\n                        </td>\r\n                    </tr>\r\n                </tbody>\r\n            </table>\r\n        </div>\r\n        <img *ngIf=\"! orders\" class=\"center\" src=\"../../../../assets/icon/LoadingGrey.gif\">\r\n    </div>\r\n</div>\r\n"

/***/ }),

/***/ "./src/app/customer/store/store-orders/store-orders.component.ts":
/*!***********************************************************************!*\
  !*** ./src/app/customer/store/store-orders/store-orders.component.ts ***!
  \***********************************************************************/
/*! exports provided: StoreOrdersComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "StoreOrdersComponent", function() { return StoreOrdersComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _service_order_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../../service/order-service */ "./src/app/service/order-service.ts");
/* harmony import */ var _model_AggregatedOrder__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../../model/AggregatedOrder */ "./src/app/model/AggregatedOrder.ts");




var StoreOrdersComponent = /** @class */ (function () {
    function StoreOrdersComponent(orderService) {
        this.orderService = orderService;
    }
    StoreOrdersComponent.prototype.ngOnChanges = function () {
        this.loadOrders();
    };
    StoreOrdersComponent.prototype.loadOrders = function () {
        var _this = this;
        if (this.storeId != null) {
            this.orderService.getOrdersOfStore(this.storeId).subscribe(function (data) {
                var arr = [];
                for (var _i = 0, data_1 = data; _i < data_1.length; _i++) {
                    var order = data_1[_i];
                    arr.push(_model_AggregatedOrder__WEBPACK_IMPORTED_MODULE_3__["AggregatedOrder"].fromJson(order));
                }
                _this.orders = arr;
            });
        }
    };
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", Number)
    ], StoreOrdersComponent.prototype, "storeId", void 0);
    StoreOrdersComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'store-orders',
            template: __webpack_require__(/*! ./store-orders.component.html */ "./src/app/customer/store/store-orders/store-orders.component.html"),
            styles: [__webpack_require__(/*! ./store-orders.component.css */ "./src/app/customer/store/store-orders/store-orders.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_service_order_service__WEBPACK_IMPORTED_MODULE_2__["OrderService"]])
    ], StoreOrdersComponent);
    return StoreOrdersComponent;
}());



/***/ }),

/***/ "./src/app/http-interceptor/HttpToHttpsInterceptor.ts":
/*!************************************************************!*\
  !*** ./src/app/http-interceptor/HttpToHttpsInterceptor.ts ***!
  \************************************************************/
/*! exports provided: HttpToHttpsInterceptor */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "HttpToHttpsInterceptor", function() { return HttpToHttpsInterceptor; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");


var HttpToHttpsInterceptor = /** @class */ (function () {
    function HttpToHttpsInterceptor() {
    }
    HttpToHttpsInterceptor.prototype.intercept = function (req, next) {
        var secureReq = req.clone({
            url: req.url.replace('http://', 'https://')
        });
        return next.handle(secureReq);
    };
    HttpToHttpsInterceptor = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])()
    ], HttpToHttpsInterceptor);
    return HttpToHttpsInterceptor;
}());



/***/ }),

/***/ "./src/app/http-interceptor/Interceptors-manager.ts":
/*!**********************************************************!*\
  !*** ./src/app/http-interceptor/Interceptors-manager.ts ***!
  \**********************************************************/
/*! exports provided: httpInterceptorProviders */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "httpInterceptorProviders", function() { return httpInterceptorProviders; });
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var _SessionTimeoutHttpInterceptor__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./SessionTimeoutHttpInterceptor */ "./src/app/http-interceptor/SessionTimeoutHttpInterceptor.ts");
/* harmony import */ var _HttpToHttpsInterceptor__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./HttpToHttpsInterceptor */ "./src/app/http-interceptor/HttpToHttpsInterceptor.ts");



var httpInterceptorProviders = [
    { provide: _angular_common_http__WEBPACK_IMPORTED_MODULE_0__["HTTP_INTERCEPTORS"], useClass: _SessionTimeoutHttpInterceptor__WEBPACK_IMPORTED_MODULE_1__["SessionTimeoutHttpInterceptor"], multi: true },
    { provide: _angular_common_http__WEBPACK_IMPORTED_MODULE_0__["HTTP_INTERCEPTORS"], useClass: _HttpToHttpsInterceptor__WEBPACK_IMPORTED_MODULE_2__["HttpToHttpsInterceptor"], multi: true }
];


/***/ }),

/***/ "./src/app/http-interceptor/SessionTimeoutHttpInterceptor.ts":
/*!*******************************************************************!*\
  !*** ./src/app/http-interceptor/SessionTimeoutHttpInterceptor.ts ***!
  \*******************************************************************/
/*! exports provided: SessionTimeoutHttpInterceptor */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "SessionTimeoutHttpInterceptor", function() { return SessionTimeoutHttpInterceptor; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
/* harmony import */ var _common_components_modal_builder__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../common-components/modal-builder */ "./src/app/common-components/modal-builder.ts");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _modal_info_modal_info_modal_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../modal/info-modal/info-modal.component */ "./src/app/modal/info-modal/info-modal.component.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");








var SessionTimeoutHttpInterceptor = /** @class */ (function () {
    function SessionTimeoutHttpInterceptor(modalBuilder, router) {
        this.modalBuilder = modalBuilder;
        this.router = router;
    }
    SessionTimeoutHttpInterceptor.prototype.intercept = function (req, next) {
        var _this = this;
        return next.handle(req).pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_4__["catchError"])(function (err) {
            return new rxjs__WEBPACK_IMPORTED_MODULE_2__["Observable"](function (observer) {
                if (err instanceof _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpErrorResponse"]) {
                    var errResp = err;
                    if (errResp.status === 401 || err.status === 403) {
                        _this.showModalLogoutMsg(errResp.status);
                    }
                }
                observer.error(err);
                observer.complete();
            });
        }));
    };
    SessionTimeoutHttpInterceptor.prototype.showModalLogoutMsg = function (errorStatus) {
        var _this = this;
        var modalRef = this.modalBuilder.openCenteredLargeModal(_modal_info_modal_info_modal_component__WEBPACK_IMPORTED_MODULE_6__["InfoModalComponent"]);
        modalRef.componentInstance.title = "Error " + errorStatus;
        modalRef.componentInstance.message = 'Session expired. You are going to be redirected to loggin again';
        modalRef.result.then(function (response) {
            _this.router.navigateByUrl("/");
        });
    };
    SessionTimeoutHttpInterceptor = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_5__["Injectable"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_common_components_modal_builder__WEBPACK_IMPORTED_MODULE_3__["ModalBuilder"], _angular_router__WEBPACK_IMPORTED_MODULE_7__["Router"]])
    ], SessionTimeoutHttpInterceptor);
    return SessionTimeoutHttpInterceptor;
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

module.exports = "<div class=\"modal-header\">\r\n    <h5 class=\"modal-title\" id=\"modal-basic-title\">Add order items</h5>\r\n    <button type=\"button\" class=\"close\" aria-label=\"Close\" (click)=\"onClose()\">\r\n      <span aria-hidden=\"true\">&times;</span>\r\n    </button>\r\n</div>\r\n<div class=\"modal-body\">\r\n  <form [formGroup]=\"addOrderItemForm\">\r\n    <div class=\"custom-control custom-switch\" style=\"float: right\">\r\n      <input type=\"checkbox\" class=\"custom-control-input\" id=\"customSwitch1\" (click)=\"shouldEnableBarCodeMode($event)\" [(ngModel)]=\"barCodeMode\" [ngModelOptions]=\"{standalone: true}\">\r\n      <label class=\"custom-control-label\" for=\"customSwitch1\">Barcode Mode</label>\r\n    </div>\r\n    <div *ngIf=\"barCodeMode\">\r\n      <div class=\"form-group\">\r\n          <label for=\"barCode\">BarCode</label>\r\n          <input type=\"text\" formControlName=\"barCode\"\r\n            (change)=\"onValueChange()\"\r\n            (blur)=\"onBlurBarCode()\"\r\n            class=\"form-control\"/>\r\n      </div>\r\n    </div>\r\n    <div *ngIf=\"! barCodeMode\">\r\n      <div class=\"form-group\">\r\n        <label for=\"Name\">Product Name</label>\r\n        <input type=\"text\" formControlName=\"productName\"\r\n          [(ngModel)]=\"inputProductName\"\r\n          [ngbTypeahead]=\"search\"\r\n          (change)=\"onProductNameChange()\"\r\n          (blur)=\"onBlurProductName()\"\r\n          class=\"form-control\"/>\r\n      </div>\r\n      <div class=\"form-group\">\r\n        <label for=\"quantity\">Quantity</label>\r\n        <input type=\"number\" formControlName=\"quantity\"\r\n          (change)=\"onValueChange()\"\r\n          class=\"form-control\"/>\r\n      </div>\r\n    </div>\r\n    <div *ngIf=\"productStockInfo\">\r\n      <table class=\"table table-striped\">\r\n        <thead>\r\n          <tr>\r\n            <th>Id</th>\r\n            <th>Name</th>\r\n            <th>Initial Qty</th>\r\n            <th>Free Qty</th>\r\n          </tr>\r\n        </thead>\r\n        <tbody>\r\n          <tr>\r\n            <td>{{ productStockInfo.product.id }}</td>\r\n            <td>{{ productStockInfo.product.name }}</td>\r\n            <td>{{ productStockInfo.createdQuantity }}</td>\r\n            <td>{{ productStockInfo.createdQuantity - productStockInfo.usedQuantity }}</td>\r\n          </tr>\r\n        </tbody>\r\n      </table>\r\n    </div>\r\n    <div *ngIf=\"productItem\">\r\n      <table class=\"table table-striped\">\r\n        <thead>\r\n          <tr>\r\n            <th>Id</th>\r\n            <th>Name</th>\r\n            <th>Free</th>\r\n          </tr>\r\n        </thead>\r\n        <tbody>\r\n          <tr>\r\n            <td>{{ productItem.id }}</td>\r\n            <td>{{ productItem.product.name }}</td>\r\n            <td>{{ productItem.orderItemId ? 'No' : 'Yes' }}</td>\r\n          </tr>\r\n        </tbody>\r\n      </table>\r\n    </div>\r\n  </form>\r\n</div>\r\n<div class=\"modal-footer\">\r\n  <div class=\"container\">\r\n    <div class=\"row\">\r\n        <div class=\"col\">\r\n          <button class=\"btn btn-outline-dark\" type=\"button\" [disabled]=\"isAddButtonDisabled\" (click)=\"onSubmit(true)\" style=\"float:left\">\r\n              <span *ngIf=\"addOrderItemInProgress\" class=\"spinner-border spinner-border-sm\" role=\"status\" aria-hidden=\"true\"></span>\r\n            Add Another</button>\r\n        </div>\r\n        <div class=\"col-md-auto\">\r\n            <ngb-alert *ngIf=\"errorMessage\" type=\"danger\" [dismissible]=\"true\" (close)=\"errorMessage = null\">{{ errorMessage }}</ngb-alert>\r\n        </div>\r\n        <div class=\"col\">\r\n          <button class=\"btn btn-outline-dark\" type=\"button\" [disabled]=\"isAddButtonDisabled\" (click)=\"onSubmit(false)\" style=\"float:right\">\r\n              <span *ngIf=\"addOrderItemInProgress\" class=\"spinner-border spinner-border-sm\" role=\"status\" aria-hidden=\"true\"></span>\r\n            Add</button>\r\n        </div>\r\n    </div>\r\n  </div>\r\n</div>"

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
        this.addOrderItemEvent = new _angular_core__WEBPACK_IMPORTED_MODULE_1__["EventEmitter"]();
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
    AddOrderItemModalComponent.prototype.onSubmit = function (addAnother) {
        if (this.barCodeMode) {
            this.onSubmitBarCodeMode(addAnother);
        }
        else {
            this.onSubmitNoBarCodeMode(addAnother);
        }
    };
    AddOrderItemModalComponent.prototype.onSubmitBarCodeMode = function (addAnother) {
        var _this = this;
        var barCode = this.addOrderItemForm.get("barCode").value;
        if (barCode == null || barCode.length == 0) {
            this.changeErrorMessage("Please enter a barcode.");
        }
        else {
            this.addInProgress(true);
            var request = new src_app_model_request_order_AddOrderItemByBarCodeReq__WEBPACK_IMPORTED_MODULE_11__["AddOrderItemByBarCodeReq"](this.orderId, barCode);
            this.orderService.addOrderItemByBarCode(request).subscribe(function (data) {
                _this.addOrderItemEvent.emit();
                if (addAnother) {
                    _this.resetModal();
                }
                else {
                    _this.modal.close(true);
                }
            }, function (error) {
                _this.changeErrorMessage(error.error);
                _this.addInProgress(false);
            });
            this.errorMessage = null;
        }
    };
    AddOrderItemModalComponent.prototype.onSubmitNoBarCodeMode = function (addAnother) {
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
                _this.addOrderItemEvent.emit();
                if (addAnother) {
                    _this.resetModal();
                }
                else {
                    _this.modal.close(true);
                }
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
    AddOrderItemModalComponent.prototype.resetModal = function () {
        this.addOrderItemForm.reset();
        this.addInProgress(false);
        this.productStockInfo = null;
    };
    AddOrderItemModalComponent.prototype.onClose = function () {
        this.modal.close(false);
    };
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Output"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", Object)
    ], AddOrderItemModalComponent.prototype, "addOrderItemEvent", void 0);
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

module.exports = "<div class=\"modal-header\">\r\n    <h4 class=\"modal-title\" id=\"modal-basic-title\">{{ title }}</h4>\r\n    <button type=\"button\" class=\"close\" aria-label=\"Close\" (click)=\"onClickClose()\">\r\n      <span aria-hidden=\"true\">&times;</span>\r\n    </button>\r\n</div>\r\n<div class=\"modal-body\">\r\n    <p>{{ message }}</p>\r\n</div>\r\n<div class=\"modal-footer\">\r\n  <button type=\"button\" class=\"btn btn-secondary\" (click)=\"onClickClose()\">No</button>\r\n  <button type=\"button\" class=\"btn btn-primary\" (click)=\"onClickYes()\">Yes</button>\r\n</div>\r\n"

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

module.exports = "<div class=\"modal-header\">\r\n  <h4 class=\"modal-title\" id=\"modal-basic-title\">New Order</h4>\r\n  <button type=\"button\" class=\"close\" aria-label=\"Close\" (click)=\"onClose()\">\r\n    <span aria-hidden=\"true\">&times;</span>\r\n  </button>\r\n</div>\r\n<form [formGroup]=\"createOrderForm\" (ngSubmit)=\"onSubmit()\">\r\n  <div class=\"modal-body\">\r\n      <div class=\"form-group\">\r\n        <label for=\"Name\">Name</label>\r\n        <input type=\"text\" formControlName=\"name\"\r\n          (input)=\"settingChanged()\"\r\n          class=\"form-control\"/>\r\n          <label *ngIf=\"isFormSubmitted && createOrderForm.get('name').invalid\" class=\"text-danger\">A name is required.</label>\r\n      </div>\r\n      <div class=\"form-group\">\r\n        <label for=\"comment\">Comment/Description</label>\r\n        <input type=\"text\" formControlName=\"comment\"\r\n          (input)=\"settingChanged()\"\r\n          class=\"form-control\"/>\r\n      </div>\r\n      <div class=\"form-group\">\r\n        <label for=\"customer\">Customer</label>\r\n        <select type=\"text\" formControlName=\"customers\"\r\n          (input)=\"settingChanged()\"\r\n          class=\"form-control\">\r\n          <option *ngFor=\"let customer of customersArray\"\r\n          [ngValue]=\"customer\">{{customer.id}} | {{ customer.store.name }} | {{ customer.store.owner.firstName }} {{ customer.store.owner.lastName }}</option>\r\n        </select>\r\n        <label *ngIf=\"isFormSubmitted && createOrderForm.get('customers').invalid\" class=\"text-danger\">A customer is required.</label>\r\n      </div>\r\n      <div>\r\n          <ngb-alert *ngIf=\"errorMessage\" type=\"danger\" [dismissible]=\"false\" (close)=\"errorMessage = null\">{{ errorMessage }}</ngb-alert>\r\n      </div>\r\n  </div>\r\n  <div class=\"modal-footer\">\r\n    <button type=\"submit\" class=\"btn btn-outline-dark\">Create</button>\r\n  </div>\r\n</form>"

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
        this.customerService.getAllCustomersNoLimit().subscribe(function (data) {
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

module.exports = ".my-custom-scrollbar {\r\n    position: relative;\r\n    max-height: 500px;\r\n    overflow: auto;\r\n}\r\n\r\n.table-wrapper-scroll-y {\r\n    display: block;\r\n}\r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvbW9kYWwvZGVsZXRlLW9yZGVyLWl0ZW1zLW1vZGFsL2RlbGV0ZS1vcmRlci1pdGVtcy1tb2RhbC5jb21wb25lbnQuY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBO0lBQ0ksa0JBQWtCO0lBQ2xCLGlCQUFpQjtJQUNqQixjQUFjO0FBQ2xCOztBQUVBO0lBQ0ksY0FBYztBQUNsQiIsImZpbGUiOiJzcmMvYXBwL21vZGFsL2RlbGV0ZS1vcmRlci1pdGVtcy1tb2RhbC9kZWxldGUtb3JkZXItaXRlbXMtbW9kYWwuY29tcG9uZW50LmNzcyIsInNvdXJjZXNDb250ZW50IjpbIi5teS1jdXN0b20tc2Nyb2xsYmFyIHtcclxuICAgIHBvc2l0aW9uOiByZWxhdGl2ZTtcclxuICAgIG1heC1oZWlnaHQ6IDUwMHB4O1xyXG4gICAgb3ZlcmZsb3c6IGF1dG87XHJcbn1cclxuXHJcbi50YWJsZS13cmFwcGVyLXNjcm9sbC15IHtcclxuICAgIGRpc3BsYXk6IGJsb2NrO1xyXG59Il19 */"

/***/ }),

/***/ "./src/app/modal/delete-order-items-modal/delete-order-items-modal.component.html":
/*!****************************************************************************************!*\
  !*** ./src/app/modal/delete-order-items-modal/delete-order-items-modal.component.html ***!
  \****************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"modal-header\">\r\n  <h4 class=\"modal-title\" id=\"modal-basic-title\">{{ title }}</h4>\r\n  <button type=\"button\" class=\"close\" aria-label=\"Close\" (click)=\"onClickClose()\">\r\n    <span aria-hidden=\"true\">&times;</span>\r\n  </button>\r\n</div>\r\n<div class=\"modal-body\">\r\n  <div class=\"table-wrapper-scroll-y my-custom-scrollbar\">\r\n    <table class=\"table table-striped\">\r\n      <thead>\r\n        <tr>\r\n          <th>#</th>\r\n          <th>Id</th>\r\n          <th>Product Name</th>\r\n          <th>BarCode</th>\r\n        </tr>\r\n      </thead>\r\n      <tbody>\r\n        <tr *ngFor=\"let item of orderItems; let i = index\">\r\n          <td>{{ i+1 }}</td>\r\n          <td>{{ item.productItem.id }}</td>\r\n          <td>{{ item.productItem.product.name }}</td>\r\n          <td>{{ item.productItem.barCode }}</td>\r\n        </tr>\r\n      </tbody>\r\n    </table>\r\n  </div>\r\n</div>\r\n<div class=\"modal-footer\">\r\n<button type=\"button\" class=\"btn btn-secondary\" (click)=\"onClickClose()\">No</button>\r\n<button type=\"button\" class=\"btn btn-primary\" (click)=\"onClickYes()\">Yes</button>\r\n</div>\r\n"

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

module.exports = "<div class=\"modal-header\">\r\n  <h4 class=\"modal-title\" id=\"modal-basic-title\">{{ title }}</h4>\r\n  <button type=\"button\" class=\"close\" aria-label=\"Close\" (click)=\"onClickClose()\">\r\n    <span aria-hidden=\"true\">&times;</span>\r\n  </button>\r\n</div>\r\n<div class=\"modal-body\">\r\n  <p>{{ message }}</p>\r\n</div>\r\n<div class=\"modal-footer\">\r\n  <button type=\"button\" class=\"btn btn-secondary\" (click)=\"onClickClose()\">OK</button>\r\n</div>\r\n"

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

/***/ "./src/app/modal/order-notification-modal/order-notification-modal.component.css":
/*!***************************************************************************************!*\
  !*** ./src/app/modal/order-notification-modal/order-notification-modal.component.css ***!
  \***************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".ng-invalid:not(form)  {\r\n    border-left: 5px solid #a94442; /* red */\r\n}\r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvbW9kYWwvb3JkZXItbm90aWZpY2F0aW9uLW1vZGFsL29yZGVyLW5vdGlmaWNhdGlvbi1tb2RhbC5jb21wb25lbnQuY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBO0lBQ0ksOEJBQThCLEVBQUUsUUFBUTtBQUM1QyIsImZpbGUiOiJzcmMvYXBwL21vZGFsL29yZGVyLW5vdGlmaWNhdGlvbi1tb2RhbC9vcmRlci1ub3RpZmljYXRpb24tbW9kYWwuY29tcG9uZW50LmNzcyIsInNvdXJjZXNDb250ZW50IjpbIi5uZy1pbnZhbGlkOm5vdChmb3JtKSAge1xyXG4gICAgYm9yZGVyLWxlZnQ6IDVweCBzb2xpZCAjYTk0NDQyOyAvKiByZWQgKi9cclxufSJdfQ== */"

/***/ }),

/***/ "./src/app/modal/order-notification-modal/order-notification-modal.component.html":
/*!****************************************************************************************!*\
  !*** ./src/app/modal/order-notification-modal/order-notification-modal.component.html ***!
  \****************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div>\r\n  <div class=\"modal-header\">\r\n    <h3 class=\"modal-title\" id=\"modal-basic-title\">Order Notification Setting</h3>\r\n    <button type=\"button\" class=\"close\" aria-label=\"Close\" (click)=\"onClose()\">\r\n      <span aria-hidden=\"true\">&times;</span>\r\n    </button>\r\n  </div>\r\n  <div class=\"modal-body\">\r\n    <form [formGroup]=\"form\">\r\n      <div class=\"form-group\">\r\n        <label for=\"notifType\">Notification Type</label>\r\n        <select formControlName=\"docTypesSelect\" class=\"custom-select\" (change)=\"onChangeType($event)\" required>\r\n            <option *ngFor=\"let type of docTypesMapByName.keys()\" [ngValue]=\"type\">{{ type }}</option>\r\n        </select>\r\n      </div>\r\n      <div class=\"form-group\" *ngIf=\"selectedType\">\r\n        <label for=\"formats\">Formats</label>\r\n        <div class=\"form-inline\">\r\n          <div formArrayName=\"formats\" *ngFor=\"let format of form.get('formats').controls; let i = index;\">\r\n            <label class=\"checkbox-inline\" style=\"margin-right:25px\" for=\"format\">{{ selectedType.supportedFormats[i] }}&nbsp;\r\n              <input formControlName=\"format\" type=\"checkbox\">\r\n            </label>\r\n          </div>\r\n        </div>\r\n      </div>\r\n      <div class=\"form-group\">\r\n        <label for=\"dateDocument\">Document's Date</label>\r\n        <div class=\"input-group\">\r\n          <input formControlName=\"dateDocument\" class=\"form-control\" placeholder=\"yyyy-mm-dd\" name=\"dp\" ngbDatepicker #dp=\"ngbDatepicker\">\r\n          <div class=\"input-group-append\">\r\n            <button class=\"btn btn-outline-secondary calendar\" (click)=\"dp.toggle()\" type=\"button\"></button>\r\n          </div>\r\n        </div>\r\n      </div>\r\n      <button type=\"button\" class=\"btn btn-outline-secondary btn-sm\" (click)=\"addEmailInput()\" style=\"float:right\">\r\n        <span class=\"glyphicon glyphicon-plus\"></span>+\r\n      </button>\r\n      <div formArrayName=\"emailInputs\" *ngFor=\"let input of form.get('emailInputs').controls; let i = index;\">\r\n        <div [formGroupName]=\"i\">\r\n          <label for=\"email\">Email {{ i + 1 }} </label>\r\n          <input formControlName=\"email\" class=\"form-control\" style=\"margin-bottom: 6px\">\r\n        </div>\r\n      </div>\r\n    </form>\r\n  </div>\r\n  <div class=\"modal-footer\">\r\n    <button type=\"button\" class=\"btn btn-outline-dark\" (click)=\"onSubmit()\" [disabled]=\"! form.valid\">Notify</button>\r\n  </div>\r\n</div>"

/***/ }),

/***/ "./src/app/modal/order-notification-modal/order-notification-modal.component.ts":
/*!**************************************************************************************!*\
  !*** ./src/app/modal/order-notification-modal/order-notification-modal.component.ts ***!
  \**************************************************************************************/
/*! exports provided: OrderNotificationModalComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "OrderNotificationModalComponent", function() { return OrderNotificationModalComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @ng-bootstrap/ng-bootstrap */ "./node_modules/@ng-bootstrap/ng-bootstrap/fesm5/ng-bootstrap.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var src_app_service_notification_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! src/app/service/notification-service */ "./src/app/service/notification-service.ts");
/* harmony import */ var src_app_model_request_notification_OrderNotificationRequest__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! src/app/model/request/notification/OrderNotificationRequest */ "./src/app/model/request/notification/OrderNotificationRequest.ts");
/* harmony import */ var file_saver__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! file-saver */ "./node_modules/file-saver/dist/FileSaver.min.js");
/* harmony import */ var file_saver__WEBPACK_IMPORTED_MODULE_6___default = /*#__PURE__*/__webpack_require__.n(file_saver__WEBPACK_IMPORTED_MODULE_6__);
/* harmony import */ var src_app_model_DocType__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! src/app/model/DocType */ "./src/app/model/DocType.ts");








var OrderNotificationModalComponent = /** @class */ (function () {
    function OrderNotificationModalComponent(modal, formBuilder, notificationService) {
        this.modal = modal;
        this.formBuilder = formBuilder;
        this.notificationService = notificationService;
        this.docTypesMapByName = new Map();
    }
    OrderNotificationModalComponent.prototype.ngOnInit = function () {
        this.initDocTypes();
        this.form = this.formBuilder.group({
            docTypesSelect: [[], [_angular_forms__WEBPACK_IMPORTED_MODULE_3__["Validators"].required]],
            formats: this.formBuilder.array([]),
            dateDocument: [],
            emailInputs: this.formBuilder.array([])
        });
        var emailInputs = this.form.controls.emailInputs;
        emailInputs.push(this.createEmailInput());
    };
    OrderNotificationModalComponent.prototype.initDocTypes = function () {
        var _this = this;
        this.notificationService.getDocumentTypes().subscribe(function (data) {
            for (var i = 0; i < data.length; i++) {
                var docType = src_app_model_DocType__WEBPACK_IMPORTED_MODULE_7__["DocType"].fromJson(data[i]);
                _this.docTypesMapByName.set(docType.type, docType);
            }
        }, function (error) {
            console.log("Error : Cannot get the notification types : " + error);
        });
    };
    OrderNotificationModalComponent.prototype.createEmailInput = function () {
        return this.formBuilder.group({
            email: ['', _angular_forms__WEBPACK_IMPORTED_MODULE_3__["Validators"].email]
        });
    };
    OrderNotificationModalComponent.prototype.createFormatCheckbox = function () {
        return this.formBuilder.group({
            format: []
        });
    };
    OrderNotificationModalComponent.prototype.addFormatCheckbox = function () {
        var formats = this.form.get('formats');
        formats.push(this.createFormatCheckbox());
    };
    OrderNotificationModalComponent.prototype.addEmailInput = function () {
        var emailInputs = this.form.get('emailInputs');
        emailInputs.push(this.createEmailInput());
    };
    OrderNotificationModalComponent.prototype.onChangeType = function (event) {
        var selectedTypeName = event.target.selectedOptions[0].text;
        if (selectedTypeName != null) {
            this.selectedType = this.docTypesMapByName.get(selectedTypeName);
            if (this.selectedType != null) {
                this.formatsOfSelectedType = this.selectedType.supportedFormats;
                for (var i = 0; i < this.formatsOfSelectedType.length; i++) {
                    this.addFormatCheckbox();
                }
            }
            else {
                console.log("Unknown selected type name " + selectedTypeName + ". Known types : " + JSON.stringify(this.docTypesMapByName));
            }
        }
    };
    OrderNotificationModalComponent.prototype.onSubmit = function () {
        var _this = this;
        if (this.form.valid) {
            var dp = this.form.controls.dateDocument.value;
            var type = this.form.controls.docTypesSelect.value;
            var req = new src_app_model_request_notification_OrderNotificationRequest__WEBPACK_IMPORTED_MODULE_5__["OrderNotificationRequest"](type, this.orderId);
            if (dp != null) {
                req.dateDocument = new Date(dp.year, dp.month - 1, dp.day + 1).getTime();
            }
            req.emails = this.getEmailsFromInputs();
            this.notificationService.notify(req).subscribe(function (response) {
                _this.saveFile(response.body, response.headers.get('filename'), response.headers.get('Content-type'));
                _this.modal.close();
            }, function (error) {
                alert(JSON.stringify(error));
            });
        }
    };
    OrderNotificationModalComponent.prototype.saveFile = function (data, filename, contentType) {
        var blob = new Blob([data], { type: contentType });
        file_saver__WEBPACK_IMPORTED_MODULE_6__["saveAs"](blob, filename);
    };
    OrderNotificationModalComponent.prototype.getEmailsFromInputs = function () {
        var emails = [];
        var array = this.form.controls.emailInputs;
        for (var i = 0; i < array.length; i++) {
            var emailObjValue = array.at(i).value;
            if (emailObjValue.email.length > 0) {
                emails.push(emailObjValue.email);
            }
        }
        return emails;
    };
    OrderNotificationModalComponent.prototype.onClose = function () {
        this.modal.close(false);
    };
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", Number)
    ], OrderNotificationModalComponent.prototype, "orderId", void 0);
    OrderNotificationModalComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-order-notification-modal',
            template: __webpack_require__(/*! ./order-notification-modal.component.html */ "./src/app/modal/order-notification-modal/order-notification-modal.component.html"),
            styles: [__webpack_require__(/*! ./order-notification-modal.component.css */ "./src/app/modal/order-notification-modal/order-notification-modal.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_2__["NgbActiveModal"],
            _angular_forms__WEBPACK_IMPORTED_MODULE_3__["FormBuilder"],
            src_app_service_notification_service__WEBPACK_IMPORTED_MODULE_4__["NotificationService"]])
    ], OrderNotificationModalComponent);
    return OrderNotificationModalComponent;
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

module.exports = "<div class=\"modal-header\">\r\n  <h5 class=\"modal-title\" id=\"modal-basic-title\">Order Items</h5>\r\n  <button type=\"button\" class=\"close\" aria-label=\"Close\" (click)=\"onClose()\">\r\n    <span aria-hidden=\"true\">&times;</span>\r\n  </button>\r\n</div>\r\n<div class=\"modal-body\">\r\n  <table class=\"table table-striped\">\r\n    <thead>\r\n      <tr>\r\n        <th>#</th>\r\n        <th>Id</th>\r\n        <th>Name</th>\r\n        <th>Price</th>\r\n        <th>Creation Date</th>\r\n        <th>Last Modified Date</th>\r\n        <th>BarCode</th>\r\n      </tr>\r\n    </thead>\r\n    <tbody>\r\n      <tr *ngFor=\"let item of orderItems; let i = index\">\r\n        <td>{{ i+1 }}</td>\r\n        <td>{{ item.productItem.id }}</td>\r\n        <td>{{ item.productItem.product.name }}</td>\r\n        <td>{{ item.productItem.product.price }} €</td>\r\n        <td>{{ item.createdDatetime }}</td>\r\n        <td>{{ item.lastModifiedDatetime }}</td>\r\n        <td>{{ item.productItem.barCode }}</td>\r\n      </tr>\r\n    </tbody>\r\n  </table>\r\n</div>\r\n<div class=\"modal-footer\">\r\n  <button class=\"btn btn-outline-dark\" (click)=\"onClose()\">Close</button>\r\n</div>"

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

/***/ "./src/app/modal/upload-product-file-modal/upload-product-file-modal.component.css":
/*!*****************************************************************************************!*\
  !*** ./src/app/modal/upload-product-file-modal/upload-product-file-modal.component.css ***!
  \*****************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".my-custom-scrollbar {\r\n  position: relative;\r\n  height: 450px;\r\n  overflow: auto;\r\n}\r\n\r\n.table-wrapper-scroll-y {\r\n  display: block;\r\n}\r\n\r\n.drop-box {\r\n  cursor: pointer;\r\n  background: #F8F8F8;\r\n  border: 5px dashed #DDD;\r\n  text-align: center;\r\n  padding: 40px;\r\n}\r\n\r\n.drag-over-title {\r\n  display: none;\r\n}\r\n\r\n.drop-box.dragover {\r\n  opacity: 0.6;\r\n}\r\n\r\n.drop-box.dragover .drag-over-title {\r\n  display: block;\r\n}\r\n\r\n.drop-box.dragover .drag-in-title {\r\n  display: none;\r\n}\r\n\r\ninput[type='file'] {\r\n  display: none;\r\n}\r\n\r\np { display: inline }\r\n\r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvbW9kYWwvdXBsb2FkLXByb2R1Y3QtZmlsZS1tb2RhbC91cGxvYWQtcHJvZHVjdC1maWxlLW1vZGFsLmNvbXBvbmVudC5jc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUE7RUFDRSxrQkFBa0I7RUFDbEIsYUFBYTtFQUNiLGNBQWM7QUFDaEI7O0FBRUE7RUFDRSxjQUFjO0FBQ2hCOztBQUVBO0VBQ0UsZUFBZTtFQUNmLG1CQUFtQjtFQUNuQix1QkFBdUI7RUFDdkIsa0JBQWtCO0VBQ2xCLGFBQWE7QUFDZjs7QUFFQTtFQUNFLGFBQWE7QUFDZjs7QUFFQTtFQUNFLFlBQVk7QUFDZDs7QUFFQTtFQUNFLGNBQWM7QUFDaEI7O0FBRUE7RUFDRSxhQUFhO0FBQ2Y7O0FBRUE7RUFDRSxhQUFhO0FBQ2Y7O0FBRUEsSUFBSSxnQkFBZ0IiLCJmaWxlIjoic3JjL2FwcC9tb2RhbC91cGxvYWQtcHJvZHVjdC1maWxlLW1vZGFsL3VwbG9hZC1wcm9kdWN0LWZpbGUtbW9kYWwuY29tcG9uZW50LmNzcyIsInNvdXJjZXNDb250ZW50IjpbIi5teS1jdXN0b20tc2Nyb2xsYmFyIHtcclxuICBwb3NpdGlvbjogcmVsYXRpdmU7XHJcbiAgaGVpZ2h0OiA0NTBweDtcclxuICBvdmVyZmxvdzogYXV0bztcclxufVxyXG5cclxuLnRhYmxlLXdyYXBwZXItc2Nyb2xsLXkge1xyXG4gIGRpc3BsYXk6IGJsb2NrO1xyXG59XHJcblxyXG4uZHJvcC1ib3gge1xyXG4gIGN1cnNvcjogcG9pbnRlcjtcclxuICBiYWNrZ3JvdW5kOiAjRjhGOEY4O1xyXG4gIGJvcmRlcjogNXB4IGRhc2hlZCAjREREO1xyXG4gIHRleHQtYWxpZ246IGNlbnRlcjtcclxuICBwYWRkaW5nOiA0MHB4O1xyXG59XHJcbiAgXHJcbi5kcmFnLW92ZXItdGl0bGUge1xyXG4gIGRpc3BsYXk6IG5vbmU7XHJcbn1cclxuICBcclxuLmRyb3AtYm94LmRyYWdvdmVyIHtcclxuICBvcGFjaXR5OiAwLjY7XHJcbn1cclxuICBcclxuLmRyb3AtYm94LmRyYWdvdmVyIC5kcmFnLW92ZXItdGl0bGUge1xyXG4gIGRpc3BsYXk6IGJsb2NrO1xyXG59XHJcbiAgXHJcbi5kcm9wLWJveC5kcmFnb3ZlciAuZHJhZy1pbi10aXRsZSB7XHJcbiAgZGlzcGxheTogbm9uZTtcclxufVxyXG4gIFxyXG5pbnB1dFt0eXBlPSdmaWxlJ10ge1xyXG4gIGRpc3BsYXk6IG5vbmU7XHJcbn1cclxuXHJcbnAgeyBkaXNwbGF5OiBpbmxpbmUgfVxyXG4iXX0= */"

/***/ }),

/***/ "./src/app/modal/upload-product-file-modal/upload-product-file-modal.component.html":
/*!******************************************************************************************!*\
  !*** ./src/app/modal/upload-product-file-modal/upload-product-file-modal.component.html ***!
  \******************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div>\r\n  <input #fileInput type=\"file\" ng2FileSelect [uploader]=\"uploader\"/>\r\n \r\n  <div class=\"drop-box\" ng2FileDrop\r\n       [ngClass]=\"{'dragover': isDropOver}\"\r\n       [uploader]=\"uploader\"\r\n       (fileOver)=\"fileOverAnother($event)\"\r\n       (click)=\"fileClicked()\">\r\n    <span class=\"drag-in-title\">Import or drag file here</span>\r\n    <span class=\"drag-over-title\">Drop the file</span>\r\n  </div>\r\n  <br>\r\n  <div *ngIf=\"result\">\r\n    <p>Upload ID : {{ result.id }}</p>\r\n    <p> | </p>\r\n    <p>Rows in file : {{ result.rowsInFile }}</p>\r\n    <p> | </p>\r\n    <p>Rows Processed : {{ result.rowsProcessed }}</p>\r\n    <p> | </p>\r\n    <p>Total Product Items : {{ result.productItems.length }}</p>\r\n    <div class=\"table-wrapper-scroll-y my-custom-scrollbar\">\r\n      <table class=\"table table-sm table-striped\">\r\n        <thead>\r\n          <tr>\r\n            <th class=\"th-sm\">Name</th>\r\n            <th class=\"th-sm\">Price</th>\r\n            <th class=\"th-sm\">BarCode</th>\r\n          </tr>\r\n        </thead>\r\n        <tbody>\r\n          <tr *ngFor=\"let productItem of result.productItems\">\r\n            <td>{{ productItem.product.name }}</td>\r\n            <td>{{ productItem.product.price }} €</td>\r\n            <td>{{ productItem.barCode }}</td>\r\n          </tr>\r\n        </tbody>\r\n      </table>\r\n    </div>\r\n    <br>\r\n    <div class=\"row\" style=\"float:right\">\r\n      <div class=\"col-md-auto\">\r\n        <p>Are you sure you want to add the {{ result.productItems.length }} product items to the stock ?</p>\r\n      </div>\r\n      <div class=\"col col-lg-1\">\r\n        <button type=\"button\" class=\"btn btn-primary\" (click)=\"onClickYes()\">Yes</button>\r\n      </div>\r\n      <div class=\"col col-lg-1\">\r\n        <button type=\"button\" class=\"btn btn-secondary\" (click)=\"onClickNo()\">No</button>\r\n      </div>\r\n    </div>\r\n  </div>\r\n\r\n\r\n</div>\r\n"

/***/ }),

/***/ "./src/app/modal/upload-product-file-modal/upload-product-file-modal.component.ts":
/*!****************************************************************************************!*\
  !*** ./src/app/modal/upload-product-file-modal/upload-product-file-modal.component.ts ***!
  \****************************************************************************************/
/*! exports provided: UploadProductFileModalComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "UploadProductFileModalComponent", function() { return UploadProductFileModalComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var ng2_file_upload__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ng2-file-upload */ "./node_modules/ng2-file-upload/index.js");
/* harmony import */ var ng2_file_upload__WEBPACK_IMPORTED_MODULE_2___default = /*#__PURE__*/__webpack_require__.n(ng2_file_upload__WEBPACK_IMPORTED_MODULE_2__);
/* harmony import */ var src_app_model_UploadProductsFileResult__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! src/app/model/UploadProductsFileResult */ "./src/app/model/UploadProductsFileResult.ts");
/* harmony import */ var _service_product_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../service/product-service */ "./src/app/service/product-service.ts");





var UploadProductFileModalComponent = /** @class */ (function () {
    function UploadProductFileModalComponent(productService) {
        this.productService = productService;
        this.showConfirmUploadButton = false;
    }
    UploadProductFileModalComponent.prototype.ngOnInit = function () {
        var _this = this;
        var headers = [{ name: 'Accept', value: 'application/json' }];
        this.uploader = new ng2_file_upload__WEBPACK_IMPORTED_MODULE_2__["FileUploader"]({
            url: 'v1/productItemFileUpload/upload',
            autoUpload: true,
            headers: headers
        });
        this.uploader.onErrorItem = function (item, response, status, headers) { return _this.onErrorItem(item, response, status, headers); };
        this.uploader.onSuccessItem = function (item, response, status, headers) { return _this.onSuccessItem(item, response, status, headers); };
    };
    UploadProductFileModalComponent.prototype.onSuccessItem = function (item, response, status, headers) {
        this.result = src_app_model_UploadProductsFileResult__WEBPACK_IMPORTED_MODULE_3__["UploadProductsFileResult"].fromJson(JSON.parse(response));
        this.showConfirmUploadButton = true;
    };
    UploadProductFileModalComponent.prototype.onErrorItem = function (item, response, status, headers) {
        alert('Error : ' + JSON.stringify(response)); //error server response
        this.showConfirmUploadButton = false;
    };
    UploadProductFileModalComponent.prototype.fileOverAnother = function (e) {
        this.reset();
        this.isDropOver = e;
    };
    UploadProductFileModalComponent.prototype.fileClicked = function () {
        this.fileInput.nativeElement.click();
    };
    UploadProductFileModalComponent.prototype.onClickYes = function () {
        var _this = this;
        this.productService.confirmProductItemFileUpload(this.result.id).subscribe(function (data) {
            _this.reset();
        });
    };
    UploadProductFileModalComponent.prototype.onClickNo = function () {
        alert('no');
    };
    UploadProductFileModalComponent.prototype.reset = function () {
        this.result = null;
    };
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["ViewChild"])('fileInput'),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", _angular_core__WEBPACK_IMPORTED_MODULE_1__["ElementRef"])
    ], UploadProductFileModalComponent.prototype, "fileInput", void 0);
    UploadProductFileModalComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'upload-product-file-modal',
            template: __webpack_require__(/*! ./upload-product-file-modal.component.html */ "./src/app/modal/upload-product-file-modal/upload-product-file-modal.component.html"),
            styles: [__webpack_require__(/*! ./upload-product-file-modal.component.css */ "./src/app/modal/upload-product-file-modal/upload-product-file-modal.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_service_product_service__WEBPACK_IMPORTED_MODULE_4__["ProductService"]])
    ], UploadProductFileModalComponent);
    return UploadProductFileModalComponent;
}());



/***/ }),

/***/ "./src/app/model/Address.ts":
/*!**********************************!*\
  !*** ./src/app/model/Address.ts ***!
  \**********************************/
/*! exports provided: Address */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Address", function() { return Address; });
var Address = /** @class */ (function () {
    function Address(streetNumber, streetName, zipCode, city, country) {
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.zipCode = zipCode;
        this.city = city;
        this.country = country;
    }
    Address.fromJson = function (data) {
        return new Address(data.streetNumber, data.streetName, data.zipCode, data.city, data.country);
    };
    Address.prototype.format = function () {
        return this.streetNumber + ', ' + this.streetName + ' - ' + this.zipCode + ' ' + this.city + ' - ' + this.country;
    };
    return Address;
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

/***/ "./src/app/model/DocType.ts":
/*!**********************************!*\
  !*** ./src/app/model/DocType.ts ***!
  \**********************************/
/*! exports provided: DocType */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "DocType", function() { return DocType; });
var DocType = /** @class */ (function () {
    function DocType() {
    }
    DocType.fromJson = function (data) {
        var notif = new DocType();
        notif.type = data.type;
        notif.supportedFormats = data.supportedFormats;
        return notif;
    };
    return DocType;
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
        return owner;
    };
    Owner.prototype.getFullName = function () {
        return this.firstName + ' ' + this.lastName;
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
        productItem.orderItemId = data.orderItemId;
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
/* harmony import */ var _Address__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./Address */ "./src/app/model/Address.ts");


var Store = /** @class */ (function () {
    function Store() {
    }
    Store.fromJson = function (data) {
        var store = new Store();
        store.id = data.id;
        store.name = data.name;
        store.email = data.email;
        store.phone = data.phone;
        store.address = _Address__WEBPACK_IMPORTED_MODULE_1__["Address"].fromJson(data.address);
        store.owner = _Owner__WEBPACK_IMPORTED_MODULE_0__["Owner"].fromJson(data.owner);
        return store;
    };
    return Store;
}());



/***/ }),

/***/ "./src/app/model/UploadProductsFileResult.ts":
/*!***************************************************!*\
  !*** ./src/app/model/UploadProductsFileResult.ts ***!
  \***************************************************/
/*! exports provided: UploadProductsFileResult */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "UploadProductsFileResult", function() { return UploadProductsFileResult; });
/* harmony import */ var _ProductItem__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./ProductItem */ "./src/app/model/ProductItem.ts");

var UploadProductsFileResult = /** @class */ (function () {
    function UploadProductsFileResult() {
        this.productItems = [];
    }
    UploadProductsFileResult.fromJson = function (data) {
        var result = new UploadProductsFileResult();
        result.id = data.id;
        result.rowsInFile = data.rowsInFile;
        result.rowsProcessed = data.rowsProcessed;
        var products = [];
        for (var _i = 0, _a = data.productItems; _i < _a.length; _i++) {
            var item = _a[_i];
            products.push(_ProductItem__WEBPACK_IMPORTED_MODULE_0__["ProductItem"].fromJson(item));
        }
        result.productItems = products;
        return result;
    };
    return UploadProductsFileResult;
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

/***/ "./src/app/model/monitoring/actuator/ActuatorBasicResponse.ts":
/*!********************************************************************!*\
  !*** ./src/app/model/monitoring/actuator/ActuatorBasicResponse.ts ***!
  \********************************************************************/
/*! exports provided: ActuatorBasicResponse */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ActuatorBasicResponse", function() { return ActuatorBasicResponse; });
var ActuatorBasicResponse = /** @class */ (function () {
    function ActuatorBasicResponse() {
        this.values = [];
    }
    ActuatorBasicResponse.fromJson = function (data) {
        var res = new ActuatorBasicResponse();
        res.name = data.name;
        res.baseUnit = data.baseUnit != null ? data.baseUnit : "";
        res.description = data.description;
        for (var _i = 0, _a = data.measurements; _i < _a.length; _i++) {
            var val = _a[_i];
            res.values.push(val.value);
        }
        return res;
    };
    return ActuatorBasicResponse;
}());



/***/ }),

/***/ "./src/app/model/monitoring/actuator/ActuatorDbHealth.ts":
/*!***************************************************************!*\
  !*** ./src/app/model/monitoring/actuator/ActuatorDbHealth.ts ***!
  \***************************************************************/
/*! exports provided: ActuatorDbHealth */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ActuatorDbHealth", function() { return ActuatorDbHealth; });
var ActuatorDbHealth = /** @class */ (function () {
    function ActuatorDbHealth() {
    }
    ActuatorDbHealth.fromJson = function (data) {
        var health = new ActuatorDbHealth();
        health.isUp = data.status == 'UP';
        health.dbName = data.details.database == null ? '' : data.details.database;
        health.error = data.details.error;
        return health;
    };
    return ActuatorDbHealth;
}());



/***/ }),

/***/ "./src/app/model/monitoring/actuator/ActuatorElasticsearchHealth.ts":
/*!**************************************************************************!*\
  !*** ./src/app/model/monitoring/actuator/ActuatorElasticsearchHealth.ts ***!
  \**************************************************************************/
/*! exports provided: ActuatorElasticsearchHealth */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ActuatorElasticsearchHealth", function() { return ActuatorElasticsearchHealth; });
var ActuatorElasticsearchHealth = /** @class */ (function () {
    function ActuatorElasticsearchHealth() {
    }
    ActuatorElasticsearchHealth.fromJson = function (data) {
        var health = new ActuatorElasticsearchHealth();
        health.isUp = data.status == 'UP';
        health.clusterName = data.details.cluster_name;
        health.elasticsearchStatus = data.details.status;
        health.nodesNb = data.details.number_of_nodes;
        health.dataNodesNb = data.details.number_of_data_nodes;
        health.activePrimaryShardsNb = data.details.active_primary_shards;
        health.activeShardsNb = data.details.active_shards;
        health.pendingTaskNb = data.details.number_of_pending_tasks;
        health.error = data.error;
        return health;
    };
    return ActuatorElasticsearchHealth;
}());



/***/ }),

/***/ "./src/app/model/request/customer/AddOrUpdateCustomerReq.ts":
/*!******************************************************************!*\
  !*** ./src/app/model/request/customer/AddOrUpdateCustomerReq.ts ***!
  \******************************************************************/
/*! exports provided: AddOrUpdateCustomerReq */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AddOrUpdateCustomerReq", function() { return AddOrUpdateCustomerReq; });
var AddOrUpdateCustomerReq = /** @class */ (function () {
    function AddOrUpdateCustomerReq(ownerId, storeName) {
        this.ownerId = ownerId;
        this.storeName = storeName;
    }
    return AddOrUpdateCustomerReq;
}());



/***/ }),

/***/ "./src/app/model/request/login/LoginRequest.ts":
/*!*****************************************************!*\
  !*** ./src/app/model/request/login/LoginRequest.ts ***!
  \*****************************************************/
/*! exports provided: LoginRequest */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "LoginRequest", function() { return LoginRequest; });
var LoginRequest = /** @class */ (function () {
    function LoginRequest(username, password) {
        this.username = username;
        this.password = password;
    }
    return LoginRequest;
}());



/***/ }),

/***/ "./src/app/model/request/notification/NotificationRequest.ts":
/*!*******************************************************************!*\
  !*** ./src/app/model/request/notification/NotificationRequest.ts ***!
  \*******************************************************************/
/*! exports provided: NotificationRequest */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "NotificationRequest", function() { return NotificationRequest; });
var NotificationRequest = /** @class */ (function () {
    function NotificationRequest(docType) {
        this.emails = [];
        this.docType = docType;
    }
    return NotificationRequest;
}());



/***/ }),

/***/ "./src/app/model/request/notification/OrderNotificationRequest.ts":
/*!************************************************************************!*\
  !*** ./src/app/model/request/notification/OrderNotificationRequest.ts ***!
  \************************************************************************/
/*! exports provided: OrderNotificationRequest */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "OrderNotificationRequest", function() { return OrderNotificationRequest; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _NotificationRequest__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./NotificationRequest */ "./src/app/model/request/notification/NotificationRequest.ts");


var OrderNotificationRequest = /** @class */ (function (_super) {
    tslib__WEBPACK_IMPORTED_MODULE_0__["__extends"](OrderNotificationRequest, _super);
    function OrderNotificationRequest(type, orderId) {
        var _this = _super.call(this, type) || this;
        _this.dateDocument = new Date().getTime();
        _this.orderId = orderId;
        return _this;
    }
    return OrderNotificationRequest;
}(_NotificationRequest__WEBPACK_IMPORTED_MODULE_1__["NotificationRequest"]));



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

/***/ "./src/app/model/statistic/OpenClosedOrdersCounter.ts":
/*!************************************************************!*\
  !*** ./src/app/model/statistic/OpenClosedOrdersCounter.ts ***!
  \************************************************************/
/*! exports provided: OpenClosedOrdersCounter */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "OpenClosedOrdersCounter", function() { return OpenClosedOrdersCounter; });
var OpenClosedOrdersCounter = /** @class */ (function () {
    function OpenClosedOrdersCounter() {
    }
    OpenClosedOrdersCounter.fromJson = function (data) {
        var counters = new OpenClosedOrdersCounter();
        counters.openOrdersCount = data.counters.OPEN != null ? data.counters.OPEN : 0;
        counters.closedOrdersCount = data.counters.CLOSED != null ? data.counters.CLOSED : 0;
        return counters;
    };
    OpenClosedOrdersCounter.prototype.calculatePercentOfClosedOrders = function () {
        var result = '0';
        var total = this.totalOrders();
        if (total > 0) {
            result = ((this.closedOrdersCount / this.totalOrders()) * 100).toFixed(1);
        }
        return result;
    };
    OpenClosedOrdersCounter.prototype.totalOrders = function () {
        return this.openOrdersCount + this.closedOrdersCount;
    };
    return OpenClosedOrdersCounter;
}());



/***/ }),

/***/ "./src/app/monitoring/dashboard/dashboard.component.css":
/*!**************************************************************!*\
  !*** ./src/app/monitoring/dashboard/dashboard.component.css ***!
  \**************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".center {\r\n    display: block;\r\n    margin-left: auto;\r\n    margin-right: auto;\r\n    width: 50%;\r\n}\r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvbW9uaXRvcmluZy9kYXNoYm9hcmQvZGFzaGJvYXJkLmNvbXBvbmVudC5jc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUE7SUFDSSxjQUFjO0lBQ2QsaUJBQWlCO0lBQ2pCLGtCQUFrQjtJQUNsQixVQUFVO0FBQ2QiLCJmaWxlIjoic3JjL2FwcC9tb25pdG9yaW5nL2Rhc2hib2FyZC9kYXNoYm9hcmQuY29tcG9uZW50LmNzcyIsInNvdXJjZXNDb250ZW50IjpbIi5jZW50ZXIge1xyXG4gICAgZGlzcGxheTogYmxvY2s7XHJcbiAgICBtYXJnaW4tbGVmdDogYXV0bztcclxuICAgIG1hcmdpbi1yaWdodDogYXV0bztcclxuICAgIHdpZHRoOiA1MCU7XHJcbn0iXX0= */"

/***/ }),

/***/ "./src/app/monitoring/dashboard/dashboard.component.html":
/*!***************************************************************!*\
  !*** ./src/app/monitoring/dashboard/dashboard.component.html ***!
  \***************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container-fluid\">\n  <div class=\"row\">\n\n    <div class=\"col\">\n      <div class=\"card bg-light shadow-sm mb-3\" style=\"width: 19rem; height: 18rem;\">\n        <div class=\"card-header\">Mysql Database Health</div>\n        <div class=\"card-body\">\n          <h4 *ngIf=\"dbHealth\" class=\"card-title\">Status :\n            <img *ngIf=\"dbHealth.isUp\" src=\"../../../assets/icon/statusGreen.png\">\n            <img *ngIf=\"! dbHealth.isUp\" src=\"../../../assets/icon/statusRed.png\">\n          </h4>\n          <img *ngIf=\"! dbHealth\" class=\"center\" src=\"../../../assets/icon/loadingGrey.gif\">\n        </div>\n      </div>\n    </div>\n\n    <div class=\"col\">\n        <div class=\"card bg-light shadow-sm mb-3\" style=\"width: 19rem; height: 18rem;\">\n          <div class=\"card-header\">Elasticsearch Health</div>\n          <div class=\"card-body\">\n            <h4  *ngIf=\"elasticsearchHealth\" class=\"card-title\">Status :\n              <img *ngIf=\"getElasticsearchStatus() == 'G'\" src=\"../../../assets/icon/statusGreen.png\">\n              <img *ngIf=\"getElasticsearchStatus() == 'Y'\" src=\"../../../assets/icon/statusYellow.png\">\n              <img *ngIf=\"getElasticsearchStatus() == 'R'\" src=\"../../../assets/icon/statusRed.png\">\n            </h4>\n            <img *ngIf=\"! elasticsearchHealth\" class=\"center\" src=\"../../../assets/icon/loadingGrey.gif\">\n            <div *ngIf=\"elasticsearchHealth\">\n              <p *ngIf=\"elasticsearchHealth.clusterName\" class=\"card-text\">Cluster Name : {{ elasticsearchHealth.clusterName }} <br> Number of Nodes : {{ elasticsearchHealth.nodesNb }} <br> Number of Data Nodes : {{ elasticsearchHealth.dataNodesNb }} <br> Primary Active Shards : {{ elasticsearchHealth.activePrimaryShardsNb }} <br>Active Shards : {{ elasticsearchHealth.activeShardsNb }} <br> Pending Tasks : {{ elasticsearchHealth.pendingTaskNb }}</p>\n              <p *ngIf=\"elasticsearchHealth.error\" class=\"card-text\">Error : {{ elasticsearchHealth.error }}</p>\n            </div>\n          </div>\n        </div>\n      </div>\n\n    <div class=\"col\">\n      <div [ngClass]=\"(cpuUsage && cpuUsage.values[0] >= cpuUsageWarningLimit) ? 'card text-white bg-danger shadow-sm mb-3' : 'card bg-light shadow-sm mb-3'\" style=\"width: 19rem; height: 18rem;\">\n        <div class=\"card-header\">Process CPU Usage</div>\n        <div class=\"card-body\">\n          <div *ngIf=\"cpuUsage\">\n            <h1 class=\"card-title\" style=\"font-size: 400%\">{{ getPercentOfCpuUsage() }} %</h1>\n            <p class=\"card-text\">{{ cpuUsage.description }}</p>\n          </div>\n          <img *ngIf=\"! cpuUsage\" class=\"center\" src=\"../../../assets/icon/loadingGrey.gif\">\n        </div>\n      </div>\n    </div>\n\n    <!--<div *ngIf=\"jvmMemoryMax\" class=\"col\">\n      <div class=\"card bg-light shadow-sm mb-3\" style=\"width: 19rem; height: 18rem;\">\n        <div class=\"card-header\">JVM Max Memory</div>\n        <div class=\"card-body\">\n          <h1 class=\"card-title\" style=\"font-size: 400%\">{{ (jvmMemoryMax.values[0] / 1000000).toFixed(0) }} MB</h1>\n          <p class=\"card-text\">{{ jvmMemoryMax.description }}</p>\n        </div>\n      </div>\n    </div>-->\n\n    <div class=\"col\">\n      <div [ngClass]=\"(jvmMemoryUsed.values[0] >= memoryUsageWarningLimit) ? 'card text-white bg-danger shadow-sm mb-3' : 'card bg-light shadow-sm mb-3'\" style=\"width: 19rem; height: 18rem;\">\n        <div class=\"card-header\">JVM Memory Used</div>\n        <div class=\"card-body\">\n          <div *ngIf=\"jvmMemoryUsed && memoryUsageWarningLimit\">\n            <h1 class=\"card-title\" style=\"font-size: 400%\">{{ getPercentOfMemoryUsed() }} %</h1>\n            <h2 class=\"card-title\" style=\"font-size: 400%\">{{ getMemoryUsedInMb() }} MB</h2>\n            <p class=\"card-text\">{{ jvmMemoryUsed.description }}</p>\n          </div>\n          <img *ngIf=\"! (jvmMemoryUsed && memoryUsageWarningLimit)\" class=\"center\" src=\"../../../assets/icon/loadingGrey.gif\">\n        </div>\n      </div>\n    </div>\n\n  </div>\n  \n  <div class=\"row\">\n    \n    <div class=\"col\">\n      <div class=\"card bg-light shadow-sm mb-3\" style=\"width: 19rem; height: 18rem;\">\n        <div class=\"card-header\">System CPU count</div>\n        <div class=\"card-body\">\n          <div *ngIf=\"cpuSystemCount\">\n            <h1 class=\"card-title\" style=\"font-size: 400%\">{{ cpuSystemCount.values[0] }}</h1>\n            <p class=\"card-text\">{{ cpuSystemCount.description }}</p>\n          </div>\n          <img *ngIf=\"! cpuSystemCount\" class=\"center\" src=\"../../../assets/icon/loadingGrey.gif\">\n        </div>\n      </div>\n    </div>\n\n    <div class=\"col\">\n      <div class=\"card bg-light shadow-sm mb-3\" style=\"width: 19rem; height: 18rem;\">\n        <div class=\"card-header\">JVM Live Threads</div>\n        <div class=\"card-body\">\n          <div *ngIf=\"jvmThreadLive\">\n            <h1 class=\"card-title\" style=\"font-size: 400%\">{{ jvmThreadLive.values[0] }}</h1>\n            <p class=\"card-text\">{{ jvmThreadLive.description }}</p>\n          </div>\n          <img *ngIf=\"! jvmThreadLive\" class=\"center\" src=\"../../../assets/icon/loadingGrey.gif\">\n        </div>\n      </div>\n    </div>\n    \n  </div>\n  \n  <div class=\"row\">\n    <div class=\"col\">\n      <div class=\"card bg-light shadow-sm mb-3\">\n        <div class=\"card-header\">Andybrook Log\n          <button class=\"btn btn-outline-dark\" (click)=\"getLogFile()\">GET</button>\n        </div>\n        <div *ngIf=\"logFile\" class=\"card-body\">\n          <p class=\"card-text\">{{ logFile }}</p>\n        </div>\n      </div>\n    </div>\n  </div>\n</div>"

/***/ }),

/***/ "./src/app/monitoring/dashboard/dashboard.component.ts":
/*!*************************************************************!*\
  !*** ./src/app/monitoring/dashboard/dashboard.component.ts ***!
  \*************************************************************/
/*! exports provided: DashboardComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "DashboardComponent", function() { return DashboardComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
/* harmony import */ var _service_monitoring_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../service/monitoring-service */ "./src/app/service/monitoring-service.ts");
/* harmony import */ var _model_monitoring_actuator_ActuatorBasicResponse__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../model/monitoring/actuator/ActuatorBasicResponse */ "./src/app/model/monitoring/actuator/ActuatorBasicResponse.ts");
/* harmony import */ var _model_monitoring_actuator_ActuatorDbHealth__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../../model/monitoring/actuator/ActuatorDbHealth */ "./src/app/model/monitoring/actuator/ActuatorDbHealth.ts");
/* harmony import */ var _model_monitoring_actuator_ActuatorElasticsearchHealth__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../../model/monitoring/actuator/ActuatorElasticsearchHealth */ "./src/app/model/monitoring/actuator/ActuatorElasticsearchHealth.ts");







var DashboardComponent = /** @class */ (function () {
    function DashboardComponent(monitoringService) {
        this.monitoringService = monitoringService;
        this.cpuUsageWarningLimit = 0.85;
        this.timer = Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["timer"])(0, 5000);
    }
    DashboardComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.timerSubscription = this.timer.subscribe(function (event) {
            _this.getCpuUsage();
            _this.getSystemCpuCount();
            _this.getJvmThreadsLive();
            _this.getJvmMemoryMax();
            _this.getJvmMemoryUsed();
            _this.getElasticsearchHealth();
            _this.getDatabaseHealth();
        });
    };
    DashboardComponent.prototype.ngOnDestroy = function () {
        this.timerSubscription.unsubscribe();
    };
    DashboardComponent.prototype.getDatabaseHealth = function () {
        var _this = this;
        this.monitoringService.getDatabaseHealth().subscribe(function (res) {
            _this.dbHealth = _model_monitoring_actuator_ActuatorDbHealth__WEBPACK_IMPORTED_MODULE_5__["ActuatorDbHealth"].fromJson(res);
        }, function (error) {
            _this.dbHealth = _model_monitoring_actuator_ActuatorDbHealth__WEBPACK_IMPORTED_MODULE_5__["ActuatorDbHealth"].fromJson(error.error);
        });
    };
    DashboardComponent.prototype.getElasticsearchHealth = function () {
        var _this = this;
        this.monitoringService.getElasticsearchHealth().subscribe(function (res) {
            _this.elasticsearchHealth = _model_monitoring_actuator_ActuatorElasticsearchHealth__WEBPACK_IMPORTED_MODULE_6__["ActuatorElasticsearchHealth"].fromJson(res);
        }, function (error) {
            _this.elasticsearchHealth = _model_monitoring_actuator_ActuatorElasticsearchHealth__WEBPACK_IMPORTED_MODULE_6__["ActuatorElasticsearchHealth"].fromJson(error.error);
        });
    };
    DashboardComponent.prototype.getLogFile = function () {
        var _this = this;
        this.monitoringService.getServerLogFile().subscribe(function (res) {
            _this.logFile = res;
        });
    };
    DashboardComponent.prototype.getJvmMemoryUsed = function () {
        var _this = this;
        this.monitoringService.getJvmMemoryUsed().subscribe(function (res) {
            _this.jvmMemoryUsed = _model_monitoring_actuator_ActuatorBasicResponse__WEBPACK_IMPORTED_MODULE_4__["ActuatorBasicResponse"].fromJson(res);
        });
    };
    DashboardComponent.prototype.getJvmMemoryMax = function () {
        var _this = this;
        this.monitoringService.getJvmMemoryMax().subscribe(function (res) {
            _this.jvmMemoryMax = _model_monitoring_actuator_ActuatorBasicResponse__WEBPACK_IMPORTED_MODULE_4__["ActuatorBasicResponse"].fromJson(res);
            _this.memoryUsageWarningLimit = Number(_this.jvmMemoryMax.values[0]) * 0.85;
        });
    };
    DashboardComponent.prototype.getJvmThreadsLive = function () {
        var _this = this;
        this.monitoringService.getJvmThreadsLive().subscribe(function (res) {
            _this.jvmThreadLive = _model_monitoring_actuator_ActuatorBasicResponse__WEBPACK_IMPORTED_MODULE_4__["ActuatorBasicResponse"].fromJson(res);
        });
    };
    DashboardComponent.prototype.getCpuUsage = function () {
        var _this = this;
        this.monitoringService.getCpuUsage().subscribe(function (res) {
            _this.cpuUsage = _model_monitoring_actuator_ActuatorBasicResponse__WEBPACK_IMPORTED_MODULE_4__["ActuatorBasicResponse"].fromJson(res);
        });
    };
    DashboardComponent.prototype.getSystemCpuCount = function () {
        var _this = this;
        this.monitoringService.getSystemCpuCount().subscribe(function (res) {
            _this.cpuSystemCount = _model_monitoring_actuator_ActuatorBasicResponse__WEBPACK_IMPORTED_MODULE_4__["ActuatorBasicResponse"].fromJson(res);
        });
    };
    DashboardComponent.prototype.getElasticsearchStatus = function () {
        var status;
        if (this.elasticsearchHealth.elasticsearchStatus == 'yellow') {
            status = 'Y';
        }
        else if (this.elasticsearchHealth.elasticsearchStatus == 'green') {
            status = 'G';
        }
        else {
            status = 'R';
        }
        return status;
    };
    DashboardComponent.prototype.getPercentOfCpuUsage = function () {
        return (Number(this.cpuUsage.values[0]) * 100).toFixed(2);
    };
    DashboardComponent.prototype.getPercentOfMemoryUsed = function () {
        return (((Number(this.jvmMemoryUsed.values[0]) / 1000000) / (Number(this.jvmMemoryMax.values[0]) / 1000000)) * 100).toFixed(2);
    };
    DashboardComponent.prototype.getMemoryUsedInMb = function () {
        return (Number(this.jvmMemoryUsed.values[0]) / 1000000).toFixed(0);
    };
    DashboardComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-dashboard',
            template: __webpack_require__(/*! ./dashboard.component.html */ "./src/app/monitoring/dashboard/dashboard.component.html"),
            styles: [__webpack_require__(/*! ./dashboard.component.css */ "./src/app/monitoring/dashboard/dashboard.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_service_monitoring_service__WEBPACK_IMPORTED_MODULE_3__["MonitoringService"]])
    ], DashboardComponent);
    return DashboardComponent;
}());



/***/ }),

/***/ "./src/app/order-panel/list-order-item/list-order-item.component.css":
/*!***************************************************************************!*\
  !*** ./src/app/order-panel/list-order-item/list-order-item.component.css ***!
  \***************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".table tr.active td {\r\n    background-color:#275e94 !important;\r\n    color: white;\r\n    font-weight: bold;\r\n    white-space: nowrap;\r\n  }\r\n\r\n.table table-striped tr td {\r\n  padding: 1.5%;\r\n}\r\n\r\n/* Scroll Bar Aggregated Order Item table */\r\n\r\n.my-custom-scrollbar {\r\n  position: relative;\r\n  max-height: 450px;\r\n  overflow: auto;\r\n}\r\n\r\n.table-wrapper-scroll-y {\r\n  display: block;\r\n}\r\n\r\n\r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvb3JkZXItcGFuZWwvbGlzdC1vcmRlci1pdGVtL2xpc3Qtb3JkZXItaXRlbS5jb21wb25lbnQuY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBO0lBQ0ksbUNBQW1DO0lBQ25DLFlBQVk7SUFDWixpQkFBaUI7SUFDakIsbUJBQW1CO0VBQ3JCOztBQUVGO0VBQ0UsYUFBYTtBQUNmOztBQUVBLDJDQUEyQzs7QUFDM0M7RUFDRSxrQkFBa0I7RUFDbEIsaUJBQWlCO0VBQ2pCLGNBQWM7QUFDaEI7O0FBRUE7RUFDRSxjQUFjO0FBQ2hCIiwiZmlsZSI6InNyYy9hcHAvb3JkZXItcGFuZWwvbGlzdC1vcmRlci1pdGVtL2xpc3Qtb3JkZXItaXRlbS5jb21wb25lbnQuY3NzIiwic291cmNlc0NvbnRlbnQiOlsiLnRhYmxlIHRyLmFjdGl2ZSB0ZCB7XHJcbiAgICBiYWNrZ3JvdW5kLWNvbG9yOiMyNzVlOTQgIWltcG9ydGFudDtcclxuICAgIGNvbG9yOiB3aGl0ZTtcclxuICAgIGZvbnQtd2VpZ2h0OiBib2xkO1xyXG4gICAgd2hpdGUtc3BhY2U6IG5vd3JhcDtcclxuICB9XHJcblxyXG4udGFibGUgdGFibGUtc3RyaXBlZCB0ciB0ZCB7XHJcbiAgcGFkZGluZzogMS41JTtcclxufVxyXG5cclxuLyogU2Nyb2xsIEJhciBBZ2dyZWdhdGVkIE9yZGVyIEl0ZW0gdGFibGUgKi9cclxuLm15LWN1c3RvbS1zY3JvbGxiYXIge1xyXG4gIHBvc2l0aW9uOiByZWxhdGl2ZTtcclxuICBtYXgtaGVpZ2h0OiA0NTBweDtcclxuICBvdmVyZmxvdzogYXV0bztcclxufVxyXG5cclxuLnRhYmxlLXdyYXBwZXItc2Nyb2xsLXkge1xyXG4gIGRpc3BsYXk6IGJsb2NrO1xyXG59XHJcblxyXG4iXX0= */"

/***/ }),

/***/ "./src/app/order-panel/list-order-item/list-order-item.component.html":
/*!****************************************************************************!*\
  !*** ./src/app/order-panel/list-order-item/list-order-item.component.html ***!
  \****************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"table-responsive table-wrapper-scroll-y my-custom-scrollbar\">\r\n  <table class=\"table table-striped table-hover\">\r\n    <thead>\r\n      <tr>\r\n        <th>#</th>\r\n        <th>Name</th>\r\n        <th>Price</th>\r\n        <th>Qty</th>\r\n        <th>Total Price</th>\r\n        <th>Last Modified Date</th>\r\n        <th></th>\r\n      </tr>\r\n    </thead>\r\n    <tbody>\r\n      <tr *ngFor=\"let item of orderItems | filter : 'name' : searchString; let i = index\"\r\n      (click)=\"setSelectedRow(i); onClickShowSelectedOrderItems(item.orderItems)\"\r\n        [class.active]=\"i == selectedRow\">\r\n        <td>{{ i+1 }}</td>\r\n        <td>{{ item.product.name }}</td>\r\n        <td>{{ item.product.price }} €</td>\r\n        <td\r\n          contenteditable=\"order.status !== 'CLOSED'\"\r\n          (blur)=\"onChangeOrderItemQuantity(item, $event)\">\r\n          {{ item.quantity }}\r\n        </td>\r\n        <td>{{ item.ttlPrice }} €</td>\r\n        <td>{{ item.lastModifiedDatetime | date:'medium' }}</td>\r\n        <td>\r\n          <button *ngIf=\"order.status !== 'CLOSED'\"\r\n          (click)=\"onClickDeleteOrderItemButton(i, item.orderItems)\"\r\n          [disabled]=\"deleteOrderItemInProgressArray[i]\"\r\n          class=\"btn btn-danger btn-sm\">\r\n              <span *ngIf=\"deleteOrderItemInProgressArray[i]\" class=\"spinner-border spinner-border-sm\" role=\"status\" aria-hidden=\"true\"></span>\r\n            Delete</button>\r\n        </td>\r\n      </tr>\r\n    </tbody>\r\n  </table>\r\n</div>\r\n<br>\r\n<selected-order-items-list\r\n  [selectedOrderItems]=\"selectedOrderItems\"\r\n  [order]=\"order\"\r\n  (onDeleteOrderItemEvent)=\"deleteSingleOrderItem($event)\"\r\n></selected-order-items-list>\r\n"

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
        this.onCreateOrderItemEvent = new _angular_core__WEBPACK_IMPORTED_MODULE_1__["EventEmitter"]();
        this.onChangeOrderItemEvent = new _angular_core__WEBPACK_IMPORTED_MODULE_1__["EventEmitter"]();
        this.onDeleteOrderItemEvent = new _angular_core__WEBPACK_IMPORTED_MODULE_1__["EventEmitter"]();
        this.areNewOrderItemFieldsSet = false;
        this.selectedOrderItems = new Map();
        this.productNames = [];
        this.deleteOrderItemInProgressArray = [];
        this.productIdMapByName = new Map();
        this.search = function (text$) {
            return text$.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_6__["debounceTime"])(200), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_6__["distinctUntilChanged"])(), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_6__["map"])(function (term) { return term.length < 1 ? []
                : _this.productNames.filter(function (v) { return v.toLowerCase().indexOf(term.toLowerCase()) > -1; }).slice(0, 10); }));
        };
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

module.exports = "/* Scroll Bar Aggregated Order Item table */\r\n.my-custom-scrollbar {\r\n    position: relative;\r\n    max-height: 200px;\r\n    overflow: auto;\r\n  }\r\n.table-wrapper-scroll-y {\r\n    display: block;\r\n  }\r\n  \r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvb3JkZXItcGFuZWwvc2VsZWN0ZWQtb3JkZXItaXRlbXMtbGlzdC9zZWxlY3RlZC1vcmRlci1pdGVtcy1saXN0LmNvbXBvbmVudC5jc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUEsMkNBQTJDO0FBQzNDO0lBQ0ksa0JBQWtCO0lBQ2xCLGlCQUFpQjtJQUNqQixjQUFjO0VBQ2hCO0FBRUE7SUFDRSxjQUFjO0VBQ2hCIiwiZmlsZSI6InNyYy9hcHAvb3JkZXItcGFuZWwvc2VsZWN0ZWQtb3JkZXItaXRlbXMtbGlzdC9zZWxlY3RlZC1vcmRlci1pdGVtcy1saXN0LmNvbXBvbmVudC5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyIvKiBTY3JvbGwgQmFyIEFnZ3JlZ2F0ZWQgT3JkZXIgSXRlbSB0YWJsZSAqL1xyXG4ubXktY3VzdG9tLXNjcm9sbGJhciB7XHJcbiAgICBwb3NpdGlvbjogcmVsYXRpdmU7XHJcbiAgICBtYXgtaGVpZ2h0OiAyMDBweDtcclxuICAgIG92ZXJmbG93OiBhdXRvO1xyXG4gIH1cclxuICBcclxuICAudGFibGUtd3JhcHBlci1zY3JvbGwteSB7XHJcbiAgICBkaXNwbGF5OiBibG9jaztcclxuICB9XHJcbiAgIl19 */"

/***/ }),

/***/ "./src/app/order-panel/selected-order-items-list/selected-order-items-list.component.html":
/*!************************************************************************************************!*\
  !*** ./src/app/order-panel/selected-order-items-list/selected-order-items-list.component.html ***!
  \************************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"table-responsive table-wrapper-scroll-y my-custom-scrollbar\">\r\n  <table class=\"table table-striped table-hover table-sm\">\r\n    <thead>\r\n      <tr>\r\n        <th>#</th>\r\n        <th>Id</th>\r\n        <th>BarCode</th>\r\n        <th>Created Date</th>\r\n        <th>Last Modified Date</th>\r\n        <th></th>\r\n      </tr>\r\n    </thead>\r\n    <tbody>\r\n      <tr *ngFor=\"let item of selectedOrderItems.values(); let i = index\">\r\n        <td>{{ i+1 }}</td>\r\n        <td>{{ item.productItem.id }}</td>\r\n        <td>{{ item.productItem.barCode }}</td>\r\n        <td>{{ item.createdDatetime }}</td>\r\n        <td>{{ item.lastModifiedDatetime }}</td>\r\n        <td>\r\n          <button\r\n          (click)=\"onClickDeleteOrderItemButton(i, item)\"\r\n          [disabled]=\"deleteOrderItemInProgressArray[i]\"\r\n          class=\"btn btn-danger btn-sm\">\r\n          <span *ngIf=\"deleteOrderItemInProgressArray[i]\" class=\"spinner-border spinner-border-sm\" role=\"status\" aria-hidden=\"true\"></span>\r\n            Delete</button>\r\n        </td>\r\n      </tr>\r\n    </tbody>\r\n  </table>\r\n</div>"

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

module.exports = "<div class=\"container-fluid\">\r\n  <div class=\"row\">\r\n    <div class=\"col\">\r\n      <h5>{{ order.name }}</h5>\r\n    </div>\r\n    <div class=\"col\">\r\n      <p>Comment : {{ order.comment }}</p>\r\n    </div>\r\n    <div class=\"col\">\r\n      <div style=\"overflow: hidden;\">\r\n        <p style=\"float: left\">Customer : &nbsp;</p>\r\n        <p style=\"float: left; font-weight: bold\"> {{ order.customer.store.name }}</p>\r\n      </div>\r\n    </div>\r\n    <div class=\"col\">\r\n      <div style=\"overflow: hidden;\">\r\n        <p style=\"float: left;\">Status :&nbsp;</p>\r\n        <p style=\"float: left; font-weight: bold\"> {{ order.status }}</p>\r\n      </div>\r\n    </div>\r\n  </div>\r\n  <div class=\"row\">\r\n    <div class=\"col\">\r\n      <div class=\"row justify-content-between\">\r\n          <div class=\"col-4\">\r\n              <button\r\n                class=\"btn btn-outline-primary\"\r\n                (click)=\"onClickAddOrderItem()\"\r\n                [disabled]=\"order.status === 'CLOSED'\"\r\n              >Add Order Item</button>\r\n          </div>\r\n          <div class=\"col-4\">\r\n              <button\r\n                style=\"float: right\"\r\n                class=\"btn btn-outline-info\"\r\n                (click)=\"onClickCloseOrder()\"\r\n                [disabled]=\"order.status === 'CLOSED'\"\r\n              >Close the order</button>\r\n          </div>\r\n      </div>\r\n    </div>\r\n  </div>    \r\n  <br>\r\n</div>"

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
        modalRef.componentInstance.addOrderItemEvent.subscribe(function ($e) {
            _this.onAddOrderItemEvent.emit();
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

module.exports = "<div>\r\n  <show-order-header\r\n    [order]=\"order\"\r\n    (onCloseOrderEvent)=\"onCloseOrder()\"\r\n    (onAddOrderItemEvent)=\"onOrderItemAdded()\"\r\n  ></show-order-header>\r\n  <div class=\"card w-100 shadow-sm p-3 mb-5 bg-white rounded\">\r\n    <list-order-item *ngIf=\"order\"\r\n      [order]=\"order\"\r\n      [orderItems]=\"order.aggregatedOrderItems.values()\"\r\n      (onCreateOrderItemEvent)=\"onNewOrderItem($event)\"\r\n      (onChangeOrderItemEvent)=\"onChangeOrderItem($event)\"\r\n      (onDeleteOrderItemEvent)=\"onDeleteOrderItem($event)\"\r\n    ></list-order-item>\r\n  </div>\r\n  <div class=\"container=fluid\">\r\n    <button class=\"btn btn-primary\"\r\n        (click)=\"onClickBack()\"\r\n        style=\"float: right\"\r\n    >Back</button>\r\n  </div>\r\n</div>"

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
        this.router.navigate(['/orders']);
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

module.exports = "<div class=\"table-responsive\">\r\n    <table class=\"table table-striped\">\r\n        <thead>\r\n            <tr>\r\n                <th>ID</th>\r\n                <th>Name</th>\r\n                <th>Store</th>\r\n                <th>Status</th>\r\n                <th>Total Product</th>\r\n                <th>Total Qty</th>\r\n                <th>Total Price</th>\r\n                <th>Creation Date</th>\r\n                <th>Last Modified Date</th>\r\n                <th>Close Date</th>\r\n                <th></th>\r\n                <th></th>\r\n            </tr>\r\n        </thead>\r\n        <tbody>\r\n            <tr *ngFor=\"let order of ordersArray\">\r\n                <td>{{ order.id }}</td>\r\n                <td>{{ order.name }}</td>\r\n                <td>{{ order.customer.store.name }}</td>\r\n                <td>{{ order.status }}</td>\r\n                <td>{{ order.aggregatedOrderInfo.productSize }}</td>\r\n                <td>{{ order.aggregatedOrderInfo.orderItemSize }}</td>\r\n                <td>{{ order.aggregatedOrderInfo.totalPrice }} €</td>\r\n                <td>{{ order.createdDatetime  | date:'medium' }}</td>\r\n                <td>{{ order.lastModifiedDatetime  | date:'medium' }}</td>\r\n                <td>{{ order.closeDatetime  | date:'medium' }}</td>\r\n                <td><button\r\n                    class=\"btn btn-success\"\r\n                    [routerLink]=\"['/order', order.id]\"\r\n                    >See</button>\r\n                </td>\r\n                <td><button\r\n                    *ngIf=\"order.status !== 'CLOSED'\"\r\n                    class=\"btn btn-info\"\r\n                    (click)=\"onClickCloseOrder(order)\"\r\n                    >Close Order</button>\r\n                    <button\r\n                        *ngIf=\"order.status === 'CLOSED'\"\r\n                        class=\"btn btn-primary\"\r\n                        (click)=\"onClickNotify(order)\"\r\n                    >Notify</button>\r\n                </td>\r\n            </tr>\r\n        </tbody>\r\n    </table>\r\n</div>\r\n<div class=\"row justify-content-between\">\r\n    <div class=\"col-4\">\r\n        <ngb-pagination [collectionSize]=\"collectionSize\" [(page)]=\"page\" [pageSize]=\"pageSize\"></ngb-pagination>\r\n    </div>\r\n    <div class=\"col-2\">\r\n        <select class=\"custom-select\" [(ngModel)]=\"pageSize\">\r\n            <option [ngValue]=\"5\">5 items per page</option>\r\n            <option [ngValue]=\"10\">10 items per page</option>\r\n            <option [ngValue]=\"20\">20 items per page</option>\r\n        </select>\r\n    </div>\r\n</div>\r\n"

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
/* harmony import */ var src_app_common_components_modal_builder__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! src/app/common-components/modal-builder */ "./src/app/common-components/modal-builder.ts");
/* harmony import */ var src_app_modal_confirm_modal_confirm_modal_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! src/app/modal/confirm-modal/confirm-modal-component */ "./src/app/modal/confirm-modal/confirm-modal-component.ts");
/* harmony import */ var src_app_modal_order_notification_modal_order_notification_modal_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! src/app/modal/order-notification-modal/order-notification-modal.component */ "./src/app/modal/order-notification-modal/order-notification-modal.component.ts");






var ListOrdersComponent = /** @class */ (function () {
    function ListOrdersComponent(orderService, modalBuilder) {
        this.orderService = orderService;
        this.modalBuilder = modalBuilder;
        this.page = 1;
        this.pageSize = 10;
    }
    ListOrdersComponent.prototype.ngOnInit = function () {
        this.collectionSize = this.orders.length;
    };
    ListOrdersComponent.prototype.onClickCloseOrder = function (orderToClose) {
        var _this = this;
        var modalRef = this.modalBuilder.open(src_app_modal_confirm_modal_confirm_modal_component__WEBPACK_IMPORTED_MODULE_4__["ConfirmModalComponent"]);
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
        var modalRef = this.modalBuilder.open(src_app_modal_order_notification_modal_order_notification_modal_component__WEBPACK_IMPORTED_MODULE_5__["OrderNotificationModalComponent"]);
        modalRef.componentInstance.orderId = order.id;
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
            src_app_common_components_modal_builder__WEBPACK_IMPORTED_MODULE_3__["ModalBuilder"]])
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

module.exports = "<div class=\"content-fluid\">\r\n    <div class=\"row justify-content-between\">\r\n        <div class=\"col-4\">\r\n            <button class=\"btn btn-primary\"\r\n                (click)=\"openCreateReportModal()\"\r\n            >New Order</button>\r\n        </div>\r\n        <div class=\"col-6\">\r\n            <div class=\"row justify-content-end\">\r\n                <div class=\"col-6\">\r\n                    <input #searchString type=\"search\"\r\n                        class=\"form-control\"\r\n                        (keyup.enter)=\"onClickSearch(searchString.value)\"\r\n                        placeholder=\"Type to search order...\">\r\n                </div>\r\n                <div class=\"col-4\">\r\n                    <button\r\n                        [disabled]=\"searchButtonDisabled\"\r\n                        class=\"btn btn-info search_button\"\r\n                        (click)=\"onClickSearch(searchString.value)\"\r\n                    >Search</button>\r\n                </div>\r\n            </div>\r\n        </div>\r\n    </div>\r\n    <br>\r\n    <h3 style=\"color: dimgray\" *ngIf=\"orders.length == 0\">{{ noOrdersFoundMessage }}</h3>\r\n    <div *ngIf=\"orders.length > 0\" class=\"card w-100 shadow-sm p-3 mb-5 bg-white rounded\">\r\n        <list-orders\r\n            [orders]=\"orders\"\r\n        ></list-orders>\r\n    </div>\r\n</div>"

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
            this.searchOrderByIdOrName(value);
        }
        else if (value.length == 0 && this.isOrderListFiltered) {
            this.searchButtonDisabled = true;
            this.getAllOrders();
            this.isOrderListFiltered = false;
        }
    };
    OrdersManagerComponent.prototype.searchOrderByIdOrName = function (name) {
        var _this = this;
        this.orderService.searchOrderByIdOrName(name).subscribe(function (data) {
            _this.orders = _this.parseOrderIntoArray(data);
            _this.searchButtonDisabled = false;
        }, function (error) {
            console.log("error in search : " + error);
            _this.orders = [];
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

/***/ "./src/app/product/products-panel/products-panel.component.css":
/*!*********************************************************************!*\
  !*** ./src/app/product/products-panel/products-panel.component.css ***!
  \*********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL3Byb2R1Y3QvcHJvZHVjdHMtcGFuZWwvcHJvZHVjdHMtcGFuZWwuY29tcG9uZW50LmNzcyJ9 */"

/***/ }),

/***/ "./src/app/product/products-panel/products-panel.component.html":
/*!**********************************************************************!*\
  !*** ./src/app/product/products-panel/products-panel.component.html ***!
  \**********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container\">\r\n  <upload-product-file-modal></upload-product-file-modal>\r\n</div>"

/***/ }),

/***/ "./src/app/product/products-panel/products-panel.component.ts":
/*!********************************************************************!*\
  !*** ./src/app/product/products-panel/products-panel.component.ts ***!
  \********************************************************************/
/*! exports provided: ProductsPanelComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ProductsPanelComponent", function() { return ProductsPanelComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");


var ProductsPanelComponent = /** @class */ (function () {
    function ProductsPanelComponent() {
    }
    ProductsPanelComponent.prototype.ngOnInit = function () {
    };
    ProductsPanelComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'products-panel',
            template: __webpack_require__(/*! ./products-panel.component.html */ "./src/app/product/products-panel/products-panel.component.html"),
            styles: [__webpack_require__(/*! ./products-panel.component.css */ "./src/app/product/products-panel/products-panel.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [])
    ], ProductsPanelComponent);
    return ProductsPanelComponent;
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
    CustomerService.prototype.updateCustomer = function (req) {
        return this.http.post(this.url + "/update", req);
    };
    CustomerService.prototype.getCustomer = function (id) {
        return this.http.get(this.url + "/get/" + id);
    };
    CustomerService.prototype.getStoresOfOwner = function (ownerId) {
        return this.http.get(this.url + "/storesOfOwner/" + ownerId);
    };
    CustomerService.prototype.getAllCustomers = function () {
        return this.http.get(this.url + "/all");
    };
    CustomerService.prototype.getAllCustomersNoLimit = function () {
        return this.http.get(this.url + "/allNoLimit");
    };
    CustomerService.prototype.searchCustomerByIdOrNames = function (input) {
        return this.http.get(this.url + "/searchByIdOrName/" + input);
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
    HttpService.prototype.get = function (url, options) {
        return this.http.get(url, options);
    };
    HttpService.prototype.post = function (url, body, options) {
        var req = this.http.post(url, body, options != null ? options : this.getHeaders());
        return req;
    };
    HttpService.prototype.delete = function (url) {
        return this.http.delete(url, this.getHeaders());
    };
    HttpService.prototype.put = function (url) {
        return this.http.put(url, this.getHeaders());
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

/***/ "./src/app/service/login-service.ts":
/*!******************************************!*\
  !*** ./src/app/service/login-service.ts ***!
  \******************************************/
/*! exports provided: LoginService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "LoginService", function() { return LoginService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _http_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./http-service */ "./src/app/service/http-service.ts");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");





var LoginService = /** @class */ (function () {
    function LoginService(httpApi) {
        this.httpApi = httpApi;
        this.userLogged = new rxjs__WEBPACK_IMPORTED_MODULE_4__["BehaviorSubject"](false);
    }
    LoginService.prototype.authenticate = function (req) {
        var httpHeaders = new _angular_common_http__WEBPACK_IMPORTED_MODULE_3__["HttpHeaders"]()
            .set('Content-Type', 'application/json')
            .set('Authorization', 'Basic ' + btoa(req.username + ':' + req.password));
        var options = {
            headers: httpHeaders
        };
        return this.httpApi.get("/user", options);
    };
    LoginService.prototype.logout = function () {
        window.sessionStorage.removeItem('username');
        return this.httpApi.get("/logout");
    };
    LoginService.prototype.isUserLoggedIn = function () {
        return sessionStorage.getItem('username') != null;
    };
    LoginService.prototype.setUserLoggedIn = function (isLogged, username) {
        window.sessionStorage.setItem('username', username);
        this.userLogged.next(isLogged);
    };
    LoginService.prototype.getUserLoggedObservable = function () {
        return this.userLogged.asObservable();
    };
    LoginService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_http_service__WEBPACK_IMPORTED_MODULE_2__["HttpService"]])
    ], LoginService);
    return LoginService;
}());



/***/ }),

/***/ "./src/app/service/monitoring-service.ts":
/*!***********************************************!*\
  !*** ./src/app/service/monitoring-service.ts ***!
  \***********************************************/
/*! exports provided: MonitoringService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "MonitoringService", function() { return MonitoringService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _http_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./http-service */ "./src/app/service/http-service.ts");



var MonitoringService = /** @class */ (function () {
    function MonitoringService(httpApi) {
        this.httpApi = httpApi;
        this.ACTUATOR_URL = 'actuator/';
        this.ACTUATOR_METRICS_URL = this.ACTUATOR_URL + 'metrics/';
        this.ACTUATOR_HEALTH_URL = this.ACTUATOR_URL + 'health/';
    }
    MonitoringService.prototype.getCpuUsage = function () {
        return this.httpApi.get(this.ACTUATOR_METRICS_URL + 'process.cpu.usage');
    };
    MonitoringService.prototype.getSystemCpuCount = function () {
        return this.httpApi.get(this.ACTUATOR_METRICS_URL + 'system.cpu.count');
    };
    MonitoringService.prototype.getJvmThreadsLive = function () {
        return this.httpApi.get(this.ACTUATOR_METRICS_URL + 'jvm.threads.live');
    };
    MonitoringService.prototype.getJvmMemoryUsed = function () {
        return this.httpApi.get(this.ACTUATOR_METRICS_URL + 'jvm.memory.used');
    };
    MonitoringService.prototype.getJvmMemoryMax = function () {
        return this.httpApi.get(this.ACTUATOR_METRICS_URL + 'jvm.memory.max');
    };
    MonitoringService.prototype.getElasticsearchHealth = function () {
        return this.httpApi.get(this.ACTUATOR_HEALTH_URL + 'elasticsearchRest');
    };
    MonitoringService.prototype.getDatabaseHealth = function () {
        return this.httpApi.get(this.ACTUATOR_HEALTH_URL + 'db');
    };
    MonitoringService.prototype.getServerLogFile = function () {
        var options = {
            responseType: 'text'
        };
        return this.httpApi.get(this.ACTUATOR_URL + 'logfile', options);
    };
    MonitoringService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_http_service__WEBPACK_IMPORTED_MODULE_2__["HttpService"]])
    ], MonitoringService);
    return MonitoringService;
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
        this.url = "v1/notification";
    }
    NotificationService.prototype.notify = function (req) {
        var options = {
            responseType: 'blob',
            observe: 'response'
        };
        return this.httpApi.post(this.url + "/notify", req, options);
    };
    NotificationService.prototype.getDocumentTypes = function () {
        return this.httpApi.get(this.url + "/document-types");
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
    OrderService.prototype.searchOrderByIdOrName = function (input) {
        console.log("Search orders by input : " + input);
        return this.httpApi.get("/v1/order/searchByIdOrName/" + input);
    };
    OrderService.prototype.getOrdersOfCustomer = function (id) {
        console.log("Get orders of customer " + id);
        return this.httpApi.get("/v1/order/ordersOfCustomer/" + id);
    };
    OrderService.prototype.getOrdersOfStore = function (id) {
        console.log("Get orders of store " + id);
        return this.httpApi.get("/v1/order/ordersOfStore/" + id);
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

/***/ "./src/app/service/orders-statistic-service.ts":
/*!*****************************************************!*\
  !*** ./src/app/service/orders-statistic-service.ts ***!
  \*****************************************************/
/*! exports provided: OrdersStatisticService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "OrdersStatisticService", function() { return OrdersStatisticService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _http_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./http-service */ "./src/app/service/http-service.ts");



var OrdersStatisticService = /** @class */ (function () {
    function OrdersStatisticService(httpApi) {
        this.httpApi = httpApi;
        this.ORDERS_STATISTIC_URL = "/v1/os";
    }
    OrdersStatisticService.prototype.getOpenClosedOrdersOfStore = function (storeId) {
        return this.httpApi.get(this.ORDERS_STATISTIC_URL + "/openClosedByStore/" + storeId);
    };
    OrdersStatisticService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_http_service__WEBPACK_IMPORTED_MODULE_2__["HttpService"]])
    ], OrdersStatisticService);
    return OrdersStatisticService;
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
    ProductService.prototype.confirmProductItemFileUpload = function (uploadId) {
        return this.http.put("/v1/productItemFileUpload/upload-confirm/" + uploadId);
    };
    ProductService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_http_service__WEBPACK_IMPORTED_MODULE_2__["HttpService"]])
    ], ProductService);
    return ProductService;
}());



/***/ }),

/***/ "./src/app/service/store-service.ts":
/*!******************************************!*\
  !*** ./src/app/service/store-service.ts ***!
  \******************************************/
/*! exports provided: StoreService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "StoreService", function() { return StoreService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _http_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./http-service */ "./src/app/service/http-service.ts");



var StoreService = /** @class */ (function () {
    function StoreService(httpApi) {
        this.httpApi = httpApi;
        this.STORE_URL = '/v1/store';
    }
    StoreService.prototype.get = function (id) {
        return this.httpApi.get(this.STORE_URL + '/get/' + id);
    };
    StoreService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_http_service__WEBPACK_IMPORTED_MODULE_2__["HttpService"]])
    ], StoreService);
    return StoreService;
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

module.exports = __webpack_require__(/*! C:\Users\Yoni Touitou\Documents\projects\Andybrook\andybrook-ui\src\main.ts */"./src/main.ts");


/***/ })

},[[0,"runtime","vendor"]]]);
//# sourceMappingURL=main.js.map