package i111.tool;

import java.io.IOException;
import java.util.Properties;

import i111.tool.config.FileProperties;

public class Main2 {

	public static void main(String[] args) throws IOException {

		FileProperties fileProperties = new FileProperties();
		Properties properties = new Properties();
		System.getProperties().forEach((k,v)->{
			//System.out.println(k + ", " + v);
			System.out.println(k + ":        " + v);
		});	
		
		//System.out.println(System.getProperties());
	}
	
	
	

}
