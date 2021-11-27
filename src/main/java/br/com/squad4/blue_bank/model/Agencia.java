package br.com.squad4.blue_bank.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Agencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String numero;

    @Embedded
    private TelefoneAgencia telefone;
    
    @Embedded
    private EnderecoAgencia endereco;

	@OneToMany(mappedBy = "agencia")
	private List<Conta> contas;

	public Agencia(String numero, TelefoneAgencia telefone, EnderecoAgencia endereco) {
		this.numero = numero;
		this.telefone = telefone;
		this.endereco = endereco;
	}

	public Agencia(){}


	public Long getId() {
		return id;
	}

	public String getNumero() {
		return numero;
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

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void setTelefone(TelefoneAgencia telefone) {
		this.telefone = telefone;
	}

	public void setEndereco(EnderecoAgencia endereco) {
		this.endereco = endereco;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}

}
