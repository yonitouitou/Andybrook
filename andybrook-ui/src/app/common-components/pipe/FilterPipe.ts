import {Pipe, PipeTransform, Injectable } from '@angular/core'

@Pipe({
    name: 'filter',
})
@Injectable()
export class FilterPipe implements PipeTransform {

    transform(items: IterableIterator<any>, field: string, value: string): IterableIterator<any> {
        if (!items) {
            return new Array[0]
        }
        if (!field || !value) {
            return items
        }
        let array = new Array(items)
        return array.filter(singleItem => singleItem[field].toLowerCase().includes(value.toLowerCase()))
    }
}