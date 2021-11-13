package br.com.squad4.blue_bank.model;

public enum TipoTransacao {
    DEB(1, "Débito", 0.01),
    DEP(2, "Depósito", 0.025),
    PIX(3, "Pix", 0.00),
    TRANSF(4, "Transferência", 0.015),
    SAQUE(5, "Saque", 0.001);

    private int codigo;
    private String descricao;
    private Double taxa;

    private TipoTransacao(int codigo, String descricao, Double taxa) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.taxa = taxa;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getTaxa() {
        return taxa;
    }
}
