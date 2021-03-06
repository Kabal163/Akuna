import {AdminComponent} from './admin.component';
import {CommonModule} from "@angular/common";
import {RouterModule} from "@angular/router";
import {FormsModule} from "@angular/forms";
import {NgModule} from "@angular/core";
import {HeaderModule} from "../header/header.module";
import {SidebarModule} from "../sidebar/sidebar.module";

let routing = RouterModule.forChild([
  {path: "", component: AdminComponent}
]);

@NgModule({
  imports: [
    routing,
    CommonModule,
    FormsModule,
    HeaderModule,
    SidebarModule],
  exports: [AdminComponent],
  declarations: [AdminComponent]
})
export class AdminModule
{

}
