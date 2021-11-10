package br.com.squad4.blue_bank.model;

import javax.persistence.*;

@Entity
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String ddd;

    @Column
    private String numero;

    @Column
    @Enumerated(EnumType.STRING)
    private TipoTelefone tipoTelefone;

    @ManyToOne
    private Cliente cliente;

    public Telefone(String ddd, String numero, TipoTelefone tipoTelefone) {
        this.ddd = ddd;
        this.numero = numero;
        this.tipoTelefone = tipoTelefone;
    }

    public Long getId() {
        return id;
    }


    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public TipoTelefone getTipoTelefone() {
        return tipoTelefone;
    }

    public void setTipoTelefone(TipoTelefone tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
