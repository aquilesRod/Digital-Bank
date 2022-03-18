package ui.operacoes_conta;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ui.operacoes_conta.pix.PixCadastrarChave;
import ui.operacoes_conta.pix.PixRemoverChave;
import ui.operacoes_conta.pix.PixTransferencia;
import ui.operacoes_conta.pix.PixVisualizarChave;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PixMenuAba extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public PixMenuAba(int numConta, String opcao) {
		setTitle("PIX");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		pixMenuBody(numConta, opcao);
	}
		
	private void pixMenuBody(int numConta, String opcao) {
		JButton botaoTransferir = new JButton("Transferir");
		botaoTransferir.setFont(new Font("Century", Font.PLAIN, 11));
		botaoTransferir.setBounds(162, 51, 89, 23);
		contentPane.add(botaoTransferir);
		
		botaoTransferir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PixTransferencia pt = new PixTransferencia(numConta, opcao);
				pt.setVisible(true);
				setVisible(false);
			}
		});
		
		JButton botaoCadastrarChave = new JButton("Cadastrar chave pix");
		botaoCadastrarChave.setFont(new Font("Century", Font.PLAIN, 11));
		botaoCadastrarChave.setBounds(141, 85, 135, 23);
		contentPane.add(botaoCadastrarChave);
		
		botaoCadastrarChave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PixCadastrarChave pcc = new PixCadastrarChave(numConta, opcao);
				pcc.setVisible(true);
				setVisible(false);
			}
		});
		
		JButton botaoRemoverChave = new JButton("Remover chave pix");
		botaoRemoverChave.setFont(new Font("Century", Font.PLAIN, 11));
		botaoRemoverChave.setBounds(141, 119, 135, 23);
		contentPane.add(botaoRemoverChave);
		
		botaoRemoverChave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PixRemoverChave prc = new PixRemoverChave(numConta, opcao);
				prc.setVisible(true);
				setVisible(false);
			}
		});
		
		JButton botaoVisualizarChave = new JButton("Visualizar chave pix");
		botaoVisualizarChave.setFont(new Font("Century", Font.PLAIN, 11));
		botaoVisualizarChave.setBounds(141, 155, 135, 23);
		contentPane.add(botaoVisualizarChave);
		
		botaoVisualizarChave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PixVisualizarChave pvc = new PixVisualizarChave(numConta, opcao);
				pvc.setVisible(true);
				setVisible(false);
			}
		});
		
		JButton botaoVoltar = new JButton("Voltar");
		botaoVoltar.setFont(new Font("Century", Font.PLAIN, 11));
		botaoVoltar.setBounds(10, 227, 72, 23);
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
