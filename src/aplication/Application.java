package aplication;

import java.io.IOException;
import javax.swing.JOptionPane;
import factories.GrafoFactory;
import infra.ManageFile;

public class Application {

	public static void main(String[] args) {
		
		ManageFile _ManageFile = new ManageFile("C:\\temp\\configs.txt");
		try {
			_ManageFile.BufferFile();
			_ManageFile.ReadFileDataList();
			_ManageFile.CompliantData();
			_ManageFile.closeFile();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao manipular o arquivo: \n\n" + e.getMessage());
		}
		
		GrafoFactory _GrafoFactory = new GrafoFactory(_ManageFile.getConformingDataList());
		_GrafoFactory.CreateGrafo();
	}
}