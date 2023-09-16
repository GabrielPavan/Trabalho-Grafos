package factories;

import java.util.HashSet;
import java.util.List;
import entities.Grafo;
import entities.Vertice;
import exceptions.DomainException;

public class GrafoFactory {
	
	Grafo Grafo;
	private HashSet<String> GrafoList = new HashSet<String>();
	
	public GrafoFactory(List<String> pGrafoDataListFromFile) throws DomainException {
		
		Grafo = new Grafo();
		OrganizeDataFromFile(pGrafoDataListFromFile);
		AddVertices(GrafoList, Grafo);
		ValidadeGrafoSize();
		CreateArestas(Grafo);
	}
	public Grafo getGrafo() {
		return Grafo;
	}
	
	private void OrganizeDataFromFile(List<String> pGrafoDataListFromFile) throws DomainException {
		Grafo.setIndentifier(pGrafoDataListFromFile.get(0));
		Grafo.setValidator(pGrafoDataListFromFile.get(pGrafoDataListFromFile.size() - 1));
		
		pGrafoDataListFromFile.remove(0);
		pGrafoDataListFromFile.remove(pGrafoDataListFromFile.size() - 1);
		
		for (String item : pGrafoDataListFromFile) {
			if(item.contains("-")) {
				Grafo.getGrafosNegative().add( item + " - Nó com Valor Negativo");
				continue;
			}
			if(!GrafoList.add(item.substring(9))) {
				Grafo.getGrafosDuplicated().add(item + " - Nó duplicado.");
			}
		}
	}
	private void AddVertices(HashSet<String> pGrafoList, Grafo pGrafo) {
		GrafoList.forEach(X -> {
			pGrafo.addVertice(X);
		});
	}
	private void ValidadeGrafoSize() throws DomainException {
		int Validador = Integer.parseInt(Grafo.getValidator().substring(16));
		
		if(Grafo.getListOfVertices().size() != Validador) {
			throw new DomainException("Erro ao consultar o validador da quantidade de Grafos");
		}
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