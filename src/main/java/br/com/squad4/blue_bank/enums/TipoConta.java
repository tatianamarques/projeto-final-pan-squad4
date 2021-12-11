package br.com.squad4.blue_bank.enums;

public enum TipoConta {
    CORRENTE(1,"Conta Corrente", 0.001, "001"),
    POUPANCA(2,"Conta Poupança", 0.02, "005"),
    SALARIO(3,"Conta Salário", 0.00, "010");


    private int id;
    private String descricao;
    private Double rendimento;
    private String codigoOperacao;

    private TipoConta(int id, String descricao, Double rendimento, String codigoOperacao) {
        this.id = id;
        this.descricao = descricao;
        this.rendimento = rendimento;
        this.codigoOperacao = codigoOperacao;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getRendimento() {
        return rendimento;
    }

    public String getCodigoOperacao() {
        return codigoOperacao;
    }
}
