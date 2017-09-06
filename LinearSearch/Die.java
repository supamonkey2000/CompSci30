import java.lang.Math;

public class Die {
	private int sides;
	
	public Die(){
		sides = 6;
	}
	public Die(int newsides) {
		sides = newsides;
	}
	
	public int rollDie() {
		return (int)(Math.random()*sides+1);
	}
}