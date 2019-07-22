package erercise.overall.hero;

public abstract class Hero implements CanFly, CanSwim, CanFight {
	
	public void fly() {
		System.out.println(this.toString()+"이 난다.");
	}
	public void fight() {
		System.out.println(this.toString()+"이 헤엄친다");
	}
	public void swim() {
		System.out.println(this.toString()+"이 싸운다.");
	}
	abstract void action();
	
	
}
