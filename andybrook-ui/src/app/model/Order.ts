import { StockItem } from './StockItem'
import { Customer } from './Customer';

export class Order {
    
    id: number
    name: string
    comment: string
    status: string
    customer: Customer = new Customer()
    createDatetime: Date
    closeDatetime: Date
    items: Map<number, StockItem> = new Map()
    nbProduct: number
    totalItemQty: number
    totalPrice: number

    constructor() {
    }

    static fromJson(data: any) : Order {
        let itemsQty = data.items.reduce((sum, item) => sum + item.quantity, 0);
        let totalPrice = this.getTotalPrice(data.items)
        let sr = new Order()
        sr.id = data.id
        sr.name = data.name
        sr.customer = data.customer
        sr.status = data.status,
        sr.nbProduct = data.items.length
        sr.createDatetime = data.createdDateTime
        sr.closeDatetime = data.closeDateTime
        sr.comment = data.comment
        sr.totalItemQty = itemsQty
        sr.totalPrice = totalPrice
        return sr
    }

    private static getTotalPrice(items: any) {
        let total = 0
        for (let i = 0; i < items.length; i++) {
            total += items[i].product.price * items[i].quantity;
        }
        return total
    }
}