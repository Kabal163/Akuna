import {Component} from "@angular/core";

@Component({
  selector: "account-navbar",
  templateUrl: "./account.component.html"
})
export class AccountComponent {
  token = localStorage.getItem("token");
}
