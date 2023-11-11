package christmas.eventplan.discount;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.constant.DDayEnum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class DDayTest {

    @DisplayName("크리스마스 디데이 이벤트 기간에 맞는 할인 금액 확인")
    @ParameterizedTest
    @CsvSource(value = {"1,1000", "2,1100", "3,1200", "24,3300", "25,3400"})
    void discountOnTotalOrderAmount(String currentDate, int expected) {
        DDay dDay = new DDay();

        int actual = dDay.discountOnTotalOrderAmount(currentDate);

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("크리스마스 디데이 이벤트 기간에 해당하지 않는 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"0", "26", "27", "28", "29", "30", "31"})
    void discountOnOrderNotInDate(String currentDate) {
        DDay dDay = new DDay();

        int actual = dDay.discountOnTotalOrderAmount(currentDate);

        assertThat(actual).isEqualTo(DDayEnum.DAY_NOT_EXIST.getDiscount());
    }
}