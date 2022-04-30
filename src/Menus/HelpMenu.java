package Menus;

import javax.swing.JMenu;
import mazeUI.*;
import MenuItems.*;
public class HelpMenu extends JMenu {
	private final InstructionsMenuItem instructions;
	
	public HelpMenu(MazeApplication mazeApp) 
	{
		super("Help ?");
		// it's items
		
		add(instructions = new InstructionsMenuItem(mazeApp));
	}

}
