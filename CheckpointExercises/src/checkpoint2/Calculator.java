package checkpoint2;

public class Calculator {
	public static void main(String args[]) {
		if (args.length != 1) {
			System.out.println("Usage: java Calculator \"operand1 operator operand2\"");
			System.exit(1);
		}
		int result = 0;
		String arg = args[0].replaceAll(" ", "");
		System.out.print(arg);

		switch (arg.charAt(1)) {
			case '+':
					result = Integer.parseInt(String.valueOf(arg.charAt(0))) + Integer.parseInt(String.valueOf(arg.charAt(2)));
					break;
			case '-':
					result = Integer.parseInt(String.valueOf(arg.charAt(0))) - Integer.parseInt(String.valueOf(arg.charAt(2)));
					break;
			case '*':
					result = Integer.parseInt(String.valueOf(arg.charAt(0))) * Integer.parseInt(String.valueOf(arg.charAt(2)));
					break;
			case '/':
					result = Integer.parseInt(String.valueOf(arg.charAt(0))) / Integer.parseInt(String.valueOf(arg.charAt(2)));
					break;
		}
		System.out.print(" = " + result);
	}
}
