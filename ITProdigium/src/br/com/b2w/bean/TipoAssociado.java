package br.com.b2w.bean;

public class TipoAssociado {

	private int id;
	
	private int nivelAcesso;
	
	private String nome;

	public TipoAssociado() {}
	
	public TipoAssociado(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	public TipoAssociado(int id, int nivelAcesso, String nome) {
		super();
		this.id = id;
		this.nivelAcesso = nivelAcesso;
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNivelAcesso() {
		return nivelAcesso;
	}

	public void setNivelAcesso(int nivelAcesso) {
		this.nivelAcesso = nivelAcesso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "\n" + id + ", " + nome + ", " + nivelAcesso + "\n";
	}
	
	
}
