package christmas.utils.menu;

import static christmas.exception.MessageHandler.invalidToCount;
import static christmas.exception.MessageHandler.invalidToName;
import static christmas.exception.MessageHandler.invalidToValue;
import static christmas.exception.MessageHandler.notExistComma;
import static christmas.exception.MessageHandler.notExistDash;
import static christmas.utils.validate.OrderedValidator.validateCountOrName;
import static christmas.utils.validate.OrderedValidator.validateDuplicateName;
import static christmas.utils.validate.OrderedValidator.validateMatchesOrderCount;
import static christmas.utils.validate.OrderedValidator.validateMatchesOrderName;
import static christmas.utils.validate.OrderedValidator.validateMaxCount20;
import static christmas.utils.validate.OrderedValidator.validateOnlyDrink;

import christmas.model.OrderInfo;
import christmas.model.UserInfo;
import java.util.List;

public class Ordered {

    public static boolean createMenuOrders(UserInfo userInfo, OrderInfo orderInfo) {
        List<String> splitMenus = orderInfo.getSplitMenus();
        try {
            validateCountOrName(splitMenus, orderInfo);
            addUserInfo(userInfo, orderInfo);
            return true;
        } catch (IllegalArgumentException e) {
            invalidToValue();
            return false;
        }
    }

    private static void addUserInfo(UserInfo userInfo, OrderInfo orderInfo) {
        for (int idx = 0; idx < orderInfo.getNameSize(); idx++) {
            userInfo.addMenuOrder(
                    orderInfo.getNames().get(idx),
                    orderInfo.getCounts().get(idx)
            );
        }
    }

    public static void isName(OrderInfo orderInfo, String menuName) {
        try {
            validateMatchesOrderName(menuName);
            validateDuplicateName(orderInfo);
            validateOnlyDrink(orderInfo);
            addOrderMenuName(orderInfo, menuName);
        } catch (IllegalArgumentException e) {
            invalidToName();
        }
    }

    private static void addOrderMenuName(OrderInfo orderInfo, String menuName) {
        orderInfo.addMenuName(menuName);
    }

    public static void isCount(OrderInfo orderInfo, int menuCount) {
        try {
            validateMatchesOrderCount(menuCount);
            validateMaxCount20(orderInfo);
            addOrderMenuCount(orderInfo, menuCount);
        } catch (IllegalArgumentException e) {
            invalidToCount();
        }
    }

    private static void addOrderMenuCount(OrderInfo orderInfo, int menuCount) {
        orderInfo.addMenuCount(menuCount);
    }

    public static void splitOrderByComma(String order, OrderInfo orderInfo) {
        try {
            String[] splitComma = order.split(",");
            if (!isExistComma(splitComma, order)) {
                notExistComma();
            }
            splitOrderByDash(splitComma, orderInfo);
        } catch (IllegalArgumentException e) {
            notExistComma();
        }
    }

    private static boolean isExistComma(String[] splitComma, String order) {
        if (splitComma.length == 1) {
            return !(order.contains(","));
        }
        return (order.contains(","));
    }

    private static void splitOrderByDash(String[] splitComma, OrderInfo orderInfo) {
        for (String origin : splitComma) {
            try {
                String[] splitDash = origin.split("-");
                if (!isExistDash(origin)) {
                    notExistDash();
                }
                removeSpace(splitDash, orderInfo);
            } catch (IllegalArgumentException e) {
                notExistDash();
            }
        }
    }

    private static boolean isExistDash(String origin) {
        return origin.contains("-");
    }

    private static void removeSpace(String[] splitDash, OrderInfo orderInfo) {
        for (String origin : splitDash) {
            orderInfo.addSplitMenus(origin);
        }
    }
}
