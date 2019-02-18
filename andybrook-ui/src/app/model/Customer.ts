import { Store } from './Store';

export class Customer {

    store: Store = new Store()

    constructor() {}

    static fromJson(data: any) : Customer {
        let customer = new Customer()
        customer.store = Store.fromJson(data.store)
        return customer
    }
}