import {NgModule} from "@angular/core";
import {AccountComponent} from "./components/account/account.component";
import {FormsModule} from "@angular/forms";
import {LogoComponent} from "./components/logo/logo.component";
import {HeaderComponent} from './header.component';
import {CommonModule} from "@angular/common";
import {AuthService} from "../../components/auth/auth.service";

@NgModule({
  declarations: [AccountComponent, LogoComponent, HeaderComponent],
  exports: [AccountComponent, LogoComponent, HeaderComponent],
  imports: [FormsModule, CommonModule],
  providers: []
})
export class HeaderModule {

}
