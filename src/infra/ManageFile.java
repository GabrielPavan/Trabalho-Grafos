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

public class ManageFile {

	private String Path;
	private InputStream InputStream;
	private InputStreamReader InputStreamReader;
	private BufferedReader BufferedFile;

	private String FirstLine;
	private List<String> DataList = new ArrayList<String>();
	private List<String> NonConformingDataList = new ArrayList<String>();
	private HashSet<String> ConformingDataList = new HashSet<String>();

	public ManageFile(String pPath) {
		this.Path = pPath;
	}
	public String getFirstLine() {
		return FirstLine;
	}
	public List<String> getConformingDataList() {
		List<String> SortedConformingDataList = new ArrayList<String>(ConformingDataList);
		Collections.sort(SortedConformingDataList);
		return SortedConformingDataList;
	}

	public void BufferFile() throws IOException {
		InputStream = new FileInputStream(Path);
		InputStreamReader = new InputStreamReader(InputStream);
		BufferedFile = new BufferedReader(InputStreamReader);
	}
	public void ReadFileDataList() throws IOException {
		String Line = "";
		FirstLine = BufferedFile.readLine();
		while ((Line = BufferedFile.readLine()) != null) {
			DataList.add(Line);
		}
	}
	public void RemoveNonCompliantData() {
		for (String item : DataList) {
			String Item = item;
			if(Item.contains("-")) {
				NonConformingDataList.add(item + " - Item com Valor Negativo");
				continue;
			}
			if(!ConformingDataList.add(Item.substring(8))){
				NonConformingDataList.add(item + " - Dado duplicado");
			}
        }
	}
	public void closeFile() throws IOException {
		BufferedFile.close();
	}
}