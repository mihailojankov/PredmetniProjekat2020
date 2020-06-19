import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpErrorResponse, HttpRequest, HttpHandler, HttpEvent } from '@angular/common/http';
import { Router } from '@angular/router';
import { Observable, throwError, of, empty } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable()
export class Interseptor implements HttpInterceptor {

    constructor(private router: Router) { }

    private handleAuthError(err: HttpErrorResponse): Observable<any> {
        if (err.status === 401 || err.status === 403 || err.status === 500) {
            window.localStorage.setItem('token', '');
            this.router.navigate(['/login']);
            // Poruka o pristupu
        }

        if (err.status === 409) {
            window.alert('Neispravni podaci!');
        }

        return throwError(err);
    }

    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        const token = window.localStorage.getItem('token');

        if (token != null && token != undefined && token != '') {
            const authReq = req.clone({headers: req.headers.set('Authorization', token)});
            return next.handle(authReq).pipe(catchError(x => this.handleAuthError(x)));
        }

        return next.handle(req).pipe(catchError(x => this.handleAuthError(x)));
    }
}
