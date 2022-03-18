package repositorios;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import entities.ContaPoupanca;
import ui.util.exceptions.*;

public class RepositorioContaPoupanca implements IRepositorioConta {
	
	private static RepositorioContaPoupanca self;
	private List<ContaPoupanca> contasPoupanca;

    private RepositorioContaPoupanca(){
    	contasPoupanca = new ArrayList<ContaPoupanca>();
    }
	
	public static IRepositorioConta getInstance() {
        if (self == null){
            self = new RepositorioContaPoupanca();
        }
        return self;
    }

	@Override
	public boolean buscarConta(int numConta) {
		boolean encontrado = false;
        for (ContaPoupanca conta : contasPoupanca) {
        	int nc = conta.getNumeroConta();
            if (nc == numConta){
                encontrado = true;
            }
        }
        return encontrado;
	}
	
	@Override
	public void depositar(int numConta, float quantia) {
		for (ContaPoupanca conta : contasPoupanca) {
			int nc = conta.getNumeroConta();
            if (nc == numConta){
                conta.depositar(quantia);
            }
        }
	}

	@Override
	public void sacar(int numConta, float quantia) throws SaldoInsuficienteException {
		for (ContaPoupanca conta : contasPoupanca) {
			int nc = conta.getNumeroConta();
            if (nc == numConta){
                conta.sacar(quantia);
            }
        }
	}

	@Override
	public float getSaldo(int numConta) {
		for (ContaPoupanca conta : contasPoupanca) {
			int nc = conta.getNumeroConta();
            if (nc == numConta){
                return conta.getSaldo();
            }
        }
		return -1;
	}

	@Override
	public void transferir(int numConta, int numContaDest, float quantia) throws SaldoInsuficienteException {
		for (ContaPoupanca conta : contasPoupanca) {
			int nc = conta.getNumeroConta();
            if (nc == numConta){
                conta.transferir(quantia);
            }
        }
		
		for (ContaPoupanca conta : contasPoupanca) {
			int nc = conta.getNumeroConta();
            if (nc == numContaDest){
                conta.depositar(quantia);
            }
        }
	}

	@Override
	public boolean buscarChavePix(String chavePix) {
		boolean encontrado = false;
        for (ContaPoupanca conta : contasPoupanca) {
        	String nc = conta.getChavePix();
        	if (nc != null) {
	            if (nc.equals(chavePix)){
	                encontrado = true;
	            }
        	}
        }
        return encontrado;
	}

	@Override
	public void transferenciaPix(int numConta, String chavePix, float quantia) throws SaldoInsuficienteException {
		for (ContaPoupanca conta : contasPoupanca) {
			int nc = conta.getNumeroConta();
            if (nc == numConta){
                conta.transferenciaPix(quantia);
            }
        }
		
		for (ContaPoupanca conta : contasPoupanca) {
			String cp = conta.getChavePix();
            if (chavePix.equals(cp)){
                conta.depositar(quantia);
            }
        }
	}

	@Override
	public void cadastrarChavePix(int numConta, String chavePix) {
		for (ContaPoupanca conta : contasPoupanca) {
			int nc = conta.getNumeroConta();
            if (nc == numConta){
                conta.setChavePix(chavePix);
            }
        }
	}

	@Override
	public void removerChavePix(int numConta, String chavePix) {
		for (ContaPoupanca conta : contasPoupanca) {
			int nc = conta.getNumeroConta();
            if (nc == numConta){
                conta.setChavePix(null);
            }
        }
	}
	
	@Override
	public String getChavePix(int numConta) {
		for (ContaPoupanca conta : contasPoupanca) {
			int nc = conta.getNumeroConta();
            if (nc == numConta){
                return conta.getChavePix();
            }
        }
		return null;
	}

	@Override
	public int criarConta(String cpf, String senha, int numAgencia) {
		int numConta;
		do {
			numConta = 1000+(new Random().nextInt(8999));
		} while (buscarConta(numConta));
		
		ContaPoupanca novaConta = new ContaPoupanca(numConta, cpf, senha, numAgencia);
		contasPoupanca.add(novaConta);
		return numConta;
	}

	@Override
	public boolean verificarSenha(int numConta, String senha) {
		boolean valido = false;
        for (ContaPoupanca conta : contasPoupanca) {
        	int nc = conta.getNumeroConta();
            if (nc == numConta && senha.equals(conta.getSenhaDeAcesso())){
                valido = true;
            }
        }
        return valido;
	}

}
