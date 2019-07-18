import { Component, OnInit } from '@angular/core';
import { CompanyDTO } from 'src/dto/companydto';
import { CompanyService } from 'src/service/company.service';

@Component({
  selector: 'app-profilo-company',
  templateUrl: './profilo-company.component.html',
  styleUrls: ['./profilo-company.component.css']
})
export class ProfiloCompanyComponent implements OnInit {
  company: CompanyDTO;
  companytoinsert: CompanyDTO = new CompanyDTO();
  username: string;

  constructor(private service: CompanyService) { }

  ngOnInit() {
    this.username= localStorage.getItem("username");
    this.readCompany(this.username);
  }

  readCompany(username: string) {
    this.service.readCompany(username).subscribe(company => this.company = company);
  }

  delete(company: CompanyDTO) {
    this.service.delete(company.id).subscribe(() => this.readCompany);
  }

  update(company: CompanyDTO) {
    this.service.update(company).subscribe(() => this.readCompany);
  }

  clear(){
    this.companytoinsert = new CompanyDTO();
  }
}

