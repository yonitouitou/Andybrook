import { Address } from '../../Address';

export class AddOrUpdateCustomerReq {

    storeId: number
    ownerId: number
    ownerCompagnyName: string
    ownerFirstName: number
    ownerLastName: number
    ownerEmail: string
    storeName: string
    storePhone: string
    storeEmail: string
    storeAddress: Address

    constructor(ownerId: number, storeName: string) {
        this.ownerId = ownerId;
        this.storeName = storeName;
    }
}