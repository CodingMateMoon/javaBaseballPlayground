package study;


import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    void setStringCalculator(){
        stringCalculator = new StringCalculator();
    }

    @Test
    void plus() {

        assertThat(stringCalculator.plus(1,2)).isEqualTo(3);
    }

    @Test
    void minus() {
        assertThat(stringCalculator.minus(1,2)).isEqualTo(-1);
    }

    @Test
    void multiple() {
        assertThat(stringCalculator.multiple(3,2)).isEqualTo(6);
    }

    @Test
    void divide() {
        assertThat(stringCalculator.divide(8,2)).isEqualTo(4);
    }
}