import { Student } from './student';
import { Rok } from './rok';
import { Ispit } from './ispit';

export interface PrijavaIspita {
    datumPrijave:Date;
    student:Student;
    rok:Rok;
    ispit:Ispit
}
