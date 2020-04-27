import { RegistrovanKorisnik } from './registrovan-korisnik';

export interface Nastavnik {
    id:number;
    biografija:string;
    jmbg:string;
    profesor:boolean;
    asistent:boolean;
    korisnik:RegistrovanKorisnik;
}
