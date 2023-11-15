package christmas.utils.validate;

import static christmas.constant.view.Limit.MENU_COUNT_MAX;
import static christmas.constant.view.Limit.MENU_COUNT_MIN;
import static christmas.constant.view.Menu.DRINK_CHAMPAGNE;
import static christmas.constant.view.Menu.DRINK_COKE;
import static christmas.constant.view.Menu.DRINK_WINE;
import static christmas.constant.view.Menu.NOT_EXIST_MENU;
import static christmas.constant.view.Menu.ONLY_TO_DRINK;
import static christmas.constant.view.Menu.values;
import static christmas.exception.MessageHandler.duplicateToMenu;
import static christmas.exception.MessageHandler.invalidToCount;
import static christmas.exception.MessageHandler.invalidToName;
import static christmas.exception.MessageHandler.limitOfMenuCount;
import static christmas.exception.MessageHandler.notOnlyDrink;
import static christmas.utils.menu.Ordered.isCount;
import static christmas.utils.menu.Ordered.isName;

import christmas.constant.view.Menu;
import christmas.model.OrderInfo;
import java.util.Arrays;
import java.util.List;

public final class OrderedValidator {

    public static void validateMatchesOrderName(String menuName) {
        if (isValidToName(menuName) == NOT_EXIST_MENU) {
            invalidToName();
        }
    }

    private static Menu isValidToName(String menuName) {
        return Arrays.stream(values())
                .filter(m -> m.getMenu().equals(menuName))
                .findFirst()
                .orElse(NOT_EXIST_MENU);
    }

    public static void validateMatchesOrderCount(int menuCount) {
        if (!isValidCount(menuCount)) {
            invalidToCount();
        }
    }

    private static boolean isValidCount(int menuCount) {
        return (MENU_COUNT_MAX.getCount() >= menuCount && MENU_COUNT_MIN.getCount() <= menuCount);
    }

    public static void validateOnlyDrink(OrderInfo orderInfo) {
        List<String> drink = List.of(DRINK_COKE.getMenu(), DRINK_WINE.getMenu(), DRINK_CHAMPAGNE.getMenu());

        long remainingCount = orderInfo.removeToDrink(drink);

        if (remainingCount == ONLY_TO_DRINK.getPrice()) {
            notOnlyDrink();
        }
    }

    public static void validateMaxCount20(OrderInfo orderInfo) {
        int count = orderInfo.maxToCount();

        if (count > MENU_COUNT_MAX.getCount()) {
            limitOfMenuCount();
        }
    }

    public static void validateDuplicateName(OrderInfo orderInfo) {
        int size = orderInfo.getNameSize();
        long duplicateSize = orderInfo.duplicateName();

        if (size != duplicateSize) {
            duplicateToMenu();
        }
    }

    public static void validateCountOrName(List<String> splitMenus, OrderInfo orderInfo) {
        for (String menu : splitMenus) {
            try {
                isCount(orderInfo, Integer.parseInt(menu));
            } catch (NumberFormatException e) {
                isName(orderInfo, menu);
            }
        }
    }
}
