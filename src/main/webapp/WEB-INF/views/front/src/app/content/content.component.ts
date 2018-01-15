import {Component, OnInit} from '@angular/core';
import {User} from "../../shared/models/user";
import {AppComponent} from "../app.component";
import {Router} from "@angular/router";
import {UserService} from "../../shared/user.service";
import {MusicService} from "../../shared/music-service";
import {Music} from "../../shared/models/music";

@Component({
  selector: 'app-content',
  templateUrl: './content.component.html',
  styleUrls: ['./content.component.css'],
  providers: [UserService,MusicService]
})
export class ContentComponent implements OnInit {
  user: User;
  music: Music;

  constructor(private _router: Router, private _userService: UserService, private _musicService: MusicService) {
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

  musicList(){

  }

  // saveMusic(musicFile: any){
  //   const file = musicFile.files[0];
  //   const formDate = new FormData();
  //   formDate.append('perfomerName',this.)
  //
  //   this._musicService.save(new FormData(music)).subscribe(next => {
  //   }, err => {
  //     console.error(err);
  //   });

  // }
  saveImage(form: HTMLFormElement) {
    this._userService.saveImage(new FormData(form), this.user.id).subscribe(next => {
      this.user = next;
    }, err => {
      console.error(err);
    });
  }

}
