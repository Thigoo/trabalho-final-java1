package cliente;

public class Cliente {
	//Atributos
	private String cpf;
	private String senha;
	
	//Construtor
	public Cliente(String cpf, String senha) {
		this.cpf = cpf;
		this.senha = senha;
	}
	//Get and set
	public String getCpf() {
		return cpf;

	}

	public void setSenha(String senha) {
		this.senha = senha;

	}

	public void setCpf (String cpf) {
		this.cpf = cpf;
	}
	
	public void setSenha (String senha) {
		this.senha = senha;
		
	}
		
	}

