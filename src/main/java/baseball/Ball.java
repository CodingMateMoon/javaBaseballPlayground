package baseball;

import java.util.Objects;

public class Ball {
    private final int position;
    private final BallNumber ballNo;

    public Ball(int position, int ballNo) {
        this.position = position;
        this.ballNo = new BallNumber(ballNo);
    }

    /*
    position이 같고 값이 같은 경우 스트라이크.
    position이 다른 경우 다음 단계로 가서 ballNo가 같은지 확인 같으면 BALL.
    position도 ballNo도 다르면 NOTHING
     */
    public BallStatus play(Ball ball) {
        if (this.equals(ball)) {
            return BallStatus.STRIKE;
        }
        if (ball.matchBallNo(ballNo)) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    // 필드에 직접 접근하기보다 해당 객체에 메세지를 보냅니다. match로 비교하는 로직에 변경이 생긴다면 해당 로직(필드값 비교)을 호출하는 부분을 일일히 수정할 필요없이 match 함수만 수정하면 됩니다. 코드의 재사용성을 높일 수 있습니다.
    private boolean matchBallNo(BallNumber ballNo) {
        return this.ballNo == ballNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return position == ball.position && ballNo == ball.ballNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, ballNo);
    }
}
