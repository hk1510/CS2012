package application;
import java.util.Scanner;

import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
public class AttackMonitor {
	ArrayList<MonsterAttack> attacks = new ArrayList<>();
	public void reportAttacks(TextField name, TextField city, TextField damage, TextField date) throws Exception{
		int month;
		int day;
		int year;
		MonsterAttack newAttack = new MonsterAttack();
		newAttack.setMonsterName(name.getText());
		newAttack.setAttackLocation(city.getText());
		newAttack.setDamagesInMillionUSD(Double.parseDouble(damage.getText()));
		String[] datestr = date.getText().split("/");
		month = Integer.parseInt(datestr[0]);
		day = Integer.parseInt(datestr[1]);
		year = Integer.parseInt(datestr[2]);
		newAttack.setDate(LocalDate.of(year, month, day));
		attacks.add(newAttack);
	}
	
	public String showAttacks() {
		String attackstr = new String();
		attackstr = String.format("%1$-3s%2$-15s%3$-10s%4$-15s%5$-15s\n", "#", "Name", "Damages", "Location", "Date");
		for (int i = 0; i < attacks.size(); i++) {
			attackstr = attackstr + String.format("%1$-3s", Integer.toString(i+1)) + attacks.get(i).toString();
		}
		return attackstr;
	}
	public String showDamages() {
		double totalDamages = 0;
		System.out.println();
		for (int i = 0; i < attacks.size(); i++) {
			totalDamages += attacks.get(i).damagesInMillionUSD;
		}
		double meanDamages = totalDamages / attacks.size();
		return "Total damage: " + totalDamages + " million dollars. " + "\nMean damage: " + meanDamages + " million dollars.";
	}
	public String showMonsters() {
		String monsters = new String();
		monsters = String.format("%-20s%-20s\n", "Monster", "Number of Attacks");
		for(int i = 0; i < attacks.size(); i++) {
			int count = 0;
			for(int j = 0; j < attacks.size(); j++) {
				String monster = attacks.get(i).getMonsterName();
				String monster2 = attacks.get(j).getMonsterName();
				if (j < i && monster.equals(monster2)) {
					break;
				}
				else if (monster.equals(monster2)) {
					count++;
				}
			}
			if (count > 0) {
				monsters = monsters + String.format("%-20s%-20d\n", attacks.get(i).monsterName, count) ;
			}
		}
		return monsters;
	}
	public String findEarliestAttack() {
		String earliestAttackstr = new String(String.format("%1$-15s%2$-10s%3$-15s%4$-15s\n", "Monster", "Damages", "Location", "Date"));
		
		if(attacks.size() == 0) {
			return earliestAttackstr;
		}
		
		MonsterAttack earliestAttack = attacks.get(0);
		LocalDate earliestAttackDate = attacks.get(0).getDate();
		for (int i = 0; i < attacks.size(); i++) {
			LocalDate attackDate = attacks.get(i).getDate();
			if (attackDate.compareTo(earliestAttackDate) < 0) {
				earliestAttack = attacks.get(i);
			}
		}

		return earliestAttackstr + earliestAttack.toString();
	}
	public String writeToCSV(TextField file) throws java.io.IOException {
		File attacksfile = new File(file.getText());
		if (attacksfile.exists()) {
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
		output.close();
		return "Data saved in " + attacksfile.getAbsolutePath();
	}
	public void readFromCSV(TextField filetf) throws FileNotFoundException {
		Scanner input = new Scanner(System.in);
		File file = new File(filetf.getText());
		if(!file.exists()) {
			input.close();
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
		input.close();
	}
}
