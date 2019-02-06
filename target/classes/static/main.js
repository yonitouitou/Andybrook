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

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJhZG1pbi1wYW5lbC9hZG1pbi1wYW5lbC5jb21wb25lbnQuY3NzIn0= */"

/***/ }),

/***/ "./src/app/admin/admin-panel/admin-panel.component.html":
/*!**************************************************************!*\
  !*** ./src/app/admin/admin-panel/admin-panel.component.html ***!
  \**************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container-fluid\">\n    <form>\n      <div class=\"form-check\">\n        <label class=\"form-check-label\" for=\"exampleCheck1\">Email On Close Report &nbsp;</label>\n        <input type=\"checkbox\" class=\"form-check-input\" [(ngModel)]=\"isEmailOn\">\n      </div>\n      <div class=\"form-group\">\n        <label for=\"exampleInputEmail1\">Email address</label>\n        <input type=\"email\" class=\"form-control\" aria-describedby=\"emailHelp\" placeholder=\"Enter email\">\n      </div>\n      <button type=\"submit\" class=\"btn btn-primary\">Submit</button>\n    </form>\n</div>"

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


var AdminPanelComponent = /** @class */ (function () {
    function AdminPanelComponent() {
    }
    AdminPanelComponent.prototype.ngOnInit = function () {
    };
    AdminPanelComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'admin-panel',
            template: __webpack_require__(/*! ./admin-panel.component.html */ "./src/app/admin/admin-panel/admin-panel.component.html"),
            styles: [__webpack_require__(/*! ./admin-panel.component.css */ "./src/app/admin/admin-panel/admin-panel.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [])
    ], AdminPanelComponent);
    return AdminPanelComponent;
}());



/***/ }),

/***/ "./src/app/app.component.css":
/*!***********************************!*\
  !*** ./src/app/app.component.css ***!
  \***********************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiIuLi9hcHAuY29tcG9uZW50LmNzcyJ9 */"

/***/ }),

/***/ "./src/app/app.component.html":
/*!************************************!*\
  !*** ./src/app/app.component.html ***!
  \************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container-fluid\">\n    <mat-toolbar class=\"mat-elevation-z6\" style=\"background-color: steelblue\">  \n        <mat-toolbar-row>\n            <span>First Rowaaaaaaaa</span>\n        </mat-toolbar-row>\n    </mat-toolbar>\n    <h3></h3>\n\n    <div class=\"row\">\n        <div class=\"col-xs-12 col-sm-10 col-md-8 col-sm-offset-1 col-md-offset-2\">\n            <ul class=\"nav nav-tabs\">\n                <li role=\"presentation\"\n                    routerLinkActive=\"active\"\n                    [routerLinkActiveOptions]=\"{exact: true}\">\n                        <a routerLink=\"/\">Home</a>\n                </li>\n                <li role=\"presentation\" routerLinkActive=\"active\">\n                    <a routerLink=\"/admin\">Admin</a>\n                </li>\n            </ul>\n        </div>\n    </div>\n    <h5></h5>\n    <div class=\"row\">\n        <div class=\"col-xs-12 col-sm-10 col-md-8 col-sm-offset-1 col-md-offset-2\">\n            <router-outlet></router-outlet>\n        </div>\n    </div>\n</div>\n\n"

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
/* harmony import */ var _reports_manager_panel_reports_manager_reports_manager_component__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ./reports-manager-panel/reports-manager/reports-manager.component */ "./src/app/reports-manager-panel/reports-manager/reports-manager.component.ts");
/* harmony import */ var _service_stock_report_service__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! ./service/stock-report-service */ "./src/app/service/stock-report-service.ts");
/* harmony import */ var _stock_report_panel_stock_report_stock_report_component__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! ./stock-report-panel/stock-report/stock-report.component */ "./src/app/stock-report-panel/stock-report/stock-report.component.ts");
/* harmony import */ var _service_http_service__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! ./service/http-service */ "./src/app/service/http-service.ts");
/* harmony import */ var _header_menu_header_menu_component__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! ./header-menu/header-menu.component */ "./src/app/header-menu/header-menu.component.ts");
/* harmony import */ var _stock_report_panel_stock_report_header_stock_report_header_component__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__(/*! ./stock-report-panel/stock-report-header/stock-report-header.component */ "./src/app/stock-report-panel/stock-report-header/stock-report-header.component.ts");
/* harmony import */ var _reports_manager_panel_list_reports_list_reports_component__WEBPACK_IMPORTED_MODULE_17__ = __webpack_require__(/*! ./reports-manager-panel/list-reports/list-reports.component */ "./src/app/reports-manager-panel/list-reports/list-reports.component.ts");
/* harmony import */ var _reports_manager_panel_create_report_modal_create_report_modal_component__WEBPACK_IMPORTED_MODULE_18__ = __webpack_require__(/*! ./reports-manager-panel/create-report-modal/create-report-modal.component */ "./src/app/reports-manager-panel/create-report-modal/create-report-modal.component.ts");
/* harmony import */ var _common_components_modal_builder_component_modalBuilderComponent__WEBPACK_IMPORTED_MODULE_19__ = __webpack_require__(/*! ./common-components/modal-builder-component/modalBuilderComponent */ "./src/app/common-components/modal-builder-component/modalBuilderComponent.ts");
/* harmony import */ var _ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_20__ = __webpack_require__(/*! @ng-bootstrap/ng-bootstrap */ "./node_modules/@ng-bootstrap/ng-bootstrap/fesm5/ng-bootstrap.js");
/* harmony import */ var _admin_admin_panel_admin_panel_component__WEBPACK_IMPORTED_MODULE_21__ = __webpack_require__(/*! ./admin/admin-panel/admin-panel.component */ "./src/app/admin/admin-panel/admin-panel.component.ts");






















