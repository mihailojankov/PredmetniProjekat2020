import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpErrorResponse, HttpRequest, HttpHandler, HttpEvent } from '@angular/common/http';
import { Router } from '@angular/router';
import { Observable, throwError, of, empty } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable()
export class Interseptor implements HttpInterceptor {

    constructor(private router: Router) { }

    private handleAuthError(err: HttpErrorResponse): Observable<any> {
        if(err.status === 401 || err.status === 403 || err.status === 500){
            window.alert("Nemate pristup!");
            this.router.navigate([""]);
        }

        if(err.status === 409){
            window.alert("Pogresni podaci!");
        }

        return throwError(err);
    }

    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        let token = window.localStorage.getItem("token");

        if(token != null && token !=undefined && token != ""){
            const authReq = req.clone({headers: req.headers.set("Authorization", token)});
            return next.handle(authReq).pipe(catchError(x=> this.handleAuthError(x)));
        }
        return next.handle(req).pipe(catchError(x=> this.handleAuthError(x))); //here use an arrow function, otherwise you may get "Cannot read property 'navigate' of undefined" on angular 4.4.2/net core 2/webpack 2.70
    }
}
