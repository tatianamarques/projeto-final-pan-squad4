package br.com.squad4.blue_bank.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Gerente {

    private int id;
    private String nome;
    private String numeroAgencia;
    private String cidadeAgencia;

}