import { Product } from './Product';
import {ProductId} from "./ProductId";

export class ProductItem {

    id: ProductId
    product: Product
    barCode: string
    orderItemId : boolean
    createdDatetime: Date
    lastModifiedDatetime: Date

    constructor() {}

    static fromJson(data: any): ProductItem {
        let productItem = new ProductItem();
        productItem.id = ProductId.fromJson(data.productId);
        productItem.orderItemId = data.orderItemId;
        productItem.product = Product.fromJson(data.product);
        productItem.createdDatetime = data.createdDatetime;
        productItem.lastModifiedDatetime = data.lastModifiedDatetime;
        if (data.barCode != undefined) {
            productItem.barCode = data.barCode.id;
        }
        return productItem;
    }

}
