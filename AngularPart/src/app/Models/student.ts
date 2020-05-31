import { RegistrovanKorisnik } from './registrovan-korisnik';
import { Predmet } from './predmet';

export interface Student {
    id:number
    jmbg:string;
    datumRodjenja:Date;
    brojIndeksa:string;
    mestoRodjenja:string;
    drzavaRodjenja:string;
    vanredni:boolean;
    godinaUpisa:string;
    korisnik:RegistrovanKorisnik;
    listaPredmeta:Predmet[]
}
