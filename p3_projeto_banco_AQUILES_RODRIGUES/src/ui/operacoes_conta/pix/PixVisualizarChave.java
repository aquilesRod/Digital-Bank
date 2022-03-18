package ui.operacoes_conta.pix;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import fachada.Fachada;
import ui.operacoes_conta.PixMenuAba;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PixVisualizarChave extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Fachada fachada;
	
	public PixVisualizarChave(int numConta, String opcao) {
		fachada = new Fachada();
		
		setTitle("VISUALIZACAO DA CHAVE PIX");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		verChavePixBody(numConta, opcao);
	}
		
	private void verChavePixBody(int numConta, String opcao) {
		JLabel chavePixLabel = new JLabel("Sua chave pix:");
		chavePixLabel.setForeground(Color.WHITE);
		chavePixLabel.setFont(new Font("Century", Font.PLAIN, 14));
		chavePixLabel.setBounds(168, 55, 122, 14);
		contentPane.add(chavePixLabel);
		
		String chavePix;
		if (opcao.equals("c")) {
			chavePix = fachada.getChavePixContaCorrente(numConta);
		} else {
			chavePix = fachada.getChavePixContaPoupanca(numConta);
		}
		
		JLabel textChavePix = new JLabel(chavePix);
		textChavePix.setHorizontalAlignment(SwingConstants.CENTER);
		textChavePix.setForeground(Color.WHITE);
		textChavePix.setBackground(Color.WHITE);
		textChavePix.setBounds(153, 93, 135, 20);
		contentPane.add(textChavePix);
		
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
