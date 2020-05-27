package springPart.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import springPart.model.AbstractModel;

@Repository
public interface InheritInterface <E extends AbstractModel> extends CrudRepository<E, Long>{

}
