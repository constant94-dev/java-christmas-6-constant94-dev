package christmas.eventplan.discount;

import christmas.constant.WeekendEnum;
import java.util.Arrays;

public class Weekend {

    public int discountOnMainMenu(String currentDate) {
        WeekendEnum weekend = Arrays.stream(WeekendEnum.values())
                .filter(d -> d.getDay().equals(currentDate))
                .findFirst()
                .orElse(WeekendEnum.DAY_NOT_EXIST);

        return weekend.getDiscount();
    }
}
