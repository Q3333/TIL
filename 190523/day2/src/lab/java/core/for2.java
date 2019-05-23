package lab.java.core;

public class for2 {

	public static void main(String[] args) {
		// 이중 for문
		for(int r=1; r<4; r++) {//행개수, 3행
			for(int c=1;c<4;c++) {//열개수, 3열
				System.out.print("("+r+","+c+") ");
			}
			System.out.println();
		}

		
		for(int r=1; r<4; r++) {//행개수, 3행
			for(int c=1;c<4;c++) {//열개수, 3열
				System.out.print("* ");
			}
			System.out.println();
		}
		
		
		for(int r=1; r<6; r++) {//행개수, 3행
			for(int c=1;c<=r;c++) {//열개수, 3열
				System.out.print("* ");
			}
			System.out.println();
		}
		

}
}

///앞의 1은 r값, 뒤의 1은 c값. (r,c) (r,c+1) (r,c+2) 순