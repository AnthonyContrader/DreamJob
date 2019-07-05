import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AbstractService } from './abstractservice';
import { CandidatoDTO } from 'src/dto/candidatodto';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class CandidatoService extends AbstractService<CandidatoDTO>{
  type: string;
  port: string = '8080';

  constructor(http: HttpClient) {
    super(http);
    this.type = 'candidato';
  }

  getAll(): Observable<any[]>{
    return this.http.get<any[]>('http://localhost:' + this.port + '/' + this.type + '/getall');
  }

  readCandidato(username: string): Observable<any[]>{
    return this.http.get<any[]>('http://localhost:' + this.port + '/' + this.type + '/readCandidato?username=' +username);
  }

  read(id: number): Observable<any> {
    return this.http.get<any>('http://localhost:' + this.port + '/' + this.type + '/read?id=' + id);
  }

  delete(id: number): Observable<any> {
      return this.http.delete('http://localhost:' + this.port + '/' + this.type + '/delete?id=' + id);
  } 

  insert(dto: any): Observable<any> {
      return this.http.post('http://localhost:' + this.port + '/' + this.type + '/insert', dto);
  }

  update(dto: any): Observable<any> {
      return this.http.put<any>('http://localhost:' + this.port + '/' + this.type + '/update', dto);
  }
  
}
