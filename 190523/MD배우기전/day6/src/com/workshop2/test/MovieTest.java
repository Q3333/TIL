package com.workshop2.test;

import com.workshop2.entity.Movie;

public class MovieTest {

	public static void main(String[] args) {
		
		Movie[] m = new Movie[] {
			new Movie("반지의 제왕 - 반지 원정대","피터 잭슨","판타지, 모험",
					"일라이저 우드",2001,178,"12세 관람가"),
			new Movie("트랜스포머 : 패자의 역습","마이클 베이","SF, 액션",
					"샤이아 라보프",2009,149),
			new Movie("러브 액츄얼리","리처드 커티스","멜로, 드라마",
					"앨런 릭맨 등",2003,134,"15세 관람가"),
			new Movie("쿵푸 팬더","마크 오스본","애니메이션","잭 블랙","12세 관람가")
			};
		
		System.out.println("<< 전체 영화 정보 조회 >>");
		System.out.println("----------------------------------------------------------------------");
		System.out.printf("%13s %18s %9s %9s %9s %9s %10s","제목","감독","장르","주연","개봉년도","런타임","등급\n");
		System.out.println("----------------------------------------------------------------------");
		for(int i = 0 ; i<m.length ; i++) {
			System.out.printf("%15s %12s %15s %15s ",m[i].getTitle(),m[i].getDirector(),m[i].getGenre(),m[i].getActor());
			if(m[i].getReleaseYear()!=0)System.out.printf("%6d년",m[i].getReleaseYear());
			if(m[i].getRunTime()!=0)System.out.printf("%5d분",m[i].getRunTime());
			if(m[i].getRating()!=null)System.out.printf("%10s",m[i].getRating());
			System.out.println();
			
		}
		System.out.println("----------------------------------------------------------------------");
		System.out.println("<< 2005년 이전 개봉작 조회 >>");
		System.out.println("----------------------------------------------------------------------");
		System.out.printf("%13s %18s %9s %9s %9s %9s %10s","제목","감독","장르","주연","개봉년도","런타임","등급\n");
		System.out.println("----------------------------------------------------------------------");
		for(int i = 0 ; i<m.length ; i++) {
			if(m[i].getReleaseYear()<2005) {
				System.out.printf("%15s %12s %15s %15s ",m[i].getTitle(),m[i].getDirector(),m[i].getGenre(),m[i].getActor());
				if(m[i].getReleaseYear()!=0)System.out.printf("%6d년",m[i].getReleaseYear());
				if(m[i].getRunTime()!=0)System.out.printf("%5d분",m[i].getRunTime());
				if(m[i].getRating()!=null)System.out.printf("%10s",m[i].getRating());
				System.out.println();
			}
				
			System.out.println();	
		}
		System.out.println();
		
		System.out.println("----------------------------------------------------------------------");
		System.out.println("<< 애니메이션 개봉작 조회 >>");
		System.out.println("----------------------------------------------------------------------");
		System.out.printf("%13s %18s %9s %9s %9s %9s %10s","제목","감독","장르","주연","개봉년도","런타임","등급\n");
		System.out.println("----------------------------------------------------------------------");
		for(int i = 0 ; i<m.length ; i++) {
			if(m[i].getGenre()=="애니메이션") {
				System.out.printf("%18s %12s %15s %15s ",m[i].getTitle(),m[i].getDirector(),m[i].getGenre(),m[i].getActor());
				if(m[i].getReleaseYear()!=0)System.out.printf("%6d년",m[i].getReleaseYear());
				if(m[i].getRunTime()!=0)System.out.printf("%5d분",m[i].getRunTime());
				if(m[i].getRating()!=null)System.out.printf("%10s",m[i].getRating());
				System.out.println();
			}
			
			
		}
		System.out.println();
		
		System.out.println("----------------------------------------------------------------------");
		System.out.println("<< 런타임 140분 이상 영화 조회 >>");
		System.out.println("----------------------------------------------------------------------");
		System.out.printf("%13s %18s %9s %9s %9s %9s %10s","제목","감독","장르","주연","개봉년도","런타임","등급\n");
		System.out.println("----------------------------------------------------------------------");
		for(int i = 0 ; i<m.length ; i++) {
			if(m[i].getRunTime()>=140) {
//				System.out.print(m[i].getTitle() + "	" +m[i].getDirector()+ "	"
//							+m[i].getGenre() + "	" +m[i].getActor());
				System.out.printf("%25s %12s %15s %15s ",m[i].getTitle(),m[i].getDirector(),m[i].getGenre(),m[i].getActor());
				if(m[i].getReleaseYear()!=0)System.out.printf("%6d년",m[i].getReleaseYear());
				if(m[i].getRunTime()!=0)System.out.printf("%5d분",m[i].getRunTime());
				if(m[i].getRating()!=null)System.out.printf("%10s",m[i].getRating());
				System.out.println();
			}
			
			
		}
		
		//System.out.printf("%13s %8s %10s %8s ",m[0].getTitle(),m[0].getDirector(),m[0].getGenre(),m[0].getActor());
		
		
		//m[0].getReleaseYear(),m[0].getRunTime(),
		//System.out.printf(%4d,m[i].getReleaseYear()+"년") %3d %8s
	
	} // main end

	} // class end
