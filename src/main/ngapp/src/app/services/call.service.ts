import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Injectable()
export class CallService
{
  constructor(private http: HttpClient) {}

  postCall(url: string, body: any)
  {
    const headers = new HttpHeaders();
    headers.append("X-Authorization", "Bearer " + localStorage.getItem("token"));
    return this.http.post(url, body, {headers});
  }

  getCall(url: string, body: any)
  {
    const headers = new HttpHeaders();
    headers.append("X-Authorization", "Bearer " + localStorage.getItem("token"));
    return this.http.get(url, {headers});
  }
}
