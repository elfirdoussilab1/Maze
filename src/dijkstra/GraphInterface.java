package dijkstra;
import java.util.ArrayList;

import maze.MBox;
public interface GraphInterface {
	
	public ArrayList<VertexInterface> getAllVertices(); // returns the list of vertices
	
	public int getWeight(VertexInterface x, VertexInterface y); // returns the value of the length of the wing (x,y)
	
	public ArrayList<VertexInterface> getSuccessors(VertexInterface vertex); // returns the list of successors of vertex

	public MBox[][] getMaze();

	
}