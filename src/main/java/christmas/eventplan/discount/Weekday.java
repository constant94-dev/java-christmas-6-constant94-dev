package christmas.eventplan.discount;


import static christmas.constant.view.OrderAnomaly.NO_DISCOUNT_WEEKDAY;

import christmas.constant.discount.WeekdayEnum;
import christmas.constant.view.Menu;
import christmas.model.UserInfo;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class Weekday {

    public int discountOnWeekday(String currentDate) {
        WeekdayEnum weekday = Arrays.stream(WeekdayEnum.values())
                .filter(wd -> wd.getDay().equals(currentDate))
                .findFirst()
                .orElse(WeekdayEnum.DAY_NOT_EXIST);

        return weekday.getDiscount();
    }

    public int discountOnDessertMenu(UserInfo userInfo) {
        List<String> main = List.of(
                Menu.DESSERT_CAKE.getMenu(),
                Menu.DESSERT_ICE_CREAM.getMenu()
        );
        Set<Entry<String, Integer>> menus = userInfo.getMenuOrders().entrySet();
        int discount = 0;

        for (Entry<String, Integer> menu : menus) {
            discount = hasDiscountWeekday(main, menu, discount);
        }

        return discountWeekdayResult(userInfo, discount);
    }

    private int discountWeekdayResult(UserInfo userInfo, int discount) {
        WeekdayEnum weekdayEnum = Arrays.stream(WeekdayEnum.values())
                .filter(w -> w.getDay().equals(userInfo.getVisitDate()))
                .findFirst()
                .orElse(WeekdayEnum.DAY_NOT_EXIST);

        return weekdayEnum.getDiscount() * discount;
    }

    private int hasDiscountWeekday(List<String> main, Entry<String, Integer> menu, int discount) {
        String item = main.stream()
                .filter(m -> m.equals(menu.getKey()))
                .findFirst()
                .orElse(NO_DISCOUNT_WEEKDAY.getNoEvent());

        return isItem(item, menu.getValue(), discount);
    }

    private int isItem(String item, Integer menu, int discount) {
        if (!item.equals(NO_DISCOUNT_WEEKDAY.getNoEvent())) {
            discount += menu;
        }
        return discount;
    }
}
