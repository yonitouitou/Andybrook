
import { Injectable } from '@angular/core'
import { HttpService } from './http-service'
import { Order } from "../model/Order";
import { Observable } from 'rxjs';
import { AddOrderItemReq } from '../model/request/AddOrderItemReq';
import { OrderItem } from '../model/OrderItem';
import { DeleteOrderItemsReq } from '../model/request/DeleteOrderItemsReq';
import { AddOrderItemByBarCodeReq } from '../model/request/AddOrderItemByBarCodeReq';

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
        console.log("Get order by id " + id);
        return this.httpApi.get("/v1/order/get/" + id);
    }

    getOrderByName(name: string): Observable<any> {
        console.log("Get order by name : " + name);
        return this.httpApi.get("/v1/order/searchByName/" + name);
    }

    addOrderItem(req: AddOrderItemReq) : Observable<any> {
        console.log("Add order item[ " + ", " + req.requestedQty + " to order " + req.orderId);
        return this.httpApi.post("/v1/order/addOrderItemByInfo", req);
    }

    addOrderItemByBarCode(req: AddOrderItemByBarCodeReq) : Observable<any> {
        console.log("Add order item by barCode to order " + req.orderId + " : " + req.barCode);
        return this.httpApi.post("/v1/order/addSingleOrderItemsByBarCode", req);
    }

    updateStockItem(order: Order, itemToUpdate: OrderItem): Observable<any> {
        console.log("updateProductItem order " + order.id + " | " + itemToUpdate)
        //return this.httpApi.post("/v1/order/updateProductItem", this.toUpdateRequest(order, itemToUpdate))
        return null;
    }

    deleteOrderItems(req: DeleteOrderItemsReq): Observable<any> {
        console.log("Delete OrderItems from order : " + req.orderId + " : " + req.orderItemsId)
        return this.httpApi.post("/v1/order/deleteOrderItems", req);
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
