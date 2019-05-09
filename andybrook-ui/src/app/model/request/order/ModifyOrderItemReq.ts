export class ModifyOrderItemReq {
    orderItemId: number;
    requestedQty: number;

    constructor(orderItemId: number, requestedQty: number) {
        this.orderItemId = orderItemId;
        this.requestedQty = requestedQty;
    }
}