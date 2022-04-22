package com.ebuild.bookstarttdd.ch_03.version_01;

import java.time.LocalDate;
import java.time.YearMonth;

public class DateUtils {

	private DateUtils(){}

	public static int lastDayOfMonth(LocalDate date) {
		return YearMonth.from(date).lengthOfMonth();
	}

	public static boolean isSameDayOfMonth(int dayOfFirstBilling, int expiryDay) {
		return dayOfFirstBilling == expiryDay;
	}
}
