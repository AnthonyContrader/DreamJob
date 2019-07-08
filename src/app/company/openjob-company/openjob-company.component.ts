import { Component, OnInit } from '@angular/core';
import { OpenjobDTO } from 'src/dto/openjobdto';
import { OpenjobService } from 'src/service/openjob.service';

@Component({
  selector: 'app-openjob-company',
  templateUrl: './openjob-company.component.html',
  styleUrls: ['./openjob-company.component.css']
})
export class OpenjobCompanyComponent implements OnInit {
  openjob: OpenjobDTO;
  openjobtoinsert: OpenjobDTO = new OpenjobDTO();
  idCompany: number;

  constructor(private service: OpenjobService) { }

  ngOnInit() {
    this.idCompany= JSON.parse(localStorage.getItem("idCompany"));
    this.readOpenjob(this.idCompany);
  }

  readOpenjob(idCompany: number) {
    this.service.readOpenjob(idCompany).subscribe(openjob => this.openjob = openjob);
  }

  delete(openjob: OpenjobDTO) {
    this.service.delete(openjob.id).subscribe(() => this.readOpenjob);
  }

  update(openjob: OpenjobDTO) {
    this.service.update(openjob).subscribe(() => this.readOpenjob);
  }

  clear(){
    this.openjobtoinsert = new OpenjobDTO();
  }
}
