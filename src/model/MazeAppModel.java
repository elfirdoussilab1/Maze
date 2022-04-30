package model;


import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


import dijkstra.DIJKSTRA;
import dijkstra.PreviousInterface;
import dijkstra.VertexInterface;
import maze.*;
// def : le modèle devra contenir tout ce qui est nécessaire pour déterminer l'état de l'interface graphique.

// l'idée est qu'au début, on va créer un Maze tout rempli avec des cases E et ensuitee avec des clics de souris
// l'utilisateur va pouvoir choisir les Walls.
// on lui demandera d'entrer la longueur et la hauteur du maze

public final class MazeAppModel {
	public static final String notAccepted = " /&@#([]){}.*?!";

	private boolean pressedA; // to know if we want to change Departure
	private boolean pressedD; // to know if we want to change Departure
    private int width;
    private int height;
	private Maze currentMaze;
	private boolean modified; // returns true if the maze is modified by the user
	private ArrayList<ChangeListener> listeners = new ArrayList<ChangeListener>();// liste d'observeurs

	// Constructor

	public MazeAppModel() throws FileNotFoundException, MazeReadingException {
        currentMaze = new Maze(null);
		currentMaze.generateEmptyMaze(10,10);
		modified = false;
        width = currentMaze.getWidth();
        height = currentMaze.getHeight();
		pressedA = false;
		pressedD = false;
	}

	// On ajoute l'observeur(View)

	public void addObserver(ChangeListener listener) {
		listeners.add(listener);
	}

	//prévenir les observeurs d'un changement
	public void stateChanges() {
		ChangeEvent evt = new ChangeEvent(this);
		for (ChangeListener listener : listeners)
			listener.stateChanged(evt);
	}

	// GETTERS AND SETTERS

	public int getWidth() {
		return width;
	}

	// to inform stateChanges that length has changed
	public void setWidth(int length) {
		if (this.width != length) {
			this.width = length;
			modified = true;
			stateChanges();
		}
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		if (this.height != height) {
			this.height = height;
			modified = true;
			stateChanges();
		}
	}

	public Maze getCurrentMaze() {
		return currentMaze;
	}

	public final void setCurrentMaze(Maze maze) {
		if (this.currentMaze != maze) {
			this.currentMaze = maze;
			setWidth(currentMaze.getWidth()); ;
			setHeight(currentMaze.getHeight());
			modified = true;
			stateChanges();
		}
	}

	public boolean isPressedA() {
		return pressedA;
	}

	public void setPressedA(boolean pressedA) {
		this.pressedA = pressedA;
	}

	public boolean isPressedD() {
		return pressedD;
	}

	public void setPressedD(boolean pressedD) {
		this.pressedD = pressedD;
	}

	// generate an empty maze (JOptionPanel)
    public void newMaze(int width, int height) {
		currentMaze.generateEmptyMaze(height,width);
		setHeight(height);
		setWidth(width);
		modified= true;
        stateChanges();
    }
    public final void importMaze(String filename) throws java.io.FileNotFoundException, FileNotFoundException, MazeReadingException {
        currentMaze.initFromTextFile(filename);
		this.width = currentMaze.getWidth();
		this.height = currentMaze.getHeight();
		modified = true;
        stateChanges();
    }
	public final void demo(String filename) throws FileNotFoundException, MazeReadingException {
		// On veut afficher le démo dans le Jpanel
		currentMaze.initFromTextFile(filename);
		setHeight(currentMaze.getHeight());
		setWidth(currentMaze.getWidth());
		modified = true;
		stateChanges();
	}

    // solving the maze
    public void solve()
    {
        ABox A = currentMaze.getArrival();
        DBox D = currentMaze.getDeparture();
        PreviousInterface previous = DIJKSTRA.dijkstra(currentMaze,D);
        ArrayList<VertexInterface> path = previous.getShortestPathTo(previous.getPrevious(A));
        for(VertexInterface M : path)
        {
            if(!M.getLabel().equals("D"))
            {
                int i = M.getX();
                int j = M.getY();
                currentMaze.getMaze()[i][j].setLabel(".") ;
            }

        }
        modified = true;
        stateChanges();
    }

	// mouseClicked is called by the Panel of the maze.

	public void mouseClicked(MouseEvent e) {
		// if it is for selecting arrival

		int caseSize = findCaseSize();
		int j = e.getX() / caseSize;
		int i = e.getY() / caseSize;
		if(pressedD){
			currentMaze.setDeparture(i,j);
			setPressedD(false);
		}
		else{
			if(pressedA){
				currentMaze.setArrival(i,j);
				setPressedA(false);
			}else{
				if(currentMaze.getMaze()[i][j].getLabel().equals("E")){
					currentMaze.getMaze()[i][j].setLabel("W");
				}
				else if (currentMaze.getMaze()[i][j].getLabel().equals("W"))
					currentMaze.getMaze()[i][j].setLabel("E");
			}


		}
		modified = true;
		stateChanges();

	}

    // saving the maze
	// checking if the name is valid or not


    public final void save(String fileName)
    {
        currentMaze.saveToTextFile(fileName+".txt");
		modified = false;
    }

	public boolean getModified() {
		return modified;
	}

	public int findCaseSize(){
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		return (int) (0.9f * Math.min(dimension.getWidth() / width, dimension.getHeight() / height));
		// 90% of the screen
	}
}
	


