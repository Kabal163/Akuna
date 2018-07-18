import {Component} from '@angular/core';
import {UserLoginForm, UserRegisterForm, SecretQuestion, Token} from './auth.model';
import {AuthService} from './auth.service';
import * as moment from "moment";
import {Router} from '@angular/router';

@Component({
  selector: "login-page",
  templateUrl: "./auth.component.html",
  styleUrls: ["./auth.component.css"]
})
export class AuthComponent {
  principle: string;
  credential: string;

  userLoginForm: UserLoginForm = new UserLoginForm();
  userRegisterForm: UserRegisterForm = new UserRegisterForm();
  secretQuestions: SecretQuestion[];

  rememberMe: boolean;
  loginAction: boolean;
  differentPasswords: boolean;

  constructor(private authService: AuthService)
  {
    this.principle = localStorage.getItem("login");
    this.credential = localStorage.getItem("password");
    this.loginAction = true;

    this.authService.getSecretQuestions().subscribe((data: SecretQuestion[]) => this.secretQuestions = data);
  }

  register()
  {
    if (this.userRegisterForm.confirmPassword != this.userRegisterForm.password)
    {
      this.differentPasswords = true;
    }
    else
    {
      this.differentPasswords = false;
      console.log(this.userRegisterForm);
      this.authService.register(this.userRegisterForm).subscribe(data =>
      {
        console.log(data);
        this.userLoginForm.username = this.userRegisterForm.email;
        this.userLoginForm.password = this.userRegisterForm.password;

        this.login()
      });


    }
  }

  login()
  {
    this.authService.login(this.userLoginForm).subscribe(authResult => this.authService.setSession(authResult));
  }


}
