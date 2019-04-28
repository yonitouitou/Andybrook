export class AggregatedOrderInfo {
    id: number;
    storeId: number;
    name: string;
    storeName: string;
    status: string;
    orderItemSize: number;
    productSize: number;
    totalPrice: number;
    createdDatetime: Date;
    lastModifiedDatetime: Date;
    closeDatetime: Date;

    constructor() {}

    static fromJson(data: any) : AggregatedOrderInfo {
        let order = new AggregatedOrderInfo();
        order.id = data.id;
        order.storeId = data.storeId;
        order.name = data.name;
        order.storeName = data.storeName;
        order.status = data.status;
        order.orderItemSize = data.orderItemSize;
        order.productSize = data.productSize;
        order.totalPrice = data.totalPrice;
        order.createdDatetime = data.createdDatetime;
        order.lastModifiedDatetime = data.lastModifiedDatetime;
        order.closeDatetime = data.closeDatetime;
        return order;
    }
}