package br.ufc.quixada.javaliproject.repository;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import br.ufc.quixada.javaliproject.model.Aluno;
import br.ufc.quixada.javaliproject.model.Disciplina;
import br.ufc.quixada.javaliproject.model.Professor;


@Named
public class DisciplinaRepositoryImpl implements DisciplinaRepository {
	
	@PersistenceContext
	protected EntityManager em;
	
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<Disciplina> findAll() {
		Query query = em.createQuery("from disciplina");
		return query.getResultList();
	}
	
	@Override
	public List<Disciplina> findByIdProfessor(Professor professor) {
		Query query = em.createQuery("from disciplina where professor=:professor ");
		query.setParameter("professor", professor);
		return query.getResultList();
	}
	
	
	public List<Disciplina> findByAluno(Aluno aluno) {
		//ESSE METODO TÁ BUGADO
		String consulta = "Select disciplina d from Disciplina d join d.alunos t join t.district t where t.name = :name";
        Query query = em.createQuery(consulta);
        query.setParameter("id", aluno.getId());
       
		return query.getResultList();
	}
	

	@Override
	@Transactional
	public void salvar(Disciplina disciplina) {
		em.persist(disciplina);
	}

	@Override
	public Disciplina findById(int id) {
		return em.find(Disciplina.class, id);
	}

	@Override
	@Transactional
	public void remover(Disciplina disciplina) {
		String consulta = "delete from disciplina where id = :id";
        Query query = em.createQuery(consulta);
        query.setParameter("id", disciplina.getId());
        query.executeUpdate();
		
		
		
	}

}
