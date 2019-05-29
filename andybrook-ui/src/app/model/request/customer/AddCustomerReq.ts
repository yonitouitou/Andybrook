import { Address } from '../../Address';

export class AddCustomerReq {

    ownerId: number
    ownerCompagnyName: string
    ownerFirstName: number
    ownerLastName: number
    ownerEmail: string
    storeName: string
    storePhone: string
    storeEmail: string
    address: Address

    constructor(ownerId: number, storeName: string) {
        this.ownerId = ownerId;
        this.storeName = storeName;
    }
}