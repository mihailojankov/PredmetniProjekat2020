import { PrijavaIspita } from './prijava-ispita';

export interface Rok {
    naziv:string;
    pocetak:Date;
    kraj:Date;
    vanredan:boolean;
    listaPrijavaIspit:PrijavaIspita[]
}
