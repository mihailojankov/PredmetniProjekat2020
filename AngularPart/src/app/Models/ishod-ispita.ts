import { Student } from './student';
import { Predmet } from './predmet';

export interface IshodIspita {
    id:number,
    prviKolokvijumBodovi:number;
    drugiKolokvijumBodovi:number;
    zavrsniIspitBodovi:number;
    polozen:boolean;
    student:Student;
    predmet:Predmet
}
