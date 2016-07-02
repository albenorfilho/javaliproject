package br.ufc.quixada.javaliproject.evaluationservice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.ufc.quixada.javaliproject.model.Item;

@Entity
public class Associacao {
 
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private int id;
 private String testeNome;
 private String classeNome;
 	@ManyToOne
	@JoinColumn(name="item")
	Item item;
 
 public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

public Associacao(){
 }
 
public String getTesteNome() {
	return testeNome;
}
public void setTesteNome(String testeNome) {
	this.testeNome = testeNome;
}
public String getClasseNome() {
	return classeNome;
}
public void setClasseNome(String classeNome) {
	this.classeNome = classeNome;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}


 
 
}
