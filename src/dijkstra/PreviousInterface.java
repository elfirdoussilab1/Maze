package dijkstra;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
public interface PreviousInterface {
	// previous will be a Dictionary (or it could be also a table of linkedlists : hashtable)
	
	public VertexInterface getPrevious(VertexInterface vertex) ;// returns the previous of vertex
	
	public void changeTo(VertexInterface key, VertexInterface pre);// to change the previous vertex of key to the vertex "previous", we already have the method "put".
	
	public ArrayList<VertexInterface> getShortestPathTo(VertexInterface vertex);
}
