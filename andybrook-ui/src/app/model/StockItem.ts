import { Product } from './Product';

enum Type {
    GLASSES = "GLASSES",
}

export class StockItem {

    id: number
    quantity: number
    product: Product
    type: Type = Type.GLASSES
    

    constructor(id: number, quantity: number, product: Product) {
        this.id = id
        this.quantity = quantity
        this.product = product
    }
}