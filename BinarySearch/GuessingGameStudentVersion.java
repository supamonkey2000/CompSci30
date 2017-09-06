import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
/**
 * This program can guess the number you are thinking of!
 * 
 * source:
 * https://www.khanacademy.org/computing/computer-science/
 * algorithms/binary-search/a/implementing-binary-search-of-an-array
 * 
 * change the code to make it work.
 * 
 * Hint: Click 
 * 			Window-> Show View -> Tasks
 * To see the notes I left you.
 *  
 */
public class GuessingGameStudentVersion {
	private static int[] numbers;
	
	//the max number that can be guessed
	private static final int N = 100;
	
	public static ArrayList<Integer> checked = new ArrayList<>();

	public static int checkCurrentGuess(int min,int max) {
		int returnThis = 0;
		
		
		while(true) {
			int g = ThreadLocalRandom.current().nextInt(min,max);
			if(!checked.contains(g)) {
				returnThis = g;
				break;
			}
		}
		
		return returnThis;
	}
	
	public static void main(String[] args) {
		int guesscounter = 0;
		
		System.out.println("Think of a number between 1 and "+N);
		try {
			Thread.sleep(3000);
		}catch(Exception ex) {}
		
		createOrderedArray(N);
		
		int minindex = 1;
		int maxindex = N;
		
		int guess;
		boolean checkguess = false;
		Scanner userinput = new Scanner(System.in);

		do {
			guess = 0;
			
			guess = checkCurrentGuess(minindex,maxindex);
			
			System.out.println("Is your number: " + guess + "? (y/n)");
			if ("y".equalsIgnoreCase(userinput.next())) {
				checkguess = true;
			} else {
				checked.add(guess);
				System.out.println("Is " + guess +" too high or too low? (H/L)");
				String highlow = userinput.next();
				if (highlow.equalsIgnoreCase("h")){
					maxindex = guess;
					/*TODO replace with code*/
					//HIGH
					
				} else {
					minindex = guess;
					/*TODO replace with code*/
					//LOW
			
				}
			}
			guesscounter++;
		}while (!checkguess);

		System.out.println("Your number was guessed in " +guesscounter+ " attempts!");
		userinput.close();
	}


	private static void createOrderedArray(int n) {
		numbers = new int[n];
		for (int i = 0; i < n; ++i) {
			numbers[i] = i;
		}
	}


}