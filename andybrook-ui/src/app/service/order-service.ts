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
        return this.httpApi.post("/v1/order/add", request)
    }

    getOrder(id: number): Observable<any> {
        console.log("Get report " + id)
        return this.httpApi.get("/v1/order/get/" + id)
    }

    getOrderByName(name: string): Observable<any> {
        console.log("Get report by name : " + name)
        return this.httpApi.get("/v1/order/getByName/" + name)
    }

    addItem(order: Order, item: StockItem) : Observable<any> {
        console.log("Add item[ " + ", " + item.quantity + " to order " + order.id)
        return this.httpApi.post("/v1/order/addOrderItems", this.toUpdateRequest(order, item))
    }

    updateStockItem(order: Order, itemToUpdate: StockItem): Observable<any> {
        console.log("updateProductItem order " + order.id + " | " + itemToUpdate)
        return this.httpApi.post("/v1/order/updateProductItem", this.toUpdateRequest(order, itemToUpdate))
    }

    deleteItem(order: Order, stockItemIdToDelete: number): Observable<any> {
        console.log("Delete Item : " + stockItemIdToDelete)
        return this.httpApi.delete("/v1/order/deleteOrderItem/" + order.id + "/" + stockItemIdToDelete)
    }

    closeOrder(order: Order) {
        console.log("Close order : " + order.id)
        let request = { "id" : order.id }
        this.httpApi.post("/v1/order/close", request).subscribe(
            data => {
                order.closeDatetime = data.closeDateTime
                order.status = data.status
            }
        )
    }

    getAllOrders(): Observable<any> {
        console.log("Get all reports")
        return this.httpApi.get("/v1/order/all")
    } 

    private toUpdateRequest(order: Order, item: StockItem): any {
        return {
            "orderId" : order.id,
            "orderItemInfo": {
                "orderItemId" : item.id,
                "quantity" : item.quantity,
                "productId" : item.product.id
            }
        }
    }

}
