import { Product } from './Product';

enum Type {
    GLASSES = "GLASSES",
}

export class StockItem {

    id: number
    quantity: number
    product: Product
    type: Type = Type.GLASSES
    barCode: string
    createdDatetime: Date
    lastModifiedDatetime: Date
    

    constructor(id: number, barCode: string, quantity: number, product: Product, creationDatetime: Date, lastModifyDatetime) {
        this.id = id
        this.barCode = barCode
        this.quantity = quantity
        this.product = product
        this.createdDatetime = creationDatetime
        this.lastModifiedDatetime = lastModifyDatetime
    }
}