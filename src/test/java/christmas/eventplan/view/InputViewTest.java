package christmas.eventplan.view;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {

    @DisplayName("우테코 식당 입장할 때 통과 문구")
    @ParameterizedTest
    @ValueSource(strings = {"안녕하세요!", "우테코 식당", "이벤트 플래너"})
    void helloWooTecoSuccess(String expected) {
        InputView inputView = new InputView();

        String hello = inputView.helloWooTeco();

        assertThat(hello).contains(expected);
    }

    @DisplayName("우테코 식당 입장할 때 실패 문구")
    @ParameterizedTest
    @ValueSource(strings = {"안녕하세요?", "우테코식당", "이벤트플래너"})
    void helloWooTecoFailure(String expected) {
        InputView inputView = new InputView();

        String hello = inputView.helloWooTeco();

        assertThat(hello).doesNotHaveToString(expected);
    }
}