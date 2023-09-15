package pessoa;

import java.util.Date;

import enums.TipoCargoEnum;

public abstract class Pessoa { //  CLASSE PAI

	// ATRIBUTOS
	protected String nome;
	protected String senha;
	protected String cpf;
	protected String email;
	protected String telefone;
	protected Date dataCadastro;
	protected TipoCargoEnum tipoCargo;

	// CONSTRUTOR
	public Pessoa() {
	}

	public Pessoa(String cpf, String senha, String nome, String email, String telefone, TipoCargoEnum tipoCargo) {
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
		this.email = email;
		this.telefone = telefone;
		this.tipoCargo = tipoCargo;
		this.dataCadastro = new Date();
	}

	// GETS E SETS
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public TipoCargoEnum getTipoCargo() {
		return tipoCargo;
	}

	public void setTipoCargo(TipoCargoEnum tipoCargo) {
		this.tipoCargo = tipoCargo;
	}

}
