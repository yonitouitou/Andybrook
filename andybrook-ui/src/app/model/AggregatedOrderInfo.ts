import { Store } from "./Store";

export class AggregatedOrderInfo {
    
    id: number;
    name: string;
    comment: string;
    store: Store;
    status: string;
    createdDatetime: Date;
    lastModifiedDatetime: Date;
    closeDatetime: Date;
    orderItemSize: number;
    productSize: number;
    totalPrice: number;

    constructor() {}

    static fromJson(data: any) : AggregatedOrderInfo {
        let order = new AggregatedOrderInfo();
        order.id = data.id;
        order.name = data.name;
        order.store = Store.fromJson(data.store);
        order.status = data.status;
        order.comment = data.comment;
        order.createdDatetime = data.createdDatetime;
        order.lastModifiedDatetime = data.lastModifiedDatetime;
        order.closeDatetime = data.closeDatetime;
        order.orderItemSize = data.orderItemSize;
        order.productSize = data.productSize;
        order.totalPrice = data.totalPrice;
        return order;
    }
}