package br.ufc.quixada.javaliproject.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Table(name="aluno_atividade")
@IdClass(Aluno_AtividadeID.class)
public class Nota {
	@Id
	private int aluno_id;
	@Id
	private int atividade_id;
	@ManyToOne
	@PrimaryKeyJoinColumn(name="atividade_ID", referencedColumnName="ID")
	private Atividade atividade;
	
	@OneToOne
	@PrimaryKeyJoinColumn(name="aluno_ID", referencedColumnName="ID")	
	private Aluno aluno;
	private double nota;
	
	
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
	
	

}
