package br.ufc.quixada.javaliproject.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name="administrator")
@DiscriminatorValue(value = "D")
public class Administrator extends Usuario{
	@Column
	private String admin;

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}
	
	
	
	
}
