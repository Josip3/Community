import {Injectable} from "@angular/core";
import {Headers, Http, RequestOptions, RequestOptionsArgs} from "@angular/http";
import {Observable} from "rxjs/Observable";
import {Url} from "../../shared/config/url";
import {HttpClient, HttpParams} from "@angular/common/http";
import "rxjs/add/observable/of";
import "rxjs/add/observable/throw";
import {User} from "../../shared/models/user";


@Injectable()
export class LoginService {

  static tokenName: string = "access_token";

  constructor(private _http: HttpClient) {
  }

  sendCredentials(model): Observable<any> {
    let tokenUrl = "/oauth/token";
    return this._http.post(tokenUrl, new HttpParams().set("username", model.username).set("password", model.password).set("grant_type", "password")).catch((error) => Observable.throw(error));
  }

  getUser(): Observable<User> {
    return this
      ._http
      .get<User>("/registration/get-user")
      .catch((error) => Observable.throw(error));
  }

}
