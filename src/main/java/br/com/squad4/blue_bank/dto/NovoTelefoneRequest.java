package br.com.squad4.blue_bank.dto;

import br.com.squad4.blue_bank.enums.TipoTelefone;
import br.com.squad4.blue_bank.model.Cliente;
import br.com.squad4.blue_bank.model.Telefone;
import br.com.squad4.blue_bank.repository.ClienteRepository;

import javax.persistence.Column;
import java.util.Optional;

public class NovoTelefoneRequest {


    private String ddd;

    private  String numero;

    private TipoTelefone tipoTelefone;

    private Long idCliente;

    public NovoTelefoneRequest(String ddd, String numero, TipoTelefone tipoTelefone , Long idCliente) {
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


}
