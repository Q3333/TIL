package erercise.overall.hero;

import java.util.Arrays;

public class HeroTest {

	public static void main(String[] args) {
		Hero[] heros = new Hero[] {
				new SuperMan(),
				new BatMan(),
				new SpiderMan() };
	
		System.out.print("Hero ¸ñ·Ï : ");
		System.out.println(Arrays.toString(heros));
		
		for(Hero num : heros) {
			num.action();
		}
	
	
	}	// main end

} // class end


