package springPart.service;

import springPart.model.AbstractModel;

public interface CommonService <E extends AbstractModel>{
	
	Iterable<E> findAll();
	
	public E findById(Long id);
	
	public void save(E obj);
	
	public void deleteById(Long id);
}
