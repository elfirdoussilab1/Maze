package MenuItems;

import javax.swing.JMenuItem;

import mazeUI.MazeApplication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public final class ArrivalMenuItem extends JMenuItem implements ActionListener {
	private final MazeApplication mazeApp;

	public ArrivalMenuItem(MazeApplication mazeApp) 
	{
		super("Select Arrival");
		this.mazeApp=mazeApp;
		addActionListener(this);
	}



	@Override
	public void actionPerformed(ActionEvent e) {

		mazeApp.getModel().setPressedA(true);
	}
}
