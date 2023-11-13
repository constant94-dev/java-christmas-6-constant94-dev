package christmas.utils.menu;

import static christmas.exception.MessageHandler.invalidToCount;
import static christmas.exception.MessageHandler.invalidToName;
import static christmas.exception.MessageHandler.notExistComma;
import static christmas.exception.MessageHandler.notExistDash;
import static christmas.utils.validate.OrderValidator.validateDuplicateName;
import static christmas.utils.validate.OrderValidator.validateMatchesOrderCount;
import static christmas.utils.validate.OrderValidator.validateMatchesOrderName;
import static christmas.utils.validate.OrderValidator.validateMaxCount20;
import static christmas.utils.validate.OrderValidator.validateOnlyDrink;

import christmas.model.OrderInfo;
import christmas.model.UserInfo;
import java.util.ArrayList;
import java.util.List;

public final class Ordered {
    private static List<String> convertOrders;

    public static boolean createMenuOrders(UserInfo userInfo, OrderInfo orderInfo) {
        // 고객 주문 검증 모두 통과 후 UserInfo 추가
        try {
            for (String order : convertOrders) {
                isName(orderInfo, order);
                isCount(orderInfo, order);
            }

            addUserInfo(userInfo, orderInfo);
            return true;
        } catch (NullPointerException e) {
            e.printStackTrace();
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

    public static void splitOrderByComma(String order) {
        try {
            String[] original = order.split(",");
            splitOrderByDash(original);
        } catch (IllegalArgumentException | IllegalStateException e) {
            notExistComma();
        }
    }

    private static void splitOrderByDash(String[] originals) {
        for (String origin : originals) {
            try {
                String[] original = origin.split("-");
                removeSpace(original);
            } catch (IllegalArgumentException | IllegalStateException e) {
                notExistDash();
            }
        }
    }

    private static void removeSpace(String[] originals) {
        convertOrders = new ArrayList<>();
        for (String origin : originals) {
            convertOrders.add(origin.trim());
        }
    }

    private static void isName(OrderInfo orderInfo, String menuName) {
        try {
            validateMatchesOrderName(menuName);
            // 중복 메뉴를 입력한 경우 예외 처리
            validateDuplicateName(orderInfo);
            // 음료만 주문 시, 주문할 수 없는 로직
            validateOnlyDrink(orderInfo);
            addOrderMenuName(orderInfo, menuName);
        } catch (IllegalArgumentException | IllegalStateException e) {
            invalidToName();
        }
    }

    private static void addOrderMenuName(OrderInfo orderInfo, String menuName) {
        orderInfo.addMenuName(menuName);
    }

    private static void isCount(OrderInfo orderInfo, String menuCount) {
        try {
            int count = Integer.parseInt(menuCount);
            validateMatchesOrderCount(count);
            // 메뉴는 최대 20개까지만 주문할 수 있는 로직
            validateMaxCount20(orderInfo);
            addOrderMenuCount(orderInfo, count);
        } catch (IllegalArgumentException | IllegalStateException e) {
            invalidToCount();
        }
    }

    private static void addOrderMenuCount(OrderInfo orderInfo, int menuCount) {
        orderInfo.addMenuCount(menuCount);
    }
}
