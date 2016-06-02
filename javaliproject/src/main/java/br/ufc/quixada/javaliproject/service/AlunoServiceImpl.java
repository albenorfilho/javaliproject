package br.ufc.quixada.javaliproject.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.ufc.quixada.javaliproject.model.Aluno;
import br.ufc.quixada.javaliproject.repository.AlunoRepository;





@Named
public class AlunoServiceImpl implements AlunoService {
	
	@Inject
	private AlunoRepository alunoRepository;

	@Override
	public List<Aluno> findAll() {
		return alunoRepository.findAll();
	}

	@Override
	public void salvar(Aluno aluno) {
		alunoRepository.salvar(aluno);
		
	}

	@Override
	public void remover(int id) {
		Aluno aluno = alunoRepository.findById(id);
		alunoRepository.remover(aluno);
	}
	
	@Override
	public Aluno getAluno(String matricula){
		return alunoRepository.findByMatricula(matricula);
	}

}
