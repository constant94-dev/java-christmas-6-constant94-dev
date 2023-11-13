package christmas.constant.view;

public enum Exception {
    EXCEPTION_TEMPLATE_HEADER("[ERROR] "),
    EXCEPTION_TEMPLATE_DATE("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    EXCEPTION_TEMPLATE_INVALID("유효하지 않은 주문입니다. 다시 입력해 주세요."),
    NOT_EXIST_COMMA(EXCEPTION_TEMPLATE_HEADER.message + EXCEPTION_TEMPLATE_INVALID.message),
    NOT_EXIST_DASH(EXCEPTION_TEMPLATE_HEADER.message + EXCEPTION_TEMPLATE_INVALID.message),
    DUPLICATE_MENU(EXCEPTION_TEMPLATE_HEADER.message + EXCEPTION_TEMPLATE_INVALID.message),
    INVALID_MANU(EXCEPTION_TEMPLATE_HEADER.message + EXCEPTION_TEMPLATE_INVALID.message),
    IS_NO_MENU(EXCEPTION_TEMPLATE_HEADER.message + EXCEPTION_TEMPLATE_INVALID.message),
    IS_NO_COUNT(EXCEPTION_TEMPLATE_HEADER.message + EXCEPTION_TEMPLATE_INVALID.message),

    MORE_1_AND_LESS_31(EXCEPTION_TEMPLATE_HEADER.message + EXCEPTION_TEMPLATE_DATE.message);


    private String message;

    Exception(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
