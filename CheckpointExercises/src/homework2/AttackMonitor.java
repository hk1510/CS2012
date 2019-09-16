package homework2;
import java.util.Scanner;
import java.util.Date;
public class AttackMonitor {
	MonsterAttack[] attacks = new MonsterAttack[5];
	public void reportAttacks() {
		int month;
		int day;
		int year;
		for(int i = 0; i < attacks.length; i++) {
			Scanner input = new Scanner(System.in);
			attacks[i] = new MonsterAttack();
			System.out.print("\nEnter the name of the monster that caused attack " + (i + 1) + ": ");
			attacks[i].setMonsterName(input.nextLine());
			System.out.print("Enter the city that attack " + (i + 1) + " took place in: ");
			attacks[i].setAttackLocation(input.nextLine());
			System.out.print("Enter the amount of damage in millions caused by attack " + (i + 1) + ": ");
			attacks[i].setDamagesInMillionUSD(input.nextDouble());
			System.out.print("Enter the date of attack " + (i + 1) + " in the form MM DD YYYY (1 1 2001 for Jan 1 2001): ");
			month = input.nextInt();
			day = input.nextInt();
			year = input.nextInt();
			attacks[i].setDate(new Date(year, day, month));
		}
	}
	
	public void showAttacks() {
		System.out.println();
		for (int i = 0; i < attacks.length; i++) {
			System.out.println("\nAttack " + (i+1) + ": ");
			System.out.println(attacks[i].toString());
		}
	}
	public void showDamages() {
		double totalDamages = 0;
		System.out.println();
		for (int i = 0; i < attacks.length; i++) {
			totalDamages += attacks[i].damagesInMillionUSD;
		}
		double meanDamages = totalDamages / attacks.length;
		System.out.println("The total damages are " + totalDamages + " million dollars. "
						   + "\nThe mean damages are " + meanDamages + " million dollars." );
	}
	public void showMonsters() {
		System.out.println();
		for(int i = 0; i < attacks.length; i++) {
			int count = 0;
			for(int j = 0; j < attacks.length; j++) {
				String monster = attacks[i].getMonsterName();
				String monster2 = attacks[j].getMonsterName();
				if (j < i && monster.equals(monster2)) {
					break;
				}
				else if (monster.equals(monster2)) {
					count++;
				}
			}
			if (count > 0) {
				System.out.println(attacks[i].monsterName + ": " + count + " attack(s)");
			}
		}
	}
	public void findEarliestAttack() {
		MonsterAttack earliestAttack = attacks[0];
		Date earliestAttackDate = attacks[0].getDate();
		for (int i = 0; i < attacks.length; i++) {
			Date attackDate = attacks[i].getDate();
			if (attackDate.compareTo(earliestAttackDate) < 0) {
				earliestAttack = attacks[i];
			}
		}
		System.out.println("\nThe details of the earliest attack are:");
		System.out.println(earliestAttack.toString());
	}
}
