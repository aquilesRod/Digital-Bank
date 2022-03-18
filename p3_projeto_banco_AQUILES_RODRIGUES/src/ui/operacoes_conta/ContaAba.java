package ui.operacoes_conta;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ui.inicial_tela.SelecaoDeContaAba;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContaAba extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public ContaAba(int numConta, String opcao) {
		setTitle("CONTA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		contaBody(numConta, opcao);
	}
		
	private void contaBody(int numConta, String opcao) {
		JButton botaoTransferir = new JButton("Transferir");
		botaoTransferir.setFont(new Font("Century", Font.PLAIN, 11));
		botaoTransferir.setBounds(169, 59, 89, 23);
		contentPane.add(botaoTransferir);
		botaoTransferir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContaTransferenciaAba ta = new ContaTransferenciaAba(numConta, opcao);
				ta.setVisible(true);
				setVisible(false);
			}
		});
		
		JButton botaoDepositar = new JButton("Depositar");
		botaoDepositar.setFont(new Font("Century", Font.PLAIN, 11));
		botaoDepositar.setBounds(169, 93, 89, 23);
		contentPane.add(botaoDepositar);
		botaoDepositar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContaDepositoAba da = new ContaDepositoAba(numConta, opcao);
				da.setVisible(true);
				setVisible(false);
			}
		});
		
		JButton botaoSacar = new JButton("Sacar");
		botaoSacar.setFont(new Font("Century", Font.PLAIN, 11));
		botaoSacar.setBounds(169, 130, 89, 23);
		contentPane.add(botaoSacar);
		botaoSacar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContaSaqueAba sa = new ContaSaqueAba(numConta, opcao);
				sa.setVisible(true);
				setVisible(false);
			}
		});
		
		JButton botaoVerSaldo = new JButton("Ver saldo");
		botaoVerSaldo.setFont(new Font("Century", Font.PLAIN, 11));
		botaoVerSaldo.setBounds(169, 164, 89, 23);
		contentPane.add(botaoVerSaldo);
		botaoVerSaldo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContaSaldoAba csa = new ContaSaldoAba(numConta, opcao);
				csa.setVisible(true);
				setVisible(false);
			}
		});
		
		JButton botaoPix = new JButton("Pix");
		botaoPix.setFont(new Font("Century", Font.PLAIN, 11));
		botaoPix.setBounds(367, 11, 57, 23);
		contentPane.add(botaoPix);
		botaoPix.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PixMenuAba mpix = new PixMenuAba(numConta, opcao);
				mpix.setVisible(true);
				setVisible(false);
			}
		});
		
		JButton botaoSair = new JButton("Sair");
		botaoSair.setFont(new Font("Century", Font.PLAIN, 11));
		botaoSair.setBounds(10, 227, 72, 23);
		contentPane.add(botaoSair);
		botaoSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelecaoDeContaAba sca = new SelecaoDeContaAba();
				sca.setVisible(true);
				setVisible(false);
			}
		});
		
	}
	
}
