package i111.tool.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import i111.tool.model.PathModel;

public class Output {

	public static final String dot = ". ";
	public static final String space = " ";

	public static final String info1 = "[1st time: 1 day revision]";
	public static final String info2 = "[2nd time: 1 week revision]";
	public static final String info3 = "[3rd time: 1 month revision]";

	public static void createFiles(PathModel pathModel, String currentTaskStr) throws IOException {
		createFile(pathModel.getCurrentDateStrPath(), currentTaskStr, "");
		
		createFile(pathModel.getRevisionDateStrPath1(), currentTaskStr, info1);
		createFile(pathModel.getRevisionDateStrPath2(), currentTaskStr, info2);
		createFile(pathModel.getRevisionDateStrPath3(), currentTaskStr, info3);
	}
	
	public static void createFile(String filePathName, String currentTaskStr, String infoStr) throws IOException {
		File file = new File(filePathName);
		int taskCount = 1;
		if (file.exists()) {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePathName)));

			String tempStr = null, lineStr;
			while ((lineStr = br.readLine()) != null) {
				tempStr = lineStr;
			}
			String lastLineStr = tempStr;
			String[] splitStrArr = lastLineStr.split(" ");
			String firstElement = splitStrArr[0].replace(".", "");
			taskCount = Integer.parseInt(firstElement);
			taskCount++;
			br.close();
		}
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
		writer.write(taskCount + dot + currentTaskStr + space + infoStr);
		writer.newLine();
		writer.close();
	}
	
}
