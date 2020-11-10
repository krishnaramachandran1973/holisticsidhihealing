import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MainComponent } from './main/main.component';
import { BriefComponent } from './brief/brief.component';
import { DisplayComponent } from './display/display.component';
import {RouterModule, Routes} from "@angular/router";
import {NgxPaginationModule} from "ngx-pagination";

export const routes: Routes = [
  {path: '', component: BriefComponent, data: {breadcrumb: 'Blog-Brief'}},
  {path: ':id', component: DisplayComponent, data: {breadcrumb: 'Blog'}}
]


@NgModule({
  declarations: [
    MainComponent,
    BriefComponent,
    DisplayComponent],
  exports: [
    MainComponent,
    BriefComponent,
    DisplayComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    NgxPaginationModule
  ]
})
export class BlogModule { }
