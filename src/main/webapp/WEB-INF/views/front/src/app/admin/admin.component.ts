import {Component, OnInit} from '@angular/core';
import {User} from '../../shared/models/user';
import {isNullOrUndefined} from 'util';
import {UserService} from '../../shared/user.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css'],
  providers: [UserService],
})
export class AdminComponent implements OnInit {

  users: User[] = [];


  constructor(private _userService: UserService) {
    this._userService.getAll().subscribe(next => {
      this.users = next;
    }, error => {
      console.error(error);
    });
    //
    // this.test();

  }

  delete(user: User) {
    this._userService.delete(user.id).subscribe(next => {
      console.log(next);
    }, error => {
      console.error(error);
    });

    // alert('delete:[' + user.id + ']');
  }

  updateName(user: User) {
    this._userService.updateName(user).subscribe(next => {
      console.log(next);
    }, error => {
      console.error(error);
    });

    // alert('updateName:[' + user.id + ']name:[' + user.name + ']');
  }

  updateLastName(user: User) {
    this._userService.updateLastName(user).subscribe(next => {
      console.log(next);
    }, error => {
      console.error(error);
    });

    // alert('updateLastName:[' + user.id + ']lastName:[' + user.lastName + ']');
  }

  updateAge(user: User) {
    this._userService.updateAge(user).subscribe(next => {
      console.log(next);
    }, error => {
      console.error(error);
    });

    // alert('updateAge:[' + user.id + ']age:[' + user.age + ']');
  }

  test() {
    for (let i = 0; i < 10; i++) {
      const one = new User();
      one.id = i;
      one.age = i;
      one.lastName = i + 'lastName';
      one.name = i + 'name';
      this.users.push(one);
    }
  }

  wrapperHTML(obj) {
    if (isNullOrUndefined(obj)) {
      return '';
    }
    return obj;
  }

  ngOnInit() {
  }

}
