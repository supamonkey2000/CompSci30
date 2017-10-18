package fileStructures;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("resource") //YES I KNOW THIS IS TERRIBlE CODING PRACTICE BUT WHATEVER

/*
 * Main Class for Hangman project
 */
public class Hangman {
	private File file = new File("words.txt"); //The wordlist file variable
	private ArrayList<String> words = new ArrayList<>(); //Arraylist that holds all the words from wordlist
	private HangingMan hm; //Object of HangingMan class, which prints the graphic to the console
	private String word; //The word the user needs to guess
	private int diff;
	private Leaderboard leaderboard;
	/*
	 * Constuctor for Hangman class
	 * 
	 * It creates HangingMan 'hm'.
	 */
	public Hangman() throws Exception {
		hm = new HangingMan();
		leaderboard = new Leaderboard();
	}
	
	/*
	 * Called by Main method as non-static Main method (?)
	 * 
	 * Throws an 'Exception' so I don't need a thousand try/catches
	 */
	public void start() throws Exception {
		if(!readFile(file.getName())) { //Call the method 'readFile()', which return whether or not the default wordlist exists
			System.out.println("File \"" + file.getAbsolutePath() + "\" does not exist, or an error has occured.");
			System.exit(1); //Exit the program with an error
		}

		int gameItem = 0; //Indicates which difficulty the user will want
		while(true) { //Loop through the menus
			hm.level = 0;
			int menuItem = menu(); //Indicates with item on the main menu the user selects
			switch(menuItem) { //Handle each case for what the user selected
			case 1: //They chose the play the game
				gameItem = playGameMenu(); //Display the Game menu where the user selects a difficulty
				break;
			case 2:
				//Leader board //This will be added later on
				break;
			case 3: //The user selected 'quit'
				System.out.println("Thanks for playing");
				Thread.sleep(2000);
				System.exit(0);
				break;
			default: //The user did not select a valid option from the menu
				System.out.println("That is an invalid option!");
			}
			if(gameItem != 0) { //The user has selected a valid difficulty, so we...
				game(gameItem);//...play the game
			}
		}
	}

	/*
	 * Displays options for game difficulties
	 * 
	 * No parameters are taken.
	 * Returns the option the user selected.
	 */
	private int playGameMenu() {
		Scanner scan = new Scanner(System.in); //Create a Scanner object (this should be dealt with globally but ayy whatevs
		System.out.println("Please enter a difficulty:");
		System.out.println("1. Easy");
		System.out.println("2. Medium");
		System.out.println("3. Hard");
		System.out.println("4. That\'s not a word");
		System.out.println("5. Custom wordlist");
		return scan.nextInt();
	}

