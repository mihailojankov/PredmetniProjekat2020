package springPart.DTO;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import springPart.model.Student;

@Getter
@Setter
public class PrijavaIspitaDTO extends AbstractDTO{
	
	LocalDateTime datumPrijave;
	Student student;
	RokDTO rok;
	IspitDTO ispit;
}