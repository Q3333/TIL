package lab.java.core;

public class Continue {

	public static void main(String[] args) {
		a1: // label, a1, 해당 위치를 저장
		for(int i=0;i<3;i++) {
			a2: // label, a2
			for(int j=0;j<3;j++) {
				//if(j==1) continue;
				if(j==1)break a1;
				System.out.println("i="+i+", j="+j);
			}
		}
	
		for(int i=1;i<=10;i++) {
			if(i%2!=0)continue; //선생님답 i%2==1;, Systemout.println(num++)[while문num<11]
			System.out.println(i);
		}
	
	} //main end

} // class end
