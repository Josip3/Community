import { Component, OnInit } from '@angular/core';
import {Music} from "../../../shared/models/music";
import {MusicService} from "../../../shared/music-service";

@Component({
  selector: 'app-music',
  templateUrl: './music.component.html',
  styleUrls: ['./music.component.css'],
  providers: [MusicService]
})
export class MusicComponent implements OnInit {

  audio: Music = new Music();

  constructor(private music:MusicService) { }

  ngOnInit() {
  }

  addMusic(form: HTMLFormElement){
    this.music.save(this.audio).subscribe(next =>{
      this.music.saveFile(form,next.id).subscribe(next=>{
        this.audio=new Music();
        form.reset();
      },err=>{console.error(err);});
    },err=>{console.error(err);});
  }
}
