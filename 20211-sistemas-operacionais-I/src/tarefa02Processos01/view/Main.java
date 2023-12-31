package tarefa02Processos01.view;

import javax.swing.JOptionPane;
import tarefa02Processos01.controller.RedesController;

public class Main {

	public static void main(String[] args) {
		
		RedesController redesController = new RedesController();

		int opc = 0;
		
		do {
			opc = Integer.parseInt(JOptionPane.showInputDialog("Digite o n�mero de uma das op��es\n "
					+ "1- Adaptador Ethernet e o IPv4\n "
					+ "2- Ping\n "
					+ "9- Finalizar Programa!", JOptionPane.QUESTION_MESSAGE));

			switch (opc) {
			case 1:
				JOptionPane.showMessageDialog(null, redesController.getIP(redesController.getOS()), "Sucess", JOptionPane.INFORMATION_MESSAGE);
				break;
			case 2:
				JOptionPane.showMessageDialog(null, redesController.getPing(redesController.getOS()), "Sucess", JOptionPane.INFORMATION_MESSAGE);
				break;
			case 9:
				JOptionPane.showMessageDialog(null, "O programa foi finalizado!", "Sucess", JOptionPane.INFORMATION_MESSAGE);
				break;
			default:
				JOptionPane.showMessageDialog(null, "Op��o inv�lida!", "Error", JOptionPane.ERROR_MESSAGE);
				break;
			}

		} while (opc != 9);
	}
}