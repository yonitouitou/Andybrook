import { Owner } from './Owner';

export class Store {

    id: number
    name: string = ''
    email: string = ''
    owner: Owner = new Owner()

    constructor() {
    }

    static fromJson(data: any): Store {
        let store = new Store()
        store.id = data.id
        store.name = data.name
        store.email = data.email
        store.owner = Owner.fromJson(data.owner)
        return store
    }
}