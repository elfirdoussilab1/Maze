package PanelsAndButtons;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import maze.MBox;
import maze.Maze;
import mazeUI.*;
import model.MazeAppModel;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.awt.Dimension;
import java.awt.Toolkit;

// l'équivalent du drawing Panel, on doir redéfinir ici la méthode paintComponent
public class MazePanel extends JPanel implements ChangeListener, MouseListener {

	private MazeApplication mazeApp;

	public MazePanel(MazeApplication mazeApp) {
		this.mazeApp = mazeApp;
		mazeApp.getModel().addObserver(this);
		setBackground(Color.WHITE);
		addMouseListener(this);

		int caseSize = mazeApp.getModel().findCaseSize();
		setPreferredSize(new Dimension(mazeApp.getModel().getWidth()*caseSize, mazeApp.getModel().getHeight()*caseSize));
	}

	public Color colorOf(String label)
	{
		switch (label) {
			case ("E"):
				return Color.YELLOW;
			case ("W"):
				return Color.GRAY;
			case ("D"):
				return Color.BLUE;
			case ("A"):
				return Color.PINK;
			case("."):
				return Color.GREEN;
		}
		return Color.RED;
	}

	//@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Maze currentmaze = mazeApp.getModel().getCurrentMaze();
		if(currentmaze!=null)
		{
			MBox[][] maze = currentmaze.getMaze();
			int length = currentmaze.getWidth();
			int height = currentmaze.getHeight();
			int caseSize = mazeApp.getModel().findCaseSize();

			//setLayout(new GridLayout(length,height));
			for (int i=0;i<height;i++)
			{
				for (int j=0; j<length;j++)
				{
					g.setColor(colorOf(maze[i][j].getLabel()));
					g.fillRect(j * caseSize , i * caseSize ,  caseSize, caseSize);
					g.setColor(Color.black);
					g.drawRect(j * caseSize , i * caseSize ,  caseSize, caseSize);

				}
			}

		}
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		mazeApp.getModel().mouseClicked(e);
		// this method is defined in the Model
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		resizePanel();
		repaint();
	}
	public void resizePanel() {
		int caseSize = mazeApp.getModel().findCaseSize();

		setPreferredSize(new Dimension(mazeApp.getModel().getWidth()*caseSize, mazeApp.getModel().getHeight()*caseSize));
		mazeApp.pack();
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}

}

