package repositorios;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import entities.ContaCorrente;
import ui.util.exceptions.SaldoInsuficienteException;

public class RepositorioContaCorrente implements IRepositorioConta {
	
    private static RepositorioContaCorrente self;
    private List<ContaCorrente> contasCorrente;

    private RepositorioContaCorrente(){
        contasCorrente = new ArrayList<ContaCorrente>();
        ContaCorrente cliente1 = new ContaCorrente(123, "1234", "abc", 1);
        contasCorrente.add(cliente1);
        ContaCorrente cliente2 = new ContaCorrente(321, "4321", "abc", 1);
        contasCorrente.add(cliente2);
    }

    public static IRepositorioConta getInstance() {
        if (self == null){
            self = new RepositorioContaCorrente();
        }
        return self;
    }

	@Override
	public boolean buscarConta(int numConta) {
		boolean encontrado = false;
        for (ContaCorrente conta : contasCorrente) {
        	int nc = conta.getNumeroConta();
            if (nc == numConta){
                encontrado = true;
            }
        }
        return encontrado;
	}
	
	@Override
	public void transferir(int numConta, int numContaDest, float quantia) throws SaldoInsuficienteException {
		for (ContaCorrente conta : contasCorrente) {
			int nc = conta.getNumeroConta();
            if (nc == numConta){
                conta.transferir(quantia);
            }
        }
		
		for (ContaCorrente conta : contasCorrente) {
			int nc = conta.getNumeroConta();
            if (nc == numContaDest){
                conta.depositar(quantia);
            }
        }
	}
	
	@Override
	public void depositar(int numConta, float quantia) {
		for (ContaCorrente conta : contasCorrente) {
			int nc = conta.getNumeroConta();
            if (nc == numConta){
                conta.depositar(quantia);
            }
        }
	}

	@Override
	public void sacar(int numConta, float quantia)
			throws SaldoInsuficienteException {
		for (ContaCorrente conta : contasCorrente) {
			int nc = conta.getNumeroConta();
            if (nc == numConta){
                conta.sacar(quantia);
            }
        }
	}

	@Override
	public float getSaldo(int numConta) {
		for (ContaCorrente conta : contasCorrente) {
			int nc = conta.getNumeroConta();
            if (nc == numConta){
                return conta.getSaldo();
            }
        }
		return -1;
	}
	
	@Override
	public boolean buscarChavePix(String chavePix) {
		boolean encontrado = false;
        for (ContaCorrente conta : contasCorrente) {
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
		for (ContaCorrente conta : contasCorrente) {
			int nc = conta.getNumeroConta();
            if (nc == numConta){
                conta.transferenciaPix(quantia);
            }
        }
		
		for (ContaCorrente conta : contasCorrente) {
			String cp = conta.getChavePix();
            if (chavePix.equals(cp)){
                conta.depositar(quantia);
            }
        }
	}

	@Override
	public void cadastrarChavePix(int numConta, String chavePix) {
		for (ContaCorrente conta : contasCorrente) {
			int nc = conta.getNumeroConta();
            if (nc == numConta){
                conta.setChavePix(chavePix);
            }
        }
	}

	@Override
	public void removerChavePix(int numConta, String chavePix) {
		for (ContaCorrente conta : contasCorrente) {
			int nc = conta.getNumeroConta();
            if (nc == numConta){
                conta.setChavePix(null);
            }
        }
	}
	
	@Override
	public String getChavePix(int numConta) {
		for (ContaCorrente conta : contasCorrente) {
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
		
		ContaCorrente novaConta = new ContaCorrente(numConta, cpf, senha, numAgencia);
		contasCorrente.add(novaConta);
		return numConta;
	}

	@Override
	public boolean verificarSenha(int numConta, String senha) {
		boolean valido = false;
        for (ContaCorrente conta : contasCorrente) {
        	int nc = conta.getNumeroConta();
            if (nc == numConta && senha.equals(conta.getSenhaDeAcesso())){
                valido = true;
            }
        }
        return valido;
	}

}
