import {Component, OnInit} from '@angular/core';
import {User} from "../../shared/models/user";
import {AppComponent} from "../app.component";
import {Router} from "@angular/router";
import {UserService} from "../../shared/user.service";
import {MusicService} from "../../shared/music-service";
import {Music} from "../../shared/models/music";
import {LoginService} from "../registration/login.service";
import {isNullOrUndefined} from "util";

@Component({
  selector: 'app-content',
  templateUrl: './content.component.html',
  styleUrls: ['./content.component.css'],
  providers: [UserService,MusicService,LoginService]
})
export class ContentComponent implements OnInit {
  user: User;
  music: Music;

  constructor(private _router: Router, private _userService: UserService, private _loginService: LoginService) {
    this.user = AppComponent._userDetailsService.user;
    console.log(this.user.id);
    if (isNullOrUndefined(this.user.id)&& AppComponent._userDetailsService.checkAuth()){
      console.log("mi nensli usera no token e");
      _loginService.getUser().subscribe(next =>{
        this.user = next;
        console.log(JSON.stringify(next));
        AppComponent._userDetailsService.user = next;
      });
    }
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

  saveImage(form: HTMLFormElement) {
    this._userService.saveImage(new FormData(form), this.user.id).subscribe(next => {
      this.user = next;
    }, err => {
      console.error(err);
    });
  }

}
