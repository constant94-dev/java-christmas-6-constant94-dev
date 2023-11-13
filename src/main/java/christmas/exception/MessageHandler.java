package christmas.exception;

import static christmas.constant.view.ExceptionMessage.DUPLICATE_MENU;
import static christmas.constant.view.ExceptionMessage.INVALID_TO_COUNT;
import static christmas.constant.view.ExceptionMessage.INVALID_TO_NAME;
import static christmas.constant.view.ExceptionMessage.LIMIT_TO_MENU_COUNT;
import static christmas.constant.view.ExceptionMessage.MORE_1_AND_LESS_31;
import static christmas.constant.view.ExceptionMessage.NOT_EXIST_COMMA;
import static christmas.constant.view.ExceptionMessage.NOT_EXIST_DASH;
import static christmas.constant.view.ExceptionMessage.NOT_ONLY_DRINK;


public final class MessageHandler {
    public static void more1AndLess31() {
        throw new IllegalArgumentException(MORE_1_AND_LESS_31.getMessage());
    }

    public static void duplicateToMenu() {
        throw new IllegalArgumentException(DUPLICATE_MENU.getMessage());
    }

    public static void notExistComma() {
        throw new IllegalArgumentException(NOT_EXIST_COMMA.getMessage());
    }

    public static void notExistDash() {
        throw new IllegalArgumentException(NOT_EXIST_DASH.getMessage());
    }

    public static void invalidToName() {
        throw new IllegalArgumentException(INVALID_TO_NAME.getMessage());
    }

    public static void invalidToCount() {
        throw new IllegalArgumentException(INVALID_TO_COUNT.getMessage());
    }

    public static void notOnlyDrink() {
        throw new IllegalStateException(NOT_ONLY_DRINK.getMessage());
    }

    public static void limitOfMenuCount() {
        throw new IllegalStateException(LIMIT_TO_MENU_COUNT.getMessage());
    }
}
