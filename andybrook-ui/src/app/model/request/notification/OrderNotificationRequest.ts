export class OrderNotificationRequest {

    orderId: number
    dateDocument: number = new Date().getTime();

    constructor(orderId: number) {
        this.orderId = orderId;
    }
}