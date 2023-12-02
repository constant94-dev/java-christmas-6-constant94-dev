package christmas.utils.validate;

import static christmas.utils.validate.OrderedValidator.validateCountOrName;
import static christmas.utils.validate.OrderedValidator.validateDuplicateName;
import static christmas.utils.validate.OrderedValidator.validateMatchesOrderCount;
import static christmas.utils.validate.OrderedValidator.validateMatchesOrderName;
import static christmas.utils.validate.OrderedValidator.validateMaxCount20;
import static christmas.utils.validate.OrderedValidator.validateOnlyDrink;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

import christmas.model.OrderInfo;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class OrderedValidatorTest {

    @DisplayName("주문한 메뉴 이름이 유효할 때 통과")
    @ParameterizedTest
    @ValueSource(strings = {"양송이수프", "타파스", "시저샐러드", "티본스테이크", "바비큐립"
            , "해산물파스타", "크리스마스파스타", "초코케이크", "아이스크림", "제로콜라", "레드와인", "샴페인"})
    void validateMatchesOrderNameIsValidToName(String menuName) {
        validateMatchesOrderName(menuName);

        assertTrue(true);
    }

    @DisplayName("주문한 메뉴 이름이 유효하지 않을 때 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"dk", "양송이", "타파", "메뉴없어요", "초코"})
    void validateOrderNameIsInvalidToName(String menuName) {
        assertThatThrownBy(() -> validateMatchesOrderName(menuName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");

    }

    @DisplayName("주문한 개수가 유효할 때 통과")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20})
    void validateMatchesOrderCountIsValidCount(int menuCount) {
        validateMatchesOrderCount(menuCount);

        assertTrue(true);
    }

    @DisplayName("주문한 개수가 유효하지 않을 때 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {0, 21, -1})
    void validateMatchesOrderCountIsInvalidCount(int menuCount) {
        assertThatThrownBy(() -> validateMatchesOrderCount(menuCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @DisplayName("음료만 주문하지 않았을 때 통과")
    @Test
    void validateOrderNotOnlyDrink() {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.addMenuName("양송이수프");
        orderInfo.addMenuName("티본스테이크");
        orderInfo.addMenuName("초코케이크");
        orderInfo.addMenuName("제로콜라");

        validateOnlyDrink(orderInfo);

        assertTrue(true);
    }

    @DisplayName("음료만 주문했을 때 예외 발생")
    @Test
    void validateOrderOnlyDrink() {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.addMenuName("레드와인");
        orderInfo.addMenuName("샴페인");
        orderInfo.addMenuName("제로콜라");

        assertThatThrownBy(() -> validateOnlyDrink(orderInfo))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("[ERROR] 음료만 주문할 수 없습니다.");
    }

    @DisplayName("주문한 총 개수가 20개 이하일 때 통과")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15
            , 16, 17, 18, 19, 20})
    void validateMaxCountLess20(int menuCount) {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.addMenuCount(menuCount);

        validateMaxCount20(orderInfo);

        assertTrue(true);
    }

    @DisplayName("주문한 총 개수가 20개 초과일 때 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {21, 22, 23, 24, 25, 100})
    void validateMaxCountMore20(int menuCount) {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.addMenuCount(menuCount);

        assertThatThrownBy(() -> validateMaxCount20(orderInfo))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("[ERROR] 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.");
    }

    @DisplayName("주문 메뉴 이름 중 중복된 메뉴가 없을 때 통과")
    @Test
    void validateNotDuplicateName() {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.addMenuName("양송이수프");
        orderInfo.addMenuName("티본스테이크");
        orderInfo.addMenuName("초코케이크");

        validateDuplicateName(orderInfo);

        assertTrue(true);
    }

    @DisplayName("주문 메뉴 이름 중 중복된 메뉴가 있을 때 예외 발생")
    @Test
    void validateDuplicateToName() {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.addMenuName("양송이수프");
        orderInfo.addMenuName("양송이수프");

        assertThatThrownBy(() -> validateDuplicateName(orderInfo))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @DisplayName("주문 메뉴 이름과 개수 검증이 문제 없을 때 통과")
    @ParameterizedTest
    @CsvSource(value = {"양송이수프,1", "티본스테이크,2"})
    void validateCountOrNameSuccess(String menuName, String menuCount) {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.addSplitMenus(menuName);
        orderInfo.addSplitMenus(menuCount);
        List<String> splitMenus = orderInfo.getSplitMenus();

        validateCountOrName(splitMenus, orderInfo);

        assertTrue(true);
    }

    @DisplayName("주문 메뉴 이름과 개수 검증이 문제 있을 때 실패")
    @ParameterizedTest
    @CsvSource(value = {"양송이d,1", "티본스테이크,-2"})
    void validateCountOrNameFailure(String menuName, String menuCount) {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.addSplitMenus(menuName);
        orderInfo.addSplitMenus(menuCount);
        List<String> splitMenus = orderInfo.getSplitMenus();

        assertThatThrownBy(() -> validateCountOrName(splitMenus, orderInfo))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("");
    }
}