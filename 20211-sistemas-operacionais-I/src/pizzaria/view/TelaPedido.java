package pizzaria.view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import pizzaria.controller.PedidoController;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Color;

public class TelaPedido extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfPreco;
	private JComboBox<String> comboBox;
	private JTextArea taModificacoes;
	private JRadioButton rdbtnPequena, rdbtnMedia, rdbtnGrande;
	private JCheckBox chckbxBordaRecheada;
	private JButton btnEmitir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPedido frame = new TelaPedido();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPedido() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 402);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPizzas = new JLabel("Pizzas");
		lblPizzas.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 11));
		lblPizzas.setBounds(10, 11, 46, 14);
		contentPane.add(lblPizzas);
		
		comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 11));
		comboBox.setBounds(66, 7, 358, 22);
		contentPane.add(comboBox);
		
		comboBox.addItem("Mu�arela");
		comboBox.addItem("Calabresa");
		comboBox.addItem("Napolitana");
		comboBox.addItem("Marguerita");
		comboBox.addItem("Portuguesa");
		comboBox.addItem("Atum");
		comboBox.addItem("Frango c/ Catupiry");
		comboBox.addItem("Chocolate");
		comboBox.addItem("Beijinho");
		
		JLabel lblModificacoes = new JLabel("Modifica\u00E7\u00F5es");
		lblModificacoes.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 11));
		lblModificacoes.setBounds(10, 52, 96, 14);
		contentPane.add(lblModificacoes);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 70, 414, 89);
		contentPane.add(scrollPane);
		
		taModificacoes = new JTextArea();
		taModificacoes.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 9));
		scrollPane.setViewportView(taModificacoes);
		
		JLabel lblPreco = new JLabel("Pre\u00E7o");
		lblPreco.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 11));
		lblPreco.setBounds(10, 178, 46, 14);
		contentPane.add(lblPreco);
		
		tfPreco = new JTextField();
		tfPreco.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 11));
		tfPreco.setBounds(66, 175, 86, 20);
		contentPane.add(tfPreco);
		tfPreco.setColumns(10);
		
		rdbtnPequena = new JRadioButton("Pequena");
		rdbtnPequena.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 11));
		rdbtnPequena.setBounds(10, 212, 109, 23);
		contentPane.add(rdbtnPequena);
		
		rdbtnMedia = new JRadioButton("M\u00E9dia");
		rdbtnMedia.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 11));
		rdbtnMedia.setBounds(10, 238, 109, 23);
		contentPane.add(rdbtnMedia);
		
		rdbtnGrande = new JRadioButton("Grande");
		rdbtnGrande.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 11));
		rdbtnGrande.setBounds(10, 264, 109, 23);
		contentPane.add(rdbtnGrande);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnPequena);
		bg.add(rdbtnMedia);
		bg.add(rdbtnGrande);
		rdbtnGrande.setSelected(true);
		
		chckbxBordaRecheada = new JCheckBox("Borda Recheada");
		chckbxBordaRecheada.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 11));
		chckbxBordaRecheada.setBounds(10, 299, 142, 23);
		contentPane.add(chckbxBordaRecheada);
		
		btnEmitir = new JButton("Emitir Pedido");
		btnEmitir.setBackground(new Color(60, 179, 113));
		btnEmitir.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 11));
		btnEmitir.setBounds(282, 331, 142, 23);
		contentPane.add(btnEmitir);
		
		PedidoController pedidoController = new PedidoController(tfPreco, comboBox, taModificacoes, rdbtnPequena, rdbtnMedia, rdbtnGrande, chckbxBordaRecheada); 
		
		btnEmitir.addActionListener(pedidoController);
	}
}
