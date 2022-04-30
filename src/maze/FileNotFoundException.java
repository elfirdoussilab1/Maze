package maze;

public final class FileNotFoundException extends Exception{
	
	private String fileName;
	
	public FileNotFoundException(String fileName) {
		super(fileName + " not found " );
		this.fileName=fileName;
	}
	
}