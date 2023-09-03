package entities;

public class Aresta {
	private Vertice Origin;	
	private Vertice Destination;
	
	public Aresta(Vertice pOrigin, final Vertice pDestination) {
		Origin = pOrigin;
		Destination = pDestination;
	}
	
	public Vertice getOrigin() {
		return Origin;
	}
	public Vertice getDestination() {
		return Destination;
	}		
}