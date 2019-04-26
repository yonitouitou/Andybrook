import { Product } from './Product';

export class ProductItem {

    id: number
    product: Product
    barCode: string
    createdDatetime: Date
    lastModifiedDatetime: Date

    constructor() {}

    static fromJson(data: any): ProductItem {
        let productItem = new ProductItem();
        productItem.id = data.id;
        productItem.barCode = data.barCode;
        productItem.product = Product.fromJson(data.product);
        productItem.createdDatetime = data.createdDatetime;
        productItem.lastModifiedDatetime = data.lastModifiedDatetime;
        return productItem;
    }

}