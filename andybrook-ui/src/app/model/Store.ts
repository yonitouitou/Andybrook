import { Owner } from './Owner';
import { Address } from './Address';

export class Store {

    id: number
    name: string
    email: string
    phone: string
    address: Address
    owner: Owner

    constructor() {
    }

    static fromJson(data: any): Store {
        let store = new Store();
        store.id = data.id;
        store.name = data.name;
        store.email = data.email;
        store.phone = data.phone;
        store.address = Address.fromJson(data.address);
        store.owner = Owner.fromJson(data.owner);
        return store
    }
}