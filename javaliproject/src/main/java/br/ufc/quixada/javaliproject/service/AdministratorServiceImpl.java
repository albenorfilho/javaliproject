package br.ufc.quixada.javaliproject.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.ufc.quixada.javaliproject.model.Administrator;
import br.ufc.quixada.javaliproject.model.Aluno;
import br.ufc.quixada.javaliproject.repository.AdministratorRepository;
import br.ufc.quixada.javaliproject.repository.AlunoRepository;





@Named
public class AdministratorServiceImpl implements AdministratorService {
	
	@Inject
	private AdministratorRepository administratorRepository;

	@Override
	public List<Administrator> findAll() {
		return administratorRepository.findAll();
	}

	@Override
	public void salvar(Administrator administrator) {
		administratorRepository.salvar(administrator);
		
	}

	@Override
	public void remover(int id) {
		Administrator administrator = administratorRepository.findById(id);
		administratorRepository.remover(administrator);
	}

	@Override
	public Administrator getAdministrator(int id) {
		return administratorRepository.findById(id);
		
	}
	

}
