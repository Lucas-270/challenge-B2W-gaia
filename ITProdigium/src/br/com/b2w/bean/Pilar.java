package br.com.b2w.bean;

public class Pilar {

	private int id;
	
	private String nome;
	
	private int statusAtivacao;
	
	private String dataCriacao;
	
	private String dataDesativacao;

	public Pilar() {}
	
	public Pilar(int id, String nome, int statusAtivacao, String dataDesativacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.statusAtivacao = statusAtivacao;
		this.dataDesativacao = dataDesativacao;
	}

	public Pilar(int id, String nome, int statusAtivacao, String dataCriacao, String dataDesativacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.statusAtivacao = statusAtivacao;
		this.dataCriacao = dataCriacao;
		this.dataDesativacao = dataDesativacao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getStatusAtivacao() {
		return statusAtivacao;
	}

	public void setStatusAtivacao(int statusAtivacao) {
		this.statusAtivacao = statusAtivacao;
	}

	public String getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(String dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getDataDesativacao() {
		return dataDesativacao;
	}

	public void setDataDesativacao(String dataDesativacao) {
		this.dataDesativacao = dataDesativacao;
	}

	@Override
	public String toString() {
		return "\n" + id + ", " + nome + ", " + statusAtivacao + ", "
				+ dataCriacao + ", " + dataDesativacao + "\n";
	}
	
}
