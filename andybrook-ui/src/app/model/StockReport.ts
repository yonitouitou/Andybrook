import { StockItem } from '../model/StockItem'

export class StockReport {
    
    id: number
    name: string
    comment: string
    status: string
    items: Map<number, StockItem> = new Map()

    constructor() {
    }
}