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

public class ContaSaqueAba extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Fachada fachada;
	private Popup popup;

	public ContaSaqueAba(int numConta, String opcao) {
		fachada = new Fachada();
		popup = new Popup();
		
		setTitle("SAQUE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		saqueBody(numConta, opcao);
	}
		
	private void saqueBody(int numConta, String opcao) {
		JLabel quantiaText = new JLabel("Valor do saque:");
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
				
				if (opcao.equals("c")) {
					try {
						fachada.sacarContaCorrente(numConta, quantia);
					} catch (SaldoInsuficienteException e1) {
						popup.getAnyMessage("Saldo insuficiente!");
					}
				} else {
					try {
						fachada.sacarContaPoupanca(numConta, quantia);
					} catch (SaldoInsuficienteException e1) {
						popup.getAnyMessage("Saldo insuficiente!");
					}
				}
				popup.getAnyMessage("Saque realizada com sucesso!");
				ContaAba ca = new ContaAba(numConta, opcao);
				ca.setVisible(true);
				setVisible(false);
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
