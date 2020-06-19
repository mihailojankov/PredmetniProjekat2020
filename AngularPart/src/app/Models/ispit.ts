import { Predmet } from './predmet';
import { PrijavaIspita } from './prijava-ispita';

export interface Ispit {
    id:number;
    datumVreme:Date;
    predmet:Predmet;
    listaPrijavaIspita:PrijavaIspita[];
}
