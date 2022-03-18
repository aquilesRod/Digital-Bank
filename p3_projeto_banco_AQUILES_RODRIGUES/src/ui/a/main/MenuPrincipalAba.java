package ui.a.main;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ui.inicial_tela.About;
import ui.inicial_tela.ContaCadastroAba;
import ui.inicial_tela.SelecaoDeContaAba;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MenuPrincipalAba extends JFrame  {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public MenuPrincipalAba() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(500, 200, 500, 350);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		mainBody();
	}
	
	private void mainBody() {
		JLabel nomeDoBanco = new JLabel("SifuBank");
		nomeDoBanco.setForeground(Color.WHITE);
		nomeDoBanco.setFont(new Font("Kristen ITC", Font.PLAIN, 25));
		nomeDoBanco.setBounds(191, 11, 129, 30);
		contentPane.add(nomeDoBanco);
		contentPane.setVisible(true);
		
		JButton botaoDeLogin = new JButton("Login");
		botaoDeLogin.setBounds(352, 90, 89, 23);
		contentPane.add(botaoDeLogin);
		botaoDeLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelecaoDeContaAba sca = new SelecaoDeContaAba();
				sca.setVisible(true);
				setVisible(false);
			}
		});
		
		JButton botaoDeCadastro = new JButton("Cadastre-se");
		botaoDeCadastro.setBounds(341, 134, 110, 23);
		contentPane.add(botaoDeCadastro);
		botaoDeCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContaCadastroAba ca = new ContaCadastroAba();
				ca.setVisible(true);
				setVisible(false);
			}
		});
		
		JButton botaoAbout = new JButton("SifuAbout");
		botaoAbout.setBounds(352, 180, 89, 23);
		contentPane.add(botaoAbout);
		botaoAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				About about = new About();
				about.setVisible(true);
				setVisible(false);
			}
		});
		
		JLabel slogan1 = new JLabel("Atrasou o pagamento? Sifu!");
		slogan1.setForeground(Color.WHITE);
		slogan1.setFont(new Font("Century", Font.PLAIN, 11));
		slogan1.setBounds(112, 245, 165, 14);
		contentPane.add(slogan1);
		
		JLabel slogan2 = new JLabel("Ta devendo 1 milhao de reais em emprestimos? Sifu!");
		slogan2.setForeground(Color.WHITE);
		slogan2.setFont(new Font("Century", Font.PLAIN, 11));
		slogan2.setBounds(57, 265, 277, 14);
		contentPane.add(slogan2);
		
		JLabel slogan3 = new JLabel("SifuBank, o banco do povo brasileiro.");
		slogan3.setForeground(Color.WHITE);
		slogan3.setFont(new Font("Century", Font.PLAIN, 11));
		slogan3.setBounds(85, 285, 202, 14);
		contentPane.add(slogan3);
		
		JLabel logoSifu = new JLabel("");
		logoSifu.setIcon(new ImageIcon(MenuPrincipalAba.class.getResource("/ui/util/imagens/sifudeu.PNG")));
		logoSifu.setBounds(27, 52, 304, 192);
		contentPane.add(logoSifu);
	}
	
}
