package dijkstra;

import java.util.Hashtable;

public final class Pi extends Hashtable<VertexInterface,Integer>  implements PiInterface {
	
	/*
	 * Constructor
	 */
	public Pi() 
	{
		super();
	}
	
	/*
	 * Getting the actual distance between r and key. 
	 */
	public int getValue(VertexInterface key) 
	{
		return get(key);
	}
	
	/*
	 * to change the value of the distance to key.
	 */
	public void setValue(VertexInterface key, int value) 
	{
		put(key, value);
	}
	/*
	 * Getter
	 */

	
	
	
}
