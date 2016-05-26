package br.ufc.quixada.javaliproject.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity(name="aluno")
@DiscriminatorValue(value = "A")
public class Aluno extends Usuario{
	
	
	@Column
	private String matricula;
	 @ManyToMany
     @JoinTable(name="aluno_tem_disciplinas", joinColumns={@JoinColumn(name="aluno_id")}, inverseJoinColumns={@JoinColumn(name="disciplina_id")})
	 private List<Disciplina> disciplinas;
	
	
	
	
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}
	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	
	
	
}
