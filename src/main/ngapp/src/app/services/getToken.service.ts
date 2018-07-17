import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {CallService} from './call.service';

@Injectable()
export class GetTokenService
{
  url: string = "/api/auth/token";

  constructor(private http: HttpClient){}

  getToken()
  {
    const refreshToken = localStorage.getItem("refreshToken");
    const headers = new HttpHeaders({"Authorization": "bearer " + refreshToken});

    this.http.get(this.url, {headers}).subscribe((data: JSON) =>
      {
        localStorage.setItem("token", data.parse("token"));
        localStorage.setItem("refreshToken", data.parse("refreshToken"));
      });
  }
}
