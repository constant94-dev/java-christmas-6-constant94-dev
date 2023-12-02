package christmas.eventplan.discount;

import christmas.constant.discount.GiftEnum;
import java.util.Arrays;

public class Gift {

    public int giftOnChampagne(int totalAmount) {
        GiftEnum gift = Arrays.stream(GiftEnum.values())
                .filter(g -> g.getTotalAmount() <= totalAmount)
                .findFirst()
                .orElse(GiftEnum.GIFT_NOT_CHAMPAGNE);

        return gift.getChampagne();
    }
}
