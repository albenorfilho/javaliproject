package br.ufc.quixada.javaliproject.model;

import java.io.Serializable;

public class Aluno_AtividadeID implements Serializable{
	private int aluno_id;
	private int atividade_id;
	
	
	public int getAluno_id() {
		return aluno_id;
	}
	public void setAluno_id(int aluno_id) {
		this.aluno_id = aluno_id;
	}
	public int getAtividade_id() {
		return atividade_id;
	}
	public void setAtividade_id(int atividade_id) {
		this.atividade_id = atividade_id;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
}