var appRoutes = [
    { path: '', component: _reports_manager_panel_reports_manager_reports_manager_component__WEBPACK_IMPORTED_MODULE_11__["ReportsManagerComponent"] },
    { path: 'stockreport/:id', component: _stock_report_panel_stock_report_stock_report_component__WEBPACK_IMPORTED_MODULE_13__["StockReportComponent"] },
    { path: 'admin', component: _admin_admin_panel_admin_panel_component__WEBPACK_IMPORTED_MODULE_21__["AdminPanelComponent"] }
];
var AppModule = /** @class */ (function () {
    function AppModule() {
    }
    AppModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_2__["NgModule"])({
            declarations: [
                _app_component__WEBPACK_IMPORTED_MODULE_9__["AppComponent"],
                _stock_report_panel_list_stock_item_list_stock_item_component__WEBPACK_IMPORTED_MODULE_10__["ListStockItemComponent"],
                _reports_manager_panel_reports_manager_reports_manager_component__WEBPACK_IMPORTED_MODULE_11__["ReportsManagerComponent"],
                _stock_report_panel_stock_report_stock_report_component__WEBPACK_IMPORTED_MODULE_13__["StockReportComponent"],
                _header_menu_header_menu_component__WEBPACK_IMPORTED_MODULE_15__["HeaderMenuComponent"],
                _stock_report_panel_stock_report_header_stock_report_header_component__WEBPACK_IMPORTED_MODULE_16__["StockReportHeaderComponent"],
                _reports_manager_panel_list_reports_list_reports_component__WEBPACK_IMPORTED_MODULE_17__["ListReportsComponent"],
                _reports_manager_panel_create_report_modal_create_report_modal_component__WEBPACK_IMPORTED_MODULE_18__["CreateReportModalComponent"],
                _common_components_modal_builder_component_modalBuilderComponent__WEBPACK_IMPORTED_MODULE_19__["ModalBuilderComponent"],
                _admin_admin_panel_admin_panel_component__WEBPACK_IMPORTED_MODULE_21__["AdminPanelComponent"]
            ],
            entryComponents: [_reports_manager_panel_create_report_modal_create_report_modal_component__WEBPACK_IMPORTED_MODULE_18__["CreateReportModalComponent"]],
            imports: [
                _angular_platform_browser__WEBPACK_IMPORTED_MODULE_1__["BrowserModule"],
                _angular_common_http__WEBPACK_IMPORTED_MODULE_6__["HttpClientModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_3__["FormsModule"],
                _angular_material_toolbar__WEBPACK_IMPORTED_MODULE_5__["MatToolbarModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_4__["MatDialogModule"],
                _angular_platform_browser_animations__WEBPACK_IMPORTED_MODULE_8__["BrowserAnimationsModule"],
                _angular_platform_browser_animations__WEBPACK_IMPORTED_MODULE_8__["NoopAnimationsModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_3__["ReactiveFormsModule"],
                _ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_20__["NgbModule"],
                _angular_router__WEBPACK_IMPORTED_MODULE_7__["RouterModule"].forRoot(appRoutes)
            ],
            providers: [_service_stock_report_service__WEBPACK_IMPORTED_MODULE_12__["StockReportService"], _service_http_service__WEBPACK_IMPORTED_MODULE_14__["HttpService"], _common_components_modal_builder_component_modalBuilderComponent__WEBPACK_IMPORTED_MODULE_19__["ModalBuilderComponent"]],
            bootstrap: [_app_component__WEBPACK_IMPORTED_MODULE_9__["AppComponent"]]
        })
    ], AppModule);
    return AppModule;
}());



/***/ }),

/***/ "./src/app/common-components/modal-builder-component/modal-builder-component.css":
/*!***************************************************************************************!*\
  !*** ./src/app/common-components/modal-builder-component/modal-builder-component.css ***!
  \***************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiIuLi9jb21tb24tY29tcG9uZW50cy9tb2RhbC1idWlsZGVyLWNvbXBvbmVudC9tb2RhbC1idWlsZGVyLWNvbXBvbmVudC5jc3MifQ== */"

/***/ }),

