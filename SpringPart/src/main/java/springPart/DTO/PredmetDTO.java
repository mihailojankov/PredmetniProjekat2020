package springPart.DTO;

import java.util.List;
public class PredmetDTO {
	
	Long id;
	String naziv;
	int espb;
	boolean obavezan;
	int brojPredavanja;
	int brojVezbi;
	//int drugiObliciNastave
	//int istrazivackiRad
	//int ostaliCasovi
	int godinaStudija;
	int semestar;
	NastavnikDTO profesor;
	NastavnikDTO asistent;
	List<StudentDTO> listaStudenata;
	List<SmerFakultetaDTO> listaSmerovaFakulteta;
}
