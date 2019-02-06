export class ReportInfo {

    id: number
    nbProduct: number
    totalItemQty: number
    totalPrice: number
    name: string
    status: string
    comment: string
    createDate: Date
    closeDate: Date

    constructor(id: number, name: string, status: string, nbProduct:number,
                createDate: Date, closeDate: Date, comment: string, totalItemQty: number,
                totalPrice: number) {
        this.id = id
        this.name = name
        this.status = status
        this.nbProduct = nbProduct
        this.createDate = createDate
        this.closeDate = closeDate
        this.comment = comment
        this.totalItemQty = totalItemQty
        this.totalPrice = totalPrice
    }
}