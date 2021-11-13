package br.com.squad4.blue_bank.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Transferencia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDate data;	
	private LocalTime hora;
	@ManyToOne
	private Conta origem;
	@ManyToOne
	private Conta destino;
	
	private BigDecimal valor;
	
	public Transferencia(Conta origem, Conta destino,BigDecimal valor) {
		this.data = LocalDate.now();
		this.hora = LocalTime.now();
		this.origem = origem;
		this.destino = destino;
		this.valor = valor;
	}

	public Long getId() {
		return id;
	}

	public LocalDate getData() {
		return data;
	}

	public LocalTime getHora() {
		return hora;
	}

	public Conta getOrigem() {
		return origem;
	}

	public Conta getDestino() {
		return destino;
	}
	
	public BigDecimal getValor() {
		return valor;
	}
	
}
