import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/observable/throw';
import 'rxjs/add/operator/catch';
import {User} from './models/user';
import {Music} from "./models/music";

// це сервіс, він необхідний для спілкування з сервером
// тут ми дістаєм інфу, надсилаєм її

@Injectable()
export class MusicService {
  constructor(private httpClient: HttpClient) {
  }


  save(music: Music): Observable<Response> {
    return this.httpClient.post('/music/save', music, {headers: new HttpHeaders().set('no-auth', '')}).catch(err => Observable.throw(err));
  }


}
