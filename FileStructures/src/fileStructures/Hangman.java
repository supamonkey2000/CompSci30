package fileStructures;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Hangman {
	private File file;
	private ArrayList<String>words = new ArrayList<>();
	private HangingMan hm;
	
	public Hangman(String FILE) {
		file = new File(FILE);
		hm = new HangingMan();
	}
	
	public void start() {
		if(!readFile()) {
			System.out.println("File \""+file.getAbsolutePath()+"\" does not exist, or an error has occured.");
			System.exit(1);
		}
		hm.displayHangingMan();
	}
	
	private boolean readFile() {
		if(!file.exists()) {
			return false;
		}
		try(BufferedReader buff = new BufferedReader(new FileReader(file))){
			String line;
			while((line = buff.readLine())!=null) {
				Pattern pt = Pattern.compile("[^a-zA-Z0-9]");
				Matcher match = pt.matcher(line);
				while(match.find()) {
					String s = match.group();
					line = line.replaceAll("\\"+s,"");
				}
				words.add(line);
				//System.out.println(line);
			}
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public static void main(String[] args) {
		Hangman hangman;
		if(args.length > 1) {
			hangman = new Hangman(args[0]);
		}else {
			hangman = new Hangman("words.txt");
			hangman.start();
		}
	}
}
