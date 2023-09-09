package pessoa;

public class Cliente extends Pessoa {
	// Atributos
	private String cpf;
	private String senha;

	// Construtor

	public Cliente() {
		super();
	}

	public Cliente(String usuario, String senha, String email, String telefone, String cpf) {
		super(usuario, senha, email, telefone, cpf);
	}

	

	// Get and set
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

}
