import { Predmet } from './predmet';
import { PrijavaIspita } from './prijava-ispita';

export interface Ispit {
    datumVreme:Date;
    predmet:Predmet;
    listaPrijavaIspita:PrijavaIspita[]
}
