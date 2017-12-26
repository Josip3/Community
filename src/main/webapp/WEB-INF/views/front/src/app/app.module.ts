import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { AdminComponent } from './admin/admin.component';
import { ContentComponent } from './content/content.component';
import { RegistrationComponent } from './registration/registration.component';
import { UserComponent } from './user/user.component';
import {Routes} from "@angular/router";

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'test/:id', component: TestComponent},
];


@NgModule({
  declarations: [
    AppComponent,
    AdminComponent,
    ContentComponent,
    RegistrationComponent,
    UserComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
