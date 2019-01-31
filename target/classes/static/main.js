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

module.exports = "\n<stock-report></stock-report>\n"

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
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var _app_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./app.component */ "./src/app/app.component.ts");
/* harmony import */ var _list_stock_item_list_stock_item_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./list-stock-item/list-stock-item.component */ "./src/app/list-stock-item/list-stock-item.component.ts");
/* harmony import */ var _reports_manager_reports_manager_component__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./reports-manager/reports-manager.component */ "./src/app/reports-manager/reports-manager.component.ts");
/* harmony import */ var _service_stock_report_service__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ./service/stock-report-service */ "./src/app/service/stock-report-service.ts");
/* harmony import */ var _stock_report_stock_report_component__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ./stock-report/stock-report.component */ "./src/app/stock-report/stock-report.component.ts");
/* harmony import */ var _service_http_service__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ./service/http-service */ "./src/app/service/http-service.ts");











var AppModule = /** @class */ (function () {
    function AppModule() {
    }
    AppModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_2__["NgModule"])({
            declarations: [
                _app_component__WEBPACK_IMPORTED_MODULE_5__["AppComponent"],
                _list_stock_item_list_stock_item_component__WEBPACK_IMPORTED_MODULE_6__["ListStockItemComponent"],
                _reports_manager_reports_manager_component__WEBPACK_IMPORTED_MODULE_7__["ReportsManagerComponent"],
                _stock_report_stock_report_component__WEBPACK_IMPORTED_MODULE_9__["StockReportComponent"]
            ],
            imports: [
                _angular_platform_browser__WEBPACK_IMPORTED_MODULE_1__["BrowserModule"],
                _angular_common_http__WEBPACK_IMPORTED_MODULE_4__["HttpClientModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_3__["FormsModule"]
            ],
            providers: [_service_stock_report_service__WEBPACK_IMPORTED_MODULE_8__["StockReportService"], _service_http_service__WEBPACK_IMPORTED_MODULE_10__["HttpService"]],
            bootstrap: [_app_component__WEBPACK_IMPORTED_MODULE_5__["AppComponent"]]
        })
    ], AppModule);
    return AppModule;
}());



/***/ }),

/***/ "./src/app/list-stock-item/list-stock-item.component.css":
/*!***************************************************************!*\
  !*** ./src/app/list-stock-item/list-stock-item.component.css ***!
  \***************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL2xpc3Qtc3RvY2staXRlbS9saXN0LXN0b2NrLWl0ZW0uY29tcG9uZW50LmNzcyJ9 */"

/***/ }),

/***/ "./src/app/list-stock-item/list-stock-item.component.html":
/*!****************************************************************!*\
  !*** ./src/app/list-stock-item/list-stock-item.component.html ***!
  \****************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"col-md-5 user-container\">\n    <table class=\"table table-striped\">\n        <thead>\n        <tr>\n          <th>ID</th>\n          <th>Name</th>\n          <th>Price</th>\n          <th>Quantity</th>\n          <th></th>\n          <th></th>\n          <th></th>\n        </tr>\n        </thead>\n        <tbody>\n        <tr>\n          <td></td>\n          <td>\n            <input class=\"form-control\" (blur)=\"onBlurNewItemInput()\" [(ngModel)]=\"inputName\">\n          </td>\n          <td>\n            <input class=\"form-control\" (blur)=\"onBlurNewItemInput()\" [(ngModel)]=\"inputPrice\">\n          </td>\n          <td>\n            <input class=\"form-control\" (blur)=\"onBlurNewItemInput()\" [(ngModel)]=\"inputQuantity\">\n          </td>\n          <td></td>\n          <td></td>\n          <td>\n            <button\n              class=\"btn btn-danger\"\n              style=\"width:150px\"\n              [disabled]=\"! areNewStockItemFieldsSet\"\n              (click)=\"createNewStockItem()\"> Add Stock Item</button>\n          </td>\n        </tr>\n        <tr *ngFor=\"let item of stockItems\">\n          <td contenteditable=\"true\">{{ item.id }}</td>\n          <td contenteditable=\"true\">{{ item.product.name }}</td>\n          <td contenteditable=\"true\">{{ item.product.price }}</td>\n          <td contenteditable=\"true\">{{ item.quantity }}</td>\n          <td></td>\n          <td></td>\n          <td><button (click)=\"deleteStockItem(item.id)\" class=\"btn btn-success\"> Delete</button>\n            <button class=\"btn btn-success\" style=\"margin-left: 20px;\"> Edit</button></td>\n        </tr>\n        </tbody>\n      </table>\n    \n</div>"

/***/ }),

