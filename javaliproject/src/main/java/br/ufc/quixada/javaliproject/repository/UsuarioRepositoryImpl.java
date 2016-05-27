package br.ufc.quixada.javaliproject.repository;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import br.ufc.quixada.javaliproject.model.Usuario;



@Named
public class UsuarioRepositoryImpl implements UsuarioRepository {
	
	@PersistenceContext
	protected EntityManager em;
	
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<Usuario> findAll() {
		
		Query query = em.createQuery("from usuario");
		return query.getResultList();
		
	}

	
	@Override
	public Usuario findById(Long id) {
		return em.find(Usuario.class, id);
	}
	
	@Override
	public Usuario findByUsername(String username) {
		Query q = em.createQuery("FROM usuario WHERE username=:username");
		q.setParameter("username", username);
		return (Usuario) q.getSingleResult();
	}
	
	
	@Override
	@Transactional
	public void remover(Usuario usuario) {
		em.remove(em.merge(usuario));
		
	}

}
