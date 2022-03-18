package ui.inicial_tela;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;

import fachada.Fachada;
import ui.a.main.MenuPrincipalAba;
import ui.util.popups.Popup;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ContaCadastroAba extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Fachada fachada;
	private Popup popup;
	
	public ContaCadastroAba() {
		fachada = new Fachada();
		popup = new Popup();
		
		setTitle("CADASTRO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cadastroBody();
	}
	
	private void cadastroBody() {
		JLabel textoNome = new JLabel("Nome Completo:");
		textoNome.setFont(new Font("Century", Font.PLAIN, 11));
		textoNome.setForeground(Color.WHITE);
		textoNome.setBackground(Color.WHITE);
		textoNome.setBounds(59, 28, 99, 14);
		contentPane.add(textoNome);
		
		JTextField campoNome = new JTextField();
		campoNome.setBounds(168, 25, 212, 20);
		contentPane.add(campoNome);
		campoNome.setColumns(50);
		
		JLabel textCPF = new JLabel("CPF:");
		textCPF.setForeground(Color.WHITE);
		textCPF.setFont(new Font("Century", Font.PLAIN, 11));
		textCPF.setBackground(Color.WHITE);
		textCPF.setBounds(122, 59, 46, 14);
		contentPane.add(textCPF);
		
		JTextField campoCPF = new JTextField();
		campoCPF.setBounds(168, 56, 212, 20);
		contentPane.add(campoCPF);
		campoCPF.setColumns(11);
		
		JLabel textCelular = new JLabel("Celular:");
		textCelular.setForeground(Color.WHITE);
		textCelular.setFont(new Font("Century", Font.PLAIN, 11));
		textCelular.setBackground(Color.WHITE);
		textCelular.setBounds(105, 90, 63, 14);
		contentPane.add(textCelular);
		
		JTextField campoCelular = new JTextField();
		campoCelular.setBounds(168, 87, 212, 20);
		contentPane.add(campoCelular);
		campoCelular.setColumns(13);
		
		JLabel textEmail = new JLabel("E-mail:");
		textEmail.setForeground(Color.WHITE);
		textEmail.setFont(new Font("Century", Font.PLAIN, 11));
		textEmail.setBackground(Color.WHITE);
		textEmail.setBounds(107, 121, 61, 14);
		contentPane.add(textEmail);
		
		JTextField campoEmail = new JTextField();
		campoEmail.setBounds(168, 118, 212, 20);
		contentPane.add(campoEmail);
		campoEmail.setColumns(50);
		
		JLabel textEndereco = new JLabel("Endereco:");
		textEndereco.setForeground(Color.WHITE);
		textEndereco.setFont(new Font("Century", Font.PLAIN, 11));
		textEndereco.setBackground(Color.WHITE);
		textEndereco.setBounds(100, 152, 82, 14);
		contentPane.add(textEndereco);
		
		JTextField campoEndereco = new JTextField();
		campoEndereco.setBounds(168, 149, 212, 20);
		contentPane.add(campoEndereco);
		campoEndereco.setColumns(100);
		
		JLabel textSenha = new JLabel("Senha de Acesso:");
		textSenha.setForeground(Color.WHITE);
		textSenha.setFont(new Font("Century", Font.PLAIN, 11));
		textSenha.setBackground(Color.WHITE);
		textSenha.setBounds(68, 180, 127, 14);
		contentPane.add(textSenha);
		
		JPasswordField campoSenha = new JPasswordField();
		campoSenha.setBounds(168, 180, 212, 20);
		contentPane.add(campoSenha);
		
		JLabel lblTipoDaConta = new JLabel("Tipo da conta:");
		lblTipoDaConta.setForeground(Color.WHITE);
		lblTipoDaConta.setFont(new Font("Century", Font.PLAIN, 11));
		lblTipoDaConta.setBackground(Color.WHITE);
		lblTipoDaConta.setBounds(100, 219, 82, 14);
		contentPane.add(lblTipoDaConta);
		
		JButton botaoContaPoupanca = new JButton("Poupanca");
		botaoContaPoupanca.setBounds(284, 215, 82, 23);
		contentPane.add(botaoContaPoupanca);
		botaoContaPoupanca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpf = campoCPF.getText();
				String senha = new String (campoSenha.getPassword());
				
				boolean result = fachada.buscarCliente(cpf);
				if (!result) {
					String nome = campoNome.getText();
					String celular = campoCelular.getText();
					String email = campoEmail.getText();
					String endereco = campoEndereco.getText();
					
					fachada.criarCliente(nome, cpf, celular, email, endereco);
					
					int numConta;
					int numAgencia = 1;
					
					numConta = fachada.criarContaPoupanca(cpf, senha, numAgencia);
					popup.getAnyMessage("O numero da sua conta e: "+numConta);
					MenuPrincipalAba mpa = new MenuPrincipalAba();
					mpa.setVisible(true);
					setVisible(false);
				} else {
					popup.getAnyMessage("Cadastro ja existente!");
				}
			}
		});
		
		JButton botaoContaCorrente = new JButton("Corrente");
		botaoContaCorrente.setBounds(185, 215, 89, 23);
		contentPane.add(botaoContaCorrente);
		botaoContaCorrente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpf = campoCPF.getText();
				String senha = new String (campoSenha.getPassword());
				
				boolean result = fachada.buscarCliente(cpf);
				if (!result) {
					String nome = campoNome.getText();
					String celular = campoCelular.getText();
					String email = campoEmail.getText();
					String endereco = campoEndereco.getText();
					
					fachada.criarCliente(nome, cpf, celular, email, endereco);
					
					int numConta;
					int numAgencia = 1;
					
					numConta = fachada.criarContaPoupanca(cpf, senha, numAgencia);
					popup.getAnyMessage("O numero da sua conta e: "+numConta);
				} else {
					popup.getAnyMessage("Cadastro ja existente!");
				}
			}
		});
		
		JButton botaoVoltar = new JButton("Voltar");
		botaoVoltar.setFont(new Font("Century", Font.PLAIN, 11));
		botaoVoltar.setBounds(10, 227, 66, 23);
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
