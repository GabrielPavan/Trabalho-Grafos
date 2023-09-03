package entities;

import java.util.ArrayList;
import java.util.List;

public class Grafo {

	private List<Vertice> ListOfVertices;

	public Grafo() {
		ListOfVertices = new ArrayList<Vertice>();
	}

	public Vertice addVertice(String Name) {
		Vertice v = new Vertice(Name);
		ListOfVertices.add(v);
		return v;
	}

    public Aresta addAresta(Vertice Origin, Vertice Destination) {
		Aresta a = new Aresta(Origin, Destination);
		Origin.getAdjacencyList().add(a);
		return a;
	}

	public int getDegree(Vertice vertice) {
		return vertice.getAdjacencyList().size();
	}

	public int getInDegree(Vertice vertice) {
		int inDegree = 0;
		for (Vertice v : ListOfVertices) {
			for (Aresta a : v.getAdjacencyList()) {
				if (a.getDestination() == vertice) {
					inDegree++;
				}
			}
		}
		return inDegree;
	}

	public void printDegree() {
		for (Vertice v : ListOfVertices) {
			int degree = getDegree(v);
			int inDegree = getInDegree(v);
			System.out.println("Grau de emissão de " + v.getName() + ": " + degree);
			System.out.println("Grau de recepção de " + v.getName() + ": " + inDegree);
		}
	}

	@Override
	public String toString() {

		String r = "";

		for (Vertice v : ListOfVertices) {
			r += v.getName() + " -> ";
			for (Aresta a : v.getAdjacencyList()) {
				v = a.getDestination();
				r += "[" + v.getName() + "] -> ";
			}
			r += "[/]";
			r += "\n";
		}
		return r;
	}
}
