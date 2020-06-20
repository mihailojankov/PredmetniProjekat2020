package springPart.DTO;

import java.time.LocalDateTime;
import java.util.List;

public class IspitDTO extends AbstractDTO{
	
    LocalDateTime datumVreme;
	PredmetDTO predmet;
	public LocalDateTime getDatumVreme() {
		return datumVreme;
	}
	public void setDatumVreme(LocalDateTime datumVreme) {
		this.datumVreme = datumVreme;
	}
	public PredmetDTO getPredmet() {
		return predmet;
	}
	public void setPredmet(PredmetDTO predmet) {
		this.predmet = predmet;
	}
	
	
}
