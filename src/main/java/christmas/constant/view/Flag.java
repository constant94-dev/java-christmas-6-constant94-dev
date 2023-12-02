package christmas.constant.view;

public enum Flag {
    VISIT_DATE_CONTINUE("continue"),
    VISIT_DATE_BREAK("break"),
    ORDER_MENU_NUMBER_CONTINUE("continue"),
    ORDER_MENU_NUMBER_BREAK("break");

    private String message;

    Flag(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
