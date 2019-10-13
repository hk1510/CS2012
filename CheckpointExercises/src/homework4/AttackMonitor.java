package homework4;
import java.util.Scanner;
import java.time.LocalDate;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
public class AttackMonitor {
	ArrayList<MonsterAttack> attacks = new ArrayList<>();
	public void reportAttacks() {
		int month;
		int day;
		int year;
		Scanner input = new Scanner(System.in);
		MonsterAttack newAttack = new MonsterAttack();
		while(true) {
			try {
				System.out.print("\nEnter the name of the monster that caused the attack: ");
				newAttack.setMonsterName(input.nextLine());
				break;
			} catch(Exception e) {
				System.out.println("Invalid input. Try again.");
				input.nextLine();
			}
		}
		while(true) {
			try {
				System.out.print("Enter the city that the attack took place in: ");
				newAttack.setAttackLocation(input.nextLine());
				break;
			} catch(Exception e) {
				System.out.println("Invalid input. Try again.");
				input.nextLine();
			}
		}
		while(true) {
			try {
				System.out.print("Enter the amount of damage in millions caused by the attack: ");
				newAttack.setDamagesInMillionUSD(input.nextDouble());
				break;
			} catch(Exception e) {
				System.out.println("Invalid input. Try again.");
				input.nextLine();
			}
		}
		while(true) {
			try {
				System.out.print("Enter the date of the attack in the form MM DD YYYY (1 1 2001 for Jan 1 2001): ");
				month = input.nextInt();
				day = input.nextInt();
				year = input.nextInt();
				input.nextLine();
				newAttack.setDate(LocalDate.of(year, month, day));
				break;
			} catch(Exception e) {
				System.out.println("Invalid input. Try again.");
				input.nextLine();
			}
		}
		attacks.add(newAttack);
	}
	
	public void showAttacks() {
		System.out.println();
		for (int i = 0; i < attacks.size(); i++) {
			System.out.println("\nAttack " + (i+1) + ": ");
			System.out.println(attacks.get(i).toString());
		}
	}
	public void showDamages() {
		double totalDamages = 0;
		System.out.println();
		for (int i = 0; i < attacks.size(); i++) {
			totalDamages += attacks.get(i).damagesInMillionUSD;
		}
		double meanDamages = totalDamages / attacks.size();
		System.out.println("The total damages are " + totalDamages + " million dollars. "
						   + "\nThe mean damages are " + meanDamages + " million dollars." );
	}
	public void showMonsters() {
		System.out.println();
		for(int i = 0; i < attacks.size(); i++) {
			int count = 0;
			for(int j = 0; j < attacks.size(); j++) {
				String monster = attacks.get(i).getMonsterName();
				String monster2 = attacks.get(i).getMonsterName();
				if (j < i && monster.equals(monster2)) {
					break;
				}
				else if (monster.equals(monster2)) {
					count++;
				}
			}
			if (count > 0) {
				System.out.println(attacks.get(i).monsterName + ": " + count + " attack(s)");
			}
		}
	}
	public void findEarliestAttack() {
		MonsterAttack earliestAttack = attacks.get(0);
		LocalDate earliestAttackDate = attacks.get(0).getDate();
		for (int i = 0; i < attacks.size(); i++) {
			LocalDate attackDate = attacks.get(i).getDate();
			if (attackDate.compareTo(earliestAttackDate) < 0) {
				earliestAttack = attacks.get(i);
			}
		}
		System.out.println("\nThe details of the earliest attack are:");
		System.out.println(earliestAttack.toString());
	}
	public void writeToCSV() throws java.io.IOException {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the name of the output file (Ex: attacks.csv) if you want your file to be stored in the current working directory. \n"
				+ "Enter the entire filepath of the output file if you want your file to be stored in a different location. \n> ");
		File attacksfile = new File(input.nextLine());
		if (attacksfile.exists()) {
			System.out.println("File already exists, overwriting file.");
			attacksfile.delete();
		}
		PrintWriter output = new PrintWriter(attacksfile);
		for(int i = 0; i < attacks.size(); i++) {
			String date = "" + attacks.get(i).getDate().getMonthValue() + "/" + attacks.get(i).getDate().getDayOfMonth() + "/" + attacks.get(i).getDate().getYear();
			output.print(attacks.get(i).getMonsterName() + ",");
			output.print(attacks.get(i).getAttackLocation() + ",");
			output.print(attacks.get(i).getDamagesInMillionUSD() + ",");
			output.print(date + "\n");
		}
		System.out.println("Data saved in " + attacksfile.getAbsolutePath());
		output.close();
	}
	public void readFromCSV() throws FileNotFoundException {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the name of the file you want to read (Ex: attacks.csv) if your file is in the current working directory. \n"
				+ "Enter the entire filepath if the file is in a different location. \n> ");
		File file = new File(input.nextLine());
		if(!file.exists()) {
			throw new FileNotFoundException();
		}
		attacks.clear();
		input = new Scanner(file);
		while(input.hasNextLine()) {
			String line = input.nextLine();
			String[] values = line.split(",");
			MonsterAttack newAttack = new MonsterAttack();
			newAttack.setMonsterName(values[0]);
			newAttack.setAttackLocation(values[1]);
			newAttack.setDamagesInMillionUSD(Double.parseDouble(values[2]));
			newAttack.setDate(LocalDate.of(Integer.parseInt(values[3].split("/")[2]), Integer.parseInt(values[3].split("/")[0]), Integer.parseInt(values[3].split("/")[1])));
			attacks.add(newAttack);
		}
	}
}
