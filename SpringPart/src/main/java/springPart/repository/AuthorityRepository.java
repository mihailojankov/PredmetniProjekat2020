package springPart.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import springPart.model.security.Authority;

@Repository
public interface AuthorityRepository extends InheritInterface<Authority>{
	@Query
	("SELECT a FROM Authority a WHERE a.authority = :naziv")
	public Authority nadjiPoNazivu(@PathVariable("naziv")String naziv);
}
