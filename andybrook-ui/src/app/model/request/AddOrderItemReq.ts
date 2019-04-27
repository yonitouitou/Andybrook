export class AddOrderItemReq {

    orderId: number;
    requestedQty: number;
    productId: number;
    barCode: string;

    constructor(orderId: number, productId: number, barCode: string, requestedQty: number) {
        this.orderId = orderId;
        this.productId = productId;
        this.requestedQty = requestedQty;
        this.barCode = barCode;
    }
}