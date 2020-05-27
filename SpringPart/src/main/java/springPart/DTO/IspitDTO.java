package springPart.DTO;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IspitDTO extends AbstractDTO{
	
    LocalDateTime datumVreme;
	PredmetDTO predmet;
	List<PrijavaIspitaDTO> listaPrijavaIspita;
}
