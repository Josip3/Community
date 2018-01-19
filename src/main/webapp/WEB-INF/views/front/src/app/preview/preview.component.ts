import {Component, Input, OnInit} from '@angular/core';
import {User} from "../../shared/models/user";
import {AppComponent} from "../app.component";
import {ActivatedRoute, Router} from "@angular/router";
import {UserService} from "../../shared/user.service";



@Component({
  selector: 'app-preview',
  templateUrl: './preview.component.html',
  styleUrls: ['./preview.component.css'],
  providers: [UserService]


})
export class PreviewComponent implements OnInit {

  user: User = new User();

  constructor(private _router: Router, private _userService: UserService,private route: ActivatedRoute) {
    route.params.subscribe(next =>{
      _userService.getOne(next["id"]).subscribe(next =>{
        this.user = next;
      })
    });
  }


  ngOnInit() {
  }

  toFriends() {
    this._router.navigateByUrl('community/friends');
  }

  logout() {
    AppComponent._userDetailsService.rmTokenParseInLocalStorage();
    this._router.navigateByUrl('login');
  }



}
