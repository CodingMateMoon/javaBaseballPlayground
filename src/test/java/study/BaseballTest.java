package study;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//import static org.junit.jupiter.api.Assertions.*;

class BaseballTest {

    private String answer;
    private String input;
    private Baseball baseball;

    @BeforeEach
    void setUp(){
        answer = "713";
        input = "123";
        baseball = new Baseball();
    }

    @Test
    void checkStrike() {

        assertThat(baseball.checkStrike(answer, input)).isEqualTo(1);
    }

    @Test
    void checkBall() {
        assertThat(baseball.checkBall(answer, input)).isEqualTo(1);
    }


    @Test
    void checkSameChar() {
        assertThat(baseball.checkSameChar('1', '2')).isEqualTo(0);
    }

    @Test
    void checkContainSameChar() {
        assertThat(baseball.checkContainSameChar(input, '1', 1)).isEqualTo(1);
    }

    @Test
    void playGame() {
        assertThat(baseball.playGame(answer, input)).isEqualTo("1볼 1스트라이크");
    }
}