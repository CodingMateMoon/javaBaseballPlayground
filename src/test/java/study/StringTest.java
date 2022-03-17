package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.*;


public class
StringTest {
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
        input = input.substring(0, input.length()-1);
        System.out.println(input);
        assertThat(input).isEqualTo("1,2");
    }

    @Test
    void charAt() {
        String input = "abc";
        int index = 1;

        assertThat(input.charAt(index)).isEqualTo('b');
    }

    @Test
    @DisplayName("ChatAt 테스트에서 assertThatThrownBy를 활용하여 Exception 처리")
    void charAtException() {
        String input = "abc";
        int index = 22;

        assertThatThrownBy(()->{

            assertThat(input.charAt(index)).isEqualTo('b');
        }).isInstanceOf(StringIndexOutOfBoundsException.class).hasMessageContaining("%d",index);
    }
}
