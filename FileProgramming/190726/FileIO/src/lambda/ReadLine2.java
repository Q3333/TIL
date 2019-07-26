package lambda;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Stream;

public class ReadLine2{

	public static void main (String[] args) throws Exception{
	    Stream<String> lines = Files.lines(Paths.get("c:/TTemp", "data.txt"));
	    Optional<String> hasPassword = lines.filter(s -> s.contains("password")).findFirst();
	    if(hasPassword.isPresent()){
	        System.out.println(hasPassword.get());
	    }
	    //Close the stream and it's underlying file as well
	    lines.close();

	}

}
