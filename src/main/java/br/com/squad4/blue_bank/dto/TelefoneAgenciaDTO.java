package br.com.squad4.blue_bank.dto;

import br.com.squad4.blue_bank.enums.TipoTelefone;
import br.com.squad4.blue_bank.model.Agencia;
import br.com.squad4.blue_bank.model.TelefoneAgencia;
import br.com.squad4.blue_bank.repository.AgenciaRepository;

public class TelefoneAgenciaDTO {

    private String ddd;
    private String numeroTelefone;
    private TipoTelefone tipoTelefone;

    public TelefoneAgenciaDTO(){}

    public TelefoneAgenciaDTO(String ddd, String numeroTelefone, TipoTelefone tipoTelefone){
        this.ddd = ddd;
        this.numeroTelefone = numeroTelefone;
        this.tipoTelefone = tipoTelefone;
    }

    public TelefoneAgencia toModel(){
        return new TelefoneAgencia(this.ddd, this.numeroTelefone, this.tipoTelefone);
    }


    @Override
    public String toString() {
        return "TelefoneAgenciaDTO{" +
                "ddd='" + ddd + '\'' +
                ", numeroTelefone='" + numeroTelefone + '\'' +
                ", tipoTelefone=" + tipoTelefone +
                '}';
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
