package i111.tool;

import java.io.IOException;
import java.util.Scanner;

import i111.tool.helper.DateHelper;
import i111.tool.helper.PathHelper;
import i111.tool.io.Input;
import i111.tool.io.Output;
import i111.tool.model.DateModel;
import i111.tool.model.PathModel;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {		
		DateModel dateModel = new DateModel();
		System.out.println("Please select the choice: \n1. System date (Automatic)  ||  2. Custom date (User choice)");
		Scanner scanner = new Scanner(System.in);
		int choiceStr = scanner.nextInt();
		if (choiceStr == 1) {
			dateModel = DateHelper.getCurrentDate(); 
		} else if (choiceStr == 2) {
			System.out.println("\nEnter dd: ");
			dateModel.setDay(scanner.nextInt());
			System.out.println("Enter mm: ");
			dateModel.setMonth(scanner.nextInt());
			System.out.println("Enter yyyy: ");
			dateModel.setYear(scanner.nextInt());
			System.out.println();
		} else {
			System.out.println("Invalid Entry");
			return;
		}
		
		PathModel pathModel = PathHelper.getAllPaths(dateModel);
        
		String currentTaskStr = Input.readUserInput();
		Output.createFiles(pathModel, currentTaskStr);
		
		System.out.println("\nAll completed");
	}
	
}
