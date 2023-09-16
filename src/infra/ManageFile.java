package infra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import entities.Grafo;
import exceptions.NotImplementedException;

public class ManageFile {

	private String Path;
	private InputStream InputStream;
	private InputStreamReader InputStreamReader;
	private BufferedReader BufferedReader;
	
	private OutputStream OutputStream;
	private OutputStreamWriter OutputStreamWriter;
	private BufferedWriter BufferedWriter;

	private String ReadLine;
	private List<String> DataList = new ArrayList<String>();
	
	public ManageFile(String pPath) {
		this.Path = pPath;
	}
	
	public void BufferFileReader() throws IOException {
		InputStream = new FileInputStream(Path);
		InputStreamReader = new InputStreamReader(InputStream);
		BufferedReader = new BufferedReader(InputStreamReader);
	}
	public void GetDataFromFile() throws IOException {
		while ((ReadLine = BufferedReader.readLine()) != null) {
			DataList.add(ReadLine);
		}
	}
	public List<String> getDataList() {
		return DataList;
	}
	
	public void BufferFileWriter() throws IOException {
		OutputStream = new FileOutputStream(Path);
		OutputStreamWriter = new OutputStreamWriter(OutputStream);
		BufferedWriter = new BufferedWriter(OutputStreamWriter);
	}
	public void WriteData(Object Data) throws IOException, NotImplementedException {
		if(Data instanceof Grafo) {
			Grafo grafo = (Grafo) Data;
			BufferedWriter.write(grafo.toString());
			BufferedWriter.flush();
		} else {
			throw new NotImplementedException("Dado fornecido não possui implementação!!");
		}
	}
	
	public void closeFile() throws IOException {
		if(BufferedReader != null)
			BufferedReader.close();
		if(BufferedWriter != null)
			BufferedWriter.close();
	}
}