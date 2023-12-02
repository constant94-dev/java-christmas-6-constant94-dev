package christmas.eventplan.discount;

import static christmas.constant.view.OrderAnomaly.NO_DISCOUNT_WEEKEND;

import christmas.constant.discount.WeekendEnum;
import christmas.constant.view.Menu;
import christmas.model.UserInfo;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class Weekend {

    public int discountOnWeekend(String currentDate) {
        WeekendEnum weekend = Arrays.stream(WeekendEnum.values())
                .filter(we -> we.getDay().equals(currentDate))
                .findFirst()
                .orElse(WeekendEnum.DAY_NOT_EXIST);

        return weekend.getDiscount();
    }

    public int discountOnMainMenu(UserInfo userInfo) {
        List<String> main = List.of(
                Menu.MAIN_SEA_PASTA.getMenu(),
                Menu.MAIN_CHRISTMAS_PASTA.getMenu(),
                Menu.MAIN_BARBECUE.getMenu(),
                Menu.MAIN_STEAK.getMenu());
        Set<Entry<String, Integer>> menus = userInfo.getMenuOrders().entrySet();
        int discount = 0;

        for (Entry<String, Integer> menu : menus) {
            discount = hasDiscountWeekend(main, menu, discount);
        }

        return discountWeekendResult(userInfo, discount);
    }

    private int discountWeekendResult(UserInfo userInfo, int discount) {
        WeekendEnum weekendEnum = Arrays.stream(WeekendEnum.values())
                .filter(w -> w.getDay().equals(userInfo.getVisitDate()))
                .findFirst()
                .orElse(WeekendEnum.DAY_NOT_EXIST);

        return weekendEnum.getDiscount() * discount;
    }

    private int hasDiscountWeekend(List<String> main, Entry<String, Integer> menu, int discount) {
        String item = main.stream()
                .filter(m -> m.equals(menu.getKey()))
                .findFirst()
                .orElse(NO_DISCOUNT_WEEKEND.getNoEvent());

        return isItem(item, menu.getValue(), discount);
    }

    private int isItem(String item, Integer menu, int discount) {
        if (!item.equals(NO_DISCOUNT_WEEKEND.getNoEvent())) {
            discount += menu;
        }
        return discount;
    }
}
