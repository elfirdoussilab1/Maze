package dijkstra;
import java.util.HashSet;
import java.util.ArrayList;
import maze.*;
import java.util.Hashtable;
import java.util.Dictionary;
import dijkstra.*;
import maze.*;
public final class DIJKSTRA {
	
	public static PreviousInterface dijkstra(GraphInterface g, VertexInterface r) 
	{
		// creating the set A
		ASet A = new ASet();
		
		// creating the object pi
		Pi pi = new Pi();
		
		// creating a Hashtable previous
		Previous prev = new Previous();
		
		PreviousInterface previous = dijkstra(g,r,A,pi,prev);
		return previous;
		
	}
	
	
	private static PreviousInterface dijkstra(GraphInterface  g,
											  VertexInterface r,
											  ASetInterface   A,
											  PiInterface     pi,
											  PreviousInterface previous) 
	{  
		
		A.addToA(r);
		
		// initializing pivot
		VertexInterface pivot = r;
		
		pi.setValue(r,0);

		
		// Initializing all distances to Infinity.
		ArrayList<VertexInterface> vertices = g.getAllVertices();
		for (int i=0;i<vertices.size();i++) 
		{
			if (vertices.get(i) !=r)
				pi.setValue(vertices.get(i), 100000000);
		}
		
		
		for (int j=0; j<vertices.size(); j++) 
		{
			ArrayList<VertexInterface> successors = g.getSuccessors(pivot);
			for (int k=0;k<successors.size(); k++) 
			{
				if (A.isNotInA(successors.get(k)))
				{
					
					VertexInterface y = successors.get(k);
					if (pi.getValue(pivot) + g.getWeight(pivot,y) < pi.getValue(y)) 
					{
						pi.setValue(y, pi.getValue(pivot) + g.getWeight(pivot,y));
						previous.changeTo(y, pivot);
					}
				}
					
			}
			
			// now we want to find the minimum
			pivot = null;
			for (int k=0;k<vertices.size(); k++) 
			{
				if(A.isNotInA(vertices.get(k)) && (pivot == null || pi.getValue(vertices.get(k)) < pi.getValue(pivot))) {
					pivot = vertices.get(k);
				}
			}
			
			A.addToA(pivot);
		}
		
		return previous;
	}
	
	
}
