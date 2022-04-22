package com.ebuild.bookstarttdd.ch_03.version_01;

public class CandidateAddedMonths {
	private final int months;
	private final static int CRITERIA_MONTHS = 10;

	public CandidateAddedMonths(int months) {
		this.months = months;
	}

	public boolean gteTenMonth() {
		return this.months >= CRITERIA_MONTHS;
	}

	public int calculateAddedYears() {
		return months / CRITERIA_MONTHS;
	}

	public int calculateSpareAddedMonth() {
		return months % CRITERIA_MONTHS;
	}

	public int get() {
		return months;
	}

}
