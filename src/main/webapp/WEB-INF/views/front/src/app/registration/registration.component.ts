import {Component, OnInit} from '@angular/core';
import {AppComponent} from '../app.component';
import {isNullOrUndefined} from 'util';
import {LoginService} from './login.service';
import {Router} from '@angular/router';
import {User} from '../../shared/models/user';
import {UserService} from '../../shared/user.service';
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css'],
  providers: [LoginService, UserService]
})
export class RegistrationComponent implements OnInit {

  user: User = new User();
  formGroup = new FormGroup({
    rePass: new FormControl('', Validators.required),
    mail: new FormControl('', Validators.email)
  });
  validMail = true;

  constructor(private _loginService: LoginService, private _userService: UserService, private _route: Router) {
  }

  ngOnInit() {
  }

  auth(login: HTMLInputElement, password: HTMLInputElement) {
    this._loginService.sendCredentials({username: login.value, password: password.value}).subscribe(next => {
      console.log(next);
      AppComponent._userDetailsService.tokenParseInLocalStorage(next);
      this._loginService.getUser().subscribe(next => {
        console.log('token' + isNullOrUndefined(next));
        console.log('token ' + JSON.stringify(next));
        AppComponent._userDetailsService.login(next);
        if (next.role == 'ROLE_ADMIN') {
          localStorage.setItem('ADMIN', 'ADMIN');
          this._route.navigateByUrl('/admin');
        } else {
          this._route.navigateByUrl('/community');
        }
      }, error => {
        console.error(error);
      });
    }, error => {
      console.error(error);
    });
  }

  registration() {
    if (!this.validateMail())
      return;
    this._userService.save(this.user).subscribe(next => {
      AppComponent._userDetailsService.user = next;
      this.user = new User();
      this.formGroup.reset();
    }, error => {
      console.error(error);
    });
    console.log(JSON.stringify(this.user));

  }

  validateMail(): boolean {
    if (!isNullOrUndefined(this.user.email)) {
      if (this.user.email.includes('@') && !this.user.email.includes(' ') && this.user.email.split('@').length == 2) {
        this.validMail = this.user.email.split('@')[1].includes('.');
        return this.user.email.split('@')[1].includes('.');
      }
    }
    this.validMail = false;
    return false;
  }

}
