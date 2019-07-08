import { Component, OnInit } from '@angular/core';
import { CandidatoDTO } from 'src/dto/candidatodto';
import { CandidatoService } from 'src/service/candidato.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-profilocandidato',
  templateUrl: './profilocandidato.component.html',
  styleUrls: ['./profilocandidato.component.css']
})
export class ProfilocandidatoComponent implements OnInit {
  candidato: CandidatoDTO;
  candidatotoinsert: CandidatoDTO = new CandidatoDTO();
  username: string;
  router: Router;

  constructor(private service: CandidatoService) { }

  ngOnInit() {
    this.username= localStorage.getItem("username");
    this.readCandidato(this.username);
  }

  readCandidato(username: string) {
    this.service.readCandidato(username).subscribe(candidato => this.candidato = candidato);
  }

  delete(candidato: CandidatoDTO) {
    this.service.delete(candidato.id).subscribe(() => this.readCandidato);
  }

  update(candidato: CandidatoDTO) {
    this.service.update(candidato).subscribe(() => this.readCandidato);
  }

  clear(){
    this.candidatotoinsert = new CandidatoDTO();
  }
}
