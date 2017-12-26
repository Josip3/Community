import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';


import {AppComponent} from './app.component';
import {AdminComponent} from './admin/admin.component';
import {ContentComponent} from './content/content.component';
import {RegistrationComponent} from './registration/registration.component';
import {UserComponent} from './user/user.component';
import {RouterModule, Routes} from "@angular/router";
import {FormsModule} from "@angular/forms";
import {AuthInterceptor} from "../shared/auth-inteceptor";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {CanActiveAdmin} from "../shared/can-active/can-active-admin";

const routes: Routes = [
  {path: '', redirectTo: 'sing-in', pathMatch: 'full'},
  {path: 'login', redirectTo: 'sing-in', pathMatch: 'full'},
  {path: 'admin', component: AdminComponent, canActivate: [CanActiveAdmin]},
  {path: 'sing-in', component: RegistrationComponent},
  {path: 'sign-up', component: RegistrationComponent},
  {path: 'community', component: ContentComponent},
  {path: 'user/:id', component: UserComponent},
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
    FormsModule,
    HttpClientModule,
    BrowserModule,
    RouterModule.forRoot(routes, {useHash: true}),
  ],
  providers: [
    CanActiveAdmin,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
