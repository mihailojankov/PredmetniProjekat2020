import { Nastavnik } from './nastavnik';

export interface Univerzitet {
    naziv:string;
    datumOsnivanja:Date;
    drzava:string;
    adresa:string;
    mesto:string;
    opisUniverziteta:string;
    rektor:Nastavnik;
}
