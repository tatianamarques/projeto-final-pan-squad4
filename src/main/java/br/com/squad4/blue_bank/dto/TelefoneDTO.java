package br.com.squad4.blue_bank.dto;

import java.util.Optional;

import br.com.squad4.blue_bank.enums.TipoTelefone;
import br.com.squad4.blue_bank.model.Cliente;
import br.com.squad4.blue_bank.model.Telefone;
import br.com.squad4.blue_bank.repository.ClienteRepository;

public class TelefoneDTO {


    private String ddd;

    private  String numero;

    private TipoTelefone tipoTelefone;

    private Long idCliente;

    public TelefoneDTO(String ddd, String numero, TipoTelefone tipoTelefone , Long idCliente) {
        this.ddd = ddd;
        this.numero = numero;
        this.tipoTelefone = tipoTelefone;
        this.idCliente = idCliente;
    }


    public Telefone toModel(ClienteRepository clienteRepository) {


    Optional<Cliente> cliente = clienteRepository.findById(idCliente);

     if(cliente.isPresent()){
         return new Telefone(this.ddd, this.numero, this.tipoTelefone, cliente.get());

     }

      return null;


    }
    
    public Telefone toModel() {
    	return new Telefone(this.ddd,this.numero,this.tipoTelefone);
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

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }
}
