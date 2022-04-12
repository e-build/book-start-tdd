package com.ebuild.bookstarttdd.ch_02.version_01;

import static org.assertj.core.api.Assertions.*;

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

    @Test
    void meetsAllCriteria_Then_Strong(){
        // given

        // when
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.meter("ab12!@AB");
        PasswordStrength result2 = meter.meter("abc1!Add");

        // then
        assertThat(result).isEqualTo(PasswordStrength.STRONG);
        assertThat(result2).isEqualTo(PasswordStrength.STRONG);

    }

    @Test
    void meetsOtherCriteria_except_for_Length_Then_Normal(){
        // given

        // when
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.meter("ab12!@A");

        // then
        assertThat(result).isEqualTo(PasswordStrength.NORMAL);
    }

    @Test
    void meetsOtherCriteria_except_for_Number_Then_Normal(){
        // given

        // when
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.meter("ab!@ABqwer");

        // then
        assertThat(result).isEqualTo(PasswordStrength.NORMAL);
    }

}
