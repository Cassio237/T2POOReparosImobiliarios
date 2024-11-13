package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ufu.Prestador;
import ufu.Sistema;

import java.awt.GridBagLayout;
import javax.swing.JScrollPane;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.Font;

public class listaPrestadoresView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtListaDePrestadores;

	private static Sistema sistema = new Sistema();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					listaPrestadoresView frame = new listaPrestadoresView();
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
	public listaPrestadoresView() {
		sistema.iniciaDados();

		setTitle("Lista de Prestadores");
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

		txtListaDePrestadores = new JTextField();
		txtListaDePrestadores.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtListaDePrestadores.setHorizontalAlignment(SwingConstants.CENTER);
		txtListaDePrestadores.setText("Lista de Prestadores");
		scrollPane.setColumnHeaderView(txtListaDePrestadores);
		txtListaDePrestadores.setColumns(10);

		JTextArea txtPrestadores = new JTextArea();
		txtPrestadores.setEditable(false);
		listarPrestadores(txtPrestadores);
		scrollPane.setViewportView(txtPrestadores);

		JButton btnAttPrestadores = new JButton("Atualizar Lista Prestador");
		btnAttPrestadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sistema.iniciaDados();
				listarPrestadores(txtPrestadores);
			}
		});
		GridBagConstraints gbc_btnAddPrestadores = new GridBagConstraints();
		gbc_btnAddPrestadores.gridx = 0;
		gbc_btnAddPrestadores.gridy = 1;
		contentPane.add(btnAttPrestadores, gbc_btnAddPrestadores);
	}

	public void listarPrestadores(JTextArea textArea) {
		StringBuilder lista = new StringBuilder();
		ArrayList<Prestador> Prestadores = sistema.getPrestadores();
		try {
			for (Prestador prestador : Prestadores) {
				lista.append(String.format(" - Nome: " + prestador.getNome()
						+ " - Função principal: " + prestador.getFuncao() + "\n"));
			}
			textArea.setText(lista.toString());
		} catch (Exception e) {
			System.out.println("listaprestadorView.listarprestador " + e);
			JOptionPane.showMessageDialog(null, "listaprestadorView.listarprestador " + e);
		}
	}

}