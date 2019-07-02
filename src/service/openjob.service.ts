import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { OpenjobDTO } from 'src/dto/openjobdto';
import { HttpClient } from '@angular/common/http';

@Injectable({
    providedIn: 'root'
  })
export class OpenjobService extends AbstractService<OpenjobDTO>{
  
    constructor(http: HttpClient) {
        super(http);
        this.type = 'openjob';
      }

}