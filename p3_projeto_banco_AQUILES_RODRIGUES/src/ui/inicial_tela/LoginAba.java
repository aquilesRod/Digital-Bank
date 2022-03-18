package ui.inicial_tela;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;
import ui.operacoes_conta.ContaAba;
import ui.util.popups.Popup;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginAba extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField campoLogin;
	private JPasswordField campoSenha;
	private Fachada fachada;
	private Popup popup;
	
	public LoginAba(String opcao) {
		fachada = new Fachada();
		popup = new Popup();
		
		setType(Type.UTILITY);
		setFont(new Font("Aharoni", Font.PLAIN, 12));
		setTitle("LOGIN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		campoLogin = new JTextField();
		campoSenha = new JPasswordField();
		
		loginBody(opcao);
	}
	
	private void loginBody(String opcao) {
		JLabel nomeDoBanco = new JLabel("SifuBank");
		nomeDoBanco.setForeground(Color.WHITE);
		nomeDoBanco.setFont(new Font("Kristen ITC", Font.PLAIN, 25));
		nomeDoBanco.setBounds(166, 25, 129, 30);
		contentPane.add(nomeDoBanco);
		
		JLabel textoLogin = new JLabel("Numero da conta:");
		textoLogin.setForeground(Color.WHITE);
		textoLogin.setFont(new Font("Century", Font.PLAIN, 11));
		textoLogin.setBounds(85, 91, 92, 14);
		contentPane.add(textoLogin);
		
		campoLogin.setBounds(187, 88, 86, 20);
		contentPane.add(campoLogin);
		campoLogin.setColumns(10);
		
		JLabel textoSenha = new JLabel("Senha:");
		textoSenha.setForeground(Color.WHITE);
		textoSenha.setFont(new Font("Century", Font.PLAIN, 11));
		textoSenha.setBounds(131, 136, 46, 14);
		contentPane.add(textoSenha);
		
		campoSenha.setBounds(187, 133, 86, 20);
		contentPane.add(campoSenha);
		
		JButton botaoConfirmar = new JButton("\u2714"); //botao confirma
		botaoConfirmar.setBounds(292, 132, 55, 23);
		contentPane.add(botaoConfirmar);
		botaoConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int numConta = Integer.parseInt(campoLogin.getText());
				String senha = new String (campoSenha.getPassword());
				
				boolean haConta;
				boolean senhaValida;
				if (opcao.equals("c")) {
					haConta = fachada.buscarContaCorrente(numConta);
					senhaValida = fachada.verificarSenhaContaCorrente(numConta,
							senha);
				} else {
					haConta = fachada.buscarContaPoupanca(numConta);
					senhaValida = fachada.verificarSenhaContaPoupanca(numConta,
							senha);
				}
				
				if(!haConta) {
					popup.getAnyMessage("Essa conta nao existe!");
				} else if (!senhaValida){
					popup.getAnyMessage("Senha incorreta!");
				} else {
					ContaAba ca = new ContaAba(numConta, opcao);
					ca.setVisible(true);
					setVisible(false);
				}
			}
		});
		
		JButton botaoVoltar = new JButton("Voltar");
		botaoVoltar.setFont(new Font("Century", Font.PLAIN, 11));
		botaoVoltar.setBounds(187, 227, 89, 23);
		contentPane.add(botaoVoltar);
		botaoVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelecaoDeContaAba sca = new SelecaoDeContaAba();
				sca.setVisible(true);
				setVisible(false);
			}
		});
		
	}
	
}
