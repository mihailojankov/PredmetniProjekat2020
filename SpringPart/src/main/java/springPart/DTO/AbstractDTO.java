package springPart.DTO;

import lombok.Getter;
import lombok.Setter;


public abstract class AbstractDTO {
	Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
