package Menus;

import javax.swing.JMenu;

import MenuItems.SaveMenuItem;
import mazeUI.*;
public class SaveMenu extends JMenu {
	
	private final SaveMenuItem save;
	
	public SaveMenu(MazeApplication mazeApp) 
	{
		super("Save");
		// it's items
		
		add(save = new SaveMenuItem(mazeApp));
	}
	

}
