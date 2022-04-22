package com.ebuild.bookstarttdd.ch_03.version_01;

import static com.ebuild.bookstarttdd.ch_03.version_01.DateUtils.*;

import java.time.LocalDate;

public class ExpiryDateCalculator {

	public LocalDate calculate(PayData payData) {
		CandidateAddedMonths candidateAddedMonths = payData.calculateCandidateAddedMonths();
		if (payData.existsFirstBillingDate()) {
			return expiryDateUsingFirstBillingDate(payData, candidateAddedMonths);
		}

		if (candidateAddedMonths.gteTenMonth()) {
			return payData.getBillingDate()
				.plusYears(candidateAddedMonths.calculateAddedYears())
				.plusMonths(candidateAddedMonths.calculateSpareAddedMonth());
		}

		return payData.getBillingDate()
			.plusMonths(candidateAddedMonths.get());
	}

	private LocalDate expiryDateUsingFirstBillingDate(PayData payData, CandidateAddedMonths candidateAddedMonths) {
		final int dayOfFirstBilling = payData.getFirstBillingDate().getDayOfMonth();
		LocalDate expiryDateCandidate = payData.getBillingDate().plusMonths(candidateAddedMonths.get());

		final int dayLengthOfExpiryMonth = lastDayOfMonth(expiryDateCandidate);
		if (dayLengthOfExpiryMonth < dayOfFirstBilling) {
			return expiryDateCandidate.withDayOfMonth(dayLengthOfExpiryMonth);
		}

		final int expiryDay = expiryDateCandidate.getDayOfMonth();
		if (!isSameDayOfMonth(dayOfFirstBilling, expiryDay)) {
			return expiryDateCandidate.withDayOfMonth(dayOfFirstBilling);
		}

		return expiryDateCandidate;
	}

}
