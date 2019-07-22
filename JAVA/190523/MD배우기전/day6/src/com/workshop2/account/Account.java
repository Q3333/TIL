package com.workshop2.account;

import java.util.Scanner;

public class Account {
	private String custid;
	private String custName;
	private String accountNumber;
	private int balance;
	
	
	
	public Account(){
		
	}
	public Account(String custId, String custName, String accountNumber, int balance){
		this.custid = custId;
		this.custName = custName;
		this.accountNumber = accountNumber;
		this.balance = balance;
		if(balance<1) {
			System.out.println("잔액 오류입니다. : 0원");
			System.exit(0); //0을 넣으면 정상종료, -1을 넣으면 비정상종료
		}
		
	}
	
	public String getCustId() {return this.custid;}
	public void setCustID(String custId) {this.custid=custId;}
	
	public String getCustName() {return this.custName;}
	public void setCustName(String custName) {this.custName=custName;}
	
	public String getAccountNumber() {return this.accountNumber;}
	public void setAccountNumber(String accountNumber) {this.accountNumber=accountNumber;}
	
	public int getBalance() {return this.balance;}
	public void setBalance(int balance) {this.balance=balance;}
	
	public void addBalance(int amount) {
		
		if(amount>= 1)this.balance += amount;
		else if(amount<1) System.out.println("금액 오류입니다. : 0원");
		
	}
	public void subtractBalance(int amount) {
		
		if(amount>= 1) {
			if(balance>=amount) this.balance -= amount;		
			else {
				System.out.println("출금 불가!! 잔금 부족입니다.");
			}
		}
		else if(amount<1) System.out.println("금액 오류입니다. : 0원");
		
	}
	public void printAccount() {
		System.out.println("=====================");
		System.out.println("고객 번호 : "+getCustId());
		System.out.println("고객명 : "+getCustName());
		System.out.println("계좌번호 : "+getAccountNumber());
		System.out.println("잔액: "+getBalance() +"원");
		System.out.println("=====================");
		
	}
	
	
}
