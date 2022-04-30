package MenuItems;

import javax.swing.JMenuItem;

import mazeUI.MazeApplication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public final class DepartureMenuItem extends JMenuItem implements ActionListener {
	private final MazeApplication mazeApp;
	
	public DepartureMenuItem(MazeApplication mazeApp) 
	{
		super("Select Departure");
		this.mazeApp = mazeApp;
		addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		mazeApp.getModel().setPressedD(true);
	}
}
