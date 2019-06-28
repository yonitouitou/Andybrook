import { ProductItem } from './ProductItem';

export class UploadProductsFileResult {

    private rowsInFile: number;
    private rowsProcessed: number;
    private productItems: ProductItem[] = [];

    constructor() {}

    public static fromJson(data: any) : UploadProductsFileResult {
        let result = new UploadProductsFileResult();
        result.rowsInFile = data.rowsInFile;
        result.rowsProcessed = data.rowsProcessed;
        let products: ProductItem[] = [];
        for (let item of data.productItems) {
            products.push(ProductItem.fromJson(item));
        }
        result.productItems = products;
        return result;
    }
}