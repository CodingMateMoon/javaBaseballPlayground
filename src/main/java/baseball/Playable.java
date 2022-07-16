package baseball;

import java.util.List;

// 구현체가 여러 개인 경우 인터페이스로 정의할 수 있습니다. play에서 구현체 변경 가능성이 있는 경우 인터페이스로 추출해서 구현합니다.
public interface Playable {
    PlayResult play(List<Integer> balls);
}
