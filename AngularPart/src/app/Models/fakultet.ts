import { SmerFakulteta } from './smer-fakulteta';

export interface Fakultet {
    id:number;
    naziv:string;
    adresa:string;
    mesto:string;
    opis:string;
    smerovi:SmerFakulteta[];
}
