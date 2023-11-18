package christmas.eventplan.discount;

import christmas.constant.discount.DDayEnum;
import java.util.Arrays;

public class DDay {

    public int discountOnDDay(String currentDate) {
        DDayEnum dDay = Arrays.stream(DDayEnum.values())
                .filter(d -> d.getDay().equals(currentDate))
                .findFirst()
                .orElse(DDayEnum.DAY_NOT_EXIST);

        return dDay.getDiscount();
    }
}
