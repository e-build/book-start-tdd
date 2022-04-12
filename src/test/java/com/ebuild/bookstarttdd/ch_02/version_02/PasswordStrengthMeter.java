package com.ebuild.bookstarttdd.ch_02.version_02;

public class PasswordStrengthMeter {


    public PasswordStrength meter(String s) {
        if (s == null || s.isEmpty()) {
            return PasswordStrength.INVALID;
        }
        boolean lengthEnough = s.length() >= 8;
        boolean containsNum = meetContainingNumberCriteria(s);
        boolean containsUppercase = meetContainingUppercaseCriteria(s);

        if (lengthEnough && !containsNum && !containsUppercase) {
            return PasswordStrength.WEAK;
        }
        if (!lengthEnough && containsNum && !containsUppercase) {
            return PasswordStrength.WEAK;
        }
        if (!lengthEnough && !containsNum && containsUppercase) {
            return PasswordStrength.WEAK;
        }
        if (!lengthEnough) {
            return PasswordStrength.NORMAL;
        }
        if (!containsNum) {
            return PasswordStrength.NORMAL;
        }
        if (!containsUppercase) {
            return PasswordStrength.NORMAL;
        }
        return PasswordStrength.STRONG;
    }

    private boolean meetContainingUppercaseCriteria(String s) {
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    private boolean meetContainingNumberCriteria(String s) {
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                return true;
            }
        }
        return false;
    }
}
