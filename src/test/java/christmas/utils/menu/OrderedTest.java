package christmas.utils.menu;

import static christmas.utils.menu.Ordered.createMenuOrders;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.model.OrderInfo;
import christmas.model.UserInfo;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class OrderedTest {

    @DisplayName("고객 주문 관련 검증이 성공했을 때 통과")
    @ParameterizedTest
    @CsvSource(value = {"양송이수프,1", "티본스테이크,2"})
    void createMenuOrdersSuccess(String menuName, String menuCount) {
        UserInfo userInfo = new UserInfo();
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.addSplitMenus(menuName);
        orderInfo.addSplitMenus(menuCount);

        boolean actual = createMenuOrders(userInfo, orderInfo);

        assertThat(actual).isTrue();
    }

    @DisplayName("고객 주문 관련 검증이 실패했을 때 예외 발생")
    @ParameterizedTest
    @CsvSource(value = {"양송이수프,-1", "OOP,2"})
    void createMenuOrdersFailure(String menuName, String menuCount) {
        UserInfo userInfo = new UserInfo();
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.addSplitMenus(menuName);
        orderInfo.addSplitMenus(menuCount);

        assertThatThrownBy(() -> createMenuOrders(userInfo, orderInfo))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @DisplayName("고객 주문 관련 검증 후 최종 내역 저장되면 통과")
    @Test
    void createUserInfoSuccess() {
        UserInfo userInfo = new UserInfo();
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.addSplitMenus("양송이수프");
        orderInfo.addSplitMenus("1");
        orderInfo.addSplitMenus("티본스테이크");
        orderInfo.addSplitMenus("2");

        Map<String, Integer> expected = Map.of("양송이수프", 1
                , "티본스테이크", 2);

        createMenuOrders(userInfo, orderInfo);

        Map<String, Integer> actual = userInfo.getMenuOrders();

        assertThat(actual).isEqualTo(expected);
    }
}