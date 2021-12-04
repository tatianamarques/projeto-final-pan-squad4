package br.com.squad4.blue_bank.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Agencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_agencia", nullable = false, unique = true)
    private String numeroAgencia;

    @Embedded
    private TelefoneAgencia telefone;
    
    @Embedded
    private EnderecoAgencia endereco;

	@OneToMany(mappedBy = "agencia")
	private List<Conta> contas = new ArrayList<>();

	public Agencia(String numeroAgencia, EnderecoAgencia endereco, TelefoneAgencia telefone) {
		this.numeroAgencia = numeroAgencia;
		this.endereco = endereco;
		this.telefone = telefone;
	}


	public Agencia(){}

	public Long getId() {
		return id;
	}

	public String getNumeroAgencia() {
		return numeroAgencia;
	}

	public TelefoneAgencia getTelefone() {
		return telefone;
	}
	
	public EnderecoAgencia getEndereco() {
		return endereco;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNumeroAgencia(String numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}

	public void setTelefone(TelefoneAgencia telefone) {
		this.telefone = telefone;
	}

	public void setEndereco(EnderecoAgencia endereco) {
		this.endereco = endereco;
	}

	public void setContas(List<Conta> contas) {this.contas = contas;}

}
