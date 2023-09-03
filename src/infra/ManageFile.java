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

	private HashSet<String> NonRepeatingDataList = new HashSet<String>();
	private List<String> SortedDataList;

	public ManageFile(String pPath) {
		this.Path = pPath;
	}
	public BufferedReader getBufferedFile() {
		return this.BufferedFile;
	}

	public BufferedReader BufferFile() throws IOException {
		InputStream = new FileInputStream(Path);
		InputStreamReader = new InputStreamReader(InputStream);
		BufferedFile = new BufferedReader(InputStreamReader);
		return BufferedFile;
	}

	public void ReadFileData(BufferedReader pBufferedFile) throws IOException {
		String Prefix = "LinhaXX: ";
		String Line = "";
		
		while ((Line = pBufferedFile.readLine()) != null) {
			Line = Line.substring(Prefix.length());
			if (Line.startsWith("-")) 
				continue;
			NonRepeatingDataList.add(Line);
		}
	}
	
	public List<String> GetFileData(){
		SortedDataList = new ArrayList<>(NonRepeatingDataList);
		Collections.sort(SortedDataList);
		return SortedDataList;
	}

	public void closeFile() throws IOException {
		BufferedFile.close();
	}
}