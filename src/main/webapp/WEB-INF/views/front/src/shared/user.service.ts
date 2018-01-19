import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/observable/throw';
import 'rxjs/add/operator/catch';
import {User} from './models/user';
import {Music} from "./models/music";

// це сервіс, він необхідний для спілкування з сервером
// тут ми дістаєм інфу, надсилаєм її

@Injectable()
export class UserService {
  constructor(private httpClient: HttpClient) {
  }

  addMusic(idMusic: number,idUser: number): Observable<User>{
    return this.httpClient.post<User>('/registration/add-music',
      null,
      {params: new HttpParams().set("idMusic",idMusic +'').set("idUser",idUser+'')}).catch(err => Observable.throw(err));
  }

  myMusic(idUser: number): Observable<Music[]>{
    return this.httpClient.get<Music[]>('/registration/my-music/' + idUser).catch(err => Observable.throw(err));
  }

  save(user: User): Observable<User> {
    user.age = 18;
    return this.httpClient.post<User>('/registration/save', JSON.stringify(user), {headers: new HttpHeaders().set('no-auth', '')}).catch(err => Observable.throw(err));
  }

  getAll(): Observable<User[]> {
    return this.httpClient.get<User[]>('/admin/get-all-users').catch(err => Observable.throw(err));
  }

  getOne(id: number): Observable<User> {
    return this.httpClient.get<User>('/main/' + id).catch(err => Observable.throw(err));
  }

  delete(id: number): Observable<boolean> {
    return this.httpClient.delete<boolean>('/registration/delete/' + id).catch(err => Observable.throw(err));
  }

  update(user: User): Observable<User> {
    return this.httpClient.post<User>('/registration/update', JSON.stringify(user)).catch(err => Observable.throw(err));
  }

  updateName(user: User): Observable<User> {
    return this.httpClient.post<User>('/registration/update/name', JSON.stringify(user), {headers: new HttpHeaders().set('Content-Type', 'application/json')}).catch(err => Observable.throw(err));
  }

  updateLastName(user: User): Observable<User> {
    return this.httpClient.post<User>('/registration/update/last-name', JSON.stringify(user)).catch(err => Observable.throw(err));
  }

  updateAge(user: User): Observable<User> {

    return this.httpClient.post<User>('/registration/update/age', JSON.stringify(user)).catch(err => Observable.throw(err));
  }

  saveImage(data: FormData, id: number): Observable<User> {
    return this.httpClient.post('/registration/save-image/' + id, data,{headers:new HttpHeaders().set('multipart','enctype')}).catch(err => Observable.throw(err));
  }
}
