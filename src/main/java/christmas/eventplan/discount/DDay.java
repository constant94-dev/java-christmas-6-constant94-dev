package christmas.eventplan.discount;

import christmas.constant.DDayEnum;
import java.util.Arrays;

public class DDay {

    public int discountOnTotalOrderAmount(String currentDate) {
        DDayEnum date = Arrays.stream(DDayEnum.values())
                .filter(d -> d.getDay().equals(currentDate))
                .findFirst()
                .orElse(DDayEnum.DAY_NOT_EXIST);

        return date.getDiscount();
    }
}
