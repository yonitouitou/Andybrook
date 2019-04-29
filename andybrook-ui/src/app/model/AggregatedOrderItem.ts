import { Product } from './Product';
import { OrderItem } from './OrderItem';

export class AggregatedOrderItem {
    quantity: number;
    ttlPrice: number;
    lastModifiedDatetime: Date;
    product: Product;
    orderItems: OrderItem[] = [];

    constructor() {}

    static fromJson(data: any): AggregatedOrderItem {
        let orderItem = new AggregatedOrderItem();
        orderItem.quantity = data.quantity;
        orderItem.ttlPrice = data.ttlPrice;
        orderItem.lastModifiedDatetime = data.lastModifiedDatetime;
        orderItem.product = Product.fromJson(data.product);
        for (let item of data.orderItems) {
            orderItem.orderItems.push(OrderItem.fromJson(item));
        }
        return orderItem;
    }
}