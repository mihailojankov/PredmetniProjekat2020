package springPart.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Student extends AbstractModel{
	
	@Column(unique = true)
	String jmbg;
	Date datumRodjenja;
	String brojIndeksa;
	String mestoRodjenja;
	String drzavaRodjenja;
	boolean vanredni;
	Date godinaUpisa;
	
	@OneToOne
	@JoinColumn(name = "korisnik_id")
	RegistrovanKorisnik korisnik;
	
	@ManyToMany
	@JoinTable(name = "studentiNaPredmetu", joinColumns = @JoinColumn(name="student_id"), inverseJoinColumns = @JoinColumn(name="predmet_id"))
	List<Predmet> listaPredmeta;
	
	@OneToMany(mappedBy = "student")
	List<PrijavaIspita> prijaveIspita;
	
	@OneToMany(mappedBy = "student")
	List<IshodIspita> istorijaIspita;
	
	
	
	public Student() {
		
	}

	public Student(String jmbg, Date datumRodjenja, String brojIndeksa, String mestoRodjenja, String drzavaRodjenja,
			boolean vanredni, Date godinaUpisa, RegistrovanKorisnik korisnik, List<Predmet> listaPredmeta,
			List<PrijavaIspita> prijaveIspita, List<IshodIspita> istorijaIspita) {
		super();
		this.jmbg = jmbg;
		this.datumRodjenja = datumRodjenja;
		this.brojIndeksa = brojIndeksa;
		this.mestoRodjenja = mestoRodjenja;
		this.drzavaRodjenja = drzavaRodjenja;
		this.vanredni = vanredni;
		this.godinaUpisa = godinaUpisa;
		this.korisnik = korisnik;
		this.listaPredmeta = listaPredmeta;
		this.prijaveIspita = prijaveIspita;
		this.istorijaIspita = istorijaIspita;
	}
	
}