/***/ "./src/app/list-stock-item/list-stock-item.component.ts":
/*!**************************************************************!*\
  !*** ./src/app/list-stock-item/list-stock-item.component.ts ***!
  \**************************************************************/
/*! exports provided: ListStockItemComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ListStockItemComponent", function() { return ListStockItemComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _model_StockItem__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../model/StockItem */ "./src/app/model/StockItem.ts");
/* harmony import */ var _service_stock_report_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../service/stock-report-service */ "./src/app/service/stock-report-service.ts");
/* harmony import */ var _model_Product__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../model/Product */ "./src/app/model/Product.ts");





var ListStockItemComponent = /** @class */ (function () {
    function ListStockItemComponent(stockReportService) {
        this.stockReportService = stockReportService;
        this.stockItemArray = [];
        this.areNewStockItemFieldsSet = false;
    }
    ListStockItemComponent.prototype.ngOnInit = function () {
    };
    ListStockItemComponent.prototype.onBlurNewItemInput = function () {
        this.areNewStockItemFieldsSet = this.inputName.trim().length > 0
            && this.inputQuantity >= 0
            && this.inputPrice >= 0;
    };
    ListStockItemComponent.prototype.createNewStockItem = function () {
        var stockItem = new _model_StockItem__WEBPACK_IMPORTED_MODULE_2__["StockItem"](null, this.inputQuantity, new _model_Product__WEBPACK_IMPORTED_MODULE_4__["Product"](null, this.inputName, this.inputPrice));
        this.stockReportService.addItemToReport(this.stockReportId, stockItem);
        this.resetNewStockitemFields();
    };
    ListStockItemComponent.prototype.deleteStockItem = function (id) {
        this.stockItemArray.splice(id, 1);
    };
    ListStockItemComponent.prototype.resetNewStockitemFields = function () {
        this.inputName = "";
        this.inputQuantity = undefined;
        this.inputPrice = undefined;
        this.areNewStockItemFieldsSet = false;
    };
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", Array)
    ], ListStockItemComponent.prototype, "stockItems", void 0);
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", Number)
    ], ListStockItemComponent.prototype, "stockReportId", void 0);
    ListStockItemComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'list-stock-item',
            template: __webpack_require__(/*! ./list-stock-item.component.html */ "./src/app/list-stock-item/list-stock-item.component.html"),
            styles: [__webpack_require__(/*! ./list-stock-item.component.css */ "./src/app/list-stock-item/list-stock-item.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_service_stock_report_service__WEBPACK_IMPORTED_MODULE_3__["StockReportService"]])
    ], ListStockItemComponent);
    return ListStockItemComponent;
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
    Type[Type["GLASSES"] = 0] = "GLASSES";
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

/***/ "./src/app/reports-manager/reports-manager.component.css":
/*!***************************************************************!*\
  !*** ./src/app/reports-manager/reports-manager.component.css ***!
  \***************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL3JlcG9ydHMtbWFuYWdlci9yZXBvcnRzLW1hbmFnZXIuY29tcG9uZW50LmNzcyJ9 */"

/***/ }),

/***/ "./src/app/reports-manager/reports-manager.component.html":
/*!****************************************************************!*\
  !*** ./src/app/reports-manager/reports-manager.component.html ***!
  \****************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/reports-manager/reports-manager.component.ts":
/*!**************************************************************!*\
  !*** ./src/app/reports-manager/reports-manager.component.ts ***!
  \**************************************************************/
