package maze;

import dijkstra.VertexInterface;

public abstract class MBox implements VertexInterface
{
	// coordinates of a box.
	private int x; 
	private int y;
	// label of the vertex
	private String label;
	
	// Il faut eliminer ça ! (une abstract class n'a pas de constructeur)
	public MBox(int x, int y,String label) 
	{
		this.x=x;
		this.y=y;
		this.label=label;
	}
	
	public int getX() 
	{
		return x;
	}

	public int getY() {
		return y;
	}
	
	public String getLabel() 
	{
		return label;
	}
	public void setLabel(String label) 
	{
		this.label=label;
	}
	
}
