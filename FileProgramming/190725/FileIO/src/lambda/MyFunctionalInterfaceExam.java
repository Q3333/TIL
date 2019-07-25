package lambda;

public class MyFunctionalInterfaceExam {
	
	public static void main(String[] args) {
        MyFunctionalInterface fi; 
        fi = () -> {    //인터페이스를 타켓 타입으로 갖는 람다식
            String str = "method call1";
            System.out.println(str);
        }; 
        fi.method();                 //람다식 호출
        fi = () -> {   
            System.out.println("method call2");
        };
        fi.method(); 
        fi = () -> System.out.println("method call3");
        fi.method();
        
        
        System.out.println("매개변수를 가진 람다식 호출");
        fi = () -> {    //인터페이스를 타켓 타입으로 갖는 람다식
            String str = "method call1";
            System.out.println(str);
        }; 
        fi.method();                 //람다식 호출
        fi = () -> {   
            System.out.println("method call2");
        };
        fi.method(); 
        fi = () -> System.out.println("method call3");
        fi.method();

        
    } 
	
	
	
}
