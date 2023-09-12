package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class SpringTest {
    @DisplayName("문자열에서 ','를 기준으로 분리하여 1과 2가 분리되면 성공한다.")
    @Test
    public void 문자열_분리_테스트() {
        //given
        String word = "1,2";

        //when
        String[] results = word.split(",");

        //then
        assertThat(List.of(results).containsAll(List.of("1", "2"))).isTrue();
    }

    @Test
    @DisplayName("1을 ','을 기준으로 분리했을 때 1만 나오면 성공한다.")
    public void 하나의_문자열만_나오는지_확인_테스트() {
        //given
        String word = "1";

        //when
        String[] results = word.split(",");

        // then
        assertThat(results).containsExactly("1");
    }

    @Test
    @DisplayName("문자열 (1,2) 가 들어오면 ()는 제거하고 1,2를 반환하면 성공한다.")
    public void 괄호_제거_및_1과2를_정상반환_테스트() {
        //given
        String word = "(1,2)";

        //when
        String[] results = word.replaceAll("[\\( \\)]", "").split(",");

        //then
        assertThat(List.of(results)).containsExactly("1", "2");
    }

    @Test
    @DisplayName("문자열 abc 에서 1번째 문자를 정상적으로 반환하면 성공한다.")
    public void 문자열_첫번째_인덱스_반환_테스트() {
        //given
        String word = "abc";

        //when,then
        assertThat(word.charAt(0)).isEqualTo('a');
    }

    @Test
    @DisplayName("문자열 abc 에서 4번째 문제를 호출하면 StringIndexOutOfBoundsException가 발생")
    public void 문자열_인덱스_범위_바깥으로_나갈때_처리_테스트() {
        //given
        String word = "abc";

        //when,then
        assertThatThrownBy(() -> word.charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("index out");
    }
}
