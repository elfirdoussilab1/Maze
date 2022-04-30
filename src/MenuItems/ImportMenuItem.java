package MenuItems;

import maze.MazeReadingException;
import mazeUI.MazeApplication;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

public final class ImportMenuItem extends JMenuItem implements ActionListener {
    private MazeApplication mazeApp;

    public ImportMenuItem(MazeApplication mazeApp)
    {
        super("Import Maze");
        this.mazeApp = mazeApp;
        addActionListener(this);

    }


    @Override
    public final void actionPerformed(ActionEvent e)
    {
        JFileChooser fileChooser = new JFileChooser();
        //fileChooser.setCurrentDirectory(new File(System.getProperty("Desktop")));
        int result = fileChooser.showOpenDialog(this.mazeApp);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                mazeApp.getModel().importMaze(selectedFile.getAbsolutePath());
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (maze.FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (MazeReadingException ex) {
                ex.printStackTrace();
            }
        }

    }
}
