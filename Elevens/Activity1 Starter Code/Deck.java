import java.util.ArrayList;

public class Deck {
	
	private ArrayList<Card> cards = new ArrayList<>();
	private ArrayList<Card> dealt = new ArrayList<>();
	
	public Deck(String[] theRanks, String[] theSuits, int[]thePointValues) {
		for(int ia = 0; ia < theRanks.length; ia++) {
			String currentRank = theRanks[ia];
			for(int ib = 0; ib < theSuits.length; ib++) {
				String currentSuit = theSuits[ib];
				int currentPointValue = thePointValues[ia];
				Card newCard = new Card(currentRank, currentSuit, currentPointValue);
				cards.add(newCard);
			}
		}
		
		//Shuffle code (activity 4)
	}
	
	public Deck(ArrayList<Card>newcards) {
		cards.addAll(newcards);
	}
	
	public int size() {
		return cards.size();
	}
	
	public boolean isEmpty() {
		if(cards.size()==0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public Card deal() {
		if(size() != 0) {
			Card dealtCard = cards.get(cards.size()-1);
			dealt.add(dealtCard);
			cards.remove(cards.size()-1);
			return dealtCard;
		}
		else {
			return null;
		}
	}
	
	public Card select(int index) {
		if(size() != 0) {
			try {
				Card dealtCard = cards.get(index);
				dealt.add(dealtCard);
				cards.remove(index);
				return dealtCard;
			}catch(IndexOutOfBoundsException ex) {return null;}
		}
		else {
			return null;
		}
	}
	
}