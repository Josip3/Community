import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {UserService} from "../../../shared/user.service";
import {MusicService} from "../../../shared/music-service";
import {Music} from "../../../shared/models/music";
import {Url} from "../../../shared/config/url";
import {AppComponent} from "../../app.component";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-friend-music',
  templateUrl: './friend-music.component.html',
  styleUrls: ['./friend-music.component.css'],
  providers: [MusicService, UserService]

})
export class FriendMusicComponent implements OnInit {

  audio: Music = new Music();
  audioSrc: Music = new Music();
  musics: Music[] = [];
  @ViewChild("idaudio") eraudio: ElementRef;
  url: string = Url.url;


  constructor(private music: MusicService, private userService: UserService, private router: ActivatedRoute) {
    router.params.subscribe(next => {
      this.getAllMusic(next["id"]);
    });
  }

  ngOnInit() {
  }


  start() {
    if (this.musics.length > 0)
      this.audioSrc = this.musics[0]
  }

  next() {
    console.log(this.musics.indexOf(this.audioSrc));
    if (this.musics.indexOf(this.audioSrc) != this.musics.length - 1) {
      this.eraudio.nativeElement.pause();
      this.audioSrc = this.musics[this.musics.indexOf(this.audioSrc) + 1];
      this.eraudio.nativeElement.play();
      this.eraudio.nativeElement.autoplay = true;


    } else {
      this.eraudio.nativeElement.pause();
      this.audioSrc = this.musics[0];
      this.eraudio.nativeElement.play();
      this.eraudio.nativeElement.autoplay = true;
    }
  }

  onClick(music: Music) {
    this.audioSrc = music;
    this.eraudio.nativeElement.play();
    this.eraudio.nativeElement.autoplay = true;
  }


  getAllMusic(id: number) {
    this.userService.myMusic(id).subscribe(next => {
      this.musics = next;
      this.start();
      console.log(JSON.stringify(next));
    }, err => {
      console.error(err);
    }, () => {
      console.log('complete');
    });
  }
}
