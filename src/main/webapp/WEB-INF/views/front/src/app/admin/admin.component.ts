import {Component, OnInit} from '@angular/core';
import {User} from "../../shared/models/user";
import {isNullOrUndefined} from "util";

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  users: User[] = [];


  constructor() {

    this.test();

  }

  delete(user:User) {

    alert("delete:[" + user.id + "]");
  }

  updateName(user:User) {

    alert("updateName:[" + user.id + "]name:[" + user.name + "]");
  }

  updateLastName(user:User) {

    alert("updateLastName:[" + user.id + "]lastName:[" + user.lastName + "]");
  }

  updateAge(user:User) {

    alert("updateAge:[" + user.id + "]age:[" + user.age + "]");
  }

  test() {
    for (let i = 0; i < 10; i++) {
      let one = new User();
      one.id = i;
      one.age = i;
      one.lastName = i+"lastName";
      one.name = i+"name";
      this.users.push(one)
    }
  }

  wrapperHTML(obj) {
    if (isNullOrUndefined(obj)) {
      return "";
    }
    return obj;
  }

  ngOnInit() {
  }

}
