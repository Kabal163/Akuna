import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {UserLoginForm, UserRegisterForm} from './auth.model';
import * as moment from "moment";
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/shareReplay';
import * as jwt_decode from "jwt-decode";
import {Router} from '@angular/router';

@Injectable()
export class AuthService
{
  secretQuestionsUrl: string = "/api/auth/register/secretQuestion";
  registerUrl: string = "/api/auth/register";
  loginUrl: string = "/api/auth/login";

  constructor(private http: HttpClient,
              private router: Router){}


  getSecretQuestions()
  {
    return this.http.get(this.secretQuestionsUrl);
  }

  register(userRegisterForm: UserRegisterForm)
  {
    return this.http.post(this.registerUrl, userRegisterForm);
  }

  login(userLoginForm: UserLoginForm)
  {
    const headers = new HttpHeaders({"X-Requested-With": "XMLHttpRequest"});
    return this.http.post(this.loginUrl, userLoginForm, {headers: headers});
      //.do(res => this.setSession)
      //.shareReplay();
  }

  logout()
  {
    localStorage.removeItem("token");
    localStorage.removeItem("expires_at");
    localStorage.removeItem("refreshToken");
    this.router.navigateByUrl("/login");
  }

  public isLoggedIn() {
    return moment().isBefore(this.getExpiration());
  }

  isLoggedOut() {
    return !this.isLoggedIn();
  }

  getExpiration() {
    const expiration = localStorage.getItem("expires_at");
    const expiresAt = JSON.parse(expiration);
    return moment(expiresAt);
  }

  getDecodedAccessToken(token: string): any {
    try{
      return jwt_decode(token);
    }
    catch(Error){
      return null;
    }
  }

  getCurrentRole()
  {
    return localStorage.getItem("role");
  }

  setSession(authResult) {
    console.log("setSession method");
    const rawToken = authResult.token;
    const refreshToken = authResult.refreshToken;

    const token = this.getDecodedAccessToken(rawToken);

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

  navigateToHomePage(role: string)
  {


    if (role === "ADMIN") this.router.navigateByUrl("/admin");
    else if (role === "TEACHER") this.router.navigateByUrl("/teacher");
    else if (role === "PARENT") this.router.navigateByUrl("/parent");
    else if (role === "STUDENT") this.router.navigateByUrl("/student");
    else
    {
      console.log("No one role is valid");
      this.logout();
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

  resolveRole(scopes: string[]): string
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
