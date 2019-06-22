import { NotificationRequest } from './NotificationRequest';

export class OrderNotificationRequest extends NotificationRequest {

    orderId: number
    dateDocument: number = new Date().getTime();

    constructor(type: string, orderId: number) {
        super(type);
        this.orderId = orderId;
    }
}