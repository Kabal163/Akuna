import {AdminComponent} from './admin.component';
import {HeaderModule} from '../header/header.module';
import {AccountComponent} from '../header/components/account/account.component';
import {LogoComponent} from '../header/components/logo/logo.component';
import {NavigationComponent} from '../header/components/navigation/navigation.component';
import {HeaderComponent} from '../header/header.component';
import {CommonModule} from "@angular/common";
import {RouterModule} from "@angular/router";
import {FormsModule} from "@angular/forms";
import {NgModule} from "@angular/core";

let routing = RouterModule.forChild([
  {path: "", component: AdminComponent}
]);

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    routing,
    HeaderModule],

  declarations: [AdminComponent, HeaderComponent, NavigationComponent, LogoComponent, AccountComponent]
})
export class AdminModule
{

}
