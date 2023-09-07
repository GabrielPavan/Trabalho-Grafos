package factories;

import java.util.ArrayList;
import java.util.List;

import entities.Grafo;

public class GrafoFactory {
	
	List<String> ListOfVertices;
	Grafo Grafo;
	
	public GrafoFactory(List<String> pListOfData) {
		ListOfVertices = new ArrayList<String>(pListOfData);
	}
	
	public void CreateGrafo() {
		Grafo = new Grafo();
		
		AddVertices(ListOfVertices, Grafo);
		CreateArestas(Grafo);
	}
	private void AddVertices(List<String> pListOfData, Grafo pGrafo) {
		pListOfData.forEach(X -> {
			pGrafo.addVertice(X);
		});
	}
	private void CreateArestas(Grafo pGrafo) {
		pGrafo.getListOfVertices().forEach(X -> {
			
		});
	}
}