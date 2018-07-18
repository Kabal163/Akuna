import {Component} from "@angular/core";
import {AuthService} from "../../../../components/auth/auth.service";

@Component({
  selector: "account-navbar",
  templateUrl: "./account.component.html"
})
export class AccountComponent {

  constructor(private authService: AuthService){}

  isLoggedIn()
  {
    return this.authService.isLoggedIn();
  }

  logout()
  {
    this.authService.logout();
  }

}
