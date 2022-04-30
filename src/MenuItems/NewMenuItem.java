package MenuItems;

import javax.swing.*;

import maze.FileNotFoundException;
import maze.MazeReadingException;
import mazeUI.MazeApplication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewMenuItem extends JMenuItem implements ActionListener {
	
	private final MazeApplication mazeApp; // pincipal window
	
	public NewMenuItem(MazeApplication mazeApp) 
	{
		super("New Maze");
		this.mazeApp=mazeApp;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String widthEntered = JOptionPane.showInputDialog(mazeApp,"Width of the Maze");
		mazeApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		String heightEntered = JOptionPane.showInputDialog(mazeApp,"Height of the Maze");
		mazeApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			int width = Integer.valueOf(widthEntered);
		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(
					this.mazeApp,
					"Invalid value for width ! Must be integer",
					"Incorrect",
					JOptionPane.WARNING_MESSAGE
			);
			return;
		}

		try{
			int height = Integer.valueOf(heightEntered);
		}catch (Exception ex){
			ex.printStackTrace();
			JOptionPane.showMessageDialog(
					this.mazeApp,
					"Invalid value for height ! Must be integer",
					"Incorrect",
					JOptionPane.WARNING_MESSAGE
			);
			return;
		}
		int width = Integer.valueOf(widthEntered);
		int height = Integer.valueOf(heightEntered);
		mazeApp.getModel().newMaze(width,height);
	}
}
