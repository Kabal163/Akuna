import {NgModule} from '@angular/core';
import {SidebarComponent} from './sidebar.component';
import {BrowserModule} from '@angular/platform-browser';
import {HttpModule} from '@angular/http';
import {FormsModule} from '@angular/forms';
import {CommonModule} from "@angular/common";

@NgModule({
  declarations: [SidebarComponent],
  imports: [FormsModule, CommonModule],
  exports: [SidebarComponent],
  providers: []
})
export class SidebarModule {

}
