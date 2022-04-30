package MenuBar;

import javax.swing.JMenuBar;

import Menus.*;
import mazeUI.*;


public final class MazeMenuBar extends JMenuBar
{
	private final StartMenu fileMenu;
	private final HelpMenu helpMenu;
	private final ExitMenu exitMenu;
	private final SaveMenu saveMenu ;
	
	
	
	public MazeMenuBar(MazeApplication mazeApp) 
	{
		super();
		//it's Menus
	
		add(fileMenu=new StartMenu(mazeApp));
		add(helpMenu = new HelpMenu(mazeApp));
		add(saveMenu = new SaveMenu(mazeApp));
		add(exitMenu = new ExitMenu(mazeApp));
	}
	

}
