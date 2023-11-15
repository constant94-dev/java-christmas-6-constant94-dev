package christmas.eventplan.discount;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.constant.discount.WeekdayEnum;
import christmas.constant.view.Menu;
import christmas.model.UserInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class WeekdayTest {

    @DisplayName("평일 이벤트 기간에 맞는 할인 금액 확인")
    @ParameterizedTest
    @CsvSource(value = {"3,2023", "4,2023", "10,2023", "11,2023", "28,2023", "31,2023"})
    void discountOnDessertMenu(String currentDate, int expected) {
        Weekday weekday = new Weekday();

        int actual = weekday.discountOnWeekday(currentDate);

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("평일 이벤트 기간에 해당하지 않는 경우 할인 안됨")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "8", "9", "15", "16", "22", "23", "29", "30"})
    void discountOnOrderNotInWeekday(String currentDate) {
        Weekday weekday = new Weekday();

        int actual = weekday.discountOnWeekday(currentDate);

        assertThat(actual).isEqualTo(WeekdayEnum.DAY_NOT_EXIST.getDiscount());
    }

    @DisplayName("평일 이벤트 기간에 해당할 때 디저트 메뉴 할인 가격 확인")
    @ParameterizedTest
    @ValueSource(ints = {12138})
    void discountOnMainMenu(int expected) {
        Weekday weekend = new Weekday();
        UserInfo userInfo = new UserInfo();
        userInfo.changeVisitDate("3");
        userInfo.addMenuOrder(Menu.DESSERT_CAKE.getMenu(), 1);
        userInfo.addMenuOrder(Menu.DESSERT_ICE_CREAM.getMenu(), 5);
        userInfo.addMenuOrder("양송이수프", 5);

        int actual = weekend.discountOnDessertMenu(userInfo);

        assertThat(actual).isEqualTo(expected);
    }
}