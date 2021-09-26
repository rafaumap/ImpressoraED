package controller;

import javax.swing.JOptionPane;

import com.rafael.utils.filas.string.*;

public class Impressora {

	public Impressora() {
		super();
	}

	
	public void insereDocumento(Fila f, String nomeArquivo) {
		f.insert(nomeArquivo);
	}
	
	public void imprime(Fila f) throws Exception {
		if (f.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Não há arquivos na fila de impressão");
		} else {
			while (!f.isEmpty()) {
				String arquivo = f.remove();
				
				String nomeArquivo[] = arquivo.split(";");
				
				System.out.println("[#PC: " + nomeArquivo[0] + " – Arquivo: " + nomeArquivo[1] + "]");
				
				int tempoImpressao = (int) ((Math.random() * 2000) + 1000);
				Thread.sleep(tempoImpressao);
			}
		}
	}
	
	public boolean validaDocumento(String nomeArquivo) {
		 //ID_PC;Nome_Arquivo
		
		if (nomeArquivo.contains(";")) {
			int tamanhoNomeArquivo = nomeArquivo.split(";").length;
			
			if (tamanhoNomeArquivo == 2) {
				return true;
			}
		} 
		
		return false;
	}
}