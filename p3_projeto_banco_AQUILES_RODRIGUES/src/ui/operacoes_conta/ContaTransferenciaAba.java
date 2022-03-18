package ui.operacoes_conta;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import fachada.Fachada;
import ui.util.exceptions.SaldoInsuficienteException;
import ui.util.popups.Popup;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContaTransferenciaAba extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Fachada fachada;
	private Popup popup;

	public ContaTransferenciaAba(int numConta, String opcao) {
		fachada = new Fachada();
		popup = new Popup();
		
		setTitle("TRANSFERENCIA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		transferenciaBody(numConta, opcao);
	}
		
	private void transferenciaBody(int numConta, String opcao) {
		JLabel numeroDestinatarioText = new JLabel("Numero da conta (Destinatario):");
		numeroDestinatarioText.setForeground(Color.WHITE);
		numeroDestinatarioText.setFont(new Font("Century", Font.PLAIN, 11));
		numeroDestinatarioText.setBounds(35, 82, 176, 14);
		contentPane.add(numeroDestinatarioText);
		
		JTextField campoNumConta = new JTextField();
		campoNumConta.setBounds(219, 79, 86, 20);
		contentPane.add(campoNumConta);
		campoNumConta.setColumns(10);
		
		JLabel quantiaText = new JLabel("Valor da transferencia:");
		quantiaText.setForeground(Color.WHITE);
		quantiaText.setFont(new Font("Century", Font.PLAIN, 11));
		quantiaText.setBounds(79, 124, 130, 14);
		contentPane.add(quantiaText);
		
		JTextField campoQuantia = new JTextField();
		campoQuantia.setColumns(10);
		campoQuantia.setBounds(219, 121, 86, 20);
		contentPane.add(campoQuantia);
		
		JButton botaoConfirmar = new JButton("\u2714");
		botaoConfirmar.setBounds(353, 120, 55, 23);
		contentPane.add(botaoConfirmar);
		botaoConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int numContaDest = Integer.parseInt(campoNumConta.getText());
				float quantia = Float.parseFloat(campoQuantia.getText());
				
				boolean haConta;
				if (opcao.equals("c")) {
					haConta = fachada.buscarContaCorrente(numConta);
				} else {
					haConta = fachada.buscarContaPoupanca(numConta);
				}
				
				if(haConta) {
					if (opcao.equals("c")) {
						try {
							fachada.transferirContaCorrente(numConta, numContaDest,
									quantia);
							popup.getAnyMessage("Transferencia realizada com sucesso!");
							ContaAba ca = new ContaAba(numConta, opcao);
							ca.setVisible(true);
							setVisible(false);
						} catch (SaldoInsuficienteException e1) {
							popup.getAnyMessage("Saldo insuficiente!");
						}
					} else {
						try {
							fachada.transferirContaPoupanca(numConta, numContaDest,
									quantia);
							popup.getAnyMessage("Transferencia realizada com sucesso!");
							ContaAba ca = new ContaAba(numConta, opcao);
							ca.setVisible(true);
							setVisible(false);
						} catch (SaldoInsuficienteException e1) {
							popup.getAnyMessage("Saldo insuficiente!");
						}
					}
				} else {
					popup.getAnyMessage("Conta inexistente!");
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
