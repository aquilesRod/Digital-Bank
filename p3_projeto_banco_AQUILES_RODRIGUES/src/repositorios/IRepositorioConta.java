package repositorios;

import ui.util.exceptions.*;

public interface IRepositorioConta {
    
    boolean buscarConta(int numConta);
    
    void transferir(int numConta,int numContaDest, float quantia) throws SaldoInsuficienteException;
    
    void depositar(int numConta, float quantia);

    void sacar(int numConta, float quantia) throws SaldoInsuficienteException;

    float getSaldo(int numConta);
    
    boolean buscarChavePix(String chavePix);

	void transferenciaPix(int numConta, String chavePix, float quantia) throws SaldoInsuficienteException;
	
	void cadastrarChavePix(int numConta, String chavePix);
	
	void removerChavePix(int numConta, String chavePix);

	int criarConta(String cpf, String senha, int numAgencia);

	boolean verificarSenha(int numConta, String senha);

	String getChavePix(int numConta);

}
