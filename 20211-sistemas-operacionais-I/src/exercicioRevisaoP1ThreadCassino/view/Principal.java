package exercicioRevisaoP1ThreadCassino.view;

import exercicioRevisaoP1ThreadCassino.controller.ThreadCassino;

public class Principal {

	public static void main(String[] args) {

		for (int idCompetidor = 1; idCompetidor <= 10; idCompetidor++) {
			ThreadCassino threadCassino = new ThreadCassino(idCompetidor);
			threadCassino.start();
		}

	}

}
