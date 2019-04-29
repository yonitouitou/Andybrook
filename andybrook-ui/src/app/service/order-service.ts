
import { Injectable } from '@angular/core'
import { HttpService } from './http-service'
import { Order } from "../model/Order";
import { Observable } from 'rxjs';
import { AddOrderItemReq } from '../model/request/AddOrderItemReq';
import { OrderItem } from '../model/OrderItem';

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
        return this.httpApi.get("/v1/order/searchByName/" + name)
    }

    addOrderItem(req: AddOrderItemReq) : Observable<any> {
        console.log("Add item[ " + ", " + req.requestedQty + " to order " + req.orderId)
        return this.httpApi.post("/v1/order/addOrderItemByInfo", req)
    }

    updateStockItem(order: Order, itemToUpdate: OrderItem): Observable<any> {
        console.log("updateProductItem order " + order.id + " | " + itemToUpdate)
        //return this.httpApi.post("/v1/order/updateProductItem", this.toUpdateRequest(order, itemToUpdate))
        return null;
    }

    deleteOrderItem(orderId: number, orderItemIdToDelete: number): Observable<any> {
        console.log("Delete OrderItem : " + orderItemIdToDelete)
        return this.httpApi.delete("/v1/order/deleteOrderItem/" + orderId + "/" + orderItemIdToDelete)
    }

    closeOrder(orderId: number): Observable<any> {
        console.log("Close order : " + orderId)
        let request = { "id" : orderId }
        return this.httpApi.post("/v1/order/close", request);
    }

    getAllOrders(): Observable<any> {
        console.log("Get all reports")
        return this.httpApi.get("/v1/order/all")
    } 
}
