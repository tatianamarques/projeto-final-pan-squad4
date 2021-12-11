package br.com.squad4.blue_bank.enums;

public enum TipoTransacao {
    DEB(1, "Débito"),
    DEP(2, "Depósito"),    
    TRANSF(3, "Transferência"),
    SAQUE(4, "Saque");

    private int codigo;
    private String descricao;
   

    private TipoTransacao(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;        
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }
    
}