	/*
	 * Displays options for game
	 * 
	 * No parameters are taken.
	 * Returns the option the user selected.
	 */
	private int menu() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter an option:");
		System.out.println("1. Play game");
		System.out.println("2. View leaderboards");
		System.out.println("3. Quit game");
		return scan.nextInt();
	}

	/*
	 * Loads a custom wordlist
	 */
	public void customList() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the name of your file: ");
		String input = scan.nextLine();
		readFile(input);
	}
	
	/*
	 * Deals with all gameplay
	 * 
	 * Parameter 'difficulty' is the game difficulty the user selected.
	 * Does not return anything.
	 */
	private void game(int difficulty) throws Exception {
		Scanner scan = new Scanner(System.in);
		
		int max = 0, min = 0; //'max' and 'min' are max and min word length allowed
		switch(difficulty) { // They are set in this based on 'difficulty'
		case 1: //Easy
			max = 5;
			min = 0;
			diff = 10; //10 points
			break;
		case 2: //Medium
			max = 9;
			min = 4;
			diff = 20; //20 points
			break;
		case 3: //Hard
			max = 13;
			min = 8;
			diff = 30; //30 points
			break;
		case 4: //Thats not a word
			max = 100;
			min = 12;
			diff = 40; //40 points
			break;
		case 5:
			max = Integer.MAX_VALUE;
			min = Integer.MIN_VALUE;
			diff = 0; //Custom wordlists do not add to the score
			words.clear();
			customList();
			break;
		default:
			max = Integer.MAX_VALUE;
			min = Integer.MIN_VALUE;
			break;
		}
		
		word = pickWord(min, max).toLowerCase(); //Select a word in between the minimum and maximum values
		
		ArrayList<String> guessed = new ArrayList<>(); //Holds all the letters the user has guessed
		String[] fillin = new String[word.length()]; //Represents user progress (hidden letters are '-')
		for(int i = 0; i < word.length(); i++) { //Make each value in 'fillin[]' a hyphen...
			fillin[i] = "-"; //...
		}
		
		//Start of gameplay loop
		boolean win = false; //Sets whether the user has won or not
		while(hm.level < 10) { //Repeate gameplay until user is out of guesses
			hm.displayHangingMan(); //Call Hangingman class to print the art to console
			for(int i = 0; i < fillin.length; i++) { //Print the contents of 'fillin'
				System.out.print(fillin[i]);
			}
			if(!Arrays.asList(fillin).contains("-")){ //If 'fillin' has no hyphens, that means the user has won
				win = true;
				break; //Exit from the while loop
			}
			System.out.print("\nGuessed letters: ");
			for(int i = 0; i < guessed.size(); i++) { //Display all the users guesses
				System.out.print(guessed.get(i) + " ");
			}
			System.out.print("\nGuess a letter: ");
			String guess = scan.nextLine().substring(0,1); //Take input from Scanner as the users guess
			if(!guessed.contains(guess)) { //First, check if 'guessed' does NOT contain the guess
				guessed.add(guess); //Add the guess to 'guesses'
				if(word.contains(guess)) { //Next, check if 'word' contains the guessed letter
					ArrayList<String> indexes = new ArrayList<>(); //Holds all the indexes of the guessed letter
					int index = word.indexOf(guess); //Find the first index...
					while(index >= 0) { //...and all indexes afterward
						indexes.add(Integer.toString(index));
						index = word.indexOf(guess, index + 1);
					}
					for(int i = 0; i < indexes.size(); i++) { //Iterate through each index...
						int curIndex = Integer.parseInt(indexes.get(i));
						fillin[curIndex] = guess; //...and replace 'fillin' with the guess
					}
				} else {
					hm.level++; //'word' does not have 'guess', so our "level" increases
				}
			}
		}
		if(win) {
			System.out.println("\nGood job, you won!");
			System.out.print("Enter your name: ");
			String name = scan.nextLine();
			leaderboard.add(name, diff);
		} else {
			hm.displayHangingMan();
			System.out.println("\nOh no, you lost! The word was: " + word);
		}
	}

	/*
	 * Picks a random word from the wordlist (potentially Recursive)
	 * 
	 * Parameters 'min' and 'max': the returned String must have a length inside these.
	 * Returns a String representing the word.
	 */
	private String pickWord(int min, int max) {
		int index = ThreadLocalRandom.current().nextInt(0, words.size()); //Pick a random number
		String theWord = words.get(index); //Get the word linked to that random number (the index)
		if(theWord.length() > min && theWord.length() < max) return theWord; //Return the word if the rules apply to it
		else return pickWord(min, max); //Or just run it recursively until they do
	}

	/*
	 * Read the wordlist file into 'words'
	 * 
	 * Parameter 'theFile' is the file
	 * Returns a boolean based on whether the file exists or not, or if an exception occured.
	 */
	private boolean readFile(String theFile) {
		file = new File(theFile);
		if(!file.exists()) { //Does the file exist in the first place?
			System.out.println("File does not exist!");
			return false; //No.
		}
		try(BufferedReader buff = new BufferedReader(new FileReader(file))) { //Ooh, fancy, a "try with resources"
			String line;
			while((line = buff.readLine())!=null) {
				Pattern pt = Pattern.compile("[^a-zA-Z0-9]");
				Matcher match = pt.matcher(line);
				while(match.find()) {
					String s = match.group();
					line = line.replaceAll("\\"+s,"");
				}
				words.add(line);
			}
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public static void main(String[] args) throws Exception {
		new Hangman().start(); //Start the game
	}
}
