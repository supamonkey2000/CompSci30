package fileStructures;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Leaderboard {
	
	private ArrayList<String> names = new ArrayList<>();
	private ArrayList<Integer> scores = new ArrayList<>();
	private File file = new File("leaderboard.hmn");
	
	public Leaderboard() throws Exception {
		if(!file.exists()) {
			file.createNewFile();
		}
		try(BufferedReader buff = new BufferedReader(new FileReader(file))){
			String line;
			while((line = buff.readLine()) != null) {
				String[] split = line.split("::");
				names.add(split[0].trim());
				scores.add(Integer.parseInt(split[1].trim()));
			}
		}
	}
	
	public void add(String name, int score) {
		boolean added = false;
		for(int i = 0; i < scores.size(); i++) {
			if(score > scores.get(i)) {
				scores.add(i,score);
				names.add(i,name);
				added = true;
				break;
			}
		}
		if(!added) {
			names.add(name);
			scores.add(score);
		}
	}
}
