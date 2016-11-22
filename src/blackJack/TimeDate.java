package blackJack;

import java.util.*;

import java.text.DateFormat;

/**
 * This class contains methods that generate and return strings with current time and date.
 * 
 * @author David
 */
public class TimeDate {

	private static Locale locale = new Locale("en");
	private static DateFormat timeFormat = DateFormat.getTimeInstance(DateFormat.DEFAULT, locale);
	private static DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);

	/**
	 * Returns current time as a String.
	 * 
	 * @return String with current time.
	 */
	public static String getTime() {
		return timeFormat.format(new Date());
	}

	/**
	 * Returns current date as a String.
	 * 
	 * @return String with current date.
	 */
	public static String getDate() {
		return dateFormat.format(new Date());
	}

}
