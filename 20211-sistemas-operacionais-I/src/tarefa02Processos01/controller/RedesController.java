package tarefa02Processos01.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class RedesController {
	
	private Process processo;
	private InputStream fluxo;
	private InputStreamReader leitor;
	private BufferedReader buffer;

	public RedesController() {
		super();
	}

	public String getOS() {
		String os = System.getProperty("os.name");
		return os;
	}

	public String getIP(String sistemaOperacional) {

		String resultado = "";

		if (sistemaOperacional.contains("Windows")) {
			try {
				processo = Runtime.getRuntime().exec("ipconfig");
				fluxo = processo.getInputStream();
				leitor = new InputStreamReader(fluxo);
				buffer = new BufferedReader(leitor);

				String linha = buffer.readLine();

				while (linha != null) {
					if (linha.contains("Ethernet:") || linha.contains("VirtualBox") || linha.contains("Windows")) {
						resultado = resultado + linha + "\n";
					}
					if (linha.contains("IPv4")) {
						resultado = resultado + linha + "\n";
					}

					linha = buffer.readLine();
				}
				
				fluxo.close();
				leitor.close();
				buffer.close();
				
				return resultado;

			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Erro ao obter configura��es de IP", "Error",JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
			return null;
		} else if (sistemaOperacional.contains("Linux")) {
			try {
				processo = Runtime.getRuntime().exec("ifconfig");
				fluxo = processo.getInputStream();
				leitor = new InputStreamReader(fluxo);
				buffer = new BufferedReader(leitor);
				
				String linha = buffer.readLine();

				while (linha != null) {
					if (linha.contains("flags")) {
						resultado = resultado + linha + "\n";
					}
					if (linha.contains("netmask")) {
						resultado = resultado + linha + "\n";
					}
					linha = buffer.readLine();
				}
				
				fluxo.close();
				leitor.close();
				buffer.close();
				
				return resultado;

			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Erro ao obter configura��es de IP", "Error",JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
			return null;
		} else {
			JOptionPane.showMessageDialog(null,  "Configura��es de sistema n�o encontradas", "Error",JOptionPane.ERROR_MESSAGE);
		}
		return null;
		
	}

	public String getPing(String sistemaOperacional) {
		
		double media = 0f;
		double soma = 0;

		if (sistemaOperacional.contains("Windows")) {
			try {
				processo = Runtime.getRuntime().exec("ping -n 10 www.google.com.br");
				fluxo = processo.getInputStream();
				leitor = new InputStreamReader(fluxo);
				buffer = new BufferedReader(leitor);

				String linha = buffer.readLine();
				
				JOptionPane.showMessageDialog(null, "Processamento das informa��es...", "Info", JOptionPane.INFORMATION_MESSAGE);

				JOptionPane.showMessageDialog(null, "Realizando itera��es do ping para www.google.com.br", "Info", JOptionPane.INFORMATION_MESSAGE);

				JOptionPane.showMessageDialog(null, "Isso pode levar algum tempo... aguarde!", "Warning", JOptionPane.WARNING_MESSAGE);
				
				while (linha != null) {
					if (linha.contains("tempo")) {
						int inicioSub = linha.indexOf("o="); 
						int finalSub = linha.indexOf("ms"); 

						soma = soma + Double.parseDouble(linha.substring(inicioSub + 2, finalSub));
					}

					linha = buffer.readLine();
				}
				
				media = soma / 10;
				
				fluxo.close();
				leitor.close();
				buffer.close();
				
				return String.format("O Tempo m�dio das itera��es solicitadas do endere�o para ping www.google.com.br foi de:  %.2fms%n", media);

			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Erro de conectividade ao endere�o solicitado", "Error",JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
			return null;
		} else if (sistemaOperacional.contains("Linux")) {
			try {
				processo = Runtime.getRuntime().exec("ping -c 10 www.google.com.br");
				fluxo = processo.getInputStream();
				leitor = new InputStreamReader(fluxo);
				buffer = new BufferedReader(leitor);
				
				String linha = buffer.readLine();
				
				JOptionPane.showMessageDialog(null, "Processamento das informa��es...", "Info", JOptionPane.INFORMATION_MESSAGE);

				JOptionPane.showMessageDialog(null, "Realizando itera��es do ping para www.google.com.br", "Info", JOptionPane.INFORMATION_MESSAGE);

				JOptionPane.showMessageDialog(null, "Isso pode levar algum tempo aguarde!", "Warning", JOptionPane.WARNING_MESSAGE);

				
				while (linha != null) {
					if (linha.contains("seq")) {
						int inicioSub = linha.indexOf("o="); 
						int finalSub = linha.indexOf(" ms"); 

						soma = soma + Double.parseDouble(linha.substring(inicioSub + 2, finalSub));
					}

					linha = buffer.readLine();
				}
				
				media = soma / 10;
				
				fluxo.close();
				leitor.close();
				buffer.close();
				
				return String.format("O Tempo m�dio das itera��es solicitadas do endere�o para ping www.google.com.br foi de:  %.2fms%n", media);
				
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Erro de conectividade ao endere�o solicitado", "Error",JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
			return null;
		} else {
			JOptionPane.showMessageDialog(null, "Configura��es de sistema n�o encontradas", "Error",JOptionPane.ERROR_MESSAGE);
		}
		return null;

	}
}
