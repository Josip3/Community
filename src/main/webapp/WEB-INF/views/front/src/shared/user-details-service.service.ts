import {Subject} from "rxjs/Subject";
import {isNullOrUndefined} from "util";
import {User} from "./models/user";

export class UserDetailsService {


  public user: User = new User();
  public isAuth: boolean = false;
  public isAdmin: boolean = false;
  private _user = new Subject<User>();
  user$ = this._user.asObservable();
  private _isAuth = new Subject<boolean>();
  isAuth$ = this._isAuth.asObservable();
  private _isAdmin = new Subject<boolean>();
  isAdmin$ = this._isAdmin.asObservable();

  constructor() {

  }


  public login(user: User) {
    this.user = user;
    this._user.next(this.user);
    this.isAuth = true;
    this._isAuth.next(this.isAuth);
    this.isAdmin = user.role.toUpperCase() == "ADMIN";
    this._isAdmin.next(this.isAdmin);
  }

  public logout() {
    this.user = new User();
    this.user.role = "no_access_token";
    this._user.next(this.user);
    this.isAuth = false;
    this._isAuth.next(this.isAuth);
    localStorage.removeItem("access_token");
    if (!isNullOrUndefined(localStorage.getItem("ADMIN")))
      localStorage.removeItem("ADMIN");
    this.isAdmin = false;
    this._isAdmin.next(this.isAdmin);
  }

  checkAuth(): boolean {
    return (!isNullOrUndefined(localStorage.getItem("access_token")));
  }

  tokenParseInLocalStorage(data: any) {
    let date = new Date();
    date.setSeconds(data.expires_in);
    localStorage.removeItem("access_token");
    localStorage.removeItem("token_type");
    localStorage.removeItem("expires_in");
    localStorage.removeItem("scope");
    localStorage.removeItem("jti");
    localStorage.removeItem("refresh_token");


    localStorage.setItem("access_token", data.access_token);
    localStorage.setItem("token_type", data.token_type);
    localStorage.setItem("expires_in", new Date().setSeconds(data.expires_in) + "");
    localStorage.setItem("scope", data.scope);
    localStorage.setItem("jti", data.jti);
    localStorage.setItem("refresh_token", data.refresh_token);
    console.log(localStorage.getItem("access_token"));
    console.log(localStorage.getItem("refresh_token"));
  }

  updateTokenParseInLocalStorage() {


  }


}
