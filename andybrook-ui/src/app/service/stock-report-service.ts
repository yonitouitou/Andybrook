import { StockItem } from '../model/StockItem'
import { Product } from '../model/Product'
import { Injectable, EventEmitter } from '@angular/core'
import { HttpService } from './http-service'
import { StockReport } from '../model/StockReport'
import { Observable } from 'rxjs';

@Injectable()
export class StockReportService {

    constructor(private httpApi: HttpService){}

    getStockReport(report: StockReport, id: number): Observable<any> {
        console.log("Get report " + id)
        return this.httpApi.get("/v1/stockReport/get/" + id)
    }

    addItem(report: StockReport, item: StockItem) {
        console.log("Add item[ " + ", " + item.quantity + " to report " + report.id)
        let stockItem
        
        this.httpApi.post("/v1/stock/update", this.toUpdateRequest(report, item)).subscribe(
            data => {
                let product = new Product(data.item.product.id, data.item.product.name, data.item.product.price)
                stockItem = new StockItem(data.item.id, data.item.quantity, product)
                report.items.set(stockItem.id, stockItem)
            },
            error => {
                debugger;
                console.log(error)
            }
        )
    }

    updateStockItem(report: StockReport, itemToUpdate: StockItem) {
        console.log("update report " + report.id + " | " + itemToUpdate)
        this.httpApi.post("/v1/stock/update", this.toUpdateRequest(report, itemToUpdate)).subscribe(data => {
            report.id = data.id
            report.name = data.name
            report.comment = data.comment
            report.status = data.status
            let product = new Product(data.item.product.id, data.item.product.name, data.item.product.price)
            let stockItem = new StockItem(data.item.id, data.item.quantity, product)
            report.items.set(stockItem.id, stockItem)
        })
    }

    deleteItem(report: StockReport, stockItemIdToDelete: number) {
        console.log("Delete Item : " + stockItemIdToDelete)
        this.httpApi.delete("/v1/stock/delete/" + stockItemIdToDelete).subscribe(
            data => {
                console.log(data)
                report.items.delete(stockItemIdToDelete)
            }
        )
    }

    closeStockReport(report: StockReport) {
        console.log("Close stock report : " + report.id)
        let request = { "id" : report.id }
        this.httpApi.post("/v1/stockReport/close", request).subscribe(
            data => {
                report.closeDatetime = data.closeDateTime
                report.status = data.status
            }
        )
    }

    getAllStockReports(): Observable<any> {
        console.log("Get all reports")
        return this.httpApi.get("/v1/stockReport/all")
    } 

    private toUpdateRequest(report: StockReport, item: StockItem): any {
        return {
            "stockReportId" : report.id,
            "stockItem" : item,
            "type" : item.type
        }
    }

}