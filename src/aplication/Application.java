package aplication;

import java.io.IOException;
import javax.swing.JOptionPane;

import entities.Grafo;
import exceptions.DomainException;
import exceptions.NotImplementedException;
import factories.GrafoFactory;
import infra.ManageFile;

public class Application {

	public static void main(String[] args) {
		
		ManageFile _ManageFile = new ManageFile("C:\\temp\\configs.txt");
		try {
			_ManageFile.BufferFileReader();
			_ManageFile.GetDataFromFile();
			_ManageFile.closeFile();
		} catch (IOException  e) {
			JOptionPane.showMessageDialog(null, "Erro ao manipular o arquivo: \n\n" + e.getMessage());
		}
		
		GrafoFactory _GrafoFactory = null;
		try {
			_GrafoFactory = new GrafoFactory(_ManageFile.getDataList());
		} catch (DomainException e) {
			JOptionPane.showMessageDialog(null, "Existe algum erro na montagem do Grafo: \n\n" + e.getMessage());
			return;
		}
		
		Grafo Grafo = _GrafoFactory.getGrafo();
		System.out.println(Grafo);
		
		_ManageFile = new ManageFile("C:\\temp\\result.txt");
		try {
			_ManageFile.BufferFileWriter();
			_ManageFile.WriteData(Grafo);
			_ManageFile.closeFile();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao manipular o arquivo: \n\n" + e.getMessage());
		} catch (NotImplementedException e) {
			JOptionPane.showMessageDialog(null, "Tentativa de manipular dado incorreto: \n\n" + e.getMessage());
		}
	}
}