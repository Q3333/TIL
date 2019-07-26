package lambda;


//여기 아래부터 복사해서 CMD에서 실행시켜야함.
import java.io.Console;

public class UsingConsoleReader {

	public static void main(String[] args) {
		  Console console = null;
		  String inputName = null;
		char[] inputPasswd = null;
		  try  {
		     //  콘솔 객체 생성
		     console = System.console();
		     // if console is not null
		     System.out.println(console);
		     if (console != null)     {
		        // 사용자로부터 이름 입력 받음
		        inputName = console.readLine("Name: ");
		        System.out.println("Name entered : " + inputName);
		        
		        inputPasswd = console.readPassword("Password : ");
		        // prints
		        System.out.println("Name entered : " + inputPasswd);
		     }
		  } catch (Exception ex)  {
		     ex.printStackTrace();
		  }


	}

}
