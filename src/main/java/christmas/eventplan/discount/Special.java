package christmas.eventplan.discount;

import christmas.constant.discount.SpecialEnum;
import java.util.Arrays;

public class Special {

    public int discountOnStarBadge(String currentDate) {
        SpecialEnum special = Arrays.stream(SpecialEnum.values())
                .filter(s -> s.getDay().equals(currentDate))
                .findFirst()
                .orElse(SpecialEnum.DAY_NOT_EXIST);

        return special.getDiscount();
    }
}
