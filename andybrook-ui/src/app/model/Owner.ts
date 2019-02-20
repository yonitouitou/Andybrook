export class Owner {
    id: number
    firstName: string = ''
    lastName: string = ''
    email: string = ''
    address: string = ''

    constructor() {
    }

    static fromJson(data: any) : Owner {
        let owner = new Owner()
        owner.id = data.id
        owner.firstName = data.firstName
        owner.lastName = data.lastName
        owner.email = data.email
        owner.address = data.address
        return owner
    }
}