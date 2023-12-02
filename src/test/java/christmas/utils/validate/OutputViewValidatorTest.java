package christmas.utils.validate;

import static christmas.constant.view.EventPlanner.PLANNER_DISCOUNT_DDAY;
import static christmas.constant.view.EventPlanner.PLANNER_DISCOUNT_GIFT;
import static christmas.constant.view.EventPlanner.PLANNER_DISCOUNT_SPECIAL;
import static christmas.constant.view.EventPlanner.PLANNER_DISCOUNT_WEEKDAY;
import static christmas.constant.view.EventPlanner.PLANNER_DISCOUNT_WEEKEND;
import static christmas.constant.view.EventPlanner.PLANNER_GIFT_MENU;
import static christmas.constant.view.EventPlanner.PLANNER_TOTAL_DISCOUNT;
import static christmas.constant.view.OrderAnomaly.NO_BENEFIT;
import static christmas.utils.validate.OutputViewValidator.validateDiscount;
import static christmas.utils.validate.OutputViewValidator.validateGift;
import static christmas.utils.validate.OutputViewValidator.validateTotalDiscount;
import static org.assertj.core.api.Assertions.assertThat;

import java.text.NumberFormat;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class OutputViewValidatorTest {

    @DisplayName("증정 메뉴가 있을 때와 없을 때 출력 확인")
    @ParameterizedTest
    @CsvSource(value = {"1,샴페인 1개", "0,없음"})
    void validateGiftToExist(int champagne, String expected) {
        Map<String, Integer> eventDetails = Map.of(
                PLANNER_GIFT_MENU.getPlanner(), champagne
        );

        String actual = validateGift(eventDetails);

        assertThat(actual).contains(expected);
    }

    @DisplayName("고객 혜택 전체 내역 출력 확인")
    @ParameterizedTest
    @CsvSource(value = {"1200,4046,4046,1000,25000"})
    void validateDiscountTotal(int dday, int weekday, int weekend, int special, int gift) {
        Map<String, Integer> eventDetails = Map.of(
                PLANNER_DISCOUNT_DDAY.getPlanner(), dday,
                PLANNER_DISCOUNT_WEEKDAY.getPlanner(), weekday,
                PLANNER_DISCOUNT_WEEKEND.getPlanner(), weekend,
                PLANNER_DISCOUNT_SPECIAL.getPlanner(), special,
                PLANNER_DISCOUNT_GIFT.getPlanner(), gift
        );

        String actual = validateDiscount(eventDetails);

        NumberFormat numberFormat = NumberFormat.getNumberInstance();

        StringBuilder expected = new StringBuilder();
        expected
                .append(PLANNER_DISCOUNT_DDAY.getPlanner())
                .append(": ")
                .append("-")
                .append(numberFormat.format(dday))
                .append("원");

        assertThat(actual).contains(expected);
    }

    @DisplayName("고객 혜택 없을 때 출력 확인")
    @ParameterizedTest
    @CsvSource(value = {"0,0,0,0,0"})
    void validateNoDiscountTotal(int dday, int weekday, int weekend, int special, int gift) {
        Map<String, Integer> eventDetails = Map.of(
                PLANNER_DISCOUNT_DDAY.getPlanner(), dday,
                PLANNER_DISCOUNT_WEEKDAY.getPlanner(), weekday,
                PLANNER_DISCOUNT_WEEKEND.getPlanner(), weekend,
                PLANNER_DISCOUNT_SPECIAL.getPlanner(), special,
                PLANNER_DISCOUNT_GIFT.getPlanner(), gift
        );

        String actual = validateDiscount(eventDetails);

        StringBuilder expected = new StringBuilder();
        expected
                .append(NO_BENEFIT.getNoEvent());

        assertThat(actual).contains(expected);
    }

    @DisplayName("총 혜택 금액에 따라서 달라지는 출력 확인")
    @ParameterizedTest
    @CsvSource(value = {"0,0", "10000,'-10,000'"})
    void validateTotalDiscountForm(int totalDiscount, String expected) {
        Map<String, Integer> eventDetails = Map.of(
                PLANNER_TOTAL_DISCOUNT.getPlanner(), totalDiscount
        );

        String actual = validateTotalDiscount(eventDetails);

        assertThat(actual).isEqualTo(expected);
    }
}