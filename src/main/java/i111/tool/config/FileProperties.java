package i111.tool.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import lombok.Data;

@Data
public class FileProperties {
	private String originalFilesFolder;
	private String revisionFilesFolder;
	
	public FileProperties() throws IOException {
		Properties properties = new Properties();
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("file.properties");
		properties.load(inputStream);
		this.setOriginalFilesFolder(properties.getProperty("source-folder")+"\\Original Files");
		this.setRevisionFilesFolder(properties.getProperty("source-folder")+"\\Revision Files");
	}
}
