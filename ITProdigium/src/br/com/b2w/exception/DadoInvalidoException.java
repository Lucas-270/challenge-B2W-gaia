package br.com.b2w.exception;

public class DadoInvalidoException extends Exception{
	
	public DadoInvalidoException() {
		super("Dado inv�lido");
	}
	
	public DadoInvalidoException(String msg) {
		super(msg);
	}
}
