package fileStructures;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/*
 * Handles leaderboard.hmn file, and displays the leaderboard to the screen
 * 
 */
public class Leaderboard {
	
	private ArrayList<String> names = new ArrayList<>(); //Holds the list of names on the leaderboard
	private ArrayList<Integer> scores = new ArrayList<>(); //Holds the list of scores on the leaderboard
	private File file = new File("leaderboard.hmn");
	
	/*
	 * Constructor for Leaderboard class
	 * Reads the leaderboard.hmn file (or creates it if it does not exist)
	 * 
	 * Takes no parameters
	 */
	public Leaderboard() {
		try {
			if(!file.exists()) { //Make sure the leaderboard exists, or create a new one if it doesn't
				file.createNewFile();
			}
		} catch(Exception ex) {
			System.out.println("WARN: Could not create new leaderboard.hmn!");
		}
		try(BufferedReader buff = new BufferedReader(new FileReader(file))) { //Create Readers for reading the leaderboard.hmn file
			String line;
			while((line = buff.readLine()) != null) { //Read each line into the ArrayLists until no lines remain
				String[] split = line.split(" :: "); //In the file, a line is formatted like "<name> :: <score>". This code splits the line into the lists
				names.add(split[0].trim()); //Add the name to the names list, removing any leading or trailing Newlines or whitespace
				scores.add(Integer.parseInt(split[1].trim())); //Do the same with the score, but parse the entry as an integer
			}
		} catch(Exception ex) { //Some sort of error occured
			System.out.println("WARN: An error occured when reading the file: " + ex.getMessage());
		}
	}
	
	/*
	 * Displays the leaderboard to the screen
	 * 
	 * Takes no parameters
	 * Returns nothing
	 */
	public void display() {
		System.out.println("\nLeaderboard");
		for(int i = 0; i < names.size(); i++) { //Print each entry in the Lists (this cannot be a for-each since we are dealing with multiple lists)
			System.out.println(names.get(i) + ": " + scores.get(i));
		}
		System.out.println("");
	}
	
	/*
	 * Add a new player to the leaderboard
	 * 
	 * Parameter 'name' is the player name
	 * Parameter 'score' is the player score
	 * Returns nothing
	 */
	public void add(String name, int score) {
		boolean added = false; //This will be important later on, so we do not add the user multiple times
		
		//First, check if the leaderboard already has that player name. If they do then we increase the existing score
		if(names.contains(name)) {
			int index = names.indexOf(name); //Get the index of the players name. This is used for retrieving the score and replacing the score
			score = score + scores.get(index); //Add the new points to the total score
			
			//We want to check each other entry in the leaderboard, and see if the new score is higher than other entries
			for(int i = 0; i < scores.size(); i++) { //We will run the loop for every item (again, this cannot be a for-each as explained above)
				if(score >= scores.get(i)) { //If the new score is higher than the current indexed score, we want to...
					scores.add(i,score); //Add the score in the specific index 'i'
					names.add(i,name); //Add the name in the specific index 'i'
					index = names.lastIndexOf(name); //Get the index of the players previous (and lower scoring) entry
					names.remove(index); //Remove the entry at that index
					scores.remove(index); //And again remove it
					added = true; //We have added the score (this is important for down below)
					break; //Exit the for loop so we dont add the entry multiple times
				}
			}
			
			//After the for loop, if the score has not been added yet, then the entry is at the bottom of the list...
			if(!added) {
				scores.set(index, score); //... so we just need to update the score and not the name
				added = true; //This has been explained above
			}
			
		//The player is not already in the list so we need to make a new entry for them
		} else {
			for(int i = 0; i < scores.size(); i++) { //Like above, we want to check if the score is higher than any of the current entries
				if(score >= scores.get(i)) { //If it is, then we add the score at that index
					scores.add(i,score);
					names.add(i,name.trim());
					added = true;
					break;
				}
			}
		}
		
		//This only runs if the above instructions did not add the score. I.e., the player is the first one to win a game
		if(!added) {
			names.add(name);
			scores.add(score);
		}
		save(); //Save the leaderboard to leaderboard.hmn file
	}
	
	/*
	 * Saves the current leaderboard to leaderboard.hmn file
	 * 
	 * Takes no parameters
	 * Returns nothing
	 */
	private void save() {
		try(BufferedWriter buff = new BufferedWriter(new FileWriter(file))) { //Create Writers to save the file
			for(int i = 0; i < names.size(); i++) { //Go through every leaderboard entry
				buff.write(names.get(i) + " :: " + Integer.toString(scores.get(i)) + "\n"); //Add it to the buffer
			}
			buff.flush(); //Save the buffer (for crying out loud they could have picked .save(), .flush() just sounds weird)
		} catch(Exception ex) {
			System.out.println("WARN: An error occured saving the Leaderboard: " + ex.getMessage());
		}
	}
}