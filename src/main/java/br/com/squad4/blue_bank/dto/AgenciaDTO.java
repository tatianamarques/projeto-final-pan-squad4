package br.com.squad4.blue_bank.dto;

import br.com.squad4.blue_bank.model.Agencia;
import br.com.squad4.blue_bank.model.EnderecoAgencia;
import br.com.squad4.blue_bank.model.TelefoneAgencia;

public class AgenciaDTO {

    private String numero;
    private TelefoneAgenciaDTO telefoneDTO;
    private EnderecoAgenciaDTO enderecoDTO;

    public AgenciaDTO(){}

    public AgenciaDTO(Agencia agencia){
        this.numero = agencia.getNumero();
        this.telefoneDTO = new TelefoneAgenciaDTO(agencia.getTelefone());
        this.enderecoDTO = new EnderecoAgenciaDTO(agencia.getEndereco());
    }


    public Agencia toModel(){
        EnderecoAgencia endereco = enderecoDTO.toModel();
        TelefoneAgencia telefone = telefoneDTO.toModel();
        Agencia agencia = new Agencia(numero, telefone, endereco);

        return agencia;
    }



    public String getNumero() {
        return numero;
    }

    public void setNumero(String numeroAgencia) {
        this.numero = numeroAgencia;
    }

    public TelefoneAgenciaDTO getTelefoneDTO() {
        return telefoneDTO;
    }

    public void setTelefoneDTO(TelefoneAgenciaDTO telefoneDTO) {
        this.telefoneDTO = telefoneDTO;
    }

    public EnderecoAgenciaDTO getEnderecoDTO() {
        return enderecoDTO;
    }

    public void setEnderecoDTO(EnderecoAgenciaDTO enderecoDTO) {
        this.enderecoDTO = enderecoDTO;
    }
}
