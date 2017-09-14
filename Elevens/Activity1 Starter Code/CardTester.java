/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 1 *** */
		Card AceSpades = new Card("Ace", "Space", 50);
		Card QueenHearts = new Card("Queen","Hearts",100);
		
		boolean test = AceSpades.matches(QueenHearts);
		if(test) {
			System.out.println(AceSpades.toString() + " is equal to " + QueenHearts.toString());
		}
		else {
			System.out.println(AceSpades.toString() + " is NOT equal to " + QueenHearts.toString());
		}
	}
}
