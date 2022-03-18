package ui.inicial_tela;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ui.a.main.MenuPrincipalAba;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class About extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public About() {
		setFont(new Font("Century", Font.PLAIN, 15));
		setType(Type.UTILITY);
		setTitle("ABOUT");
		setForeground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 450, 300);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		aboutBody();
	}
	
	private void aboutBody() {
		JLabel textoAbout = new JLabel("Este programa foi feito por Aquiles Rodrigues.");
		
		textoAbout.setFont(new Font("Century", Font.PLAIN, 15));
		textoAbout.setForeground(Color.WHITE);
		textoAbout.setBackground(Color.WHITE);
		textoAbout.setBounds(41, 11, 354, 26);
		contentPane.add(textoAbout);
		
		JButton botaoVoltar = new JButton("Voltar");
		botaoVoltar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		botaoVoltar.setBounds(151, 209, 118, 23);
		contentPane.add(botaoVoltar);
		botaoVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipalAba mpa = new MenuPrincipalAba();
				mpa.setVisible(true);
				setVisible(false);
			}
		});
		
		JLabel texto1 = new JLabel("Bem-vindos ao Sifubank!");
		texto1.setFont(new Font("Century", Font.PLAIN, 11));
		texto1.setForeground(Color.WHITE);
		texto1.setBounds(141, 151, 147, 14);
		contentPane.add(texto1);
		
		JLabel texto2 = new JLabel("Todos os direitos reservados \u00A9");
		texto2.setFont(new Font("Tahoma", Font.PLAIN, 8));
		texto2.setForeground(Color.WHITE);
		texto2.setBounds(306, 236, 118, 14);
		contentPane.add(texto2);
		
		JLabel texto3 = new JLabel("Projeto de Programacao III");
		texto3.setFont(new Font("Century", Font.PLAIN, 11));
		texto3.setForeground(Color.WHITE);
		texto3.setBounds(134, 42, 177, 14);
		contentPane.add(texto3);
		
		JLabel texto4 = new JLabel("Sistema que contem algumas operacoes basicas de uma conta bancaria.");
		texto4.setFont(new Font("Century", Font.PLAIN, 11));
		texto4.setForeground(Color.WHITE);
		texto4.setBounds(35, 125, 399, 14);
		contentPane.add(texto4);
		
	}
	
	
}
