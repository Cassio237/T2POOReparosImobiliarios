package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ufu.Imovel;
import ufu.Sistema;

import java.awt.GridBagLayout;
import javax.swing.JScrollPane;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.Font;

public class listaImoveisView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtListaDeImoveis;

	private static Sistema sistema = new Sistema();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					listaImoveisView frame = new listaImoveisView();
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
	public listaImoveisView() {
		sistema.iniciaDados();

		setTitle("Lista de Imoveis");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		contentPane.add(scrollPane, gbc_scrollPane);

		txtListaDeImoveis = new JTextField();
		txtListaDeImoveis.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtListaDeImoveis.setHorizontalAlignment(SwingConstants.CENTER);
		txtListaDeImoveis.setText("Lista de Imoveis");
		scrollPane.setColumnHeaderView(txtListaDeImoveis);
		txtListaDeImoveis.setColumns(10);

		JTextArea txtImoveis = new JTextArea();
		txtImoveis.setEditable(false);
		listarImoveis(txtImoveis);
		scrollPane.setViewportView(txtImoveis);

		JButton btnAddImoveis = new JButton("Adicionar Imovel");
		GridBagConstraints gbc_btnAddImoveis = new GridBagConstraints();
		gbc_btnAddImoveis.gridx = 0;
		gbc_btnAddImoveis.gridy = 1;
		contentPane.add(btnAddImoveis, gbc_btnAddImoveis);
	}

	public void listarImoveis(JTextArea textArea) {
		StringBuilder lista = new StringBuilder();
		ArrayList<Imovel> Imoveis = sistema.getImoveis();
		try {
			for (Imovel imovel : Imoveis) {
				lista.append(String
						.format("ID: " + imovel.getId() + " - Endereço: " + imovel.getEndereco() + " - Proprietário ID: "
								+ imovel.getCliente().getId() + " - Nome: " + imovel.getCliente().getNome()+ "\n"));
			}
			textArea.setText(lista.toString());
		} catch (Exception e) {
			System.out.println("listaImovelView.listarImovel " + e);
			JOptionPane.showMessageDialog(null, "listaImovelView.listarImovel " + e);
		}
	}

}