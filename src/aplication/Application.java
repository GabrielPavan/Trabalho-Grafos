package aplication;

import java.io.IOException;
import javax.swing.JOptionPane;

import factories.GrafoFactory;
import infra.ManageFile;

public class Application {

	public static void main(String[] args) {
		ManageFile _ManageFile = new ManageFile(args[0]);
		try {
			_ManageFile.BufferFile();
			_ManageFile.ReadFileData(_ManageFile.getBufferedFile());
			_ManageFile.closeFile();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao manipular o arquivo: \n\n" + e.getMessage());
		}
		
		GrafoFactory _GraphFactory =  new GrafoFactory(_ManageFile.GetFileData());
		
	}
}