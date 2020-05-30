import { RegistrovanKorisnik } from './registrovan-korisnik';
import { Predmet } from './predmet';

export interface Nastavnik {
    id:number;
    biografija:string;
    jmbg:string;
    profesor:boolean;
    asistent:boolean;
    korisnik:RegistrovanKorisnik;
    predmeti:Predmet[];
}
