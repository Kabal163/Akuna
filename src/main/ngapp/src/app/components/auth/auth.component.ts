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

  constructor(private authService: AuthService,
              private router: Router)
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
      this.authService.register(this.userRegisterForm).subscribe(data => console.log(data));
    }
  }

  login()
  {
    this.authService.login(this.userLoginForm).subscribe(authResult => this.setSession(authResult));
  }

  private setSession(authResult) {
    console.log("setSession method");
    const rawToken = authResult.token;
    const refreshToken = authResult.refreshToken;

    const token = this.authService.getDecodedAccessToken(rawToken);

    console.log("decoded sub: " + token.sub);
    console.log("decoded exp: " + token.exp);
    console.log("decoded scopes: " + token.scopes);

    const expiresAt = moment().add(token.exp,'second');
    const role: string = this.resolveRole(token.scopes);

    localStorage.setItem('token', rawToken);
    localStorage.setItem("refreshToken", refreshToken);
    localStorage.setItem("expires_at", JSON.stringify(expiresAt.valueOf()));
    localStorage.setItem("role", role);

    this.navigateToHomePage(role);
  }

  private navigateToHomePage(role: string)
  {


    if (role === "ADMIN") this.router.navigateByUrl("/admin");
    else if (role === "TEACHER") this.router.navigateByUrl("/teacher");
    else if (role === "PARENT") this.router.navigateByUrl("/parent");
    else if (role === "STUDENT") this.router.navigateByUrl("/student");
    else
    {
      console.log("No one role is valid");
      this.authService.logout();
      this.router.navigateByUrl("/login");
    }
  }

  /* The method tries to retrieve the most important role for the user.
   *
   * Roles priority:
   * 1. ADMIN
   * 2. TEACHER
   * 3. PARENT
   * 4. STUDENT
   *
   * It needs in case when the user has multiple roles.
   */

  private resolveRole(scopes: string[]): string
  {
    let role: string;

    if (scopes.length == 0)
    {
      return null;
    }

    if (scopes.length == 1)
    {
      role = scopes[0];
    }
    else
    {
      for (let element in scopes)
      {
        if (element === "ADMIN")
        {
          role = element;
          break;
        }
        else if (element === "TEACHER")
        {
          role = element;
        }
        else if ((element === "PARENT" && !role) || role === "STUDENT")
        {
          role = element;
        }
        else if (element === "STUDENT" && !role)
        {
          role = element;
        }
      }
    }
    return role;
  }
}
