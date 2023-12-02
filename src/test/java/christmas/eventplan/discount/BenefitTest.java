package christmas.eventplan.discount;

import static christmas.constant.view.EventPlanner.PLANNER_BEFORE_DISCOUNT;
import static christmas.constant.view.EventPlanner.PLANNER_DISCOUNT_DDAY;
import static christmas.constant.view.EventPlanner.PLANNER_DISCOUNT_GIFT;
import static christmas.constant.view.EventPlanner.PLANNER_DISCOUNT_SPECIAL;
import static christmas.constant.view.EventPlanner.PLANNER_DISCOUNT_WEEKDAY;
import static christmas.constant.view.EventPlanner.PLANNER_DISCOUNT_WEEKEND;
import static christmas.constant.view.EventPlanner.PLANNER_TOTAL_DISCOUNT;
import static org.assertj.core.api.Assertions.assertThat;

import christmas.eventplan.badge.EventBadge;
import christmas.model.UserInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BenefitTest {
    UserInfo userInfo;

    @BeforeEach
    void setUp() {
        userInfo = new UserInfo();
        userInfo.addMenuOrder("양송이수프", 1);
        userInfo.addMenuOrder("타파스", 2);
        userInfo.addEventDetail(PLANNER_DISCOUNT_DDAY.getPlanner(), 1000);
        userInfo.addEventDetail(PLANNER_DISCOUNT_WEEKDAY.getPlanner(), 2023);
        userInfo.addEventDetail(PLANNER_DISCOUNT_WEEKEND.getPlanner(), 2023);
        userInfo.addEventDetail(PLANNER_DISCOUNT_SPECIAL.getPlanner(), 1000);
        userInfo.addEventDetail(PLANNER_DISCOUNT_GIFT.getPlanner(), 25000);
        userInfo.addEventDetail(PLANNER_TOTAL_DISCOUNT.getPlanner(), 20000);
        userInfo.addEventDetail(PLANNER_BEFORE_DISCOUNT.getPlanner(), 50000);
    }

    @DisplayName("이벤트 혜택을 생성할 때 할인 전 총주문 금액을 확인")
    @ParameterizedTest
    @ValueSource(ints = {17000})
    void createEventBenefit(int expected) {
        Benefit benefit = new Benefit();

        int actual = benefit.getTotalOrderAmount(userInfo.getMenuOrders());

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("이벤트로 발생한 총 혜택 금액을 확인")
    @Test
    void createTotalBenefitAmount() {
        Benefit benefit = new Benefit();

        int actual = benefit.createTotalBenefitAmount(userInfo);

        assertThat(actual).isEqualTo(31046);
    }

    @DisplayName("이벤트로 발생한 총 혜택 금액에 따라서 배지 부여 확인")
    @Test
    void createEventBadge() {
        Benefit benefit = new Benefit();
        EventBadge eventBadge = new EventBadge();

        System.out.println(userInfo.getEventDetail(PLANNER_TOTAL_DISCOUNT.getPlanner()));

        String actual = benefit.createEventBadge(userInfo, eventBadge);

        assertThat(actual).contains("산타");
    }

    @DisplayName("할인 전 총주문 금액에서 할인 금액을 제외한 할인 후 예상 결제 금액 확인")
    @Test
    void createDiscountTotalAmount() {
        Benefit benefit = new Benefit();

        int actual = benefit.createDiscountTotalAmount(userInfo);

        assertThat(actual).isEqualTo(55000);
    }


}