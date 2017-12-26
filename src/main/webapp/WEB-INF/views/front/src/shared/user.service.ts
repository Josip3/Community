import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from "rxjs/Observable";
import "rxjs/add/observable/throw";
import "rxjs/add/operator/catch";
import {User} from "./models/user";

@Injectable()
export class UserService{
    constructor(private httpClient: HttpClient) {
    }

    save(user:User):Observable<User>{
    return this.httpClient.post<User>("/registration/save",JSON.stringify(user)).catch(err=>Observable.throw(err));
    }

    getAll():Observable<User[]>{
      return this.httpClient.get<User[]>("/admin/get-all-user").catch(err => Observable.throw(err));
    }

    getOne(id:number):Observable<User>{
      return this.httpClient.get<User>("/main/" + id).catch(err => Observable.throw(err));
    }

    delete(id:number):Observable<boolean>{
        return this.httpClient.delete<boolean>("/registration/delete",JSON.stringify({id:id})).catch(err => Observable.throw(err));
    }

    update(user:User):Observable<User>{
        return this.httpClient.post<User>("/registration/update",JSON.stringify(user)).catch(err=>Observable.throw(err));
    }
}
