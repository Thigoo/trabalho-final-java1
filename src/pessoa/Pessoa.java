package pessoa;

import java.util.Date;

import enums.TipoAcessoEnum;
import enums.TipoAgenciaEnum;
import enums.TipoContaEnum;

public abstract class Pessoa {
	
	protected String nome;
	

	protected String senha;
	protected String cpf;
	protected String email;
	protected String telefone;
	protected Date dataCadastro;
	protected TipoAcessoEnum Acesso;
	public String IdAgencia;
	
	public Pessoa() {
	}
	
	public Pessoa(TipoAcessoEnum acesso, String cpf, String senha, String nome,  String email, String telefone, String idAgencia) {
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
		this.email = email;
		this.telefone = telefone;
		this.dataCadastro = new Date();
		this.Acesso = acesso;
		this.IdAgencia = idAgencia;
	}

	
	public TipoAcessoEnum getAcesso() {
		return Acesso;
	}
	
	
	

//	public void setIdAgencia(String dados) {
//		IdAgencia = dados;
//	}
//
//	public TipoAgenciaEnum getIdAgencia() {
//		return IdAgencia;
//	}
	

	public String getNome() {
		return nome;
	}

	public void setIdAgencia(String idAgencia) {
		IdAgencia = idAgencia;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSenha() {
		return senha;
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
	
}
