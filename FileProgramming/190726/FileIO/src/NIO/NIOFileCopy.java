package NIO;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class NIOFileCopy {
	public static void main(String[] args) throws Exception {
		Path sourceFile = Paths.get("C:/test/dept.txt");
		Path targetFile = Paths.get("C:/test/copycat.txt");		
		
		
		try {
			Files.copy(sourceFile, targetFile,
					StandardCopyOption.REPLACE_EXISTING);
					System.out.println("copy completed!");;
		} catch (IOException ex) {
			System.err.format("I/O Error when copying file");
		}
		
	}     
	 
}
