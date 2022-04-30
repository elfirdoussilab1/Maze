package default_package;
import java.io.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import dijkstra.*;
import maze.*;

public class MainTest {

	public static void main(String[] args) throws MazeReadingException, maze.FileNotFoundException 
		{
			Maze maze = new Maze(null);
			maze.initFromTextFile("data/labyrinthe.txt");
			//MBox[][] m = maze.getMaze();
			//ABox A = maze.getArrival();
			//DBox D = maze.getDeparture();
			ABox A = maze.getArrival();
			DBox D = maze.getDeparture();
			PreviousInterface previous = DIJKSTRA.dijkstra(maze,D);
			
			System.out.println(A.getLabel());
			System.out.println(previous.toString());
			
			ArrayList<VertexInterface> path = previous.getShortestPathTo(previous.getPrevious(A));
			
			for(VertexInterface M : path) 
			{
				if(M.getLabel()!="D") 
				{
					int i = M.getX();
					int j = M.getY();
					maze.getMaze()[i][j].setLabel(".") ;
				}
				
			}
			
			maze.saveToTextFile("data/labyrinthe2.txt");
			
			System.out.println("ana khdam");
		}
	
}
