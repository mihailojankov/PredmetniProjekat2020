import { Predmet } from './predmet';
import { Fakultet } from './fakultet';

export interface SmerFakulteta {
    id:number;
    naziv:string;
    opis:string;
    predmeti:Predmet[];
    fakultet:Fakultet;
}
