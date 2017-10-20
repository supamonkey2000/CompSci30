package fileStructures;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Leaderboard {
	
	private ArrayList<String> names = new ArrayList<>();
	private ArrayList<Integer> scores = new ArrayList<>();
	private File file = new File("leaderboard.hmn");
	
	public Leaderboard() {
		try {
			if(!file.exists()) {
				file.createNewFile();
			}
		}catch(Exception ex){}
		try(BufferedReader buff = new BufferedReader(new FileReader(file))){
			String line;
			while((line = buff.readLine()) != null) {
				String[] split = line.split(" :: ");
				names.add(split[0].trim());
				scores.add(Integer.parseInt(split[1].trim()));
			}
		}catch(Exception ex) {
			//nothing?
		}
	}
	
	public void display() {
		System.out.println("\nLeaderboard");
		for(int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i) + ": " + scores.get(i));
		}
		System.out.println("");
	}
	
	public void add(String name, int score) {
		boolean added = false;
		if(names.contains(name)) {
			int index = names.indexOf(name);
			score = score + scores.get(index);
			for(int i = 0; i < scores.size(); i++) {
				if(score > scores.get(i)) {
					scores.add(i,score);
					names.add(i,name);
					index = names.lastIndexOf(name);
					names.remove(index);
					scores.remove(index);
					added = true;
					break;
				}
			}
			if(!added) {
				scores.set(index, score);
				added = true;
			}
		} else {
			for(int i = 0; i < scores.size(); i++) {
				if(score > scores.get(i)) {
					scores.add(i,score);
					names.add(i,name.trim());
					added = true;
					break;
				}
			}
		}
		if(!added) {
			names.add(name);
			scores.add(score);
		}
		save();
	}
	
	private void save() {
		try(BufferedWriter buff = new BufferedWriter(new FileWriter(file))){
			for(int i = 0; i < names.size(); i++) {
				buff.write(names.get(i) + " :: " + Integer.toString(scores.get(i)) + "\n");
			}
			buff.flush();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
