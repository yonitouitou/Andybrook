import { Injectable } from "@angular/core";
import { HttpService } from "./http-service";
import { LoginRequest } from "../model/request/login/LoginRequest";
import { HttpHeaders } from "@angular/common/http";

@Injectable()
export class LoginService {

    private isUserLogged: boolean = false

    constructor(private httpApi: HttpService) {}

    authenticate(req: LoginRequest) {
        const headers = new HttpHeaders(
            { Authorization: 'Basic ' + btoa(req.username + ':' + req.password) }
        );
        return this.httpApi.post("/login", req, headers)
    }


}