
public class DeckTester {
	
	public static void main(String[] args) {
		String[] ranks1 = {"One","Two","Three","Four","Five"};
		String[] suits1 = {"Blue","Red","Green"};
		int[] points1 = {1,2,3,4,5};
		
		
		Deck deck1 = new Deck(ranks1,suits1,points1);
		int size1 = deck1.size();
		Card gimmeCard1 = deck1.deal();
		System.out.println(gimmeCard1.toString());
	}
	
}
