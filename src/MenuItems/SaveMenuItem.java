package MenuItems;

import javax.swing.*;

import mazeUI.*;
import model.MazeAppModel;
import java.lang.String;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public final class SaveMenuItem extends JMenuItem implements ActionListener {

	private final MazeApplication mazeApp;

	public SaveMenuItem(MazeApplication mazeApp) {
		super("Save Maze");
		this.mazeApp = mazeApp;
		addActionListener(this);
	}

	@Override
	// Enregistre le labyrinthe dans le fichier SavedMaze
	public void actionPerformed(ActionEvent e) {
		String fileName = JOptionPane.showInputDialog(mazeApp, "Name of the File");
		String notAccepted = MazeAppModel.notAccepted;
		int n = fileName.length();
		for (int i = 0; i < n; i++) {
			String c = String.valueOf(fileName.charAt(i));
			if (notAccepted.contains(c)) {
				JOptionPane.showMessageDialog(
						this.mazeApp,
						"Name should not contain " + notAccepted,
						"Invalid Name",
						JOptionPane.WARNING_MESSAGE
				);
				return;
			}
		}
		mazeApp.getModel().save(fileName);
	}
}
