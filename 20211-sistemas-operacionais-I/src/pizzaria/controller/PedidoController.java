package pizzaria.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import pizzaria.model.Pizza;

public class PedidoController implements ActionListener {

	private JTextField tfPreco;
	private JComboBox<String> comboBox;
	private JTextArea taModificacoes;
	private JRadioButton rdbtnPequena, rdbtnMedia, rdbtnGrande;
	private JCheckBox chckbxBordaRecheada;

	public PedidoController(JTextField tfPreco, JComboBox<String> comboBox, JTextArea taModificacoes,
			JRadioButton rdbtnPequena, JRadioButton rdbtnMedia, JRadioButton rdbtnGrande,
			JCheckBox chckbxBordaRecheada) {

		this.tfPreco = tfPreco;
		this.comboBox = comboBox;
		this.taModificacoes = taModificacoes;
		this.rdbtnPequena = rdbtnPequena;
		this.rdbtnMedia = rdbtnMedia;
		this.rdbtnGrande = rdbtnGrande;
		this.chckbxBordaRecheada = chckbxBordaRecheada;
	}

	public boolean validaTela() {
		boolean valida = true;
		if (tfPreco.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Preencha o valor", "ERRO", JOptionPane.ERROR_MESSAGE);
			valida = false;
		}
		return valida;
	}

	public void recebePedido() {
		Pizza pizza = new Pizza();
		pizza.setBordaRecheada(chckbxBordaRecheada.isSelected());
		pizza.setModificacoes(taModificacoes.getText());
		pizza.setNome(comboBox.getSelectedItem().toString());
		try {
			pizza.setPreco(Double.parseDouble(tfPreco.getText()));
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Pre�o deve ser n�merico com duas casas decimais", "ERRO",
					JOptionPane.ERROR_MESSAGE);
		}
		String tipo = "";
		if (rdbtnPequena.isSelected()) {
			tipo = rdbtnPequena.getText();
		} else {
			if (rdbtnMedia.isSelected()) {
				tipo = rdbtnMedia.getText();
			} else {
				tipo = rdbtnGrande.getText();
			}
		}
		pizza.setTipo(tipo);

		StringBuffer sb = new StringBuffer();
		sb.append(pizza.getNome());
		sb.append(" - ");
		sb.append(pizza.getTipo());
		sb.append("\n");
		sb.append(pizza.getModificacoes());
		sb.append("\n");
		if (pizza.isBordaRecheada()) {
			sb.append("Com Borda Recheada");
			sb.append("\n");
		}
		sb.append("Valor : R$");
		sb.append(pizza.getPreco());
		JOptionPane.showMessageDialog(null, sb.toString(), "Pedido", JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		boolean valido = validaTela();
		if (valido) {
			recebePedido();
		}
	}

}
