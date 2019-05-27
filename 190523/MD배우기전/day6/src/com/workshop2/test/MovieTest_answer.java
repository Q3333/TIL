package com.workshop2.test;

import com.workshop2.entity.Movie;

public class MovieTest_answer {

	public static void main(String[] args) {
		Movie[] movies = new Movie[] {
			new Movie("반지의 제왕 - 반지 원정대","피터 잭슨","판타지, 모험",
						"일라이저 우드",2001,178,"12세 관람가"),
			new Movie("트랜스포머 : 패자의 역습","마이클 베이","SF, 액션",
					"샤이아 라보프",2009,149),
			new Movie("러브 액츄얼리","리처드 커티스","멜로, 드라마",
					"앨런 릭맨 등",2003,134,"15세 관람가"),
			new Movie("쿵푸 팬더","마크 오스본","애니메이션","잭 블랙","12세 관람가")
		};
	
		System.out.println("<< 전체 영화 정보 조회 >>");
		
		

	}
	
	public static void printTitle2() {
	System.out.println("----------------------------------------------------------------------");
	System.out.printf("\t제목\t\t 감독\t 장르\t주연\t개봉년도 런타임\n");
	System.out.println("----------------------------------------------------------------------");
	}
}
