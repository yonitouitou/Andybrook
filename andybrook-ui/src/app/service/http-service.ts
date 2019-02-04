import { HttpClient } from '@angular/common/http'
import { HttpHeaders } from '@angular/common/http'; 
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';

@Injectable()
export class HttpService {

    constructor(private http: HttpClient){}

    get(url: string) : Observable<any> {
        return this.http.get(url)
    }

    post(url: string, body: any) : Observable<any> {
        return this.http.post(url, body, this.getHeaders());
    }

    delete(url: string) : Observable<any> {
        return this.http.delete(url, this.getHeaders());
    }

    private getHeaders() {
        let httpHeaders = new HttpHeaders()
            .set('Content-Type', 'application/json')
        let options = {
            headers: httpHeaders
        }; 
        return options
    }
}