/***/ "./src/app/common-components/modal-builder-component/modal-builder-component.html":
/*!****************************************************************************************!*\
  !*** ./src/app/common-components/modal-builder-component/modal-builder-component.html ***!
  \****************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<p>\n  modal-builder-component works!\n</p>\n"

/***/ }),

/***/ "./src/app/common-components/modal-builder-component/modalBuilderComponent.ts":
/*!************************************************************************************!*\
  !*** ./src/app/common-components/modal-builder-component/modalBuilderComponent.ts ***!
  \************************************************************************************/
/*! exports provided: ModalBuilderComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ModalBuilderComponent", function() { return ModalBuilderComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @ng-bootstrap/ng-bootstrap */ "./node_modules/@ng-bootstrap/ng-bootstrap/fesm5/ng-bootstrap.js");



var ModalBuilderComponent = /** @class */ (function () {
    function ModalBuilderComponent(modalService) {
        this.modalService = modalService;
    }
    ModalBuilderComponent.prototype.open = function (component) {
        var modalRef = this.modalService.open(component);
        modalRef.componentInstance.name = 'World';
    };
    ModalBuilderComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'modal-builder-component',
            template: __webpack_require__(/*! ./modal-builder-component.html */ "./src/app/common-components/modal-builder-component/modal-builder-component.html"),
            styles: [__webpack_require__(/*! ./modal-builder-component.css */ "./src/app/common-components/modal-builder-component/modal-builder-component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_2__["NgbModal"]])
    ], ModalBuilderComponent);
    return ModalBuilderComponent;
}());



/***/ }),

/***/ "./src/app/header-menu/header-menu.component.css":
/*!*******************************************************!*\
  !*** ./src/app/header-menu/header-menu.component.css ***!
  \*******************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiIuLi9oZWFkZXItbWVudS9oZWFkZXItbWVudS5jb21wb25lbnQuY3NzIn0= */"

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

/***/ "./src/app/model/ReportInfo.ts":
/*!*************************************!*\
  !*** ./src/app/model/ReportInfo.ts ***!
  \*************************************/
/*! exports provided: ReportInfo */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ReportInfo", function() { return ReportInfo; });
var ReportInfo = /** @class */ (function () {
    function ReportInfo(id, name, status, nbProduct, createDate, closeDate, comment, totalItemQty, totalPrice) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.nbProduct = nbProduct;
        this.createDate = createDate;
        this.closeDate = closeDate;
        this.comment = comment;
        this.totalItemQty = totalItemQty;
        this.totalPrice = totalPrice;
    }
    return ReportInfo;
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
    function StockItem(id, quantity, product) {
        this.type = Type.GLASSES;
        this.id = id;
        this.quantity = quantity;
        this.product = product;
    }
    return StockItem;
}());



/***/ }),

/***/ "./src/app/model/StockReport.ts":
/*!**************************************!*\
  !*** ./src/app/model/StockReport.ts ***!
  \**************************************/
/*! exports provided: StockReport */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "StockReport", function() { return StockReport; });
var StockReport = /** @class */ (function () {
    function StockReport() {
        this.items = new Map();
    }
    return StockReport;
}());



/***/ }),

/***/ "./src/app/reports-manager-panel/create-report-modal/create-report-modal.component.css":
/*!*********************************************************************************************!*\
  !*** ./src/app/reports-manager-panel/create-report-modal/create-report-modal.component.css ***!
  \*********************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiIuLi9yZXBvcnRzLW1hbmFnZXItcGFuZWwvY3JlYXRlLXJlcG9ydC1tb2RhbC9jcmVhdGUtcmVwb3J0LW1vZGFsLmNvbXBvbmVudC5jc3MifQ== */"

/***/ }),

/***/ "./src/app/reports-manager-panel/create-report-modal/create-report-modal.component.html":
/*!**********************************************************************************************!*\
  !*** ./src/app/reports-manager-panel/create-report-modal/create-report-modal.component.html ***!
  \**********************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"modal-header\">\n  <h4 class=\"modal-title\">Hi there!</h4>\n  <button type=\"button\" class=\"close\" aria-label=\"Close\" (click)=\"activeModal.dismiss('Cross click')\">\n    <span aria-hidden=\"true\">&times;</span>\n  </button>\n</div>\n<div class=\"modal-body\">\n  <p>Hello!</p>\n</div>\n<div class=\"modal-footer\">\n  <button type=\"button\" class=\"btn btn-outline-dark\" (click)=\"activeModal.close('Close click')\">Close</button>\n</div>"

/***/ }),

/***/ "./src/app/reports-manager-panel/create-report-modal/create-report-modal.component.ts":
/*!********************************************************************************************!*\
  !*** ./src/app/reports-manager-panel/create-report-modal/create-report-modal.component.ts ***!
  \********************************************************************************************/
/*! exports provided: CreateReportModalComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "CreateReportModalComponent", function() { return CreateReportModalComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @ng-bootstrap/ng-bootstrap */ "./node_modules/@ng-bootstrap/ng-bootstrap/fesm5/ng-bootstrap.js");



