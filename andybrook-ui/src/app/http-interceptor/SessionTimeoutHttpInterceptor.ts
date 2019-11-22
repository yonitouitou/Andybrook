import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent, HttpErrorResponse } from "@angular/common/http";
import { Observable } from "rxjs";
import { ModalBuilder } from "../common-components/modal-builder";
import { tap, catchError } from "rxjs/operators";
import { Injectable } from "@angular/core";
import { InfoModalComponent } from "../modal/info-modal/info-modal.component";
import { Router } from "@angular/router";

@Injectable()
export class SessionTimeoutHttpInterceptor implements HttpInterceptor {

    constructor(private modalBuilder: ModalBuilder, private router: Router) {}

    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
      if (req.url.includes('/user')) {
        return next.handle(req)
      }

      return next.handle(req).pipe(
        catchError(
          err =>
            new Observable<HttpEvent<any>>(observer => {
              if (err instanceof HttpErrorResponse) {
                const errResp = <HttpErrorResponse>err;
                if (errResp.status === 401 || err.status === 403) {
                  this.showModalLogoutMsg(errResp.status)
                }
              }
              observer.error(err);
              observer.complete();
            })
        )
      );
    }

    private showModalLogoutMsg(errorStatus: number) {
      const modalRef = this.modalBuilder.openCenteredLargeModal(InfoModalComponent)
      modalRef.componentInstance.title = "Error " + errorStatus;
      modalRef.componentInstance.message = 'Session expired. You are going to be redirected to loggin again'
      modalRef.result.then((response) => {
        this.router.navigateByUrl("/");
      })
    }
}
