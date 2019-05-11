export class AddCustomerReq {

    ownerId: number
    ownerCompagnyName: string
    ownerFirstName: number
    ownerLastName: number
    ownerEmail: string
    storeName: string
    storeAddress: string
    storePhone: string
    storeEmail: string

    constructor(ownerId: number, storeName: string) {
        this.ownerId = ownerId;
        this.storeName = storeName;
    }
}