package aula1.view;

import aula1.controller.OperacoesController;

public class Principal {

	public static void main(String[] args) {
		
		OperacoesController op = new OperacoesController();
		op.concatenaString();
		op.concatenaBuffer();
		
		String frase = "Ol� turma do terceiro semestre de ADS da Fatec ZL";
		op.divideFrase(frase);
	}

}