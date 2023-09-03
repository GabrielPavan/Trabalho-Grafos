package entities;

import java.util.ArrayList;
import java.util.List;

public class Vertice {
	
	private String Name;
	private List<Aresta> AdjacencyList;
	
	public Vertice(String pName) {
		Name = pName;
		AdjacencyList = new ArrayList<Aresta>();
	}

	public String getName() {
		return Name;
	}
	public List<Aresta> getAdjacencyList() {
		return AdjacencyList;
	}
}