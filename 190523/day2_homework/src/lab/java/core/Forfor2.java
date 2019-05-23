package lab.java.core;

public class Forfor2 {

	public static void main(String[] args) {
		for(int r=1; r<6; r++) {//행개수, 3행
			for(int c=1;c<=r;c++) {//열개수, 3열
				System.out.print("* ");
			}
			System.out.println();
		}
	
		for(int r=1; r<6; r++) {//행개수, 3행
			for(int c=1;c<=6-r;c++) {//열개수, 3열 혹은 c=6;c>r;c-- 
				System.out.print("* ");
			}
			System.out.println();
		}
		
		
		
	}
}
