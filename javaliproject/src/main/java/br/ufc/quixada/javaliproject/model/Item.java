package br.ufc.quixada.javaliproject.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import br.ufc.quixada.javaliproject.evaluationservice.Associacao;

@Entity(name="item")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idItem;
	@Column
	private String titulo;
	@Column(length=1000)
	private String descricao;
	@Column
	private double pontuacao;
	@OneToMany
	@JoinColumn(name="id_arquivo")
	private List<Arquivo> arquivos;
	
	@Column
	private String casoDeTeste;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "item")
	
	private List<Associacao> associacoes;
	
	@ManyToOne
	@JoinColumn(name = "atividade") 
	private Atividade atividade;
	
	public Item(){
		this.associacoes = new ArrayList<>();
	}
	
	public int getIdItem() {
		return idItem;
	}
	public List<Associacao> getAssociacoes() {
		return associacoes;
	}
	public void setAssociacoes(List<Associacao> associacoes) {
		this.associacoes = associacoes;
	}
	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getPontuacao() {
		return pontuacao;
	}
	public void setPontuacao(double pontuacao) {
		this.pontuacao = pontuacao;
	}
	public String getCasoDeTeste() {
		return casoDeTeste;
	}
	public void setArquivo(String casoDeTeste) {
		this.casoDeTeste = casoDeTeste;
	}
	public Atividade getAtividade() {
		return atividade;
	}
	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}
	

}
