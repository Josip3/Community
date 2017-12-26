import {Component} from '@angular/core';
import {UserDetailsService} from "../shared/user-details-service.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';
 static _userDetailsService: UserDetailsService = new UserDetailsService();

}
