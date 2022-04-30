package MenuItems;

import javax.swing.*;

import mazeUI.MazeApplication;
import model.MazeAppModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public final class QuitMenuItem extends JMenuItem implements ActionListener
{
	private final MazeApplication mazeApp;
	
	public QuitMenuItem(MazeApplication mazeApp) 
	{
		super("Quit Game");
		this.mazeApp = mazeApp;
		addActionListener(this);
	}
	public final void actionPerformed(ActionEvent evt)
	{
		MazeAppModel model = mazeApp.getModel() ;

		if (model.getModified()==true) {
			int response = JOptionPane.showInternalOptionDialog(this,
					"Drawing not saved. Save it ?",
					"Quit application",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.WARNING_MESSAGE,
					null,null,null) ;
			switch (response) {
				case JOptionPane.CANCEL_OPTION:
					return ;
				case JOptionPane.OK_OPTION:
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
					model.save(fileName);
					break ;
				case JOptionPane.NO_OPTION:
					break ;
			}
		}
		System.exit(0) ;
	}

}
