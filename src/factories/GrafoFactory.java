package factories;

import java.util.List;
import entities.Grafo;

public class GrafoFactory {
	
	Grafo Grafo;
	
	public GrafoFactory(List<String> pGrafoList) {
		Grafo = new Grafo();
		AddVertices(pGrafoList, Grafo);
		CreateArestas(Grafo);
	}
	
	public Grafo getGrafo() {
		return Grafo;
	}
	
	private void AddVertices(List<String> pListOfVertices, Grafo pGrafo) {
		pListOfVertices.forEach(X -> {
			pGrafo.addVertice(X);
		});
	}
	private void CreateArestas(Grafo pGrafo) {
		
	}
}