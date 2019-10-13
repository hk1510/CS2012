package homework4;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
public class MonitorDriver {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int choice = 0;
		AttackMonitor monitor = new AttackMonitor();
		System.out.println("====================================================\n"
						 + "       Welcome to the Attack Monitor Program\n"
						 + "====================================================");
		while(true) {
			
			System.out.println("\nEnter 1 to document a new attack.");
			System.out.println("Enter 2 for information on all of the attacks.");
			System.out.println("Enter 3 to output data to a CSV file.");
			System.out.println("Enter 4 to read data from a CSV file.");
			System.out.println("Enter 5 for the total damage and the mean damage.");
			System.out.println("Enter 6 for information on the number of attacks by different monsters.");
			System.out.println("Enter 7 for information on the earliest attack.");
			System.out.println("Enter 8 to quit.");
			System.out.print("> ");
			
			choice = input.nextInt();
			
			switch(choice) {
			case 1:
				monitor.reportAttacks();
				break;
			case 2:
				monitor.showAttacks();
				break;
			case 3:
				try {
					monitor.writeToCSV();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case 4:
				try {
					monitor.readFromCSV();
				} catch (FileNotFoundException e) {
					System.out.println("File not found.");
				}
				break;
			case 5:
				monitor.showDamages();
				break;
			case 6:
				monitor.showMonsters();
				break;
			case 7:
				monitor.findEarliestAttack();
				break;
			case 8:
				System.exit(0);
			default:
				System.out.println("Invalid input");
			}
		}
	}
}
