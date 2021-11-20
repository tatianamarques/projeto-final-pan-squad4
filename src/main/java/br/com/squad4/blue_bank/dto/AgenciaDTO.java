package br.com.squad4.blue_bank.dto;

import br.com.squad4.blue_bank.model.Agencia;
import br.com.squad4.blue_bank.model.EnderecoAgencia;
import br.com.squad4.blue_bank.model.TelefoneAgencia;

public class AgenciaDTO {

    private String numeroAgencia;
    private TelefoneAgencia telefoneDTO;
    private EnderecoAgencia enderecoDTO;

    public AgenciaDTO(Agencia agencia){
        this.numeroAgencia = numeroAgencia;
    }
    public AgenciaDTO(){}

    public AgenciaDTO(String numeroAgencia, TelefoneAgencia telefone, EnderecoAgencia enderecoID){
        this.numeroAgencia = numeroAgencia;
        this.telefoneDTO = telefone;
        this.enderecoDTO = enderecoID;
    }


    public Agencia toModel(){
        EnderecoAgencia endereco = new EnderecoAgencia();
        TelefoneAgencia telefone = new TelefoneAgencia();
        Agencia agencia = new Agencia(numeroAgencia, telefone, endereco);

        return agencia;
    }

    @Override
    public String toString() {
        return "AgenciaDTO{" +
                "numero='" + numeroAgencia + '\'' +
                ", telefoneDTO=" + telefoneDTO +
                ", enderecoDTO=" + enderecoDTO +
                '}';
    }

    public String getNumeroAgencia() {
        return numeroAgencia;
    }

    public void setNumeroAgencia(String numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
    }

    public TelefoneAgencia getTelefoneDTO() {
        return telefoneDTO;
    }

    public void setTelefoneDTO(TelefoneAgencia telefoneDTO) {
        this.telefoneDTO = telefoneDTO;
    }

    public EnderecoAgencia getEnderecoDTO() {
        return enderecoDTO;
    }

    public void setEnderecoDTO(EnderecoAgencia enderecoDTO) {
        this.enderecoDTO = enderecoDTO;
    }
}
