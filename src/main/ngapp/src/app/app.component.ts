import { Component } from "@angular/core";
import {Router} from '@angular/router';
import {AuthService} from './components/auth/auth.service';

@Component({
	selector: "todo-app",
	templateUrl: "./app.component.html"
})
export class AppComponent
{

  constructor(private router: Router,
              private auth: AuthService)
  {
    if (this.auth.isLoggedOut())
    {
      this.router.navigateByUrl("/login");
    }
    else
    {

    }
  }



}
