import { Nastavnik } from './nastavnik';

export interface Predmet {
    id:number;
    naziv:string;
    espb:number;
    obavezan:boolean;
    brojPredavanja:number;
    brojVezbi:number;
    godinaStudija:number;
    semestar:number;
    silabus:string;
    listaNastavnika:Nastavnik[];
}
