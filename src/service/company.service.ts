import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AbstractService } from './abstractservice';
import { Observable } from 'rxjs';
import { CompanyDTO } from 'src/dto/companydto';

@Injectable({
  providedIn: 'root'
})
export class CompanyService extends AbstractService<CompanyDTO>{
  type: string;
  port: string = '8080';

  constructor(http: HttpClient) {
    super(http);
    this.type = 'company';
  }

  getAll(): Observable<any[]>{
    return this.http.get<any[]>('http://localhost:' + this.port + '/' + this.type + '/getall');
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