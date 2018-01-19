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
  allUsers:User[]=[];


  constructor(private _userService:UserService) {
    this._userService.getAll().subscribe(next=>{
      this.users = next;
      this.allUsers = next;
      console.log(JSON.stringify(next));
    }, err=>{
      console.error(err);
    },()=>{
      console.log('complete');
    });
  }

  filter(val:string){
    this.users = this.allUsers.filter(value => value.name.toLocaleLowerCase().includes(val.toLocaleLowerCase()))    ;
  }

  ngOnInit() {
  }

}
