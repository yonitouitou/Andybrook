import { AggregatedOrderInfo } from './AggregatedOrderInfo';
import { AggregatedOrderItem } from './AggregatedOrderItem';
import { Customer } from './Customer';

export class AggregatedOrder {
    id: number;
    name: string;
    comment: string;
    customer: Customer;
    status: string;
    createdDatetime: Date;
    lastModifiedDatetime: Date;
    closeDatetime: Date;
    aggregatedOrderInfo: AggregatedOrderInfo;
    aggregatedOrderItems: AggregatedOrderItem[] = [];

    constructor() {}

    static fromJson(data: any): AggregatedOrder {
        let order = new AggregatedOrder();
        order.id = data.id;
        order.name = data.name;
        order.customer = Customer.fromJson(data.customer);
        order.status = data.status;
        order.comment = data.comment;
        order.createdDatetime = data.createdDatetime;
        order.lastModifiedDatetime = data.lastModifiedDatetime;
        order.closeDatetime = data.closeDatetime;
        order.aggregatedOrderInfo = AggregatedOrderInfo.fromJson(data.aggregatedOrderInfo);
        for (let item of data.aggregatedOrderItems) {
            order.aggregatedOrderItems.push(AggregatedOrderItem.fromJson(item));
        }
        return order;
    }
}