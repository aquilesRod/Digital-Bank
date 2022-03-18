package entities;

import ui.util.exceptions.SaldoInsuficienteException;

public class ContaPoupanca extends Conta implements Pix{
	
	private String chavePix;

	public ContaPoupanca(int numConta, String cpfDono, String senha, int numAgencia) {
		super(numConta, cpfDono, senha, numAgencia);
	}

	@Override
	public void cadastrarChavePix(String chavePix) {
		this.setChavePix(chavePix);
	}

	@Override
	public void removerChave(String chavePix) {
		this.setChavePix(null);
	}

	@Override
	public void transferenciaPix(float quantia) 
			throws SaldoInsuficienteException  {
		this.setSaldo(getSaldo() - quantia);
	}
	
	public String getChavePix() {
		return this.chavePix;
	}

	public void setChavePix(String chavePix) {
		this.chavePix = chavePix;
	}

}
