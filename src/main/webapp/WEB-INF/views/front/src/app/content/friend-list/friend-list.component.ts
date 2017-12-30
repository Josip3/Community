import { Component, OnInit } from '@angular/core';
import {User} from "../../../shared/models/user";
import {UserService} from "../../../shared/user.service";

@Component({
  selector: 'app-friend-list',
  templateUrl: './friend-list.component.html',
  styleUrls: ['./friend-list.component.css'],
  providers: [UserService]
})
export class FriendListComponent implements OnInit {

  users:User[] = [];


  constructor(private _userService:UserService) {
    this._userService.getAll().subscribe(next=>{
      this.users = next;
      console.log(JSON.stringify(next));
    }, err=>{
      console.error(err);
    },()=>{
      console.log('complete');
    });
  }

  ngOnInit() {
  }

}
