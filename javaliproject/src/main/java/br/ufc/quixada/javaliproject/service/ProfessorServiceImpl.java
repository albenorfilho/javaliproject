package br.ufc.quixada.javaliproject.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.ufc.quixada.javaliproject.model.Professor;
import br.ufc.quixada.javaliproject.repository.ProfessorRepository;




@Named
public class ProfessorServiceImpl implements ProfessorService {
	
	@Inject
	private ProfessorRepository professorRepository;

	@Override
	public List<Professor> findAll() {
		return professorRepository.findAll();
	}

	@Override
	public void salvar(Professor professor) {
		professorRepository.salvar(professor);
		
	}

	@Override
	public void remover(Long id) {
		Professor professor = professorRepository.findById(id);
		professorRepository.remover(professor);
	}
	
	@Override
	public Professor getProfessor(String siape){
		return professorRepository.findBySiape(siape);
	}

}
