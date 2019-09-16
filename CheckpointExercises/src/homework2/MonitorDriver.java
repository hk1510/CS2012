package homework2;
import java.util.Scanner;
public class MonitorDriver {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int choice = 0;
		AttackMonitor monitor = new AttackMonitor();
		monitor.reportAttacks();
		while(true) {
			
			System.out.println("\nEnter 1 for information on all of the attacks.");
			System.out.println("Enter 2 for the total damage and the mean damage.");
			System.out.println("Enter 3 for information on the number of attacks by different monsters.");
			System.out.println("Enter 4 for information on the earliest attack.");
			System.out.println("Enter 5 to quit.");
			
			choice = input.nextInt();
			
			switch(choice) {
			case 1:
				monitor.showAttacks();
				break;
			case 2:
				monitor.showDamages();
				break;
			case 3:
				monitor.showMonsters();
				break;
			case 4:
				monitor.findEarliestAttack();
				break;
			case 5:
				System.exit(0);
			default:
				System.out.println("Invalid input");
			}
		}
	}
}
