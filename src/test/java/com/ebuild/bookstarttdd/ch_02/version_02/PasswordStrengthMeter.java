package com.ebuild.bookstarttdd.ch_02.version_02;

public class PasswordStrengthMeter {


    public PasswordStrength meter(String s) {
        if ( s == null || s.isEmpty() )
            return PasswordStrength.INVALID;
        if ( !meetContainingNumberCriteria(s) )
            return PasswordStrength.NORMAL;
        if( s.length() < 8 )
            return PasswordStrength.NORMAL;
        return PasswordStrength.STRONG;
    }

    private boolean meetContainingNumberCriteria(String s) {
        boolean containsNumber = false;
        for (char c : s.toCharArray()){
            if (c >= '0' && c <= '9') {
                containsNumber = true;
                break;
            }
        }
        return containsNumber;
    }
}
