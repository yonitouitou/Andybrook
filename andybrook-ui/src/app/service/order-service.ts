import { StockItem } from '../model/StockItem'
import { Product } from '../model/Product'
import { Injectable, EventEmitter } from '@angular/core'
import { HttpService } from './http-service'
import { Order } from "../model/Order";
import { Observable } from 'rxjs';

@Injectable()
export class OrderService {

    constructor(private httpApi: HttpService){}

    addOrder(order: Order): Observable<any> {
        const request = {
            "name": order.name,
            "customerId": order.customer.id,
            "comment": order.comment
        }
        return this.httpApi.post("/v1/stockReport/add", request)
    }

    getOrder(id: number): Observable<any> {
        console.log("Get report " + id)
        return this.httpApi.get("/v1/stockReport/get/" + id)
    }

    getOrderByName(name: string): Observable<any> {
        console.log("Get report by name : " + name)
        return this.httpApi.get("/v1/stockReport/getByName/" + name)
    }

    addItem(order: Order, item: StockItem) {
        console.log("Add item[ " + ", " + item.quantity + " to order " + order.id)
        let stockItem
        
        this.httpApi.post("/v1/stock/update", this.toUpdateRequest(order, item)).subscribe(
            data => {
                let product = new Product(data.item.product.id, data.item.product.name, data.item.product.price)
                stockItem = new StockItem(data.item.id, data.item.quantity, product)
                order.items.set(stockItem.id, stockItem)
            },
            error => {
                debugger;
                console.log(error)
            }
        )
    }

    updateStockItem(order: Order, itemToUpdate: StockItem) {
        console.log("update order " + order.id + " | " + itemToUpdate)
        this.httpApi.post("/v1/stock/update", this.toUpdateRequest(order, itemToUpdate)).subscribe(data => {
            order.id = data.id
            order.name = data.name
            order.comment = data.comment
            order.status = data.status
            let product = new Product(data.item.product.id, data.item.product.name, data.item.product.price)
            let stockItem = new StockItem(data.item.id, data.item.quantity, product)
            order.items.set(stockItem.id, stockItem)
        })
    }

    deleteItem(order: Order, stockItemIdToDelete: number) {
        console.log("Delete Item : " + stockItemIdToDelete)
        this.httpApi.delete("/v1/stock/delete/" + stockItemIdToDelete).subscribe(
            data => {
                console.log(data)
                order.items.delete(stockItemIdToDelete)
            }
        )
    }

    closeOrder(order: Order) {
        console.log("Close order : " + order.id)
        let request = { "id" : order.id }
        this.httpApi.post("/v1/stockReport/close", request).subscribe(
            data => {
                order.closeDatetime = data.closeDateTime
                order.status = data.status
            }
        )
    }

    getAllOrders(): Observable<any> {
        console.log("Get all reports")
        return this.httpApi.get("/v1/stockReport/all")
    } 

    private toUpdateRequest(order: Order, item: StockItem): any {
        return {
            "stockReportId" : order.id,
            "stockItem" : item,
            "type" : item.type
        }
    }

}