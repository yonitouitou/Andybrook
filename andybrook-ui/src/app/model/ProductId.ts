import { ProductType } from './ProductType';

export class ProductId {

  id: String
  productType: ProductType;

  constructor(id: String, productType: ProductType) {
    this.id = id
    this.productType = productType;
  }

  static fromJson(data: any): ProductId {
    return new ProductId(data.id, data.productType)
  }
}
