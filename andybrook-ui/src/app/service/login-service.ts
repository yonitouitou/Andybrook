import { Injectable } from "@angular/core";
import { HttpService } from "./http-service";
import { LoginRequest } from "../model/request/login/LoginRequest";
import { HttpHeaders } from "@angular/common/http";

@Injectable()
export class LoginService {

    private isUserLogged: boolean = false

    constructor(private httpApi: HttpService) {}

    authenticate(req: LoginRequest) {
        const body = {
                        'username': req.username,
                        'password': req.password
                     }
        let httpHeaders = new HttpHeaders()
            .set('Content-Type', 'application/json')
            .set('Authorization', 'Basic ' + btoa('admin' + ':' + 'admin'))
        let options = {
            headers: httpHeaders
        }; 
        return this.httpApi.post("/login?username=" + req.username + "&password=" + req.password, body, options)
    }

    authenticate2(req: LoginRequest) {
        let httpHeaders = new HttpHeaders()
            .set('Content-Type', 'application/json')
            .set('Authorization', 'Basic ' + btoa(req.username + ':' + req.password))
        let options = {
            headers: httpHeaders
        }; 
        return this.httpApi.get("/user", options)
    }
}