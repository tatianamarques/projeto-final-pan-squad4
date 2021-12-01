package br.com.squad4.blue_bank.dto;

import br.com.squad4.blue_bank.model.Agencia;
import br.com.squad4.blue_bank.model.EnderecoAgencia;
import br.com.squad4.blue_bank.model.TelefoneAgencia;

public class AgenciaDTO {

    private String numeroAgencia;
    private TelefoneAgenciaDTO telefoneDTO;
    private EnderecoAgenciaDTO enderecoDTO;

    public AgenciaDTO(){}

    public AgenciaDTO(Agencia agencia){
        this.numeroAgencia = agencia.getNumeroAgencia();
        this.enderecoDTO = new EnderecoAgenciaDTO(agencia.getEndereco());
        this.telefoneDTO = new TelefoneAgenciaDTO(agencia.getTelefone());
    }


    public Agencia toModel(){
        EnderecoAgencia endereco = enderecoDTO.toModel();
        TelefoneAgencia telefone = telefoneDTO.toModel();
        Agencia agencia = new Agencia(numeroAgencia, endereco, telefone);

        return agencia;
    }



    public String getNumeroAgencia() {
        return numeroAgencia;
    }

    public void setNumeroAgencia(String numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
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
