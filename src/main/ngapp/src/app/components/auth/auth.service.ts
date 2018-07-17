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

  constructor(private http: HttpClient){}

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

  }



}
