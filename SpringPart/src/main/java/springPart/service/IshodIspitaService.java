package springPart.service;

import org.springframework.stereotype.Service;

import springPart.model.ispitPart.IshodIspita;
import springPart.repository.IshodIspitaRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class IshodIspitaService extends AbstractService<IshodIspita, IshodIspitaRepository>{

	public IshodIspitaService(IshodIspitaRepository repository) {
		super(repository);
	}

	public IshodIspita pronadjiIshod(Long studentId, Long predmetId){
		return repository.pronadjiIshod(studentId, predmetId);
	}

	public List<IshodIspita> pronadjiIshodePoPredmetu(Long predmetId){
		return  repository.pronadjiIshodePoPredmetu(predmetId);
	}
}
