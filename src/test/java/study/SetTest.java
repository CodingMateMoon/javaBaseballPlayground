package study;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;


public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    // Test Case 구현
    // 요구사항1
    // Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.
    @Test
    void size() {

        assertThat(numbers.size()).isEqualTo(3);
    }

    /*
    요구사항2
    Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습테스트를 구현하려한다.
    구현하고 보니 다음과 같이 중복 코드가 계속해서 발생한다.
    JUnit의 ParameterizedTest를 활용해 중복 코드를 제거해 본다.
    힌트 : Guide to JUnit 5 Parameterized Tests
    https://www.baeldung.com/parameterized-tests-junit-5
     @Test
    void contains(){
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @NullAndEmptySource, @ValueSource를 함께 사용하여 null, empty 등 빈문자열과 여러 값의 문자열들을 모두 포함하는 테스트를 할 수 있습니다.
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"  ", "\t", "\n"})
    void isBlank_ShouldReturnTrueForAllTypesOfBlankStrings(String input) {
        assertTrue(Strings.isBlank(input));
    }
     */

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    /*
    요구사항 3
    요구사항 2는 contains 메소드 결과 값이 true인 경우만 테스트 가능하다. 입력 값에 따라 결과 값이 다른 경우에 대한 테스트도 가능하도록 구현한다.
    예를 들어 1, 2, 3 값은 contains 메소드 실행결과 true, 4, 5 값을 넣으면 false 가 반환되는 테스트를 하나의 Test Case로 구현한다.
    Guide to JUnit 5 Parameterized Tests 문서에서 @CsvSource를 활용한다.
    https://www.baeldung.com/parameterized-tests-junit-5
    toUpperCase() 함수는 기대값으로 대문자 값이 필요합니다. parameterized 테스트 시나리오를 생각할 때 입력값에 대한 기대값 JaVa가 입력되면 JAVA가 기대값인 것과 같이 함수에 전달할 두개의 인자값(입력값, 기대값)이 필요합니다. 그래서 여러 인자값을 전달할 @CSVSource를 사용합니다.
    기본적으로 ','를 구분자로 쓸 수 있지만 delimiter = ':' 와 같이 delimiter 속성을 사용하여 원하는 방식으로 변형할 수 있습니다.
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1) 로 파일 또한 읽어들일 수 있습니다.

    @ParameterizedTest
    @CsvSource({"test,TEST", "tEst,TEST", "Java,JAVA"})
    void toUpperCase_ShouldGenerateTheExpectedUppercaseValue(String input, String expected) {
        String actualValue = input.toUpperCase();
        assertEquals(expected, actualValue);
    }
    @ParameterizedTest
    @CsvSource(value = {"test:test", "tEst:test", "Java:java"}, delimiter = ':')
    void toLowerCase_ShouldGenerateTheExpectedLowercaseValue(String input, String expected) {
        String actualValue = input.toLowerCase();
        assertEquals(expected, actualValue);
    }
     */

    @ParameterizedTest
    @CsvSource(value ={"1:true", "2:true", "3:true", "4:false", "5:false","6:true"}, delimiter = ':')
    void containsCsv(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }


}
