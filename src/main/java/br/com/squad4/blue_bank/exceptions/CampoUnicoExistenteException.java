package br.com.squad4.blue_bank.exceptions;

public class CampoUnicoExistenteException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public CampoUnicoExistenteException(String campo) {
		super("O campo "+ campo+" informado já está cadastrado!");
	}


}
