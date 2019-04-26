import { ProductItem } from './ProductItem';

enum Type {
    GLASSES = "GLASSES",
}

export class StockItem {

    id: number
    quantity: number
    productItem: ProductItem
    type: Type = Type.GLASSES
    barCode: string
    createdDatetime: Date
    lastModifiedDatetime: Date
    

    constructor(id: number, barCode: string, quantity: number, productItem: ProductItem, creationDatetime: Date, lastModifyDatetime) {
        this.id = id;
        this.barCode = barCode;
        this.quantity = quantity;
        this.productItem = productItem;
        this.createdDatetime = creationDatetime;
        this.lastModifiedDatetime = lastModifyDatetime;
    }
}