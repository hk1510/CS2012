package homework2;

public class MonitorDriver {
	public static void main(String[] args) {
		AttackMonitor monitor = new AttackMonitor();
		MonsterAttack[] array = monitor.reportAttacks();
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i].toString());
		}
		
	}
}