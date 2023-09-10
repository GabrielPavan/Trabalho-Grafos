package aplication;

import java.io.IOException;
import javax.swing.JOptionPane;

import entities.Grafo;
import exceptions.DomainException;
import factories.GrafoFactory;
import infra.ManageFile;

public class Application {

	public static void main(String[] args) {
		
		ManageFile _ManageFile = new ManageFile("C:\\temp\\configs.txt");
		try {
			_ManageFile.BufferFile();
			_ManageFile.GetDataFromFile();
			_ManageFile.OrganizeData();
			_ManageFile.closeFile();
		} catch (IOException  e) {
			JOptionPane.showMessageDialog(null, "Erro ao manipular o arquivo: \n\n" + e.getMessage());
		} catch (DomainException e) {
			JOptionPane.showMessageDialog(null, "Erro ao validar os dados do arquivo: \n\n" + e.getMessage());
		} 

		GrafoFactory _GrafoFactory = new GrafoFactory(_ManageFile.getGrafoList());
		
		Grafo Grafo = _GrafoFactory.getGrafo();
		
		System.out.println(_ManageFile.getFirstLine());
		System.out.println(Grafo);
		System.out.println(_ManageFile.getLastLine());
		
		System.out.println(_ManageFile.getGrafoDuplicated());
		System.out.println(_ManageFile.getGrafoNegative());
	}
}