export class AddOrderItemReq {

    orderId: number;
    requestedQty: number;
    productId: number;

    constructor(orderId: number, productId: number, requestedQty: number) {
        this.orderId = orderId;
        this.productId = productId;
        this.requestedQty = requestedQty;
    }
}