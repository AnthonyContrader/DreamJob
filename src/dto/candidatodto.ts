import {Usertype} from './usertype';

export class CandidatoDTO {
    id: number;
    username: string;
    password: string;
    name: string;
    surname: string;
    age: number;
    tipolaurea: string;
    experience: string;
    usertype: Usertype;
}