package maze;

public class MazeReadingException extends Exception{
	
	private String fileName;
	private int numLine;
	private String message;
	
	public MazeReadingException(String fileName, int numLine, String message) {
		super("Error at line:" + " " + numLine + " in file " + " " + fileName + " : " + message );
		this.fileName=fileName;
		this.numLine=numLine;
		this.message = message;
	}
	
	public final String getFileName() {
		return fileName;
	}

}
