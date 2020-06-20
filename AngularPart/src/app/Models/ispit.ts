import { Predmet } from './predmet';
import { PrijavaIspita } from './prijava-ispita';
import { Rok } from './rok';

export interface Ispit {
    id:number;
    datumVreme:Date;
    predmet:Predmet;
    listaPrijavaIspita:PrijavaIspita[];
    rok:Rok;
}
