package dijkstra;
import java.util.Dictionary;
public interface PiInterface {
	
	public int getValue(VertexInterface key) ;//to get the value of the Key key
	
	public void setValue(VertexInterface key, int value) ;// to change the value of the distance to key.  

}
