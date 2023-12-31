package tarefa02Processos03.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import tarefa02Processos03.view.TelaExecutar;

public class BotaoOK implements ActionListener {

	private JTextField tfCaminho;
	private TelaExecutar telaExecutar;

	public BotaoOK(JTextField tfCaminho, TelaExecutar telaExecutar) {
		this.tfCaminho = tfCaminho;
		this.telaExecutar = telaExecutar;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		callProcess(tfCaminho.getText());
	}
	
	public void callProcess(String process) {
		try {
			Runtime.getRuntime().exec(process);
			telaExecutar.dispose();
		} catch (Exception e) {
			String msgErro = e.getMessage();
			if (msgErro.contains("740")) {
				StringBuffer buffer = new StringBuffer();
				buffer.append("cmd /c");
				buffer.append(" ");
				buffer.append(process);			
				try {
					Runtime.getRuntime().exec(buffer.toString());
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "O Windows n�o pode encontrar '" + process + "'. Certifique-se de que o nome foi digitado corretamente e tente novamente.", process, JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
		} else 
			System.err.println(msgErro);
		}
	}

}
