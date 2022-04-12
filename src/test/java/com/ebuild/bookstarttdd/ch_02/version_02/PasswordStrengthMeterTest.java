package com.ebuild.bookstarttdd.ch_02.version_02;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class PasswordStrengthMeterTest {

    /**
     * # 암호 검사기 예제
     *
     * ### 검사 규칙
     * 1. 길이가 89글자 이상
     * 2. 0 ~ 9 사이의 숫자를 포함
     * 3. 대문자 포함
     *
     * ### 등급 판정
     * 3개의 규칙을 충족 => 암호 강함
     * 2개의 규칙을 충족 => 암호 보통
     * 1개의 규칙을 충족 => 암호 약함
     *
     */

    PasswordStrengthMeter meter = new PasswordStrengthMeter();

    @Test
    void meetsAllCriteria_Then_Strong(){
        assertStrength("ab12!@AB", PasswordStrength.STRONG);
        assertStrength("abc1!Add", PasswordStrength.STRONG);
    }

    @Test
    void meetsOtherCriteria_except_for_Length_Then_Normal(){
        assertStrength("ab12!@A", PasswordStrength.NORMAL);
    }

    @Test
    void meetsOtherCriteria_except_for_Number_Then_Normal(){
        assertStrength("ab!@ABqwer", PasswordStrength.NORMAL);
    }

    private void assertStrength(String password, PasswordStrength expectedStrength){
        PasswordStrength result = meter.meter(password);
        assertThat(result).isEqualTo(expectedStrength);
    }

}
