package default_package;

import maze.FileNotFoundException;
import maze.MazeReadingException;
import mazeUI.*;

public class Main {

	public static void main(String[] args) {
		try {
			new MazeApplication();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (MazeReadingException e) {
			e.printStackTrace();
		}

	}

}
