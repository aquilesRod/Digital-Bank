package ui.operacoes_conta;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

import fachada.Fachada;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContaSaldoAba extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Fachada fachada;

	public ContaSaldoAba(int numConta, String opcao) {
		fachada = new Fachada();
		
		setTitle("CONSULTA DE SALDO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		saldoBody(numConta, opcao);
	}
		
	private void saldoBody(int numConta, String opcao) {
		JLabel texto = new JLabel("Seu saldo atual:");
		texto.setForeground(Color.WHITE);
		texto.setFont(new Font("Century", Font.PLAIN, 14));
		texto.setBounds(152, 60, 130, 14);
		contentPane.add(texto);
		
		float saldo;
		if (opcao.equals("c")) {
			saldo = fachada.saldoContaCorrente(numConta);
		} else {
			saldo = fachada.saldoContaPoupanca(numConta);
		}
		
		JLabel saldoTexto = new JLabel("R$"+saldo);
		saldoTexto.setForeground(Color.WHITE);
		saldoTexto.setFont(new Font("Century", Font.PLAIN, 14));
		saldoTexto.setBounds(166, 102, 101, 14);
		contentPane.add(saldoTexto);
		
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
