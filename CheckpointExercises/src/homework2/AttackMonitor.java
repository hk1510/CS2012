package homework2;
import java.util.Scanner;
import java.util.Date;
public class AttackMonitor {
	public MonsterAttack[] reportAttacks() {
		
		MonsterAttack[] array = new MonsterAttack[5];
		for(int i = 0; i < array.length; i++) {
			Scanner input = new Scanner(System.in);
			array[i] = new MonsterAttack();
			System.out.print("\nEnter the name of the monster that caused attack " + (i + 1) + ": ");
			array[i].setMonsterName(input.nextLine());
			System.out.print("Enter the city that attack " + (i + 1) + " took place in: ");
			array[i].setAttackLocation(input.nextLine());
			System.out.print("Enter the amount of damage in millions caused by attack " + (i + 1) + ": ");
			array[i].setDamagesInMillionUSD(input.nextDouble());
			System.out.print("Enter the date of attack " + (i + 1) + " in the form: YYYY MM DD: ");
			array[i].setDate(new Date(input.nextInt(), input.nextInt(), input.nextInt()));
			System.out.println();
		}
		return array;
	}
}