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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private static Sistema sistema = new Sistema();
	
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
		sistema.iniciaDados();
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
		btnAddCliente.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        addClienteView view = new addClienteView();
		        view.setVisible(true);
		    }
		});
		contentPane.add(btnAddCliente);
		
		JButton btnListCliente = new JButton("Listar Clientes");
		btnListCliente.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        listaClientesView view = new listaClientesView();
		        view.setVisible(true);
		    }
		});
		contentPane.add(btnListCliente);
		
		JButton btnAddImovel = new JButton("Adicionar Imovel");
		contentPane.add(btnAddImovel);
		
		JButton btnListImovel = new JButton("Listar Imoveis");
		btnListImovel.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        listaImoveisView view = new listaImoveisView();
		        view.setVisible(true);
		    }
		});
		contentPane.add(btnListImovel);
		
		JButton btnAddPrestador = new JButton("Adicionar Prestador");
		btnAddPrestador.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        addPrestadorView view = new addPrestadorView();
		        view.setVisible(true);
		    }
		});
		contentPane.add(btnAddPrestador);
		
		JButton btnListPrestador = new JButton("Listar Prestadores");
		btnListPrestador.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        listaPrestadoresView view = new listaPrestadoresView();
		        view.setVisible(true);
		    }
		});
		contentPane.add(btnListPrestador);
		
		
		JButton btnCriarOrcamento = new JButton("Criar Orçamento");
		contentPane.add(btnCriarOrcamento);
		
		JButton btnLstOrcamento = new JButton("Listar Orçamentos");
		contentPane.add(btnLstOrcamento);
		
	}

}
