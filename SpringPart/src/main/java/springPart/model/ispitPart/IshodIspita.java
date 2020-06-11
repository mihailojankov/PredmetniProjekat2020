package springPart.model.ispitPart;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import springPart.model.AbstractModel;
import springPart.model.korisnikPart.Student;
import springPart.model.predmetPart.Predmet;

@Getter
@Setter
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
	
	
	
	
}
