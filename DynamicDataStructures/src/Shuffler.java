import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Shuffler {
	
	public static void main(String[] args) {
		Shuffler shuffler = new Shuffler();
		shuffler.go();
	}
	
	@SuppressWarnings("unused")
	public void go() {
		String[] ranks = {"1","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
		int[] pointValues = {1,2,3,4,5,6,7,8,9,10,11,12,13};
		String[] suits = {"Spades","Hearts","Diamonds","Clubs"};
		Deck mainDeck = new Deck(ranks, suits, pointValues);
		Deck perfectDeckOriginal = new Deck(ranks, suits, pointValues);
		Deck selectionDeckOriginal = new Deck(ranks, suits, pointValues);
		Deck perfectDeck = perfectShuffle(perfectDeckOriginal);
		Deck selectionDeck = selectionShuffle(selectionDeckOriginal);
		
		
		
		for(int i = 0; i < 52; i++) {
			System.out.print(mainDeck.deal().rank()+", ");
		}
		System.out.println("");
		for(int i = 0; i < 52; i++) {
			System.out.print(selectionDeck.deal().rank()+", ");
		}
	}
	
	public Deck perfectShuffle(Deck startDeck) {
		ArrayList<Card>cardshalf1 = new ArrayList<>();
		ArrayList<Card>cardshalf2 = new ArrayList<>();
		ArrayList<Card>returncards = new ArrayList<>();
		int halfsize = startDeck.size() / 2;
		for(int i = 0; i < halfsize; i++) {
			Card tmpCard = startDeck.deal();
			cardshalf1.add(tmpCard);
		}
		for(int i = 0; i < halfsize; i++) {
			Card tmpCard = startDeck.deal();
			cardshalf2.add(tmpCard);
		}
		for(int i = 0; i < cardshalf1.size(); i++) {
			returncards.add(cardshalf1.get(i));
			returncards.add(cardshalf2.get(i));
		}
		return new Deck(returncards);
	}
	
	public Deck selectionShuffle(Deck startDeck) {
		ArrayList<Card>newDeckAL=new ArrayList<>();
		int size = startDeck.size();
		for(int k = 0; k < size; k++) {
			Card tmpCard = null;
			while(tmpCard==null) {
				int j = ThreadLocalRandom.current().nextInt(0,51);
				tmpCard = startDeck.select(j);
				//System.out.println(j);
			}
			newDeckAL.add(tmpCard);
			//System.out.println("Found card for index " + k);
		}
		System.out.println(newDeckAL.size());
		return new Deck(newDeckAL);
	}
}
