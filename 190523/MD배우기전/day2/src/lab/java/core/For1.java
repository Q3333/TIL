package lab.java.core;

public class For1 {

	public static void main(String[] args) {
		for(int i=1; i<=10; i++) {
			System.out.println(i);
		}



//1. 1~10까지 누적합
int sum =0;
for(int i=1;i<=10;i++) {
	sum= sum+i;
}

System.out.println("누적합 = " + sum );

//2. 1~10까지 홀수만 출력
for(int i=1;i<=10;i++) {
	if(i%2!=0)System.out.println(i);
}

//3. 1~10까지 홀수를 역순으로 출력
for(int i=10;i>0;i--) {
	if(i%2!=0)System.out.println(i);
}

//4. A~Z까지 출력
for(char ch = 'A';ch<='Z';ch++) {
	System.out.print(ch+" ");
}

//5. A~Z까지 역순으로 출력
for(char ch = 'Z';ch>='A';ch--) {
	System.out.print(ch+" ");
}

}
}