package fileStructures;

public class HangingMan {
	
	public int level = 0; //max is 4
	private String[] hangmanText = {
			"_________",//0
			"|/      |",//1
			"|      (_)",//2
			"|      \\|/",//3
			"|       |",//4
			"|      / \\",//5
			"|",//6
			"|_________"//7
	};
	
	private void blankLines() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
	
	private void level0() {
		System.out.println(hangmanText[0]+"\n"+hangmanText[1]);
		for(int i=0;i<5;i++)System.out.println(hangmanText[6]);
		System.out.println(hangmanText[7]);
	}private void level1() {
		System.out.println(hangmanText[0]+"\n"+hangmanText[1]);
		System.out.println(hangmanText[2].substring(0, hangmanText[2].length()-2));
		for(int i=0;i<4;i++)System.out.println(hangmanText[6]);
		System.out.println(hangmanText[7]);
	}private void level2() {
		System.out.println(hangmanText[0]+"\n"+hangmanText[1]);
		System.out.println(hangmanText[2].substring(0, hangmanText[2].length()-1));
		for(int i=0;i<4;i++)System.out.println(hangmanText[6]);
		System.out.println(hangmanText[7]);
	}private void level3() {
		System.out.println(hangmanText[0]+"\n"+hangmanText[1]);
		System.out.println(hangmanText[2].substring(0, hangmanText[2].length()));
		for(int i=0;i<4;i++)System.out.println(hangmanText[6]);
		System.out.println(hangmanText[7]);
	}private void level4() {
		System.out.println(hangmanText[0]+"\n"+hangmanText[1]);
		System.out.println(hangmanText[2].substring(0, hangmanText[2].length()));
		System.out.println(hangmanText[3].substring(0, hangmanText[3].length()-2));
		for(int i=0;i<3;i++)System.out.println(hangmanText[6]);
		System.out.println(hangmanText[7]);
	}private void level5() {
		System.out.println(hangmanText[0]+"\n"+hangmanText[1]);
		System.out.println(hangmanText[2].substring(0, hangmanText[2].length()));
		System.out.println(hangmanText[3].substring(0, hangmanText[3].length()-1));
		for(int i=0;i<3;i++)System.out.println(hangmanText[6]);
		System.out.println(hangmanText[7]);
	}private void level6() {
		System.out.println(hangmanText[0]+"\n"+hangmanText[1]);
		System.out.println(hangmanText[2].substring(0, hangmanText[2].length()));
		System.out.println(hangmanText[3].substring(0, hangmanText[3].length()));
		for(int i=0;i<3;i++)System.out.println(hangmanText[6]);
		System.out.println(hangmanText[7]);
	}private void level7() {
		System.out.println(hangmanText[0]+"\n"+hangmanText[1]);
		System.out.println(hangmanText[2].substring(0, hangmanText[2].length()));
		System.out.println(hangmanText[3].substring(0, hangmanText[3].length()));
		System.out.println(hangmanText[4]);
		for(int i=0;i<2;i++)System.out.println(hangmanText[6]);
		System.out.println(hangmanText[7]);
	}private void level8() {
		System.out.println(hangmanText[0]+"\n"+hangmanText[1]);
		System.out.println(hangmanText[2].substring(0, hangmanText[2].length()));
		System.out.println(hangmanText[3].substring(0, hangmanText[3].length()));
		System.out.println(hangmanText[4]);
		System.out.println(hangmanText[5].substring(0, hangmanText[5].length()-2));
		for(int i=0;i<1;i++)System.out.println(hangmanText[6]);
		System.out.println(hangmanText[7]);
	}
	private void level9() {
		System.out.println(hangmanText[0]+"\n"+hangmanText[1]);
		System.out.println(hangmanText[2].substring(0, hangmanText[2].length()));
		System.out.println(hangmanText[3].substring(0, hangmanText[3].length()));
		System.out.println(hangmanText[4]);
		System.out.println(hangmanText[5].substring(0, hangmanText[5].length()-1));
		for(int i=0;i<1;i++)System.out.println(hangmanText[6]);
		System.out.println(hangmanText[7]);
	}
	private void level10() {
		System.out.println(hangmanText[0]+"\n"+hangmanText[1]);
		System.out.println(hangmanText[2].substring(0, hangmanText[2].length()));
		System.out.println(hangmanText[3].substring(0, hangmanText[3].length()));
		System.out.println(hangmanText[4]);
		System.out.println(hangmanText[5].substring(0, hangmanText[5].length()));
		for(int i=0;i<1;i++)System.out.println(hangmanText[6]);
		System.out.println(hangmanText[7]);
	}
	
	
	public void displayHangingMan() throws Exception {
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