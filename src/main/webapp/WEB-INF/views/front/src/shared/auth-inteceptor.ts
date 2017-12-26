import {Injectable} from "@angular/core";
import {
  HttpErrorResponse, HttpEvent, HttpHandler, HttpHeaders, HttpInterceptor, HttpParams,
  HttpRequest
} from "@angular/common/http";
import {Router} from "@angular/router";
import {Observable} from "rxjs/Observable";
import {isNull, isNullOrUndefined} from "util";
import "rxjs/add/operator/catch";
import {Url} from "./config/url";
import "rxjs/add/observable/throw";

@Injectable()
export class AuthInterceptor implements HttpInterceptor {
  constructor(private _router: Router) {
  }

  intercept<T>(req: HttpRequest<T>, next: HttpHandler): Observable<HttpEvent<T>> {
    let headers = this.getHeaders(req);
    req = req.clone({headers, url: Url.url + req.url});
    return next.handle(req).catch(err => {
      console.log(err.status);
      if (err.status === 401) {
        if (isNullOrUndefined(localStorage.getItem("refresh_token"))) {
          console.error("isNullOrUndefined(localStorage.getItem(\"refresh_token\"))");
          return Observable.throw(err);
        } else {
          var data = 'refresh_token='
            + encodeURIComponent(localStorage.getItem("refresh_token")) + '&grant_type=refresh_token&client_id=' +
            encodeURIComponent("clientapp") + "&client_secret=" + encodeURIComponent("123456");
          let authReq = new HttpRequest("POST", "/oauth/token", {
            params: new HttpParams().set("refresh_token", localStorage.getItem("refresh_token"))
              .set("grant_type", "refresh_token").set("client_id", "clientapp").set("client_secret", "123456")
          });
          next.handle(authReq).catch((error) => Observable.throw(error)).subscribe(
            next => {
              console.log(next);
            }, error => {
              console.error(error);
              this._router.navigateByUrl('/login');
            })
        }
        this._router.navigateByUrl('/login');
      } else {
        console.error(err);
        console.error(err.url);
        console.log(err instanceof HttpErrorResponse);
        return Observable.throw(err);
      }
    });
  }

  getHeaders(req: HttpRequest<any>): HttpHeaders {
    let authKey = "";
    let headers = new HttpHeaders();
    let temp: HttpRequest<any>;
    if (isNull(req.headers)) {
      temp = req.clone({headers});
    } else {
      temp = req.clone();
    }
    if (temp.headers.keys().indexOf("multipart") != -1 || temp.headers.keys().indexOf("enctype") != -1) {
      headers = headers.append("enctype", "form-data/multipart");
    } else {
      if (!isNullOrUndefined(localStorage.getItem("access_token")) && localStorage.getItem("access_token") != "") {
        authKey = "Bearer " + localStorage.getItem("access_token");
      } else if (req.url.indexOf("grant_type") != -1) {
        authKey = "Basic  Y2xpZW50YXBwOjEyMzQ1Ng==";
        if (temp.headers.keys().indexOf("Content-Type") != -1) {
          if (temp.headers.get("Content-Type").indexOf("application/x-www-form-urlencoded") == -1) {
            headers = headers.set("Content-Type", temp.headers.get("Content-Type") + ";application/x-www-form-urlencoded");
          }
          if (temp.headers.get("Content-Type").indexOf("application/json") == -1) {
            headers = headers.set("Content-Type", temp.headers.get("Content-Type") + ";application/json");
          }
        } else {
          headers = headers.append("Content-Type", "application/x-www-form-urlencoded;application/json");
        }
      }
      if (headers.keys().indexOf("Content-Type") != -1) {
        if (headers.get("Content-Type").indexOf("application/json") == -1) {
          headers = headers.set("Content-Type", temp.headers.get("Content-Type") + ";application/json");
        }
      } else {
        headers = headers.append("Content-Type", "application/json");
      }
      headers = headers.append("Authorization", authKey);
    }
    headers = headers.append("Accept", "application/json");
    return headers;
  }
}
