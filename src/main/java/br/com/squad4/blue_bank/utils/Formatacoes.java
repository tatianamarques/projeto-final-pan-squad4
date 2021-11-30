package br.com.squad4.blue_bank.utils;

import java.text.ParseException;

import javax.swing.text.MaskFormatter;

public class Formatacoes {
	
	public static String retirarPontosHifen(String string) {
		String retorno = string.replaceAll("\\p{Punct}","");
		return retorno;
	}
	
	public static String mascaraCpf(String cpf) {
		MaskFormatter mf;
        try {
            mf = new MaskFormatter("###.###.###-##");
            mf.setValueContainsLiteralCharacters(false);
            return mf.valueToString(cpf);
        } catch (ParseException ex) {
            return cpf;
        }	
		
	}
	
	public static String mascaraTelefone(String telefone) {
		MaskFormatter mf;
        try {
            mf = new MaskFormatter("####-####");
            mf.setValueContainsLiteralCharacters(false);
            return mf.valueToString(telefone);
        } catch (ParseException ex) {
            return telefone;
        }		
	}
	
	public static String mascaraCelular(String telefone) {
		MaskFormatter mf;
        try {
            mf = new MaskFormatter("#####-####");
            mf.setValueContainsLiteralCharacters(false);
            return mf.valueToString(telefone);
        } catch (ParseException ex) {
            return telefone;
        }	
		
	}
	
	public static String mascaraCep(String cep) {
		MaskFormatter mf;
        try {
            mf = new MaskFormatter("##.###-####");
            mf.setValueContainsLiteralCharacters(false);
            return mf.valueToString(cep);
        } catch (ParseException ex) {
            return cep;
        }	
		
	}
	
	
	
}
