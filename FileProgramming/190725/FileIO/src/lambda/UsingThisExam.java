package lambda;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class UsingThisExam { 
    public static void main(String[] args) {
        UsingThis usingThis = new UsingThis();
        UsingThis.Inner inner = usingThis.new Inner();
        inner.method();
    
        List<String> list = Arrays.asList("John", "Simons", "Andy");
        Stream<String> stream = list.stream(); 
        stream.forEach( name -> System.out.println(name) );

//        
//        Files.newDirectoryStream(Paths.get("."),
//                path -> path.toString().endsWith(".java"))
//                .forEach(System.out::println);


    } 
}
