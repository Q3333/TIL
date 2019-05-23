package com.lg.workshop2.lotto;

public class TestLotto {

	public static void main(String[] args) {
		Lotto a = new Lotto();
		int num[] = new int[a.LOTTO_NUM_CNT];
		num=a.generateLottoNumbers();
		
		
		
		a.sortLottoNumbers(num);
		a.displayLottoNumbers(num);
		
		
		
	}

}
