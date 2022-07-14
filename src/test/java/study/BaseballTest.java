package study;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice.BaseballPractice;

//import static org.junit.jupiter.api.Assertions.*;

class BaseballTest {

    private String answer;
    private String input;
    private BaseballPractice baseballPractice;

    @BeforeEach
    void setUp(){
        answer = "713";
        input = "123";
        baseballPractice = new BaseballPractice();
    }

    @Test
    void checkStrike() {

        assertThat(baseballPractice.checkStrike(answer, input)).isEqualTo(1);
    }

    @Test
    void checkBall() {
        assertThat(baseballPractice.checkBall(answer, input)).isEqualTo(1);
    }


    @Test
    void checkSameChar() {
        assertThat(baseballPractice.checkSameChar('1', '2')).isEqualTo(0);
    }

    @Test
    void checkContainSameChar() {
        assertThat(baseballPractice.checkContainSameChar(input, '1', 1)).isEqualTo(1);
    }

    @Test
    void playGame() {
        assertThat(baseballPractice.playGame(answer, input)).isEqualTo("1볼 1스트라이크");
    }
}