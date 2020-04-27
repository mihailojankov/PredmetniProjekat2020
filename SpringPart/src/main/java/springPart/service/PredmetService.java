package springPart.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springPart.model.Predmet;
import springPart.model.SmerFakulteta;
import springPart.repository.PredmetRepository;

@Service
public class PredmetService {
	
	@Autowired
	PredmetRepository repo;
	
	
	public Iterable<Predmet> dobaviSve(){
		return repo.findAll();
	}
	
	public Predmet dobaviPoId(Long id) {
		return repo.findById(id).orElse(null);
	}
	
	public void save(Predmet obj) {
		repo.save(obj);
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	public ArrayList<Predmet> dobaviPoIdSmera(Long id){
		ArrayList<Predmet> lista = new ArrayList<>();
		
		for(Predmet x:repo.findAll()) {
			for(SmerFakulteta x2:x.getListaSmerovaFakulteta()) {
				if(x2.getId() == id) {
					lista.add(x);
				}
			}
		}
		return lista;
	}
}
