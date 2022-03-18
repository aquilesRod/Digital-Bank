package entities;

public class Agencia {
	
	private int numeroAgencia;
	private String endereco;

	public Agencia(int numeroAgencia, String endereco) {
		super();
		this.numeroAgencia = numeroAgencia;
		this.endereco = endereco;
	}

	public int getNumeroAgencia() {
		return this.numeroAgencia;
	}

	public String getEndereco() {
		return endereco;
	}
	
}
