package com.workshop2.test;

import java.util.Scanner;

import com.workshop2.account.Account;

public class TestAccount {
	
	//*메뉴 번호 또는 금액 입력받는 기능
	public static int getUserInput() {
		Scanner input = new Scanner(System.in);
		return input.nextInt();
	}
	
	//*메뉴 출력하고 메뉴 입력받기
	public static int getMenuItem() {
		System.out.println("[ Menu ] ");
		System.out.println("1. 입금 ");
		System.out.println("2. 출금 ");
		System.out.println("3. 종료 ");
		System.out.println("==> Menu 선택 : " );
		return getUserInput();
				
	}
	
	//*금액을 입력 받습니다.
	public static int getAmount() {
		//static 메소드에서는 non-static 변수, 객체, 메소드, 사용 불가
		return getUserInput();
		
	}


	public static void main(String[] args) {
		
		Account sjs = new Account("CUST01","소지섭","1-22-333",100000);
		int amount =0;
		int menu = 0;
	
		
		sjs.printAccount();
		
		while((menu = getMenuItem())!=9)
		switch(menu) {
		case 1: 
			System.out.print("금액 : ");
			amount = getAmount();
			System.out.println(amount+"원을 입금합니다.");
						sjs.addBalance(amount);
			System.out.println("=====================");
			System.out.println("현재 잔액 : " + sjs.getBalance());
			System.out.println("=====================");
			break;
			
		case 2:
			System.out.print("금액 : ");
			amount = getAmount(); 
			System.out.println(amount+"원을 출금합니다.");
			sjs.subtractBalance(amount);
			System.out.println("=====================");
			System.out.println("현재 잔액 : " + sjs.getBalance());
			System.out.println("=====================");
			break;
			
		
	} // switch end
		System.out.println("Bye~~");
		
	} // main end

} // class end


