import { Product } from './Product';

export class ProductStockInfo {
    product: Product
    createdQuantity: number;
    usedQuantity: number;

    constructor() {}

    static fromJson(data: any): ProductStockInfo {
        let stockInfo = new ProductStockInfo();
        stockInfo.product = Product.fromJson(data.product);
        stockInfo.createdQuantity = data.quantityCreated;
        stockInfo.usedQuantity = data.quantityUsed;
        return stockInfo;
    }

    getFreeQuantity(): number {
        return this.createdQuantity - this.usedQuantity;
    }
}