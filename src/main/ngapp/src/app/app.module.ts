import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import {HttpClientModule} from '@angular/common/http';
import {CallService} from './services/call.service';
import {GetTokenService} from './services/getToken.service';
import {AuthService} from './components/auth/auth.service';
import {RouterModule} from '@angular/router';
import {AuthComponent} from './components/auth/auth.component';

@NgModule({
  declarations: [
    AppComponent,
    AuthComponent],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot([
      {path: "admin", loadChildren: "app/modules/admin/admin.module#AdminModule"},
      {path: "teacher", loadChildren: "app/modules/teacher/teacher.module#TeacherModule"},
      {path: "student", loadChildren: "app/modules/student/student.module#StudentModule"},
      {path: "login", component: AuthComponent}
    ])
  ],
  providers: [CallService, GetTokenService, AuthService],
  bootstrap: [AppComponent]
})
export class AppModule {

}
