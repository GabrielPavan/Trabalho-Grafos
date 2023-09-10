package factories;

import java.util.List;
import entities.Grafo;
import entities.Vertice;

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
		for (Vertice VerticeOrigem : pGrafo.getListOfVertices()) {
			int AndarOrigem = Integer.parseInt(VerticeOrigem.getName().substring(0, 1));
			int ApartamentOrigem = Integer.parseInt(VerticeOrigem.getName().substring(1));
			
			for(Vertice VerticeDestino : pGrafo.getListOfVertices()) {
				int AndarDestino = Integer.parseInt(VerticeDestino.getName().substring(0, 1));
				int ApartamentDestino = Integer.parseInt(VerticeDestino.getName().substring(1));
				
				if(AndarOrigem == AndarDestino) {
					if(ApartamentOrigem == ApartamentDestino) {
						continue;
					}
					if((ApartamentOrigem + 1) == ApartamentDestino || (ApartamentOrigem - 1) == ApartamentDestino) {
						pGrafo.addAresta(VerticeOrigem, VerticeDestino);
						continue;
					}
				}
				
				if((AndarOrigem + 1) == AndarDestino || (AndarOrigem - 1) == AndarDestino) {
					if(ApartamentOrigem == ApartamentDestino) {
						pGrafo.addAresta(VerticeOrigem, VerticeDestino);
						continue;
					}
					if((ApartamentOrigem + 1) == ApartamentDestino || (ApartamentOrigem - 1) == ApartamentDestino) {
						pGrafo.addAresta(VerticeOrigem, VerticeDestino);
					}
				}
			}
		}
	}
}