var CreateReportModalComponent = /** @class */ (function () {
    function CreateReportModalComponent(activeModal) {
        this.activeModal = activeModal;
    }
    CreateReportModalComponent.prototype.ngOnInit = function () {
    };
    CreateReportModalComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'create-report-modal',
            template: __webpack_require__(/*! ./create-report-modal.component.html */ "./src/app/reports-manager-panel/create-report-modal/create-report-modal.component.html"),
            styles: [__webpack_require__(/*! ./create-report-modal.component.css */ "./src/app/reports-manager-panel/create-report-modal/create-report-modal.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_2__["NgbActiveModal"]])
    ], CreateReportModalComponent);
    return CreateReportModalComponent;
}());



/***/ }),

/***/ "./src/app/reports-manager-panel/list-reports/list-reports.component.css":
/*!*******************************************************************************!*\
  !*** ./src/app/reports-manager-panel/list-reports/list-reports.component.css ***!
  \*******************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiIuLi9yZXBvcnRzLW1hbmFnZXItcGFuZWwvbGlzdC1yZXBvcnRzL2xpc3QtcmVwb3J0cy5jb21wb25lbnQuY3NzIn0= */"

/***/ }),

/***/ "./src/app/reports-manager-panel/list-reports/list-reports.component.html":
/*!********************************************************************************!*\
  !*** ./src/app/reports-manager-panel/list-reports/list-reports.component.html ***!
  \********************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"col-md-20 user-container\">\n    <table class=\"table table-striped\">\n        <thead>\n            <tr>\n                <th>ID</th>\n                <th>Name</th>\n                <th>Status</th>\n                <th>Total Product</th>\n                <th>Total Qty</th>\n                <th>Total Price</th>\n                <th>Creation Date</th>\n                <th>Close Date</th>\n                <th>Comment</th>\n                <th></th>\n            </tr>\n        </thead>\n        <tbody>\n            <tr *ngFor=\"let report of reports.values()\">\n                <td>{{ report.id }}</td>\n                <td>{{ report.name }}</td>\n                <td>{{ report.status }}</td>\n                <td>{{ report.nbProduct }}</td>\n                <td>{{ report.totalItemQty }}</td>\n                <td>{{ report.totalPrice }} €</td>\n                <td>{{ report.createDate  | date:'medium' }}</td>\n                <td>{{ report.closeDate  | date:'medium' }}</td>\n                <td>{{ report.comment }}</td>\n                <td><button\n                    class=\"btn btn-success\"\n                    [routerLink]=\"['/stockreport', report.id]\"\n                    >See</button>\n                </td>\n            </tr>\n        </tbody>\n    </table>\n</div>"

/***/ }),

/***/ "./src/app/reports-manager-panel/list-reports/list-reports.component.ts":
/*!******************************************************************************!*\
  !*** ./src/app/reports-manager-panel/list-reports/list-reports.component.ts ***!
  \******************************************************************************/
/*! exports provided: ListReportsComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ListReportsComponent", function() { return ListReportsComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");


var ListReportsComponent = /** @class */ (function () {
    function ListReportsComponent() {
    }
    ListReportsComponent.prototype.ngOnInit = function () {
    };
    ListReportsComponent.prototype.onClickSeeReport = function (id) {
    };
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", Map)
    ], ListReportsComponent.prototype, "reports", void 0);
    ListReportsComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'list-reports',
            template: __webpack_require__(/*! ./list-reports.component.html */ "./src/app/reports-manager-panel/list-reports/list-reports.component.html"),
            styles: [__webpack_require__(/*! ./list-reports.component.css */ "./src/app/reports-manager-panel/list-reports/list-reports.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [])
    ], ListReportsComponent);
    return ListReportsComponent;
}());



/***/ }),

/***/ "./src/app/reports-manager-panel/reports-manager/reports-manager.component.css":
/*!*************************************************************************************!*\
  !*** ./src/app/reports-manager-panel/reports-manager/reports-manager.component.css ***!
  \*************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiIuLi9yZXBvcnRzLW1hbmFnZXItcGFuZWwvcmVwb3J0cy1tYW5hZ2VyL3JlcG9ydHMtbWFuYWdlci5jb21wb25lbnQuY3NzIn0= */"

/***/ }),

/***/ "./src/app/reports-manager-panel/reports-manager/reports-manager.component.html":
/*!**************************************************************************************!*\
  !*** ./src/app/reports-manager-panel/reports-manager/reports-manager.component.html ***!
  \**************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n<ng-template #content let-modal>\n    <p>aaa</p>\n</ng-template>\n<div class=\"container-fluid\">\n    <div>\n        <button class=\"btn btn-primary\"\n            (click)=\"openCreateReportModal(content)\"\n        >New Report</button>\n    </div>\n    <list-reports\n        [reports]=\"reports\"\n    ></list-reports>\n</div>"

/***/ }),

/***/ "./src/app/reports-manager-panel/reports-manager/reports-manager.component.ts":
/*!************************************************************************************!*\
  !*** ./src/app/reports-manager-panel/reports-manager/reports-manager.component.ts ***!
  \************************************************************************************/
