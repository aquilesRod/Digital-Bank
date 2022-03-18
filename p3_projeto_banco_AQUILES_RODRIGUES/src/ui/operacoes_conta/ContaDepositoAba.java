package ui.operacoes_conta;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;
import ui.util.popups.Popup;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContaDepositoAba extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Fachada fachada;
	private Popup popup;

	public ContaDepositoAba(int numConta, String opcao) {
		fachada = new Fachada();
		popup = new Popup();
		
		setTitle("DEPOSITO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		depositoBody(numConta, opcao);
	}
	
	private void depositoBody(int numConta, String opcao) {
		JLabel quantiaText = new JLabel("Valor do deposito:");
		quantiaText.setForeground(Color.WHITE);
		quantiaText.setFont(new Font("Century", Font.PLAIN, 11));
		quantiaText.setBounds(66, 103, 130, 14);
		contentPane.add(quantiaText);
		
		JTextField campoQuantia = new JTextField();
		campoQuantia.setColumns(10);
		campoQuantia.setBounds(166, 100, 86, 20);
		contentPane.add(campoQuantia);
		
		JButton botaoConfirmar = new JButton("\u2714");
		botaoConfirmar.setBounds(317, 99, 55, 23);
		contentPane.add(botaoConfirmar);
		botaoConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float quantia = Float.parseFloat(campoQuantia.getText());
				
				boolean haConta;
				if (opcao.equals("c")) {
					haConta = fachada.buscarContaCorrente(numConta);
				} else {
					haConta = fachada.buscarContaPoupanca(numConta);
				}
				
				if(haConta) {
					if (opcao.equals("c")) {
						fachada.depositarContaCorrente(numConta, quantia);
					} else {
						fachada.depositarContaPoupanca(numConta, quantia);
					}
					popup.getAnyMessage("Deposito realizado com sucesso!");
					ContaAba ca = new ContaAba(numConta, opcao);
					ca.setVisible(true);
					setVisible(false);
				} else {
					popup.getAnyMessage("Conta nao existente!");
				}
			}
		});
		
		JButton botaoVoltar = new JButton("Voltar");
		botaoVoltar.setFont(new Font("Century", Font.PLAIN, 11));
		botaoVoltar.setBounds(166, 213, 89, 23);
		contentPane.add(botaoVoltar);
		botaoVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContaAba ca = new ContaAba(numConta, opcao);
				ca.setVisible(true);
				setVisible(false);
			}
		});
		
	}

}
