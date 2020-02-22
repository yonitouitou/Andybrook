import { AggregatedOrderInfo } from './AggregatedOrderInfo';
import { AggregatedOrderItem } from './AggregatedOrderItem';

export class AggregatedOrder {
    aggregatedOrderInfo: AggregatedOrderInfo;
    aggregatedOrderItems: AggregatedOrderItem[] = [];

    constructor() {}

    static fromJson(data: any): AggregatedOrder {
        console.debug()
        let order = new AggregatedOrder();
        order.aggregatedOrderInfo = AggregatedOrderInfo.fromJson(data.aggregatedOrderInfo);
        for (let item of data.aggregatedOrderItems) {
            order.aggregatedOrderItems.push(AggregatedOrderItem.fromJson(item));
        }
        return order;
    }
}