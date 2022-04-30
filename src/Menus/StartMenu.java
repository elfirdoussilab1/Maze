package Menus;

import javax.swing.JMenu;

import MenuItems.*;
import MenuItems.QuitMenuItem;
import mazeUI.MazeApplication;

public final class StartMenu extends JMenu
{
	private final SolveMenuItem solve;
	private final ImportMenuItem importMaze;
	private final NewMenuItem newMaze;
	private final DepartureMenuItem departure;
	private ArrivalMenuItem arrival;
	
	public StartMenu (MazeApplication mazeApp) 
	{
		super("Start"); // Name of the Menu
		
		// it's items :
		add(newMaze= new NewMenuItem(mazeApp));
		add(importMaze = new ImportMenuItem(mazeApp));
		add(departure = new DepartureMenuItem(mazeApp));
		add(arrival = new ArrivalMenuItem(mazeApp));
		add(solve = new SolveMenuItem(mazeApp));
		
	}

}
