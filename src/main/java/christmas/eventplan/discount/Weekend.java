package christmas.eventplan.discount;

import christmas.constant.discount.WeekendEnum;
import java.util.Arrays;

public class Weekend {

    public int discountOnMainMenu(String currentDate) {
        WeekendEnum weekend = Arrays.stream(WeekendEnum.values())
                .filter(we -> we.getDay().equals(currentDate))
                .findFirst()
                .orElse(WeekendEnum.DAY_NOT_EXIST);

        return weekend.getDiscount();
    }
}
