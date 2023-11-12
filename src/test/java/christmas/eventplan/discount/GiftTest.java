package christmas.eventplan.discount;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.constant.discount.GiftEnum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class GiftTest {

    @DisplayName("할인 전 총 주문 금액이 12만원 이상일 때, 샴페인 증정 확인")
    @ParameterizedTest
    @CsvSource(value = {"120000,1", "200000,1", "300000,1", "400000,1"})
    void giftOnChampagne(int totalAmount, int expected) {
        Gift gift = new Gift();

        int actual = gift.giftOnChampagne(totalAmount);

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("할인 전 총 주문 금액이 12만원 이하일 때, 샴페인 증정 안함")
    @ParameterizedTest
    @ValueSource(ints = {110000, 100000, 20000, 10000})
    void giftNotHaveChampagne(int totalAmount) {
        Gift gift = new Gift();

        int actual = gift.giftOnChampagne(totalAmount);

        assertThat(actual).isEqualTo(GiftEnum.GIFT_NOT_CHAMPAGNE.getChampagne());
    }
}