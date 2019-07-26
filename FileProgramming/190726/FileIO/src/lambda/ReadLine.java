package lambda;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ReadLine{

	public static void main (String[] args) throws Exception{
		File file = new File("c:/TTemp/data.txt");
	    FileReader fr = new FileReader(file);
	    BufferedReader br = new BufferedReader(fr);
	    String line;
	    while((line = br.readLine()) != null){
	        if(line.contains("password")){
	            System.out.println(line);
	        }
	    }
	    br.close();
	    fr.close();

	}

}
