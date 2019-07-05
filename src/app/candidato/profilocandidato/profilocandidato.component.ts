import { Component, OnInit } from '@angular/core';
import { CandidatoDTO } from 'src/dto/candidatodto';
import { CandidatoService } from 'src/service/candidato.service';

@Component({
  selector: 'app-profilocandidato',
  templateUrl: './profilocandidato.component.html',
  styleUrls: ['./profilocandidato.component.css']
})
export class ProfilocandidatoComponent implements OnInit {
  candidato: CandidatoDTO;
  candidatotoinsert: CandidatoDTO = new CandidatoDTO();
  username: string;

  constructor(private service: CandidatoService) { }

  ngOnInit() {
    this.username= localStorage.getItem("username");
    this.readCandidato(this.username);
  }

  readCandidato(username: string) {
    this.service.readCandidato(username).subscribe(candidato => this.candidato = candidato);
  }

  /*getCandidato() {
    this.service.getAll().subscribe(candidato => this.candidato = candidato);
  }

  delete(candidato: CandidatoDTO) {
    this.service.delete(candidato.id).subscribe(() => this.getCandidato());
  }

  update(candidato: CandidatoDTO) {
    this.service.update(candidato).subscribe(() => this.getCandidato());
  }

  insert(candidato: CandidatoDTO) {
    this.service.insert(candidato).subscribe(() => this.getCandidato());
  }

  clear(){
    this.candidatotoinsert = new CandidatoDTO();
  }*/
}
