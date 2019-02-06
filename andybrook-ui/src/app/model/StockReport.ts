import { StockItem } from '../model/StockItem'

export class StockReport {
    
    id: number
    name: string
    comment: string
    status: string
    createDatetime: Date
    closeDatetime: Date
    items: Map<number, StockItem> = new Map()

    constructor() {
    }
}