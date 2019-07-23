import { AbstractCompanyService } from './abstractcompanyservices.service';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { OpenjobDTO } from 'src/dto/openjobdto';

@Injectable({
  providedIn: 'root'
})
export class OpenjobService extends AbstractCompanyService<OpenjobDTO>{
 
  constructor(http: HttpClient) {
    super(http);
    this.type = 'openjob';
    this.name= 'Micro1';
    this.port = '8080';
  }

  userLogged(username: string) {
    // console.log('qua: ', this.auth());
     console.log(this.auth());
     return this.http.get('http://localhost:8080/api/users/' + username, {
       headers: {
         Authorization: this.auth()
       }
     });
   }
   
   getallbycompany(Company: any): Observable<any>{
    return this.http.get<any[]>('http://localhost:' + this.port + '/' + this.type + '/getallbycompany?Company=' + Company);
  }

  readOpenjob(id: number): Observable<any>{
    return this.http.get<any[]>('http://localhost:' + this.port + '/' + this.name + '/' + 'api' + '/openjobs' + id);
  }

}
