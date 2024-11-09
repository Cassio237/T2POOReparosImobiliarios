package view;

import ufu.Sistema;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView();
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
	public MainView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(25, 50, 50, 50));
		
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Função");
		menuBar.add(menu);
		
		JMenuItem mntmNewMenuItem1 = new JMenuItem("Principal");
		menu.add(mntmNewMenuItem1);
		
		JMenuItem mntmNewMenuItem2 = new JMenuItem("Finanças");
		menu.add(mntmNewMenuItem2);
		
		setJMenuBar(menuBar);

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 15, 15));
		
		JButton btnAddCliente = new JButton("Adicionar Clientes");
		contentPane.add(btnAddCliente);
		
		JButton btnListCliente = new JButton("Listar Clientes");
		contentPane.add(btnListCliente);
		
		JButton btnAddImovel = new JButton("Adicionar Imovel");
		contentPane.add(btnAddImovel);
		
		JButton btnLstImovel = new JButton("Listar Imoveis");
		contentPane.add(btnLstImovel);
		
		JButton btnAddPrestador = new JButton("Adicionar Prestador");
		contentPane.add(btnAddPrestador);
		
		JButton btnLstPrestador = new JButton("Listar Prestadores");
		contentPane.add(btnLstPrestador);
		
		JButton btnCriarOrcamento = new JButton("Criar Orçamento");
		contentPane.add(btnCriarOrcamento);
		
		JButton btnLstOrcamento = new JButton("Listar Orçamentos");
		contentPane.add(btnLstOrcamento);
		
	}

}
