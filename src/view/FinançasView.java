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
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FinançasView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultListModel<Financeiro> listaFinancaModel = new DefaultListModel<Financeiro>();
	protected Financeiro financaSelecionada;

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
		setBounds(100, 100, 600, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Função");
		menuBar.add(menu);

		JMenuItem mntmNewMenuItem1 = new JMenuItem("Alterar para Tela Principal");
		mntmNewMenuItem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainView view = new MainView();
				JOptionPane.showMessageDialog(null, "Alternando para Tela Principal");
				view.setVisible(true);
				dispose();
			}
		});
		menu.add(mntmNewMenuItem1);

		setJMenuBar(menuBar);

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane);

		JLabel lblNewLabel = new JLabel("Orçamentos Aprovados");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane.setColumnHeaderView(lblNewLabel);
		
		JList<Financeiro> listFinanca = new JList<Financeiro>(listaFinancaModel);
		listarFinancas(listaFinancaModel);
		scrollPane.setViewportView(listFinanca);

		JPanel jpanelBotao = new JPanel();
		jpanelBotao.setLayout(new FlowLayout(FlowLayout.CENTER));
		JButton btnAlterarCobranca = new JButton("Alterar Cobrança");
		btnAlterarCobranca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Financeiro financa = listFinanca.getSelectedValue();
				if (financa != null) {
					financa.mudaPago();
					sistema.attFinanca(financa);
					listFinanca.repaint();
				}
			}
		});
		jpanelBotao.add(btnAlterarCobranca);
		contentPane.add(jpanelBotao, BorderLayout.SOUTH);
	}

	public void listarFinancas(DefaultListModel<Financeiro> modelFinanca) {
		ArrayList<Financeiro> financas = sistema.getFinancas();
		try {
			modelFinanca.clear();
			for (Financeiro financa : financas) {
				modelFinanca.addElement(financa);
			}
		} catch (Exception e) {
			System.out.println("sistema.listaFinancas " + e);
			JOptionPane.showMessageDialog(null, "sistema.listaFinancas " + e);
		}
	}

}
