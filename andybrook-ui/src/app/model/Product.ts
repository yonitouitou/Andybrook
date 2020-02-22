import { ProductId } from "./ProductId"
import { ProductType } from "./ProductType"

export class Product {
    id: ProductId
    name: string
    price: number

    constructor(id: ProductId, name: string, price: number) {
        this.id = id
        this.name = name
        this.price = price
    }

    static fromJson(data: any): Product {
        const productId = new ProductId(data.id, ProductType.GLASSES);
        const productName = data.name;
        const productPrice = data.price;
        return new Product(productId, productName, productPrice)
    }
}