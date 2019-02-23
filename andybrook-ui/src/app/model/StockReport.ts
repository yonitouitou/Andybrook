import { StockItem } from '../model/StockItem'
import { Customer } from './Customer';

export class StockReport {
    
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

    static fromJson(data: any) : StockReport {
        let itemsQty = data.items.reduce((sum, item) => sum + item.quantity, 0);
        let totalPrice = this.getTotalPrice(data.items)
        let sr = new StockReport()
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