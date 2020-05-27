package springPart.DTO;

import java.time.LocalDate;
import java.util.List;

public class RokDTO extends AbstractDTO{
	
	String naziv;
	LocalDate pocetak;
	LocalDate kraj;
	boolean vanredan;
	List<PrijavaIspitaDTO> listaPrijavaIspita;
	
}
