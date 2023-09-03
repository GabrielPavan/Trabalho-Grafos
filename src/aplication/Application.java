package aplication;

import java.io.IOException;
import javax.swing.JOptionPane;

import factories.GrafoFactory;
import infra.ManageFile;
import util.ProgramParameters;

public class Application {

	public static void main(String[] args) {
		
		ManageFile _ManageFile = new ManageFile(args[ProgramParameters.FILE_PATH.getValue()]);
		try {
			_ManageFile.BufferFile();
			_ManageFile.ReadFileDataList();
			_ManageFile.RemoveNonCompliantData();
			_ManageFile.closeFile();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao manipular o arquivo: \n\n" + e.getMessage());
		}
		
		GrafoFactory _GrafoFactory = new GrafoFactory(_ManageFile.getConformingDataList());
		
		_GrafoFactory.CreateGrafo();
	}
}