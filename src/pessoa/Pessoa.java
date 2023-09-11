package pessoa;



public abstract class Pessoa {

	// Atributos
	private String usuario;
	private String senha;
	private String email;
	private String telefone;
	private String cpf;

	// Construtor

	public Pessoa(String usuario, String senha, String email, String telefone, String cpf) {
		this.usuario = usuario;
		this.senha = senha;
		this.email = email;
		this.telefone = telefone;
		this.cpf = cpf;

	}

	// Construtor Padrão
	public Pessoa() {

	}

	// Get and set

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
