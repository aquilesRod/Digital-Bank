package controller;

import repositorios.*;
import ui.util.exceptions.*;

public class ContaCorrenteController {

    private IRepositorioConta rep = RepositorioContaCorrente.getInstance();

    public boolean buscar(int numConta){
        return rep.buscarConta(numConta);
    }

    public void sacar(int numConta, float quantia) throws SaldoInsuficienteException {
        rep.sacar(numConta,quantia);
    }

    public void depositar(int numConta, float quantia) {
        rep.depositar(numConta,quantia);
    }

    public float getSaldo(int numConta) {
        return rep.getSaldo(numConta);
    }

	public void transferir(int numConta, int numContaDest, float quantia) throws SaldoInsuficienteException {
		rep.transferir(numConta, numContaDest, quantia);
	}
	
	public boolean buscarChavePix(String chavePix) {
		return rep.buscarChavePix(chavePix);
	}
	
	public void transferenciaPix(int numConta, String chavePix, float quantia) throws SaldoInsuficienteException {
		rep.transferenciaPix(numConta, chavePix, quantia);
	}
	
	public void cadastrarChavePix(int numConta, String chavePix) {
		rep.cadastrarChavePix(numConta, chavePix);
	}
	
	public void removerChavePix(int numConta, String chavePix) {
		rep.removerChavePix(numConta, chavePix);
	}
	
	public int criarConta(String cpf, String senha, int numAgencia) {
		return rep.criarConta(cpf, senha, numAgencia);
	}

	public boolean verificarSenha(int numConta, String senha) {
		return rep.verificarSenha(numConta, senha);
	}

	public String getChavePix(int numConta) {
		return rep.getChavePix(numConta);
	}
	
}
