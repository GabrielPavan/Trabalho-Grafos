package infra;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import exceptions.DomainException;

public class ManageFile {

	private String Path;
	private InputStream InputStream;
	private InputStreamReader InputStreamReader;
	private BufferedReader BufferedFile;

	private String ReadLine, FirstLine, LastLine;
	private List<String> DataList = new ArrayList<String>();
	private HashSet<String> GrafoList = new HashSet<String>();
	private List<String> GrafoNegative = new ArrayList<String>();
	private List<String> GrafoDuplicated = new ArrayList<String>();
	

	public ManageFile(String pPath) {
		this.Path = pPath;
	}
	
	public String getFirstLine() {
		return FirstLine;
	}
	public String getLastLine() {
		return LastLine;
	}
	public List<String> getGrafoList() {
		List<String> SortedGrafoList = new ArrayList<String>(GrafoList);
		Collections.sort(SortedGrafoList);
		return SortedGrafoList;
	}
	public List<String> getGrafoNegative(){
		return GrafoNegative;
	}
	public List<String> getGrafoDuplicated(){
		return GrafoDuplicated;
	}
	
	public void BufferFile() throws IOException {
		InputStream = new FileInputStream(Path);
		InputStreamReader = new InputStreamReader(InputStream);
		BufferedFile = new BufferedReader(InputStreamReader);
	}
	
	public void GetDataFromFile() throws IOException, DomainException {
		while ((ReadLine = BufferedFile.readLine()) != null) {
			DataList.add(ReadLine);
		}
	}
	public void OrganizeData() throws DomainException {
		FirstLine = DataList.get(0);
		LastLine = DataList.get(DataList.size() - 1);
		
		DataList.remove(0);
		DataList.remove(DataList.size() - 1);
		
		for (String item : DataList) {
			if(item.contains("-")) {
				GrafoNegative.add( item + " - Nó com Valor Negativo");
				continue;
			}
			if(!GrafoList.add(item.substring(9))) {
				GrafoDuplicated.add(item + " - Nó duplicado.");
			}
		}
		int validador = Integer.parseInt(LastLine.substring(16));
		
		if(GrafoList.size() != validador) {
			throw new DomainException("Erro ao consultar o validador da quantidade de Grafos");
		}
	}
	public void closeFile() throws IOException {
		BufferedFile.close();
	}
}