package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {


    private final List<Ball> answers;

    public Balls(List<Integer> answers) {
        this.answers = mapBall(answers);;
    }

    // 인스턴스에 의존할 필요가 없으므로 static으로 만들어줍니다.
    private static List<Ball> mapBall(List<Integer> answers) {
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            balls.add(new Ball(i + 1, answers.get(i)));
        }
        return balls;
    }

    public PlayResult play(List<Integer> balls) {
        Balls userBalls = new Balls(balls);
        PlayResult result = new PlayResult();
        for (Ball answer : answers) {
            BallStatus status = userBalls.play(answer);
            result.report(status);
        }

        return result;
    }

    /*
    스트림 , 람다, Optional 활용
    1. ball List 가져오기
    2. play를 통해 Stream<BallStatus> 가져오기
    3. BallStatus 중 NOTHING이 아닌 것만 가져오기
    4. findFirst() : 가장 처음으로 나온 값 하나 가져오기. Optional<BallStatus>
    5. NOTHING이 아닌 경우가 아에 없으면 BallStatus.NOTHING return
    enum도 JVM내에 유일하게 하나만 존재하는 인스턴스로 enum에게 메세지를 보낼 수 있습니다. enum도 똑같이 내부에 메소드를 가질 수 있습니다.
    */
    public BallStatus play(Ball userBall) {

        return answers.stream()
                .map(answer -> answer.play(userBall))
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse((BallStatus.NOTHING));
    }
}
