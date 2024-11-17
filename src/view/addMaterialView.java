package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ufu.Materiais;
import ufu.Orcamento;
import ufu.Servico;
import ufu.Sistema;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class addMaterialView extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNomeMaterial;
	private JTextField textQuantidade;
	private JTextField textValorUnitario;
	private JTextField textValorTotal;

	protected Servico servico;
	protected Orcamento orcamento;
	private static Sistema sistema = new Sistema();
	ArrayList<Materiais> MateriaisCopia;
	
	protected Double valorMaterial = 0.0;
	int quantidade = 0;
	
	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { addMaterialView frame = new
	 * addMaterialView(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the frame.
	 */
	public addMaterialView(Orcamento orcamentoPassado, Servico servicoPassado) {
		sistema.iniciaDados();
		orcamento = orcamentoPassado;
		servico = servicoPassado;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 400, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 20, 20, 21, 30, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel lblNewLabel_3 = new JLabel("Adicionar Material     ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 0;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);

		JLabel lblNewLabel = new JLabel("Nome");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);

		textNomeMaterial = new JTextField();
		GridBagConstraints gbc_textNomeMaterial = new GridBagConstraints();
		gbc_textNomeMaterial.insets = new Insets(0, 0, 5, 0);
		gbc_textNomeMaterial.fill = GridBagConstraints.BOTH;
		gbc_textNomeMaterial.gridx = 1;
		gbc_textNomeMaterial.gridy = 1;
		contentPane.add(textNomeMaterial, gbc_textNomeMaterial);
		textNomeMaterial.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Valor unitario");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 2;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 146, 54, 22, 0 };
		gbl_panel.rowHeights = new int[] { 25, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		textValorUnitario = new JTextField();
		GridBagConstraints gbc_textValorUnitario = new GridBagConstraints();
		gbc_textValorUnitario.insets = new Insets(0, 0, 0, 5);
		gbc_textValorUnitario.fill = GridBagConstraints.HORIZONTAL;
		gbc_textValorUnitario.gridx = 0;
		gbc_textValorUnitario.gridy = 0;
		panel.add(textValorUnitario, gbc_textValorUnitario);
		textValorUnitario.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Quantidade");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 0;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		textQuantidade = new JTextField();
		GridBagConstraints gbc_textQuantidade = new GridBagConstraints();
		gbc_textQuantidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_textQuantidade.gridx = 2;
		gbc_textQuantidade.gridy = 0;
		panel.add(textQuantidade, gbc_textQuantidade);
		textQuantidade.setColumns(5);

		JLabel lblNewLabel_4 = new JLabel("Valor Total");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 3;
		contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);

		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 3;
		contentPane.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		textValorTotal = new JTextField();
		textValorTotal.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_textValorTotal = new GridBagConstraints();
		gbc_textValorTotal.insets = new Insets(0, 0, 0, 5);
		gbc_textValorTotal.fill = GridBagConstraints.BOTH;
		gbc_textValorTotal.gridx = 0;
		gbc_textValorTotal.gridy = 0;
		panel_1.add(textValorTotal, gbc_textValorTotal);
		textValorTotal.setColumns(10);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcular();
			}
		});
		GridBagConstraints gbc_btnCalcular = new GridBagConstraints();
		gbc_btnCalcular.anchor = GridBagConstraints.WEST;
		gbc_btnCalcular.gridx = 1;
		gbc_btnCalcular.gridy = 0;
		panel_1.add(btnCalcular, gbc_btnCalcular);

		JButton btnAddServico = new JButton("Adicionar Material");
		btnAddServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addMateriais(orcamentoPassado.getId(), servicoPassado.getTipo());
			}
		});
		GridBagConstraints gbc_btnAddServico = new GridBagConstraints();
		gbc_btnAddServico.fill = GridBagConstraints.VERTICAL;
		gbc_btnAddServico.gridx = 1;
		gbc_btnAddServico.gridy = 4;
		contentPane.add(btnAddServico, gbc_btnAddServico);
	}

	public void addMateriais(int orcamentoID, String servico) {
		try {
			valorMaterial = Double.parseDouble(textValorUnitario.getText());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Valor inválido! Insira um número em Valor do Material.");
			return;
		}
		try {
			quantidade = Integer.parseInt(textQuantidade.getText());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Valor inválido! Insira um número em Quantidade.");
			return;
		}
		textValorTotal.setText(String.format("R$ %.2f", valorMaterial * quantidade));
		sistema.addItensOrcamento(orcamentoID, servico, textNomeMaterial.getText(), quantidade, valorMaterial);
		textValorUnitario.setText("");
		textNomeMaterial.setText("");
		textQuantidade.setText("");
		textValorTotal.setText("");
	}
	
	public void calcular() {
		try {
			valorMaterial = Double.parseDouble(textValorUnitario.getText());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Valor inválido! Insira um número em Valor do Material.");
			return;
		}
		try {
			quantidade = Integer.parseInt(textQuantidade.getText());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Valor inválido! Insira um número em Quantidade.");
			return;
		}
		textValorTotal.setText(String.format("R$ %.2f", valorMaterial * quantidade));
	}
	
	public ArrayList<Materiais> passaArray(){
		return MateriaisCopia;
	}

}
