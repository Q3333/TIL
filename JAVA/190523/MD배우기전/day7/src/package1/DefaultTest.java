package package1;


class Other { // 상속받지 않은 other가 속성값 변경 가능
	public void access() {
		Parent p = new Parent();
		System.out.println(p.name);// 속성 읽기
		p.name = "other"; // 속성값 변경
		System.out.println(p.name);// 변경된 name 확인
		
	
	}
}

public class DefaultTest {

	public static void main(String[] args) {
		Other o = new Other();
		o.access();
		Child c = new Child();
		c.access();
	}

}
