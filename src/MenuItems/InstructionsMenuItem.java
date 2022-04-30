package MenuItems;

import javax.swing.*;

import mazeUI.MazeApplication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InstructionsMenuItem extends JMenuItem implements ActionListener {
	
	private final MazeApplication mazeApp;
	
	public InstructionsMenuItem(MazeApplication mazeApp) 
	{
		super("Instructions");
		this.mazeApp = mazeApp;
		addActionListener(this);
	}
	@Override

	public final void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this.mazeApp,"- If you want to create a new Maze with whatever dimension you want"+
				", then you should click on New Maze\n"+
				"- Select a departure box by clicking on Select Departure\n"+
				"- Select an arrival box by clicking on Select Arrival\n"+
				"- You can make Walls and Empty boxes only by clicking on the squares\n"+
				"- Then click on Solve to visualize the path from Departure to Arrival\n"+
				"- If you want to import an existing Maze, click on Import Maze and select the file\n"+
				"- If you want to save your Maze, click on Save\n"+
				"- Finally, if you have finished playing, you can quit by clicking on Exit\n"+
				"                                                                             ENJOY !!");

	}

}
