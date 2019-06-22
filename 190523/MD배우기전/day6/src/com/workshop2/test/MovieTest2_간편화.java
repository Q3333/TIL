package com.workshop2.test;

import com.workshop2.entity.Movie;

public class MovieTest2_간편화 {

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
		m[0].printTitle();
		for(int i = 0 ; i<m.length ; i++) {
			m[i].printContent(m[i]);
			}
		System.out.println("----------------------------------------------------------------------");
		System.out.println("<< 2005년 이전 개봉작 조회 >>");
		m[0].printTitle();
		for(int i = 0 ; i<m.length ; i++) {
			if(m[i].getReleaseYear()<2005) {
				m[i].printContent(m[i]);
			}
				
			System.out.println();	
		}
		System.out.println();
		
		System.out.println("----------------------------------------------------------------------");
		System.out.println("<< 애니메이션 개봉작 조회 >>");
		m[0].printTitle();
		for(int i = 0 ; i<m.length ; i++) {
//			if(m[i].getGenre()=="애니메이션") { //이 경우 주소값 비교가 됨
			if(m[i].getGenre().contentEquals("애니메이션")){ // 이 경우가 스트링비교
				m[i].printContent(m[i]);
			}
			
			
		}
		System.out.println();
		
		System.out.println("----------------------------------------------------------------------");
		System.out.println("<< 런타임 140분 이상 영화 조회 >>");
		m[0].printTitle();
		for(int i = 0 ; i<m.length ; i++) {
			if(m[i].getRunTime()>=140) {
				m[i].printContent(m[i]);
			}
			
			
		}
		
		
	
	} // main end

	} // class end
