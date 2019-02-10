import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser'
import { FilterPipe } from './common-components/pipe/FilterPipe';

@NgModule({
    imports:[
        BrowserModule
    ],
    declarations: [
        FilterPipe
    ],
    providers:[
        // service
    ],
    exports:[
        FilterPipe
    ],
})
export class SharedModule {}