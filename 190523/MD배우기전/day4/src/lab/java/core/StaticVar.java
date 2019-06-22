package lab.java.core;

public class StaticVar {
	public static int tickets = 500;
	public static void main(String[] args) { //main문은 StaticVar의 메소드가아님)
		System.out.println(tickets); // 같은 static이라서 참조변수가 아니라도 접근 가능.
		tickets-=5;
		System.out.println(StaticVar.tickets);//클래스 변수
		
		StaticVar sv = new StaticVar(); // 객체 생성
		System.out.println(sv.tickets);//495, 새로 생성된 변수도 같은 값을 공유함.
		sv.tickets -=10;
		
		StaticVar sv2 = new StaticVar();
		System.out.println(sv.tickets);
		System.out.println(sv2.tickets);
		sv2.tickets -= 20;
		
		sv = new StaticVar();
		System.out.println(sv.tickets);
		System.out.println(sv2.tickets);
	}

}
