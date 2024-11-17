package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ufu.Sistema;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class addClienteView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textEndereco;
	private JTextField textTelefone;
	private JTextField textDado;
	private JButton btnCadastrar;
	private JPanel panel;
	private JRadioButton rdCPF;
	private JRadioButton rdCNPJ;
	private JLabel lblNewLabel_4;

	private static Sistema sistema = new Sistema();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addClienteView frame = new addClienteView();
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
	public addClienteView() {
		sistema.iniciaDados();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 85, 302, 0 };
		gbl_contentPane.rowHeights = new int[] { 52, 37, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		lblNewLabel_4 = new JLabel("Cadastrar Cliente");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 0;
		contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);

		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.SOUTH;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 1;
		contentPane.add(panel, gbc_panel);

		JLabel lblDado = new JLabel("CPF");

		rdCPF = new JRadioButton("Pessoa Fisica");
		rdCPF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblDado.setText("CPF");
				rdCNPJ.setSelected(false);
			}
		});
		panel.add(rdCPF);

		rdCNPJ = new JRadioButton("Pessoa Juridica");
		rdCNPJ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblDado.setText("CNPJ");
				rdCPF.setSelected(false);
			}
		});
		panel.add(rdCNPJ);

		JLabel lblNewLabel = new JLabel("Nome");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);

		textNome = new JTextField();
		GridBagConstraints gbc_textNome = new GridBagConstraints();
		gbc_textNome.ipady = 5;
		gbc_textNome.insets = new Insets(0, 0, 5, 0);
		gbc_textNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNome.gridx = 1;
		gbc_textNome.gridy = 2;
		contentPane.add(textNome, gbc_textNome);
		textNome.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Endereço");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 3;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);

		textEndereco = new JTextField();
		GridBagConstraints gbc_textEndereco = new GridBagConstraints();
		gbc_textEndereco.ipady = 5;
		gbc_textEndereco.insets = new Insets(0, 0, 5, 0);
		gbc_textEndereco.fill = GridBagConstraints.HORIZONTAL;
		gbc_textEndereco.gridx = 1;
		gbc_textEndereco.gridy = 3;
		contentPane.add(textEndereco, gbc_textEndereco);
		textEndereco.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Telefone");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 4;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);

		textTelefone = new JTextField();
		GridBagConstraints gbc_textTelefone = new GridBagConstraints();
		gbc_textTelefone.ipadx = 40;
		gbc_textTelefone.ipady = 5;
		gbc_textTelefone.anchor = GridBagConstraints.WEST;
		gbc_textTelefone.insets = new Insets(0, 0, 5, 0);
		gbc_textTelefone.gridx = 1;
		gbc_textTelefone.gridy = 4;
		contentPane.add(textTelefone, gbc_textTelefone);
		textTelefone.setColumns(10);

		GridBagConstraints gbc_lblDado = new GridBagConstraints();
		gbc_lblDado.anchor = GridBagConstraints.EAST;
		gbc_lblDado.insets = new Insets(0, 0, 5, 5);
		gbc_lblDado.gridx = 0;
		gbc_lblDado.gridy = 5;
		contentPane.add(lblDado, gbc_lblDado);

		textDado = new JTextField();
		GridBagConstraints gbc_textDado = new GridBagConstraints();
		gbc_textDado.insets = new Insets(0, 0, 5, 0);
		gbc_textDado.ipadx = 40;
		gbc_textDado.ipady = 5;
		gbc_textDado.anchor = GridBagConstraints.WEST;
		gbc_textDado.gridx = 1;
		gbc_textDado.gridy = 5;
		contentPane.add(textDado, gbc_textDado);
		textDado.setColumns(10);

		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textNome.getText().isEmpty() || textDado.getText().isEmpty() || textEndereco.getText().isEmpty()
						|| textTelefone.getText().isEmpty()) { //Verificar se esta vazio os campos para evitar o null
					JOptionPane.showMessageDialog(null, "Preencha todos campos!");
					return;
				}
				if (rdCPF.isSelected()) {
					sistema.criarClienteFisica(textNome.getText(), textEndereco.getText(), textTelefone.getText(),
							textDado.getText());
					limparCampos();
					
				} else if (rdCNPJ.isSelected()) {
					sistema.criarClienteJuridica(textNome.getText(), textEndereco.getText(), textTelefone.getText(),
							textDado.getText());
					limparCampos();
				} else {
					JOptionPane.showMessageDialog(null, "Selecione se é Pessoa Fisíca ou Jurídica");
				}
			}
		});
		GridBagConstraints gbc_btnCadastrar = new GridBagConstraints();
		gbc_btnCadastrar.gridx = 1;
		gbc_btnCadastrar.gridy = 6;
		contentPane.add(btnCadastrar, gbc_btnCadastrar);
	}
	
	public void limparCampos() {
	    textNome.setText("");
	    textDado.setText("");
	    textEndereco.setText("");
	    textTelefone.setText("");
	    rdCPF.setSelected(false);
	    rdCNPJ.setSelected(false);
	}

}
