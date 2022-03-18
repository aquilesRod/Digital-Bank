package entities;

import ui.util.exceptions.SaldoInsuficienteException;

public class ContaCorrente extends Conta implements Pix {
	
	private String chavePix;

	public ContaCorrente(int numConta, String cpfDono, String senha, int numAgencia) {
		super(numConta, cpfDono, senha, numAgencia);
	}
	
	public void sacar(float quantia) throws SaldoInsuficienteException{
		if (this.getSaldo() > quantia){
			this.setSaldo(this.getSaldo() - quantia - 6.5f); //taxa de saque do SifuBank
        } else {
            throw new SaldoInsuficienteException();
        }
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
			throws SaldoInsuficienteException {
		this.setSaldo(getSaldo() - quantia);
	}

	public String getChavePix() {
		return this.chavePix;
	}

	public void setChavePix(String chavePix) {
		this.chavePix = chavePix;
	}
	
}
