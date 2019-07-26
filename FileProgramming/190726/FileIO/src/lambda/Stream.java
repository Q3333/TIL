package lambda;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Stream {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Files.newDirectoryStream(Paths.get("."), path -> path.toFile().isFile())
        .forEach(System.out::println);
		
		Files.newDirectoryStream(Paths.get("C:\\workspace3\\FileIO\\src\\lambda"),
		        path -> path.toString().endsWith(".java"))
		        .forEach(System.out::println);

//		final​ ​File​​[]​ files = ​new​ ​File​(​"."​).listFiles(file -> file.isHidden());
//		//or
//		final​ ​File​​[]​ files = ​new​ ​File​(​"."​).listFiles(​File​::isHidden);

		
	}

}
