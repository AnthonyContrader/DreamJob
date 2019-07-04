import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { CompanyLayoutComponent } from '../layout/company-layout/company-layout.component';
import { CompanyDashboardComponent } from './company-dashboard/company-dashboard.component';




const routes: Routes = [
  { path: 'company-dashboard', component: CompanyLayoutComponent, children:[
    { path: '', component: CompanyDashboardComponent},
  ]},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})

export class CompanyRoutingModule { }
