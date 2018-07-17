import {NgModule} from '@angular/core';
import {TeacherComponent} from './teacher.component';
import {RouterModule} from '@angular/router';
import {StudentComponent} from '../student/student.component';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';

let routing = RouterModule.forChild([
  {path: "", component: TeacherComponent}
]);

@NgModule({
  imports: [CommonModule, FormsModule, routing],
  declarations: [TeacherComponent]
})
export class TeacherModule
{

}
