package br.com.b2w.exception;

public class EntidadeNaoEncontradaException extends Exception{

	public EntidadeNaoEncontradaException() {
		super("Entidade não encontrada");
	}
	
	public EntidadeNaoEncontradaException(String msg) {
		super(msg);
	}
}
