package ui.inicial_tela;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ui.a.main.MenuPrincipalAba;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SelecaoDeContaAba extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public SelecaoDeContaAba() {
		setTitle("LOGIN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		selecaoDeContaBody();
	}
		
	private void selecaoDeContaBody() {
		JButton botaoContaCorrente = new JButton("Conta Corrente");
		botaoContaCorrente.setBounds(147, 57, 117, 23);
		botaoContaCorrente.setFont(new Font("Century", Font.PLAIN, 11));
		contentPane.add(botaoContaCorrente);
		botaoContaCorrente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginAba la = new LoginAba("c");
				la.setVisible(true);
				setVisible(false);
			}
		});
		
		JButton botaoContaPoupanca = new JButton("Conta Poupanca");
		botaoContaPoupanca.setBounds(147, 106, 117, 23);
		botaoContaPoupanca.setFont(new Font("Century", Font.PLAIN, 11));
		contentPane.add(botaoContaPoupanca);
		botaoContaPoupanca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginAba la = new LoginAba("p");
				la.setVisible(true);
				setVisible(false);
			}
		});
		
		JButton botaoVoltar = new JButton("Voltar");
		botaoVoltar.setBounds(175, 194, 65, 23);
		botaoVoltar.setFont(new Font("Century", Font.PLAIN, 11));
		contentPane.add(botaoVoltar);
		botaoVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipalAba mpa = new MenuPrincipalAba();
				mpa.setVisible(true);
				setVisible(false);
			}
		});
		
	}
	
}
