package christmas.utils.validate;

import static christmas.exception.MessageHandler.more1AndLess31;
import static christmas.utils.menu.Ordered.splitOrderByComma;

import christmas.model.OrderInfo;

public final class InputViewValidator {

    public static boolean validateMore1AndLess31(String visitDate) {
        if (!validateMatchesVisitDate(visitDate)) {
            more1AndLess31();
            return false;
        }
        return true;
    }

    private static boolean validateMatchesVisitDate(String visitDate) {
        return visitDate.matches("^(?:[1-9]|[12]\\d|3[0-1])$");
    }

    public static void validateMenuToExist(String order, OrderInfo orderInfo) {
        splitOrderByComma(order, orderInfo);
    }
}
