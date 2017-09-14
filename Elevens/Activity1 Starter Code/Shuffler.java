
public class Shuffler {
	
	public static void main(String[] args) {
		String[] ranks = {"1","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
		int[] pointValues = {1,2,3,4,5,6,7,8,9,10,11,12,13};
		String[] suits = {"Spades","Hearts","Diamonds","Clubs"};
		Deck testDeck = new Deck(ranks, suits, pointValues);
		System.out.println(testDeck.size());
	}
	
	public void perfectShuffle() {
		
	}
	
	public void selectionShuffle() {
		
	}
}
