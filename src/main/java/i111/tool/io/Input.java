package i111.tool.io;

import java.util.Scanner;

public class Input {
	
	@SuppressWarnings("resource")
	public static String readUserInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the task completed:");
		String taskStr = scanner.nextLine();
		return taskStr;
	}
}
