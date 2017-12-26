import {Injectable} from "@angular/core";
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from "@angular/router";
import {Observable} from "rxjs/Observable";
import {AppComponent} from "../../app/app.component";

@Injectable()
export class CanActiveLogin implements CanActivate {


  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    return !AppComponent._userDetailsService.isAuth;
  }
}
