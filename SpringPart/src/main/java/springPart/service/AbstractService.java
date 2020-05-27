package springPart.service;

import org.springframework.beans.factory.annotation.Autowired;

import springPart.model.AbstractModel;
import springPart.repository.InheritInterface;

public abstract class AbstractService <E extends AbstractModel, R extends InheritInterface<E>> implements CommonService<E>{
	
	@Autowired
	protected final R repository;
	
	
	public AbstractService(R repository) {
		this.repository = repository;
	}
	
	@Override
	public Iterable<E> findAll(){
		return repository.findAll();
	}
	@Override
	public E findById(Long id) {
		return repository.findById(id).orElse(null);
	}
	@Override
	public void save(E obj) {
		repository.save(obj);
	}
	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}