/*! exports provided: ReportsManagerComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ReportsManagerComponent", function() { return ReportsManagerComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");


var ReportsManagerComponent = /** @class */ (function () {
    function ReportsManagerComponent() {
    }
    ReportsManagerComponent.prototype.ngOnInit = function () {
    };
    ReportsManagerComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'reports-manager',
            template: __webpack_require__(/*! ./reports-manager.component.html */ "./src/app/reports-manager/reports-manager.component.html"),
            styles: [__webpack_require__(/*! ./reports-manager.component.css */ "./src/app/reports-manager/reports-manager.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [])
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
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _http_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./http-service */ "./src/app/service/http-service.ts");



var StockReportService = /** @class */ (function () {
    function StockReportService(http) {
        this.http = http;
    }
    StockReportService.prototype.getStockReport = function (id) {
        console.log("Get report " + id);
        return this.http.get("/v1/stockReport/get/" + id);
    };
    StockReportService.prototype.addItemToReport = function (idReport, item) {
        console.log("Add item[ " + ", " + item.quantity + " to report " + idReport);
        var addStockItemRequest = {
            "id": idReport,
            "stockItem": item,
            "type": item.type
        };
        this.http.post("/v1/stock/update", addStockItemRequest);
    };
    StockReportService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_http_service__WEBPACK_IMPORTED_MODULE_2__["HttpService"]])
    ], StockReportService);
    return StockReportService;
}());



/***/ }),

/***/ "./src/app/stock-report/stock-report.component.css":
/*!*********************************************************!*\
  !*** ./src/app/stock-report/stock-report.component.css ***!
  \*********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL3N0b2NrLXJlcG9ydC9zdG9jay1yZXBvcnQuY29tcG9uZW50LmNzcyJ9 */"

/***/ }),

/***/ "./src/app/stock-report/stock-report.component.html":
/*!**********************************************************!*\
  !*** ./src/app/stock-report/stock-report.component.html ***!
  \**********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div>\n  <h2 style=\"margin: auto\"> {{ reportName }}</h2>\n  <h3></h3>\n  <list-stock-item [stockReportId]=\"reportId\" [stockItems]=\"stockItems\"></list-stock-item>\n</div>"

/***/ }),

/***/ "./src/app/stock-report/stock-report.component.ts":
/*!********************************************************!*\
  !*** ./src/app/stock-report/stock-report.component.ts ***!
  \********************************************************/
/*! exports provided: StockReportComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "StockReportComponent", function() { return StockReportComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _service_stock_report_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../service/stock-report-service */ "./src/app/service/stock-report-service.ts");
/* harmony import */ var _model_StockItem__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../model/StockItem */ "./src/app/model/StockItem.ts");
/* harmony import */ var _model_Product__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../model/Product */ "./src/app/model/Product.ts");





var StockReportComponent = /** @class */ (function () {
    function StockReportComponent(stockReportService) {
        this.stockReportService = stockReportService;
        this.stockItems = [];
    }
    StockReportComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.stockReportService.getStockReport(1).subscribe(function (data) {
            _this.reportId = data.id;
            _this.reportName = data.name;
            for (var _i = 0, _a = data.items; _i < _a.length; _i++) {
                var item = _a[_i];
                var product = new _model_Product__WEBPACK_IMPORTED_MODULE_4__["Product"](item.product.id, item.product.name, item.product.price);
                var stockItem = new _model_StockItem__WEBPACK_IMPORTED_MODULE_3__["StockItem"](item.id, item.quantity, product);
                _this.stockItems.push(stockItem);
            }
        });
    };
    StockReportComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'stock-report',
            template: __webpack_require__(/*! ./stock-report.component.html */ "./src/app/stock-report/stock-report.component.html"),
            styles: [__webpack_require__(/*! ./stock-report.component.css */ "./src/app/stock-report/stock-report.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_service_stock_report_service__WEBPACK_IMPORTED_MODULE_2__["StockReportService"]])
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