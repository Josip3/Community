import {Component, OnInit} from '@angular/core';
import {User} from "../../shared/models/user";
import {AppComponent} from "../app.component";
import {Router} from "@angular/router";
import {UserService} from "../../shared/user.service";

@Component({
  selector: 'app-content',
  templateUrl: './content.component.html',
  styleUrls: ['./content.component.css'],
  providers: [UserService]
})
export class ContentComponent implements OnInit {
  user: User;

  constructor(private _router: Router, private _userService: UserService) {
    this.user = AppComponent._userDetailsService.user;
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
