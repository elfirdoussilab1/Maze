package MenuItems;

import maze.ABox;
import maze.DBox;
import maze.Maze;
import mazeUI.MazeApplication;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SolveMenuItem extends JMenuItem implements ActionListener {
    private MazeApplication mazeApp;

    public SolveMenuItem(MazeApplication mazeApp){
        super("Solve");
        this.mazeApp = mazeApp;
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Maze currentMaze = mazeApp.getModel().getCurrentMaze();
        int numA = currentMaze.numberofA();
        int numD = currentMaze.numberofD();
        if(numA !=1) {
            JOptionPane.showMessageDialog(
                    this.mazeApp,
                    "You should have only ONE Arrival !",
                    "Solving Error",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }else if(numD!=1) {
            JOptionPane.showMessageDialog(
                    this.mazeApp,
                    "You should have only ONE Departure !",
                    "Solving Error",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        } else{
            mazeApp.getModel().solve();
        }


    }
}
