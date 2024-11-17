package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ufu.Materiais;
import ufu.Orcamento;
import ufu.Prestador;
import ufu.Servico;
import ufu.Sistema;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class addServicoView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JTextField textCliente;
	private JTextField textID;
	private JTextField textPrestador;
	private JTextField textServico;
	private JTextField textValorServico;
	private JTextField textValotTotal;

	private static Sistema sistema = new Sistema();
	protected Orcamento orcamentoPassado;
	private DefaultListModel<Prestador> listaPrestador = new DefaultListModel<Prestador>();
	protected ArrayList<Materiais> materiaisCopiado = new ArrayList<Materiais>();
	protected Prestador prestadorSelecionado;
	protected Double valorServico = 0.0;
	protected Servico servicoCriado;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { addServicoView frame = new
	 * addServicoView(null); frame.setVisible(true); } catch (Exception e) {
	 * JOptionPane.showMessageDialog(null,
	 * "<html>Adicionar Serviçoes precisa de um orcamento <br> Chame atraves da addOrcamentoView <br></html>"
	 * ); e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the frame.
	 */
	public addServicoView(Orcamento orcamento) {
		sistema.iniciaDados();
		orcamentoPassado = orcamento;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 0;
		contentPane.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 0, 0 };
		gbl_panel_2.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel_2.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 0;
		panel_2.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel_3.rowHeights = new int[] { 0, 0 };
		gbl_panel_3.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel_3.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_3.setLayout(gbl_panel_3);

		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.VERTICAL;
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		panel_3.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 31, 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JLabel lblNewLabel_4 = new JLabel("Adicionar Serviços");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 0;
		panel_1.add(lblNewLabel_4, gbc_lblNewLabel_4);

		JLabel lblNewLabel = new JLabel("Cliente");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);

		textCliente = new JTextField(orcamentoPassado.getCliente().getNome());
		textCliente.setBackground(new Color(255, 255, 255));
		textCliente.setEditable(false);
		GridBagConstraints gbc_textCliente = new GridBagConstraints();
		gbc_textCliente.insets = new Insets(0, 0, 5, 0);
		gbc_textCliente.fill = GridBagConstraints.BOTH;
		gbc_textCliente.gridx = 1;
		gbc_textCliente.gridy = 1;
		panel_1.add(textCliente, gbc_textCliente);
		textCliente.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Nº");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);

		textID = new JTextField(String.valueOf(orcamentoPassado.getId()));
		textID.setBackground(new Color(255, 255, 255));
		textID.setEditable(false);
		GridBagConstraints gbc_textID = new GridBagConstraints();
		gbc_textID.fill = GridBagConstraints.VERTICAL;
		gbc_textID.anchor = GridBagConstraints.WEST;
		gbc_textID.insets = new Insets(0, 0, 5, 0);
		gbc_textID.gridx = 1;
		gbc_textID.gridy = 2;
		panel_1.add(textID, gbc_textID);
		textID.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Prestador");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);

		textPrestador = new JTextField();
		textPrestador.setBackground(new Color(255, 255, 255));
		textPrestador.setEditable(false);
		GridBagConstraints gbc_textPrestador = new GridBagConstraints();
		gbc_textPrestador.insets = new Insets(0, 0, 5, 0);
		gbc_textPrestador.fill = GridBagConstraints.HORIZONTAL;
		gbc_textPrestador.gridx = 1;
		gbc_textPrestador.gridy = 3;
		panel_1.add(textPrestador, gbc_textPrestador);
		textPrestador.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Serviço");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 4;
		panel_1.add(lblNewLabel_3, gbc_lblNewLabel_3);

		textServico = new JTextField();
		GridBagConstraints gbc_textServico = new GridBagConstraints();
		gbc_textServico.insets = new Insets(0, 0, 5, 0);
		gbc_textServico.fill = GridBagConstraints.HORIZONTAL;
		gbc_textServico.gridx = 1;
		gbc_textServico.gridy = 4;
		panel_1.add(textServico, gbc_textServico);
		textServico.setColumns(10);
		textServico.setEditable(false);

		JLabel lblNewLabel_6 = new JLabel("Valor Serviço");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 5;
		panel_1.add(lblNewLabel_6, gbc_lblNewLabel_6);

		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 5, 0);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 1;
		gbc_panel_4.gridy = 5;
		panel_1.add(panel_4, gbc_panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel_4.rowHeights = new int[] { 0, 0 };
		gbl_panel_4.columnWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		gbl_panel_4.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_4.setLayout(gbl_panel_4);

		textValorServico = new JTextField();
		GridBagConstraints gbc_textValorServiço = new GridBagConstraints();
		gbc_textValorServiço.insets = new Insets(0, 0, 0, 5);
		gbc_textValorServiço.fill = GridBagConstraints.BOTH;
		gbc_textValorServiço.gridx = 0;
		gbc_textValorServiço.gridy = 0;
		panel_4.add(textValorServico, gbc_textValorServiço);
		textValorServico.setColumns(10);

		JButton btnAttValorServico = new JButton("Atualizar Valor");
		btnAttValorServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (servicoCriado == null) {
					return;
				}
				try {
					valorServico = Double.parseDouble(textValorServico.getText());
					servicoCriado.setValorServico(valorServico);
				} catch (NumberFormatException e3) {
					JOptionPane.showMessageDialog(null, "Valor inválido! Insira um número em Valor Serviço.");
					return;
				}
			}
		});
		GridBagConstraints gbc_btnAttValorServico = new GridBagConstraints();
		gbc_btnAttValorServico.fill = GridBagConstraints.BOTH;
		gbc_btnAttValorServico.gridx = 1;
		gbc_btnAttValorServico.gridy = 0;
		panel_4.add(btnAttValorServico, gbc_btnAttValorServico);

		JLabel lblNewLabel_5 = new JLabel("Após adicionar o serviço adicione materiais se necessário  ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.ITALIC, 10));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_5.gridx = 1;
		gbc_lblNewLabel_5.gridy = 7;
		panel_1.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
				JButton btnAddMaterial = new JButton(
						"Adicionar Materiais");
				btnAddMaterial.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (servicoCriado == null) {
							JOptionPane.showMessageDialog(null,
									"<html>Primeiro clique em adicionar o servico ao Orçamento<br>Ai você poderá adicionar Materiais a esse Serviço<?html>");
							return;
						}
						addMaterialView view = new addMaterialView(orcamentoPassado, servicoCriado);
						view.setModal(true); // Usei Jdialog pra travar essa tela assim que a de material abrir
						view.setVisible(true);
					}
				});
				btnAddMaterial.setBackground(new Color(255, 255, 255));
				btnAddMaterial.setForeground(new Color(0, 0, 0));
				GridBagConstraints gbc_btnAddMaterial = new GridBagConstraints();
				gbc_btnAddMaterial.fill = GridBagConstraints.HORIZONTAL;
				gbc_btnAddMaterial.insets = new Insets(0, 0, 6, 0);
				gbc_btnAddMaterial.gridx = 1;
				gbc_btnAddMaterial.gridy = 8;
				btnAddMaterial.setMargin(new Insets(0, 0, 0, 0));
				panel_1.add(btnAddMaterial, gbc_btnAddMaterial);

		JLabel lblNewLabel_6_1 = new JLabel("Valor Total");
		GridBagConstraints gbc_lblNewLabel_6_1 = new GridBagConstraints();
		gbc_lblNewLabel_6_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_6_1.gridx = 0;
		gbc_lblNewLabel_6_1.gridy = 9;
		panel_1.add(lblNewLabel_6_1, gbc_lblNewLabel_6_1);

		JPanel panel_4_1 = new JPanel();
		GridBagConstraints gbc_panel_4_1 = new GridBagConstraints();
		gbc_panel_4_1.fill = GridBagConstraints.BOTH;
		gbc_panel_4_1.gridx = 1;
		gbc_panel_4_1.gridy = 9;
		panel_1.add(panel_4_1, gbc_panel_4_1);
		GridBagLayout gbl_panel_4_1 = new GridBagLayout();
		gbl_panel_4_1.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel_4_1.rowHeights = new int[] { 0, 0 };
		gbl_panel_4_1.columnWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		gbl_panel_4_1.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_4_1.setLayout(gbl_panel_4_1);

		textValotTotal = new JTextField();
		textValotTotal.setColumns(10);
		GridBagConstraints gbc_textValotTotal = new GridBagConstraints();
		gbc_textValotTotal.fill = GridBagConstraints.BOTH;
		gbc_textValotTotal.insets = new Insets(0, 0, 0, 5);
		gbc_textValotTotal.gridx = 0;
		gbc_textValotTotal.gridy = 0;
		panel_4_1.add(textValotTotal, gbc_textValotTotal);

		JButton btnAttValorTotal = new JButton("Atualizar Valor");
		btnAttValorTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Double valorTotal = servicoCriado.getValorTotal();
					textValotTotal.setText(String.format("R$ %.2f", valorTotal));
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, "Valor inválido! Insira um número em Valor Serviço.");
					return;
				}
			}
		});
		GridBagConstraints gbc_btnAttValorTotal = new GridBagConstraints();
		gbc_btnAttValorTotal.fill = GridBagConstraints.BOTH;
		gbc_btnAttValorTotal.gridx = 1;
		gbc_btnAttValorTotal.gridy = 0;
		panel_4_1.add(btnAttValorTotal, gbc_btnAttValorTotal);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.VERTICAL;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 0;
		panel_3.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		panel.add(scrollPane, gbc_scrollPane);

		JList<Prestador> listPrestador = new JList<Prestador>(listaPrestador);
		listarPrestador(listaPrestador);
		scrollPane.setViewportView(listPrestador);

		JButton btnAddServico = new JButton("Adicionar Serviço ao Orçamento");
		btnAddServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				criarServico();
			}
		});
		GridBagConstraints gbc_btnAddServico = new GridBagConstraints();
		gbc_btnAddServico.insets = new Insets(0, 0, 5, 0);
		gbc_btnAddServico.fill = GridBagConstraints.BOTH;
		gbc_btnAddServico.gridx = 1;
		gbc_btnAddServico.gridy = 6;
		panel_1.add(btnAddServico, gbc_btnAddServico);

		JButton btnAddPrestador = new JButton("<<< Inserir Prestador");
		btnAddPrestador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listPrestador.getSelectedValue() == null) {
					JOptionPane.showMessageDialog(null, "Selecione o Prestador na lista");
					return;
				}
				JOptionPane.showMessageDialog(null,
						"Agora insira o Serviço e o Valor e clique em adicionar ao orcamento");
				prestadorSelecionado = listPrestador.getSelectedValue();
				textPrestador.setText(prestadorSelecionado.getNome());
				btnAddPrestador.setText("<html>Adicionar outro Prestador e<br>Iniciar outro Serviço</html>");
				if (textServico.isEditable() == false) {
					textServico.setText("");
					textServico.setEditable(true);
				}
			}
		});
		GridBagConstraints gbc_btnAddPrestador = new GridBagConstraints();
		gbc_btnAddPrestador.insets = new Insets(0, 0, 5, 0);
		gbc_btnAddPrestador.gridx = 0;
		gbc_btnAddPrestador.gridy = 0;
		panel.add(btnAddPrestador, gbc_btnAddPrestador);

		JButton btnProsseguir = new JButton("Listar Detalhes Orçamento");
		btnProsseguir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				orcamentoDetalheView view = new orcamentoDetalheView(orcamentoPassado);
				view.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnProsseguir = new GridBagConstraints();
		gbc_btnProsseguir.gridx = 0;
		gbc_btnProsseguir.gridy = 1;
		panel_2.add(btnProsseguir, gbc_btnProsseguir);
	}

	public void listarPrestador(DefaultListModel<Prestador> modelPrestador) {
		ArrayList<Prestador> prestadores = sistema.getPrestadores();
		try {
			modelPrestador.clear();
			for (Prestador prestador : prestadores) {
				modelPrestador.addElement(prestador);
			}
		} catch (Exception e) {
			System.out.println("listaPrestadorView.listaPrestador " + e);
			JOptionPane.showMessageDialog(null, "listaPrestadorView.listaPrestador " + e);
		}
	}

	public void listaMateriais(ArrayList<Materiais> materiaisCopia, JTextArea textArea) {
	    StringBuilder lista = new StringBuilder();
	    try {
	        if (materiaisCopia == null || materiaisCopia.isEmpty()) {
	            textArea.setText("Nenhum material encontrado.");
	            return;
	        }

	        for (Materiais material : materiaisCopia) {
	            lista.append(String.format(
	                "Nome: %s -- Qtde: %d -- Valor: %.2f -- Total: R$ %.2f\n",
	                material.getNome(), material.getQuantidade(), material.getValor(), material.getValorTotal()
	            ));
	        }

	        textArea.setText(lista.toString());
	    } catch (Exception e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Erro ao listar materiais: " + e.getMessage());
	    }
	}



	public void criarServico() {
		if (prestadorSelecionado == null) {
			JOptionPane.showMessageDialog(null, "Selecione e insira o Prestador!");
			return;
		}
		if (textServico.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o campo de Servico!");
			return;
		}
		try {
			valorServico = Double.parseDouble(textValorServico.getText());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Valor inválido! Insira um número em Valor Serviço.");
			return;
		}
		servicoCriado = sistema.addServicoOrcamento(orcamentoPassado.getId(), prestadorSelecionado, valorServico,
				textServico.getText());
		if (servicoCriado.getValorMateriais() == null) {
			textValotTotal.setText(String.format("R$ %.2f", servicoCriado.getValorServico()));
			return;
		}
		textValotTotal
				.setText(String.format("R% %.2f", servicoCriado.getValorServico() + servicoCriado.getValorMateriais()));
	}

}
