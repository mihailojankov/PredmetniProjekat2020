import { RegistrovanKorisnik } from './registrovan-korisnik';
import { Predmet } from './predmet';

export interface Student {
    jmbg:string;
    datumRodjenja:Date;
    brojIndeksa:string;
    mestoRodjenja:string;
    drzavaRodjenja:string;
    vanredni:boolean;
    godinaUpisa:Date;
    korisnik:RegistrovanKorisnik;
    listaPredmeta:Predmet[]
}
