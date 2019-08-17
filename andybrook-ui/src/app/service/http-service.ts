import { HttpClient, HttpHeaders } from '@angular/common/http'
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable()
export class HttpService {

    constructor(private http: HttpClient){}

    get(url: string) : Observable<any> {
        return this.http.get(url)
    }

    post(url: string, body: any, options?) : Observable<any> {
        return this.http.post(url, body, options != null ? options : this.getHeaders());
    }

    delete(url: string) : Observable<any> {
        return this.http.delete(url, this.getHeaders());
    }

    put(url: string): Observable<any> {
      return this.http.put(url, this.getHeaders());
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
