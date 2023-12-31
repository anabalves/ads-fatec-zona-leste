package aula3.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ProcessosController {

	public ProcessosController() {
		super();
	}

	// Retorne o S.O que est� em execu��o na m�quina
	public String getOS() {
		String os = System.getProperty("os.name");
		String arch = System.getProperty("os.arch");
		String version = System.getProperty("os.version");
		String language = System.getProperty("user.language");
		return os + " - v. " + version + " - arch. " + arch + " - idioma: " + language;
	}
	
	public void callProcess(String process) {
		try {
			Runtime.getRuntime().exec(process);
			//todas as linhas que eu quero que receba tratamento
		} catch (Exception e) {
			String msgErro = e.getMessage();
			//linhas de tratamento do erro
			if (msgErro.contains("740")) {
				StringBuffer buffer = new StringBuffer();
				buffer.append("cmd /c");
				buffer.append(" ");
				buffer.append(process);			
				try {
					Runtime.getRuntime().exec(buffer.toString());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
		} else 
			System.err.println(msgErro);
		}
	}
	
	public void readProcess(String process) {
		try {
			Process proc = Runtime.getRuntime().exec(process);
			InputStream fluxo = proc.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			
			String linha = buffer.readLine();
			
			while (linha != null) {
				System.out.println(linha);
				linha = buffer.readLine();			
			}
			
			buffer.close();
			leitor.close();
			fluxo.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void killProcess(String param) {
		String cmdPID = "TASKKILL /PID";
		String cmdNome = "TASKKILL /IM";
		int pid = 0;
		StringBuffer buffer = new StringBuffer();
		
		//NumberFormatException -> Exception
		try {
			//TASKKILL /PID XXXX
			pid = Integer.parseInt(param);
			buffer.append(cmdPID);
			buffer.append(" ");
			buffer.append(pid);
		} catch (Exception e) {
			//TASKKILL /IM nomedoprocesso.exe
			buffer.append(cmdNome);
			buffer.append(" ");
			buffer.append(param);
		}
		
		callProcess(buffer.toString());
	}
}
