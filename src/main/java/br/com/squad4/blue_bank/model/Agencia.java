package br.com.squad4.blue_bank.model;

import javax.persistence.*;
import java.util.List;

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

	@OneToMany(mappedBy = "agencia")
	private List<Conta> contas;

	public Agencia(String numero, TelefoneAgencia telefone, EnderecoAgencia endereco) {
		this.numero = numero;
		this.telefone = telefone;
		this.endereco = endereco;
	}
   @Deprecated
	public Agencia() {
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
