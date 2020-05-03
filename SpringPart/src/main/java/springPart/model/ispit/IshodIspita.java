package springPart.model.ispit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import springPart.model.Predmet;
import springPart.model.korisnik.Student;

@Entity
public class IshodIspita {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public IshodIspita(Long id, float prviKolokvijumBodovi, float drugiKolokvijumBodovi, float zavrsniIspitBodovi,
			boolean polozen, Student student, Predmet predmet) {
		super();
		this.id = id;
		this.prviKolokvijumBodovi = prviKolokvijumBodovi;
		this.drugiKolokvijumBodovi = drugiKolokvijumBodovi;
		this.zavrsniIspitBodovi = zavrsniIspitBodovi;
		this.polozen = polozen;
		this.student = student;
		this.predmet = predmet;
	}

	public IshodIspita() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
