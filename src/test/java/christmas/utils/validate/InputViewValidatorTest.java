package christmas.utils.validate;

import static christmas.utils.validate.InputViewValidator.validateMenuToExist;
import static christmas.utils.validate.InputViewValidator.validateMore1AndLess31;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.model.OrderInfo;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewValidatorTest {

    @DisplayName("1 이상 31 이하의 숫자가 맞는 경우, 통과")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "30", "31"})
    void validateMore1AndLess31Success(String visitDate) {
        boolean actual = validateMore1AndLess31(visitDate);

        assertThat(actual).isTrue();
    }

    @DisplayName("1 이상 31 이하의 숫자가 아닌 경우, 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"0", "32", "-1", "100", "1j", "31k", "long"})
    void validateMore1AndLess31Failure(String visitDate) {
        assertThatThrownBy(() -> validateMore1AndLess31(visitDate))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("문자열 콤마(,)와 대쉬(-)를 기준으로 분할한 값을 확인")
    @ParameterizedTest
    @ValueSource(strings = {"타파스-1,제로콜라-1"})
    void validateMenuToSplit(String order) {
        OrderInfo orderInfo = new OrderInfo();
        List<String> expected = List.of("타파스", "1", "제로콜라", "1");

        validateMenuToExist(order, orderInfo);

        List<String> actual = orderInfo.getSplitMenus();

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("문자열 분할한 길이가 1보다 클때 콤마(,) 또는 대쉬(-)가 존재하지 않는 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"타파스2", "타파스2,초코케이크-3"})
    void validateMenuToNotSplit(String order) {
        OrderInfo orderInfo = new OrderInfo();

        assertThatThrownBy(() -> validateMenuToExist(order, orderInfo))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}