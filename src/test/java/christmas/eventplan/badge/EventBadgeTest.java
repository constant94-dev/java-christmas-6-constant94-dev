package christmas.eventplan.badge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class EventBadgeTest {

    @DisplayName("총 혜택 금액에 따라서 이벤트 배지 부여")
    @ParameterizedTest
    @CsvSource(value = {"5000,별", "9000,별", "10000,트리", "19000,트리", "20000,산타", "30000,산타", "4000,없음", "1000,없음"})
    void grantToBadge(int totalBenefitAmount, String expected) {
        EventBadge eventBadge = new EventBadge();

        String actual = eventBadge.grantToBadge(totalBenefitAmount);

        assertThat(actual).isEqualTo(expected);
    }
}