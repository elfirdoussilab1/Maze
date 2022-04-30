package maze;

import java.awt.*;
import java.util.ArrayList;

import java.io.*;

import dijkstra.GraphInterface;
import dijkstra.VertexInterface;

public final class Maze implements GraphInterface
{
	private MBox[][] maze;
	private int width;
	private int height;
	
	
	/*
	 * the length of the maze
	 */ // maze[0].length;
	/*
	 * The height of the maze
	 */ // maze.length;
	
	
	
	/*
	 * Constructor
	 */
	public Maze(MBox[][] maze) 
	{
		this.maze = maze;
		
	}
	// maze
	
	public MBox[][] getMaze() 
	{
		return maze;
	}

	public void setMaze(MBox[][] maze) 
	{
		this.maze = maze;
	}

	//length 
	public int getWidth()
	{
		return width;
	}

	public void setWidth(int length) {
		this.width = length;
	}
	// height

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	

	/*
	 * All Vertices of the maze
	 */
	public ArrayList<VertexInterface> getAllVertices()
	{
		ArrayList<VertexInterface> l = new ArrayList<VertexInterface>();
				for (int i =0; i<maze.length;i++) 
					for (int j=0;j<maze[0].length;j++)
						l.add(maze[i][j]);
	
		return l;
	}
	
	
	/*
	 * Poids de l'arête
	 */
	public int getWeight(VertexInterface x, VertexInterface y) 
	{
		if (x==y)
			return 0;
		else 
		{
			ArrayList<VertexInterface> l = getSuccessors(x); 
			for(VertexInterface v : l) 
			{
				if (v==y)
					return 1;
			}
			
		}
		
		System.out.println("Impossible de donner un poids entre deux vertex non connectés");
		return 0;
	}

	
	/*
	 * Successors of vertex
	 */
	public ArrayList<VertexInterface> getSuccessors(VertexInterface vertex)
	{
		int i = vertex.getX();
		int j = vertex.getY();
		ArrayList<VertexInterface> l = new ArrayList<VertexInterface>();
		
		// If it is a Wall, then box has no successor
		
		if(vertex.getLabel().equals("W"))
			return l;
		
		// If it is not a Wall
		
		if(i+1<maze.length)
			if (!maze[i+1][j].getLabel().equals("W"))
				l.add(maze[i+1][j]);
		if(i-1>=0)
			if (!maze[i-1][j].getLabel().equals("W"))
				l.add(maze[i-1][j]);
		if(j-1>=0)
			if (!maze[i][j-1].getLabel().equals("W"))
				l.add(maze[i][j-1]);
		if(j+1<maze[0].length)
			if (!maze[i][j+1].getLabel().equals("W"))
				l.add(maze[i][j+1]);
		
		return l;
		
	}
	
	
	/*
	 * Generate a maze by reading a text file
	 */
	// Errors related to the number of ABoes and DBoxes are treated in the Solve method in the class MazeAppModel
	public final void initFromTextFile(String fileName) throws MazeReadingException // FileNotFoundException
	{
		// ouvrir le fichier, puis le lire et l'enregistrer dans une chaine de carctère temporarire,
		// check la longueur des lignes
		
		// remplir en utilisant la variable temporaire
		
		
		BufferedReader br = null;
		String memoire2=""; // c'est juste pour que je puisse visualiser l'évolution
		String memoire="";
		int n=0; // the length of each line in the text file
		int p=1; // at the end, p will be the number of lines in the text file 
		int a=0; // the number of ABoxes
		int d=0; // the number of DBoxes
		
		try 
		{
			try 
			{
			FileReader fr = new FileReader(fileName);
			br = new BufferedReader(fr);
			}catch(Exception e) 
			{
				throw new FileNotFoundException(fileName);
			}
			// traitement
			while (br.ready()) 
			{
				memoire2=br.readLine();
				memoire = memoire+memoire2+"8"; // le 8 pour séparer les éléments de chaque ligne
				 System.out.println(memoire2);// c'était pour afficher les lignes dans la console
			}
			System.out.println(memoire);
				
		}
		catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				br.close();
			}catch(Exception e) {}
		}
		// maintenant on a stocké les données du fichier dans la variable locale memoire
		
		// vérifions la cohérence des lignes
		try 
		{
			// first line
			int k=0;
			while(memoire.charAt(k)!='8') 
			{
				k=k+1;
			}
			n=k;// les longueurs des lignes doivent être égaux à n 
			int compt = k; // le début de la 2eme ligne
			while(compt<memoire.length()-1) 
			{
				compt = compt+1;
				int m=0;
				while(memoire.charAt(compt)!='8') 
				{
					m=m+1;
					compt = compt+1;
				}
				if(n!=m) 
				{
					throw new MazeReadingException(fileName,p+1,"lines should have the same length");
				}
					
				else
					p=p+1;
			}
		}catch(Exception e) 
		{
			e.printStackTrace();
		}
		// maintenant on a un maze avec i lignes et n colonnes
		// on crée alors notre maze
		try 
		{
			MBox[][] M = new MBox[p][n];
			setHeight(p);
			setWidth(n);
			setMaze(M);
			
			// remplissage de maze
			int compteur =0;
			for (int i=0;i<p;i++) // lines
			{
				while(memoire.charAt(compteur)!='8') 
				{
					int j =0;
					while (j<n) 
					{
						switch(memoire.charAt(compteur)) 
						{
							case ('E'): 
								maze[i][j]= new EBox(i,j);
								break;
							case ('W'): 
								maze[i][j]= new WBox(i,j);
								break;
							case ('A'):
									maze[i][j]= new ABox(i,j);
									a=a+1;
									break;
							case ('D'):
									maze[i][j]= new DBox(i,j);
									d=d+1;
									break;

							default :
								throw new MazeReadingException(fileName, i+1,"invalid letter for box");
						} // end of switch
						
						j=j+1;
						compteur=compteur+1;
					}
					compteur=compteur+1;
					break;
				}
				
			}
		}catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	
	/*
	 * To save the Maze in a file called fileName
	 */
	public final void saveToTextFile(String fileName) 
	{
		PrintWriter pw = null;
		try 
		{
			
			pw = new PrintWriter(fileName);
			
			for (int i=0;i<maze.length;i++) 
			{
				for (int j=0;j<maze[0].length-1;j++)
					pw.print(maze[i][j].getLabel());
				pw.println(maze[i][maze[0].length-1].getLabel());
			} // end of for
		// end of try
			
		}
		
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		
		finally
		{
			try 
			{
				pw.close();			
			}
			catch(Exception e) {}
		}
	}
	
	
	/*
	 * We want to get the Departure Box
	 */
	public final DBox getDeparture()
	{
		DBox D=null;
		for(int i=0;i<maze.length;i++) 
			{
				for (int j=0;j<maze[0].length;j++) 
				{
					if(maze[i][j].getLabel().equals("D"))
						D = (DBox) maze[i][j];
				}
			}
		return D;
		
	}

	// to know how many departures we have
	public final int numberofD(){
		int compteurD=0;
		for(int i=0;i<height;i++)
			for(int j=0;j<width;j++)
				if(maze[i][j].getLabel().equals("D"))
					compteurD = compteurD+1;
		return compteurD;
	}
	/*
	We want to set the departure box
	 */
	public final void setDeparture(int x, int y)
	{
		int p=0;
		int q=0;
		for(int i=0;i<height;i++)
			for(int j=0;j<width;j++)
				if(maze[i][j].getLabel().equals("D")){
					p=i;
					q=j;
				}
		if(!maze[p][q].getLabel().equals("A")) // because sometimes D is in (0,0)
			maze[p][q] = new EBox(p,q);
		maze[x][y] = new DBox(x,y);
	}

	/*
	 * We want to get the Arrival Box
	 */
	public ABox getArrival()
	{
		ABox A=null;
		for(int i=0;i<maze.length;i++) 
			{
				for (int j=0;j<maze[0].length;j++) 
				{
					if(maze[i][j].getLabel().equals("A"))
						A = (ABox) maze[i][j];
				}
			}
		return A;
		
	}
	// to know how many arrivals we have
	public final int numberofA(){
		int compteurA=0;
		for(int i=0;i<height;i++)
			for(int j=0;j<width;j++)
				if(maze[i][j].getLabel().equals("A"))
					compteurA = compteurA+1;
		return compteurA;
	}

	/*
	We want to set the departure box
	 */
	public final void setArrival(int x, int y)
	{
		int p=0;
		int q=0;
		for(int i=0;i<height;i++)
			for(int j=0;j<width;j++)
				if(maze[i][j].getLabel().equals("A")){
					p=i;
					q=j;
				}
		if(!maze[p][q].getLabel().equals("D")) // because sometimes D is in (0,0)
			maze[p][q] = new EBox(p,q);

		maze[x][y] = new ABox(x,y);
	}

	/*
	Thanks to this method, we can generate an empty maze with the desired dimensions
	 */
	public final void generateEmptyMaze(int height, int width) // on va demander à user to enter the length and height
	{
		this.maze = new MBox[height][width];
		setHeight(height);
		setWidth(width);
		for(int i=0;i<height;i++)
			for (int j=0;j<width;j++)
				this.maze[i][j] = new EBox(i,j);
	}


	
	
}
