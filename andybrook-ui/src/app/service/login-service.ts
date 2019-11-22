import { Injectable } from "@angular/core";
import { HttpService } from "./http-service";
import { LoginRequest } from "../model/request/login/LoginRequest";
import { HttpHeaders } from "@angular/common/http";
import { BehaviorSubject, Observable } from "rxjs";

@Injectable()
export class LoginService {

    private userLogged = new BehaviorSubject<boolean>(false);

    constructor(private httpApi: HttpService) {}

    authenticate(req: LoginRequest) {
        let httpHeaders = new HttpHeaders()
            .set('Content-Type', 'application/json')
            .set('Authorization', 'Basic ' + btoa(req.username + ':' + req.password))
        let options = {
            headers: httpHeaders
        };
        alert(JSON.stringify(options))
        return this.httpApi.get("/user", options)
    }

    logout() {
        window.sessionStorage.removeItem('username');
        let httpHeaders = new HttpHeaders()
            .set('Content-Type', 'application/json')
            .set('Authorization', 'Basic ' + btoa('admin:admin'))
        let options = {
            headers: httpHeaders
        };
        return this.httpApi.post("/logout", "", options);
        this.setUserLoggedIn(false, 'admin')
    }

    isUserLoggedIn() : boolean {
        return sessionStorage.getItem('username') != null;
    }

    setUserLoggedIn(isLogged: boolean, username: string) {
        window.sessionStorage.setItem('username', username);
        this.userLogged.next(isLogged);
    }

    getUserLoggedObservable(): Observable<boolean> {
        return this.userLogged.asObservable()
    }

    getLoggedUsers(): Observable<any> {
        return this.httpApi.get("/v1/user/loggedUsers");
    }
}
