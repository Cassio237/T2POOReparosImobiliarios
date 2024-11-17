package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ufu.Orcamento;
import ufu.Sistema;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class listaOrcamentoView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private static Sistema sistema = new Sistema();
	protected Orcamento orcamentoSelecionado;
	private DefaultListModel<Orcamento> listaOrcamento = new DefaultListModel<Orcamento>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					listaOrcamentoView frame = new listaOrcamentoView();
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
	public listaOrcamentoView() {
		sistema.iniciaDados();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Lista de Orçamentos");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		contentPane.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel_1.add(scrollPane, gbc_scrollPane);
		
		JList<Orcamento> listOrcamento = new JList<Orcamento>(listaOrcamento);
		listarOrcamento(listaOrcamento);
		scrollPane.setViewportView(listOrcamento);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 2;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 1, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnAttOrcamento = new JButton("Modificar Orçamento");
		btnAttOrcamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				orcamentoSelecionado = listOrcamento.getSelectedValue();
				addServicoView view = new addServicoView(orcamentoSelecionado);
				view.setVisible(true);
				dispose();
			}
		});
		GridBagConstraints gbc_btnAttOrcamento = new GridBagConstraints();
		gbc_btnAttOrcamento.insets = new Insets(0, 0, 0, 5);
		gbc_btnAttOrcamento.gridx = 0;
		gbc_btnAttOrcamento.gridy = 0;
		panel.add(btnAttOrcamento, gbc_btnAttOrcamento);
		
		JButton btnFinalizarOrcamento = new JButton("Finalizar Orçamento");
		btnFinalizarOrcamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				orcamentoSelecionado = listOrcamento.getSelectedValue();
				if (orcamentoSelecionado.isAprovado()) {
					JOptionPane.showMessageDialog(null, "Orcamento já aprovado");
					listOrcamento.repaint();
					return;
				}
				sistema.aprovarOrcamento(orcamentoSelecionado, true);
				listOrcamento.repaint();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 0;
		panel.add(btnFinalizarOrcamento, gbc_btnNewButton);
	}
	
	public void listarOrcamento(DefaultListModel<Orcamento> modelOrcamento) {
	    ArrayList<Orcamento> orcamentosLidos = sistema.getOrcamentos();
	    try {
	        modelOrcamento.clear();
	        for (Orcamento orcamento : orcamentosLidos) {
	        	modelOrcamento.addElement(orcamento);
	        }
	    } catch (Exception e) {
	        System.out.println("listaOrcamentoView.listaOrcamento " + e); 
	        JOptionPane.showMessageDialog(null, "listaOrcamentoView.listaOrcamento " + e);
	    }
	}

}
