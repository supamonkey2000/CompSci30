package fileStructures;

import java.io.File;
import java.util.Scanner;

public class InOutExercises {
	
	private void ex1() {
		File file = new File("/");
		String[] fileList = file.list();
		for(String files : fileList) {
			System.out.println(files);
		}
		System.out.println("\n");
	}
	
	private void ex2() {
		File file = new File("/home/josh/Documents/programs/bevfaceyapp");
		String extension = ".txt";
		String[] fileList = file.list();
		for(String files : fileList) {
			if(files.contains(extension)) {
				System.out.println(files);
			}
		}
		System.out.println("\n");
	}
	
	private void ex3() {
		File filePath = new File("/home/josh/Documents/programs/traceroutemap");
		String fileName = "README.md";
		String[] fileList = filePath.list();
		for(String files : fileList) {
			if(files.contains(fileName)) {
				System.out.println("File \"" + fileName + "\" exists");
				System.out.println("\n");
				return;
			}
		}
		System.out.println("File \"" + fileName + "\" does not exist!");
		System.out.println("\n");
	}
	
	private void ex4() {
		File filePath = new File("/home/josh/Documents/programs/traceroutemap/README.md");
		String fileName = "README.md";
		if(filePath.exists()) {
			if(filePath.canRead() && filePath.canWrite()) {
				System.out.println("File \"" + fileName + "\" has Read and Write permissions");
			}else if(filePath.canRead()) {
				System.out.println("File \"" + fileName + "\" has Read permissions");
			}else if(filePath.canWrite()) {
				System.out.println("File \"" + fileName + "\" has Write permissions");
			}else {
				System.out.println("File \"" + fileName + "\" has NO Read or Write permissions");
			}
		}
		System.out.println("\n");
	}
	
	private void ex5() {
		File filePath = new File("/home/josh/Documents/programs/traceroutemap");
		if(filePath.exists()) {
			if(filePath.isDirectory()) {
				System.out.println(filePath.getAbsolutePath() + " is a directory");
			}else if(filePath.isFile()) {
				System.out.println(filePath.getAbsolutePath() + " is a file");
			}
		}
		System.out.println("\n");
	}
	
	private void ex6() {
		File filePath1 = new File("/home/josh/Documents/programs/traceroutemap/install.py");
		File filePath2= new File("/home/josh/Documents/programs/traceroutemap/run.py");
		if(filePath1.exists()&&filePath2.exists()) {
			int compare = filePath1.compareTo(filePath2);
			System.out.println("Lexicograph: " + Integer.toString(compare));
		}
		System.out.println("\n");
	}
	
	private void ex7() {
		File filePath = new File("/home/josh/Documents/programs/traceroutemap/README.md");
		if(filePath.exists()) {
			long lastModified = filePath.lastModified();
			System.out.println("Last modified: " + Long.toString(lastModified));
		}
		System.out.println("\n");
	}
	
	private void ex8() {
		System.out.print("Input some text: ");
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		System.out.println("You typed: " + input);
		System.out.println("\n");
		scan.close();
	}
	
	private void ex9() {
		File file = new File("/home/josh/Documents/programs/wpa2hasher/words.txt");
		if(file.exists()) {
			System.out.println("Size in bytes: " + Long.toString(file.length()));
			System.out.println("Size in kilobytes: " + ((int)file.length())/1000);
			System.out.println("Size in megabytes: " + ((int)file.length())/1000/1000);
		}
		System.out.println("\n");
	}
	
	
	
	public static void main(String[] args) {
		InOutExercises ioe = new InOutExercises();
		ioe.ex1();
		ioe.ex2();
		ioe.ex3();
		ioe.ex4();
		ioe.ex5();
		ioe.ex6();
		ioe.ex7();
		ioe.ex8();
		ioe.ex9();
	}
}
