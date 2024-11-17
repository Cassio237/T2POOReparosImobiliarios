package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import ufu.Cliente;
import ufu.Imovel;
import ufu.Orcamento;
import ufu.PessoaFisica;
import ufu.PessoaJuridica;
import ufu.Sistema;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class addOrcamentoView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textDado;
	
	private DefaultListModel<Cliente> listaCliente = new DefaultListModel<Cliente>();
	private DefaultListModel<Imovel> listaImovel = new DefaultListModel<Imovel>();
	protected Cliente clienteSelecionado;
	protected Imovel imovelSelecionado;
	public Orcamento orcamentoCriado;
	
	private static Sistema sistema = new Sistema();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addOrcamentoView frame = new addOrcamentoView();
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
	public addOrcamentoView() {
		sistema.iniciaDados();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 758, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{27, 34, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.anchor = GridBagConstraints.NORTH;
		gbc_panel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		contentPane.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{24, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel = new JLabel("Criar Orçamento");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 0;
		panel.add(scrollPane_1, gbc_scrollPane_1);
		
		JLabel lblNewLabel_1 = new JLabel("Selecione o Imovel");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		scrollPane_1.setColumnHeaderView(lblNewLabel_1);
		
		JList<Imovel> listImovel = new JList<Imovel>(listaImovel);
		listarImoveis(listaImovel);
		scrollPane_1.setViewportView(listImovel);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 0;
		panel.add(scrollPane, gbc_scrollPane);
		
		JLabel lblNewLabel_1_1 = new JLabel("Selecione o Responsavel");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		scrollPane.setColumnHeaderView(lblNewLabel_1_1);
		
		JList<Cliente> listCliente = new JList<Cliente>(listaCliente);
		listarClientes(listaCliente);
		scrollPane.setViewportView(listCliente);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 0, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 2;
		panel.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblNewLabel_2 = new JLabel("Endereço");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 0;
		panel_2.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JTextArea textEndereco = new JTextArea();
		textEndereco.setEditable(false);
		textEndereco.setFont(new Font("Tahoma", Font.PLAIN, 10));
		GridBagConstraints gbc_textEndereco = new GridBagConstraints();
		gbc_textEndereco.fill = GridBagConstraints.BOTH;
		gbc_textEndereco.gridx = 1;
		gbc_textEndereco.gridy = 0;
		Border border = BorderFactory.createLineBorder(Color.GRAY, 1);
		textEndereco.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		panel_2.add(textEndereco, gbc_textEndereco);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 1;
		gbc_panel_3.gridy = 2;
		panel.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JLabel lblNewLabel_3 = new JLabel("Nome");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 0;
		panel_3.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		textNome = new JTextField();
		textNome.setBackground(new Color(255, 255, 255));
		textNome.setEditable(false);
		GridBagConstraints gbc_textNome = new GridBagConstraints();
		gbc_textNome.insets = new Insets(0, 0, 5, 0);
		gbc_textNome.fill = GridBagConstraints.BOTH;
		gbc_textNome.gridx = 1;
		gbc_textNome.gridy = 0;
		panel_3.add(textNome, gbc_textNome);
		textNome.setColumns(10);
		
		JLabel lblDado = new JLabel("CPF");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 1;
		panel_3.add(lblDado, gbc_lblNewLabel_4);
		
		textDado = new JTextField();
		textDado.setBackground(new Color(255, 255, 255));
		textDado.setEditable(false);
		GridBagConstraints gbc_textDado = new GridBagConstraints();
		gbc_textDado.anchor = GridBagConstraints.WEST;
		gbc_textDado.fill = GridBagConstraints.VERTICAL;
		gbc_textDado.gridx = 1;
		gbc_textDado.gridy = 1;
		panel_3.add(textDado, gbc_textDado);
		textDado.setColumns(10);
		
		JButton btnAddImovel = new JButton("Inserir Imovel");
		btnAddImovel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Imovel imovel = listImovel.getSelectedValue();
		        if (imovel != null) {
		            textEndereco.setText(imovel.getEndereco());
		            imovelSelecionado = imovel;
		        } else {
		            JOptionPane.showMessageDialog(null, "Nenhum imovel selecionado.");
		        }
		    }
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 1;
		panel.add(btnAddImovel, gbc_btnNewButton_1);
		
		JButton btnAddCliente = new JButton("Inserir Cliente");
		btnAddCliente.addActionListener(new ActionListener() {
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
		            clienteSelecionado = cliente;
		        } else {
		            JOptionPane.showMessageDialog(null, "Nenhum cliente selecionado.");
		        }
		    }
		});
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_2.gridx = 1;
		gbc_btnNewButton_2.gridy = 1;
		panel.add(btnAddCliente, gbc_btnNewButton_2);
		
		JButton btnAddOrcamento = new JButton("Criar Orçamento");
		btnAddOrcamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imovelSelecionado = listImovel.getSelectedValue();
				clienteSelecionado = listCliente.getSelectedValue();
				if (clienteSelecionado == null || imovelSelecionado == null) {
					JOptionPane.showMessageDialog(null, "Selecione e insira Imovel e Cliente");
				}
				cadastrar(imovelSelecionado, clienteSelecionado);
				JOptionPane.showMessageDialog(null, "Abrindo Tela de Serviço!");
				addServicoView view = new addServicoView(orcamentoCriado);
				view.setVisible(true);
				dispose();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.ipadx = 40;
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 2;
		contentPane.add(btnAddOrcamento, gbc_btnNewButton);
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

	public void listarImoveis(DefaultListModel<Imovel> modelImovel) {
	    ArrayList<Imovel> imovels = sistema.getImoveis();
	    try {
	        modelImovel.clear();
	        for (Imovel imovel : imovels) {
	            modelImovel.addElement(imovel);
	        }
	    } catch (Exception e) {
	        System.out.println("addOrcamentoView.listarImoveis " + e); 
	        JOptionPane.showMessageDialog(null, "addOrcamentoView.listarImoveis " + e);
	    }
	}
	
	public void cadastrar(Imovel imovel, Cliente cliente) {
		orcamentoCriado = sistema.iniciarOrcamento(imovel, cliente);
	}
}
