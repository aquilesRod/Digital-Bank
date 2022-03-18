package controller;

import repositorios.IRepositorioAgencia;
import repositorios.RepositorioAgencia;

public class AgenciaController {
	
	private IRepositorioAgencia rep = RepositorioAgencia.getInstance();
	
	public boolean buscarAgencia(int numAgencia) {
    	return rep.buscarAgencia(numAgencia);
    }
    
    public void criarAgencia(int numAgencia, String endereco) {
    	rep.criarAgencia(numAgencia, endereco);
    }
    
}
