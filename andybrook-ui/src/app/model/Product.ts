export class Product {
    id: number
    name: string
    price: number

    constructor(id: number, name: string, price: number) {
        this.id = id
        this.name = name
        this.price = price
    }

    static fromJson(data: any): Product {
        const productId = data.id;
        const productName = data.name;
        const productPrice = data.price;
        return new Product(productId, productName, productPrice)
    }
}