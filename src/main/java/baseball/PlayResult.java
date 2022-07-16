package baseball;

public class PlayResult {

    private int strike = 0;
    private int ball = 0;

    public int getStrike() {
        return this.strike;
    }

    public int getBall() {
        return this.ball;
    }

    /*
    BallStatus에게 STRIKE인지 묻는 메세지를 보냅니다.
    if(status = BallStatus.STRIKE) -> if (status.isStrike())
    STRIKE를 판단하는 로직이 바뀌면 isStrike() 함수만 수정하면 됩니다
     */
    public void report(BallStatus status) {
        if(status == BallStatus.STRIKE)

        if (status.isStrike()) {
            this.strike += 1;
        }
        if (status.isBall()) {
            this.ball += 1;
        }
    }

    public boolean isGameEnd() {
        return this.strike == 3;
    }
}
