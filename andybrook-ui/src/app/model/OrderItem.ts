import { ProductItem } from './ProductItem';

enum Type {
    GLASSES = "GLASSES",
}

export class OrderItem {

    id: number
    quantity: number
    productItem: ProductItem
    type: Type = Type.GLASSES
    createdDatetime: Date
    lastModifiedDatetime: Date
    
    constructor() {}

    static fromJson(data: any): OrderItem {
        let orderItem = new OrderItem();
        orderItem.id = data.id;
        orderItem.quantity = data.quantity;
        orderItem.productItem = ProductItem.fromJson(data.productItem);
        orderItem.createdDatetime = data.createdDatetime;
        orderItem.lastModifiedDatetime = data.lastModifiedDatetime;
        return orderItem;
    }
}