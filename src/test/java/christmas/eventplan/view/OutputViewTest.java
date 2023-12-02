package christmas.eventplan.view;

import static christmas.constant.view.EventPlanner.PLANNER_AFTER_DISCOUNT;
import static christmas.constant.view.EventPlanner.PLANNER_BEFORE_DISCOUNT;
import static christmas.constant.view.EventPlanner.PLANNER_DISCOUNT_DDAY;
import static christmas.constant.view.EventPlanner.PLANNER_DISCOUNT_GIFT;
import static christmas.constant.view.EventPlanner.PLANNER_DISCOUNT_SPECIAL;
import static christmas.constant.view.EventPlanner.PLANNER_DISCOUNT_WEEKDAY;
import static christmas.constant.view.EventPlanner.PLANNER_DISCOUNT_WEEKEND;
import static christmas.constant.view.EventPlanner.PLANNER_GIFT_MENU;
import static christmas.constant.view.EventPlanner.PLANNER_TOTAL_DISCOUNT;
import static org.assertj.core.api.Assertions.assertThat;

import christmas.eventplan.badge.EventBadge;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class OutputViewTest {
    OutputView outputView;

    @BeforeEach
    void setUp() {
        outputView = new OutputView();
    }

    @DisplayName("고객이 입력한 예상 방문 날짜 출력 확인")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "5", "30", "31"})
    void printWooTecoEventPreview(String visitDate) {
        outputView.printWooTecoEventPreview(visitDate);
    }

    @DisplayName("고객이 주문한 메뉴 출력 확인")
    @Test
    void printOrderToMenu() {
        Map<String, Integer> menuOrders = Map.of(
                "타파스", 1,
                "제로콜라", 2
        );
        outputView.printOrderToMenu(menuOrders);
    }

    @DisplayName("할인 전 총주문 금액 확인")
    @ParameterizedTest
    @ValueSource(ints = {8500, 10000, 45000, 100000})
    void printTotalOrderAmountBeforeDiscount(int amount) {
        Map<String, Integer> eventDetails = Map.of(
                PLANNER_BEFORE_DISCOUNT.getPlanner(), amount
        );

        outputView.printTotalOrderAmountBeforeDiscount(eventDetails);
    }

    @DisplayName("증정 메뉴 출력 확인")
    @ParameterizedTest
    @ValueSource(ints = {0, 1})
    void printGiftToMenu(int gift) {
        Map<String, Integer> eventDetails = Map.of(
                PLANNER_GIFT_MENU.getPlanner(), gift
        );

        outputView.printGiftToMenu(eventDetails);
    }

    @DisplayName("혜택 내역 출력 확인")
    @Test
    void printDiscountDetails() {
        Map<String, Integer> eventDetails =
                Map.of(
                        PLANNER_DISCOUNT_DDAY.getPlanner(), 1000,
                        PLANNER_DISCOUNT_WEEKDAY.getPlanner(), 2023,
                        PLANNER_DISCOUNT_WEEKEND.getPlanner(), 2023,
                        PLANNER_DISCOUNT_SPECIAL.getPlanner(), 1000,
                        PLANNER_DISCOUNT_GIFT.getPlanner(), 25000
                );
        outputView.printDiscountDetails(eventDetails);
    }

    @DisplayName("총 혜택 내역 출력 확인")
    @Test
    void printTotalDiscount() {
        Map<String, Integer> eventDetails =
                Map.of(
                        PLANNER_TOTAL_DISCOUNT.getPlanner(), 31406
                );
        outputView.printTotalDiscount(eventDetails);
    }

    @DisplayName("할인 후 예상 결제 금액 출력 확인")
    @Test
    void printEstimatedAmountAfterDiscount() {
        Map<String, Integer> eventDetails =
                Map.of(
                        PLANNER_BEFORE_DISCOUNT.getPlanner(), 65000,
                        PLANNER_TOTAL_DISCOUNT.getPlanner(), 31406,
                        PLANNER_AFTER_DISCOUNT.getPlanner(), 135754
                );

        outputView.printEstimatedAmountAfterDiscount(eventDetails);
    }

    @DisplayName("12월 이벤트 배지 확인")
    @ParameterizedTest
    @CsvSource(value = {"4000,없음", "5000,별", "10000,트리", "20000,산타"})
    void printEventBadge(int totalBenefitAmount, String expected) {
        EventBadge eventBadge = new EventBadge();

        String badge = eventBadge.grantToBadge(totalBenefitAmount);
        eventBadge.changeBadgeStatus(badge);
        outputView.printEventBadge(expected);

        String actual = eventBadge.getBadgeStatus();
        assertThat(actual).isEqualTo(expected);
    }
}