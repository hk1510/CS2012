package checkpoint2;

public class Calculator {
	public static void main(String args[]) {
		if (args.length != 1) {
			System.out.println("Usage: java Calculator \"operand1 operator operand2\"");
			System.exit(1);
		}
		int result = 0;
		args = args[0].split(" ");
		for(int i = 0; i < args.length; i++) {
			System.out.print(args[i] + " ");
		}
	}
}