/*! exports provided: ReportsManagerComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ReportsManagerComponent", function() { return ReportsManagerComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _create_report_modal_create_report_modal_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../create-report-modal/create-report-modal.component */ "./src/app/reports-manager-panel/create-report-modal/create-report-modal.component.ts");
/* harmony import */ var src_app_service_stock_report_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! src/app/service/stock-report-service */ "./src/app/service/stock-report-service.ts");
/* harmony import */ var src_app_common_components_modal_builder_component_modalBuilderComponent__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! src/app/common-components/modal-builder-component/modalBuilderComponent */ "./src/app/common-components/modal-builder-component/modalBuilderComponent.ts");





var ReportsManagerComponent = /** @class */ (function () {
    function ReportsManagerComponent(stockReportService, modalBuilder) {
        this.stockReportService = stockReportService;
        this.modalBuilder = modalBuilder;
        this.reports = new Map();
    }
    ReportsManagerComponent.prototype.ngOnInit = function () {
        this.stockReportService.getAllStockReports(this.reports);
    };
    ReportsManagerComponent.prototype.openCreateReportModal = function () {
        this.modalBuilder.open(_create_report_modal_create_report_modal_component__WEBPACK_IMPORTED_MODULE_2__["CreateReportModalComponent"]);
    };
    ReportsManagerComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'reports-manager',
            template: __webpack_require__(/*! ./reports-manager.component.html */ "./src/app/reports-manager-panel/reports-manager/reports-manager.component.html"),
            styles: [__webpack_require__(/*! ./reports-manager.component.css */ "./src/app/reports-manager-panel/reports-manager/reports-manager.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [src_app_service_stock_report_service__WEBPACK_IMPORTED_MODULE_3__["StockReportService"],
            src_app_common_components_modal_builder_component_modalBuilderComponent__WEBPACK_IMPORTED_MODULE_4__["ModalBuilderComponent"]])
    ], ReportsManagerComponent);
    return ReportsManagerComponent;
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

/***/ "./src/app/service/stock-report-service.ts":
/*!*************************************************!*\
  !*** ./src/app/service/stock-report-service.ts ***!
  \*************************************************/
/*! exports provided: StockReportService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "StockReportService", function() { return StockReportService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _model_StockItem__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../model/StockItem */ "./src/app/model/StockItem.ts");
/* harmony import */ var _model_Product__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../model/Product */ "./src/app/model/Product.ts");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _http_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./http-service */ "./src/app/service/http-service.ts");
/* harmony import */ var _model_ReportInfo__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../model/ReportInfo */ "./src/app/model/ReportInfo.ts");






var StockReportService = /** @class */ (function () {
    function StockReportService(httpApi) {
        this.httpApi = httpApi;
    }
    StockReportService.prototype.getStockReport = function (report, id) {
        console.log("Get report " + id);
        this.httpApi.get("/v1/stockReport/get/" + id).subscribe(function (data) {
            report.id = data.id;
            report.name = data.name;
            report.comment = data.comment;
            report.status = data.status;
            for (var _i = 0, _a = data.items; _i < _a.length; _i++) {
                var item = _a[_i];
                var product = new _model_Product__WEBPACK_IMPORTED_MODULE_2__["Product"](item.product.id, item.product.name, item.product.price);
                var stockItem = new _model_StockItem__WEBPACK_IMPORTED_MODULE_1__["StockItem"](item.id, item.quantity, product);
                report.items.set(stockItem.id, stockItem);
            }
        });
    };
    StockReportService.prototype.addItem = function (report, item) {
        console.log("Add item[ " + ", " + item.quantity + " to report " + report.id);
        var stockItem;
        this.httpApi.post("/v1/stock/update", this.toUpdateRequest(report, item)).subscribe(function (data) {
            var product = new _model_Product__WEBPACK_IMPORTED_MODULE_2__["Product"](data.item.product.id, data.item.product.name, data.item.product.price);
            stockItem = new _model_StockItem__WEBPACK_IMPORTED_MODULE_1__["StockItem"](data.item.id, data.item.quantity, product);
            report.items.set(stockItem.id, stockItem);
        }, function (error) {
            debugger;
            console.log(error);
        });
    };
    StockReportService.prototype.updateStockItem = function (report, itemToUpdate) {
        console.log("update report " + report.id + " | " + itemToUpdate);
        this.httpApi.post("/v1/stock/update", this.toUpdateRequest(report, itemToUpdate)).subscribe(function (data) {
            report.id = data.id;
            report.name = data.name;
            report.comment = data.comment;
            report.status = data.status;
            var product = new _model_Product__WEBPACK_IMPORTED_MODULE_2__["Product"](data.item.product.id, data.item.product.name, data.item.product.price);
            var stockItem = new _model_StockItem__WEBPACK_IMPORTED_MODULE_1__["StockItem"](data.item.id, data.item.quantity, product);
            report.items.set(stockItem.id, stockItem);
        });
    };
    StockReportService.prototype.deleteItem = function (report, stockItemIdToDelete) {
        console.log("Delete Item : " + stockItemIdToDelete);
        this.httpApi.delete("/v1/stock/delete/" + stockItemIdToDelete).subscribe(function (data) {
            console.log(data);
            report.items.delete(stockItemIdToDelete);
        });
    };
    StockReportService.prototype.closeStockReport = function (report) {
        console.log("Close stock report : " + report.id);
        var request = { "id": report.id };
        this.httpApi.post("/v1/stockReport/close", request).subscribe(function (data) {
            report.status = "CLOSED";
        });
    };
    StockReportService.prototype.getAllStockReports = function (reports) {
        var _this = this;
        console.log("Get all reports");
        this.httpApi.get("/v1/stockReport/all").subscribe(function (data) {
            for (var _i = 0, data_1 = data; _i < data_1.length; _i++) {
                var report = data_1[_i];
                var itemsQty = report.items.reduce(function (sum, item) { return sum + item.quantity; }, 0);
                var totalPrice = _this.getTotalPrice(report.items);
                var info = new _model_ReportInfo__WEBPACK_IMPORTED_MODULE_5__["ReportInfo"](report.id, report.name, report.status, report.items.length, report.createdDateTime, report.closeDateTime, report.comment, itemsQty, totalPrice);
                reports.set(info.id, info);
            }
        });
    };
    StockReportService.prototype.getTotalPrice = function (items) {
        var total = 0;
        for (var i = 0; i < items.length; i++) {
            total += items[i].product.price;
        }
        return total;
    };
    StockReportService.prototype.toUpdateRequest = function (report, item) {
        return {
            "stockReportId": report.id,
            "stockItem": item,
            "type": item.type
        };
    };
    StockReportService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_3__["Injectable"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_http_service__WEBPACK_IMPORTED_MODULE_4__["HttpService"]])
    ], StockReportService);
    return StockReportService;
}());



