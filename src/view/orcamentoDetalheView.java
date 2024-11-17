package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ufu.Orcamento;
import ufu.Sistema;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class orcamentoDetalheView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	protected Orcamento orcamentoPassado;
	private static Sistema sistema = new Sistema();

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { orcamentoDetalheView frame = new
	 * orcamentoDetalheView(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */
	/**
	 * Create the frame.
	 */
	public orcamentoDetalheView(Orcamento orcamento) {
		sistema.iniciaDados();
	    orcamentoPassado = orcamento;
	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    setBounds(100, 100, 600, 650);
	    contentPane = new JPanel();
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	    setContentPane(contentPane);
	    GridBagLayout gbl_contentPane = new GridBagLayout();
	    gbl_contentPane.columnWidths = new int[]{0, 0};
	    gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0};
	    gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
	    gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
	    contentPane.setLayout(gbl_contentPane);

	    JLabel lblNewLabel = new JLabel("Orçamento Detalhado");
	    lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
	    GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
	    gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
	    gbc_lblNewLabel.gridx = 0;
	    gbc_lblNewLabel.gridy = 0;
	    contentPane.add(lblNewLabel, gbc_lblNewLabel);

	    JScrollPane scrollPane = new JScrollPane();
	    GridBagConstraints gbc_scrollPane = new GridBagConstraints();
	    gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
	    gbc_scrollPane.fill = GridBagConstraints.BOTH;
	    gbc_scrollPane.gridx = 0;
	    gbc_scrollPane.gridy = 1;
	    contentPane.add(scrollPane, gbc_scrollPane);

	    JTextArea textOrcamento = new JTextArea();
	    textOrcamento.setFont(new Font("Tahoma", Font.BOLD, 12));
	    textOrcamento.setLineWrap(true);
	    textOrcamento.setEditable(false);
	    textOrcamento.setWrapStyleWord(true);
	    scrollPane.setViewportView(textOrcamento);
	    
	    String detalhes = listaOrcamento(orcamentoPassado);
	    if (detalhes != null && !detalhes.isEmpty()) {
	        textOrcamento.setText(detalhes);
	    } else {
	        textOrcamento.setText("Nenhum detalhe encontrado para este orçamento.");
	    }

	    JPanel panel = new JPanel();
	    GridBagConstraints gbc_panel = new GridBagConstraints();
	    gbc_panel.fill = GridBagConstraints.BOTH;
	    gbc_panel.gridx = 0;
	    gbc_panel.gridy = 2;
	    contentPane.add(panel, gbc_panel);
	    GridBagLayout gbl_panel = new GridBagLayout();
	    gbl_panel.columnWidths = new int[]{0, 0, 0};
	    gbl_panel.rowHeights = new int[]{0, 0};
	    gbl_panel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
	    gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
	    panel.setLayout(gbl_panel);
	}

	public String listaOrcamento(Orcamento orcamento) {
	    return sistema.listaOrcamentoDetalhado(orcamento);
	}


}
