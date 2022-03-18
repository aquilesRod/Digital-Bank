package entities;

public class Cliente {
	
	private String nome, cpf, celular, endereco, email;
	
	public Cliente(String nome, String cpf, String celular, String email, String endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.celular = celular;
		this.email = email;
		this.endereco = endereco;
	}

	public String getNome() {
		return this.nome;
	}

	public String getCelular() {
		return this.celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return this.cpf;
	}
	
}