/***/ }),

/***/ "./src/app/stock-report-panel/list-stock-item/list-stock-item.component.css":
/*!**********************************************************************************!*\
  !*** ./src/app/stock-report-panel/list-stock-item/list-stock-item.component.css ***!
  \**********************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".table tr.active td {\n    background-color:#275e94 !important;\n    color: white;\n    font-weight: bold;\n  }\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIi4uL3N0b2NrLXJlcG9ydC1wYW5lbC9saXN0LXN0b2NrLWl0ZW0vbGlzdC1zdG9jay1pdGVtLmNvbXBvbmVudC5jc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUE7SUFDSSxtQ0FBbUM7SUFDbkMsWUFBWTtJQUNaLGlCQUFpQjtFQUNuQiIsImZpbGUiOiIuLi9zdG9jay1yZXBvcnQtcGFuZWwvbGlzdC1zdG9jay1pdGVtL2xpc3Qtc3RvY2staXRlbS5jb21wb25lbnQuY3NzIiwic291cmNlc0NvbnRlbnQiOlsiLnRhYmxlIHRyLmFjdGl2ZSB0ZCB7XG4gICAgYmFja2dyb3VuZC1jb2xvcjojMjc1ZTk0ICFpbXBvcnRhbnQ7XG4gICAgY29sb3I6IHdoaXRlO1xuICAgIGZvbnQtd2VpZ2h0OiBib2xkO1xuICB9Il19 */"

/***/ }),

