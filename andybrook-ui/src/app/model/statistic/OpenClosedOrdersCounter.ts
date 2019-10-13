export class OpenClosedOrdersCounter {

    openOrdersCount: number
    closedOrdersCount: number

    constructor() {}

    static fromJson(data: any): OpenClosedOrdersCounter {
        let counters = new OpenClosedOrdersCounter()
        counters.openOrdersCount = data.counters.OPEN != null ? data.counters.OPEN : 0 
        counters.closedOrdersCount = data.counters.CLOSED != null ? data.counters.CLOSED : 0
        return counters
    }

    calculatePercentOfClosedOrders(): string {
        let result = '0'
        const total = this.totalOrders();
        if (total > 0) {
            result = ((this.closedOrdersCount / this.totalOrders()) * 100).toFixed(1)
        }
        return  result
    }

    totalOrders(): number {
        return this.openOrdersCount + this.closedOrdersCount;
    }
}