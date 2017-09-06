import java.io.*;
import java.util.*;
import java.lang.Math;

public class UserInterface {
	private static String[] filecontents;
	public static void main(String[] args) throws Exception {
		Scanner userinput = new Scanner(System.in);
		int choice = 0;
		int numsides = 0;
		int numrolls = 0;
		String result;
		do {
			displayMenu();
			choice = userinput.nextInt();
			switch (choice) {
			case 1:
				System.out.println("How many sides should the die have?");
				numsides = userinput.nextInt();
				System.out.println("How many rolls would you like to make?");
				numrolls = userinput.nextInt();
				runDiceSimulation(numsides, numrolls);
				break;
			case 2:
				System.out.println("How many sides did the die have?");
				numsides = userinput.nextInt();
				System.out.println("How many rolls were made?");
				numrolls = userinput.nextInt();
				readFile("Die"+numsides+"rolls"+numrolls+".txt", numrolls);
				break;
			case 3:
				System.out.println("Which result would you like to search the current file for?");
				result = userinput.next();
				if (numsides == 0 || numrolls == 0) {
					System.out.println("You do not currently have a file loaded.  Please load a file.");
				} else {
					int count = linearSearchDiceFile(numsides, numrolls, result);
					System.out.println(result+" appears in the file "+count+ " times.");
				}
				break;
			}
			System.out.println("********************************");
		} while (choice !=4 );
		System.out.println("Program ended.");

		userinput.close();
		//80000000
		//90000000
	}

	private static void displayMenu() {
		System.out.println("Select fromt the options below:");
		System.out.println("1. Rolling dice simulator.");
		System.out.println("2. Load a set of results.");
		System.out.println("3. Linear search a Dice file.");
		System.out.println("4. Quit the program.");
	}

	private static int linearSearchDiceFile(int numsides, int numrolls, String searchterm) throws Exception {
		int counter = 0;
		/*
		* Replace with code that will loop through the file that has been loaded in to 
		* filecontents, and count how many times the search term appear.
		* returns the number of times the term appeared.
		*/
		BufferedReader in = new BufferedReader(new FileReader("Die"+numsides+"rolls"+numrolls+".txt"));
		String str;
		List<String>list = new ArrayList<String>();
		while((str = in.readLine())!=null) {
			list.add(str);
		}
		
		String[] results = list.toArray(new String[0]);
		
		for(int i = 0; i < results.length; i++) {
			int test = Integer.parseInt(results[i]);
			if(test==Integer.parseInt(searchterm)) {
				counter++;
			}
		}
		
		return counter;//IGNORE THIS COMMENT THIS IS FOR A GITHUB COMMIT
		//IGNORE THIS ONE AS WELL
		//AND THIS
	}

	private static void readFile(String filename, int filelength){
		try{
			//Create object of FileReader
			FileReader inputFile = new FileReader(filename);

			//Instantiate the BufferedReader Class
			BufferedReader bufferReader = new BufferedReader(inputFile);

			filecontents = new String[filelength];
			// Read file line by line and print on the console
			for (int index = 0; index <filelength; index++) {
				filecontents[index] = bufferReader.readLine();
			}
			//Close the buffer reader
			bufferReader.close();
			System.out.println("File loaded.");
		}catch(Exception e){
			System.out.println("Error while reading file line by line:" + e.getMessage());                      
		}
	}

	private static void runDiceSimulation(int numsides, int numrolls) {
		File dataFile = new File("Die"+numsides+"rolls"+numrolls+".txt");
		FileWriter out;
		BufferedWriter writeFile;

		try {
			out = new FileWriter(dataFile);
			writeFile = new BufferedWriter(out);
			for (int i = 0; i < numrolls; i++) {
				writeFile.write((Integer.toString((int)(Math.random()*numsides+1))));
				writeFile.newLine();
			}
			writeFile.close();
			out.close();
			System.out.println("Data written to file.");
		} catch (IOException e) {
			System.out.println("Problem writing to file.");
			System.err.println("IOException: " + e.getMessage());
		}//end of try-catch
	}
}