package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import ufu.Cliente;
import ufu.PessoaFisica;
import ufu.PessoaJuridica;
import ufu.Sistema;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class addImovelView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textDado;
	private JTextField textTelefone;
	
	Sistema sistema = new Sistema();
	Cliente clienteSelecionado;
	DefaultListModel<Cliente> listaCliente = new DefaultListModel<>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addImovelView frame = new addImovelView();
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
	public addImovelView() {
		sistema.iniciaDados();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{426, 202, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{55, 0, 0};
		gbl_panel.rowHeights = new int[]{36, 50, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("Cadastrar Imovel ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblEndereco = new JLabel("Endereco");
		GridBagConstraints gbc_lblEndereco = new GridBagConstraints();
		gbc_lblEndereco.insets = new Insets(0, 0, 5, 5);
		gbc_lblEndereco.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblEndereco.gridx = 0;
		gbc_lblEndereco.gridy = 1;
		panel.add(lblEndereco, gbc_lblEndereco);
		
		JTextArea textEndereco = new JTextArea();
		textEndereco.setLineWrap(true);
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.insets = new Insets(0, 0, 5, 0);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 1;
		gbc_textArea.gridy = 1;
		Border border = BorderFactory.createLineBorder(Color.GRAY, 1);
		textEndereco.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		panel.add(textEndereco, gbc_textArea);
		
		JLabel lblNewLabel_1 = new JLabel("Nome Responsavel");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textNome = new JTextField();
		textNome.setBackground(new Color(255, 255, 255));
		textNome.setEditable(false);
		GridBagConstraints gbc_textNome = new GridBagConstraints();
		gbc_textNome.ipady = 5;
		gbc_textNome.insets = new Insets(0, 0, 5, 0);
		gbc_textNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNome.gridx = 1;
		gbc_textNome.gridy = 2;
		panel.add(textNome, gbc_textNome);
		textNome.setColumns(10);
		
		JLabel lblDado = new JLabel("CPF");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		panel.add(lblDado, gbc_lblNewLabel_3);
		
		textDado = new JTextField();
		textDado.setBackground(new Color(255, 255, 255));
		textDado.setEditable(false);
		GridBagConstraints gbc_textDado = new GridBagConstraints();
		gbc_textDado.ipady = 5;
		gbc_textDado.ipadx = 40;
		gbc_textDado.anchor = GridBagConstraints.WEST;
		gbc_textDado.insets = new Insets(0, 0, 5, 0);
		gbc_textDado.gridx = 1;
		gbc_textDado.gridy = 3;
		panel.add(textDado, gbc_textDado);
		textDado.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Telefone");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		panel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		textTelefone = new JTextField();
		textTelefone.setBackground(new Color(255, 255, 255));
		textTelefone.setEditable(false);
		GridBagConstraints gbc_textTelefone = new GridBagConstraints();
		gbc_textTelefone.ipady = 5;
		gbc_textTelefone.ipadx = 40;
		gbc_textTelefone.insets = new Insets(0, 0, 5, 0);
		gbc_textTelefone.anchor = GridBagConstraints.WEST;
		gbc_textTelefone.gridx = 1;
		gbc_textTelefone.gridy = 4;
		panel.add(textTelefone, gbc_textTelefone);
		textTelefone.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textEndereco.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o campo Endereco");
					return;
				}
				if (clienteSelecionado == null) {
					JOptionPane.showMessageDialog(null, "Selecione o cliente na lista a direita");
					return;
				}
				sistema.criarImovel(textEndereco.getText(), clienteSelecionado);
				clienteSelecionado = null;
				textEndereco.setText("");
				textNome.setText("");
				textDado.setText("");
				textTelefone.setText("");
			}
		});
		GridBagConstraints gbc_btnCadastrar = new GridBagConstraints();
		gbc_btnCadastrar.insets = new Insets(0, 0, 5, 0);
		gbc_btnCadastrar.gridx = 1;
		gbc_btnCadastrar.gridy = 5;
		panel.add(btnCadastrar, gbc_btnCadastrar);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 0;
		contentPane.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel_1.add(scrollPane, gbc_scrollPane);
		
		JList<Cliente> listCliente = new JList<>(listaCliente);
		listarClientes(listaCliente);
		scrollPane.setViewportView(listCliente);
		
		JLabel lblNewLabel_2 = new JLabel("Selecione o Cliente");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		scrollPane.setColumnHeaderView(lblNewLabel_2);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(new ActionListener() {
			@Override
		    public void actionPerformed(ActionEvent e) {
		        Cliente cliente = listCliente.getSelectedValue();
		        if (cliente != null) {
		            if (cliente instanceof PessoaFisica ) {
						lblDado.setText("CPF");
					} else if (cliente instanceof PessoaJuridica) {
						lblDado.setText("CNPJ");
					}
		            textNome.setText(cliente.getNome());
		            textDado.setText(cliente.getDado());
		            textTelefone.setText(cliente.getTelefone());
		            clienteSelecionado = cliente;
		            JOptionPane.showMessageDialog(null, "Confira os dados!");
		        } else {
		            JOptionPane.showMessageDialog(null, "Nenhum cliente selecionado.");
		        }
		    }
		});
		GridBagConstraints gbc_btnInserir = new GridBagConstraints();
		gbc_btnInserir.gridx = 0;
		gbc_btnInserir.gridy = 1;
		panel_1.add(btnInserir, gbc_btnInserir);
	}
	
	public void cadastrar(String endereco, Cliente cliente) {
		sistema.criarImovel(endereco, cliente);
	}
	
	public void listarClientes(DefaultListModel<Cliente> modelCliente) {
	    ArrayList<Cliente> clientes = sistema.getClientes();
	    try {
	        modelCliente.clear();
	        for (Cliente cliente : clientes) {
	            modelCliente.addElement(cliente);
	        }
	    } catch (Exception e) {
	        System.out.println("addImovelView.listarCliente " + e); 
	        JOptionPane.showMessageDialog(null, "addImovelView.listarCliente " + e);
	    }
	}

}
