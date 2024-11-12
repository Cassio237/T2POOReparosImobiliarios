package view;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ufu.Financeiro;
import ufu.Sistema;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.BorderLayout;

public class FinançasView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private static Sistema sistema = new Sistema();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinançasView frame = new FinançasView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FinançasView() {
		sistema.iniciaDados();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Função");
		menuBar.add(menu);

		JMenuItem mntmNewMenuItem1 = new JMenuItem("Principal");
		menu.add(mntmNewMenuItem1);

		JMenuItem mntmNewMenuItem2 = new JMenuItem("Finanças");
		menu.add(mntmNewMenuItem2);

		setJMenuBar(menuBar);

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JTextArea txtFinanca = new JTextArea();
		txtFinanca.setEditable(false);
		listarFinancas(txtFinanca);
		JScrollPane scrollPane = new JScrollPane(txtFinanca);
		contentPane.add(scrollPane);

		JLabel lblNewLabel = new JLabel("Orçamentos Aprovados");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane.setColumnHeaderView(lblNewLabel);

		JPanel jpanelBotao = new JPanel();
		jpanelBotao.setLayout(new FlowLayout(FlowLayout.CENTER));
		JButton btnAlterarCobranca = new JButton("Alterar Cobrança");
		jpanelBotao.add(btnAlterarCobranca);
		contentPane.add(jpanelBotao, BorderLayout.SOUTH);
	}

	public void listarFinancas(JTextArea textArea) {
		StringBuilder lista = new StringBuilder();
		ArrayList<Financeiro> financas = sistema.getFinancas();
		try {
			for (Financeiro financa : financas) {
				lista.append(String.format(
						"ID: %d - Cliente: %s - Endereco: %s - Valor: R$ %.2f - Data: %s - Pago: %s\n", financa.getId(),
						financa.getResponsavel().getNome(), financa.getOrcamento().getImovel().getEndereco(),
						financa.getValor(), financa.getData(), financa.getPago()));
			}
			textArea.setText(lista.toString());
		} catch (Exception e) {
			System.out.println("sistema.listaFinancas " + e);
			JOptionPane.showMessageDialog(null, "sistema.listaFinancas " + e);
		}
	}

}
