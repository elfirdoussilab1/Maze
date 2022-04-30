package dijkstra;

// It is dedicated for the vertices that are already visited.
public interface ASetInterface {
	
	public void addToA(VertexInterface vertex);
	
	public boolean isNotInA(VertexInterface vertex); // returns True if vertex is not in A
	
}
