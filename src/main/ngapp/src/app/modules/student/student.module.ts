import {NgModule} from '@angular/core';
import {StudentComponent} from './student.component';
import {AdminComponent} from '../admin/admin.component';
import {RouterModule} from '@angular/router';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';

let routing = RouterModule.forChild([
  {path: "", component: StudentComponent}
]);

@NgModule({
  imports: [CommonModule, FormsModule, routing],
  declarations: [StudentComponent]
})
export class StudentModule
{

}
