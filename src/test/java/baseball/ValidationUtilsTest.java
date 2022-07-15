package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidationUtilsTest {
    /*
    테스트 코드는 소통이 중요. 팀 컨벤션 만들고 사용
    input과 output이 중요합니다.
    1 ~ 9 경계값 체크. 1, 9, 0, 10 등 경계값을 체크하여 최소한의 테스트 케이스로 모든 예외사항들을 테스트하는 코드 작성
     */
    @Test
    @DisplayName("야구_숫자_1_9_검증 display")
    void 야구_숫자_1_9_검증(){

        assertThat(ValidationUtils.validNo(9)).isTrue();
        assertThat(ValidationUtils.validNo(1)).isTrue();
        assertThat(ValidationUtils.validNo(0)).isFalse();
        assertThat(ValidationUtils.validNo(10)).isFalse();
    }
}
