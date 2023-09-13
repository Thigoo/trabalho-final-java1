package pessoa;

import java.util.Date;

import enums.TipoAcessoEnum;
import enums.TipoAgenciaEnum;
import enums.TipoContaEnum;

public abstract class Pessoa {
	
	protected String nome;
	protected String cpf;
	protected String email;
	protected String telefone;
	protected Date dataCadastro;
	protected TipoAcessoEnum Acesso;
	protected TipoAgenciaEnum IdAgencia;
	
	public Pessoa() {
	}

	public Pessoa(String nome, String cpf, String email, String telefone, TipoAcessoEnum acesso, TipoAgenciaEnum idAgencia) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
		this.dataCadastro = new Date();
		this.Acesso = acesso;
		this.IdAgencia = idAgencia;
	}

	
	public TipoAcessoEnum getAcesso() {
		return Acesso;
	}


	public TipoAgenciaEnum getIdAgencia() {
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
