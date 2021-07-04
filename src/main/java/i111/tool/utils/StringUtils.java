package i111.tool.utils;

import java.text.DateFormatSymbols;

import i111.tool.model.DateModel;

public class StringUtils {
	
	public static final String space = " ";
	public static final String comma = ", ";
	public static final String dot = ". ";
	public static final String txt = ".txt";

	public static String getFileNameStr(DateModel dateModel) {
		String dayStr   = getDayInString(dateModel);
		String monthStr = getMonthInString(dateModel);
		String yearStr  = Integer.toString(dateModel.getYear());
		
		String fileNameStr = monthStr + space + dayStr + comma +  yearStr + txt;
		return fileNameStr;
	}
	
	public static String getDayInString(DateModel dateModel) {
		String dayStr = "";
		if(dateModel.getDay()>=1 && dateModel.getDay()<=9) {
			dayStr = "0" + dateModel.getDay();
		} else {
			dayStr = Integer.toString(dateModel.getDay());
		}
		return dayStr;
	}
	
	public static String getMonthInString(DateModel dateModel) {	
		String monthStr = DateFormatSymbols.getInstance().getMonths()[dateModel.getMonth()-1];
		String monthStrModified = dateModel.getMonth() + dot + monthStr;
		return monthStrModified;
	}
}
