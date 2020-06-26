package springPart.model.ispitPart;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import springPart.model.AbstractModel;
import springPart.model.korisnikPart.Student;
import springPart.model.predmetPart.Predmet;

@Entity
public class IshodIspita extends AbstractModel{
	
	@Column(nullable = true)
	float prviKolokvijumBodovi;
	@Column(nullable = true)
	float drugiKolokvijumBodovi;
	@Column(nullable = true)
	float zavrsniIspitBodovi;
	boolean polozen;
	
	@ManyToOne
	Student student;
	
	@ManyToOne
	Predmet predmet;

	public IshodIspita() {
		
	}

	public IshodIspita(float prviKolokvijumBodovi, float drugiKolokvijumBodovi, float zavrsniIspitBodovi,
			boolean polozen, Student student, Predmet predmet) {
		super();
		this.prviKolokvijumBodovi = prviKolokvijumBodovi;
		this.drugiKolokvijumBodovi = drugiKolokvijumBodovi;
		this.zavrsniIspitBodovi = zavrsniIspitBodovi;
		this.polozen = polozen;
		this.student = student;
		this.predmet = predmet;
	}

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

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}
	
	
	
	
}
