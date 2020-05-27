package springPart.DTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClanAdministrativnogOsobljaDTO extends AbstractDTO{
	String jmbg;
	String uloga;
	RegistrovanKorisnikDTO korisnik;
}
