package classwork;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {
	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<String> lines = new ArrayList<>();
		File file = new File(args[0]);
		if (args.length != 1) {
			System.out.println("Invalid number of arguments.");
			System.exit(1);
		}
		if (!file.exists()) {
			System.out.println("Source file" + args[0] + " does not exist");
			System.exit(2);
		}
		try (
			Scanner input = new Scanner(file);
		) {
			while(input.hasNextLine()) {
				String line = input.nextLine();
				lines.add(line);
			}
		}
		int numberOfLines = lines.size();
		int numberOfWords = 0;
		int numberOfCharacters = 0;
		for (int i = 0; i < lines.size(); i++) {
			String[] words = lines.get(i).split(" ");
			numberOfWords += words.length;
			for (int j = 0; j < words.length; j++) {
				numberOfCharacters += words[j].length();
			}
			if (words.length >= 2) {
				numberOfCharacters += words.length - 1;
			}
		}
		System.out.println("Number Of Characters: " + numberOfCharacters + "\nNumber Of Words: " + numberOfWords + "\nNumber of Lines: " + numberOfLines);
	}
}