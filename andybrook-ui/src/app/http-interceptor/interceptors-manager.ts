import { HTTP_INTERCEPTORS } from "@angular/common/http";
import { SessionTimeoutHttpInterceptor } from "./SessionTimeoutHttpInterceptor";
import { HttpToHttpsInterceptor } from "./HttpToHttpsInterceptor";

export const httpInterceptorProviders = [
    { provide: HTTP_INTERCEPTORS, useClass: SessionTimeoutHttpInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: HttpToHttpsInterceptor, multi: true}
]