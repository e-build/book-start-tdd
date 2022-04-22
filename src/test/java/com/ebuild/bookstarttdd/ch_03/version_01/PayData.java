package com.ebuild.bookstarttdd.ch_03.version_01;

import static java.util.Objects.*;

import java.time.LocalDate;

import lombok.Builder;

public class PayData {

	private LocalDate firstBillingDate;
	private LocalDate billingDate;
	private int payAmount;

	@Builder
	public PayData(LocalDate firstBillingDate, LocalDate billingDate, int payAmount) {
		this.firstBillingDate = firstBillingDate;
		this.billingDate = billingDate;
		this.payAmount = payAmount;
	}

	public LocalDate getFirstBillingDate() {
		return firstBillingDate;
	}

	public LocalDate getBillingDate() {
		return billingDate;
	}

	public boolean existsFirstBillingDate() {
		return !isNull(firstBillingDate);
	}

	public CandidateAddedMonths calculateCandidateAddedMonths() {
		return new CandidateAddedMonths(payAmount / 10_000);
	}

}
