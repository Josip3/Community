import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {Music} from "../../../shared/models/music";
import {MusicService} from "../../../shared/music-service";
import {Url} from "../../../shared/config/url";

@Component({
  selector: 'app-music',
  templateUrl: './music.component.html',
  styleUrls: ['./music.component.css'],
  providers: [MusicService]
})
export class MusicComponent implements OnInit {

  audio: Music = new Music();
  audioSrc: Music = new Music();
  musics:Music[] = [];
  @ViewChild("idaudio") eraudio:ElementRef;
url:string=Url.url;
  constructor(private music:MusicService) {
    this.getAllMusic();
  }

  ngOnInit() {
  }

  addMusic(form: HTMLFormElement){
    this.music.save(this.audio).subscribe(next =>{
      this.music.saveFile(form,next.id).subscribe(next=>{
        this.audio=new Music();
        form.reset();
        this.getAllMusic();
      },err=>{console.error(err);});
    },err=>{console.error(err);});
  }

  start(){
    if(this.musics.length>0)
    this.audioSrc=this.musics[0]
  }
next(){
    console.log(this.musics.indexOf(this.audioSrc));
if(this.musics.indexOf(this.audioSrc)!=this.musics.length-1){
  this.eraudio.nativeElement.pause();
  this.audioSrc=this.musics[this.musics.indexOf(this.audioSrc)+1];
  this.eraudio.nativeElement.play();
  this.eraudio.nativeElement.autoplay=true;


}else{
  this.eraudio.nativeElement.pause();
  this.audioSrc=this.musics[0];
  this.eraudio.nativeElement.play();
  this.eraudio.nativeElement.autoplay=true;
}
}

onClick(music:Music){
  this.audioSrc=music;
  this.eraudio.nativeElement.play();
  this.eraudio.nativeElement.autoplay=true;
}
  getAllMusic(){
    this.music.getAll().subscribe(next=>{
      this.musics = next;
      this.start();
      console.log(JSON.stringify(next));
    }, err=>{
      console.error(err);
    },()=>{
      console.log('complete');
    });
  }
}
