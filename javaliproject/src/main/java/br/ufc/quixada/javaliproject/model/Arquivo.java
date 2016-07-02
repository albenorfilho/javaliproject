package br.ufc.quixada.javaliproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="arquivo")
public class Arquivo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_arquivo")
	private int idArquivo;
	private String nome;
	private String path;
	@ManyToOne
	Aluno aluno;
	@ManyToOne
	@JoinColumn(name="id_item")
	Item item;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	
	
}
