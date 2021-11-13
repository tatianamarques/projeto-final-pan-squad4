package br.com.squad4.blue_bank.model.security;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String login;
	private String senha;
	private Boolean ativo;
	@ManyToMany
	@JoinTable(name = "perfis_usuarios", 
	           joinColumns = @JoinColumn(name = "perfil_id", referencedColumnName = "id"), 
	           inverseJoinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id")
	           )
	private List<Perfil> perfis;
	
	public Usuario() {
	}

	public Usuario(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}

	public Long getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public List<Perfil> getPerfis() {
		return perfis;
	}
	
}
