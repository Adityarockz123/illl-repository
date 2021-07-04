package i111.tool.helper;

import java.io.IOException;

import i111.tool.config.FileProperties;
import i111.tool.model.DateModel;
import i111.tool.model.PathModel;
import i111.tool.utils.StringUtils;

public class PathHelper {
	
	public static final String backslash = "\\";
	
	public static PathModel getAllPaths(DateModel dateModel) throws IOException {
		PathModel pathModel = new PathModel();
		FileProperties fileProperties = new FileProperties();
		
		PathHelper.getOriginalFilesPath(dateModel, pathModel, fileProperties);
		PathHelper.getRevisionFilesPath(dateModel, pathModel, fileProperties);
		return pathModel;
	}
	
	public static void getOriginalFilesPath(DateModel dateModel, PathModel pathModel, FileProperties fileProperties) {
		String fileNameStr = StringUtils.getFileNameStr(dateModel);
		String pathNameStr = fileProperties.getOriginalFilesFolder() + backslash + fileNameStr;
		pathModel.setCurrentDateStrPath(pathNameStr);
	}
	
	public static void getRevisionFilesPath(DateModel dateModel, PathModel pathModel, FileProperties fileProperties) {
		String pathNameStr = "";
		int index = 0;
		for(int i = 0; i < 3; i++) {
			index ++;
			if (index == 1) {
				pathNameStr = addingDateFunctionlity(dateModel, fileProperties, 1); // 1 day
				pathModel.setRevisionDateStrPath1(pathNameStr);
			} else if (index == 2) {
				pathNameStr = addingDateFunctionlity(dateModel, fileProperties, 7); // 1 week
				pathModel.setRevisionDateStrPath2(pathNameStr);
			} else {
				pathNameStr = addingDateFunctionlity(dateModel, fileProperties, 30); // 1 month
				pathModel.setRevisionDateStrPath3(pathNameStr);
			}
		}
	}
	
	public static String addingDateFunctionlity(DateModel dateModel, FileProperties fileProperties, int revisionDays) {
		while(revisionDays != 0) {
			IncreementDate(dateModel);
			revisionDays--;
		}
		String fileNameStr = StringUtils.getFileNameStr(dateModel);
		String pathNameStr = fileProperties.getRevisionFilesFolder() + backslash + fileNameStr;
		return pathNameStr;
	}
	
	public static void IncreementDate(DateModel revisonDateModel) {
		int dd = revisonDateModel.getDay();
		int mm = revisonDateModel.getMonth();
		int yy = revisonDateModel.getYear();

		dd++;
		if (dd == 29 && mm == 2 && yy % 4 != 0) {
			dd = 1;
			mm++;
		} else if (dd == 30 && mm == 2 && yy % 4 == 0) {
			dd = 1;
			mm++;
		} else if (dd == 31 && (mm == 4 || mm == 6 || mm == 9 || mm == 11)) {
			dd = 1;
			mm++;
		} else if (dd == 32) {
			dd = 1;
			mm++;
			if (mm == 13) {
				mm = 1;
				yy++;
			}
		}
		revisonDateModel.setDay(dd);
		revisonDateModel.setMonth(mm);
		revisonDateModel.setYear(yy);		
	}
		
}	
