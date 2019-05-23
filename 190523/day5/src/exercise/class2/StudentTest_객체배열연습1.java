package exercise.class2;

public class StudentTest_객체배열연습1 {

	public static void main(String[] args) {
		//생성방법 1
		Student[] students = new Student[4];
		students[0]=new Student("SW05A01",80,90,100);
		students[1]=new Student("SW05A02",70,80,90);
		students[2]=new Student("SW05A03",90,90,100);
		students[3]=new Student("SW05A04",90,90,90);
		
		for(int i=0;i<students.length;i++) {
			System.out.println("=== "+students[i].getStudentId()+"학생 점수 ====");
			System.out.println(students[i].toString());
			System.out.println("총점: "+students[i].getTotal()+"점");
			System.out.println("평균: "+students[i].getTotal()/3+"점");
			System.out.println();
		}
		
		
		//생성방법 2
//		Student[] students2 = new Student[] {
//				new Student("SW05A01",80,90,100),
//				new Student("SW05A02",70,80,90),
//				new Student("SW05A03",90,90,100),
//				new Student("SW05A04",90,90,90),
//		};
		
//		Student s1 = new Student("SW05A01",80,90,100);
//		System.out.println(s1);
		
//		System.out.print("C : " +s1.getC()+"점 ");
//		System.out.print("Linux : " +s1.getLinux()+"점 ");
//		System.out.print("Java : " +s1.getJava()+"점 \n");
		
		
	
	}

}
