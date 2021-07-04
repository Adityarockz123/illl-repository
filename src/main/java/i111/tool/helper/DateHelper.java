package i111.tool.helper;

import java.util.Calendar;

import i111.tool.model.DateModel;

public class DateHelper {
	
	public static DateModel getCurrentDate() {
		Calendar cal = Calendar.getInstance();
		DateModel dateModel = new DateModel();
		dateModel.setDay(cal.get(Calendar.DATE));
		dateModel.setMonth(cal.get(Calendar.MONTH) + 1);
		dateModel.setYear(cal.get(Calendar.YEAR));
		return dateModel;
	}
}
