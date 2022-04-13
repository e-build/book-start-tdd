package com.ebuild.bookstarttdd.ch_03.version_01;

import java.time.LocalDate;
import java.time.YearMonth;

public class ExpiryDateCalculator {

    public LocalDate calculate(PayData payData) {
        final int addedMonths = calculatePayAmount(payData.getPayAmount());
        if (payData.getFirstBillingDate() == null) {
            if (gteTenMonth(addedMonths)) {
                return payData.getBillingDate()
                    .plusYears(calculateAddedYears(addedMonths))
                    .plusMonths(calculateSpareAddedMonth(addedMonths));
            }
            return payData.getBillingDate()
                .plusMonths(addedMonths);
        }
        return expiryDateUsingFirstBillingDate(payData, addedMonths);
    }

    private int calculateSpareAddedMonth(int addedMonths) {
        return addedMonths % 10;
    }

    private int calculateAddedYears(int addedMonths) {
        return addedMonths / 10;
    }

    private boolean gteTenMonth(int addedMonths) {
        return addedMonths / 10 >= 1;
    }

    private LocalDate expiryDateUsingFirstBillingDate(PayData payData, int addedMonths) {
        final int dayOfFirstBilling = payData.getFirstBillingDate().getDayOfMonth();
        LocalDate expiryDateCandidate = payData.getBillingDate().plusMonths(addedMonths);

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

    private int lastDayOfMonth(LocalDate date) {
        return YearMonth.from(date).lengthOfMonth();
    }

    private boolean isSameDayOfMonth(int dayOfFirstBilling, int expiryDay) {
        return dayOfFirstBilling == expiryDay;
    }

    private int calculatePayAmount(int payAmount) {
        return payAmount / 10_000;
    }


}