/***/ "./src/app/stock-report-panel/list-stock-item/list-stock-item.component.html":
/*!***********************************************************************************!*\
  !*** ./src/app/stock-report-panel/list-stock-item/list-stock-item.component.html ***!
  \***********************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"col-md-20 user-container\">\n    <table class=\"table table-striped\">\n        <thead>\n        <tr>\n          <th>ID</th>\n          <th>Name</th>\n          <th>Price</th>\n          <th>Quantity</th>\n          <th></th>\n          <th></th>\n          <th></th>\n        </tr>\n        </thead>\n        <tbody>\n        <tr *ngIf=\"stockReportStatus !== 'CLOSED'\">\n          <td></td>\n          <td>\n            <input class=\"form-control\" (blur)=\"onBlurNewItemInput()\" [(ngModel)]=\"inputName\">\n          </td>\n          <td>\n            <input class=\"form-control\" (blur)=\"onBlurNewItemInput()\" [(ngModel)]=\"inputPrice\">\n          </td>\n          <td>\n            <input class=\"form-control\" (blur)=\"onBlurNewItemInput()\" [(ngModel)]=\"inputQuantity\">\n          </td>\n          <td></td>\n          <td></td>\n          <td>\n            <button\n              class=\"btn btn-info\"\n              [disabled]=\"! areNewStockItemFieldsSet\"\n              (click)=\"createNewStockItem()\"> Add Stock Item</button>\n          </td>\n        </tr>\n        <tr *ngFor=\"let item of stockReportItems; let i = index\" (click)=\"setSelectedRow(i)\" [class.active]=\"i == selectedRow\">\n          <td>{{ item.product.id }}</td>\n          <td contenteditable=\"stockReportStatus !== 'CLOSED'\"\n             (blur)=\"onChangeStockItemName(item, $event)\"\n          >{{ item.product.name }}</td>\n          <td contenteditable=\"stockReportStatus !== 'CLOSED'\"\n              (blur)=\"onChangeStockItemPrice(item, $event)\"\n          >{{ item.product.price }} €</td>\n          <td contenteditable=\"stockReportStatus !== 'CLOSED'\"\n              (blur)=\"onChangeStockItemQuantity(item, $event)\"\n          >{{ item.quantity }}</td>\n          <td></td>\n          <td></td>\n          <td>\n            <button *ngIf=\"stockReportStatus !== 'CLOSED'\" (click)=\"deleteStockItem(item.id)\" class=\"btn btn-danger\"> Delete</button>\n          </td>\n        </tr>\n        </tbody>\n      </table>\n    \n</div>"

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




var ListStockItemComponent = /** @class */ (function () {
    function ListStockItemComponent() {
        this.areNewStockItemFieldsSet = false;
        this.onCreateStockItemEvent = new _angular_core__WEBPACK_IMPORTED_MODULE_1__["EventEmitter"]();
        this.onChangeStockItemEvent = new _angular_core__WEBPACK_IMPORTED_MODULE_1__["EventEmitter"]();
        this.onDeleteStockItemEvent = new _angular_core__WEBPACK_IMPORTED_MODULE_1__["EventEmitter"]();
    }
    ListStockItemComponent.prototype.ngOnInit = function () {
    };
    ListStockItemComponent.prototype.onBlurNewItemInput = function () {
        this.areNewStockItemFieldsSet = this.inputName.trim().length > 0
            && this.inputQuantity >= 0
            && this.inputPrice >= 0;
    };
    ListStockItemComponent.prototype.createNewStockItem = function () {
        var stockItem = new _model_StockItem__WEBPACK_IMPORTED_MODULE_2__["StockItem"](undefined, this.inputQuantity, new _model_Product__WEBPACK_IMPORTED_MODULE_3__["Product"](undefined, this.inputName, this.inputPrice));
        this.onCreateStockItemEvent.emit(stockItem);
        this.resetNewStockitemFields();
    };
    ListStockItemComponent.prototype.deleteStockItem = function (id) {
        this.onDeleteStockItemEvent.emit(id);
    };
    ListStockItemComponent.prototype.onChangeStockItemName = function (stockItem, event) {
        var product = stockItem.product;
        var newName = event.target.textContent;
        if (product.name !== newName) {
            var p = new _model_Product__WEBPACK_IMPORTED_MODULE_3__["Product"](product.id, newName, product.price);
            var item = new _model_StockItem__WEBPACK_IMPORTED_MODULE_2__["StockItem"](stockItem.id, stockItem.quantity, p);
            this.onChangeStockItemEvent.emit(item);
        }
    };
    ListStockItemComponent.prototype.onChangeStockItemQuantity = function (stockItem, event) {
        var newQuantity = event.target.textContent;
        if (stockItem.quantity != newQuantity) {
            var item = new _model_StockItem__WEBPACK_IMPORTED_MODULE_2__["StockItem"](stockItem.id, newQuantity, stockItem.product);
            this.onChangeStockItemEvent.emit(item);
        }
    };
    ListStockItemComponent.prototype.onChangeStockItemPrice = function (stockItem, event) {
        var product = stockItem.product;
        var newPrice = event.target.textContent;
        if (product.price != newPrice) {
            var p = new _model_Product__WEBPACK_IMPORTED_MODULE_3__["Product"](product.id, product.name, newPrice);
            var item = new _model_StockItem__WEBPACK_IMPORTED_MODULE_2__["StockItem"](stockItem.id, stockItem.quantity, p);
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
    ], ListStockItemComponent.prototype, "stockReportItems", void 0);
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", Number)
    ], ListStockItemComponent.prototype, "stockReportId", void 0);
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", String)
    ], ListStockItemComponent.prototype, "stockReportStatus", void 0);
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
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [])
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

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiIuLi9zdG9jay1yZXBvcnQtcGFuZWwvc3RvY2stcmVwb3J0LWhlYWRlci9zdG9jay1yZXBvcnQtaGVhZGVyLmNvbXBvbmVudC5jc3MifQ== */"

/***/ }),

/***/ "./src/app/stock-report-panel/stock-report-header/stock-report-header.component.html":
/*!*******************************************************************************************!*\
  !*** ./src/app/stock-report-panel/stock-report-header/stock-report-header.component.html ***!
  \*******************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"row justify-content-between\">\n  <div class=\"col-4\">\n    <h2>{{ report.name }}</h2>\n    <p>{{ report.comment }}</p>\n    <div style=\"overflow: hidden;\">\n      <p style=\"float: left;\">Status :&nbsp;</p>\n      <p style=\"float: left; font-weight: bold\"> {{ report.status }}</p>\n    </div>\n  </div>\n  <div class=\"col-2\">\n      <button\n        class=\"btn btn-outline-info\"\n        (click)=\"onClickCloseReport()\"\n        [disabled]=\"report.status === 'CLOSED'\"\n      >Close the report</button>\n  </div>\n</div>"

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
/* harmony import */ var _model_StockReport__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../model/StockReport */ "./src/app/model/StockReport.ts");



