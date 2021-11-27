package br.com.squad4.blue_bank.dto;

import br.com.squad4.blue_bank.enums.TipoTelefone;
import br.com.squad4.blue_bank.model.TelefoneAgencia;

public class TelefoneAgenciaDTO {

    private String ddd;
    private String numeroTelefone;
    private TipoTelefone tipoTelefone;

    public TelefoneAgenciaDTO(){}

    public TelefoneAgenciaDTO(TelefoneAgencia telefoneAgencia){
        this.ddd = telefoneAgencia.getDdd();
        this.numeroTelefone = telefoneAgencia.getNumero();
        this.tipoTelefone = telefoneAgencia.getTipoTelefone();
    }

    public TelefoneAgencia toModel(){
        return new TelefoneAgencia(this.ddd, this.numeroTelefone, this.tipoTelefone);
    }


    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public TipoTelefone getTipoTelefone() {
        return tipoTelefone;
    }

    public void setTipoTelefone(TipoTelefone tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }
}
