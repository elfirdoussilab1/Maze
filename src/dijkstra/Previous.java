package dijkstra;
import java.util.Hashtable;
import java.util.ArrayList;
import java.util.Dictionary;
public final class Previous  extends Hashtable<VertexInterface,VertexInterface> implements PreviousInterface{
	private static final long serialVersionUID = 1L;
	
	/*
	 * Constructor
	 */
	public Previous () 
	{
		super();
	}
	
	/*
	 * change the previous of key
	 */
	public void changeTo(VertexInterface key, VertexInterface pre) 
	{
		put(key, pre);
	}
	
	/*
	 * return the previous of vertex
	 */
	public VertexInterface getPrevious(VertexInterface vertex) 
	{
		return get(vertex);
	}
	
	/*
	 * Shortest path
	 */
	// renvoie l'arborescence d'un sommet du labyrinthe vers le départ
	
	public ArrayList<VertexInterface> getShortestPathTo(VertexInterface vertex) 
	{
		VertexInterface v = vertex;
		ArrayList<VertexInterface> path = new ArrayList<VertexInterface>();
		while (v !=null)
		{
			path.add(v);
			v = get(v);
			
		}

		return path;
	}
}
