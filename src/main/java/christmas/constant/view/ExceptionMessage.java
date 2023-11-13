package christmas.constant.view;

public enum ExceptionMessage {
    EXCEPTION_TEMPLATE_HEADER("[ERROR] "),
    EXCEPTION_TEMPLATE_DATE("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    EXCEPTION_TEMPLATE_INVALID("유효하지 않은 주문입니다. 다시 입력해 주세요."),
    EXCEPTION_TEMPLATE_DRINK("음료만 주문할 수 없습니다."),
    EXCEPTION_TEMPLATE_LIMIT("메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다."),
    NOT_EXIST_COMMA(EXCEPTION_TEMPLATE_HEADER.message + EXCEPTION_TEMPLATE_INVALID.message),
    NOT_EXIST_DASH(EXCEPTION_TEMPLATE_HEADER.message + EXCEPTION_TEMPLATE_INVALID.message),
    DUPLICATE_MENU(EXCEPTION_TEMPLATE_HEADER.message + EXCEPTION_TEMPLATE_INVALID.message),
    INVALID_TO_NAME(EXCEPTION_TEMPLATE_HEADER.message + EXCEPTION_TEMPLATE_INVALID.message),
    INVALID_TO_COUNT(EXCEPTION_TEMPLATE_HEADER.message + EXCEPTION_TEMPLATE_INVALID.message),
    NOT_ONLY_DRINK(EXCEPTION_TEMPLATE_HEADER.message + EXCEPTION_TEMPLATE_DRINK.message),
    LIMIT_TO_MENU_COUNT(EXCEPTION_TEMPLATE_HEADER.message + EXCEPTION_TEMPLATE_LIMIT.message),
    MORE_1_AND_LESS_31(EXCEPTION_TEMPLATE_HEADER.message + EXCEPTION_TEMPLATE_DATE.message);


    private String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
