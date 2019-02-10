import {Pipe, PipeTransform, Injectable } from '@angular/core'

@Pipe({
    name: 'filter',
})
@Injectable()
export class FilterPipe implements PipeTransform {

    transform(items: IterableIterator<any>, field: string, value: string): Array<any> {
        if (!items) {
            return new Array[0]
        }
        let array = Array.from(items)
        if (!field || !value) {
            return array
        }
        return array.filter(singleTerm => singleTerm[field].toLowerCase().includes(value.toLowerCase()))
    }
}