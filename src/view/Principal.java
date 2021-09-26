package view;

import javax.swing.JOptionPane;

import com.rafael.utils.filas.string.*;

import controller.Impressora;

public class Principal {

	public static void main(String[] args) {
		Fila f = new Fila();
		Impressora impressora = new Impressora();

		String[] actionButtons = { "Adicionar arquivo para impress�o", "imprimir arquivos", "Cancelar" };

		int opcao = 0;

		do {
			opcao = JOptionPane.showOptionDialog(null, "Qual ser� a a��o?", "Confirmation",
					JOptionPane.INFORMATION_MESSAGE, 0, null, actionButtons, actionButtons[0]);

			switch (opcao) {
			case 0:
				String nomeArquivo = JOptionPane.showInputDialog(null, "Insira o nome do documento");

				if (impressora.validaDocumento(nomeArquivo)) {
					impressora.insereDocumento(f, nomeArquivo);
				} else {
					JOptionPane.showMessageDialog(null, "Documento inv�lido");
					opcao = 0;
				}

				break;

			case 1:
				try {
					impressora.imprime(f);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Documentos impressos");
				}

				break;
			}

		} while (opcao != 2);

	}

}