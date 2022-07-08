package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.*;


public class StringTest {

    class Frodo {
        private int age;
        private String name;

        Frodo(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    // assertions 문서 참고 : https://joel-costigliola.github.io/assertj/assertj-core-features-highlight.html#exception-assertion
    /*
    isInstanceOf : 실제 값이 주어진 타입(ex. Exception.class)의 인스턴스인지 확인합니다.
    public interface ThrowableAssert.ThrowingCallable : 함수형 인터페이스
    * */
    @Test
    public void assertThatThrownByExample() {
        assertThatThrownBy(() -> {
            throw new Exception("boom!");
        }).isInstanceOf(Exception.class)
                .hasMessageContaining("boom");
    }

    @Test
    public void assertThatThrownByExampleBDD() {
        // given some preconditions

        // when
        Throwable thrown = catchThrowable(() -> { throw new Exception("boom!"); });

        // then
        assertThat(thrown).isInstanceOf(Exception.class)
                .hasMessageContaining("boom");
    }

    @Test
    public void assertThatThrownByExampleAdd() {
        // assertion will fail but "display me" won't appear in the error
        /*
        java.lang.AssertionError:
        Expecting code to raise a throwable.
        * */
        assertThatThrownBy(() -> {
        }).as("display me")
                .isInstanceOf(Exception.class);
    }

    @Test
    public void assertThatThrownByExampleAdd2() {

        // assertion will fail AND "display me" will appear in the error
        /*
        java.lang.AssertionError: [display me]
        Expecting actual not to be null
        * */
        Throwable thrown = catchThrowable(() -> {
        });
        assertThat(thrown).as("display me")
                .isInstanceOf(Exception.class);
    }

    @Test
    public void assertErrorTest2() {

        Frodo frodo = new Frodo("Frodo");

        try {
            // set an incorrect age to Mr Frodo which is really 33 years old.
            frodo.setAge(50);
            // specify a test description (call as() before the assertion !), it supports String format syntax.
            assertThat(frodo.getAge()).as("check %s's age", frodo.getName()).isEqualTo(33);
        } catch (AssertionError e) {
            assertThat(e).hasMessage("[check Frodo's age]\nexpected: 33\nbut was : 50");
        }
    }

    @Test
    public void assertThatExceptionOfTypeExample() {
        assertThatExceptionOfType(IOException.class).isThrownBy(() -> {
                    throw new IOException("boom!");
                })
                .withMessage("%s!", "boom")
                .withMessageContaining("boom")
                .withNoCause();
    }

    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {

        String ex = "1,2";
        String ex2 = "1";

        String[] exArray = ex.split(",");
        String[] exArray2 = ex2.split(",");

        assertThat(exArray).contains("1");
        assertThat(exArray).contains("2");
        assertThat(exArray).containsExactly("1", "2");
        assertThat(exArray2).containsExactly("1");
    }

    @Test
    void substring() {
        String input = "(1,2)";
        input = input.substring(1);
        input = input.substring(0, input.length() - 1);
        System.out.println(input);
        assertThat(input).isEqualTo("1,2");
    }

    @Test
    void charAt() {
        String input = "abc";
        int index = 1;

        assertThat(input.charAt(index)).isEqualTo('b');
    }

    /*
    int index = 1;

    assertThatThrownBy(() -> {

        assertThat(input.charAt(index)).isEqualTo('b');
    }).isInstanceOf(IndexOutOfBoundsException.class).hasMessageContaining("%d", index);
    IndexOutOfBoundsException이 발생하지 않으면 isInstanceOf(IndexOutOfBoundsException.class)에서 조건을 충족시키지 못하므로 AssertionError가 발생합니다.
    java.lang.AssertionError:
    Expecting code to raise a throwable.
    * */
    @Test
    @DisplayName("ChatAt 테스트에서 assertThatThrownBy를 활용하여 Exception 처리")
    void charAtException() {
        String input = "abc";
        int index = 5;

        assertThatThrownBy(() -> {

            assertThat(input.charAt(index)).isEqualTo('b');
        }).isInstanceOf(IndexOutOfBoundsException.class).hasMessageContaining("%d", index);
    }

    @Test
    @DisplayName("charAt에서 assertThatExceptionOfType을 사용하여 Exception 처리")
    void charAtException2() {

        String str = "abc";
        int index = 21;

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    char c = str.charAt(index);
                    assertThat(c).isEqualTo('c');
                }).withMessageContaining("%d", index);
    }

}
