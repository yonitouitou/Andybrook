import { Store } from './Store';

export class Customer {

    id: number
    store: Store = new Store()

    constructor() {}

    static fromJson(data: any) : Customer {
        let customer = new Customer()
        customer.id = data.id
        customer.store = Store.fromJson(data.store)
        return customer
    }
}