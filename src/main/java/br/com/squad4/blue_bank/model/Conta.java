package br.com.squad4.blue_bank.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


import br.com.squad4.blue_bank.enums.TipoConta;


@Entity
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @ManyToOne
    private Agencia agencia;


    @ManyToOne
    private Cliente cliente;


    @Column(nullable = false, unique = true)
    private String numero;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoConta tipoConta;

    @Column(nullable = false)
    private BigDecimal saldo;

    @Column
    private BigDecimal saldoEspecial;

    @Column(nullable = false)
    private boolean estaBloqueada;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private LocalDate dataAbertura;
    
    @OneToMany(mappedBy = "origem")
    private List<Transferencia> origem;
    
    @OneToMany(mappedBy = "destino")
    private List<Transferencia> destino;

    @OneToMany
//    @JoinTable(name = "conta_transacao", joinColumns = @JoinColumn(name = "conta_id", referencedColumnName = "id"),
//            inverseJoinColumns=@JoinColumn(name="transacao_id", referencedColumnName = "id"))
    private List<Transacao> transacoes = new ArrayList<>();
    


    @Deprecated
    public Conta(){}

    public Conta(Agencia agencia,Cliente cliente, String numero, TipoConta tipoConta, BigDecimal saldo, BigDecimal saldoEspecial, boolean estaBloqueada, String senha, LocalDate dataAbertura) {
        this.agencia=agencia;
        this.cliente =cliente;
        this.numero = numero;
        this.tipoConta = tipoConta;
        this.saldo = saldo;
        this.saldoEspecial = saldoEspecial;
        this.estaBloqueada = estaBloqueada;
        this.senha = senha;
        this.dataAbertura = dataAbertura;
    }




    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getNumero() {
        return numero;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public BigDecimal getSaldo() {
        return saldo.add(this.saldoEspecial);
    }

    public BigDecimal getSaldoEspecial() {
        return saldoEspecial;
    }

    public boolean isEstaBloqueada() {
        return estaBloqueada;
    }

    public String getSenha() {
        return senha;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }


    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

    public void setEstaBloqueada(boolean estaBloqueada) {
        this.estaBloqueada = estaBloqueada;
    }

    public Boolean receberDinheiro(BigDecimal quantia) {
    	try {
    		this.saldo=saldo.add(quantia);
    		return true;
    	}catch( Exception e){
    		e.printStackTrace();
    		return false;
    	}
    }
    
    public Boolean cederDinheiro(BigDecimal quantia) {
    	try {
    		this.saldo = saldo.subtract(quantia);
    		return true;
    	}catch( Exception e){
    		e.printStackTrace();
    		return false;
    	}
    	
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}
    
    
}
