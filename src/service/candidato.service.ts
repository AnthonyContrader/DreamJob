import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { CandidatoDTO } from 'src/dto/candidatodto';
import { HttpClient } from '@angular/common/http';
@Injectable({
    providedIn: 'root'
  })
  export class CandidatoService extends AbstractService<CandidatoDTO>{
  
    constructor(http: HttpClient) {
      super(http);
      this.type = 'candidato';
    }

    methodprova(){}
}