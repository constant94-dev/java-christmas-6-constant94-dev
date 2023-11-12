package christmas.eventplan.discount;

import christmas.constant.WeekdayEnum;
import java.util.Arrays;

public class Weekday {

    public int discountOnDessertMenu(String currentDate) {
        WeekdayEnum weekday = Arrays.stream(WeekdayEnum.values())
                .filter(wd -> wd.getDay().equals(currentDate))
                .findFirst()
                .orElse(WeekdayEnum.DAY_NOT_EXIST);

        return weekday.getDiscount();
    }
}
