package christmas.eventplan.discount;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.constant.SpecialEnum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class SpecialTest {

    @DisplayName("특별 할인 기간에 맞는 할인 금액 확인")
    @ParameterizedTest
    @CsvSource(value = {"3,1000", "10,1000", "17,1000", "24,1000", "25,1000", "31,1000"})
    void discountOnStarBadge(String currentDate, int expected) {
        Special special = new Special();

        int actual = special.discountOnStarBadge(currentDate);

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("특별 할인 기간에 해당하지 않는 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "4", "5", "6", "7", "8", "9", "11", "12", "13", "14", "15", "16", "18", "19",
            "20", "21", "22", "23", "26", "27", "28", "29", "30"})
    void discountOnCalendarNotHaveStar(String currentDate) {
        Special special = new Special();

        int actual = special.discountOnStarBadge(currentDate);

        assertThat(actual).isEqualTo(SpecialEnum.DAY_NOT_EXIST.getDiscount());
    }
}