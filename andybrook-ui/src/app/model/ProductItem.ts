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
        productItem.product = Product.fromJson(data.product);
        productItem.createdDatetime = data.createdDatetime;
        productItem.lastModifiedDatetime = data.lastModifiedDatetime;
        if (data.barCode != undefined) {
            productItem.barCode = data.barCode.id;
        }
        return productItem;
    }

}