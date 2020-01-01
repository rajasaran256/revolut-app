package hello;

import java.util.Calendar;

public class Utility {

	/**
	 * This function checks whether the incoming string contains only alphabet
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isStringOnlyAlphabet(String str) {
		return ((str != null) && (!str.equals("")) && (str.matches("^[a-zA-Z]*$")));
	}

	/**
	 * 
	 * @param dateOfBirth
	 * @return
	 */
	public static int getBirthdaysByDateOfBirth(String dateOfBirth) {
		Calendar earlier = Calendar.getInstance();
		Calendar later = Calendar.getInstance();

		int currentDay, currentYear, currentMonth;
		String delimeter = "-";

		String bDate[] = dateOfBirth.split(delimeter, 3);

		currentYear = earlier.get(Calendar.YEAR);
		currentMonth = earlier.get(Calendar.MONTH);
		currentDay = earlier.get(Calendar.DATE);

		earlier.set(currentYear, currentMonth, currentDay);

		later.set(currentYear, Integer.valueOf(bDate[1]) - 1, Integer.valueOf(bDate[2]));

		if (earlier.get(Calendar.DATE) == later.get(Calendar.DATE)) {
			return 0;
		}

		if (earlier.get(Calendar.MONTH) >= later.get(Calendar.MONTH)) {
			later.set(currentYear + 1, Integer.valueOf(bDate[1]) - 1, Integer.valueOf(bDate[2]));
			return later.get(Calendar.DAY_OF_YEAR);
		} else {
			later.set(currentYear, Integer.valueOf(bDate[1]) - 1, Integer.valueOf(bDate[2]));
		}

		int earlierDays = earlier.get(Calendar.DAY_OF_YEAR);
		int laterDays = later.get(Calendar.DAY_OF_YEAR);
		int remain = laterDays - earlierDays;

		return remain;

	}

}
