import { PrijavaIspita } from './prijava-ispita';

export interface Rok {
    id:number;
    naziv:string;
    pocetak:Date;
    kraj:Date;
    vanredan:boolean;
    listaPrijavaIspit:PrijavaIspita[]
}
