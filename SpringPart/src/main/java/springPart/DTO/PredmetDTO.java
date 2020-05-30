package springPart.DTO;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PredmetDTO extends AbstractDTO{
	
	String naziv;
	int espb;
	boolean obavezan;
	int brojPredavanja;
	int brojVezbi;
	String silabus;
	int godinaStudija;
	int semestar;
	
	
}
