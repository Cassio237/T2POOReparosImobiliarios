package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ufu.Cliente;
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

public class listaClientesView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtListaDeClientes;
	
	private static Sistema sistema = new Sistema();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					listaClientesView frame = new listaClientesView();
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
	public listaClientesView() {
		sistema.iniciaDados();
	
		setTitle("Lista de Clientes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		txtListaDeClientes = new JTextField();
		txtListaDeClientes.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtListaDeClientes.setHorizontalAlignment(SwingConstants.CENTER);
		txtListaDeClientes.setText("Lista de Clientes");
		scrollPane.setColumnHeaderView(txtListaDeClientes);
		txtListaDeClientes.setColumns(10);
		
		JTextArea txtClientes = new JTextArea();
		txtClientes.setEditable(false);
		listarClientes(txtClientes);
		scrollPane.setViewportView(txtClientes);
		
		JButton btnAddClientes = new JButton("Adicionar Cliente");
		GridBagConstraints gbc_btnAddClientes = new GridBagConstraints();
		gbc_btnAddClientes.gridx = 0;
		gbc_btnAddClientes.gridy = 1;
		contentPane.add(btnAddClientes, gbc_btnAddClientes);
	}
	
	public void listarClientes(JTextArea textArea) {
	    StringBuilder lista = new StringBuilder();
	    ArrayList<Cliente> clientes = sistema.getClientes();
	    try {
	        for (Cliente cliente : clientes) {
	            lista.append(String.format(
	                "ID: %d - Nome: %s - %s - Endereco: %s - Telefone: %s\n",
	                cliente.getId(), cliente.getNome(), cliente.getDado(),
	                cliente.getEndereco(), cliente.getTelefone()
	            ));
	        }
	        textArea.setText(lista.toString());
	    } catch (Exception e) {
	        System.out.println("listaClienteView.listarCliente " + e); 
	        JOptionPane.showMessageDialog(null, "listaClienteView.listarCliente " + e);
	    }
	}


}
