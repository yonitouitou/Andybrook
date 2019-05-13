import { NotificationRequest } from './NotificationRequest';

export class OrderNotificationRequest extends NotificationRequest {

    orderId: number
    dateDocument: number = new Date().getTime();

    constructor(types: string[], orderId: number) {
        super(types);
        this.orderId = orderId;
    }
}