package Menus;

import javax.swing.JMenu;

import MenuItems.QuitMenuItem;
import mazeUI.*;

public class ExitMenu extends JMenu{
	private QuitMenuItem quit;
	
	public ExitMenu(MazeApplication mazeApp) 
	{
		super("Exit");
		// it's items
		
		add(quit=new QuitMenuItem(mazeApp));
		
	}
	

}
