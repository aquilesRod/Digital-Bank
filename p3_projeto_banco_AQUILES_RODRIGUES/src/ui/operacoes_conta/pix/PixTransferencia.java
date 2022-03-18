package ui.operacoes_conta.pix;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import fachada.Fachada;
import ui.operacoes_conta.PixMenuAba;
import ui.util.exceptions.SaldoInsuficienteException;
import ui.util.popups.Popup;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PixTransferencia extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Fachada fachada;
	private Popup popup;

	public PixTransferencia(int numConta, String opcao) {
		fachada = new Fachada();
		popup = new Popup();
		
		setTitle("TRANSFERENCIA PIX");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		transferenciaPixBody(numConta, opcao);
	}
	
	private void transferenciaPixBody(int numConta, String opcao) {	
		JLabel textChavePix = new JLabel("Chave pix do destinatario:");
		textChavePix.setFont(new Font("Century", Font.PLAIN, 11));
		textChavePix.setForeground(Color.WHITE);
		textChavePix.setBounds(41, 74, 153, 14);
		contentPane.add(textChavePix);
		
		JTextField campoChavePix = new JTextField();
		campoChavePix.setBounds(188, 71, 128, 20);
		contentPane.add(campoChavePix);
		campoChavePix.setColumns(10);
		
		JLabel lblQuantia = new JLabel("Quantia:");
		lblQuantia.setForeground(Color.WHITE);
		lblQuantia.setFont(new Font("Century", Font.PLAIN, 11));
		lblQuantia.setBounds(122, 117, 58, 14);
		contentPane.add(lblQuantia);
		
		JTextField campoQuantia = new JTextField();
		campoQuantia.setColumns(10);
		campoQuantia.setBounds(191, 114, 86, 20);
		contentPane.add(campoQuantia);
		
		JButton botaoConfirmar = new JButton("\u2714");
		botaoConfirmar.setBounds(308, 113, 55, 23);
		contentPane.add(botaoConfirmar);
		botaoConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String chavePix = campoChavePix.getText();
				float quantia = Float.parseFloat(campoQuantia.getText());
				
				boolean chaveValida;
				if (opcao.equals("c")) {
					chaveValida = fachada.buscarChavePixContaCorrente(chavePix);
				} else {
					chaveValida = fachada.buscarChavePixContaPoupanca(chavePix);
				}
				
				if (chaveValida) {
					if (opcao.equals("c")) {
						try {
							fachada.transferenciaPixContaCorrente(numConta, chavePix,
									quantia);
							popup.getAnyMessage("Transferencia Pix "
									+ "realizada com sucesso!");
							PixMenuAba pma = new PixMenuAba(numConta, opcao);
							pma.setVisible(true);
							setVisible(false);
						} catch (SaldoInsuficienteException e1) {
							popup.getAnyMessage("Saldo insuficiente!");
						}
					} else {
						try {
							fachada.transferenciaPixContaPoupanca(numConta, chavePix,
									quantia);
							popup.getAnyMessage("Transferencia Pix realizada "
									+ "com sucesso!");
							PixMenuAba pma = new PixMenuAba(numConta, opcao);
							pma.setVisible(true);
							setVisible(false);
						} catch (SaldoInsuficienteException e1) {
							popup.getAnyMessage("Saldo insuficiente!");
						}
					}
				} else {
					popup.getAnyMessage("Chave invalida!");
				}
			}
		});
		
		JButton botaoVoltar = new JButton("Voltar");
		botaoVoltar.setFont(new Font("Century", Font.PLAIN, 11));
		botaoVoltar.setBounds(171, 211, 89, 23);
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
