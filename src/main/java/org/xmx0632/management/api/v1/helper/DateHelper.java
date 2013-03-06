package org.xmx0632.management.api.v1.helper;

import java.util.Date;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class DateHelper {

	private static DateTimeFormatter DATE_FORMAT = DateTimeFormat
			.forPattern("yyyy-MM-dd HH:mm:ssZ");

	public static String getDateString(Date date) {
		return DATE_FORMAT.print(date.getTime());
	}

	public static void main(String args[]) {
		System.out.println(DateHelper.getDateString(new Date()));
	}
}
