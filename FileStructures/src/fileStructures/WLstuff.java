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
	
	private void removeWord() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Type your word: ");
		String remove = scan.nextLine();
		for(int i = 0; i < lines.size(); i++) {
			if(lines.get(i).matches(Pattern.quote(remove + ":")+"[0-9]")) {
				System.out.println("Removed " + remove);
				lines.remove(i);
			}
		}
		save();
	}
	
	private void addWord() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Type your word: ");
		String add = scan.nextLine();
		lines.add(add+":0");
		save();
	}
	
	private void save() {
		try(BufferedWriter buff = new BufferedWriter(new FileWriter(file))) {
			for(String line : lines) {
				buff.write(line+"\n");
			}
			buff.flush();
			System.out.println("Saved");
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	private void save(String update) {
		String[] split = update.split(":");
		System.out.println(update);
		int index = lines.indexOf(split[0]+":"+Integer.toString(Integer.parseInt(split[1])));
		lines.remove(index);
		lines.add(split[0]+":"+Integer.toString(Integer.parseInt(split[1])+1));
		try(BufferedWriter buff = new BufferedWriter(new FileWriter(file))) {
			for(String line : lines) {
				buff.write(line+"\n");
			}
			buff.flush();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		readFile();
	}
	
	private String pickWord() {
		String line = lines.get(ThreadLocalRandom.current().nextInt(0, lines.size()));
		String[] split = line.split(":");
		save(line);
		return split[0] + " has been guessed " + Integer.toString(Integer.parseInt(split[1]) + 1) + " times.";
	}
	
	private void readFile() {
		lines.clear();
		try(BufferedReader buff = new BufferedReader(new FileReader(file))){
			String line;
			while((line = buff.readLine()) != null) {
				lines.add(line);
			}
		} catch(Exception ex) {
			System.out.println("hoover dam");
		}
	}
	
	private void checkFile() {
		try {
			if(!file.exists()) {
				file.createNewFile();
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new WLstuff().start();
	}	
}