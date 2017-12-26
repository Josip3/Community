import {Injectable} from '@angular/core';
import {
  HttpErrorResponse, HttpEvent, HttpHandler, HttpHeaders, HttpInterceptor, HttpParams,
  HttpRequest
} from '@angular/common/http';
import {Router} from '@angular/router';
import {Observable} from 'rxjs/Observable';
import {isNull, isNullOrUndefined} from 'util';
import 'rxjs/add/operator/catch';
import {Url} from './config/url';
import 'rxjs/add/observable/throw';
import {AppComponent} from "../app/app.component";

// дуже складна схема
// тут ми обробляєм наш запит - додаєм хедери, урлу
// якщо прийде 401 - надсилаєм запит з рефреш токеном, ґкщо знову то кидаєм на логін

@Injectable()
export class AuthInterceptor implements HttpInterceptor {
  constructor(private _router: Router) {
  }

  intercept<T>(req: HttpRequest<T>, next: HttpHandler): Observable<HttpEvent<T>> {
    const headers = this.getHeaders(req);
    let url = req.url;
    req = req.clone({headers, url: Url.url + req.url});
    return next.handle(req).catch(err => {
      console.log(err.status);
      if (err.status === 401 && url.indexOf("/oauth/token") == -1) {
        if (isNullOrUndefined(localStorage.getItem('refresh_token'))) {
          console.error('isNullOrUndefined(localStorage.getItem("refresh_token"))');
          return Observable.throw(err);
        } else {
          const data = 'refresh_token='
            + encodeURIComponent(localStorage.getItem('refresh_token')) + '&grant_type=refresh_token&client_id=' +
            encodeURIComponent('clientapp') + '&client_secret=' + encodeURIComponent('123456');
          const authReq = new HttpRequest('POST', '/oauth/token', {
            params: new HttpParams().set('refresh_token', localStorage.getItem('refresh_token'))
              .set('grant_type', 'refresh_token').set('client_id', 'clientapp').set('client_secret', '123456')
          });
          next.handle(authReq).catch((error) => Observable.throw(error)).subscribe(
            next => {
              console.log(next);
            }, error => {
              console.error(error);
              this._router.navigateByUrl('/login');
            });
        }
        this._router.navigateByUrl('/login');
      } else {
        if (err.status == 401 && url.indexOf("/oauth/token") != -1) {
          AppComponent._userDetailsService.rmTokenParseInLocalStorage();
        }
        console.error(err);
        console.error(err.url);
        console.log(err instanceof HttpErrorResponse);
        return Observable.throw(err);
      }
    });
  }

  getHeaders(req: HttpRequest<any>): HttpHeaders {
    let authKey = '';
    console.log(authKey);
    let headers = new HttpHeaders();
    let temp: HttpRequest<any>;
    if (isNull(req.headers)) {
      temp = req.clone({headers});
    } else {
      temp = req.clone();
    }
    if (temp.headers.keys().indexOf('multipart') != -1 || temp.headers.keys().indexOf('enctype') != -1) {
      headers = headers.append('enctype', 'form-data/multipart');
    } else if (temp.headers.keys().indexOf('no-auth') != -1) {
      headers = headers.append('Content-Type', 'application/json');
    } else {
      if ((!isNullOrUndefined(localStorage.getItem('access_token'))) && (localStorage.getItem('access_token') != '')) {
        console.log('access_token');
        console.log(localStorage.getItem('access_token') == 'undefined');
        headers = headers.append('Content-Type', 'application/json');
        authKey = 'Bearer ' + localStorage.getItem('access_token');
        console.log((isNullOrUndefined(localStorage.getItem('access_token'))));
      } else {
        console.log(req.url);
        console.log(JSON.stringify(req.body));
        authKey = 'Basic  Y2xpZW50YXBwOjEyMzQ1Ng==';
        console.log(authKey);
        if (JSON.stringify(req.body).indexOf('grant_type') != -1) {
          if (temp.headers.keys().indexOf('Content-Type') != -1) {
            // if (temp.headers.get('Content-Type').indexOf('application/x-www-form-urlencoded') == -1) {
            //   headers = headers.set('Content-Type', temp.headers.get('Content-Type') + ';application/x-www-form-urlencoded');
            // }
            // if (temp.headers.get('Content-Type').indexOf('application/json') == -1) {
            //   headers = headers.set('Content-Type', temp.headers.get('Content-Type') + ';application/json');
            // }
            headers = headers.set('Content-Type', 'application/x-www-form-urlencoded');
          } else {
            headers = headers.append('Content-Type', 'application/x-www-form-urlencoded');
          }
        }
      }
      //   if (headers.keys().indexOf('Content-Type') != -1) {
      //     if (headers.get('Content-Type').indexOf('application/json') == -1) {
      //       headers = headers.set('Content-Type', temp.headers.get('Content-Type') + ';application/json');
      //     }
      //   } else {
      //     headers = headers.append('Content-Type', 'application/json');
      //   }
      headers = headers.append('Authorization', authKey);
      console.log(authKey);
    }
    headers = headers.append('Accept', 'application/json');
    return headers;
  }
}
