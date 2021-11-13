package br.com.squad4.blue_bank.model;

import javax.persistence.*;

@Entity
public class Agencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String numero;

    @Embedded
    private TelefoneAgencia telefone;
    
    @Embedded
    private EnderecoAgencia endereco;

	public Agencia(String numero, TelefoneAgencia telefone, EnderecoAgencia endereco) {
		this.numero = numero;
		this.telefone = telefone;
		this.endereco = endereco;
	}

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

}
