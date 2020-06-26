package springPart.DTO;

public class IshodIspitaDTO extends AbstractDTO{
	
	float prviKolokvijumBodovi;
	float drugiKolokvijumBodovi;
	float zavrsniIspitBodovi;
	boolean polozen;
	StudentDTO student;
	PredmetDTO predmet;
	public float getPrviKolokvijumBodovi() {
		return prviKolokvijumBodovi;
	}
	public void setPrviKolokvijumBodovi(float prviKolokvijumBodovi) {
		this.prviKolokvijumBodovi = prviKolokvijumBodovi;
	}
	public float getDrugiKolokvijumBodovi() {
		return drugiKolokvijumBodovi;
	}
	public void setDrugiKolokvijumBodovi(float drugiKolokvijumBodovi) {
		this.drugiKolokvijumBodovi = drugiKolokvijumBodovi;
	}
	public float getZavrsniIspitBodovi() {
		return zavrsniIspitBodovi;
	}
	public void setZavrsniIspitBodovi(float zavrsniIspitBodovi) {
		this.zavrsniIspitBodovi = zavrsniIspitBodovi;
	}
	public boolean isPolozen() {
		return polozen;
	}
	public void setPolozen(boolean polozen) {
		this.polozen = polozen;
	}
	public StudentDTO getStudent() {
		return student;
	}
	public void setStudent(StudentDTO student) {
		this.student = student;
	}
	public PredmetDTO getPredmet() {
		return predmet;
	}
	public void setPredmet(PredmetDTO predmet) {
		this.predmet = predmet;
	}
	
	
}
