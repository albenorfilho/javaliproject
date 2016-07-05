package br.ufc.quixada.javaliproject.evaluationservice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.ufc.quixada.javaliproject.model.Item;

@Entity
@Table(name="associacao")
public class Associacao {
 
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private int id;
 @Column(name="testenome")
 private String testeNome;
 @Column(name="classenome")
 private String classeNome;
 	
 @ManyToOne
	@JoinColumn(name = "item")
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
