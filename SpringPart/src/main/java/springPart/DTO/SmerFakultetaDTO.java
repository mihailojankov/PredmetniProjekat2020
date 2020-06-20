package springPart.DTO;
import java.util.List;

public class SmerFakultetaDTO extends AbstractDTO{
	
	String naziv;
	String opis;
	List<PredmetDTO> predmeti;
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public List<PredmetDTO> getPredmeti() {
		return predmeti;
	}
	public void setPredmeti(List<PredmetDTO> predmeti) {
		this.predmeti = predmeti;
	}
	
	
}
