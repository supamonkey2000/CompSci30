package fileStructures;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Pattern;

public class WLstuff {
	
	File file = new File("WLstuffWordlist.txt"); //File object that contains the name of the wordlist
	ArrayList<String> lines = new ArrayList<>(); //Holds all the lines in the wordlist
	
	
	/*
	 * The main section of the program
	 * 
	 * Takes no parameters
	 * Returns nothing
	 */
	public void start() {
		checkFile(); //Call 'checkFile'
		readFile(); //Call 'readFile'
		Scanner scan = new Scanner(System.in);
		while(true) { //Loop through the menu
			System.out.println("1. Pick random word");
			System.out.println("2. Add new word");
			System.out.println("3. Remove a word");
			System.out.println("4. Quit");
			int option = Integer.parseInt(scan.nextLine()); //Take user input to select on option
			switch(option) {
			case 1:
				System.out.println(pickWord());
				break;
			case 2:
				addWord();
				break;
			case 3:
				removeWord();
				break;
			case 4:
				scan.close();
				System.exit(0);
			default:
				System.out.println("Nope bad option");
				break;
			}
		}
	}
	
	/*
	 * Remove a word from the list
	 * 
	 * Takes no parameters
	 * Returns nothing
	 */
	private void removeWord() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("Type your word: ");
		String remove = scan.nextLine();
		for(int i = 0; i < lines.size(); i++) { //Loop through each word in the list
			if(lines.get(i).matches(Pattern.quote(remove + ":")+"[0-9]")) { //Check if line matches the word, a colon, and ANY letter
				System.out.println("Removed " + remove);
				lines.remove(i); //........ remove it....
			}
		}
		save(); //And save the file
	}
	
	/*
	 * Add a word to the list
	 * 
	 * Takes no parameters
	 * Returns nothing
	 */
	private void addWord() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.print("Type your word: ");
		String add = scan.nextLine();
		lines.add(add+":0"); //Add the word, plus a guess count of zero
		save(); //Save the file
	}
	
	/*
	 * Saves the current wordlist to a file
	 * 
	 * Takes no parameters
	 * Returns nothing
	 * Possibly throws an exception
	 */
	private void save() {
		try(BufferedWriter buff = new BufferedWriter(new FileWriter(file))) { //Create new writers
			for(String line : lines) { //Go through every line in the list...
				buff.write(line+"\n"); //... and write them to the buffer
			}
			buff.flush(); //Save the buffer into a file
			System.out.println("Saved");
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/*
	 * Save file with an updated guess count
	 * 
	 * Takes no parameters
	 * Returns nothing
	 * Possibly throws an exception
	 */
	private void save(String update) {
		String[] split = update.split(":"); //Split the input into an array for {word,score}
		System.out.println(update);
		int index = lines.indexOf(split[0]+":"+Integer.toString(Integer.parseInt(split[1]))); //Get the index of the line
		lines.remove(index); //Remove it
		lines.add(split[0]+":"+Integer.toString(Integer.parseInt(split[1])+1)); //Add the updated version to the wordlist
		try(BufferedWriter buff = new BufferedWriter(new FileWriter(file))) { //Create new writers
			for(String line : lines) { //Go through each line in the list
				buff.write(line+"\n"); //Write them to the buffer
			}
			buff.flush();
		} catch(Exception ex) { //Catch the exception
			ex.printStackTrace(); //Print the stack trace of the exception
		}
		readFile(); //Read the file again to update the list
	}
	
	/*
	 * Picks a random word from the list
	 * 
	 * Takes no parameters
	 * Returns a string (the word)
	 */
	private String pickWord() {
		String line = lines.get(ThreadLocalRandom.current().nextInt(0, lines.size())); //Get a String from a random index in the list
		String[] split = line.split(":"); //Split it so we can actually print it
		save(line); //Save the updated line
		return split[0] + " has been guessed " + Integer.toString(Integer.parseInt(split[1]) + 1) + " times."; //Return the word to the screen
	}
	
	/*
	 * Reads the file into a list
	 * 
	 * Takes no parameters
	 * Returns nothing
	 * Possibly throws an exception
	 */
	private void readFile() {
		lines.clear(); //Clear the list
		try(BufferedReader buff = new BufferedReader(new FileReader(file))) { //Create new writers
			String line;
			while((line = buff.readLine()) != null) { //Read each line into the list until no lines remain
				lines.add(line); //Add the line to the 
			}
		} catch(Exception ex) { //Catch the exception
			ex.printStackTrace(); //Print the stack trace of the exception
		}
	}
	
	/*
	 * Check if the file is created or create it
	 * 
	 * Takes no parameters
	 * Returns nothing
	 * Possibly throws an exception
	 */
	private void checkFile() {
		try {
			if(!file.exists()) {
				file.createNewFile();
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/*
	 * Starts the program
	 */
	public static void main(String[] args) {
		new WLstuff().start();
	}	
}