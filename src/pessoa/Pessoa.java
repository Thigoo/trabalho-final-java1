package pessoa;

import java.util.Date;

import agencia.ETipoAgencia;
import conta.ETipoConta;

public abstract class Pessoa {
	
	protected String nome;
	protected String cpf;
	protected String senha;
	protected String email;
	protected String telefone;
	protected Date dataCadastro;
	protected ETipoAcesso Acesso;
	protected ETipoAgencia IdAgencia;
	
	public Pessoa() {
	}

	public Pessoa(String nome, String cpf, String senha, String email, String telefone, ETipoAcesso acesso, ETipoAgencia idAgencia) {
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
		this.email = email;
		this.telefone = telefone;
		this.dataCadastro = new Date();
		this.Acesso = acesso;
		this.IdAgencia = idAgencia;
	}

	
	public ETipoAcesso getAcesso() {
		return Acesso;
	}


	public ETipoAgencia getIdAgencia() {
		return IdAgencia;
	}


	public String getNome() {
		return nome;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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
