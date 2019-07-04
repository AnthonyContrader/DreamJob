import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CompanyDashboardComponent } from './company-dashboard/company-dashboard.component';
import { LayoutModule} from '../layout/layout.module';
import { CompanyRoutingModule } from './company-routing.module';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [CompanyDashboardComponent],
  imports: [
    CommonModule,
    CompanyRoutingModule,
    FormsModule,
    LayoutModule
  ]
})
export class CompanyModule { }
