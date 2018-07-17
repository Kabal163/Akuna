import {NgModule} from "@angular/core";
import {AccountComponent} from "./components/account/account.component";
import {BrowserModule} from "@angular/platform-browser";
import {FormsModule} from "@angular/forms";
import {LogoComponent} from "./components/logo/logo.component";
import {NavigationComponent} from "./components/navigation/navigation.component";
import {HeaderComponent} from './header.component';

@NgModule({
  declarations: [AccountComponent, LogoComponent, NavigationComponent],
  imports: [BrowserModule, FormsModule],
  exports: [AccountComponent, LogoComponent, NavigationComponent, HeaderComponent],
  providers: []
})
export class HeaderModule {

}
