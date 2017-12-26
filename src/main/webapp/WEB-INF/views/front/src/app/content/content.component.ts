import { Component, OnInit } from '@angular/core';
import {User} from "../../shared/models/user";

@Component({
  selector: 'app-content',
  templateUrl: './content.component.html',
  styleUrls: ['./content.component.css']
})
export class ContentComponent implements OnInit {

  constructor() { }

  user:User;

  ngOnInit() {
  }

}
