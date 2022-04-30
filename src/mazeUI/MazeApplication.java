package mazeUI;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import MenuBar.*;
import PanelsAndButtons.*;
import maze.FileNotFoundException;
import maze.MazeReadingException;
import model.MazeAppModel;
import model.MazeAppModel;
public final class MazeApplication extends JFrame
{
	private MazeAppModel model;
	private final MazeMenuBar menubar;
	private final MazePanel mazePanel;
	
	
	public final MazeAppModel getModel() 
	{
		return model ;
	}
	
	public final void setModel(MazeAppModel model) 
	{
		this.model= model;
	}

	public MazePanel getMazePanel() {
		return mazePanel;
	}

	public MazeApplication() throws FileNotFoundException, MazeReadingException {
		super("Maze Application");
		// Window menu bar
		menubar = new MazeMenuBar(this);
		setJMenuBar(menubar);
		model = new MazeAppModel();
		mazePanel = new MazePanel(this);
		setContentPane(mazePanel);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// to exit the app.
		pack();           // This sets components sizes, positions
		setVisible(true); // makes the window visible !
	}


	

}
