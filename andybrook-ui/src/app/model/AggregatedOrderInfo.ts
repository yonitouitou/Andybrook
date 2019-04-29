export class AggregatedOrderInfo {
    
    orderItemSize: number;
    productSize: number;
    totalPrice: number;

    constructor() {}

    static fromJson(data: any) : AggregatedOrderInfo {
        let order = new AggregatedOrderInfo();
        order.orderItemSize = data.orderItemSize;
        order.productSize = data.productSize;
        order.totalPrice = data.totalPrice;
        return order;
    }
}