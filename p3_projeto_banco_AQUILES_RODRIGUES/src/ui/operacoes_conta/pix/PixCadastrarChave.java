package ui.operacoes_conta.pix;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import fachada.Fachada;
import ui.operacoes_conta.PixMenuAba;
import ui.util.popups.Popup;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PixCadastrarChave extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Fachada fachada;
	private Popup popup;
	
	public PixCadastrarChave(int numConta, String opcao) {
		fachada = new Fachada();
		popup = new Popup();
		
		setTitle("CADASTRO DE CHAVE PIX");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cadastrarChavePixBody(numConta, opcao);
	}
		
	private void cadastrarChavePixBody(int numConta, String opcao) {
		JLabel textChavePix = new JLabel("Chave pix:");
		textChavePix.setForeground(Color.WHITE);
		textChavePix.setFont(new Font("Century", Font.PLAIN, 11));
		textChavePix.setBounds(27, 99, 153, 14);
		contentPane.add(textChavePix);
		
		JTextField campoChavePix = new JTextField();
		campoChavePix.setColumns(10);
		campoChavePix.setBounds(172, 96, 128, 20);
		contentPane.add(campoChavePix);
		
		JButton botaoConfirmar = new JButton("\u2714");
		botaoConfirmar.setBounds(326, 95, 55, 23);
		contentPane.add(botaoConfirmar);
		botaoConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String chavePix = campoChavePix.getText();
				
				boolean haChavePix;
				if (opcao.equals("c")) {
					haChavePix = fachada.buscarChavePixContaCorrente(chavePix);
				} else {
					haChavePix = fachada.buscarChavePixContaPoupanca(chavePix);
				}
				
				if(!haChavePix) {
					if (opcao.equals("c")) {
						fachada.cadastrarChavePixContaCorrente(numConta, chavePix);
					} else {
						fachada.cadastrarChavePixContaPoupanca(numConta, chavePix);
					}
					popup.getAnyMessage("Chave cadastrada com sucesso!");
					PixMenuAba pma = new PixMenuAba(numConta, opcao);
					pma.setVisible(true);
					setVisible(false);
				} else {
					popup.getAnyMessage("Chave pix ja existente no cadastro!");
				}
			}
		});
		
		JButton botaoVoltar = new JButton("Voltar");
		botaoVoltar.setFont(new Font("Century", Font.PLAIN, 11));
		botaoVoltar.setBounds(172, 212, 89, 23);
		contentPane.add(botaoVoltar);
		botaoVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PixMenuAba pma = new PixMenuAba(numConta, opcao);
				pma.setVisible(true);
				setVisible(false);
			}
		});
		
	}

}
