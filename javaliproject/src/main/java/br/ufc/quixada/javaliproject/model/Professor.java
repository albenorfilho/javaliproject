package br.ufc.quixada.javaliproject.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="professor")
public class Professor extends Usuario{
	
	
	@Column
	private String siape;
	@OneToMany(mappedBy="professor", cascade=CascadeType.ALL)
	private List<Disciplina> disciplinas;
	
	
	
	
	
	public String getSiape() {
		return siape;
	}
	public void setSiape(String siape) {
		this.siape = siape;
	}
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}
	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	
	
	
}
