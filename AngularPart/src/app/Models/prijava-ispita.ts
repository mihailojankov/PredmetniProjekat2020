import { Student } from './student';
import { Rok } from './rok';
import { Ispit } from './ispit';

export interface PrijavaIspita {
    id:number;
    datumPrijave:Date;
    student:Student;
    rok:Rok;
    ispit:Ispit
}
