import {NgModule} from '@angular/core';
import {SidebarComponent} from './sidebar.component';
import {BrowserModule} from '@angular/platform-browser';
import {HttpModule} from '@angular/http';
import {FormsModule} from '@angular/forms';
import {AppRoutingModule} from '../routing/routing.module';

@NgModule({
  declarations: [SidebarComponent],
  imports: [BrowserModule, FormsModule, AppRoutingModule],
  exports: [SidebarComponent],
  providers: []
})
export class SidebarModule {

}
