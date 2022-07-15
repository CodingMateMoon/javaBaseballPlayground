package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {
    /*
    com.play(new Ball(2,5))로 사용자의 값 하나를 넣었을 때 enum이 nothing이 나오는 경우
     */
    @Test
    void nothing() {
        Ball com = new Ball(1, 4);
        BallStatus status = com.play(new Ball(2, 5));
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }
}
