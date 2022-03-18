package entities;

import ui.util.exceptions.SaldoInsuficienteException;

public interface Pix {
	
	public void cadastrarChavePix (String chavePix);
	
	public void removerChave (String chavePix);
	
	public void transferenciaPix (float quantia) 
			throws SaldoInsuficienteException;
	
}
