package br.com.b2w.bean;

public class Objetivo {

	private int codigo;
	
	private AvaliacaoDesempenho aval;
	
	private int status;
	
	private String nome;
	
	private String resultado;
	
	private String pessoa;
	
	private String metodos;
	
	private Pilar pilar;
	
	private String dataPrazo;
	
	private String dataCriacao;
	
	private String dataAprovacao;
	
	private double autoNota;
	
	private String dataAutoNota;
	
	private double notaGestor;
	
	private String dataNotaGestor;
	
	private String dataConfirmacao;

	public Objetivo() {
		super();
	}

	public Objetivo(int codigo, AvaliacaoDesempenho aval, int status, String nome, Pilar pilar, String pessoa, String metodos, String dataPrazo,
			String dataCriacao) {
		super();
		this.codigo = codigo;
		this.aval = aval;
		this.pessoa = pessoa;
		this.pilar = pilar;
		this.status = status;
		this.nome = nome;
		this.metodos = metodos;
		this.dataPrazo = dataPrazo;
		this.dataCriacao = dataCriacao;
	}

	public Objetivo(int codigo, AvaliacaoDesempenho aval, int status, String nome, String resultado, String pessoa,
			String metodos, Pilar pilar, String dataPrazo, String dataCriacao, String dataAprovacao, double autoNota,
			String dataAutoNota, double notaGestor, String dataNotaGestor, String dataConfirmacao) {
		super();
		this.codigo = codigo;
		this.aval = aval;
		this.status = status;
		this.nome = nome;
		this.resultado = resultado;
		this.pessoa = pessoa;
		this.metodos = metodos;
		this.pilar = pilar;
		this.dataPrazo = dataPrazo;
		this.dataCriacao = dataCriacao;
		this.dataAprovacao = dataAprovacao;
		this.autoNota = autoNota;
		this.dataAutoNota = dataAutoNota;
		this.notaGestor = notaGestor;
		this.dataNotaGestor = dataNotaGestor;
		this.dataConfirmacao = dataConfirmacao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public AvaliacaoDesempenho getAval() {
		return aval;
	}

	public void setAval(AvaliacaoDesempenho aval) {
		this.aval = aval;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public String getMeta() {
		return pessoa;
	}

	public void setMeta(String pessoa) {
		this.pessoa = pessoa;
	}

	public String getDataPrazo() {
		return dataPrazo;
	}

	public void setDataPrazo(String dataPrazo) {
		this.dataPrazo = dataPrazo;
	}

	public String getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(String dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getDataAprovacao() {
		return dataAprovacao;
	}

	public void setDataAprovacao(String dataAprovacao) {
		this.dataAprovacao = dataAprovacao;
	}

	public double getAutoNota() {
		return autoNota;
	}

	public void setAutoNota(double autoNota) {
		this.autoNota = autoNota;
	}

	public String getDataAutoNota() {
		return dataAutoNota;
	}

	public void setDataAutoNota(String dataAutoNota) {
		this.dataAutoNota = dataAutoNota;
	}

	public double getNotaGestor() {
		return notaGestor;
	}

	public void setNotaGestor(double notaGestor) {
		this.notaGestor = notaGestor;
	}

	public String getDataNotaGestor() {
		return dataNotaGestor;
	}

	public void setDataNotaGestor(String dataNotaGestor) {
		this.dataNotaGestor = dataNotaGestor;
	}

	public String getDataConfirmacao() {
		return dataConfirmacao;
	}

	public void setDataConfirmacao(String dataConfirmacao) {
		this.dataConfirmacao = dataConfirmacao;
	}

	public String getPessoa() {
		return pessoa;
	}

	public void setPessoa(String pessoa) {
		this.pessoa = pessoa;
	}

	public String getMetodos() {
		return metodos;
	}

	public void setMetodos(String metodos) {
		this.metodos = metodos;
	}

	public Pilar getPilar() {
		return pilar;
	}

	public void setPilar(Pilar pilar) {
		this.pilar = pilar;
	}
	
}
