import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from "@angular/router";
import {Observable} from "rxjs/Observable";
import {AppComponent} from "../../app/app.component";
import {Injectable} from "@angular/core";


@Injectable()
export class CanActiveAdmin implements CanActivate {

  constructor(private _route: Router) {

  }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    if (AppComponent._userDetailsService.isAdmin)
      return AppComponent._userDetailsService.isAdmin;
    else
      this._route.navigateByUrl("/sing-in");
    return false;
  }
}
