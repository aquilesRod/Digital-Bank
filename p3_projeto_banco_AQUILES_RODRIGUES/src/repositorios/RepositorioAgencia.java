package repositorios;

import java.util.ArrayList;
import java.util.List;

import entities.Agencia;

public class RepositorioAgencia implements IRepositorioAgencia{
	
	private static RepositorioAgencia self;
    private List<Agencia> agencias;
    
    private RepositorioAgencia(){
    	agencias = new ArrayList<Agencia>();
    }

    public static IRepositorioAgencia getInstance() {
        if (self == null){
            self = new RepositorioAgencia();
        }
        return self;
    }
    
    @Override
    public boolean buscarAgencia(int numAgencia) {
    	boolean encontrado = false;
        for (Agencia agencia : agencias) {
        	int nc = agencia.getNumeroAgencia();
            if (nc == numAgencia){
                encontrado = true;
            }
        }
        return encontrado;
    }
    
    @Override
    public void criarAgencia(int numAgencia, String endereco) {
    	Agencia novaAgencia = new Agencia(numAgencia, endereco);
    	agencias.add(novaAgencia);
    }
    
}
