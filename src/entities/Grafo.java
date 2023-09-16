package entities;

import java.util.ArrayList;
import java.util.List;

public class Grafo {

	private String Indentifier;
	private String Validator;
	private List<Vertice> ListOfVertices = new ArrayList<Vertice>();
	private List<String> GrafosNegative =  new ArrayList<String>();
	private List<String> GrafosDuplicated = new ArrayList<String>(); 
	
	public Grafo() {
		ListOfVertices = new ArrayList<Vertice>();
	}
	
	public String getIndentifier() {
		return Indentifier;
	}
	public void setIndentifier(String indentifier) {
		Indentifier = indentifier;
	}
	public String getValidator() {
		return Validator;
	}
	public void setValidator(String validator) {
		Validator = validator;
	}
	public List<Vertice> getListOfVertices() {
		return ListOfVertices;
	}
	public List<String> getGrafosNegative() {
		return GrafosNegative;
	}
	public void setGrafoNegative(List<String> grafoNegative) {
		GrafosNegative = grafoNegative;
	}
	public List<String> getGrafosDuplicated() {
		return GrafosDuplicated;
	}
	public void setGrafoDuplicated(List<String> grafoDuplicated) {
		GrafosDuplicated = grafoDuplicated;
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
	    StringBuilder sb = new StringBuilder();
	    
	    sb.append(Indentifier).append("\n");

	    for (Vertice v : ListOfVertices) {
	        sb.append(v.getName()).append(" -> ");
	        for (Aresta a : v.getAdjacencyList()) {
	            Vertice destination = a.getDestination();
	            sb.append("[").append(destination.getName()).append("] -> ");
	        }
	        sb.append("[/]").append("\n");
	    }
	    
	    sb.append(Validator).append("\n\n");
	    sb.append("Vertices Negativas: ").append(getGrafosNegative().size()).append("\n");
	    sb.append(getGrafosNegative()).append("\n");
	    sb.append("Vertices Duplicados: ").append(getGrafosDuplicated().size()).append("\n");
	    sb.append(getGrafosDuplicated()).append("\n");
	    
	    return sb.toString();
	}	
}