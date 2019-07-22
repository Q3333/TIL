package exercise.basic.diary;

import java.util.Scanner;

public class MyDiaryTest_객체배열연습2 {

	public static int getUserInput() {
		Scanner input = new Scanner(System.in);
		return input.nextInt();
	}

	
	
	public static void main(String[] args) {
		
		MyDiary[] arr = new MyDiary[] {
				new MyDiary("데이트, ",1,5,"레스토랑"),
				new MyDiary("시험",1,7,"열공"),
				new MyDiary("찜질방",1,30,"땀빼기"),
				new MyDiary("OPEN API",5,13,"IT전문가 교육시작"),
				new MyDiary("야근",2,3),
				new MyDiary("미장원",2,20,"변신"),
				new MyDiary("영화",3,3,"쿵푸팬더"),
				
		};
		
		int inputNumber  = 0;
		
		for(;;){
			int count = 1;
			System.out.println("##월 입력 (종료 : -1) => ");
			inputNumber = getUserInput();
			for(int j=0;j<arr.length;j++) {
				if(arr[j].getMonth()==inputNumber) {
					System.out.print((count)+"."+arr[j].getMonth()+"월 ");
					System.out.print(arr[j].getDay()+"일 : "+arr[j].getTitle());
					if(arr[j].getDesc()!=null) {
						System.out.print(", "+arr[j].getDesc());
					}
					System.out.println();
					count++;
				}//if문 end
			}//for문 end
			
			if(inputNumber==-1) {
				System.out.println("프로그램을 종료합니다!!");
				break;
			}	
			if(count==1) System.out.println(inputNumber+"월에 등록된 일정이 없습니다.");
			
		}
		
		
	}

}
