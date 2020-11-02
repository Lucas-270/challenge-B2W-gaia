package br.com.b2w.bean;

import java.util.List;

public class AvaliacaoDesempenho {

	private int codigo;
	
	private Funcionario func;
	
	private int status;
	
	private double nota;
	
	private String dataCriacao;
	
	private String dataAvaliacao;
	
	private String dataConfirmacao;
	
	private List<Objetivo> objetivos;
	
	private String dataCadObjs;
	
	private String dataFecObjs;
	
	private Funcionario criadorAval;

	public AvaliacaoDesempenho() {
		super();
	}

	public AvaliacaoDesempenho(int codigo, Funcionario func, int status, double nota, String dataAvaliacao,
			List<Objetivo> objetivos, String dataCadObjs, String dataFecObjs, Funcionario criadorAval) {
		super();
		this.codigo = codigo;
		this.func = func;
		this.status = status;
		this.nota = nota;
		this.dataAvaliacao = dataAvaliacao;
		this.objetivos = objetivos;
		this.dataCadObjs = dataCadObjs;
		this.dataFecObjs = dataFecObjs;
		this.criadorAval = criadorAval;
	}

	public AvaliacaoDesempenho(int codigo, Funcionario func, int status, double nota, String dataCriacao, String dataAvaliacao,
			String dataConfirmacao, List<Objetivo> objetivos, String dataCadObjs, String dataFecObjs,
			Funcionario criadorAval) {
		super();
		this.codigo = codigo;
		this.func = func;
		this.status = status;
		this.nota = nota;
		this.dataCriacao = dataCriacao;
		this.dataAvaliacao = dataAvaliacao;
		this.dataConfirmacao = dataConfirmacao;
		this.objetivos = objetivos;
		this.dataCadObjs = dataCadObjs;
		this.dataFecObjs = dataFecObjs;
		this.criadorAval = criadorAval;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Funcionario getFunc() {
		return func;
	}

	public void setFunc(Funcionario func) {
		this.func = func;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public String getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(String dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getDataAvaliacao() {
		return dataAvaliacao;
	}

	public void setDataAvaliacao(String dataAvaliacao) {
		this.dataAvaliacao = dataAvaliacao;
	}

	public String getDataConfirmacao() {
		return dataConfirmacao;
	}

	public void setDataConfirmacao(String dataConfirmacao) {
		this.dataConfirmacao = dataConfirmacao;
	}

	public List<Objetivo> getObjetivos() {
		return objetivos;
	}

	public void setObjetivos(List<Objetivo> objetivos) {
		this.objetivos = objetivos;
	}

	public String getDataCadObjs() {
		return dataCadObjs;
	}

	public void setDataCadObjs(String dataCadObjs) {
		this.dataCadObjs = dataCadObjs;
	}

	public String getDataFecObjs() {
		return dataFecObjs;
	}

	public void setDataFecObjs(String dataFecObjs) {
		this.dataFecObjs = dataFecObjs;
	}

	public Funcionario getCriadorAval() {
		return criadorAval;
	}

	public void setCriadorAval(Funcionario criadorAval) {
		this.criadorAval = criadorAval;
	}

}
