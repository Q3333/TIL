package lab.java.core;

public class FinalVar {
	public int flag ; 
	public final int PORT =3000;
	public static void main(String[] args) {
		FinalVar fv = new FinalVar();
		
		
		System.out.println(fv.PORT);
		//fv.PORT=5555; final이 선언된 값은 변경 안됨
		System.out.println(fv.flag);
	}

}
