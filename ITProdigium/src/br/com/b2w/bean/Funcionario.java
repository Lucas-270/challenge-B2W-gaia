package br.com.b2w.bean;

/**
 * Classe que ira instanciar um funcionario
 * @author Lucas
 *
 */
public class Funcionario {

	private int codigo;
	
	private String nome;
	
	private String cargo;
	
	private String gestor;
	
	private Departamento dep;
	
	private TipoAssociado tipo;
	
	private String email;
	
	private String senha;
	
	private String dataCadastro;
	
	private String dataDesativacao;
	
	private int isActive;

	public Funcionario() {
		super();
	}

	public Funcionario(int codigo, String nome, String cargo, String gestor, Departamento dep, TipoAssociado tipo, String email, String senha, String dataCadastro,
			String dataDesativacao, int isActive) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.cargo = cargo;
		this.gestor = gestor;
		this.dep = dep;
		this.tipo = tipo;
		this.email = email;
		this.senha = senha;
		this.dataCadastro = dataCadastro;
		this.dataDesativacao = dataDesativacao;
		this.isActive = isActive;
	}
	
	public Funcionario(int codigo, String nome, String cargo, String gestor, Departamento dep, TipoAssociado tipo, String email, String senha, String dataDesativacao, int isActive) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.cargo = cargo;
		this.gestor = gestor;
		this.dep = dep;
		this.tipo = tipo;
		this.email = email;
		this.senha = senha;
		this.dataDesativacao = dataDesativacao;
		this.isActive = isActive;
	}

	public Funcionario(int codigo, String nome, String cargo, String gestor, Departamento dep, TipoAssociado tipo, String email, String senha, int isActive) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.cargo = cargo;
		this.gestor = gestor;
		this.dep = dep;
		this.tipo = tipo;
		this.email = email;
		this.senha = senha;
		this.isActive = isActive;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getGestor() {
		return gestor;
	}

	public void setGestor(String gestor) {
		this.gestor = gestor;
	}

	public Departamento getDep() {
		return dep;
	}

	public void setDep(Departamento dep) {
		this.dep = dep;
	}

	public TipoAssociado getTipo() {
		return tipo;
	}

	public void setTipo(TipoAssociado tipo) {
		this.tipo = tipo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getDataDesativacao() {
		return dataDesativacao;
	}

	public void setDataDesativacao(String dataDesativacao) {
		this.dataDesativacao = dataDesativacao;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return codigo + ", " + nome + ", " + cargo + ", " + gestor + ", "
				+ dep + ", " + tipo + ", " + email + ", " + senha + ", " + dataCadastro
				+ ", " + dataDesativacao + ", " + isActive + "\n";
	}

	
}
