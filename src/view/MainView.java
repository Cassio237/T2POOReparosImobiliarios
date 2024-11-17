package view;

import ufu.Sistema;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainView extends JFrame {

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
					MainView frame = new MainView();
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
	public MainView() {
		sistema.iniciaDados();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 300);
		contentPane = new JPanel();

		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Função");
		menuBar.add(menu);

		JMenuItem mntmNewMenuItem2 = new JMenuItem("Alterar Tela para Finanças");
		mntmNewMenuItem2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FinançasView view = new FinançasView();
				JOptionPane.showMessageDialog(null, "Alternando para Tela de Finanças");
				view.setVisible(true);
				dispose();
			}
		});
		menu.add(mntmNewMenuItem2);

		setJMenuBar(menuBar);

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 212, 0 };
		gbl_contentPane.rowHeights = new int[] { 30, 191, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel lblNewLabel = new JLabel("Menu Principal");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null,
						"<html>Escolha uma opção e uma outra janela irá abrir. Acima, no menu Função, você pode alternar para a função de Financeiro.</html>");
			}
		});
		lblNewLabel.setToolTipText("Clique para informações");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 203, 191, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JButton btnAddCliente = new JButton("Adicionar Clientes");
		GridBagConstraints gbc_btnAddCliente = new GridBagConstraints();
		gbc_btnAddCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAddCliente.ipady = 1;
		gbc_btnAddCliente.ipadx = 1;
		gbc_btnAddCliente.insets = new Insets(10, 25, 10, 25);
		gbc_btnAddCliente.gridx = 0;
		gbc_btnAddCliente.gridy = 0;
		panel.add(btnAddCliente, gbc_btnAddCliente);

		JButton btnListCliente = new JButton("Listar Clientes");
		GridBagConstraints gbc_btnListCliente = new GridBagConstraints();
		gbc_btnListCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnListCliente.ipady = 1;
		gbc_btnListCliente.ipadx = 1;
		gbc_btnListCliente.insets = new Insets(10, 25, 10, 25);
		gbc_btnListCliente.gridx = 1;
		gbc_btnListCliente.gridy = 0;
		panel.add(btnListCliente, gbc_btnListCliente);

		JButton btnAddImovel = new JButton("Adicionar Imovel");
		GridBagConstraints gbc_btnAddImovel = new GridBagConstraints();
		gbc_btnAddImovel.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAddImovel.ipady = 1;
		gbc_btnAddImovel.ipadx = 1;
		gbc_btnAddImovel.insets = new Insets(10, 25, 10, 25);
		gbc_btnAddImovel.gridx = 0;
		gbc_btnAddImovel.gridy = 1;
		panel.add(btnAddImovel, gbc_btnAddImovel);

		JButton btnListImovel = new JButton("Listar Imoveis");
		GridBagConstraints gbc_btnListImovel = new GridBagConstraints();
		gbc_btnListImovel.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnListImovel.ipady = 1;
		gbc_btnListImovel.ipadx = 1;
		gbc_btnListImovel.insets = new Insets(10, 25, 10, 25);
		gbc_btnListImovel.gridx = 1;
		gbc_btnListImovel.gridy = 1;
		panel.add(btnListImovel, gbc_btnListImovel);

		JButton btnAddPrestador = new JButton("Adicionar Prestador");
		GridBagConstraints gbc_btnAddPrestador = new GridBagConstraints();
		gbc_btnAddPrestador.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAddPrestador.insets = new Insets(10, 25, 10, 25);
		gbc_btnAddPrestador.gridx = 0;
		gbc_btnAddPrestador.gridy = 2;
		panel.add(btnAddPrestador, gbc_btnAddPrestador);

		JButton btnListPrestador = new JButton("Listar Prestadores");
		GridBagConstraints gbc_btnListPrestador = new GridBagConstraints();
		gbc_btnListPrestador.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnListPrestador.ipady = 1;
		gbc_btnListPrestador.ipadx = 1;
		gbc_btnListPrestador.insets = new Insets(10, 25, 10, 25);
		gbc_btnListPrestador.gridx = 1;
		gbc_btnListPrestador.gridy = 2;
		panel.add(btnListPrestador, gbc_btnListPrestador);

		JButton btnCriarOrcamento = new JButton("Criar Orçamento");
		btnCriarOrcamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addOrcamentoView view = new addOrcamentoView();
				view.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnCriarOrcamento = new GridBagConstraints();
		gbc_btnCriarOrcamento.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCriarOrcamento.ipady = 1;
		gbc_btnCriarOrcamento.ipadx = 1;
		gbc_btnCriarOrcamento.insets = new Insets(10, 25, 10, 25);
		gbc_btnCriarOrcamento.gridx = 0;
		gbc_btnCriarOrcamento.gridy = 3;
		panel.add(btnCriarOrcamento, gbc_btnCriarOrcamento);

		JButton btnLstOrcamento = new JButton("Listar Orçamentos");
		btnLstOrcamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listaOrcamentoView view = new listaOrcamentoView();
				view.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnLstOrcamento = new GridBagConstraints();
		gbc_btnLstOrcamento.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnLstOrcamento.ipady = 1;
		gbc_btnLstOrcamento.ipadx = 1;
		gbc_btnLstOrcamento.insets = new Insets(10, 25, 10, 25);
		gbc_btnLstOrcamento.gridx = 1;
		gbc_btnLstOrcamento.gridy = 3;
		panel.add(btnLstOrcamento, gbc_btnLstOrcamento);
		
		btnListPrestador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listaPrestadoresView view = new listaPrestadoresView();
				view.setVisible(true);
			}
		});
		btnAddPrestador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addPrestadorView view = new addPrestadorView();
				view.setVisible(true);
			}
		});
		btnListImovel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listaImoveisView view = new listaImoveisView();
				view.setVisible(true);
			}
		});
		btnAddImovel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addImovelView view = new addImovelView();
				view.setVisible(true);
			}
		});
		btnListCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listaClientesView view = new listaClientesView();
				view.setVisible(true);
			}
		});
		btnAddCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addClienteView view = new addClienteView();
				view.setVisible(true);
			}
		});

	}

}
