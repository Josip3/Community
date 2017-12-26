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
    ahtp
    }
}
