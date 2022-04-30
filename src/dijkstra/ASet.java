package dijkstra;
import java.util.HashSet;

public final class ASet extends HashSet<VertexInterface> implements ASetInterface {
	/*
	 * Constructor 
	 */
	
	public ASet() 
	{
		super();
	}
	
	/*
	 * the method isNotInA
	 */
	
	public boolean isNotInA(VertexInterface vertex) 
	{
		return !(contains(vertex));
	}
	
	/*
	 * the void add to the Set
	 */
	public void addToA(VertexInterface vertex) 
	{
		add(vertex);
	}
}
