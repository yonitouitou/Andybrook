export class AddOrderItemByBarCodeReq {

    orderId: number
    barCode: string

    constructor(orderId: number, barCode: string) {
        this.orderId = orderId;
        this.barCode = barCode;
    }
}