var StockReportHeaderComponent = /** @class */ (function () {
    function StockReportHeaderComponent() {
        this.onCloseStockReportEvent = new _angular_core__WEBPACK_IMPORTED_MODULE_1__["EventEmitter"]();
    }
    StockReportHeaderComponent.prototype.ngOnInit = function () {
    };
    StockReportHeaderComponent.prototype.onClickCloseReport = function () {
        this.onCloseStockReportEvent.emit();
    };
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", _model_StockReport__WEBPACK_IMPORTED_MODULE_2__["StockReport"])
    ], StockReportHeaderComponent.prototype, "report", void 0);
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Output"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", Object)
    ], StockReportHeaderComponent.prototype, "onCloseStockReportEvent", void 0);
    StockReportHeaderComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'stock-report-header',
            template: __webpack_require__(/*! ./stock-report-header.component.html */ "./src/app/stock-report-panel/stock-report-header/stock-report-header.component.html"),
            styles: [__webpack_require__(/*! ./stock-report-header.component.css */ "./src/app/stock-report-panel/stock-report-header/stock-report-header.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [])
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

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiIuLi9zdG9jay1yZXBvcnQtcGFuZWwvc3RvY2stcmVwb3J0L3N0b2NrLXJlcG9ydC5jb21wb25lbnQuY3NzIn0= */"

/***/ }),

/***/ "./src/app/stock-report-panel/stock-report/stock-report.component.html":
/*!*****************************************************************************!*\
  !*** ./src/app/stock-report-panel/stock-report/stock-report.component.html ***!
  \*****************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div>\n  <stock-report-header\n    [report]=\"report\"\n    (onCloseStockReportEvent)=\"onCloseStockReport()\"\n  ></stock-report-header>\n  <h5></h5>\n  <list-stock-item\n    [stockReportId]=\"reportId\"\n    [stockReportItems]=\"report.items.values()\"\n    [stockReportStatus]=\"report.status\"\n    (onCreateStockItemEvent)=\"onNewStockItem($event)\"\n    (onChangeStockItemEvent)=\"onChangeStockItem($event)\"\n    (onDeleteStockItemEvent)=\"onDeleteStockItem($event)\"\n  ></list-stock-item>\n  <h3></h3>\n  <div class=\"container=fluid\">\n    <button class=\"btn btn-primary\"\n        (click)=\"onClickBack()\"\n        style=\"float: right\"\n    >Back</button>\n</div>\n</div>"

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
/* harmony import */ var _service_stock_report_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../service/stock-report-service */ "./src/app/service/stock-report-service.ts");
/* harmony import */ var _model_StockReport__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../model/StockReport */ "./src/app/model/StockReport.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");





var StockReportComponent = /** @class */ (function () {
    function StockReportComponent(stockReportService, route, router) {
        this.stockReportService = stockReportService;
        this.route = route;
        this.router = router;
        this.reportId = 1;
    }
    StockReportComponent.prototype.ngOnInit = function () {
        this.report = new _model_StockReport__WEBPACK_IMPORTED_MODULE_3__["StockReport"]();
        var stockReportId = parseInt(this.route.snapshot.paramMap.get('id'));
        this.stockReportService.getStockReport(this.report, stockReportId);
        //this.stockReportService.getStockReport(this.report, this.reportId);
    };
    StockReportComponent.prototype.onNewStockItem = function (stockItemToAdd) {
        this.stockReportService.addItem(this.report, stockItemToAdd);
    };
    StockReportComponent.prototype.onChangeStockItem = function (stockItemToUpdate) {
        this.stockReportService.updateStockItem(this.report, stockItemToUpdate);
    };
    StockReportComponent.prototype.onDeleteStockItem = function (id) {
        this.stockReportService.deleteItem(this.report, id);
    };
    StockReportComponent.prototype.onCloseStockReport = function () {
        this.stockReportService.closeStockReport(this.report);
    };
    StockReportComponent.prototype.onClickBack = function () {
        this.router.navigate(['']);
    };
    StockReportComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'stock-report',
            template: __webpack_require__(/*! ./stock-report.component.html */ "./src/app/stock-report-panel/stock-report/stock-report.component.html"),
            styles: [__webpack_require__(/*! ./stock-report.component.css */ "./src/app/stock-report-panel/stock-report/stock-report.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_service_stock_report_service__WEBPACK_IMPORTED_MODULE_2__["StockReportService"],
            _angular_router__WEBPACK_IMPORTED_MODULE_4__["ActivatedRoute"],
            _angular_router__WEBPACK_IMPORTED_MODULE_4__["Router"]])
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