package br.com.squad4.blue_bank.model.security;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Perfil {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, length = 30)
	private String nomeRole;
	@ManyToMany		   
	private List<Usuario> usuarios;
	
	public Perfil() {
	}
	
	public Perfil(String nomeRole) {
		this.nomeRole = nomeRole;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getNomeRole() {
		return nomeRole;
	}
	
	
}
