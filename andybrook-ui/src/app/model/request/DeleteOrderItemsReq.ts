export class DeleteOrderItemsReq {

    orderId: number
    orderItemsId: number[]

    constructor(orderId: number, orderItemsId: number[]) {
        this.orderId = orderId;
        this.orderItemsId = orderItemsId;
    }
}