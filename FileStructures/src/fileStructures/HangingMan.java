package fileStructures;

/*
 * Handles displaying art
 * 
 */
public class HangingMan {
	
	public int level = 0; //max is 4
	private String[] hangmanText = { //Holds content for the hangman art
			"_________",//0
			"|/      |",//1
			"|      (_)",//2
			"|      \\|/",//3
			"|       |",//4
			"|      / \\",//5
			"|",//6
			"|_________"//7
	};
	private String logo = "                                                                                 \r\n" + //Holds title art
			"                                                                                 \r\n" + 
			"   .                      _..._             __  __   ___                _..._    \r\n" + 
			" .'|                    .'     '.   .--./) |  |/  `.'   `.            .'     '.  \r\n" + 
			"<  |                   .   .-.   . /.''\\\\  |   .-.  .-.   '          .   .-.   . \r\n" + 
			" | |             __    |  '   '  || |  | | |  |  |  |  |  |    __    |  '   '  | \r\n" + 
			" | | .'''-.   .:--.'.  |  |   |  | \\`-' /  |  |  |  |  |  | .:--.'.  |  |   |  | \r\n" + 
			" | |/.'''. \\ / |   \\ | |  |   |  | /(\"'`   |  |  |  |  |  |/ |   \\ | |  |   |  | \r\n" + 
			" |  /    | | `\" __ | | |  |   |  | \\ '---. |  |  |  |  |  |`\" __ | | |  |   |  | \r\n" + 
			" | |     | |  .'.''| | |  |   |  |  /'\"\"'.\\|__|  |__|  |__| .'.''| | |  |   |  | \r\n" + 
			" | |     | | / /   | |_|  |   |  | ||     ||               / /   | |_|  |   |  | \r\n" + 
			" | '.    | '.\\ \\._,\\ '/|  |   |  | \\'. __//                \\ \\._,\\ '/|  |   |  | \r\n" + 
			" '---'   '---'`--'  `\" '--'   '--'  `'---'                  `--'  `\" '--'   '--' ";
	
	/*
	 * Prints the logo to the screen
	 * 
	 * Takes no parameters.
	 * Returns a string value
	 */
	public String showTitle() {
		return logo;
	}
	
	/*
	 * Prints a bunch of newline characters
	 * 
	 * Takes no parameters
	 * Returns nothing
	 */
	private void blankLines() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
	
	/*
	 * Each of the below methods print the hangman art based off the level the player is at
	 * 
	 * None take parameters
	 * None return anything
	 */
	private void level0() {
		System.out.println(hangmanText[0] + "\n" + hangmanText[1]);
		for(int i = 0; i < 5; i++)System.out.println(hangmanText[6]);
		System.out.println(hangmanText[7]);
	}
	
	private void level1() {
		System.out.println(hangmanText[0] + "\n" + hangmanText[1]);
		System.out.println(hangmanText[2].substring(0, hangmanText[2].length()-2));
		for(int i = 0; i < 4; i++)System.out.println(hangmanText[6]);
		System.out.println(hangmanText[7]);
	}
	
	private void level2() {
		System.out.println(hangmanText[0] + "\n" + hangmanText[1]);
		System.out.println(hangmanText[2].substring(0, hangmanText[2].length()-1));
		for(int i = 0; i < 4; i++)System.out.println(hangmanText[6]);
		System.out.println(hangmanText[7]);
	}
	
	private void level3() {
		System.out.println(hangmanText[0] + "\n" + hangmanText[1]);
		System.out.println(hangmanText[2].substring(0, hangmanText[2].length()));
		for(int i = 0; i < 4; i++)System.out.println(hangmanText[6]);
		System.out.println(hangmanText[7]);
	}
	
	private void level4() {
		System.out.println(hangmanText[0] + "\n" + hangmanText[1]);
		System.out.println(hangmanText[2].substring(0, hangmanText[2].length()));
		System.out.println(hangmanText[3].substring(0, hangmanText[3].length()-2));
		for(int i = 0; i < 3; i++)System.out.println(hangmanText[6]);
		System.out.println(hangmanText[7]);
	}
	
	private void level5() {
		System.out.println(hangmanText[0] + "\n" + hangmanText[1]);
		System.out.println(hangmanText[2].substring(0, hangmanText[2].length()));
		System.out.println(hangmanText[3].substring(0, hangmanText[3].length()-1));
		for(int i = 0; i < 3; i++)System.out.println(hangmanText[6]);
		System.out.println(hangmanText[7]);
	}
	
	private void level6() {
		System.out.println(hangmanText[0] + "\n" + hangmanText[1]);
		System.out.println(hangmanText[2].substring(0, hangmanText[2].length()));
		System.out.println(hangmanText[3].substring(0, hangmanText[3].length()));
		for(int i = 0; i < 3; i++)System.out.println(hangmanText[6]);
		System.out.println(hangmanText[7]);
	}
	
	private void level7() {
		System.out.println(hangmanText[0] + "\n" + hangmanText[1]);
		System.out.println(hangmanText[2].substring(0, hangmanText[2].length()));
		System.out.println(hangmanText[3].substring(0, hangmanText[3].length()));
		System.out.println(hangmanText[4]);
		for(int i = 0; i < 2; i++)System.out.println(hangmanText[6]);
		System.out.println(hangmanText[7]);
	}
	
	private void level8() {
		System.out.println(hangmanText[0] + "\n" + hangmanText[1]);
		System.out.println(hangmanText[2].substring(0, hangmanText[2].length()));
		System.out.println(hangmanText[3].substring(0, hangmanText[3].length()));
		System.out.println(hangmanText[4]);
		System.out.println(hangmanText[5].substring(0, hangmanText[5].length()-2));
		for(int i = 0; i < 1; i++)System.out.println(hangmanText[6]);
		System.out.println(hangmanText[7]);
	}
	
	private void level9() {
		System.out.println(hangmanText[0] + "\n" + hangmanText[1]);
		System.out.println(hangmanText[2].substring(0, hangmanText[2].length()));
		System.out.println(hangmanText[3].substring(0, hangmanText[3].length()));
		System.out.println(hangmanText[4]);
		System.out.println(hangmanText[5].substring(0, hangmanText[5].length()-1));
		for(int i = 0; i < 1; i++)System.out.println(hangmanText[6]);
		System.out.println(hangmanText[7]);
	}
	
	private void level10() {
		System.out.println(hangmanText[0] + "\n" + hangmanText[1]);
		System.out.println(hangmanText[2].substring(0, hangmanText[2].length()));
		System.out.println(hangmanText[3].substring(0, hangmanText[3].length()));
		System.out.println(hangmanText[4]);
		System.out.println(hangmanText[5].substring(0, hangmanText[5].length()));
		for(int i = 0; i < 1; i++)System.out.println(hangmanText[6]);
		System.out.println(hangmanText[7]);
	}
	
	/*
	 * Determines which level of hangman art to display, then calls them accoringly
	 * 
	 * Takes no parameters
	 * Returns nothing
	 */
	public void displayHangingMan() {
		blankLines();
		switch(level) {
		case 0:
			level0();
			break;
		case 1:
			level1();
			break;
		case 2:
			level2();
			break;
		case 3:
			level3();
			break;
		case 4:
			level4();
			break;
		case 5:
			level5();
			break;
		case 6:
			level6();
			break;
		case 7:
			level7();
			break;
		case 8:
			level8();
			break;
		case 9:
			level9();
			break;
		case 10:
			level10();
			break;		
		}
	}
}